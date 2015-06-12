// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class ad implements Parcelable$Creator<av>
{
    static void a(final av av, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, av.a);
        c.a(parcel, 2, av.b);
        c.a(parcel, 3, av.c);
        c.a(parcel, 4, av.d);
        c.a(parcel, 5, av.e);
        c.a(parcel, 6, av.f);
        c.a(parcel, 7, av.g);
        c.a(parcel, 8, av.h);
        c.a(parcel, 9, av.i);
        c.a(parcel, 10, av.j, false);
        c.a(parcel, 11, av.k);
        c.a(parcel, 12, av.l, false);
        c.a(parcel, 13, av.m);
        c.a(parcel, 14, av.n);
        c.a(parcel, 15, av.o, false);
        c.a(parcel, a);
    }
    
    public av a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        int g2 = 0;
        int g3 = 0;
        int g4 = 0;
        int g5 = 0;
        int g6 = 0;
        int g7 = 0;
        int g8 = 0;
        int g9 = 0;
        String n = null;
        int g10 = 0;
        String n2 = null;
        int g11 = 0;
        int g12 = 0;
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
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 11: {
                    g10 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 12: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
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
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new av(g, g2, g3, g4, g5, g6, g7, g8, g9, n, g10, n2, g11, g12, n3);
    }
    
    public av[] a(final int n) {
        return new av[n];
    }
}
