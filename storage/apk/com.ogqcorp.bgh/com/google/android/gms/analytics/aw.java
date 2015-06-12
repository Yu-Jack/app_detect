// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import java.util.List;
import java.util.Map;
import android.content.Intent;
import java.util.TimerTask;
import com.google.android.gms.internal.ef;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Timer;
import java.util.Queue;
import android.content.Context;

class aw implements af, ag, w
{
    private volatile long a;
    private volatile ax b;
    private volatile ac c;
    private ah d;
    private ah e;
    private final c f;
    private final aj g;
    private final Context h;
    private final Queue<ba> i;
    private volatile int j;
    private volatile Timer k;
    private volatile Timer l;
    private volatile Timer m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private am r;
    private long s;
    
    aw(final Context context, final aj aj) {
        this(context, aj, null, com.google.android.gms.analytics.c.a(context));
    }
    
    aw(final Context h, final aj g, final ah e, final c f) {
        this.i = new ConcurrentLinkedQueue<ba>();
        this.s = 300000L;
        this.e = e;
        this.h = h;
        this.g = g;
        this.f = f;
        this.r = new am() {
            @Override
            public long a() {
                return System.currentTimeMillis();
            }
        };
        this.j = 0;
        this.b = ax.g;
    }
    
    private Timer a(final Timer timer) {
        if (timer != null) {
            timer.cancel();
        }
        return null;
    }
    
    private void g() {
        this.k = this.a(this.k);
        this.l = this.a(this.l);
        this.m = this.a(this.m);
    }
    
    private void h() {
        while (true) {
            Label_0323: {
                Label_0190: {
                    Label_0204: {
                        synchronized (this) {
                            if (!Thread.currentThread().equals(this.g.d())) {
                                this.g.c().add(new Runnable() {
                                    @Override
                                    public void run() {
                                        aw.this.h();
                                    }
                                });
                                return;
                            }
                            if (this.o) {
                                this.f();
                            }
                            switch (aw$3.a[this.b.ordinal()]) {
                                case 1: {
                                    while (!this.i.isEmpty()) {
                                        final ba obj = this.i.poll();
                                        com.google.android.gms.analytics.p.c("Sending hit to store  " + obj);
                                        this.d.a(obj.a(), obj.b(), obj.c(), obj.d());
                                    }
                                    break;
                                }
                                case 2: {
                                    break Label_0204;
                                }
                                case 6: {
                                    break Label_0323;
                                }
                                default: {
                                    return;
                                }
                            }
                        }
                        break Label_0190;
                    }
                    while (!this.i.isEmpty()) {
                        final ba obj2 = this.i.peek();
                        com.google.android.gms.analytics.p.c("Sending hit to service   " + obj2);
                        if (!this.f.b()) {
                            this.c.a(obj2.a(), obj2.b(), obj2.c(), obj2.d());
                        }
                        else {
                            com.google.android.gms.analytics.p.c("Dry run enabled. Hit not actually sent to service.");
                        }
                        this.i.poll();
                    }
                    this.a = this.r.a();
                    return;
                }
                if (this.n) {
                    this.i();
                    return;
                }
                return;
            }
            com.google.android.gms.analytics.p.c("Need to reconnect");
            if (!this.i.isEmpty()) {
                this.k();
            }
        }
    }
    
    private void i() {
        this.d.c();
        this.n = false;
    }
    
    private void j() {
        while (true) {
            while (true) {
                Label_0062: {
                    synchronized (this) {
                        if (this.b != ax.c) {
                            this.g();
                            com.google.android.gms.analytics.p.c("falling back to local store");
                            if (this.e == null) {
                                break Label_0062;
                            }
                            this.d = this.e;
                            this.b = ax.c;
                            this.h();
                        }
                        return;
                    }
                }
                final av c = av.c();
                c.a(this.h, this.g);
                this.d = c.d();
                continue;
            }
        }
    }
    
    private void k() {
        while (true) {
            synchronized (this) {
                if (!this.q && this.c != null && this.b != ax.c) {
                    try {
                        ++this.j;
                        this.a(this.l);
                        this.b = ax.a;
                        (this.l = new Timer("Failed Connect")).schedule(new az(this, null), 3000L);
                        com.google.android.gms.analytics.p.c("connecting to Analytics service");
                        this.c.b();
                        return;
                    }
                    catch (SecurityException ex) {
                        com.google.android.gms.analytics.p.d("security exception on connectToService");
                        this.j();
                    }
                }
            }
            com.google.android.gms.analytics.p.d("client not initialized.");
            this.j();
        }
    }
    
    private void l() {
        synchronized (this) {
            if (this.c != null && this.b == ax.b) {
                this.b = ax.f;
                this.c.c();
            }
        }
    }
    
    private void m() {
        this.k = this.a(this.k);
        (this.k = new Timer("Service Reconnect")).schedule(new bb(this, null), 5000L);
    }
    
    @Override
    public void a() {
        while (true) {
            Label_0088: {
                synchronized (this) {
                    if (!this.q) {
                        com.google.android.gms.analytics.p.c("setForceLocalDispatch called.");
                        this.q = true;
                        switch (aw$3.a[this.b.ordinal()]) {
                            case 2: {
                                this.l();
                            }
                            case 1:
                            case 4:
                            case 5:
                            case 6: {
                                break;
                            }
                            case 3: {
                                break Label_0088;
                            }
                            default: {}
                        }
                    }
                    return;
                }
            }
            this.p = true;
        }
    }
    
    @Override
    public void a(final int n, final Intent intent) {
        synchronized (this) {
            this.b = ax.e;
            if (this.j < 2) {
                com.google.android.gms.analytics.p.d("Service unavailable (code=" + n + "), will retry.");
                this.m();
            }
            else {
                com.google.android.gms.analytics.p.d("Service unavailable (code=" + n + "), using local store.");
                this.j();
            }
        }
    }
    
    @Override
    public void a(final Map<String, String> map, final long n, final String s, final List<ef> list) {
        com.google.android.gms.analytics.p.c("putHit called");
        this.i.add(new ba(map, n, s, list));
        this.h();
    }
    
    @Override
    public void b() {
        switch (aw$3.a[this.b.ordinal()]) {
            default: {
                this.n = true;
            }
            case 2: {}
            case 1: {
                this.i();
            }
        }
    }
    
    @Override
    public void c() {
        if (this.c != null) {
            return;
        }
        this.c = new ad(this.h, this, this);
        this.k();
    }
    
    @Override
    public void d() {
        synchronized (this) {
            this.l = this.a(this.l);
            this.j = 0;
            com.google.android.gms.analytics.p.c("Connected to service");
            this.b = ax.b;
            if (this.p) {
                this.l();
                this.p = false;
            }
            else {
                this.h();
                this.m = this.a(this.m);
                (this.m = new Timer("disconnect check")).schedule(new ay(this, null), this.s);
            }
        }
    }
    
    @Override
    public void e() {
        while (true) {
            Label_0065: {
                synchronized (this) {
                    if (this.b == ax.f) {
                        com.google.android.gms.analytics.p.c("Disconnected from service");
                        this.g();
                        this.b = ax.g;
                    }
                    else {
                        com.google.android.gms.analytics.p.c("Unexpected disconnect.");
                        this.b = ax.e;
                        if (this.j >= 2) {
                            break Label_0065;
                        }
                        this.m();
                    }
                    return;
                }
            }
            this.j();
        }
    }
    
    public void f() {
        com.google.android.gms.analytics.p.c("clearHits called");
        this.i.clear();
        switch (aw$3.a[this.b.ordinal()]) {
            default: {
                this.o = true;
            }
            case 1: {
                this.d.a(0L);
                this.o = false;
            }
            case 2: {
                this.c.a();
                this.o = false;
            }
        }
    }
}
