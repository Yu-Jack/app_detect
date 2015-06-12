// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;

final class eg$a
{
    private long rN;
    private long rO;
    
    public eg$a() {
        this.rN = -1L;
        this.rO = -1L;
    }
    
    public long bE() {
        return this.rO;
    }
    
    public void bF() {
        this.rO = SystemClock.elapsedRealtime();
    }
    
    public void bG() {
        this.rN = SystemClock.elapsedRealtime();
    }
    
    public Bundle toBundle() {
        final Bundle bundle = new Bundle();
        bundle.putLong("topen", this.rN);
        bundle.putLong("tclose", this.rO);
        return bundle;
    }
}
