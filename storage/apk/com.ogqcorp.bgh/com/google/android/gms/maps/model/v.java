// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;

public class v
{
    static void a(final LatLngBounds latLngBounds, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, latLngBounds.a());
        c.a(parcel, 2, (Parcelable)latLngBounds.a, n, false);
        c.a(parcel, 3, (Parcelable)latLngBounds.b, n, false);
        c.a(parcel, a);
    }
}
