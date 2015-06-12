// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.List;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class it implements Parcelable$Creator<hg>
{
    static void a(final hg hg, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.b(parcel, 1, hg.b, false);
        c.a(parcel, 1000, hg.a);
        c.a(parcel, 2, hg.a(), false);
        c.a(parcel, 3, hg.b());
        c.a(parcel, a);
    }
    
    public hg a(final Parcel parcel) {
        String n = null;
        boolean c = false;
        final int b = a.b(parcel);
        List<hm> c2 = null;
        int g = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    c2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, (android.os.Parcelable$Creator<hm>)hm.CREATOR);
                    continue;
                }
                case 1000: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new hg(g, c2, n, c);
    }
    
    public hg[] a(final int n) {
        return new hg[n];
    }
}
