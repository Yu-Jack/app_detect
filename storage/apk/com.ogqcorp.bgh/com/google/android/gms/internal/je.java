// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.List;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Set;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class je implements Parcelable$Creator<ih>
{
    static void a(final ih ih, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        final Set<Integer> e = ih.e();
        if (e.contains(1)) {
            c.a(parcel, 1, ih.f());
        }
        if (e.contains(2)) {
            c.a(parcel, 2, ih.g(), true);
        }
        if (e.contains(3)) {
            c.a(parcel, 3, (Parcelable)ih.h(), n, true);
        }
        if (e.contains(4)) {
            c.a(parcel, 4, ih.i(), true);
        }
        if (e.contains(5)) {
            c.a(parcel, 5, ih.j(), true);
        }
        if (e.contains(6)) {
            c.a(parcel, 6, ih.k());
        }
        if (e.contains(7)) {
            c.a(parcel, 7, (Parcelable)ih.l(), n, true);
        }
        if (e.contains(8)) {
            c.a(parcel, 8, ih.m(), true);
        }
        if (e.contains(9)) {
            c.a(parcel, 9, ih.n(), true);
        }
        if (e.contains(12)) {
            c.a(parcel, 12, ih.o());
        }
        if (e.contains(14)) {
            c.a(parcel, 14, ih.p(), true);
        }
        if (e.contains(15)) {
            c.a(parcel, 15, (Parcelable)ih.q(), n, true);
        }
        if (e.contains(16)) {
            c.a(parcel, 16, ih.r());
        }
        if (e.contains(19)) {
            c.a(parcel, 19, (Parcelable)ih.t(), n, true);
        }
        if (e.contains(18)) {
            c.a(parcel, 18, ih.s(), true);
        }
        if (e.contains(21)) {
            c.a(parcel, 21, ih.v());
        }
        if (e.contains(20)) {
            c.a(parcel, 20, ih.u(), true);
        }
        if (e.contains(23)) {
            c.b(parcel, 23, ih.x(), true);
        }
        if (e.contains(22)) {
            c.b(parcel, 22, ih.w(), true);
        }
        if (e.contains(25)) {
            c.a(parcel, 25, ih.z());
        }
        if (e.contains(24)) {
            c.a(parcel, 24, ih.y());
        }
        if (e.contains(27)) {
            c.a(parcel, 27, ih.B(), true);
        }
        if (e.contains(26)) {
            c.a(parcel, 26, ih.A(), true);
        }
        if (e.contains(29)) {
            c.a(parcel, 29, ih.D());
        }
        if (e.contains(28)) {
            c.b(parcel, 28, ih.C(), true);
        }
        c.a(parcel, a);
    }
    
    public ih a(final Parcel parcel) {
        final int b = a.b(parcel);
        final HashSet<Integer> set = new HashSet<Integer>();
        int g = 0;
        String n = null;
        ih$a ih$a = null;
        String n2 = null;
        String n3 = null;
        int g2 = 0;
        ih$b ih$b = null;
        String n4 = null;
        String n5 = null;
        int g3 = 0;
        String n6 = null;
        ih$c ih$c = null;
        boolean c = false;
        String n7 = null;
        ih$d ih$d = null;
        String n8 = null;
        int g4 = 0;
        List<ih$f> c2 = null;
        List<ih$g> c3 = null;
        int g5 = 0;
        int g6 = 0;
        String n9 = null;
        String n10 = null;
        List<ih$h> c4 = null;
        boolean c5 = false;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    set.add(1);
                    continue;
                }
                case 2: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(2);
                    continue;
                }
                case 3: {
                    final ih$a ih$a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<ih$a>)com.google.android.gms.internal.ih$a.CREATOR);
                    set.add(3);
                    ih$a = ih$a2;
                    continue;
                }
                case 4: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(4);
                    continue;
                }
                case 5: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(5);
                    continue;
                }
                case 6: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    set.add(6);
                    continue;
                }
                case 7: {
                    final ih$b ih$b2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<ih$b>)com.google.android.gms.internal.ih$b.CREATOR);
                    set.add(7);
                    ih$b = ih$b2;
                    continue;
                }
                case 8: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(8);
                    continue;
                }
                case 9: {
                    n5 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(9);
                    continue;
                }
                case 12: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    set.add(12);
                    continue;
                }
                case 14: {
                    n6 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(14);
                    continue;
                }
                case 15: {
                    final ih$c ih$c2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<ih$c>)com.google.android.gms.internal.ih$c.CREATOR);
                    set.add(15);
                    ih$c = ih$c2;
                    continue;
                }
                case 16: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    set.add(16);
                    continue;
                }
                case 19: {
                    final ih$d ih$d2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<ih$d>)com.google.android.gms.internal.ih$d.CREATOR);
                    set.add(19);
                    ih$d = ih$d2;
                    continue;
                }
                case 18: {
                    n7 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(18);
                    continue;
                }
                case 21: {
                    g4 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    set.add(21);
                    continue;
                }
                case 20: {
                    n8 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(20);
                    continue;
                }
                case 23: {
                    c3 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, (android.os.Parcelable$Creator<ih$g>)ih$g.CREATOR);
                    set.add(23);
                    continue;
                }
                case 22: {
                    c2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, (android.os.Parcelable$Creator<ih$f>)ih$f.CREATOR);
                    set.add(22);
                    continue;
                }
                case 25: {
                    g6 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    set.add(25);
                    continue;
                }
                case 24: {
                    g5 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    set.add(24);
                    continue;
                }
                case 27: {
                    n10 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(27);
                    continue;
                }
                case 26: {
                    n9 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(26);
                    continue;
                }
                case 29: {
                    c5 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    set.add(29);
                    continue;
                }
                case 28: {
                    c4 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, (android.os.Parcelable$Creator<ih$h>)ih$h.CREATOR);
                    set.add(28);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ih(set, g, n, ih$a, n2, n3, g2, ih$b, n4, n5, g3, n6, ih$c, c, n7, ih$d, n8, g4, c2, c3, g5, g6, n9, n10, c4, c5);
    }
    
    public ih[] a(final int n) {
        return new ih[n];
    }
}
