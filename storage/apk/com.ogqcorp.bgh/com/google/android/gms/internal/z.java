// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.HashSet;
import android.content.Context;
import java.util.Collections;
import com.google.android.gms.ads.e.a;
import com.google.android.gms.ads.mediation.NetworkExtras;
import android.os.Bundle;
import com.google.android.gms.ads.c.b;
import java.util.Map;
import android.location.Location;
import java.util.Set;
import java.util.Date;

public final class z
{
    public static final String a;
    private final Date b;
    private final String c;
    private final int d;
    private final Set<String> e;
    private final Location f;
    private final boolean g;
    private final Map<Class<? extends b>, Bundle> h;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> i;
    private final String j;
    private final a k;
    private final int l;
    private final Set<String> m;
    
    static {
        a = em.a("emulator");
    }
    
    public z(final aa aa) {
        this(aa, null);
    }
    
    public z(final aa aa, final a k) {
        this.b = aa.e;
        this.c = aa.f;
        this.d = aa.g;
        this.e = Collections.unmodifiableSet((Set<? extends String>)aa.a);
        this.f = aa.h;
        this.g = aa.i;
        this.h = Collections.unmodifiableMap((Map<? extends Class<? extends b>, ? extends Bundle>)aa.b);
        this.i = Collections.unmodifiableMap((Map<? extends Class<? extends NetworkExtras>, ? extends NetworkExtras>)aa.c);
        this.j = aa.j;
        this.k = k;
        this.l = aa.k;
        this.m = Collections.unmodifiableSet((Set<? extends String>)aa.d);
    }
    
    public Bundle a(final Class<? extends b> clazz) {
        return this.h.get(clazz);
    }
    
    public Date a() {
        return this.b;
    }
    
    public boolean a(final Context context) {
        return this.m.contains(em.a(context));
    }
    
    public String b() {
        return this.c;
    }
    
    public int c() {
        return this.d;
    }
    
    public Set<String> d() {
        return this.e;
    }
    
    public Location e() {
        return this.f;
    }
    
    public boolean f() {
        return this.g;
    }
    
    public String g() {
        return this.j;
    }
    
    public a h() {
        return this.k;
    }
    
    public Map<Class<? extends NetworkExtras>, NetworkExtras> i() {
        return this.i;
    }
    
    public Map<Class<? extends b>, Bundle> j() {
        return this.h;
    }
    
    public int k() {
        return this.l;
    }
}
