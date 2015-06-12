// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

public final class ds
{
    private String a;
    private String b;
    private String c;
    private List<String> d;
    private String e;
    private String f;
    private List<String> g;
    private long h;
    private boolean i;
    private final long j;
    private List<String> k;
    private long l;
    private int m;
    
    public ds() {
        this.h = -1L;
        this.i = false;
        this.j = -1L;
        this.l = -1L;
        this.m = -1;
    }
    
    private static String a(final Map<String, List<String>> map, final String s) {
        final List<String> list = map.get(s);
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }
    
    private static long b(final Map<String, List<String>> map, final String str) {
        final List<String> list = map.get(str);
        if (list != null && !list.isEmpty()) {
            final String s = list.get(0);
            try {
                return (long)(Float.parseFloat(s) * 1000.0f);
            }
            catch (NumberFormatException ex) {
                en.e("Could not parse float from " + str + " header: " + s);
            }
        }
        return -1L;
    }
    
    private void b(final Map<String, List<String>> map) {
        this.a = a(map, "X-Afma-Ad-Size");
    }
    
    private static List<String> c(final Map<String, List<String>> map, final String s) {
        final List<String> list = map.get(s);
        if (list != null && !list.isEmpty()) {
            final String s2 = list.get(0);
            if (s2 != null) {
                return Arrays.asList(s2.trim().split("\\s+"));
            }
        }
        return null;
    }
    
    private void c(final Map<String, List<String>> map) {
        final List<String> c = c(map, "X-Afma-Click-Tracking-Urls");
        if (c != null) {
            this.d = c;
        }
    }
    
    private void d(final Map<String, List<String>> map) {
        final List<String> list = map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.e = list.get(0);
        }
    }
    
    private void e(final Map<String, List<String>> map) {
        final List<String> c = c(map, "X-Afma-Tracking-Urls");
        if (c != null) {
            this.g = c;
        }
    }
    
    private void f(final Map<String, List<String>> map) {
        final long b = b(map, "X-Afma-Interstitial-Timeout");
        if (b != -1L) {
            this.h = b;
        }
    }
    
    private void g(final Map<String, List<String>> map) {
        this.f = a(map, "X-Afma-ActiveView");
    }
    
    private void h(final Map<String, List<String>> map) {
        final List<String> list = map.get("X-Afma-Mediation");
        if (list != null && !list.isEmpty()) {
            this.i = Boolean.valueOf(list.get(0));
        }
    }
    
    private void i(final Map<String, List<String>> map) {
        final List<String> c = c(map, "X-Afma-Manual-Tracking-Urls");
        if (c != null) {
            this.k = c;
        }
    }
    
    private void j(final Map<String, List<String>> map) {
        final long b = b(map, "X-Afma-Refresh-Rate");
        if (b != -1L) {
            this.l = b;
        }
    }
    
    private void k(final Map<String, List<String>> map) {
        final List<String> list = map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            final String s = list.get(0);
            if ("portrait".equalsIgnoreCase(s)) {
                this.m = eg.c();
            }
            else if ("landscape".equalsIgnoreCase(s)) {
                this.m = eg.b();
            }
        }
    }
    
    public cz a(final long n) {
        return new cz(this.b, this.c, this.d, this.g, this.h, this.i, -1L, this.k, this.l, this.m, this.a, n, this.e, this.f);
    }
    
    public void a(final String b, final Map<String, List<String>> map, final String c) {
        this.b = b;
        this.c = c;
        this.a(map);
    }
    
    public void a(final Map<String, List<String>> map) {
        this.b(map);
        this.c(map);
        this.d(map);
        this.e(map);
        this.f(map);
        this.h(map);
        this.i(map);
        this.j(map);
        this.k(map);
        this.g(map);
    }
}
