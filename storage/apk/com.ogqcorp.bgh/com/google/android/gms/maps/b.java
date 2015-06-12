// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class b implements Parcelable$Creator<StreetViewPanoramaOptions>
{
    static void a(final StreetViewPanoramaOptions streetViewPanoramaOptions, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, streetViewPanoramaOptions.a());
        c.a(parcel, 2, (Parcelable)streetViewPanoramaOptions.g(), n, false);
        c.a(parcel, 3, streetViewPanoramaOptions.j(), false);
        c.a(parcel, 4, (Parcelable)streetViewPanoramaOptions.h(), n, false);
        c.a(parcel, 5, streetViewPanoramaOptions.i(), false);
        c.a(parcel, 6, streetViewPanoramaOptions.b());
        c.a(parcel, 7, streetViewPanoramaOptions.c());
        c.a(parcel, 8, streetViewPanoramaOptions.d());
        c.a(parcel, 9, streetViewPanoramaOptions.e());
        c.a(parcel, 10, streetViewPanoramaOptions.f());
        c.a(parcel, a);
    }
    
    public StreetViewPanoramaOptions a(final Parcel parcel) {
        Integer h = null;
        byte e = 0;
        final int b = a.b(parcel);
        byte e2 = 0;
        byte e3 = 0;
        byte e4 = 0;
        byte e5 = 0;
        LatLng latLng = null;
        String n = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        int g = 0;
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
                    streetViewPanoramaCamera = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<StreetViewPanoramaCamera>)StreetViewPanoramaCamera.CREATOR);
                    continue;
                }
                case 3: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 4: {
                    latLng = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<LatLng>)LatLng.CREATOR);
                    continue;
                }
                case 5: {
                    h = com.google.android.gms.common.internal.safeparcel.a.h(parcel, a);
                    continue;
                }
                case 6: {
                    e5 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, a);
                    continue;
                }
                case 7: {
                    e4 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, a);
                    continue;
                }
                case 8: {
                    e3 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, a);
                    continue;
                }
                case 9: {
                    e2 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, a);
                    continue;
                }
                case 10: {
                    e = com.google.android.gms.common.internal.safeparcel.a.e(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + b, parcel);
        }
        return new StreetViewPanoramaOptions(g, streetViewPanoramaCamera, n, latLng, h, e5, e4, e3, e2, e);
    }
    
    public StreetViewPanoramaOptions[] a(final int n) {
        return new StreetViewPanoramaOptions[n];
    }
}
