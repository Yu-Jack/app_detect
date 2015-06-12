// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class d implements Parcelable$Creator<GroundOverlayOptions>
{
    static void a(final GroundOverlayOptions groundOverlayOptions, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, groundOverlayOptions.b());
        c.a(parcel, 2, groundOverlayOptions.a(), false);
        c.a(parcel, 3, (Parcelable)groundOverlayOptions.c(), n, false);
        c.a(parcel, 4, groundOverlayOptions.d());
        c.a(parcel, 5, groundOverlayOptions.e());
        c.a(parcel, 6, (Parcelable)groundOverlayOptions.f(), n, false);
        c.a(parcel, 7, groundOverlayOptions.g());
        c.a(parcel, 8, groundOverlayOptions.h());
        c.a(parcel, 9, groundOverlayOptions.l());
        c.a(parcel, 10, groundOverlayOptions.i());
        c.a(parcel, 11, groundOverlayOptions.j());
        c.a(parcel, 12, groundOverlayOptions.k());
        c.a(parcel, a);
    }
    
    public GroundOverlayOptions a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        IBinder o = null;
        LatLng latLng = null;
        float k = 0.0f;
        float i = 0.0f;
        LatLngBounds latLngBounds = null;
        float j = 0.0f;
        float l = 0.0f;
        boolean c = false;
        float m = 0.0f;
        float k2 = 0.0f;
        float k3 = 0.0f;
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
                    o = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 3: {
                    latLng = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<LatLng>)LatLng.CREATOR);
                    continue;
                }
                case 4: {
                    k = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
                case 5: {
                    i = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
                case 6: {
                    latLngBounds = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<LatLngBounds>)LatLngBounds.CREATOR);
                    continue;
                }
                case 7: {
                    j = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
                case 8: {
                    l = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
                case 9: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 10: {
                    m = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
                case 11: {
                    k2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
                case 12: {
                    k3 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new GroundOverlayOptions(g, o, latLng, k, i, latLngBounds, j, l, c, m, k2, k3);
    }
    
    public GroundOverlayOptions[] a(final int n) {
        return new GroundOverlayOptions[n];
    }
}
