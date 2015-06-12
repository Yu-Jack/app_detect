// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ix implements SafeParcelable
{
    public static final Parcelable$Creator<ix> CREATOR;
    String[] a;
    byte[][] b;
    private final int c;
    
    static {
        CREATOR = (Parcelable$Creator)new jv();
    }
    
    ix() {
        this(1, new String[0], new byte[0][]);
    }
    
    ix(final int c, final String[] a, final byte[][] b) {
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
        jv.a(this, parcel, n);
    }
}
