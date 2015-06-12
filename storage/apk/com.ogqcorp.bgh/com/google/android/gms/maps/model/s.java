// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;

public class s
{
    static void a(final CameraPosition cameraPosition, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, cameraPosition.a());
        c.a(parcel, 2, (Parcelable)cameraPosition.a, n, false);
        c.a(parcel, 3, cameraPosition.b);
        c.a(parcel, 4, cameraPosition.c);
        c.a(parcel, 5, cameraPosition.d);
        c.a(parcel, a);
    }
}
