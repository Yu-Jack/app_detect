// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import java.util.ArrayList;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.List;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class l implements Parcelable$Creator<MaskedWalletRequest>
{
    static void a(final MaskedWalletRequest maskedWalletRequest, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, maskedWalletRequest.a());
        c.a(parcel, 2, maskedWalletRequest.a, false);
        c.a(parcel, 3, maskedWalletRequest.b);
        c.a(parcel, 4, maskedWalletRequest.c);
        c.a(parcel, 5, maskedWalletRequest.d);
        c.a(parcel, 6, maskedWalletRequest.e, false);
        c.a(parcel, 7, maskedWalletRequest.f, false);
        c.a(parcel, 8, maskedWalletRequest.g, false);
        c.a(parcel, 9, (Parcelable)maskedWalletRequest.h, n, false);
        c.a(parcel, 10, maskedWalletRequest.i);
        c.a(parcel, 11, maskedWalletRequest.j);
        c.a(parcel, 12, maskedWalletRequest.k, n, false);
        c.a(parcel, 13, maskedWalletRequest.l);
        c.a(parcel, 14, maskedWalletRequest.m);
        c.b(parcel, 15, maskedWalletRequest.n, false);
        c.a(parcel, a);
    }
    
    public MaskedWalletRequest a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        String n = null;
        boolean c = false;
        boolean c2 = false;
        boolean c3 = false;
        String n2 = null;
        String n3 = null;
        String n4 = null;
        Cart cart = null;
        boolean c4 = false;
        boolean c5 = false;
        com.google.android.gms.wallet.CountrySpecification[] array = null;
        boolean c6 = true;
        boolean c7 = true;
        ArrayList<CountrySpecification> c8 = null;
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
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 4: {
                    c2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 5: {
                    c3 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 6: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 7: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 8: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 9: {
                    cart = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, Cart.CREATOR);
                    continue;
                }
                case 10: {
                    c4 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 11: {
                    c5 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 12: {
                    array = com.google.android.gms.common.internal.safeparcel.a.b(parcel, a, com.google.android.gms.wallet.CountrySpecification.CREATOR);
                    continue;
                }
                case 13: {
                    c6 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 14: {
                    c7 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 15: {
                    c8 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, CountrySpecification.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new MaskedWalletRequest(g, n, c, c2, c3, n2, n3, n4, cart, c4, c5, array, c6, c7, c8);
    }
    
    public MaskedWalletRequest[] a(final int n) {
        return new MaskedWalletRequest[n];
    }
}
