// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.e.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class av implements SafeParcelable
{
    public static final ad CREATOR;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final String j;
    public final int k;
    public final String l;
    public final int m;
    public final int n;
    public final String o;
    
    static {
        CREATOR = new ad();
    }
    
    av(final int a, final int b, final int c, final int d, final int e, final int f, final int g, final int h, final int i, final String j, final int k, final String l, final int m, final int n, final String o) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = n;
        this.o = o;
    }
    
    public av(final a a) {
        this.a = 1;
        this.b = a.a();
        this.c = a.b();
        this.d = a.c();
        this.e = a.d();
        this.f = a.e();
        this.g = a.f();
        this.h = a.g();
        this.i = a.h();
        this.j = a.i();
        this.k = a.j();
        this.l = a.k();
        this.m = a.l();
        this.n = a.m();
        this.o = a.n();
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        ad.a(this, parcel, n);
    }
}
