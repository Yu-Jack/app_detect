// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jp implements SafeParcelable
{
    public static final Parcelable$Creator<jp> CREATOR;
    int a;
    String b;
    double c;
    String d;
    long e;
    int f;
    private final int g;
    
    static {
        CREATOR = (Parcelable$Creator)new kc();
    }
    
    jp() {
        this.g = 1;
        this.f = -1;
        this.a = -1;
        this.c = -1.0;
    }
    
    jp(final int g, final int a, final String b, final double c, final String d, final long e, final int f) {
        this.g = g;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public int a() {
        return this.g;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        kc.a(this, parcel, n);
    }
}
