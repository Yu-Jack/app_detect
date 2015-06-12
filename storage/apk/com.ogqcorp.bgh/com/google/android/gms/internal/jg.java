// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Set;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class jg implements Parcelable$Creator<ih$b>
{
    static void a(final ih$b ih$b, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        final Set<Integer> e = ih$b.e();
        if (e.contains(1)) {
            c.a(parcel, 1, ih$b.f());
        }
        if (e.contains(2)) {
            c.a(parcel, 2, (Parcelable)ih$b.g(), n, true);
        }
        if (e.contains(3)) {
            c.a(parcel, 3, (Parcelable)ih$b.h(), n, true);
        }
        if (e.contains(4)) {
            c.a(parcel, 4, ih$b.i());
        }
        c.a(parcel, a);
    }
    
    public ih$b a(final Parcel parcel) {
        ih$b$b ih$b$b = null;
        int g = 0;
        final int b = a.b(parcel);
        final HashSet<Integer> set = new HashSet<Integer>();
        ih$b$a ih$b$a = null;
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
                    final ih$b$a ih$b$a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<ih$b$a>)com.google.android.gms.internal.ih$b$a.CREATOR);
                    set.add(2);
                    ih$b$a = ih$b$a2;
                    continue;
                }
                case 3: {
                    final ih$b$b ih$b$b2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<ih$b$b>)com.google.android.gms.internal.ih$b$b.CREATOR);
                    set.add(3);
                    ih$b$b = ih$b$b2;
                    continue;
                }
                case 4: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    set.add(4);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ih$b(set, g2, ih$b$a, ih$b$b, g);
    }
    
    public ih$b[] a(final int n) {
        return new ih$b[n];
    }
}
