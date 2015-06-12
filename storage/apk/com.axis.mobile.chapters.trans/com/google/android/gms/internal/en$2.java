// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ThreadFactory;

final class en$2 implements ThreadFactory
{
    private final AtomicInteger sk;
    
    en$2() {
        this.sk = new AtomicInteger(1);
    }
    
    @Override
    public Thread newThread(final Runnable target) {
        return new Thread(target, "AdWorker #" + this.sk.getAndIncrement());
    }
}
