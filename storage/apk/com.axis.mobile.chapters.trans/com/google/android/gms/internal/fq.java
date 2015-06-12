// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class fq implements Parcelable$Creator
{
    static void a(final fp fp, final Parcel parcel, final int n) {
        final int c = b.C(parcel);
        b.a(parcel, 1, fp.name, false);
        b.c(parcel, 1000, fp.xM);
        b.a(parcel, 2, fp.yb, false);
        b.a(parcel, 3, fp.yc);
        b.c(parcel, 4, fp.weight);
        b.a(parcel, 5, fp.yd);
        b.a(parcel, 6, fp.ye, false);
        b.a(parcel, 7, (Parcelable[])fp.yf, n, false);
        b.a(parcel, 8, fp.yg, false);
        b.a(parcel, 11, fp.yh, false);
        b.G(parcel, c);
    }
    
    public fp[] J(final int n) {
        return new fp[n];
    }
    
    public fp p(final Parcel parcel) {
        boolean c = false;
        String o = null;
        final int b = a.B(parcel);
        int g = 1;
        int[] u = null;
        fm[] array = null;
        String o2 = null;
        boolean c2 = false;
        String o3 = null;
        String o4 = null;
        int g2 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    o4 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 1000: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    o3 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 3: {
                    c2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 4: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 5: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 6: {
                    o2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 7: {
                    array = (fm[])com.google.android.gms.common.internal.safeparcel.a.b(parcel, a, (Parcelable$Creator)fm.CREATOR);
                    continue;
                }
                case 8: {
                    u = com.google.android.gms.common.internal.safeparcel.a.u(parcel, a);
                    continue;
                }
                case 11: {
                    o = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new a$a("Overread allowed size end=" + b, parcel);
        }
        return new fp(g2, o4, o3, c2, g, c, o2, array, u, o);
    }
}
