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

public class fs implements Parcelable$Creator
{
    static void a(final fr fr, final Parcel parcel, final int n) {
        final int c = b.C(parcel);
        b.a(parcel, 1, (Parcelable)fr.yq, n, false);
        b.c(parcel, 1000, fr.xM);
        b.a(parcel, 2, fr.yr);
        b.c(parcel, 3, fr.ys);
        b.a(parcel, 4, fr.mP, false);
        b.a(parcel, 5, (Parcelable)fr.yt, n, false);
        b.G(parcel, c);
    }
    
    public fr[] K(final int n) {
        return new fr[n];
    }
    
    public fr q(final Parcel parcel) {
        int g = 0;
        fg fg = null;
        final int b = a.B(parcel);
        long i = 0L;
        String o = null;
        fi fi = null;
        int g2 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    fi = (fi)com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (Parcelable$Creator)com.google.android.gms.internal.fi.CREATOR);
                    continue;
                }
                case 1000: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    i = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 3: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 4: {
                    o = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 5: {
                    fg = (fg)com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (Parcelable$Creator)com.google.android.gms.internal.fg.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new a$a("Overread allowed size end=" + b, parcel);
        }
        return new fr(g2, fi, i, g, o, fg);
    }
}
