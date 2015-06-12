// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import java.util.Locale;
import java.util.Map;
import android.os.Bundle;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import java.util.Iterator;
import android.app.Activity;
import java.util.HashSet;
import java.util.Set;
import android.content.Context;

public class c extends n
{
    private static boolean a;
    private static c l;
    private boolean b;
    private aj c;
    private v d;
    private Context e;
    private volatile Boolean f;
    private i g;
    private String h;
    private String i;
    private Set<d> j;
    private boolean k;
    
    protected c(final Context context) {
        this(context, bc.a(context), av.c());
    }
    
    private c(final Context context, final aj c, final v d) {
        this.f = false;
        this.k = false;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.e = context.getApplicationContext();
        this.c = c;
        this.d = d;
        ak.a(this.e);
        u.a(this.e);
        al.a(this.e);
        this.g = new aq();
        this.j = new HashSet<d>();
        this.f();
    }
    
    private int a(final String s) {
        final String lowerCase = s.toLowerCase();
        if ("verbose".equals(lowerCase)) {
            return 0;
        }
        if ("info".equals(lowerCase)) {
            return 1;
        }
        if ("warning".equals(lowerCase)) {
            return 2;
        }
        if ("error".equals(lowerCase)) {
            return 3;
        }
        return -1;
    }
    
    static c a() {
        synchronized (c.class) {
            return c.l;
        }
    }
    
    public static c a(final Context context) {
        synchronized (c.class) {
            if (c.l == null) {
                c.l = new c(context);
            }
            return c.l;
        }
    }
    
    private k a(final k k) {
        if (this.i != null) {
            k.a("&an", this.i);
        }
        if (this.h != null) {
            k.a("&av", this.h);
        }
        return k;
    }
    
    private void c(final Activity activity) {
        final Iterator<d> iterator = this.j.iterator();
        while (iterator.hasNext()) {
            iterator.next().a(activity);
        }
    }
    
    private void d(final Activity activity) {
        final Iterator<d> iterator = this.j.iterator();
        while (iterator.hasNext()) {
            iterator.next().b(activity);
        }
    }
    
    private void f() {
        if (!com.google.android.gms.analytics.c.a) {
            ApplicationInfo applicationInfo;
            while (true) {
                try {
                    applicationInfo = this.e.getPackageManager().getApplicationInfo(this.e.getPackageName(), 129);
                    if (applicationInfo == null) {
                        p.d("Couldn't get ApplicationInfo to load gloabl config.");
                        return;
                    }
                }
                catch (PackageManager$NameNotFoundException obj) {
                    p.c("PackageManager doesn't know about package: " + obj);
                    applicationInfo = null;
                    continue;
                }
                break;
            }
            final Bundle metaData = applicationInfo.metaData;
            if (metaData != null) {
                final int int1 = metaData.getInt("com.google.android.gms.analytics.globalConfigResource");
                if (int1 > 0) {
                    final bh bh = new bf(this.e).a(int1);
                    if (bh != null) {
                        this.a(bh);
                    }
                }
            }
        }
    }
    
    public k a(final int n) {
        synchronized (this) {
            bd.a().a(be.N);
            final k k = new k(null, this);
            if (n > 0) {
                final aa aa = new y(this.e).a(n);
                if (aa != null) {
                    k.a(this.e, aa);
                }
            }
            return this.a(k);
        }
    }
    
    public void a(final Activity activity) {
        if (!this.k) {
            this.c(activity);
        }
    }
    
    void a(final bh bh) {
        p.c("Loading global config values.");
        if (bh.a()) {
            this.i = bh.b();
            p.c("app name loaded: " + this.i);
        }
        if (bh.c()) {
            this.h = bh.d();
            p.c("app version loaded: " + this.h);
        }
        if (bh.e()) {
            final int a = this.a(bh.f());
            if (a >= 0) {
                p.c("log level loaded: " + a);
                this.d().a(a);
            }
        }
        if (bh.g()) {
            this.d.a(bh.h());
        }
        if (bh.i()) {
            this.a(bh.j());
        }
    }
    
    void a(final d d) {
        this.j.add(d);
    }
    
    @Override
    void a(final Map<String, String> map) {
        // monitorenter(this)
        if (map == null) {
            try {
                throw new IllegalArgumentException("hit cannot be null");
            }
            finally {
            }
            // monitorexit(this)
        }
        ab.a(map, "&ul", ab.a(Locale.getDefault()));
        ab.a(map, "&sr", u.a().a("&sr"));
        map.put("&_u", bd.a().c());
        bd.a().b();
        this.c.a(map);
    }
    // monitorexit(this)
    
    public void a(final boolean b) {
        bd.a().a(be.ac);
        this.b = b;
    }
    
    public void b(final Activity activity) {
        if (!this.k) {
            this.d(activity);
        }
    }
    
    void b(final d d) {
        this.j.remove(d);
    }
    
    public boolean b() {
        bd.a().a(be.ad);
        return this.b;
    }
    
    public boolean c() {
        bd.a().a(be.R);
        return this.f;
    }
    
    public i d() {
        return this.g;
    }
    
    @Deprecated
    public void e() {
        this.d.a();
    }
}
