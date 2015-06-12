// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class InstrumentInfo implements SafeParcelable
{
    public static final Parcelable$Creator<InstrumentInfo> CREATOR;
    private final int a;
    private String b;
    private String c;
    
    static {
        CREATOR = (Parcelable$Creator)new h();
    }
    
    InstrumentInfo(final int a, final String b, final String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int a() {
        return this.a;
    }
    
    public String b() {
        return this.b;
    }
    
    public String c() {
        return this.c;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        h.a(this, parcel, n);
    }
}
