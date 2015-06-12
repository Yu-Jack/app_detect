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

public class jh implements Parcelable$Creator<ih$b$a>
{
    static void a(final ih$b$a ih$b$a, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        final Set<Integer> e = ih$b$a.e();
        if (e.contains(1)) {
            c.a(parcel, 1, ih$b$a.f());
        }
        if (e.contains(2)) {
            c.a(parcel, 2, ih$b$a.g());
        }
        if (e.contains(3)) {
            c.a(parcel, 3, ih$b$a.h());
        }
        c.a(parcel, a);
    }
    
    public ih$b$a a(final Parcel parcel) {
        int g = 0;
        final int b = a.b(parcel);
        final HashSet<Integer> set = new HashSet<Integer>();
        int g2 = 0;
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
                case 2: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    set.add(2);
                    continue;
                }
                case 3: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    set.add(3);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ih$b$a(set, g3, g2, g);
    }
    
    public ih$b$a[] a(final int n) {
        return new ih$b$a[n];
    }
}
