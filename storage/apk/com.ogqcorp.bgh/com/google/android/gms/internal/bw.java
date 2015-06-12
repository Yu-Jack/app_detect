// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.IBinder;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class bw implements Parcelable$Creator<ce>
{
    static void a(final ce ce, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, ce.a);
        c.a(parcel, 2, (Parcelable)ce.b, n, false);
        c.a(parcel, 3, ce.a(), false);
        c.a(parcel, 4, ce.b(), false);
        c.a(parcel, 5, ce.c(), false);
        c.a(parcel, 6, ce.d(), false);
        c.a(parcel, 7, ce.g, false);
        c.a(parcel, 8, ce.h);
        c.a(parcel, 9, ce.i, false);
        c.a(parcel, 10, ce.f(), false);
        c.a(parcel, 11, ce.k);
        c.a(parcel, 12, ce.l);
        c.a(parcel, 13, ce.m, false);
        c.a(parcel, 14, (Parcelable)ce.n, n, false);
        c.a(parcel, 15, ce.e(), false);
        c.a(parcel, 16, ce.p, false);
        c.a(parcel, a);
    }
    
    public ce a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        cb cb = null;
        IBinder o = null;
        IBinder o2 = null;
        IBinder o3 = null;
        IBinder o4 = null;
        String n = null;
        boolean c = false;
        String n2 = null;
        IBinder o5 = null;
        int g2 = 0;
        int g3 = 0;
        String n3 = null;
        dx dx = null;
        IBinder o6 = null;
        String n4 = null;
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
                    cb = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<cb>)com.google.android.gms.internal.cb.CREATOR);
                    continue;
                }
                case 3: {
                    o = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 4: {
                    o2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 5: {
                    o3 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 6: {
                    o4 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 7: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 8: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 9: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 10: {
                    o5 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 11: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 12: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 13: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 14: {
                    dx = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<dx>)com.google.android.gms.internal.dx.CREATOR);
                    continue;
                }
                case 15: {
                    o6 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 16: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ce(g, cb, o, o2, o3, o4, n, c, n2, o5, g2, g3, n3, dx, o6, n4);
    }
    
    public ce[] a(final int n) {
        return new ce[n];
    }
}
