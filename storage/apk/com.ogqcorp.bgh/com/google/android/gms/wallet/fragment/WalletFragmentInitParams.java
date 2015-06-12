// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentInitParams implements SafeParcelable
{
    public static final Parcelable$Creator<WalletFragmentInitParams> CREATOR;
    final int a;
    private String b;
    private MaskedWalletRequest c;
    private int d;
    private MaskedWallet e;
    
    static {
        CREATOR = (Parcelable$Creator)new a();
    }
    
    private WalletFragmentInitParams() {
        this.a = 1;
        this.d = -1;
    }
    
    WalletFragmentInitParams(final int a, final String b, final MaskedWalletRequest c, final int d, final MaskedWallet e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public String a() {
        return this.b;
    }
    
    public MaskedWalletRequest b() {
        return this.c;
    }
    
    public int c() {
        return this.d;
    }
    
    public MaskedWallet d() {
        return this.e;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.wallet.fragment.a.a(this, parcel, n);
    }
}
