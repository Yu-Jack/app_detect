// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;

public class z
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
}
