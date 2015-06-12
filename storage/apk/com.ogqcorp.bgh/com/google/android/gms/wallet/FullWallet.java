// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.identity.intents.model.UserAddress;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FullWallet implements SafeParcelable
{
    public static final Parcelable$Creator<FullWallet> CREATOR;
    String a;
    String b;
    ProxyCard c;
    String d;
    Address e;
    Address f;
    String[] g;
    UserAddress h;
    UserAddress i;
    InstrumentInfo[] j;
    private final int k;
    
    static {
        CREATOR = (Parcelable$Creator)new f();
    }
    
    private FullWallet() {
        this.k = 1;
    }
    
    FullWallet(final int k, final String a, final String b, final ProxyCard c, final String d, final Address e, final Address f, final String[] g, final UserAddress h, final UserAddress i, final InstrumentInfo[] j) {
        this.k = k;
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
    }
    
    public int a() {
        return this.k;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.wallet.f.a(this, parcel, n);
    }
}
