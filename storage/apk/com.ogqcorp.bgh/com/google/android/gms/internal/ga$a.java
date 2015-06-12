// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.HashMap;
import java.util.ArrayList;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ga$a<I, O> implements SafeParcelable
{
    public static final hj CREATOR;
    protected final int a;
    protected final boolean b;
    protected final int c;
    protected final boolean d;
    protected final String e;
    protected final int f;
    protected final Class<? extends ga> g;
    protected final String h;
    private final int i;
    private gd j;
    private hh<I, O> k;
    
    static {
        CREATOR = new hj();
    }
    
    ga$a(final int i, final int a, final boolean b, final int c, final boolean d, final String e, final int f, final String h, final fv fv) {
        this.i = i;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        if (h == null) {
            this.g = null;
            this.h = null;
        }
        else {
            this.g = gg.class;
            this.h = h;
        }
        if (fv == null) {
            this.k = null;
            return;
        }
        this.k = (hh<I, O>)fv.c();
    }
    
    protected ga$a(final int a, final boolean b, final int c, final boolean d, final String e, final int f, final Class<? extends ga> g, final hh<I, O> k) {
        this.i = 1;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        if (g == null) {
            this.h = null;
        }
        else {
            this.h = g.getCanonicalName();
        }
        this.k = k;
    }
    
    public static ga$a<Integer, Integer> a(final String s, final int n) {
        return new ga$a<Integer, Integer>(0, false, 0, false, s, n, null, null);
    }
    
    public static ga$a a(final String s, final int n, final hh<?, ?> hh, final boolean b) {
        return new ga$a(hh.c(), b, hh.d(), false, s, n, null, (hh<I, O>)hh);
    }
    
    public static <T extends ga> ga$a<T, T> a(final String s, final int n, final Class<T> clazz) {
        return new ga$a<T, T>(11, false, 11, false, s, n, clazz, null);
    }
    
    public static ga$a<Double, Double> b(final String s, final int n) {
        return new ga$a<Double, Double>(4, false, 4, false, s, n, null, null);
    }
    
    public static <T extends ga> ga$a<ArrayList<T>, ArrayList<T>> b(final String s, final int n, final Class<T> clazz) {
        return new ga$a<ArrayList<T>, ArrayList<T>>(11, true, 11, true, s, n, clazz, null);
    }
    
    public static ga$a<Boolean, Boolean> c(final String s, final int n) {
        return new ga$a<Boolean, Boolean>(6, false, 6, false, s, n, null, null);
    }
    
    public static ga$a<String, String> d(final String s, final int n) {
        return new ga$a<String, String>(7, false, 7, false, s, n, null, null);
    }
    
    public static ga$a<ArrayList<String>, ArrayList<String>> e(final String s, final int n) {
        return new ga$a<ArrayList<String>, ArrayList<String>>(7, true, 7, true, s, n, null, null);
    }
    
    public int a() {
        return this.i;
    }
    
    public I a(final O o) {
        return this.k.a(o);
    }
    
    public void a(final gd j) {
        this.j = j;
    }
    
    public int b() {
        return this.a;
    }
    
    public boolean c() {
        return this.b;
    }
    
    public int d() {
        return this.c;
    }
    
    public int describeContents() {
        final hj creator = ga$a.CREATOR;
        return 0;
    }
    
    public boolean e() {
        return this.d;
    }
    
    public String f() {
        return this.e;
    }
    
    public int g() {
        return this.f;
    }
    
    public Class<? extends ga> h() {
        return this.g;
    }
    
    String i() {
        if (this.h == null) {
            return null;
        }
        return this.h;
    }
    
    public boolean j() {
        return this.k != null;
    }
    
    fv k() {
        if (this.k == null) {
            return null;
        }
        return fv.a(this.k);
    }
    
    public HashMap<String, ga$a<?, ?>> l() {
        gz.a(this.h);
        gz.a(this.j);
        return this.j.a(this.h);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Field\n");
        sb.append("            versionCode=").append(this.i).append('\n');
        sb.append("                 typeIn=").append(this.a).append('\n');
        sb.append("            typeInArray=").append(this.b).append('\n');
        sb.append("                typeOut=").append(this.c).append('\n');
        sb.append("           typeOutArray=").append(this.d).append('\n');
        sb.append("        outputFieldName=").append(this.e).append('\n');
        sb.append("      safeParcelFieldId=").append(this.f).append('\n');
        sb.append("       concreteTypeName=").append(this.i()).append('\n');
        if (this.h() != null) {
            sb.append("     concreteType.class=").append(this.h().getCanonicalName()).append('\n');
        }
        final StringBuilder append = sb.append("          converterName=");
        String canonicalName;
        if (this.k == null) {
            canonicalName = "null";
        }
        else {
            canonicalName = this.k.getClass().getCanonicalName();
        }
        append.append(canonicalName).append('\n');
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final hj creator = ga$a.CREATOR;
        hj.a(this, parcel, n);
    }
}
