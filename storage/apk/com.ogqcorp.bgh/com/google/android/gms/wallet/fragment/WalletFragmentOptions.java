// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentOptions implements SafeParcelable
{
    public static final Parcelable$Creator<WalletFragmentOptions> CREATOR;
    final int a;
    private int b;
    private int c;
    private WalletFragmentStyle d;
    private int e;
    
    static {
        CREATOR = (Parcelable$Creator)new b();
    }
    
    private WalletFragmentOptions() {
        this.a = 1;
    }
    
    WalletFragmentOptions(final int a, final int b, final int c, final WalletFragmentStyle d, final int e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public int a() {
        return this.b;
    }
    
    public int b() {
        return this.c;
    }
    
    public WalletFragmentStyle c() {
        return this.d;
    }
    
    public int d() {
        return this.e;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.wallet.fragment.b.a(this, parcel, n);
    }
}
