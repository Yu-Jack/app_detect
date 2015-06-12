// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

public final class en
{
    private static final ThreadFactory sh;
    private static final ThreadPoolExecutor si;
    
    static {
        sh = new en$2();
        si = new ThreadPoolExecutor(0, 10, 65L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(true), en.sh);
    }
    
    public static void execute(final Runnable runnable) {
        try {
            en.si.execute(new en$1(runnable));
        }
        catch (RejectedExecutionException ex) {
            eu.c("Too many background threads already running. Aborting task.  Current pool size: " + getPoolSize(), ex);
        }
    }
    
    public static int getPoolSize() {
        return en.si.getPoolSize();
    }
}
