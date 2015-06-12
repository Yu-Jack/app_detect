// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games;

import com.google.android.gms.common.internal.safeparcel.b;
import android.net.Uri;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class d implements Parcelable$Creator<PlayerEntity>
{
    static void a(final PlayerEntity playerEntity, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, playerEntity.b(), false);
        c.a(parcel, 1000, playerEntity.k());
        c.a(parcel, 2, playerEntity.c(), false);
        c.a(parcel, 3, (Parcelable)playerEntity.d(), n, false);
        c.a(parcel, 4, (Parcelable)playerEntity.f(), n, false);
        c.a(parcel, 5, playerEntity.h());
        c.a(parcel, 6, playerEntity.j());
        c.a(parcel, 7, playerEntity.i());
        c.a(parcel, 8, playerEntity.e(), false);
        c.a(parcel, 9, playerEntity.g(), false);
        c.a(parcel, a);
    }
    
    public PlayerEntity a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        String n = null;
        String n2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long i = 0L;
        int g2 = 0;
        long j = 0L;
        String n3 = null;
        String n4 = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 1000: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    uri = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<Uri>)Uri.CREATOR);
                    continue;
                }
                case 4: {
                    uri2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<Uri>)Uri.CREATOR);
                    continue;
                }
                case 5: {
                    i = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 6: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 7: {
                    j = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 8: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 9: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new PlayerEntity(g, n, n2, uri, uri2, i, g2, j, n3, n4);
    }
    
    public PlayerEntity[] a(final int n) {
        return new PlayerEntity[n];
    }
}
