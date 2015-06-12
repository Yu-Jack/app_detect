// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;

class ThreadUtils$ThreadPoolRunnableExecutor implements ThreadUtils$RunnableExecutor
{
    private static final int keepAliveTimeSeconds = 30;
    private static final int maxNumberThreads = 3;
    private static final int numberThreads = 1;
    private ExecutorService executorService;
    
    ThreadUtils$ThreadPoolRunnableExecutor() {
        this.executorService = new ThreadPoolExecutor(1, 3, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    }
    
    @Override
    public void execute(final Runnable runnable) {
        this.executorService.submit(runnable);
    }
}
