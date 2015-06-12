// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;

public class ac
{
    static void a(final VisibleRegion visibleRegion, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, visibleRegion.a());
        c.a(parcel, 2, (Parcelable)visibleRegion.a, n, false);
        c.a(parcel, 3, (Parcelable)visibleRegion.b, n, false);
        c.a(parcel, 4, (Parcelable)visibleRegion.c, n, false);
        c.a(parcel, 5, (Parcelable)visibleRegion.d, n, false);
        c.a(parcel, 6, (Parcelable)visibleRegion.e, n, false);
        c.a(parcel, a);
    }
}
