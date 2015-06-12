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

public class b implements Parcelable$Creator<CameraPosition>
{
    static void a(final CameraPosition cameraPosition, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, cameraPosition.a());
        c.a(parcel, 2, (Parcelable)cameraPosition.a, n, false);
        c.a(parcel, 3, cameraPosition.b);
        c.a(parcel, 4, cameraPosition.c);
        c.a(parcel, 5, cameraPosition.d);
        c.a(parcel, a);
    }
    
    public CameraPosition a(final Parcel parcel) {
        float k = 0.0f;
        final int b = a.b(parcel);
        int g = 0;
        LatLng latLng = null;
        float i = 0.0f;
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
                    latLng = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<LatLng>)LatLng.CREATOR);
                    continue;
                }
                case 3: {
                    j = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
                case 4: {
                    i = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
                case 5: {
                    k = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + b, parcel);
        }
        return new CameraPosition(g, latLng, j, i, k);
    }
    
    public CameraPosition[] a(final int n) {
        return new CameraPosition[n];
    }
}
