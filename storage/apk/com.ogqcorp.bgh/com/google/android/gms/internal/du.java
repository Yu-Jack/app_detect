// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Collections;
import org.json.JSONObject;
import java.util.List;

public final class du
{
    public final ah a;
    public final ep b;
    public final List<String> c;
    public final int d;
    public final List<String> e;
    public final List<String> f;
    public final int g;
    public final long h;
    public final String i;
    public final JSONObject j;
    public final boolean k;
    public final ar l;
    public final be m;
    public final String n;
    public final as o;
    public final au p;
    public final long q;
    public final ak r;
    public final long s;
    public final long t;
    public final long u;
    public final String v;
    
    public du(final ah a, final ep b, final List<String> list, final int d, final List<String> list2, final List<String> list3, final int g, final long h, final String i, final boolean k, final ar l, final be m, final String n, final as o, final au p22, final long q, final ak r, final long s, final long t, final long u, final String v, final JSONObject j) {
        this.a = a;
        this.b = b;
        List<String> unmodifiableList;
        if (list != null) {
            unmodifiableList = Collections.unmodifiableList((List<? extends String>)list);
        }
        else {
            unmodifiableList = null;
        }
        this.c = unmodifiableList;
        this.d = d;
        List<String> unmodifiableList2;
        if (list2 != null) {
            unmodifiableList2 = Collections.unmodifiableList((List<? extends String>)list2);
        }
        else {
            unmodifiableList2 = null;
        }
        this.e = unmodifiableList2;
        List<String> unmodifiableList3;
        if (list3 != null) {
            unmodifiableList3 = Collections.unmodifiableList((List<? extends String>)list3);
        }
        else {
            unmodifiableList3 = null;
        }
        this.f = unmodifiableList3;
        this.g = g;
        this.h = h;
        this.i = i;
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = n;
        this.o = o;
        this.p = p22;
        this.q = q;
        this.r = r;
        this.s = s;
        this.t = t;
        this.u = u;
        this.v = v;
        this.j = j;
    }
}
