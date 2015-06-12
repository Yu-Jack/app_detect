// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.content.ComponentName;
import android.content.Intent;
import android.content.Context;
import android.content.ServiceConnection;

public final class cw extends df$a implements ServiceConnection
{
    private Context mContext;
    private cr oY;
    private String pf;
    private cv pj;
    private boolean po;
    private int pp;
    private Intent pq;
    
    public cw(final Context mContext, final String pf, final boolean po, final int pp, final Intent pq, final cv pj) {
        this.po = false;
        this.pf = pf;
        this.pp = pp;
        this.pq = pq;
        this.po = po;
        this.mContext = mContext;
        this.pj = pj;
    }
    
    public void finishPurchase() {
        final int c = cy.c(this.pq);
        if (this.pp != -1 || c != 0) {
            return;
        }
        this.oY = new cr(this.mContext);
        final Context mContext = this.mContext;
        final Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        final Context mContext2 = this.mContext;
        mContext.bindService(intent, (ServiceConnection)this, 1);
    }
    
    public String getProductId() {
        return this.pf;
    }
    
    public Intent getPurchaseData() {
        return this.pq;
    }
    
    public int getResultCode() {
        return this.pp;
    }
    
    public boolean isVerified() {
        return this.po;
    }
    
    public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        eu.B("In-app billing service connected.");
        this.oY.o(binder);
        final String q = cy.q(cy.d(this.pq));
        if (q == null) {
            return;
        }
        if (this.oY.a(this.mContext.getPackageName(), q) == 0) {
            cx.k(this.mContext).a(this.pj);
        }
        this.mContext.unbindService((ServiceConnection)this);
        this.oY.destroy();
    }
    
    public void onServiceDisconnected(final ComponentName componentName) {
        eu.B("In-app billing service disconnected.");
        this.oY.destroy();
    }
}
