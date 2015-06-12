// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;

public final class hb$g implements GoogleApiClient$OnConnectionFailedListener
{
    private final GooglePlayServicesClient$OnConnectionFailedListener Gm;
    
    public hb$g(final GooglePlayServicesClient$OnConnectionFailedListener gm) {
        this.Gm = gm;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof hb$g) {
            return this.Gm.equals(((hb$g)obj).Gm);
        }
        return this.Gm.equals(obj);
    }
    
    @Override
    public void onConnectionFailed(final ConnectionResult connectionResult) {
        this.Gm.onConnectionFailed(connectionResult);
    }
}
