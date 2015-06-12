// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import android.os.Parcel;
import java.util.ArrayList;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class MaskedWalletRequest implements SafeParcelable
{
    public static final Parcelable$Creator<MaskedWalletRequest> CREATOR;
    String a;
    boolean b;
    boolean c;
    boolean d;
    String e;
    String f;
    String g;
    Cart h;
    boolean i;
    boolean j;
    CountrySpecification[] k;
    boolean l;
    boolean m;
    ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> n;
    private final int o;
    
    static {
        CREATOR = (Parcelable$Creator)new l();
    }
    
    MaskedWalletRequest() {
        this.o = 3;
        this.l = true;
        this.m = true;
    }
    
    MaskedWalletRequest(final int o, final String a, final boolean b, final boolean c, final boolean d, final String e, final String f, final String g, final Cart h, final boolean i, final boolean j, final CountrySpecification[] k, final boolean l, final boolean m, final ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> n) {
        this.o = o;
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
        this.l = l;
        this.m = m;
        this.n = n;
    }
    
    public int a() {
        return this.o;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.wallet.l.a(this, parcel, n);
    }
}
