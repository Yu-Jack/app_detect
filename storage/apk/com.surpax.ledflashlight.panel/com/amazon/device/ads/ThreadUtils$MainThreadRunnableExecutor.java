// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.os.Handler;
import android.os.Looper;

class ThreadUtils$MainThreadRunnableExecutor implements ThreadUtils$RunnableExecutor
{
    @Override
    public void execute(final Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }
}
