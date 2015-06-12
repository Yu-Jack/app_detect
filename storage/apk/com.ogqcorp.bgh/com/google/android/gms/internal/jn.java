// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Set;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class jn implements Parcelable$Creator<ih$f>
{
    static void a(final ih$f ih$f, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        final Set<Integer> e = ih$f.e();
        if (e.contains(1)) {
            c.a(parcel, 1, ih$f.f());
        }
        if (e.contains(2)) {
            c.a(parcel, 2, ih$f.g(), true);
        }
        if (e.contains(3)) {
            c.a(parcel, 3, ih$f.h(), true);
        }
        if (e.contains(4)) {
            c.a(parcel, 4, ih$f.i(), true);
        }
        if (e.contains(5)) {
            c.a(parcel, 5, ih$f.j(), true);
        }
        if (e.contains(6)) {
            c.a(parcel, 6, ih$f.k(), true);
        }
        if (e.contains(7)) {
            c.a(parcel, 7, ih$f.l());
        }
        if (e.contains(8)) {
            c.a(parcel, 8, ih$f.m(), true);
        }
        if (e.contains(9)) {
            c.a(parcel, 9, ih$f.n(), true);
        }
        if (e.contains(10)) {
            c.a(parcel, 10, ih$f.o());
        }
        c.a(parcel, a);
    }
    
    public ih$f a(final Parcel parcel) {
        int g = 0;
        String n = null;
        final int b = a.b(parcel);
        final HashSet<Integer> set = new HashSet<Integer>();
        String n2 = null;
        boolean c = false;
        String n3 = null;
        String n4 = null;
        String n5 = null;
        String n6 = null;
        String n7 = null;
        int g2 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    set.add(1);
                    continue;
                }
                case 2: {
                    n7 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(2);
                    continue;
                }
                case 3: {
                    n6 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(3);
                    continue;
                }
                case 4: {
                    n5 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(4);
                    continue;
                }
                case 5: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(5);
                    continue;
                }
                case 6: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(6);
                    continue;
                }
                case 7: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    set.add(7);
                    continue;
                }
                case 8: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(8);
                    continue;
                }
                case 9: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(9);
                    continue;
                }
                case 10: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    set.add(10);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ih$f(set, g2, n7, n6, n5, n4, n3, c, n2, n, g);
    }
    
    public ih$f[] a(final int n) {
        return new ih$f[n];
    }
}
