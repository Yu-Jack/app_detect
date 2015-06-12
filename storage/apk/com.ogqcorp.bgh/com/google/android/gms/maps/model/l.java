// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class l implements Parcelable$Creator<StreetViewPanoramaLocation>
{
    static void a(final StreetViewPanoramaLocation streetViewPanoramaLocation, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, streetViewPanoramaLocation.a());
        c.a(parcel, 2, streetViewPanoramaLocation.a, n, false);
        c.a(parcel, 3, (Parcelable)streetViewPanoramaLocation.b, n, false);
        c.a(parcel, 4, streetViewPanoramaLocation.c, false);
        c.a(parcel, a);
    }
    
    public StreetViewPanoramaLocation a(final Parcel parcel) {
        String s = null;
        final int b = a.b(parcel);
        int n = 0;
        LatLng latLng = null;
        StreetViewPanoramaLink[] array = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            String n2 = null;
            LatLng latLng2 = null;
            StreetViewPanoramaLink[] array2 = null;
            int n3 = 0;
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    n2 = s;
                    latLng2 = latLng;
                    array2 = array;
                    n3 = n;
                    break;
                }
                case 1: {
                    final int g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    final String s2 = s;
                    latLng2 = latLng;
                    array2 = array;
                    n3 = g;
                    n2 = s2;
                    break;
                }
                case 2: {
                    final StreetViewPanoramaLink[] array3 = com.google.android.gms.common.internal.safeparcel.a.b(parcel, a, (android.os.Parcelable$Creator<StreetViewPanoramaLink>)StreetViewPanoramaLink.CREATOR);
                    n3 = n;
                    final LatLng latLng3 = latLng;
                    array2 = array3;
                    n2 = s;
                    latLng2 = latLng3;
                    break;
                }
                case 3: {
                    final LatLng latLng4 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<LatLng>)LatLng.CREATOR);
                    array2 = array;
                    n3 = n;
                    final String s3 = s;
                    latLng2 = latLng4;
                    n2 = s3;
                    break;
                }
                case 4: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    latLng2 = latLng;
                    array2 = array;
                    n3 = n;
                    break;
                }
            }
            n = n3;
            array = array2;
            latLng = latLng2;
            s = n2;
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new StreetViewPanoramaLocation(n, array, latLng, s);
    }
    
    public StreetViewPanoramaLocation[] a(final int n) {
        return new StreetViewPanoramaLocation[n];
    }
}
