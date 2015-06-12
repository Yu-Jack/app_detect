import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Executor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;

// 
// Decompiled by Procyon v0.5.29
// 

abstract class ah
{
    private static final ThreadFactory a;
    private static final BlockingQueue b;
    private static final an c;
    public static final Executor d;
    private static volatile Executor e;
    private final ap f;
    private final FutureTask g;
    private volatile ao h;
    private final AtomicBoolean i;
    
    static {
        a = new ai();
        b = new LinkedBlockingQueue(10);
        d = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, ah.b, ah.a);
        c = new an((byte)0);
        ah.e = ah.d;
    }
    
    public ah() {
        this.h = ao.a;
        this.i = new AtomicBoolean();
        this.f = new aj(this);
        this.g = new ak(this, this.f);
    }
    
    private Object b(final Object o) {
        ah.c.obtainMessage(1, (Object)new am(this, new Object[] { o })).sendToTarget();
        return o;
    }
    
    protected static void c() {
    }
    
    public final ah a(final Executor executor) {
        if (this.h != ao.a) {
            switch (al.a[this.h.ordinal()]) {
                case 1: {
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                }
                case 2: {
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                }
            }
        }
        this.h = ao.b;
        this.f.b = null;
        executor.execute(this.g);
        return this;
    }
    
    protected void a() {
    }
    
    protected void a(final Object o) {
    }
    
    protected abstract Object b();
    
    public final boolean d() {
        return this.g.cancel(false);
    }
}
