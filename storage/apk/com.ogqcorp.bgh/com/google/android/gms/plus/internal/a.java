// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.plus.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class a implements Parcelable$Creator<PlusCommonExtras>
{
    static void a(final PlusCommonExtras plusCommonExtras, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, plusCommonExtras.b(), false);
        c.a(parcel, 1000, plusCommonExtras.a());
        c.a(parcel, 2, plusCommonExtras.c(), false);
        c.a(parcel, a);
    }
    
    public PlusCommonExtras a(final Parcel parcel) {
        String n = null;
        final int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int g = 0;
        String n2 = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
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
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new PlusCommonExtras(g, n2, n);
    }
    
    public PlusCommonExtras[] a(final int n) {
        return new PlusCommonExtras[n];
    }
}
