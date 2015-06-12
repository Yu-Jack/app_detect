// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ju implements SafeParcelable
{
    public static final Parcelable$Creator<ju> CREATOR;
    long a;
    long b;
    private final int c;
    
    static {
        CREATOR = (Parcelable$Creator)new kf();
    }
    
    ju() {
        this.c = 1;
    }
    
    ju(final int c, final long a, final long b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public int a() {
        return this.c;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        kf.a(this, parcel, n);
    }
}
