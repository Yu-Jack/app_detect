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

public class g implements Parcelable$Creator<MarkerOptions>
{
    static void a(final MarkerOptions markerOptions, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, markerOptions.a());
        c.a(parcel, 2, (Parcelable)markerOptions.c(), n, false);
        c.a(parcel, 3, markerOptions.d(), false);
        c.a(parcel, 4, markerOptions.e(), false);
        c.a(parcel, 5, markerOptions.b(), false);
        c.a(parcel, 6, markerOptions.f());
        c.a(parcel, 7, markerOptions.g());
        c.a(parcel, 8, markerOptions.h());
        c.a(parcel, 9, markerOptions.i());
        c.a(parcel, 10, markerOptions.j());
        c.a(parcel, 11, markerOptions.k());
        c.a(parcel, 12, markerOptions.l());
        c.a(parcel, 13, markerOptions.m());
        c.a(parcel, 14, markerOptions.n());
        c.a(parcel, a);
    }
    
    public MarkerOptions a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        LatLng latLng = null;
        String n = null;
        String n2 = null;
        IBinder o = null;
        float k = 0.0f;
        float i = 0.0f;
        boolean c = false;
        boolean c2 = false;
        boolean c3 = false;
        float j = 0.0f;
        float l = 0.5f;
        float m = 0.0f;
        float k2 = 1.0f;
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
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 4: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 5: {
                    o = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 6: {
                    k = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
                case 7: {
                    i = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
                case 8: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 9: {
                    c2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 10: {
                    c3 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 11: {
                    j = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
                case 12: {
                    l = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
                case 13: {
                    m = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
                case 14: {
                    k2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new MarkerOptions(g, latLng, n, n2, o, k, i, c, c2, c3, j, l, m, k2);
    }
    
    public MarkerOptions[] a(final int n) {
        return new MarkerOptions[n];
    }
}
