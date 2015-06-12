// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jy implements SafeParcelable
{
    public static final Parcelable$Creator<jy> CREATOR;
    String a;
    String b;
    ju c;
    jw d;
    jw e;
    private final int f;
    
    static {
        CREATOR = (Parcelable$Creator)new kh();
    }
    
    jy() {
        this.f = 1;
    }
    
    jy(final int f, final String a, final String b, final ju c, final jw d, final jw e) {
        this.f = f;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public int a() {
        return this.f;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        kh.a(this, parcel, n);
    }
}
