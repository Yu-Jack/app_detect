// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

public final class ea
{
    private int mOrientation;
    private String qG;
    private String qH;
    private String qI;
    private List qJ;
    private String qK;
    private String qL;
    private List qM;
    private long qN;
    private boolean qO;
    private final long qP;
    private List qQ;
    private long qR;
    
    public ea() {
        this.qN = -1L;
        this.qO = false;
        this.qP = -1L;
        this.qR = -1L;
        this.mOrientation = -1;
    }
    
    private static String a(final Map map, final String s) {
        final List<String> list = map.get(s);
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }
    
    private static long b(final Map map, final String str) {
        final List<String> list = map.get(str);
        if (list != null && !list.isEmpty()) {
            final String s = list.get(0);
            try {
                return (long)(Float.parseFloat(s) * 1000.0f);
            }
            catch (NumberFormatException ex) {
                eu.D("Could not parse float from " + str + " header: " + s);
            }
        }
        return -1L;
    }
    
    private static List c(final Map map, final String s) {
        final List<String> list = map.get(s);
        if (list != null && !list.isEmpty()) {
            final String s2 = list.get(0);
            if (s2 != null) {
                return Arrays.asList(s2.trim().split("\\s+"));
            }
        }
        return null;
    }
    
    private void e(final Map map) {
        this.qG = a(map, "X-Afma-Ad-Size");
    }
    
    private void f(final Map map) {
        final List c = c(map, "X-Afma-Click-Tracking-Urls");
        if (c != null) {
            this.qJ = c;
        }
    }
    
    private void g(final Map map) {
        final List<String> list = map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.qK = list.get(0);
        }
    }
    
    private void h(final Map map) {
        final List c = c(map, "X-Afma-Tracking-Urls");
        if (c != null) {
            this.qM = c;
        }
    }
    
    private void i(final Map map) {
        final long b = b(map, "X-Afma-Interstitial-Timeout");
        if (b != -1L) {
            this.qN = b;
        }
    }
    
    private void j(final Map map) {
        this.qL = a(map, "X-Afma-ActiveView");
    }
    
    private void k(final Map map) {
        final List<String> list = map.get("X-Afma-Mediation");
        if (list != null && !list.isEmpty()) {
            this.qO = Boolean.valueOf(list.get(0));
        }
    }
    
    private void l(final Map map) {
        final List c = c(map, "X-Afma-Manual-Tracking-Urls");
        if (c != null) {
            this.qQ = c;
        }
    }
    
    private void m(final Map map) {
        final long b = b(map, "X-Afma-Refresh-Rate");
        if (b != -1L) {
            this.qR = b;
        }
    }
    
    private void n(final Map map) {
        final List<String> list = map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            final String s = list.get(0);
            if ("portrait".equalsIgnoreCase(s)) {
                this.mOrientation = eo.bS();
            }
            else if ("landscape".equalsIgnoreCase(s)) {
                this.mOrientation = eo.bR();
            }
        }
    }
    
    public void a(final String qh, final Map map, final String qi) {
        this.qH = qh;
        this.qI = qi;
        this.d(map);
    }
    
    public void d(final Map map) {
        this.e(map);
        this.f(map);
        this.g(map);
        this.h(map);
        this.i(map);
        this.k(map);
        this.l(map);
        this.m(map);
        this.n(map);
        this.j(map);
    }
    
    public du i(final long n) {
        return new du(this.qH, this.qI, this.qJ, this.qM, this.qN, this.qO, -1L, this.qQ, this.qR, this.mOrientation, this.qG, n, this.qK, this.qL);
    }
}
