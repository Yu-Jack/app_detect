// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Intent;
import com.google.android.gms.internal.ef;
import java.util.List;
import java.util.Map;
import android.os.RemoteException;
import com.google.android.gms.internal.ey;
import android.content.Context;
import android.content.ServiceConnection;

class ad implements ac
{
    private ServiceConnection a;
    private af b;
    private ag c;
    private Context d;
    private ey e;
    
    public ad(final Context d, final af b, final ag c) {
        this.d = d;
        if (b == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.b = b;
        if (c == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.c = c;
    }
    
    private ey f() {
        this.d();
        return this.e;
    }
    
    private void g() {
        this.h();
    }
    
    private void h() {
        this.b.d();
    }
    
    @Override
    public void a() {
        try {
            this.f().a();
        }
        catch (RemoteException obj) {
            p.a("clear hits failed: " + obj);
        }
    }
    
    @Override
    public void a(final Map<String, String> map, final long n, final String s, final List<ef> list) {
        try {
            this.f().a(map, n, s, list);
        }
        catch (RemoteException obj) {
            p.a("sendHit failed: " + obj);
        }
    }
    
    @Override
    public void b() {
        final Intent obj = new Intent("com.google.android.gms.analytics.service.START");
        obj.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        obj.putExtra("app_package_name", this.d.getPackageName());
        if (this.a != null) {
            p.a("Calling connect() while still connected, missing disconnect().");
        }
        else {
            this.a = (ServiceConnection)new ae(this);
            final boolean bindService = this.d.bindService(obj, this.a, 129);
            p.c("connect: bindService returned " + bindService + " for " + obj);
            if (!bindService) {
                this.a = null;
                this.c.a(1, null);
            }
        }
    }
    
    @Override
    public void c() {
        this.e = null;
        if (this.a == null) {
            return;
        }
        while (true) {
            try {
                this.d.unbindService(this.a);
                this.a = null;
                this.b.e();
            }
            catch (IllegalArgumentException ex) {
                continue;
            }
            catch (IllegalStateException ex2) {
                continue;
            }
            break;
        }
    }
    
    protected void d() {
        if (!this.e()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }
    
    public boolean e() {
        return this.e != null;
    }
}
