// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class jt implements Parcelable$Creator<iv>
{
    static void a(final iv iv, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, iv.a());
        c.a(parcel, 2, iv.a, false);
        c.a(parcel, a);
    }
    
    public iv a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        int[] t = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    t = com.google.android.gms.common.internal.safeparcel.a.t(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new iv(g, t);
    }
    
    public iv[] a(final int n) {
        return new iv[n];
    }
}
