// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.util.Log;

public final class hf
{
    private final String GI;
    
    public hf(final String s) {
        this.GI = (String)hm.f(s);
    }
    
    public void a(final String s, final String s2, final Throwable t) {
        if (this.ap(4)) {
            Log.i(s, s2, t);
        }
    }
    
    public boolean ap(final int n) {
        return Log.isLoggable(this.GI, n);
    }
    
    public void b(final String s, final String s2, final Throwable t) {
        if (this.ap(6)) {
            Log.e(s, s2, t);
        }
    }
    
    public void i(final String s, final String s2) {
        if (this.ap(2)) {
            Log.v(s, s2);
        }
    }
    
    public void j(final String s, final String s2) {
        if (this.ap(5)) {
            Log.w(s, s2);
        }
    }
    
    public void k(final String s, final String s2) {
        if (this.ap(6)) {
            Log.e(s, s2);
        }
    }
}
