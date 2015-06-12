// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class o implements Parcelable$Creator<ProxyCard>
{
    static void a(final ProxyCard proxyCard, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, proxyCard.a());
        c.a(parcel, 2, proxyCard.a, false);
        c.a(parcel, 3, proxyCard.b, false);
        c.a(parcel, 4, proxyCard.c);
        c.a(parcel, 5, proxyCard.d);
        c.a(parcel, a);
    }
    
    public ProxyCard a(final Parcel parcel) {
        String n = null;
        int g = 0;
        final int b = a.b(parcel);
        int g2 = 0;
        String n2 = null;
        int g3 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
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
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 5: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ProxyCard(g3, n2, n, g2, g);
    }
    
    public ProxyCard[] a(final int n) {
        return new ProxyCard[n];
    }
}
