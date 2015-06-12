// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.util.Log;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import java.util.Iterator;
import java.util.Collection;
import com.google.android.gms.common.GooglePlayServicesClient$OnConnectionFailedListener;
import com.google.android.gms.common.ConnectionResult;
import android.os.Looper;
import android.content.Context;
import android.os.Handler;
import java.util.ArrayList;

public final class hc
{
    private final hc$b Gp;
    private final ArrayList Gq;
    final ArrayList Gr;
    private boolean Gs;
    private final ArrayList Gt;
    private final Handler mHandler;
    
    public hc(final Context context, final Looper looper, final hc$b gp) {
        this.Gq = new ArrayList();
        this.Gr = new ArrayList();
        this.Gs = false;
        this.Gt = new ArrayList();
        this.Gp = gp;
        this.mHandler = new hc$a(this, looper);
    }
    
    public void a(final ConnectionResult connectionResult) {
        this.mHandler.removeMessages(1);
        synchronized (this.Gt) {
            for (final GooglePlayServicesClient$OnConnectionFailedListener o : new ArrayList<GooglePlayServicesClient$OnConnectionFailedListener>(this.Gt)) {
                if (!this.Gp.eO()) {
                    return;
                }
                if (!this.Gt.contains(o)) {
                    continue;
                }
                o.onConnectionFailed(connectionResult);
            }
        }
    }
    // monitorexit(list)
    
    public void ao(final int n) {
        this.mHandler.removeMessages(1);
        synchronized (this.Gq) {
            this.Gs = true;
            for (final GoogleApiClient$ConnectionCallbacks o : new ArrayList<GoogleApiClient$ConnectionCallbacks>(this.Gq)) {
                if (!this.Gp.eO()) {
                    break;
                }
                if (!this.Gq.contains(o)) {
                    continue;
                }
                o.onConnectionSuspended(n);
            }
            this.Gs = false;
        }
    }
    
    public void c(final Bundle bundle) {
        boolean b;
        boolean b2;
        Label_0019_Outer:Label_0047_Outer:
        while (true) {
            b = true;
            while (true) {
            Label_0164:
                while (true) {
                    synchronized (this.Gq) {
                        if (!this.Gs) {
                            b2 = b;
                            hm.A(b2);
                            this.mHandler.removeMessages(1);
                            this.Gs = true;
                            if (this.Gr.size() == 0) {
                                hm.A(b);
                                for (final GoogleApiClient$ConnectionCallbacks o : new ArrayList<GoogleApiClient$ConnectionCallbacks>(this.Gq)) {
                                    if (!this.Gp.eO() || !this.Gp.isConnected()) {
                                        break;
                                    }
                                    if (this.Gr.contains(o)) {
                                        continue Label_0019_Outer;
                                    }
                                    o.onConnected(bundle);
                                }
                                this.Gr.clear();
                                this.Gs = false;
                                return;
                            }
                            break Label_0164;
                        }
                    }
                    b2 = false;
                    continue Label_0047_Outer;
                }
                b = false;
                continue;
            }
        }
    }
    
    protected void cp() {
        synchronized (this.Gq) {
            this.c(this.Gp.ef());
        }
    }
    
    public boolean isConnectionCallbacksRegistered(final GoogleApiClient$ConnectionCallbacks o) {
        hm.f(o);
        synchronized (this.Gq) {
            return this.Gq.contains(o);
        }
    }
    
    public boolean isConnectionFailedListenerRegistered(final GooglePlayServicesClient$OnConnectionFailedListener o) {
        hm.f(o);
        synchronized (this.Gt) {
            return this.Gt.contains(o);
        }
    }
    
    public void registerConnectionCallbacks(final GoogleApiClient$ConnectionCallbacks e) {
        hm.f(e);
        synchronized (this.Gq) {
            if (this.Gq.contains(e)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + e + " is already registered");
            }
            else {
                this.Gq.add(e);
            }
            // monitorexit(this.Gq)
            if (this.Gp.isConnected()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1, (Object)e));
            }
        }
    }
    
    public void registerConnectionFailedListener(final GooglePlayServicesClient$OnConnectionFailedListener e) {
        hm.f(e);
        synchronized (this.Gt) {
            if (this.Gt.contains(e)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + e + " is already registered");
            }
            else {
                this.Gt.add(e);
            }
        }
    }
    
    public void unregisterConnectionCallbacks(final GoogleApiClient$ConnectionCallbacks e) {
        hm.f(e);
        synchronized (this.Gq) {
            if (this.Gq != null) {
                if (!this.Gq.remove(e)) {
                    Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + e + " not found");
                }
                else if (this.Gs) {
                    this.Gr.add(e);
                }
            }
        }
    }
    
    public void unregisterConnectionFailedListener(final GooglePlayServicesClient$OnConnectionFailedListener googlePlayServicesClient$OnConnectionFailedListener) {
        hm.f(googlePlayServicesClient$OnConnectionFailedListener);
        synchronized (this.Gt) {
            if (this.Gt != null && !this.Gt.remove(googlePlayServicesClient$OnConnectionFailedListener)) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + googlePlayServicesClient$OnConnectionFailedListener + " not found");
            }
        }
    }
}
