// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.concurrent.RejectedExecutionException;
import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

public final class ee
{
    private static final ThreadFactory a;
    private static final ThreadPoolExecutor b;
    
    static {
        a = new ThreadFactory() {
            private final AtomicInteger a = new AtomicInteger(1);
            
            @Override
            public Thread newThread(final Runnable target) {
                return new Thread(target, "AdWorker #" + this.a.getAndIncrement());
            }
        };
        b = new ThreadPoolExecutor(0, 10, 65L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(true), ee.a);
    }
    
    public static int a() {
        return ee.b.getPoolSize();
    }
    
    public static void a(final Runnable runnable) {
        try {
            ee.b.execute(new Runnable() {
                @Override
                public void run() {
                    Process.setThreadPriority(10);
                    runnable.run();
                }
            });
        }
        catch (RejectedExecutionException ex) {
            en.c("Too many background threads already running. Aborting task.  Current pool size: " + a(), ex);
        }
    }
}
