// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class k implements Parcelable$Creator<ak>
{
    static void a(final ak ak, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, ak.a);
        c.a(parcel, 2, ak.b, false);
        c.a(parcel, 3, ak.c);
        c.a(parcel, 4, ak.d);
        c.a(parcel, 5, ak.e);
        c.a(parcel, 6, ak.f);
        c.a(parcel, 7, ak.g);
        c.a(parcel, 8, ak.h, n, false);
        c.a(parcel, a);
    }
    
    public ak a(final Parcel parcel) {
        ak[] array = null;
        int g = 0;
        final int b = a.b(parcel);
        int g2 = 0;
        boolean c = false;
        int g3 = 0;
        int g4 = 0;
        String n = null;
        int g5 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g5 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    g4 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 4: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 5: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 6: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 7: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 8: {
                    array = com.google.android.gms.common.internal.safeparcel.a.b(parcel, a, (android.os.Parcelable$Creator<ak>)ak.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ak(g5, n, g4, g3, c, g2, g, array);
    }
    
    public ak[] a(final int n) {
        return new ak[n];
    }
}
