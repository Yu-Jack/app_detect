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

public class f implements Parcelable$Creator<FullWallet>
{
    static void a(final FullWallet fullWallet, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, fullWallet.a());
        c.a(parcel, 2, fullWallet.a, false);
        c.a(parcel, 3, fullWallet.b, false);
        c.a(parcel, 4, (Parcelable)fullWallet.c, n, false);
        c.a(parcel, 5, fullWallet.d, false);
        c.a(parcel, 6, (Parcelable)fullWallet.e, n, false);
        c.a(parcel, 7, (Parcelable)fullWallet.f, n, false);
        c.a(parcel, 8, fullWallet.g, false);
        c.a(parcel, 9, (Parcelable)fullWallet.h, n, false);
        c.a(parcel, 10, (Parcelable)fullWallet.i, n, false);
        c.a(parcel, 11, fullWallet.j, n, false);
        c.a(parcel, a);
    }
    
    public FullWallet a(final Parcel parcel) {
        InstrumentInfo[] array = null;
        final int b = a.b(parcel);
        int g = 0;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        String[] z = null;
        Address address = null;
        Address address2 = null;
        String n = null;
        ProxyCard proxyCard = null;
        String n2 = null;
        String n3 = null;
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
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 4: {
                    proxyCard = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, ProxyCard.CREATOR);
                    continue;
                }
                case 5: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 6: {
                    address2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, Address.CREATOR);
                    continue;
                }
                case 7: {
                    address = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, Address.CREATOR);
                    continue;
                }
                case 8: {
                    z = com.google.android.gms.common.internal.safeparcel.a.z(parcel, a);
                    continue;
                }
                case 9: {
                    userAddress2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, UserAddress.CREATOR);
                    continue;
                }
                case 10: {
                    userAddress = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, UserAddress.CREATOR);
                    continue;
                }
                case 11: {
                    array = com.google.android.gms.common.internal.safeparcel.a.b(parcel, a, InstrumentInfo.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new FullWallet(g, n3, n2, proxyCard, n, address2, address, z, userAddress2, userAddress, array);
    }
    
    public FullWallet[] a(final int n) {
        return new FullWallet[n];
    }
}
