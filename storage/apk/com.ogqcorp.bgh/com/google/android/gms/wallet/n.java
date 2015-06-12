// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class n implements Parcelable$Creator<OfferWalletObject>
{
    static void a(final OfferWalletObject offerWalletObject, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, offerWalletObject.a());
        c.a(parcel, 2, offerWalletObject.a, false);
        c.a(parcel, 3, offerWalletObject.b, false);
        c.a(parcel, a);
    }
    
    public OfferWalletObject a(final Parcel parcel) {
        String n = null;
        final int b = a.b(parcel);
        int g = 0;
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
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new OfferWalletObject(g, n2, n);
    }
    
    public OfferWalletObject[] a(final int n) {
        return new OfferWalletObject[n];
    }
}
