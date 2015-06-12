// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Map;

class dz$1 implements bc
{
    final /* synthetic */ dz qF;
    
    dz$1(final dz qf) {
        this.qF = qf;
    }
    
    @Override
    public void b(final ex ex, final Map map) {
        synchronized (this.qF.ls) {
            final eb eb = new eb(map);
            eu.D("Invalid " + eb.getType() + " request error: " + eb.by());
            this.qF.pJ = 1;
            this.qF.ls.notify();
        }
    }
}
