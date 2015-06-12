// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;

public class x
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
        c.a(parcel, a);
    }
}
