// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Process;

final class en$1 implements Runnable
{
    final /* synthetic */ Runnable sj;
    
    en$1(final Runnable sj) {
        this.sj = sj;
    }
    
    @Override
    public void run() {
        Process.setThreadPriority(10);
        this.sj.run();
    }
}
