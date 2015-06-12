// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.GooglePlayServicesUtil;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesClient$OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import android.os.Handler;
import android.content.Context;
import java.util.ArrayList;
import android.os.Looper;
import com.google.android.gms.common.api.Api$a;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import android.os.IInterface;
import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Bundle;

public final class hb$h extends hb$b
{
    final /* synthetic */ hb Gi;
    public final Bundle Gn;
    public final IBinder Go;
    public final int statusCode;
    
    public hb$h(final hb gi, final int statusCode, final IBinder go, final Bundle gn) {
        this.Gi = gi;
        super(gi, true);
        this.statusCode = statusCode;
        this.Go = go;
        this.Gn = gn;
    }
    
    protected void b(final Boolean b) {
        if (b == null) {
            this.Gi.am(1);
            return;
        }
        switch (this.statusCode) {
            default: {
                PendingIntent pendingIntent;
                if (this.Gn != null) {
                    pendingIntent = (PendingIntent)this.Gn.getParcelable("pendingIntent");
                }
                else {
                    pendingIntent = null;
                }
                if (this.Gi.Gd != null) {
                    hd.E(this.Gi.mContext).b(this.Gi.bu(), this.Gi.Gd);
                    this.Gi.Gd = null;
                }
                this.Gi.am(1);
                this.Gi.Gb = null;
                this.Gi.DS.a(new ConnectionResult(this.statusCode, pendingIntent));
            }
            case 0: {
                try {
                    if (this.Gi.bv().equals(this.Go.getInterfaceDescriptor())) {
                        this.Gi.Gb = this.Gi.x(this.Go);
                        if (this.Gi.Gb != null) {
                            this.Gi.am(3);
                            this.Gi.DS.cp();
                            return;
                        }
                    }
                }
                catch (RemoteException ex) {}
                hd.E(this.Gi.mContext).b(this.Gi.bu(), this.Gi.Gd);
                this.Gi.Gd = null;
                this.Gi.am(1);
                this.Gi.Gb = null;
                this.Gi.DS.a(new ConnectionResult(8, null));
            }
            case 10: {
                this.Gi.am(1);
                throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            }
        }
    }
    
    @Override
    protected void fu() {
    }
}
