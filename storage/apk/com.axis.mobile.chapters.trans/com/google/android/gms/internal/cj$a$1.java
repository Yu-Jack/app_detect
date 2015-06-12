// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

class cj$a$1 implements Runnable
{
    private final WeakReference oO;
    final /* synthetic */ cj oP;
    final /* synthetic */ cj$a oQ;
    
    cj$a$1(final cj$a oq, final cj op) {
        this.oQ = oq;
        this.oP = op;
        this.oO = new WeakReference((T)this.oP);
    }
    
    @Override
    public void run() {
        final cj cj = (cj)this.oO.get();
        if (!this.oQ.oN && cj != null) {
            cj.bb();
            this.oQ.bc();
        }
    }
}
