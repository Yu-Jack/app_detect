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

public class jj implements Parcelable$Creator<ih$c>
{
    static void a(final ih$c ih$c, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        final Set<Integer> e = ih$c.e();
        if (e.contains(1)) {
            c.a(parcel, 1, ih$c.f());
        }
        if (e.contains(2)) {
            c.a(parcel, 2, ih$c.g(), true);
        }
        c.a(parcel, a);
    }
    
    public ih$c a(final Parcel parcel) {
        final int b = a.b(parcel);
        final HashSet<Integer> set = new HashSet<Integer>();
        int g = 0;
        String n = null;
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
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ih$c(set, g, n);
    }
    
    public ih$c[] a(final int n) {
        return new ih$c[n];
    }
}
