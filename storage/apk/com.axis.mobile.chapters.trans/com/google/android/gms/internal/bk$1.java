// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.RemoteException;

class bk$1 implements Runnable
{
    final /* synthetic */ bq ni;
    final /* synthetic */ bk nj;
    
    bk$1(final bk nj, final bq ni) {
        this.nj = nj;
        this.ni = ni;
    }
    
    @Override
    public void run() {
        try {
            this.ni.nN.destroy();
        }
        catch (RemoteException ex) {
            eu.c("Could not destroy mediation adapter.", (Throwable)ex);
        }
    }
}
