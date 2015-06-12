// 
// Decompiled by Procyon v0.5.29
// 

package bolts;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class Task<TResult>
{
    public static final ExecutorService BACKGROUND_EXECUTOR;
    private static final Executor IMMEDIATE_EXECUTOR;
    public static final Executor UI_THREAD_EXECUTOR;
    private boolean cancelled;
    private boolean complete;
    private List<Continuation<TResult, Void>> continuations;
    private Exception error;
    private final Object lock;
    private TResult result;
    
    static {
        BACKGROUND_EXECUTOR = Executors.newCachedThreadPool();
        IMMEDIATE_EXECUTOR = new ImmediateExecutor();
        UI_THREAD_EXECUTOR = new UIThreadExecutor();
    }
    
    private Task() {
        this.lock = new Object();
        this.continuations = new ArrayList<Continuation<TResult, Void>>();
    }
    
    public static <TResult> Task<TResult> call(final Callable<TResult> callable) {
        return call(callable, Task.IMMEDIATE_EXECUTOR);
    }
    
    public static <TResult> Task<TResult> call(final Callable<TResult> callable, final Executor executor) {
        final TaskCompletionSource create = create();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    create.setResult(callable.call());
                }
                catch (Exception error) {
                    create.setError(error);
                }
            }
        });
        return (Task<TResult>)create.getTask();
    }
    
    public static <TResult> Task<TResult> callInBackground(final Callable<TResult> callable) {
        return call(callable, Task.BACKGROUND_EXECUTOR);
    }
    
    public static <TResult> Task<TResult> cancelled() {
        final TaskCompletionSource create = create();
        create.setCancelled();
        return (Task<TResult>)create.getTask();
    }
    
    private static <TContinuationResult, TResult> void completeAfterTask(final TaskCompletionSource taskCompletionSource, final Continuation<TResult, Task<TContinuationResult>> continuation, final Task<TResult> task, final Executor executor) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    final Task<Object> task = continuation.then(task);
                    if (task == null) {
                        taskCompletionSource.setResult(null);
                        return;
                    }
                    task.continueWith((Continuation<Object, Object>)new Continuation<TContinuationResult, Void>() {
                        @Override
                        public Void then(final Task<TContinuationResult> task) {
                            if (task.isCancelled()) {
                                taskCompletionSource.setCancelled();
                            }
                            else if (task.isFaulted()) {
                                taskCompletionSource.setError(task.getError());
                            }
                            else {
                                taskCompletionSource.setResult(task.getResult());
                            }
                            return null;
                        }
                    });
                }
                catch (Exception error) {
                    taskCompletionSource.setError(error);
                }
            }
        });
    }
    
    private static <TContinuationResult, TResult> void completeImmediately(final TaskCompletionSource taskCompletionSource, final Continuation<TResult, TContinuationResult> continuation, final Task<TResult> task, final Executor executor) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    taskCompletionSource.setResult(continuation.then(task));
                }
                catch (Exception error) {
                    taskCompletionSource.setError(error);
                }
            }
        });
    }
    
    public static <TResult> TaskCompletionSource create() {
        final Task task = new Task();
        task.getClass();
        return new TaskCompletionSource();
    }
    
    public static <TResult> Task<TResult> forError(final Exception error) {
        final TaskCompletionSource create = create();
        create.setError(error);
        return (Task<TResult>)create.getTask();
    }
    
    public static <TResult> Task<TResult> forResult(final TResult result) {
        final TaskCompletionSource create = create();
        create.setResult(result);
        return (Task<TResult>)create.getTask();
    }
    
    private void runContinuations() {
        final Object lock = this.lock;
        // monitorenter(lock)
        try {
            for (final Continuation<TResult, Void> continuation : this.continuations) {
                try {
                    continuation.then(this);
                }
                catch (RuntimeException ex) {
                    throw ex;
                }
                catch (Exception cause) {
                    throw new RuntimeException(cause);
                }
            }
        }
        finally {}
        this.continuations = null;
    }
    // monitorexit(lock)
    
    public static Task<Void> whenAll(final Collection<? extends Task<?>> collection) {
        if (collection.size() == 0) {
            return forResult((Void)null);
        }
        final TaskCompletionSource create = create();
        final ArrayList list = new ArrayList();
        final Object o = new Object();
        final AtomicInteger atomicInteger = new AtomicInteger(collection.size());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Iterator<? extends Task<?>> iterator = collection.iterator();
        while (iterator.hasNext()) {
            ((Task)iterator.next()).continueWith(new Continuation<Object, Void>() {
                @Override
                public Void then(final Task<Object> task) {
                    Label_0119: {
                        Label_0028: {
                            if (!task.isFaulted()) {
                                break Label_0028;
                            }
                            synchronized (o) {
                                list.add(task.getError());
                                // monitorexit(this.val$errorLock)
                                if (task.isCancelled()) {
                                    atomicBoolean.set(true);
                                }
                                if (atomicInteger.decrementAndGet() == 0) {
                                    if (list.size() == 0) {
                                        break Label_0119;
                                    }
                                    if (list.size() != 1) {
                                        break Label_0028;
                                    }
                                    create.setError(list.get(0));
                                }
                                return null;
                            }
                        }
                        create.setError(new AggregateException(list));
                        return null;
                    }
                    if (atomicBoolean.get()) {
                        create.setCancelled();
                        return null;
                    }
                    create.setResult(null);
                    return null;
                }
            });
        }
        return (Task<Void>)create.getTask();
    }
    
    public <TOut> Task<TOut> cast() {
        return (Task<TOut>)this;
    }
    
    public Task<Void> continueWhile(final Callable<Boolean> callable, final Continuation<Void, Task<Void>> continuation) {
        return this.continueWhile(callable, continuation, Task.IMMEDIATE_EXECUTOR);
    }
    
    public Task<Void> continueWhile(final Callable<Boolean> callable, final Continuation<Void, Task<Void>> continuation, final Executor executor) {
        final Capture<Task$4> capture = new Capture<Task$4>();
        capture.set(new Continuation<Void, Task<Void>>() {
            @Override
            public Task<Void> then(final Task<Void> task) throws Exception {
                if (callable.call()) {
                    return Task.forResult((Object)null).onSuccessTask((Continuation<Object, Task<Object>>)continuation, executor).onSuccessTask(capture.get(), executor);
                }
                return Task.forResult((Void)null);
            }
        });
        return this.makeVoid().continueWithTask((Continuation<Void, Task<Void>>)capture.get(), executor);
    }
    
    public <TContinuationResult> Task<TContinuationResult> continueWith(final Continuation<TResult, TContinuationResult> continuation) {
        return this.continueWith(continuation, Task.IMMEDIATE_EXECUTOR);
    }
    
    public <TContinuationResult> Task<TContinuationResult> continueWith(final Continuation<TResult, TContinuationResult> continuation, final Executor executor) {
        final TaskCompletionSource create = create();
        synchronized (this.lock) {
            final boolean completed = this.isCompleted();
            if (!completed) {
                this.continuations.add(new Continuation<TResult, Void>() {
                    @Override
                    public Void then(final Task<TResult> task) {
                        completeImmediately(create, (Continuation<Object, Object>)continuation, task, executor);
                        return null;
                    }
                });
            }
            // monitorexit(this.lock)
            if (completed) {
                completeImmediately(create, continuation, this, executor);
            }
            return (Task<TContinuationResult>)create.getTask();
        }
    }
    
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(final Continuation<TResult, Task<TContinuationResult>> continuation) {
        return this.continueWithTask(continuation, Task.IMMEDIATE_EXECUTOR);
    }
    
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(final Continuation<TResult, Task<TContinuationResult>> continuation, final Executor executor) {
        final TaskCompletionSource create = create();
        synchronized (this.lock) {
            final boolean completed = this.isCompleted();
            if (!completed) {
                this.continuations.add(new Continuation<TResult, Void>() {
                    @Override
                    public Void then(final Task<TResult> task) {
                        completeAfterTask(create, (Continuation<Object, Task<Object>>)continuation, task, executor);
                        return null;
                    }
                });
            }
            // monitorexit(this.lock)
            if (completed) {
                completeAfterTask(create, continuation, this, executor);
            }
            return (Task<TContinuationResult>)create.getTask();
        }
    }
    
    public Exception getError() {
        synchronized (this.lock) {
            return this.error;
        }
    }
    
    public TResult getResult() {
        synchronized (this.lock) {
            return this.result;
        }
    }
    
    public boolean isCancelled() {
        synchronized (this.lock) {
            return this.cancelled;
        }
    }
    
    public boolean isCompleted() {
        synchronized (this.lock) {
            return this.complete;
        }
    }
    
    public boolean isFaulted() {
        while (true) {
            synchronized (this.lock) {
                if (this.error != null) {
                    return true;
                }
            }
            return false;
        }
    }
    
    public Task<Void> makeVoid() {
        return this.continueWithTask((Continuation<TResult, Task<Void>>)new Continuation<TResult, Task<Void>>() {
            @Override
            public Task<Void> then(final Task<TResult> task) throws Exception {
                if (task.isCancelled()) {
                    return Task.cancelled();
                }
                if (task.isFaulted()) {
                    return Task.forError(task.getError());
                }
                return Task.forResult((Void)null);
            }
        });
    }
    
    public <TContinuationResult> Task<TContinuationResult> onSuccess(final Continuation<TResult, TContinuationResult> continuation) {
        return this.onSuccess(continuation, Task.IMMEDIATE_EXECUTOR);
    }
    
    public <TContinuationResult> Task<TContinuationResult> onSuccess(final Continuation<TResult, TContinuationResult> continuation, final Executor executor) {
        return (Task<TContinuationResult>)this.continueWithTask((Continuation<TResult, Task<Object>>)new Continuation<TResult, Task<TContinuationResult>>() {
            @Override
            public Task<TContinuationResult> then(final Task<TResult> task) {
                if (task.isFaulted()) {
                    return Task.forError(task.getError());
                }
                if (task.isCancelled()) {
                    return Task.cancelled();
                }
                return task.continueWith(continuation);
            }
        }, executor);
    }
    
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(final Continuation<TResult, Task<TContinuationResult>> continuation) {
        return this.onSuccessTask(continuation, Task.IMMEDIATE_EXECUTOR);
    }
    
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(final Continuation<TResult, Task<TContinuationResult>> continuation, final Executor executor) {
        return (Task<TContinuationResult>)this.continueWithTask((Continuation<TResult, Task<Object>>)new Continuation<TResult, Task<TContinuationResult>>() {
            @Override
            public Task<TContinuationResult> then(final Task<TResult> task) {
                if (task.isFaulted()) {
                    return Task.forError(task.getError());
                }
                if (task.isCancelled()) {
                    return Task.cancelled();
                }
                return task.continueWithTask(continuation);
            }
        }, executor);
    }
    
    public void waitForCompletion() throws InterruptedException {
        synchronized (this.lock) {
            if (!this.isCompleted()) {
                this.lock.wait();
            }
        }
    }
    
    private static class ImmediateExecutor implements Executor
    {
        private static final int MAX_DEPTH = 15;
        private ThreadLocal<Integer> executionDepth;
        
        private ImmediateExecutor() {
            this.executionDepth = new ThreadLocal<Integer>();
        }
        
        private int decrementDepth() {
            Integer value = this.executionDepth.get();
            if (value == null) {
                value = 0;
            }
            final int i = -1 + value;
            if (i == 0) {
                this.executionDepth.remove();
                return i;
            }
            this.executionDepth.set(i);
            return i;
        }
        
        private int incrementDepth() {
            Integer value = this.executionDepth.get();
            if (value == null) {
                value = 0;
            }
            final int i = 1 + value;
            this.executionDepth.set(i);
            return i;
        }
        
        @Override
        public void execute(final Runnable runnable) {
            Label_0021: {
                if (this.incrementDepth() > 15) {
                    break Label_0021;
                }
                try {
                    runnable.run();
                    return;
                    Task.BACKGROUND_EXECUTOR.execute(runnable);
                }
                finally {
                    this.decrementDepth();
                }
            }
        }
    }
    
    public class TaskCompletionSource
    {
        public Task<TResult> getTask() {
            return Task.this;
        }
        
        public void setCancelled() {
            if (!this.trySetCancelled()) {
                throw new IllegalStateException("Cannot cancel a completed task.");
            }
        }
        
        public void setError(final Exception ex) {
            if (!this.trySetError(ex)) {
                throw new IllegalStateException("Cannot set the error on a completed task.");
            }
        }
        
        public void setResult(final TResult tResult) {
            if (!this.trySetResult(tResult)) {
                throw new IllegalStateException("Cannot set the result of a completed task.");
            }
        }
        
        public boolean trySetCancelled() {
            synchronized (Task.this.lock) {
                if (Task.this.complete) {
                    return false;
                }
                Task.this.complete = true;
                Task.this.cancelled = true;
                Task.this.lock.notifyAll();
                Task.this.runContinuations();
                return true;
            }
        }
        
        public boolean trySetError(final Exception ex) {
            synchronized (Task.this.lock) {
                if (Task.this.complete) {
                    return false;
                }
                Task.this.complete = true;
                Task.this.error = ex;
                Task.this.lock.notifyAll();
                Task.this.runContinuations();
                return true;
            }
        }
        
        public boolean trySetResult(final TResult tResult) {
            synchronized (Task.this.lock) {
                if (Task.this.complete) {
                    return false;
                }
                Task.this.complete = true;
                Task.this.result = tResult;
                Task.this.lock.notifyAll();
                Task.this.runContinuations();
                return true;
            }
        }
    }
    
    private static class UIThreadExecutor implements Executor
    {
        @Override
        public void execute(final Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}
