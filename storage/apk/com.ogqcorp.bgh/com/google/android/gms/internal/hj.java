// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class hj implements Parcelable$Creator<ga$a>
{
    static void a(final ga$a ga$a, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, ga$a.a());
        c.a(parcel, 2, ga$a.b());
        c.a(parcel, 3, ga$a.c());
        c.a(parcel, 4, ga$a.d());
        c.a(parcel, 5, ga$a.e());
        c.a(parcel, 6, ga$a.f(), false);
        c.a(parcel, 7, ga$a.g());
        c.a(parcel, 8, ga$a.i(), false);
        c.a(parcel, 9, (Parcelable)ga$a.k(), n, false);
        c.a(parcel, a);
    }
    
    public ga$a a(final Parcel parcel) {
        fv fv = null;
        int g = 0;
        final int b = a.b(parcel);
        String n = null;
        String n2 = null;
        boolean c = false;
        int g2 = 0;
        boolean c2 = false;
        int g3 = 0;
        int g4 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
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
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 7: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 8: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 9: {
                    fv = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<fv>)com.google.android.gms.internal.fv.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ga$a(g4, g3, c2, g2, c, n2, g, n, fv);
    }
    
    public ga$a[] a(final int n) {
        return new ga$a[n];
    }
}
