// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;
import java.util.ArrayList;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class h implements Parcelable$Creator<PolygonOptions>
{
    static void a(final PolygonOptions polygonOptions, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, polygonOptions.a());
        c.b(parcel, 2, polygonOptions.c(), false);
        c.c(parcel, 3, polygonOptions.b(), false);
        c.a(parcel, 4, polygonOptions.d());
        c.a(parcel, 5, polygonOptions.e());
        c.a(parcel, 6, polygonOptions.f());
        c.a(parcel, 7, polygonOptions.g());
        c.a(parcel, 8, polygonOptions.h());
        c.a(parcel, 9, polygonOptions.i());
        c.a(parcel, a);
    }
    
    public PolygonOptions a(final Parcel parcel) {
        float k = 0.0f;
        boolean c = false;
        final int b = a.b(parcel);
        List<LatLng> c2 = null;
        final ArrayList list = new ArrayList();
        boolean c3 = false;
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
                    c2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, (android.os.Parcelable$Creator<LatLng>)LatLng.CREATOR);
                    continue;
                }
                case 3: {
                    com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, list, this.getClass().getClassLoader());
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
                    c3 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 9: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new PolygonOptions(g3, c2, list, i, g2, g, k, c3, c);
    }
    
    public PolygonOptions[] a(final int n) {
        return new PolygonOptions[n];
    }
}
