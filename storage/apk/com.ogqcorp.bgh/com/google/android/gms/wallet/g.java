// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class g implements Parcelable$Creator<FullWalletRequest>
{
    static void a(final FullWalletRequest fullWalletRequest, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, fullWalletRequest.a());
        c.a(parcel, 2, fullWalletRequest.a, false);
        c.a(parcel, 3, fullWalletRequest.b, false);
        c.a(parcel, 4, (Parcelable)fullWalletRequest.c, n, false);
        c.a(parcel, a);
    }
    
    public FullWalletRequest a(final Parcel parcel) {
        Cart cart = null;
        final int b = a.b(parcel);
        int g = 0;
        String n = null;
        String n2 = null;
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
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 4: {
                    cart = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, Cart.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new FullWalletRequest(g, n2, n, cart);
    }
    
    public FullWalletRequest[] a(final int n) {
        return new FullWalletRequest[n];
    }
}
