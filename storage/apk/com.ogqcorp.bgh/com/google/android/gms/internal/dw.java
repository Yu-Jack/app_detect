// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;

final class dw
{
    private long a;
    private long b;
    
    public dw() {
        this.a = -1L;
        this.b = -1L;
    }
    
    public long a() {
        return this.b;
    }
    
    public void b() {
        this.b = SystemClock.elapsedRealtime();
    }
    
    public void c() {
        this.a = SystemClock.elapsedRealtime();
    }
    
    public Bundle d() {
        final Bundle bundle = new Bundle();
        bundle.putLong("topen", this.a);
        bundle.putLong("tclose", this.b);
        return bundle;
    }
}
