// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class iy implements Parcelable$Creator<hm>
{
    static void a(final hm hm, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, hm.bx, false);
        c.a(parcel, 1000, hm.bw);
        c.a(parcel, a);
    }
    
    public hm a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        String n = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 1000: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new hm(g, n);
    }
    
    public hm[] a(final int n) {
        return new hm[n];
    }
}
