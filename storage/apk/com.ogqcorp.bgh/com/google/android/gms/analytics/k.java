// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.internal.gz;
import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public class k
{
    private final n a;
    private final Map<String, String> b;
    private t c;
    private final al d;
    private final u e;
    private final ak f;
    private boolean g;
    private l h;
    private aa i;
    
    k(final String s, final n n) {
        this(s, n, al.a(), u.a(), ak.a(), new bk("tracking"));
    }
    
    k(final String s, final n a, final al d, final u e, final ak f, final t c) {
        this.b = new HashMap<String, String>();
        this.a = a;
        if (s != null) {
            this.b.put("&tid", s);
        }
        this.b.put("useSecure", "1");
        this.d = d;
        this.e = e;
        this.f = f;
        this.c = c;
        this.h = new l(this);
    }
    
    long a() {
        return this.h.a();
    }
    
    public void a(final long n) {
        this.h.a(1000L * n);
    }
    
    void a(final Context context, final aa i) {
        p.c("Loading Tracker config values.");
        this.i = i;
        if (this.i.a()) {
            final String b = this.i.b();
            this.a("&tid", b);
            p.c("[Tracker] trackingId loaded: " + b);
        }
        if (this.i.c()) {
            final String string = Double.toString(this.i.d());
            this.a("&sf", string);
            p.c("[Tracker] sample frequency loaded: " + string);
        }
        if (this.i.e()) {
            this.a(this.i.f());
            p.c("[Tracker] session timeout loaded: " + this.a());
        }
        if (this.i.g()) {
            this.a(this.i.h());
            p.c("[Tracker] auto activity tracking loaded: " + this.b());
        }
        if (this.i.i()) {
            if (this.i.j()) {
                this.a("&aip", "1");
                p.c("[Tracker] anonymize ip loaded: true");
            }
            p.c("[Tracker] anonymize ip loaded: false");
        }
        this.g = this.i.k();
        if (this.i.k()) {
            Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)new b(this, Thread.getDefaultUncaughtExceptionHandler(), context));
            p.c("[Tracker] report uncaught exceptions loaded: " + this.g);
        }
    }
    
    public void a(final String s, final String s2) {
        gz.a(s, "Key should be non-null");
        bd.a().a(be.k);
        this.b.put(s, s2);
    }
    
    public void a(final Map<String, String> map) {
        bd.a().a(be.l);
        final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.putAll(this.b);
        if (map != null) {
            hashMap.putAll(map);
        }
        if (TextUtils.isEmpty((CharSequence)hashMap.get("&tid"))) {
            p.d(String.format("Missing tracking id (%s) parameter.", "&tid"));
        }
        String s = hashMap.get("&t");
        if (TextUtils.isEmpty((CharSequence)s)) {
            p.d(String.format("Missing hit type (%s) parameter.", "&t"));
            s = "";
        }
        if (this.h.c()) {
            hashMap.put("&sc", "start");
        }
        if (!s.equals("transaction") && !s.equals("item") && !this.c.a()) {
            p.d("Too many hits sent too quickly, rate limiting invoked.");
            return;
        }
        this.a.a((Map<String, String>)hashMap);
    }
    
    public void a(final boolean b) {
        this.h.a(b);
    }
    
    boolean b() {
        return this.h.b();
    }
}
