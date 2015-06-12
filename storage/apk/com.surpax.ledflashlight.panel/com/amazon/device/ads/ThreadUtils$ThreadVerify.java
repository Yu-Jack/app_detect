// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.os.Looper;

class ThreadUtils$ThreadVerify
{
    private static ThreadUtils$ThreadVerify instance;
    
    static {
        ThreadUtils$ThreadVerify.instance = new ThreadUtils$ThreadVerify();
    }
    
    static ThreadUtils$ThreadVerify getInstance() {
        return ThreadUtils$ThreadVerify.instance;
    }
    
    static void setInstance(final ThreadUtils$ThreadVerify instance) {
        ThreadUtils$ThreadVerify.instance = instance;
    }
    
    boolean isOnMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
