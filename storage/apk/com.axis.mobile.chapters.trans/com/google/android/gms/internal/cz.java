// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.Intent;

public class cz
{
    private final String mz;
    
    public cz(final String mz) {
        this.mz = mz;
    }
    
    public boolean a(final String s, final int n, final Intent intent) {
        if (s != null && intent != null) {
            final String d = cy.d(intent);
            final String e = cy.e(intent);
            if (d != null && e != null) {
                if (!s.equals(cy.p(d))) {
                    eu.D("Developer payload not match.");
                    return false;
                }
                if (this.mz != null && !da.b(this.mz, d, e)) {
                    eu.D("Fail to verify signature.");
                    return false;
                }
                return true;
            }
        }
        return false;
    }
    
    public String bm() {
        return eo.bT();
    }
}
