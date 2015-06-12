// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;

public class c
{
    static void a(final GoogleMapOptions googleMapOptions, final Parcel parcel, final int n) {
        final int a = com.google.android.gms.common.internal.safeparcel.c.a(parcel);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1, googleMapOptions.a());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, googleMapOptions.b());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 3, googleMapOptions.c());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 4, googleMapOptions.j());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 5, (Parcelable)googleMapOptions.k(), n, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 6, googleMapOptions.d());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 7, googleMapOptions.e());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 8, googleMapOptions.f());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 9, googleMapOptions.g());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 10, googleMapOptions.h());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 11, googleMapOptions.i());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, a);
    }
}
