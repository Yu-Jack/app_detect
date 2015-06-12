// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class gk implements Parcelable$Creator
{
    static void a(final gj gj, final Parcel parcel, final int n) {
        final int c = b.C(parcel);
        b.c(parcel, 1, gj.getVersionCode());
        b.a(parcel, 2, gj.eh());
        b.a(parcel, 3, gj.en());
        b.c(parcel, 4, gj.eo());
        b.G(parcel, c);
    }
    
    public gj[] Y(final int n) {
        return new gj[n];
    }
    
    public gj v(final Parcel parcel) {
        int g = 0;
        final int b = a.B(parcel);
        double m = 0.0;
        boolean c = false;
        int g2 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    m = com.google.android.gms.common.internal.safeparcel.a.m(parcel, a);
                    continue;
                }
                case 3: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 4: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new a$a("Overread allowed size end=" + b, parcel);
        }
        return new gj(g2, m, c, g);
    }
}
