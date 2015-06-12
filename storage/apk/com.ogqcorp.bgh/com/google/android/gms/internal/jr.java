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

public class jr implements Parcelable$Creator<ih$h>
{
    static void a(final ih$h ih$h, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        final Set<Integer> e = ih$h.e();
        if (e.contains(1)) {
            c.a(parcel, 1, ih$h.f());
        }
        if (e.contains(3)) {
            c.a(parcel, 3, ih$h.h());
        }
        if (e.contains(4)) {
            c.a(parcel, 4, ih$h.j(), true);
        }
        if (e.contains(5)) {
            c.a(parcel, 5, ih$h.g(), true);
        }
        if (e.contains(6)) {
            c.a(parcel, 6, ih$h.i());
        }
        c.a(parcel, a);
    }
    
    public ih$h a(final Parcel parcel) {
        String n = null;
        int g = 0;
        final int b = a.b(parcel);
        final HashSet<Integer> set = new HashSet<Integer>();
        int g2 = 0;
        String n2 = null;
        int g3 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    set.add(1);
                    continue;
                }
                case 3: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    set.add(3);
                    continue;
                }
                case 4: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(4);
                    continue;
                }
                case 5: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(5);
                    continue;
                }
                case 6: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    set.add(6);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ih$h(set, g3, n2, g2, n, g);
    }
    
    public ih$h[] a(final int n) {
        return new ih$h[n];
    }
}
