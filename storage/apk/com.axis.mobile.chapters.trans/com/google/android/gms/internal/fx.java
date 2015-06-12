// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import android.os.Looper;
import android.content.Context;

public class fx extends hb
{
    public fx(final Context context, final Looper looper, final GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks, final GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        super(context, looper, googleApiClient$ConnectionCallbacks, googleApiClient$OnConnectionFailedListener, new String[0]);
    }
    
    protected fu C(final IBinder binder) {
        return fu$a.A(binder);
    }
    
    @Override
    protected void a(final hi hi, final hb$e hb$e) {
        hi.b(hb$e, 5089000, this.getContext().getPackageName());
    }
    
    @Override
    protected String bu() {
        return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
    }
    
    @Override
    protected String bv() {
        return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
    }
    
    public fu dR() {
        return (fu)this.ft();
    }
}
