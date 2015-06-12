// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class j implements Parcelable$Creator<StreetViewPanoramaCamera>
{
    static void a(final StreetViewPanoramaCamera streetViewPanoramaCamera, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, streetViewPanoramaCamera.a());
        c.a(parcel, 2, streetViewPanoramaCamera.a);
        c.a(parcel, 3, streetViewPanoramaCamera.b);
        c.a(parcel, 4, streetViewPanoramaCamera.c);
        c.a(parcel, a);
    }
    
    public StreetViewPanoramaCamera a(final Parcel parcel) {
        float k = 0.0f;
        final int b = a.b(parcel);
        float i = 0.0f;
        int g = 0;
        float j = 0.0f;
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
                    j = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
                case 4: {
                    k = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new StreetViewPanoramaCamera(g, i, j, k);
    }
    
    public StreetViewPanoramaCamera[] a(final int n) {
        return new StreetViewPanoramaCamera[n];
    }
}
