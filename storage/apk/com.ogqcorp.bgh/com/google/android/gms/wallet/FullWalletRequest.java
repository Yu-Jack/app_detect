// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FullWalletRequest implements SafeParcelable
{
    public static final Parcelable$Creator<FullWalletRequest> CREATOR;
    String a;
    String b;
    Cart c;
    private final int d;
    
    static {
        CREATOR = (Parcelable$Creator)new g();
    }
    
    FullWalletRequest() {
        this.d = 1;
    }
    
    FullWalletRequest(final int d, final String a, final String b, final Cart c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int a() {
        return this.d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        g.a(this, parcel, n);
    }
}
