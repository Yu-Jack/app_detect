// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

public final class dz
{
    private ex lN;
    private final Object ls;
    private int pJ;
    private String qB;
    private eb qC;
    public final bc qD;
    public final bc qE;
    
    public dz(final String qb) {
        this.ls = new Object();
        this.pJ = -2;
        this.qD = new dz$1(this);
        this.qE = new dz$2(this);
        this.qB = qb;
    }
    
    public void b(final ex ln) {
        synchronized (this.ls) {
            this.lN = ln;
        }
    }
    
    public eb bx() {
        synchronized (this.ls) {
            while (this.qC == null && this.pJ == -2) {
                try {
                    this.ls.wait();
                    continue;
                }
                catch (InterruptedException ex) {
                    eu.D("Ad request service was interrupted.");
                    return null;
                }
                break;
            }
            return this.qC;
        }
    }
    
    public int getErrorCode() {
        synchronized (this.ls) {
            return this.pJ;
        }
    }
}
