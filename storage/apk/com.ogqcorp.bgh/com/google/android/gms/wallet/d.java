// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class d implements SafeParcelable
{
    public static final Parcelable$Creator<d> CREATOR;
    LoyaltyWalletObject a;
    private final int b;
    
    static {
        CREATOR = (Parcelable$Creator)new e();
    }
    
    d() {
        this.b = 1;
    }
    
    d(final int b, final LoyaltyWalletObject a) {
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
        e.a(this, parcel, n);
    }
}
