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

public class jq implements Parcelable$Creator<ih$g>
{
    static void a(final ih$g ih$g, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        final Set<Integer> e = ih$g.e();
        if (e.contains(1)) {
            c.a(parcel, 1, ih$g.f());
        }
        if (e.contains(2)) {
            c.a(parcel, 2, ih$g.g());
        }
        if (e.contains(3)) {
            c.a(parcel, 3, ih$g.h(), true);
        }
        c.a(parcel, a);
    }
    
    public ih$g a(final Parcel parcel) {
        boolean c = false;
        final int b = a.b(parcel);
        final HashSet<Integer> set = new HashSet<Integer>();
        String n = null;
        int g = 0;
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
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    set.add(2);
                    continue;
                }
                case 3: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(3);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ih$g(set, g, c, n);
    }
    
    public ih$g[] a(final int n) {
        return new ih$g[n];
    }
}
