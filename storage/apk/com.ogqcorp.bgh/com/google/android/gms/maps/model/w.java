// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;

public class w
{
    static void a(final LatLng latLng, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, latLng.a());
        c.a(parcel, 2, latLng.a);
        c.a(parcel, 3, latLng.b);
        c.a(parcel, a);
    }
}
