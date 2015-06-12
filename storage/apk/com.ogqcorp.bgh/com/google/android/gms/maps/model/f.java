// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class f implements Parcelable$Creator<LatLng>
{
    static void a(final LatLng latLng, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, latLng.a());
        c.a(parcel, 2, latLng.a);
        c.a(parcel, 3, latLng.b);
        c.a(parcel, a);
    }
    
    public LatLng a(final Parcel parcel) {
        double l = 0.0;
        final int b = a.b(parcel);
        int g = 0;
        double i = l;
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
                    i = com.google.android.gms.common.internal.safeparcel.a.l(parcel, a);
                    continue;
                }
                case 3: {
                    l = com.google.android.gms.common.internal.safeparcel.a.l(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new LatLng(g, i, l);
    }
    
    public LatLng[] a(final int n) {
        return new LatLng[n];
    }
}
