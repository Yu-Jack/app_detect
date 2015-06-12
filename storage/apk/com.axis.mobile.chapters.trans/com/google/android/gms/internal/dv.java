// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.List;
import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class dv implements Parcelable$Creator
{
    static void a(final du du, final Parcel parcel, final int n) {
        final int c = b.C(parcel);
        b.c(parcel, 1, du.versionCode);
        b.a(parcel, 2, du.oA, false);
        b.a(parcel, 3, du.qe, false);
        b.a(parcel, 4, du.nt, false);
        b.c(parcel, 5, du.errorCode);
        b.a(parcel, 6, du.nu, false);
        b.a(parcel, 7, du.qf);
        b.a(parcel, 8, du.qg);
        b.a(parcel, 9, du.qh);
        b.a(parcel, 10, du.qi, false);
        b.a(parcel, 11, du.nx);
        b.c(parcel, 12, du.orientation);
        b.a(parcel, 13, du.qj, false);
        b.a(parcel, 14, du.qk);
        b.a(parcel, 15, du.ql, false);
        b.a(parcel, 19, du.qn, false);
        b.a(parcel, 18, du.qm);
        b.a(parcel, 21, du.qo, false);
        b.G(parcel, c);
    }
    
    public du i(final Parcel parcel) {
        final int b = a.B(parcel);
        int g = 0;
        String o = null;
        String o2 = null;
        List b2 = null;
        int g2 = 0;
        List b3 = null;
        long i = 0L;
        boolean c = false;
        long j = 0L;
        List b4 = null;
        long k = 0L;
        int g3 = 0;
        String o3 = null;
        long l = 0L;
        String o4 = null;
        boolean c2 = false;
        String o5 = null;
        String o6 = null;
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
                    o = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 3: {
                    o2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 4: {
                    b2 = com.google.android.gms.common.internal.safeparcel.a.B(parcel, a);
                    continue;
                }
                case 5: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 6: {
                    b3 = com.google.android.gms.common.internal.safeparcel.a.B(parcel, a);
                    continue;
                }
                case 7: {
                    i = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 8: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 9: {
                    j = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 10: {
                    b4 = com.google.android.gms.common.internal.safeparcel.a.B(parcel, a);
                    continue;
                }
                case 11: {
                    k = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 12: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 13: {
                    o3 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 14: {
                    l = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 15: {
                    o4 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 19: {
                    o5 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 18: {
                    c2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 21: {
                    o6 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new a$a("Overread allowed size end=" + b, parcel);
        }
        return new du(g, o, o2, b2, g2, b3, i, c, j, b4, k, g3, o3, l, o4, c2, o5, o6);
    }
    
    public du[] n(final int n) {
        return new du[n];
    }
}
