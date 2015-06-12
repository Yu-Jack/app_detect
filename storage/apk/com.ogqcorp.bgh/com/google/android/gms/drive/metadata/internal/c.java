// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.internal.iq;
import com.google.android.gms.internal.ij;
import com.google.android.gms.internal.hy;
import java.util.HashMap;
import com.google.android.gms.drive.metadata.a;
import java.util.Map;

public final class c
{
    private static Map<String, a<?>> a;
    
    static {
        c.a = new HashMap<String, a<?>>();
        a(hy.a);
        a(hy.x);
        a(hy.q);
        a(hy.v);
        a(hy.y);
        a(hy.k);
        a(hy.l);
        a(hy.i);
        a(hy.n);
        a(hy.t);
        a(hy.b);
        a(hy.s);
        a(hy.c);
        a(hy.j);
        a(hy.d);
        a(hy.e);
        a(hy.f);
        a(hy.p);
        a(hy.m);
        a(hy.r);
        a(hy.u);
        a(hy.z);
        a(hy.A);
        a(hy.h);
        a(hy.g);
        a(hy.w);
        a(hy.o);
        a(ij.a);
        a(ij.c);
        a(ij.d);
        a(ij.e);
        a(ij.b);
        a(iq.a);
        a(iq.b);
    }
    
    public static a<?> a(final String s) {
        return c.a.get(s);
    }
    
    private static void a(final a<?> a) {
        if (c.a.containsKey(a.a())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + a.a());
        }
        c.a.put(a.a(), a);
    }
}
