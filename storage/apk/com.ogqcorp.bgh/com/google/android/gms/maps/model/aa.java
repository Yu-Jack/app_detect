// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;

public class aa
{
    static void a(final Tile tile, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, tile.a());
        c.a(parcel, 2, tile.a);
        c.a(parcel, 3, tile.b);
        c.a(parcel, 4, tile.c, false);
        c.a(parcel, a);
    }
}
