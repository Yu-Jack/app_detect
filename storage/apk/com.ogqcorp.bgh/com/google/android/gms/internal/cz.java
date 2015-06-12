// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Collections;
import java.util.List;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class cz implements SafeParcelable
{
    public static final dl CREATOR;
    public final int a;
    public final String b;
    public final String c;
    public final List<String> d;
    public final int e;
    public final List<String> f;
    public final long g;
    public final boolean h;
    public final long i;
    public final List<String> j;
    public final long k;
    public final int l;
    public final String m;
    public final long n;
    public final String o;
    public final boolean p;
    public final String q;
    public final String r;
    
    static {
        CREATOR = new dl();
    }
    
    public cz(final int n) {
        this(7, null, null, null, n, null, -1L, false, -1L, null, -1L, -1, null, -1L, null, false, null, null);
    }
    
    public cz(final int n, final long n2) {
        this(7, null, null, null, n, null, -1L, false, -1L, null, n2, -1, null, -1L, null, false, null, null);
    }
    
    cz(final int a, final String b, final String c, final List<String> list, final int e, final List<String> list2, final long g, final boolean h, final long i, final List<String> list3, final long k, final int l, final String m, final long n, final String o, final boolean p18, final String q, final String r) {
        this.a = a;
        this.b = b;
        this.c = c;
        List<String> unmodifiableList;
        if (list != null) {
            unmodifiableList = Collections.unmodifiableList((List<? extends String>)list);
        }
        else {
            unmodifiableList = null;
        }
        this.d = unmodifiableList;
        this.e = e;
        List<String> unmodifiableList2;
        if (list2 != null) {
            unmodifiableList2 = Collections.unmodifiableList((List<? extends String>)list2);
        }
        else {
            unmodifiableList2 = null;
        }
        this.f = unmodifiableList2;
        this.g = g;
        this.h = h;
        this.i = i;
        List<String> unmodifiableList3;
        if (list3 != null) {
            unmodifiableList3 = Collections.unmodifiableList((List<? extends String>)list3);
        }
        else {
            unmodifiableList3 = null;
        }
        this.j = unmodifiableList3;
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = n;
        this.o = o;
        this.p = p18;
        this.q = q;
        this.r = r;
    }
    
    public cz(final String s, final String s2, final List<String> list, final List<String> list2, final long n, final boolean b, final long n2, final List<String> list3, final long n3, final int n4, final String s3, final long n5, final String s4, final String s5) {
        this(7, s, s2, list, -2, list2, n, b, n2, list3, n3, n4, s3, n5, s4, false, null, s5);
    }
    
    public cz(final String s, final String s2, final List<String> list, final List<String> list2, final long n, final boolean b, final long n2, final List<String> list3, final long n3, final int n4, final String s3, final long n5, final String s4, final boolean b2, final String s5, final String s6) {
        this(7, s, s2, list, -2, list2, n, b, n2, list3, n3, n4, s3, n5, s4, b2, s5, s6);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        dl.a(this, parcel, n);
    }
}
