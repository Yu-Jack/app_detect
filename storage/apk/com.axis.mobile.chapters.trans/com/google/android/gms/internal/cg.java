// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.IBinder;
import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class cg implements Parcelable$Creator
{
    static void a(final ch ch, final Parcel parcel, final int n) {
        final int c = b.C(parcel);
        b.c(parcel, 1, ch.versionCode);
        b.a(parcel, 2, (Parcelable)ch.ov, n, false);
        b.a(parcel, 3, ch.aU(), false);
        b.a(parcel, 4, ch.aV(), false);
        b.a(parcel, 5, ch.aW(), false);
        b.a(parcel, 6, ch.aX(), false);
        b.a(parcel, 7, ch.oA, false);
        b.a(parcel, 8, ch.oB);
        b.a(parcel, 9, ch.oC, false);
        b.a(parcel, 10, ch.aZ(), false);
        b.c(parcel, 11, ch.orientation);
        b.c(parcel, 12, ch.oE);
        b.a(parcel, 13, ch.ob, false);
        b.a(parcel, 14, (Parcelable)ch.kQ, n, false);
        b.a(parcel, 15, ch.aY(), false);
        b.a(parcel, 17, (Parcelable)ch.oH, n, false);
        b.a(parcel, 16, ch.oG, false);
        b.G(parcel, c);
    }
    
    public ch f(final Parcel parcel) {
        final int b = a.B(parcel);
        int g = 0;
        ce ce = null;
        IBinder p = null;
        IBinder p2 = null;
        IBinder p3 = null;
        IBinder p4 = null;
        String o = null;
        boolean c = false;
        String o2 = null;
        IBinder p5 = null;
        int g2 = 0;
        int g3 = 0;
        String o3 = null;
        ev ev = null;
        IBinder p6 = null;
        String o4 = null;
        v v = null;
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
                    ce = (ce)com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (Parcelable$Creator)com.google.android.gms.internal.ce.CREATOR);
                    continue;
                }
                case 3: {
                    p = com.google.android.gms.common.internal.safeparcel.a.p(parcel, a);
                    continue;
                }
                case 4: {
                    p2 = com.google.android.gms.common.internal.safeparcel.a.p(parcel, a);
                    continue;
                }
                case 5: {
                    p3 = com.google.android.gms.common.internal.safeparcel.a.p(parcel, a);
                    continue;
                }
                case 6: {
                    p4 = com.google.android.gms.common.internal.safeparcel.a.p(parcel, a);
                    continue;
                }
                case 7: {
                    o = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 8: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 9: {
                    o2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 10: {
                    p5 = com.google.android.gms.common.internal.safeparcel.a.p(parcel, a);
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
                    o3 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 14: {
                    ev = (ev)com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (Parcelable$Creator)com.google.android.gms.internal.ev.CREATOR);
                    continue;
                }
                case 15: {
                    p6 = com.google.android.gms.common.internal.safeparcel.a.p(parcel, a);
                    continue;
                }
                case 17: {
                    v = (v)com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (Parcelable$Creator)com.google.android.gms.internal.v.CREATOR);
                    continue;
                }
                case 16: {
                    o4 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new a$a("Overread allowed size end=" + b, parcel);
        }
        return new ch(g, ce, p, p2, p3, p4, o, c, o2, p5, g2, g3, o3, ev, p6, o4, v);
    }
    
    public ch[] j(final int n) {
        return new ch[n];
    }
}
