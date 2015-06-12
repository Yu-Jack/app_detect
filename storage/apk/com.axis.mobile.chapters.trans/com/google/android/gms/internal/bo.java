// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

public final class bo extends bv$a
{
    private final Object ls;
    private bq$a nA;
    private bn nB;
    
    public bo() {
        this.ls = new Object();
    }
    
    public void a(final bn nb) {
        synchronized (this.ls) {
            this.nB = nb;
        }
    }
    
    public void a(final bq$a na) {
        synchronized (this.ls) {
            this.nA = na;
        }
    }
    
    public void onAdClicked() {
        synchronized (this.ls) {
            if (this.nB != null) {
                this.nB.ab();
            }
        }
    }
    
    public void onAdClosed() {
        synchronized (this.ls) {
            if (this.nB != null) {
                this.nB.ac();
            }
        }
    }
    
    public void onAdFailedToLoad(final int n) {
        while (true) {
            while (true) {
                Label_0046: {
                    synchronized (this.ls) {
                        if (this.nA != null) {
                            if (n != 3) {
                                break Label_0046;
                            }
                            final int n2 = 1;
                            this.nA.g(n2);
                            this.nA = null;
                        }
                        return;
                    }
                }
                final int n2 = 2;
                continue;
            }
        }
    }
    
    public void onAdLeftApplication() {
        synchronized (this.ls) {
            if (this.nB != null) {
                this.nB.ad();
            }
        }
    }
    
    public void onAdLoaded() {
        synchronized (this.ls) {
            if (this.nA != null) {
                this.nA.g(0);
                this.nA = null;
                return;
            }
            if (this.nB != null) {
                this.nB.af();
            }
        }
    }
    
    public void onAdOpened() {
        synchronized (this.ls) {
            if (this.nB != null) {
                this.nB.ae();
            }
        }
    }
}
