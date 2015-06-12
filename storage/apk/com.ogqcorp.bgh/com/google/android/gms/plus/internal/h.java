// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.plus.internal;

import android.os.Parcel;
import java.util.Arrays;
import com.google.android.gms.internal.gw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class h implements SafeParcelable
{
    public static final b CREATOR;
    private final int a;
    private final String b;
    private final String[] c;
    private final String[] d;
    private final String[] e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final PlusCommonExtras j;
    
    static {
        CREATOR = new b();
    }
    
    h(final int a, final String b, final String[] c, final String[] d, final String[] e, final String f, final String g, final String h, final String i, final PlusCommonExtras j) {
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
    }
    
    public int a() {
        return this.a;
    }
    
    public String b() {
        return this.b;
    }
    
    public String[] c() {
        return this.c;
    }
    
    public String[] d() {
        return this.d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public String[] e() {
        return this.e;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof h) {
            final h h = (h)o;
            if (this.a == h.a && gw.a(this.b, h.b) && Arrays.equals(this.c, h.c) && Arrays.equals(this.d, h.d) && Arrays.equals(this.e, h.e) && gw.a(this.f, h.f) && gw.a(this.g, h.g) && gw.a(this.h, h.h) && gw.a(this.i, h.i) && gw.a(this.j, h.j)) {
                return true;
            }
        }
        return false;
    }
    
    public String f() {
        return this.f;
    }
    
    public String g() {
        return this.g;
    }
    
    public String h() {
        return this.h;
    }
    
    @Override
    public int hashCode() {
        return gw.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
    }
    
    public String i() {
        return this.i;
    }
    
    public PlusCommonExtras j() {
        return this.j;
    }
    
    @Override
    public String toString() {
        return gw.a(this).a("versionCode", this.a).a("accountName", this.b).a("requestedScopes", this.c).a("visibleActivities", this.d).a("requiredFeatures", this.e).a("packageNameForAuth", this.f).a("callingPackageName", this.g).a("applicationName", this.h).a("extra", this.j.toString()).toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.plus.internal.b.a(this, parcel, n);
    }
}
