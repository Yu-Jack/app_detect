// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.AsyncTask;

public class ThreadUtils
{
    private static ThreadUtils$RunnableExecutor runnableExecutor;
    
    static {
        ThreadUtils.runnableExecutor = new ThreadUtils$ThreadPoolRunnableExecutor();
    }
    
    public static final void executeAsyncTask(final AsyncTask asyncTask, final Object... array) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AndroidTargetUtils.executeAsyncTask(asyncTask, array);
            return;
        }
        new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
            @Override
            public final void run() {
                AndroidTargetUtils.executeAsyncTask(asyncTask, array);
            }
        });
    }
    
    public static void executeRunnable(final Runnable runnable) {
        ThreadUtils.runnableExecutor.execute(runnable);
    }
    
    public static boolean isOnMainThread() {
        return ThreadUtils$ThreadVerify.getInstance().isOnMainThread();
    }
    
    static void setRunnableExecutor(final ThreadUtils$RunnableExecutor runnableExecutor) {
        ThreadUtils.runnableExecutor = runnableExecutor;
    }
}
