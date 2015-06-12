// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.RemoteException;

public abstract class dq extends em
{
    private final ds ne;
    private final dp$a pT;
    
    public dq(final ds ne, final dp$a pt) {
        this.ne = ne;
        this.pT = pt;
    }
    
    private static du a(final dw dw, final ds ds) {
        try {
            return dw.b(ds);
        }
        catch (RemoteException ex) {
            eu.c("Could not fetch ad response from ad request service.", (Throwable)ex);
            return null;
        }
        catch (NullPointerException ex2) {
            eu.c("Could not fetch ad response from ad request service due to an Exception.", ex2);
            return null;
        }
        catch (SecurityException ex3) {
            eu.c("Could not fetch ad response from ad request service due to an Exception.", ex3);
            return null;
        }
    }
    
    @Override
    public final void bh() {
        try {
            final dw bt = this.bt();
            du a;
            if (bt == null) {
                a = new du(0);
            }
            else {
                a = a(bt, this.ne);
                if (a == null) {
                    a = new du(0);
                }
            }
            this.bs();
            this.pT.a(a);
        }
        finally {
            this.bs();
        }
    }
    
    public abstract void bs();
    
    public abstract dw bt();
    
    @Override
    public final void onStop() {
        this.bs();
    }
}
