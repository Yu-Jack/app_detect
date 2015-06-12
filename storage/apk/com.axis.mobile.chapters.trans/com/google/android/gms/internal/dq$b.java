// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import android.os.Bundle;
import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesClient$OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesClient$ConnectionCallbacks;

public final class dq$b extends dq implements GooglePlayServicesClient$ConnectionCallbacks, GooglePlayServicesClient$OnConnectionFailedListener
{
    private final Object ls;
    private final dp$a pT;
    private final dr pU;
    
    public dq$b(final Context context, final ds ds, final dp$a pt) {
        super(ds, pt);
        this.ls = new Object();
        this.pT = pt;
        (this.pU = new dr(context, this, this, ds.kQ.sy)).connect();
    }
    
    @Override
    public void bs() {
        synchronized (this.ls) {
            if (this.pU.isConnected() || this.pU.isConnecting()) {
                this.pU.disconnect();
            }
        }
    }
    
    @Override
    public dw bt() {
        synchronized (this.ls) {
            try {
                return this.pU.bw();
            }
            catch (IllegalStateException ex) {
                return null;
            }
        }
    }
    
    @Override
    public void onConnected(final Bundle bundle) {
        this.start();
    }
    
    @Override
    public void onConnectionFailed(final ConnectionResult connectionResult) {
        this.pT.a(new du(0));
    }
    
    @Override
    public void onDisconnected() {
        eu.z("Disconnected from remote ad request service.");
    }
}
