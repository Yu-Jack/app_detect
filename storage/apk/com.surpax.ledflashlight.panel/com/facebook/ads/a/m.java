// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a;

import android.net.NetworkInfo;
import com.facebook.ads.d;
import android.net.ConnectivityManager;
import android.os.AsyncTask$Status;
import com.facebook.ads.b;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Handler;
import com.facebook.ads.e;
import android.content.Context;

public final class m
{
    private final Context a;
    private final String b;
    private final e c;
    private final l d;
    private final q e;
    private final boolean f;
    private final n g;
    private int h;
    private int i;
    private boolean j;
    private volatile boolean k;
    private final Handler l;
    private final Runnable m;
    private AsyncTask n;
    private volatile long o;
    private int p;
    
    public m(final Context a, final String b, final e c, final boolean f, final q e, final l d) {
        this.h = 30000;
        this.i = 20000;
        this.j = false;
        this.k = false;
        this.p = 8;
        if (d == null) {
            throw new IllegalArgumentException("adViewRequestCallback");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.f = f;
        this.e = e;
        this.d = d;
        this.g = new n(this, (byte)0);
        this.l = new Handler();
        this.m = new Runnable() {
            @Override
            public final void run() {
                com.facebook.ads.a.m.this.k = false;
                com.facebook.ads.a.m.this.b();
            }
        };
        if (this.f) {
            final IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.a.registerReceiver((BroadcastReceiver)this.g, intentFilter);
        }
    }
    
    private void d() {
        synchronized (this) {
            if (this.k) {
                this.l.removeCallbacks(this.m);
                this.k = false;
            }
        }
    }
    
    public final void a() {
        synchronized (this) {
            if (this.f && this.h > 0 && !this.k) {
                this.l.postDelayed(this.m, (long)this.h);
                this.k = true;
            }
        }
    }
    
    public final void a(final int p) {
        this.p = p;
        if (p == 0) {
            if (this.j) {
                this.a();
            }
            return;
        }
        this.d();
    }
    
    public final void b() {
        while (true) {
            long currentTimeMillis = 0L;
        Label_0188:
            while (true) {
                Label_0152: {
                    synchronized (this) {
                        final long n = this.o + this.i;
                        currentTimeMillis = System.currentTimeMillis();
                        if (this.f && currentTimeMillis < n) {
                            this.d.a(com.facebook.ads.b.b);
                        }
                        else {
                            if (this.k) {
                                this.d();
                            }
                            if (this.n != null && this.n.getStatus() != AsyncTask$Status.FINISHED) {
                                this.n.cancel(true);
                            }
                            if (this.a.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                                break Label_0152;
                            }
                            final int n2 = 1;
                            if (n2 != 0) {
                                break Label_0188;
                            }
                            this.h = 30000;
                            this.i = 20000;
                            this.d.a(new b(-1, "network unavailable"));
                            this.a();
                        }
                        return;
                    }
                }
                final NetworkInfo activeNetworkInfo = ((ConnectivityManager)this.a.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    final int n2 = 1;
                    continue;
                }
                final int n2 = 0;
                continue;
            }
            this.o = currentTimeMillis;
            this.n = new j(this.a, this.b, this.c, this.e, com.facebook.ads.d.a(this.a), new l() {
                @Override
                public final void a(final o o) {
                    com.facebook.ads.a.m.this.h = o.a();
                    com.facebook.ads.a.m.this.i = o.b();
                    com.facebook.ads.a.m.this.d.a(o);
                    com.facebook.ads.a.m.this.j = true;
                }
                
                @Override
                public final void a(final b b) {
                    com.facebook.ads.a.m.this.d.a(b);
                    com.facebook.ads.a.m.this.j = true;
                    com.facebook.ads.a.m.this.a();
                }
            }).a();
        }
    }
    
    public final void c() {
        if (this.f) {
            this.a.unregisterReceiver((BroadcastReceiver)this.g);
        }
        this.d();
    }
}
