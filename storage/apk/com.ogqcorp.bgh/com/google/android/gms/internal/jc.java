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

public class jc implements Parcelable$Creator<ic>
{
    static void a(final ic ic, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        final Set<Integer> e = ic.e();
        if (e.contains(1)) {
            c.a(parcel, 1, ic.f());
        }
        if (e.contains(2)) {
            c.a(parcel, 2, (Parcelable)ic.g(), n, true);
        }
        if (e.contains(3)) {
            c.a(parcel, 3, ic.h(), true);
        }
        if (e.contains(4)) {
            c.a(parcel, 4, (Parcelable)ic.i(), n, true);
        }
        if (e.contains(5)) {
            c.a(parcel, 5, ic.j(), true);
        }
        if (e.contains(6)) {
            c.a(parcel, 6, ic.k(), true);
        }
        if (e.contains(7)) {
            c.a(parcel, 7, ic.l(), true);
        }
        if (e.contains(8)) {
            c.b(parcel, 8, ic.m(), true);
        }
        if (e.contains(9)) {
            c.a(parcel, 9, ic.n());
        }
        if (e.contains(10)) {
            c.b(parcel, 10, ic.o(), true);
        }
        if (e.contains(11)) {
            c.a(parcel, 11, (Parcelable)ic.p(), n, true);
        }
        if (e.contains(12)) {
            c.b(parcel, 12, ic.q(), true);
        }
        if (e.contains(13)) {
            c.a(parcel, 13, ic.r(), true);
        }
        if (e.contains(14)) {
            c.a(parcel, 14, ic.s(), true);
        }
        if (e.contains(15)) {
            c.a(parcel, 15, (Parcelable)ic.t(), n, true);
        }
        if (e.contains(17)) {
            c.a(parcel, 17, ic.v(), true);
        }
        if (e.contains(16)) {
            c.a(parcel, 16, ic.u(), true);
        }
        if (e.contains(19)) {
            c.b(parcel, 19, ic.x(), true);
        }
        if (e.contains(18)) {
            c.a(parcel, 18, ic.w(), true);
        }
        if (e.contains(21)) {
            c.a(parcel, 21, ic.z(), true);
        }
        if (e.contains(20)) {
            c.a(parcel, 20, ic.y(), true);
        }
        if (e.contains(23)) {
            c.a(parcel, 23, ic.B(), true);
        }
        if (e.contains(22)) {
            c.a(parcel, 22, ic.A(), true);
        }
        if (e.contains(25)) {
            c.a(parcel, 25, ic.D(), true);
        }
        if (e.contains(24)) {
            c.a(parcel, 24, ic.C(), true);
        }
        if (e.contains(27)) {
            c.a(parcel, 27, ic.F(), true);
        }
        if (e.contains(26)) {
            c.a(parcel, 26, ic.E(), true);
        }
        if (e.contains(29)) {
            c.a(parcel, 29, (Parcelable)ic.H(), n, true);
        }
        if (e.contains(28)) {
            c.a(parcel, 28, ic.G(), true);
        }
        if (e.contains(31)) {
            c.a(parcel, 31, ic.J(), true);
        }
        if (e.contains(30)) {
            c.a(parcel, 30, ic.I(), true);
        }
        if (e.contains(34)) {
            c.a(parcel, 34, (Parcelable)ic.M(), n, true);
        }
        if (e.contains(32)) {
            c.a(parcel, 32, ic.K(), true);
        }
        if (e.contains(33)) {
            c.a(parcel, 33, ic.L(), true);
        }
        if (e.contains(38)) {
            c.a(parcel, 38, ic.P());
        }
        if (e.contains(39)) {
            c.a(parcel, 39, ic.Q(), true);
        }
        if (e.contains(36)) {
            c.a(parcel, 36, ic.N());
        }
        if (e.contains(37)) {
            c.a(parcel, 37, (Parcelable)ic.O(), n, true);
        }
        if (e.contains(42)) {
            c.a(parcel, 42, ic.T(), true);
        }
        if (e.contains(43)) {
            c.a(parcel, 43, ic.U(), true);
        }
        if (e.contains(40)) {
            c.a(parcel, 40, (Parcelable)ic.R(), n, true);
        }
        if (e.contains(41)) {
            c.b(parcel, 41, ic.S(), true);
        }
        if (e.contains(46)) {
            c.a(parcel, 46, (Parcelable)ic.X(), n, true);
        }
        if (e.contains(47)) {
            c.a(parcel, 47, ic.Y(), true);
        }
        if (e.contains(44)) {
            c.a(parcel, 44, ic.V(), true);
        }
        if (e.contains(45)) {
            c.a(parcel, 45, ic.W(), true);
        }
        if (e.contains(51)) {
            c.a(parcel, 51, ic.ac(), true);
        }
        if (e.contains(50)) {
            c.a(parcel, 50, (Parcelable)ic.ab(), n, true);
        }
        if (e.contains(49)) {
            c.a(parcel, 49, ic.aa(), true);
        }
        if (e.contains(48)) {
            c.a(parcel, 48, ic.Z(), true);
        }
        if (e.contains(55)) {
            c.a(parcel, 55, ic.ag(), true);
        }
        if (e.contains(54)) {
            c.a(parcel, 54, ic.af(), true);
        }
        if (e.contains(53)) {
            c.a(parcel, 53, ic.ae(), true);
        }
        if (e.contains(52)) {
            c.a(parcel, 52, ic.ad(), true);
        }
        if (e.contains(56)) {
            c.a(parcel, 56, ic.ah(), true);
        }
        c.a(parcel, a);
    }
    
    public ic a(final Parcel parcel) {
        final int b = a.b(parcel);
        final HashSet<Integer> set = new HashSet<Integer>();
        int g = 0;
        ic ic = null;
        List<String> a = null;
        ic ic2 = null;
        String n = null;
        String n2 = null;
        String n3 = null;
        List<ic> c = null;
        int g2 = 0;
        List<ic> c2 = null;
        ic ic3 = null;
        List<ic> c3 = null;
        String n4 = null;
        String n5 = null;
        ic ic4 = null;
        String n6 = null;
        String n7 = null;
        String n8 = null;
        List<ic> c4 = null;
        String n9 = null;
        String n10 = null;
        String n11 = null;
        String n12 = null;
        String n13 = null;
        String n14 = null;
        String n15 = null;
        String n16 = null;
        String n17 = null;
        ic ic5 = null;
        String n18 = null;
        String n19 = null;
        String n20 = null;
        String n21 = null;
        ic ic6 = null;
        double l = 0.0;
        ic ic7 = null;
        double i = 0.0;
        String n22 = null;
        ic ic8 = null;
        List<ic> c5 = null;
        String n23 = null;
        String n24 = null;
        String n25 = null;
        String n26 = null;
        ic ic9 = null;
        String n27 = null;
        String n28 = null;
        String n29 = null;
        ic ic10 = null;
        String n30 = null;
        String n31 = null;
        String n32 = null;
        String n33 = null;
        String n34 = null;
        String n35 = null;
        while (parcel.dataPosition() < b) {
            final int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a2)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a2);
                    continue;
                }
                case 1: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a2);
                    set.add(1);
                    continue;
                }
                case 2: {
                    final ic ic11 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a2, (android.os.Parcelable$Creator<ic>)com.google.android.gms.internal.ic.CREATOR);
                    set.add(2);
                    ic = ic11;
                    continue;
                }
                case 3: {
                    a = com.google.android.gms.common.internal.safeparcel.a.A(parcel, a2);
                    set.add(3);
                    continue;
                }
                case 4: {
                    final ic ic12 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a2, (android.os.Parcelable$Creator<ic>)com.google.android.gms.internal.ic.CREATOR);
                    set.add(4);
                    ic2 = ic12;
                    continue;
                }
                case 5: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(5);
                    continue;
                }
                case 6: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(6);
                    continue;
                }
                case 7: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(7);
                    continue;
                }
                case 8: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a2, (android.os.Parcelable$Creator<ic>)com.google.android.gms.internal.ic.CREATOR);
                    set.add(8);
                    continue;
                }
                case 9: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a2);
                    set.add(9);
                    continue;
                }
                case 10: {
                    c2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a2, (android.os.Parcelable$Creator<ic>)com.google.android.gms.internal.ic.CREATOR);
                    set.add(10);
                    continue;
                }
                case 11: {
                    final ic ic13 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a2, (android.os.Parcelable$Creator<ic>)com.google.android.gms.internal.ic.CREATOR);
                    set.add(11);
                    ic3 = ic13;
                    continue;
                }
                case 12: {
                    c3 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a2, (android.os.Parcelable$Creator<ic>)com.google.android.gms.internal.ic.CREATOR);
                    set.add(12);
                    continue;
                }
                case 13: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(13);
                    continue;
                }
                case 14: {
                    n5 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(14);
                    continue;
                }
                case 15: {
                    final ic ic14 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a2, (android.os.Parcelable$Creator<ic>)com.google.android.gms.internal.ic.CREATOR);
                    set.add(15);
                    ic4 = ic14;
                    continue;
                }
                case 17: {
                    n7 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(17);
                    continue;
                }
                case 16: {
                    n6 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(16);
                    continue;
                }
                case 19: {
                    c4 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a2, (android.os.Parcelable$Creator<ic>)com.google.android.gms.internal.ic.CREATOR);
                    set.add(19);
                    continue;
                }
                case 18: {
                    n8 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(18);
                    continue;
                }
                case 21: {
                    n10 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(21);
                    continue;
                }
                case 20: {
                    n9 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(20);
                    continue;
                }
                case 23: {
                    n12 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(23);
                    continue;
                }
                case 22: {
                    n11 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(22);
                    continue;
                }
                case 25: {
                    n14 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(25);
                    continue;
                }
                case 24: {
                    n13 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(24);
                    continue;
                }
                case 27: {
                    n16 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(27);
                    continue;
                }
                case 26: {
                    n15 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(26);
                    continue;
                }
                case 29: {
                    final ic ic15 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a2, (android.os.Parcelable$Creator<ic>)com.google.android.gms.internal.ic.CREATOR);
                    set.add(29);
                    ic5 = ic15;
                    continue;
                }
                case 28: {
                    n17 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(28);
                    continue;
                }
                case 31: {
                    n19 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(31);
                    continue;
                }
                case 30: {
                    n18 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(30);
                    continue;
                }
                case 34: {
                    final ic ic16 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a2, (android.os.Parcelable$Creator<ic>)com.google.android.gms.internal.ic.CREATOR);
                    set.add(34);
                    ic6 = ic16;
                    continue;
                }
                case 32: {
                    n20 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(32);
                    continue;
                }
                case 33: {
                    n21 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(33);
                    continue;
                }
                case 38: {
                    i = com.google.android.gms.common.internal.safeparcel.a.l(parcel, a2);
                    set.add(38);
                    continue;
                }
                case 39: {
                    n22 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(39);
                    continue;
                }
                case 36: {
                    l = com.google.android.gms.common.internal.safeparcel.a.l(parcel, a2);
                    set.add(36);
                    continue;
                }
                case 37: {
                    final ic ic17 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a2, (android.os.Parcelable$Creator<ic>)com.google.android.gms.internal.ic.CREATOR);
                    set.add(37);
                    ic7 = ic17;
                    continue;
                }
                case 42: {
                    n23 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(42);
                    continue;
                }
                case 43: {
                    n24 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(43);
                    continue;
                }
                case 40: {
                    final ic ic18 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a2, (android.os.Parcelable$Creator<ic>)com.google.android.gms.internal.ic.CREATOR);
                    set.add(40);
                    ic8 = ic18;
                    continue;
                }
                case 41: {
                    c5 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a2, (android.os.Parcelable$Creator<ic>)com.google.android.gms.internal.ic.CREATOR);
                    set.add(41);
                    continue;
                }
                case 46: {
                    final ic ic19 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a2, (android.os.Parcelable$Creator<ic>)com.google.android.gms.internal.ic.CREATOR);
                    set.add(46);
                    ic9 = ic19;
                    continue;
                }
                case 47: {
                    n27 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(47);
                    continue;
                }
                case 44: {
                    n25 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(44);
                    continue;
                }
                case 45: {
                    n26 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(45);
                    continue;
                }
                case 51: {
                    n30 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(51);
                    continue;
                }
                case 50: {
                    final ic ic20 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a2, (android.os.Parcelable$Creator<ic>)com.google.android.gms.internal.ic.CREATOR);
                    set.add(50);
                    ic10 = ic20;
                    continue;
                }
                case 49: {
                    n29 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(49);
                    continue;
                }
                case 48: {
                    n28 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(48);
                    continue;
                }
                case 55: {
                    n34 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(55);
                    continue;
                }
                case 54: {
                    n33 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(54);
                    continue;
                }
                case 53: {
                    n32 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(53);
                    continue;
                }
                case 52: {
                    n31 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(52);
                    continue;
                }
                case 56: {
                    n35 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    set.add(56);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ic(set, g, ic, a, ic2, n, n2, n3, c, g2, c2, ic3, c3, n4, n5, ic4, n6, n7, n8, c4, n9, n10, n11, n12, n13, n14, n15, n16, n17, ic5, n18, n19, n20, n21, ic6, l, ic7, i, n22, ic8, c5, n23, n24, n25, n26, ic9, n27, n28, n29, ic10, n30, n31, n32, n33, n34, n35);
    }
    
    public ic[] a(final int n) {
        return new ic[n];
    }
}
