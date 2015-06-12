// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.IBinder;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesClient$OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesClient$ConnectionCallbacks;
import android.content.Context;

public class dr extends hb
{
    final int pV;
    
    public dr(final Context context, final GooglePlayServicesClient$ConnectionCallbacks googlePlayServicesClient$ConnectionCallbacks, final GooglePlayServicesClient$OnConnectionFailedListener googlePlayServicesClient$OnConnectionFailedListener, final int pv) {
        super(context, googlePlayServicesClient$ConnectionCallbacks, googlePlayServicesClient$OnConnectionFailedListener, new String[0]);
        this.pV = pv;
    }
    
    @Override
    protected void a(final hi hi, final hb$e hb$e) {
        hi.g(hb$e, this.pV, this.getContext().getPackageName(), new Bundle());
    }
    
    @Override
    protected String bu() {
        return "com.google.android.gms.ads.service.START";
    }
    
    @Override
    protected String bv() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }
    
    public dw bw() {
        return (dw)super.ft();
    }
    
    protected dw w(final IBinder binder) {
        return dw$a.y(binder);
    }
}
