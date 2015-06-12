// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.Cast$MessageReceivedCallback;
import android.os.IBinder;
import java.util.HashMap;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import android.os.Looper;
import android.content.Context;
import android.os.Handler;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Map;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.Cast$Listener;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.api.a$d;
import com.google.android.gms.common.api.Status;

class gh$1 extends gm$a
{
    final /* synthetic */ gh Cc;
    
    gh$1(final gh cc) {
        this.Cc = cc;
    }
    
    private boolean X(final int n) {
        synchronized (gh.Cb) {
            if (this.Cc.BZ != null) {
                this.Cc.BZ.a(new Status(n));
                this.Cc.BZ = null;
                return true;
            }
            return false;
        }
    }
    
    private void b(final long l, final int n) {
        synchronized (this.Cc.BW) {
            final a$d a$d = this.Cc.BW.remove(l);
            // monitorexit(gh.h(this.Cc))
            if (a$d != null) {
                a$d.a(new Status(n));
            }
        }
    }
    
    public void T(final int i) {
        gh.BG.b("ICastDeviceControllerListener.onDisconnected: %d", i);
        this.Cc.BP = false;
        this.Cc.BQ.set(false);
        this.Cc.BH = null;
        if (i != 0) {
            this.Cc.an(2);
        }
    }
    
    public void U(final int n) {
        synchronized (gh.Ca) {
            if (this.Cc.BY != null) {
                this.Cc.BY.a(new gh$a(new Status(n)));
                this.Cc.BY = null;
            }
        }
    }
    
    public void V(final int n) {
        this.X(n);
    }
    
    public void W(final int n) {
        this.X(n);
    }
    
    public void a(final ApplicationMetadata applicationMetadata, final String s, final String s2, final boolean b) {
        this.Cc.BH = applicationMetadata;
        this.Cc.BT = applicationMetadata.getApplicationId();
        this.Cc.BU = s2;
        synchronized (gh.Ca) {
            if (this.Cc.BY != null) {
                this.Cc.BY.a(new gh$a(new Status(0), applicationMetadata, s, s2, b));
                this.Cc.BY = null;
            }
        }
    }
    
    public void a(final String s, final double n, final boolean b) {
        gh.BG.b("Deprecated callback: \"onStatusreceived\"", new Object[0]);
    }
    
    public void a(final String s, final long n) {
        this.b(n, 0);
    }
    
    public void a(final String s, final long n, final int n2) {
        this.b(n, n2);
    }
    
    public void b(final ge ge) {
        gh.BG.b("onApplicationStatusChanged", new Object[0]);
        this.Cc.mHandler.post((Runnable)new gh$1$3(this, ge));
    }
    
    public void b(final gj gj) {
        gh.BG.b("onDeviceStatusChanged", new Object[0]);
        this.Cc.mHandler.post((Runnable)new gh$1$2(this, gj));
    }
    
    public void b(final String s, final byte[] array) {
        gh.BG.b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", s, array.length);
    }
    
    public void g(final String s, final String s2) {
        gh.BG.b("Receive (type=text, ns=%s) %s", s, s2);
        this.Cc.mHandler.post((Runnable)new gh$1$4(this, s, s2));
    }
    
    public void onApplicationDisconnected(final int n) {
        this.Cc.BT = null;
        this.Cc.BU = null;
        this.X(n);
        if (this.Cc.Ae != null) {
            this.Cc.mHandler.post((Runnable)new gh$1$1(this, n));
        }
    }
}
