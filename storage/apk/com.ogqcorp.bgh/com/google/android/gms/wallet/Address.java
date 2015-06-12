// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public final class Address implements SafeParcelable
{
    public static final Parcelable$Creator<Address> CREATOR;
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    boolean j;
    String k;
    private final int l;
    
    static {
        CREATOR = (Parcelable$Creator)new a();
    }
    
    Address() {
        this.l = 1;
    }
    
    Address(final int l, final String a, final String b, final String c, final String d, final String e, final String f, final String g, final String h, final String i, final boolean j, final String k) {
        this.l = l;
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
    }
    
    public int a() {
        return this.l;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.wallet.a.a(this, parcel, n);
    }
}
