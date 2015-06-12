// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;

public class t
{
    static void a(final CircleOptions circleOptions, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, circleOptions.a());
        c.a(parcel, 2, (Parcelable)circleOptions.b(), n, false);
        c.a(parcel, 3, circleOptions.c());
        c.a(parcel, 4, circleOptions.d());
        c.a(parcel, 5, circleOptions.e());
        c.a(parcel, 6, circleOptions.f());
        c.a(parcel, 7, circleOptions.g());
        c.a(parcel, 8, circleOptions.h());
        c.a(parcel, a);
    }
}
