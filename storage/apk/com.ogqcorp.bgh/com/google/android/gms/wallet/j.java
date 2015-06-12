// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import java.util.ArrayList;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.jo;
import com.google.android.gms.internal.ju;
import com.google.android.gms.internal.hr;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.internal.jw;
import com.google.android.gms.internal.js;
import com.google.android.gms.internal.jm;
import com.google.android.gms.maps.model.LatLng;
import android.os.Parcelable;
import com.google.android.gms.internal.jy;
import java.util.List;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class j implements Parcelable$Creator<LoyaltyWalletObject>
{
    static void a(final LoyaltyWalletObject loyaltyWalletObject, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, loyaltyWalletObject.a());
        c.a(parcel, 2, loyaltyWalletObject.a, false);
        c.a(parcel, 3, loyaltyWalletObject.b, false);
        c.a(parcel, 4, loyaltyWalletObject.c, false);
        c.a(parcel, 5, loyaltyWalletObject.d, false);
        c.a(parcel, 6, loyaltyWalletObject.e, false);
        c.a(parcel, 7, loyaltyWalletObject.f, false);
        c.a(parcel, 8, loyaltyWalletObject.g, false);
        c.a(parcel, 9, loyaltyWalletObject.h, false);
        c.a(parcel, 10, loyaltyWalletObject.i, false);
        c.a(parcel, 11, loyaltyWalletObject.j, false);
        c.a(parcel, 12, loyaltyWalletObject.k);
        c.b(parcel, 13, loyaltyWalletObject.l, false);
        c.a(parcel, 14, (Parcelable)loyaltyWalletObject.m, n, false);
        c.b(parcel, 15, loyaltyWalletObject.n, false);
        c.a(parcel, 17, loyaltyWalletObject.p, false);
        c.a(parcel, 16, loyaltyWalletObject.o, false);
        c.a(parcel, 19, loyaltyWalletObject.r);
        c.b(parcel, 18, loyaltyWalletObject.q, false);
        c.b(parcel, 21, loyaltyWalletObject.t, false);
        c.b(parcel, 20, loyaltyWalletObject.s, false);
        c.a(parcel, 23, (Parcelable)loyaltyWalletObject.v, n, false);
        c.b(parcel, 22, loyaltyWalletObject.u, false);
        c.a(parcel, a);
    }
    
    public LoyaltyWalletObject a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        String n = null;
        String n2 = null;
        String n3 = null;
        String n4 = null;
        String n5 = null;
        String n6 = null;
        String n7 = null;
        String n8 = null;
        String n9 = null;
        String n10 = null;
        int g2 = 0;
        ArrayList<jy> list = hr.a();
        ju ju = null;
        ArrayList<LatLng> list2 = hr.a();
        String n11 = null;
        String n12 = null;
        ArrayList<jm> list3 = hr.a();
        boolean c = false;
        ArrayList<jw> list4 = hr.a();
        ArrayList<js> list5 = hr.a();
        ArrayList<jw> list6 = hr.a();
        jo jo = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 4: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 5: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 6: {
                    n5 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 7: {
                    n6 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 8: {
                    n7 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 9: {
                    n8 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 10: {
                    n9 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 11: {
                    n10 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 12: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 13: {
                    list = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, jy.CREATOR);
                    continue;
                }
                case 14: {
                    ju = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, com.google.android.gms.internal.ju.CREATOR);
                    continue;
                }
                case 15: {
                    list2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, (android.os.Parcelable$Creator<LatLng>)LatLng.CREATOR);
                    continue;
                }
                case 17: {
                    n12 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 16: {
                    n11 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 19: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 18: {
                    list3 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, jm.CREATOR);
                    continue;
                }
                case 21: {
                    list5 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, js.CREATOR);
                    continue;
                }
                case 20: {
                    list4 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, jw.CREATOR);
                    continue;
                }
                case 23: {
                    jo = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, com.google.android.gms.internal.jo.CREATOR);
                    continue;
                }
                case 22: {
                    list6 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, jw.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new LoyaltyWalletObject(g, n, n2, n3, n4, n5, n6, n7, n8, n9, n10, g2, list, ju, list2, n11, n12, list3, c, list4, list5, list6, jo);
    }
    
    public LoyaltyWalletObject[] a(final int n) {
        return new LoyaltyWalletObject[n];
    }
}
