// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class n implements Parcelable$Creator<StreetViewPanoramaOrientation>
{
    static void a(final StreetViewPanoramaOrientation streetViewPanoramaOrientation, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, streetViewPanoramaOrientation.a());
        c.a(parcel, 2, streetViewPanoramaOrientation.a);
        c.a(parcel, 3, streetViewPanoramaOrientation.b);
        c.a(parcel, a);
    }
    
    public StreetViewPanoramaOrientation a(final Parcel parcel) {
        float k = 0.0f;
        final int b = a.b(parcel);
        int g = 0;
        float i = 0.0f;
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
                    i = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
                case 3: {
                    k = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new StreetViewPanoramaOrientation(g, i, k);
    }
    
    public StreetViewPanoramaOrientation[] a(final int n) {
        return new StreetViewPanoramaOrientation[n];
    }
}
