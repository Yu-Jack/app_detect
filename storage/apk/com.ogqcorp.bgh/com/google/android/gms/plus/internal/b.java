// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.plus.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class b implements Parcelable$Creator<h>
{
    static void a(final h h, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, h.b(), false);
        c.a(parcel, 1000, h.a());
        c.a(parcel, 2, h.c(), false);
        c.a(parcel, 3, h.d(), false);
        c.a(parcel, 4, h.e(), false);
        c.a(parcel, 5, h.f(), false);
        c.a(parcel, 6, h.g(), false);
        c.a(parcel, 7, h.h(), false);
        c.a(parcel, 8, h.i(), false);
        c.a(parcel, 9, (Parcelable)h.j(), n, false);
        c.a(parcel, a);
    }
    
    public h a(final Parcel parcel) {
        PlusCommonExtras plusCommonExtras = null;
        final int b = a.b(parcel);
        int g = 0;
        String n = null;
        String n2 = null;
        String n3 = null;
        String n4 = null;
        String[] z = null;
        String[] z2 = null;
        String[] z3 = null;
        String n5 = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    n5 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 1000: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    z3 = com.google.android.gms.common.internal.safeparcel.a.z(parcel, a);
                    continue;
                }
                case 3: {
                    z2 = com.google.android.gms.common.internal.safeparcel.a.z(parcel, a);
                    continue;
                }
                case 4: {
                    z = com.google.android.gms.common.internal.safeparcel.a.z(parcel, a);
                    continue;
                }
                case 5: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 6: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 7: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 8: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 9: {
                    plusCommonExtras = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<PlusCommonExtras>)PlusCommonExtras.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + b, parcel);
        }
        return new h(g, n5, z3, z2, z, n4, n3, n2, n, plusCommonExtras);
    }
    
    public h[] a(final int n) {
        return new h[n];
    }
}
