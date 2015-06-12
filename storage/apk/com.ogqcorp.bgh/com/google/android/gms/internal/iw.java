// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class iw implements Parcelable$Creator<hk>
{
    static void a(final hk hk, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1000, hk.b);
        c.a(parcel, 2, (Parcelable)hk.a(), n, false);
        c.a(parcel, 3, hk.b());
        c.a(parcel, 4, hk.c());
        c.a(parcel, a);
    }
    
    public hk a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        hg hg = null;
        long n = hk.a;
        int g2 = 102;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1000: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    hg = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<hg>)com.google.android.gms.internal.hg.CREATOR);
                    continue;
                }
                case 3: {
                    n = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 4: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new hk(g, hg, n, g2);
    }
    
    public hk[] a(final int n) {
        return new hk[n];
    }
}
