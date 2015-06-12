// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;

public final class hb$c implements GoogleApiClient$ConnectionCallbacks
{
    private final GooglePlayServicesClient$ConnectionCallbacks Gk;
    
    public hb$c(final GooglePlayServicesClient$ConnectionCallbacks gk) {
        this.Gk = gk;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof hb$c) {
            return this.Gk.equals(((hb$c)obj).Gk);
        }
        return this.Gk.equals(obj);
    }
    
    @Override
    public void onConnected(final Bundle bundle) {
        this.Gk.onConnected(bundle);
    }
    
    @Override
    public void onConnectionSuspended(final int n) {
        this.Gk.onDisconnected();
    }
}
