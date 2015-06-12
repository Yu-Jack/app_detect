// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.util.SparseArray;

abstract class StartUpWaiter implements Configuration$ConfigurationListener, Settings$SettingsListener
{
    static final int CALLBACK_ON_MAIN_THREAD = 0;
    static final int DEFAULT = 1;
    private static final SparseArray executors;
    private int callbackType;
    
    static {
        executors = new SparseArray();
        putRunnableExecutor(0, new ThreadUtils$MainThreadRunnableExecutor());
        putRunnableExecutor(1, new ThreadUtils$ThreadPoolRunnableExecutor());
    }
    
    StartUpWaiter() {
        this.callbackType = 1;
    }
    
    private static ThreadUtils$RunnableExecutor getExecutor(final int n) {
        return (ThreadUtils$RunnableExecutor)StartUpWaiter.executors.get(n, StartUpWaiter.executors.get(1));
    }
    
    private void onFinished(final Runnable runnable) {
        getExecutor(this.callbackType).execute(runnable);
    }
    
    static void putRunnableExecutor(final int n, final ThreadUtils$RunnableExecutor threadUtils$RunnableExecutor) {
        if (threadUtils$RunnableExecutor == null) {
            StartUpWaiter.executors.remove(n);
            return;
        }
        StartUpWaiter.executors.put(n, (Object)threadUtils$RunnableExecutor);
    }
    
    @Override
    public void onConfigurationFailure() {
        this.onFinished(new Runnable() {
            @Override
            public void run() {
                StartUpWaiter.this.startUpFailed();
            }
        });
    }
    
    @Override
    public void onConfigurationReady() {
        this.onFinished(new Runnable() {
            @Override
            public void run() {
                StartUpWaiter.this.startUpReady();
            }
        });
    }
    
    @Override
    public void settingsLoaded() {
        Configuration.getInstance().queueConfigurationListener(this);
    }
    
    public void start() {
        Settings.getInstance().listenForSettings(this);
    }
    
    public void startAndCallbackOnMainThread() {
        this.callbackType = 0;
        this.start();
    }
    
    protected abstract void startUpFailed();
    
    protected abstract void startUpReady();
}
