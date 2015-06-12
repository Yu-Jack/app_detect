// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.internal.gz;
import android.content.Context;
import java.util.Map;
import java.util.HashMap;
import android.app.Activity;
import java.util.TimerTask;
import java.util.Timer;

class l implements d
{
    final /* synthetic */ k a;
    private Timer b;
    private TimerTask c;
    private boolean d;
    private boolean e;
    private int f;
    private long g;
    private boolean h;
    private long i;
    private am j;
    
    public l(final k a) {
        this.a = a;
        this.d = false;
        this.e = false;
        this.f = 0;
        this.g = -1L;
        this.h = false;
        this.j = new am() {
            @Override
            public long a() {
                return System.currentTimeMillis();
            }
        };
    }
    
    private void e() {
        final c a = com.google.android.gms.analytics.c.a();
        if (a == null) {
            p.a("GoogleAnalytics isn't initialized for the Tracker!");
            return;
        }
        if (this.g >= 0L || this.e) {
            a.a(this.a.h);
            return;
        }
        a.b(this.a.h);
    }
    
    private void f() {
        synchronized (this) {
            if (this.b != null) {
                this.b.cancel();
                this.b = null;
            }
        }
    }
    
    public long a() {
        return this.g;
    }
    
    public void a(final long g) {
        this.g = g;
        this.e();
    }
    
    @Override
    public void a(final Activity activity) {
        bd.a().a(be.ai);
        this.f();
        if (!this.d && this.f == 0 && this.d()) {
            this.h = true;
        }
        this.d = true;
        ++this.f;
        if (this.e) {
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("&t", "appview");
            bd.a().a(true);
            final k a = this.a;
            String s;
            if (this.a.i != null) {
                s = this.a.i.a(activity);
            }
            else {
                s = activity.getClass().getCanonicalName();
            }
            a.a("&cd", s);
            this.a.a(hashMap);
            bd.a().a(false);
        }
    }
    
    public void a(final boolean e) {
        this.e = e;
        this.e();
    }
    
    @Override
    public void b(final Activity activity) {
        bd.a().a(be.aj);
        --this.f;
        this.f = Math.max(0, this.f);
        this.i = this.j.a();
        if (this.f == 0) {
            this.f();
            this.c = new m(this, null);
            (this.b = new Timer("waitForActivityStart")).schedule(this.c, 1000L);
        }
    }
    
    public boolean b() {
        return this.e;
    }
    
    public boolean c() {
        final boolean h = this.h;
        this.h = false;
        return h;
    }
    
    boolean d() {
        return this.g == 0L || (this.g > 0L && this.j.a() > this.i + this.g);
    }
}
