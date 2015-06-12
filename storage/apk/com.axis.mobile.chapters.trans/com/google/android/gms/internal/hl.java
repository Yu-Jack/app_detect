// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.List;
import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class hl implements Parcelable$Creator
{
    static void a(final gy$a gy$a, final Parcel parcel, final int n) {
        final int c = b.C(parcel);
        b.a(parcel, 1, gy$a.getAccountName(), false);
        b.c(parcel, 1000, gy$a.getVersionCode());
        b.a(parcel, 2, gy$a.fl(), false);
        b.c(parcel, 3, gy$a.fk());
        b.a(parcel, 4, gy$a.fn(), false);
        b.G(parcel, c);
    }
    
    public gy$a[] aq(final int n) {
        return new gy$a[n];
    }
    
    public gy$a z(final Parcel parcel) {
        int g = 0;
        String o = null;
        final int b = a.B(parcel);
        List b2 = null;
        String o2 = null;
        int g2 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    o2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 1000: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    b2 = com.google.android.gms.common.internal.safeparcel.a.B(parcel, a);
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
            }
        }
        if (parcel.dataPosition() != b) {
            throw new a$a("Overread allowed size end=" + b, parcel);
        }
        return new gy$a(g2, o2, b2, g, o);
    }
}
