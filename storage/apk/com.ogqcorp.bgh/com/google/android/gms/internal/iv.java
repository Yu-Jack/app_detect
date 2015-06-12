// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class iv implements SafeParcelable
{
    public static final Parcelable$Creator<iv> CREATOR;
    int[] a;
    private final int b;
    
    static {
        CREATOR = (Parcelable$Creator)new jt();
    }
    
    iv() {
        this(1, null);
    }
    
    iv(final int b, final int[] a) {
        this.b = b;
        this.a = a;
    }
    
    public int a() {
        return this.b;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        jt.a(this, parcel, n);
    }
}
