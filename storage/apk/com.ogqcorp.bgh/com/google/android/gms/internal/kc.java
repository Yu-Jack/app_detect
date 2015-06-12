// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class kc implements Parcelable$Creator<jp>
{
    static void a(final jp jp, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, jp.a());
        c.a(parcel, 2, jp.a);
        c.a(parcel, 3, jp.b, false);
        c.a(parcel, 4, jp.c);
        c.a(parcel, 5, jp.d, false);
        c.a(parcel, 6, jp.e);
        c.a(parcel, 7, jp.f);
        c.a(parcel, a);
    }
    
    public jp a(final Parcel parcel) {
        String n = null;
        int g = 0;
        final int b = a.b(parcel);
        double l = 0.0;
        long i = 0L;
        int g2 = -1;
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
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 3: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 4: {
                    l = com.google.android.gms.common.internal.safeparcel.a.l(parcel, a);
                    continue;
                }
                case 5: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 6: {
                    i = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 7: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new jp(g3, g, n2, l, n, i, g2);
    }
    
    public jp[] a(final int n) {
        return new jp[n];
    }
}
