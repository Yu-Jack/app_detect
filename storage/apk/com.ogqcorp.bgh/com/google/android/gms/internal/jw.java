// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jw implements SafeParcelable
{
    public static final Parcelable$Creator<jw> CREATOR;
    String a;
    String b;
    private final int c;
    
    static {
        CREATOR = (Parcelable$Creator)new kg();
    }
    
    jw() {
        this.c = 1;
    }
    
    jw(final int c, final String a, final String b) {
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
        kg.a(this, parcel, n);
    }
}
