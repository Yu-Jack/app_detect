// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class fl implements Parcelable$Creator
{
    static void a(final fk fk, final Parcel parcel, final int n) {
        final int c = b.C(parcel);
        b.a(parcel, 1, fk.xU, false);
        b.c(parcel, 1000, fk.xM);
        b.a(parcel, 3, (Parcelable)fk.xV, n, false);
        b.c(parcel, 4, fk.xW);
        b.a(parcel, 5, fk.xX, false);
        b.G(parcel, c);
    }
    
    public fk[] F(final int n) {
        return new fk[n];
    }
    
    public fk n(final Parcel parcel) {
        byte[] r = null;
        final int b = a.B(parcel);
        int g = 0;
        int g2 = -1;
        fp fp = null;
        String o = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    o = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 1000: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 3: {
                    fp = (fp)com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (Parcelable$Creator)com.google.android.gms.internal.fp.CREATOR);
                    continue;
                }
                case 4: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 5: {
                    r = com.google.android.gms.common.internal.safeparcel.a.r(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new a$a("Overread allowed size end=" + b, parcel);
        }
        return new fk(g, o, fp, g2, r);
    }
}
