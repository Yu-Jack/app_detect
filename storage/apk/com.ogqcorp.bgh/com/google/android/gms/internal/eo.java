// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class eo implements Parcelable$Creator<dx>
{
    static void a(final dx dx, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, dx.a);
        c.a(parcel, 2, dx.b, false);
        c.a(parcel, 3, dx.c);
        c.a(parcel, 4, dx.d);
        c.a(parcel, 5, dx.e);
        c.a(parcel, a);
    }
    
    public dx a(final Parcel parcel) {
        boolean c = false;
        final int b = a.b(parcel);
        String n = null;
        int g = 0;
        int g2 = 0;
        int g3 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 4: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 5: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new dx(g3, n, g2, g, c);
    }
    
    public dx[] a(final int n) {
        return new dx[n];
    }
}
