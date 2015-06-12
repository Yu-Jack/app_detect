// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class hx implements Parcelable$Creator
{
    static void a(final hv$a hv$a, final Parcel parcel, final int n) {
        final int c = b.C(parcel);
        b.c(parcel, 1, hv$a.versionCode);
        b.a(parcel, 2, hv$a.GZ, false);
        b.c(parcel, 3, hv$a.Ha);
        b.G(parcel, c);
    }
    
    public hv$a G(final Parcel parcel) {
        int g = 0;
        final int b = a.B(parcel);
        String o = null;
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
                    o = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 3: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new a$a("Overread allowed size end=" + b, parcel);
        }
        return new hv$a(g2, o, g);
    }
    
    public hv$a[] av(final int n) {
        return new hv$a[n];
    }
}
