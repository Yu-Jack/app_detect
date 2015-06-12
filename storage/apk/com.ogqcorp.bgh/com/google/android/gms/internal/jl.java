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

public class jl implements Parcelable$Creator<ih$d>
{
    static void a(final ih$d ih$d, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        final Set<Integer> e = ih$d.e();
        if (e.contains(1)) {
            c.a(parcel, 1, ih$d.f());
        }
        if (e.contains(2)) {
            c.a(parcel, 2, ih$d.g(), true);
        }
        if (e.contains(3)) {
            c.a(parcel, 3, ih$d.h(), true);
        }
        if (e.contains(4)) {
            c.a(parcel, 4, ih$d.i(), true);
        }
        if (e.contains(5)) {
            c.a(parcel, 5, ih$d.j(), true);
        }
        if (e.contains(6)) {
            c.a(parcel, 6, ih$d.k(), true);
        }
        if (e.contains(7)) {
            c.a(parcel, 7, ih$d.l(), true);
        }
        c.a(parcel, a);
    }
    
    public ih$d a(final Parcel parcel) {
        String n = null;
        final int b = a.b(parcel);
        final HashSet<Integer> set = new HashSet<Integer>();
        int g = 0;
        String n2 = null;
        String n3 = null;
        String n4 = null;
        String n5 = null;
        String n6 = null;
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
                    n6 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(2);
                    continue;
                }
                case 3: {
                    n5 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(3);
                    continue;
                }
                case 4: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(4);
                    continue;
                }
                case 5: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(5);
                    continue;
                }
                case 6: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(6);
                    continue;
                }
                case 7: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(7);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ih$d(set, g, n6, n5, n4, n3, n2, n);
    }
    
    public ih$d[] a(final int n) {
        return new ih$d[n];
    }
}
