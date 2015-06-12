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

public class ia implements Parcelable$Creator
{
    static void a(final ib$b ib$b, final Parcel parcel, final int n) {
        final int c = b.C(parcel);
        b.c(parcel, 1, ib$b.versionCode);
        b.a(parcel, 2, ib$b.eM, false);
        b.a(parcel, 3, (Parcelable)ib$b.Hp, n, false);
        b.G(parcel, c);
    }
    
    public ib$b I(final Parcel parcel) {
        hy$a hy$a = null;
        final int b = a.B(parcel);
        int g = 0;
        String o = null;
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
                    o = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 3: {
                    hy$a = (hy$a)com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (Parcelable$Creator)com.google.android.gms.internal.hy$a.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new a$a("Overread allowed size end=" + b, parcel);
        }
        return new ib$b(g, o, hy$a);
    }
    
    public ib$b[] ax(final int n) {
        return new ib$b[n];
    }
}
