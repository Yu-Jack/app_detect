// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class p implements Parcelable$Creator<TileOverlayOptions>
{
    static void a(final TileOverlayOptions tileOverlayOptions, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, tileOverlayOptions.a());
        c.a(parcel, 2, tileOverlayOptions.b(), false);
        c.a(parcel, 3, tileOverlayOptions.d());
        c.a(parcel, 4, tileOverlayOptions.c());
        c.a(parcel, 5, tileOverlayOptions.e());
        c.a(parcel, a);
    }
    
    public TileOverlayOptions a(final Parcel parcel) {
        boolean c = false;
        final int b = a.b(parcel);
        IBinder o = null;
        float k = 0.0f;
        boolean c2 = true;
        int g = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    o = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 3: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 4: {
                    k = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
                case 5: {
                    c2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new TileOverlayOptions(g, o, c, k, c2);
    }
    
    public TileOverlayOptions[] a(final int n) {
        return new TileOverlayOptions[n];
    }
}
