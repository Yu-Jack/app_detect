// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.location;

import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class e implements Parcelable$Creator<b>
{
    static void a(final b b, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, b.a);
        c.a(parcel, 1000, b.a());
        c.a(parcel, 2, b.b);
        c.a(parcel, 3, b.c);
        c.a(parcel, a);
    }
    
    public b a(final Parcel parcel) {
        int g = 1;
        final int b = a.b(parcel);
        int g2 = 0;
        long i = 0L;
        int g3 = g;
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
                case 1000: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 3: {
                    i = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + b, parcel);
        }
        return new b(g2, g3, g, i);
    }
    
    public b[] a(final int n) {
        return new b[n];
    }
}
