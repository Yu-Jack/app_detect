// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import java.util.List;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class i implements Parcelable$Creator<PolylineOptions>
{
    static void a(final PolylineOptions polylineOptions, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, polylineOptions.a());
        c.b(parcel, 2, polylineOptions.b(), false);
        c.a(parcel, 3, polylineOptions.c());
        c.a(parcel, 4, polylineOptions.d());
        c.a(parcel, 5, polylineOptions.e());
        c.a(parcel, 6, polylineOptions.f());
        c.a(parcel, 7, polylineOptions.g());
        c.a(parcel, a);
    }
    
    public PolylineOptions a(final Parcel parcel) {
        float k = 0.0f;
        boolean c = false;
        final int b = a.b(parcel);
        List<Object> c2 = null;
        boolean c3 = false;
        int g = 0;
        float i = 0.0f;
        int g2 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    c2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, (android.os.Parcelable$Creator<Object>)LatLng.CREATOR);
                    continue;
                }
                case 3: {
                    i = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
                case 4: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 5: {
                    k = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
                case 6: {
                    c3 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 7: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new PolylineOptions(g2, c2, i, g, k, c3, c);
    }
    
    public PolylineOptions[] a(final int n) {
        return new PolylineOptions[n];
    }
}
