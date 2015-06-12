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

public class jd implements Parcelable$Creator<ie>
{
    static void a(final ie ie, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        final Set<Integer> e = ie.e();
        if (e.contains(1)) {
            c.a(parcel, 1, ie.f());
        }
        if (e.contains(2)) {
            c.a(parcel, 2, ie.g(), true);
        }
        if (e.contains(4)) {
            c.a(parcel, 4, (Parcelable)ie.h(), n, true);
        }
        if (e.contains(5)) {
            c.a(parcel, 5, ie.i(), true);
        }
        if (e.contains(6)) {
            c.a(parcel, 6, (Parcelable)ie.j(), n, true);
        }
        if (e.contains(7)) {
            c.a(parcel, 7, ie.k(), true);
        }
        c.a(parcel, a);
    }
    
    public ie a(final Parcel parcel) {
        String n = null;
        final int b = a.b(parcel);
        final HashSet<Integer> set = new HashSet<Integer>();
        int g = 0;
        ic ic = null;
        String n2 = null;
        ic ic2 = null;
        String n3 = null;
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
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(2);
                    continue;
                }
                case 4: {
                    final ic ic3 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<ic>)com.google.android.gms.internal.ic.CREATOR);
                    set.add(4);
                    ic2 = ic3;
                    continue;
                }
                case 5: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    set.add(5);
                    continue;
                }
                case 6: {
                    final ic ic4 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<ic>)com.google.android.gms.internal.ic.CREATOR);
                    set.add(6);
                    ic = ic4;
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
        return new ie(set, g, n3, ic2, n2, ic, n);
    }
    
    public ie[] a(final int n) {
        return new ie[n];
    }
}
