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

public class hz implements Parcelable$Creator
{
    static void a(final hy$a hy$a, final Parcel parcel, final int n) {
        final int c = b.C(parcel);
        b.c(parcel, 1, hy$a.getVersionCode());
        b.c(parcel, 2, hy$a.fE());
        b.a(parcel, 3, hy$a.fK());
        b.c(parcel, 4, hy$a.fF());
        b.a(parcel, 5, hy$a.fL());
        b.a(parcel, 6, hy$a.fM(), false);
        b.c(parcel, 7, hy$a.fN());
        b.a(parcel, 8, hy$a.fP(), false);
        b.a(parcel, 9, (Parcelable)hy$a.fR(), n, false);
        b.G(parcel, c);
    }
    
    public hy$a H(final Parcel parcel) {
        ht ht = null;
        int g = 0;
        final int b = a.B(parcel);
        String o = null;
        String o2 = null;
        boolean c = false;
        int g2 = 0;
        boolean c2 = false;
        int g3 = 0;
        int g4 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g4 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 3: {
                    c2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 4: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 5: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 6: {
                    o2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 7: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 8: {
                    o = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 9: {
                    ht = (ht)com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (Parcelable$Creator)com.google.android.gms.internal.ht.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new a$a("Overread allowed size end=" + b, parcel);
        }
        return new hy$a(g4, g3, c2, g2, c, o2, g, o, ht);
    }
    
    public hy$a[] aw(final int n) {
        return new hy$a[n];
    }
}
