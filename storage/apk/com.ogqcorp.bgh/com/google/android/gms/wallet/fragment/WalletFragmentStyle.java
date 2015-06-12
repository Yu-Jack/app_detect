// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentStyle implements SafeParcelable
{
    public static final Parcelable$Creator<WalletFragmentStyle> CREATOR;
    final int a;
    Bundle b;
    int c;
    
    static {
        CREATOR = (Parcelable$Creator)new c();
    }
    
    public WalletFragmentStyle() {
        this.a = 1;
        this.b = new Bundle();
    }
    
    WalletFragmentStyle(final int a, final Bundle b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.wallet.fragment.c.a(this, parcel, n);
    }
}
