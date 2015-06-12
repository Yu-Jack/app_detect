// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class o implements Parcelable$Creator<Tile>
{
    static void a(final Tile tile, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, tile.a());
        c.a(parcel, 2, tile.a);
        c.a(parcel, 3, tile.b);
        c.a(parcel, 4, tile.c, false);
        c.a(parcel, a);
    }
    
    public Tile a(final Parcel parcel) {
        int g = 0;
        final int b = a.b(parcel);
        byte[] q = null;
        int g2 = 0;
        int g3 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 3: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 4: {
                    q = com.google.android.gms.common.internal.safeparcel.a.q(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new Tile(g3, g2, g, q);
    }
    
    public Tile[] a(final int n) {
        return new Tile[n];
    }
}
