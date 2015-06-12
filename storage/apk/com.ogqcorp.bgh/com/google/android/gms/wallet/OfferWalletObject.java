// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class OfferWalletObject implements SafeParcelable
{
    public static final Parcelable$Creator<OfferWalletObject> CREATOR;
    String a;
    String b;
    private final int c;
    
    static {
        CREATOR = (Parcelable$Creator)new n();
    }
    
    OfferWalletObject() {
        this.c = 2;
    }
    
    OfferWalletObject(final int c, final String a, final String b) {
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
        n.a(this, parcel, n);
    }
}
