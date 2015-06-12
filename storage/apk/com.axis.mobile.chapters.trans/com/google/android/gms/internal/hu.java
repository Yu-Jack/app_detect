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

public class hu implements Parcelable$Creator
{
    static void a(final ht ht, final Parcel parcel, final int n) {
        final int c = b.C(parcel);
        b.c(parcel, 1, ht.getVersionCode());
        b.a(parcel, 2, (Parcelable)ht.fB(), n, false);
        b.G(parcel, c);
    }
    
    public ht E(final Parcel parcel) {
        final int b = a.B(parcel);
        int g = 0;
        hv hv = null;
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
                    hv = (hv)com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (Parcelable$Creator)com.google.android.gms.internal.hv.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new a$a("Overread allowed size end=" + b, parcel);
        }
        return new ht(g, hv);
    }
    
    public ht[] at(final int n) {
        return new ht[n];
    }
}
