// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Handler;

public class ln
{
    private final Handler a;
    
    public ln(final Handler a) {
        this.a = a;
    }
    
    public void a(final Runnable runnable) {
        this.a.removeCallbacks(runnable);
    }
    
    public boolean a(final Runnable runnable, final long n) {
        return this.a.postDelayed(runnable, n);
    }
}
