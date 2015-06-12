// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Bundle;

public class ek
{
    private final Object ls;
    private final eh rD;
    private final String rG;
    private int sc;
    private int sd;
    
    ek(final eh rd, final String rg) {
        this.ls = new Object();
        this.rD = rd;
        this.rG = rg;
    }
    
    public ek(final String s) {
        this(eh.bH(), s);
    }
    
    public void a(final int sc, final int sd) {
        synchronized (this.ls) {
            this.sc = sc;
            this.sd = sd;
            this.rD.a(this.rG, this);
        }
    }
    
    public Bundle toBundle() {
        synchronized (this.ls) {
            final Bundle bundle = new Bundle();
            bundle.putInt("pmnli", this.sc);
            bundle.putInt("pmnll", this.sd);
            return bundle;
        }
    }
}
