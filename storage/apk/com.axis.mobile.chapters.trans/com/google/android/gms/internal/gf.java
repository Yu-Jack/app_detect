// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class gf implements Parcelable$Creator
{
    static void a(final ge ge, final Parcel parcel, final int n) {
        final int c = b.C(parcel);
        b.c(parcel, 1, ge.getVersionCode());
        b.a(parcel, 2, ge.ec(), false);
        b.G(parcel, c);
    }
    
    public ge[] S(final int n) {
        return new ge[n];
    }
    
    public ge u(final Parcel parcel) {
        final int b = a.B(parcel);
        int g = 0;
        String o = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    o = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new a$a("Overread allowed size end=" + b, parcel);
        }
        return new ge(g, o);
    }
}
