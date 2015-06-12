// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class he implements Parcelable$Creator<fx$a>
{
    static void a(final fx$a fx$a, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, fx$a.a);
        c.a(parcel, 2, fx$a.b, false);
        c.a(parcel, 3, fx$a.c);
        c.a(parcel, a);
    }
    
    public fx$a a(final Parcel parcel) {
        int g = 0;
        final int b = a.b(parcel);
        String n = null;
        int g2 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new fx$a(g2, n, g);
    }
    
    public fx$a[] a(final int n) {
        return new fx$a[n];
    }
}
