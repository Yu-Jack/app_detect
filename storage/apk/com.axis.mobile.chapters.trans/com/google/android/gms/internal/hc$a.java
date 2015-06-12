// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Collection;
import com.google.android.gms.common.GooglePlayServicesClient$OnConnectionFailedListener;
import com.google.android.gms.common.ConnectionResult;
import android.content.Context;
import java.util.ArrayList;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import android.os.Message;
import android.os.Looper;
import android.os.Handler;

final class hc$a extends Handler
{
    final /* synthetic */ hc Gu;
    
    public hc$a(final hc gu, final Looper looper) {
        this.Gu = gu;
        super(looper);
    }
    
    public void handleMessage(final Message message) {
        if (message.what == 1) {
            synchronized (this.Gu.Gq) {
                if (this.Gu.Gp.eO() && this.Gu.Gp.isConnected() && this.Gu.Gq.contains(message.obj)) {
                    ((GoogleApiClient$ConnectionCallbacks)message.obj).onConnected(this.Gu.Gp.ef());
                }
                return;
            }
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
    }
}
