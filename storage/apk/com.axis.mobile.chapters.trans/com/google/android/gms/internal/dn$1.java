// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

class dn$1 implements Runnable
{
    final /* synthetic */ dn pG;
    
    dn$1(final dn pg) {
        this.pG = pg;
    }
    
    @Override
    public void run() {
        this.pG.onStop();
    }
}
