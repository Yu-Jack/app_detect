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

public class gy implements Parcelable$Creator<fc$a>
{
    static void a(final fc$a fc$a, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, fc$a.a(), false);
        c.a(parcel, 1000, fc$a.e());
        c.a(parcel, 2, fc$a.d(), false);
        c.a(parcel, 3, fc$a.b());
        c.a(parcel, 4, fc$a.c(), false);
        c.a(parcel, a);
    }
    
    public fc$a a(final Parcel parcel) {
        int g = 0;
        String n = null;
        final int b = a.b(parcel);
        List<String> a = null;
        String n2 = null;
        int g2 = 0;
        while (parcel.dataPosition() < b) {
            final int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a2)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a2);
                    continue;
                }
                case 1: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    continue;
                }
                case 1000: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a2);
                    continue;
                }
                case 2: {
                    a = com.google.android.gms.common.internal.safeparcel.a.A(parcel, a2);
                    continue;
                }
                case 3: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a2);
                    continue;
                }
                case 4: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new fc$a(g2, n2, a, g, n);
    }
    
    public fc$a[] a(final int n) {
        return new fc$a[n];
    }
}
