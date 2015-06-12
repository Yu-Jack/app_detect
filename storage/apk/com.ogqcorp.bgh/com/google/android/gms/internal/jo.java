// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jo implements SafeParcelable
{
    public static final Parcelable$Creator<jo> CREATOR;
    String a;
    jp b;
    String c;
    ju d;
    private final int e;
    
    static {
        CREATOR = (Parcelable$Creator)new kd();
    }
    
    jo() {
        this.e = 1;
    }
    
    jo(final int e, final String a, final jp b, final String c, final ju d) {
        this.e = e;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public int a() {
        return this.e;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        kd.a(this, parcel, n);
    }
}
