// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.identity.intents.model.UserAddress;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class MaskedWallet implements SafeParcelable
{
    public static final Parcelable$Creator<MaskedWallet> CREATOR;
    String a;
    String b;
    String[] c;
    String d;
    Address e;
    Address f;
    LoyaltyWalletObject[] g;
    OfferWalletObject[] h;
    UserAddress i;
    UserAddress j;
    InstrumentInfo[] k;
    private final int l;
    
    static {
        CREATOR = (Parcelable$Creator)new k();
    }
    
    private MaskedWallet() {
        this.l = 2;
    }
    
    MaskedWallet(final int l, final String a, final String b, final String[] c, final String d, final Address e, final Address f, final LoyaltyWalletObject[] g, final OfferWalletObject[] h, final UserAddress i, final UserAddress j, final InstrumentInfo[] k) {
        this.l = l;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
    }
    
    public int a() {
        return this.l;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.wallet.k.a(this, parcel, n);
    }
}
