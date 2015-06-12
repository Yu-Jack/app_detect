// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class c implements Parcelable$Creator<CountrySpecification>
{
    static void a(final CountrySpecification countrySpecification, final Parcel parcel, final int n) {
        final int a = com.google.android.gms.common.internal.safeparcel.c.a(parcel);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1, countrySpecification.a());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, countrySpecification.a, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, a);
    }
    
    public CountrySpecification a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        String n = null;
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
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new CountrySpecification(g, n);
    }
    
    public CountrySpecification[] a(final int n) {
        return new CountrySpecification[n];
    }
}
