// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class ax implements Parcelable$Creator
{
    static void a(final aw aw, final Parcel parcel, final int n) {
        final int c = b.C(parcel);
        b.c(parcel, 1, aw.versionCode);
        b.c(parcel, 2, aw.mD);
        b.c(parcel, 3, aw.backgroundColor);
        b.c(parcel, 4, aw.mE);
        b.c(parcel, 5, aw.mF);
        b.c(parcel, 6, aw.mG);
        b.c(parcel, 7, aw.mH);
        b.c(parcel, 8, aw.mI);
        b.c(parcel, 9, aw.mJ);
        b.a(parcel, 10, aw.mK, false);
        b.c(parcel, 11, aw.mL);
        b.a(parcel, 12, aw.mM, false);
        b.c(parcel, 13, aw.mN);
        b.c(parcel, 14, aw.mO);
        b.a(parcel, 15, aw.mP, false);
        b.G(parcel, c);
    }
    
    public aw d(final Parcel parcel) {
        final int b = a.B(parcel);
        int g = 0;
        int g2 = 0;
        int g3 = 0;
        int g4 = 0;
        int g5 = 0;
        int g6 = 0;
        int g7 = 0;
        int g8 = 0;
        int g9 = 0;
        String o = null;
        int g10 = 0;
        String o2 = null;
        int g11 = 0;
        int g12 = 0;
        String o3 = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 3: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 4: {
                    g4 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 5: {
                    g5 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 6: {
                    g6 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 7: {
                    g7 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 8: {
                    g8 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 9: {
                    g9 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 10: {
                    o = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 11: {
                    g10 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 12: {
                    o2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 13: {
                    g11 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 14: {
                    g12 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 15: {
                    o3 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new a$a("Overread allowed size end=" + b, parcel);
        }
        return new aw(g, g2, g3, g4, g5, g6, g7, g8, g9, o, g10, o2, g11, g12, o3);
    }
    
    public aw[] f(final int n) {
        return new aw[n];
    }
}
