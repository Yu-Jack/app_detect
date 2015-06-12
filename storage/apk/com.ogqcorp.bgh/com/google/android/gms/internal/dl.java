// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.List;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class dl implements Parcelable$Creator<cz>
{
    static void a(final cz cz, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, cz.a);
        c.a(parcel, 2, cz.b, false);
        c.a(parcel, 3, cz.c, false);
        c.a(parcel, 4, cz.d, false);
        c.a(parcel, 5, cz.e);
        c.a(parcel, 6, cz.f, false);
        c.a(parcel, 7, cz.g);
        c.a(parcel, 8, cz.h);
        c.a(parcel, 9, cz.i);
        c.a(parcel, 10, cz.j, false);
        c.a(parcel, 11, cz.k);
        c.a(parcel, 12, cz.l);
        c.a(parcel, 13, cz.m, false);
        c.a(parcel, 14, cz.n);
        c.a(parcel, 15, cz.o, false);
        c.a(parcel, 19, cz.q, false);
        c.a(parcel, 18, cz.p);
        c.a(parcel, 21, cz.r, false);
        c.a(parcel, a);
    }
    
    public cz a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        String n = null;
        String n2 = null;
        List<String> a = null;
        int g2 = 0;
        List<String> a2 = null;
        long i = 0L;
        boolean c = false;
        long j = 0L;
        List<String> a3 = null;
        long k = 0L;
        int g3 = 0;
        String n3 = null;
        long l = 0L;
        String n4 = null;
        boolean c2 = false;
        String n5 = null;
        String n6 = null;
        while (parcel.dataPosition() < b) {
            final int a4 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a4)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a4);
                    continue;
                }
                case 1: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a4);
                    continue;
                }
                case 2: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a4);
                    continue;
                }
                case 3: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a4);
                    continue;
                }
                case 4: {
                    a = com.google.android.gms.common.internal.safeparcel.a.A(parcel, a4);
                    continue;
                }
                case 5: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a4);
                    continue;
                }
                case 6: {
                    a2 = com.google.android.gms.common.internal.safeparcel.a.A(parcel, a4);
                    continue;
                }
                case 7: {
                    i = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a4);
                    continue;
                }
                case 8: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a4);
                    continue;
                }
                case 9: {
                    j = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a4);
                    continue;
                }
                case 10: {
                    a3 = com.google.android.gms.common.internal.safeparcel.a.A(parcel, a4);
                    continue;
                }
                case 11: {
                    k = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a4);
                    continue;
                }
                case 12: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a4);
                    continue;
                }
                case 13: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a4);
                    continue;
                }
                case 14: {
                    l = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a4);
                    continue;
                }
                case 15: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a4);
                    continue;
                }
                case 19: {
                    n5 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a4);
                    continue;
                }
                case 18: {
                    c2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a4);
                    continue;
                }
                case 21: {
                    n6 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a4);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new cz(g, n, n2, a, g2, a2, i, c, j, a3, k, g3, n3, l, n4, c2, n5, n6);
    }
    
    public cz[] a(final int n) {
        return new cz[n];
    }
}
