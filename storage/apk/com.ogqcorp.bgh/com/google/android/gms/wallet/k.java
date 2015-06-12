// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class k implements Parcelable$Creator<MaskedWallet>
{
    static void a(final MaskedWallet maskedWallet, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, maskedWallet.a());
        c.a(parcel, 2, maskedWallet.a, false);
        c.a(parcel, 3, maskedWallet.b, false);
        c.a(parcel, 4, maskedWallet.c, false);
        c.a(parcel, 5, maskedWallet.d, false);
        c.a(parcel, 6, (Parcelable)maskedWallet.e, n, false);
        c.a(parcel, 7, (Parcelable)maskedWallet.f, n, false);
        c.a(parcel, 8, maskedWallet.g, n, false);
        c.a(parcel, 9, maskedWallet.h, n, false);
        c.a(parcel, 10, (Parcelable)maskedWallet.i, n, false);
        c.a(parcel, 11, (Parcelable)maskedWallet.j, n, false);
        c.a(parcel, 12, maskedWallet.k, n, false);
        c.a(parcel, a);
    }
    
    public MaskedWallet a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        String n = null;
        String n2 = null;
        String[] z = null;
        String n3 = null;
        Address address = null;
        Address address2 = null;
        LoyaltyWalletObject[] array = null;
        OfferWalletObject[] array2 = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] array3 = null;
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
                    z = com.google.android.gms.common.internal.safeparcel.a.z(parcel, a);
                    continue;
                }
                case 5: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 6: {
                    address = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, Address.CREATOR);
                    continue;
                }
                case 7: {
                    address2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, Address.CREATOR);
                    continue;
                }
                case 8: {
                    array = com.google.android.gms.common.internal.safeparcel.a.b(parcel, a, LoyaltyWalletObject.CREATOR);
                    continue;
                }
                case 9: {
                    array2 = com.google.android.gms.common.internal.safeparcel.a.b(parcel, a, OfferWalletObject.CREATOR);
                    continue;
                }
                case 10: {
                    userAddress = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, UserAddress.CREATOR);
                    continue;
                }
                case 11: {
                    userAddress2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, UserAddress.CREATOR);
                    continue;
                }
                case 12: {
                    array3 = com.google.android.gms.common.internal.safeparcel.a.b(parcel, a, InstrumentInfo.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new MaskedWallet(g, n, n2, z, n3, address, address2, array, array2, userAddress, userAddress2, array3);
    }
    
    public MaskedWallet[] a(final int n) {
        return new MaskedWallet[n];
    }
}
