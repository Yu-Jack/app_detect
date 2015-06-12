// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class is implements Parcelable$Creator<hd>
{
    static void a(final hd hd, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, hd.f(), false);
        c.a(parcel, 1000, hd.a());
        c.a(parcel, 2, hd.g());
        c.a(parcel, 3, hd.b());
        c.a(parcel, 4, hd.c());
        c.a(parcel, 5, hd.d());
        c.a(parcel, 6, hd.e());
        c.a(parcel, 7, hd.h());
        c.a(parcel, 8, hd.i());
        c.a(parcel, 9, hd.j());
        c.a(parcel, a);
    }
    
    public hd a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        String n = null;
        int g2 = 0;
        short f = 0;
        double l = 0.0;
        double i = 0.0;
        float k = 0.0f;
        long j = 0L;
        int g3 = 0;
        int g4 = -1;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 1000: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    j = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 3: {
                    f = com.google.android.gms.common.internal.safeparcel.a.f(parcel, a);
                    continue;
                }
                case 4: {
                    l = com.google.android.gms.common.internal.safeparcel.a.l(parcel, a);
                    continue;
                }
                case 5: {
                    i = com.google.android.gms.common.internal.safeparcel.a.l(parcel, a);
                    continue;
                }
                case 6: {
                    k = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
                case 7: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 8: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 9: {
                    g4 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new hd(g, n, g2, f, l, i, k, j, g3, g4);
    }
    
    public hd[] a(final int n) {
        return new hd[n];
    }
}
