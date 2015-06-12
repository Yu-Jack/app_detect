// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class UserAddress implements SafeParcelable
{
    public static final Parcelable$Creator<UserAddress> CREATOR;
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    String l;
    boolean m;
    String n;
    String o;
    private final int p;
    
    static {
        CREATOR = (Parcelable$Creator)new b();
    }
    
    UserAddress() {
        this.p = 1;
    }
    
    UserAddress(final int p16, final String a, final String b, final String c, final String d, final String e, final String f, final String g, final String h, final String i, final String j, final String k, final String l, final boolean m, final String n, final String o) {
        this.p = p16;
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
    
    public int a() {
        return this.p;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.identity.intents.model.b.a(this, parcel, n);
    }
}
