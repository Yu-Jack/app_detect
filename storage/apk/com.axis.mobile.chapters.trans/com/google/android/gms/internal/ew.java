// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class ew implements Parcelable$Creator
{
    static void a(final ev ev, final Parcel parcel, final int n) {
        final int c = b.C(parcel);
        b.c(parcel, 1, ev.versionCode);
        b.a(parcel, 2, ev.sw, false);
        b.c(parcel, 3, ev.sx);
        b.c(parcel, 4, ev.sy);
        b.a(parcel, 5, ev.sz);
        b.G(parcel, c);
    }
    
    public ev j(final Parcel parcel) {
        boolean c = false;
        final int b = a.B(parcel);
        String o = null;
        int g = 0;
        int g2 = 0;
        int g3 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    o = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
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
            throw new a$a("Overread allowed size end=" + b, parcel);
        }
        return new ev(g3, o, g2, g, c);
    }
    
    public ev[] q(final int n) {
        return new ev[n];
    }
}
