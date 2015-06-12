// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;

public class u
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
}
