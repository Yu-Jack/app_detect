// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.GooglePlayServicesUtil;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesClient$OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import android.content.Context;
import java.util.ArrayList;
import com.google.android.gms.common.api.Api$a;
import android.util.Log;
import android.os.IInterface;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import android.os.Message;
import android.os.Looper;
import android.os.Handler;

final class hb$a extends Handler
{
    final /* synthetic */ hb Gi;
    
    public hb$a(final hb gi, final Looper looper) {
        this.Gi = gi;
        super(looper);
    }
    
    public void handleMessage(final Message message) {
        if (message.what == 1 && !this.Gi.isConnecting()) {
            final hb$b hb$b = (hb$b)message.obj;
            hb$b.fu();
            hb$b.unregister();
            return;
        }
        if (message.what == 3) {
            this.Gi.DS.a(new ConnectionResult((int)message.obj, null));
            return;
        }
        if (message.what == 4) {
            this.Gi.am(1);
            this.Gi.Gb = null;
            this.Gi.DS.ao((int)message.obj);
            return;
        }
        if (message.what == 2 && !this.Gi.isConnected()) {
            final hb$b hb$b2 = (hb$b)message.obj;
            hb$b2.fu();
            hb$b2.unregister();
            return;
        }
        if (message.what == 2 || message.what == 1) {
            ((hb$b)message.obj).fv();
            return;
        }
        Log.wtf("GmsClient", "Don't know how to handle this message.");
    }
}
