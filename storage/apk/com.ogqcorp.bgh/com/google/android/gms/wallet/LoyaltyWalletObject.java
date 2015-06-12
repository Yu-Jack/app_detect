// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.internal.hr;
import com.google.android.gms.internal.jo;
import com.google.android.gms.internal.js;
import com.google.android.gms.internal.jw;
import com.google.android.gms.internal.jm;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.internal.ju;
import com.google.android.gms.internal.jy;
import java.util.ArrayList;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LoyaltyWalletObject implements SafeParcelable
{
    public static final Parcelable$Creator<LoyaltyWalletObject> CREATOR;
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    int k;
    ArrayList<jy> l;
    ju m;
    ArrayList<LatLng> n;
    String o;
    String p;
    ArrayList<jm> q;
    boolean r;
    ArrayList<jw> s;
    ArrayList<js> t;
    ArrayList<jw> u;
    jo v;
    private final int w;
    
    static {
        CREATOR = (Parcelable$Creator)new j();
    }
    
    LoyaltyWalletObject() {
        this.w = 4;
        this.l = hr.a();
        this.n = hr.a();
        this.q = hr.a();
        this.s = hr.a();
        this.t = hr.a();
        this.u = hr.a();
    }
    
    LoyaltyWalletObject(final int w, final String a, final String b, final String c, final String d, final String e, final String f, final String g, final String h, final String i, final String j, final int k, final ArrayList<jy> l, final ju m, final ArrayList<LatLng> n, final String o, final String p23, final ArrayList<jm> q, final boolean r, final ArrayList<jw> s, final ArrayList<js> t, final ArrayList<jw> u, final jo v) {
        this.w = w;
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
        this.o = o;
        this.p = p23;
        this.q = q;
        this.r = r;
        this.s = s;
        this.t = t;
        this.u = u;
        this.v = v;
    }
    
    public int a() {
        return this.w;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.wallet.j.a(this, parcel, n);
    }
}
