// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

final class cj$a
{
    private final Runnable lg;
    private volatile boolean oN;
    
    public cj$a(final cj cj) {
        this.oN = false;
        this.lg = new cj$a$1(this, cj);
    }
    
    public void bc() {
        et.sv.postDelayed(this.lg, 250L);
    }
    
    public void cancel() {
        this.oN = true;
        et.sv.removeCallbacks(this.lg);
    }
}
