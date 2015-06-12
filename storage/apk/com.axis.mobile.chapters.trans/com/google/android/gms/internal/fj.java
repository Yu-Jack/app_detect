// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class fj implements Parcelable$Creator
{
    static void a(final fi fi, final Parcel parcel, final int n) {
        final int c = b.C(parcel);
        b.a(parcel, 1, fi.xQ, false);
        b.c(parcel, 1000, fi.xM);
        b.a(parcel, 2, fi.xR, false);
        b.a(parcel, 3, fi.xS, false);
        b.G(parcel, c);
    }
    
    public fi[] E(final int n) {
        return new fi[n];
    }
    
    public fi m(final Parcel parcel) {
        String o = null;
        final int b = a.B(parcel);
        int g = 0;
        String o2 = null;
        String o3 = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    o3 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 1000: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    o2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 3: {
                    o = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new a$a("Overread allowed size end=" + b, parcel);
        }
        return new fi(g, o3, o2, o);
    }
}
