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

public class c implements Parcelable$Creator<CircleOptions>
{
    static void a(final CircleOptions circleOptions, final Parcel parcel, final int n) {
        final int a = com.google.android.gms.common.internal.safeparcel.c.a(parcel);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1, circleOptions.a());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, (Parcelable)circleOptions.b(), n, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 3, circleOptions.c());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 4, circleOptions.d());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 5, circleOptions.e());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 6, circleOptions.f());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 7, circleOptions.g());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 8, circleOptions.h());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, a);
    }
    
    public CircleOptions a(final Parcel parcel) {
        float k = 0.0f;
        boolean c = false;
        final int b = a.b(parcel);
        LatLng latLng = null;
        double l = 0.0;
        int g = 0;
        int g2 = 0;
        float i = 0.0f;
        int g3 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    latLng = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<LatLng>)LatLng.CREATOR);
                    continue;
                }
                case 3: {
                    l = com.google.android.gms.common.internal.safeparcel.a.l(parcel, a);
                    continue;
                }
                case 4: {
                    i = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
                case 5: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 6: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 7: {
                    k = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
                case 8: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new CircleOptions(g3, latLng, l, i, g2, g, k, c);
    }
    
    public CircleOptions[] a(final int n) {
        return new CircleOptions[n];
    }
}
