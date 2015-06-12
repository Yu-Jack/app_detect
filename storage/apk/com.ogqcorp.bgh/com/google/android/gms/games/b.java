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

public class b implements Parcelable$Creator<GameEntity>
{
    static void a(final GameEntity gameEntity, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, gameEntity.b(), false);
        c.a(parcel, 2, gameEntity.c(), false);
        c.a(parcel, 3, gameEntity.d(), false);
        c.a(parcel, 4, gameEntity.e(), false);
        c.a(parcel, 5, gameEntity.f(), false);
        c.a(parcel, 6, gameEntity.g(), false);
        c.a(parcel, 7, (Parcelable)gameEntity.h(), n, false);
        c.a(parcel, 8, (Parcelable)gameEntity.j(), n, false);
        c.a(parcel, 9, (Parcelable)gameEntity.l(), n, false);
        c.a(parcel, 10, gameEntity.n());
        c.a(parcel, 11, gameEntity.q());
        c.a(parcel, 12, gameEntity.r(), false);
        c.a(parcel, 13, gameEntity.s());
        c.a(parcel, 14, gameEntity.t());
        c.a(parcel, 15, gameEntity.u());
        c.a(parcel, 17, gameEntity.w());
        c.a(parcel, 16, gameEntity.v());
        c.a(parcel, 1000, gameEntity.x());
        c.a(parcel, 19, gameEntity.k(), false);
        c.a(parcel, 18, gameEntity.i(), false);
        c.a(parcel, 21, gameEntity.o());
        c.a(parcel, 20, gameEntity.m(), false);
        c.a(parcel, 22, gameEntity.p());
        c.a(parcel, a);
    }
    
    public GameEntity a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        String n = null;
        String n2 = null;
        String n3 = null;
        String n4 = null;
        String n5 = null;
        String n6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean c = false;
        boolean c2 = false;
        String n7 = null;
        int g2 = 0;
        int g3 = 0;
        int g4 = 0;
        boolean c3 = false;
        boolean c4 = false;
        String n8 = null;
        String n9 = null;
        String n10 = null;
        boolean c5 = false;
        boolean c6 = false;
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
                case 2: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 4: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 5: {
                    n5 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 6: {
                    n6 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 7: {
                    uri = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<Uri>)Uri.CREATOR);
                    continue;
                }
                case 8: {
                    uri2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<Uri>)Uri.CREATOR);
                    continue;
                }
                case 9: {
                    uri3 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<Uri>)Uri.CREATOR);
                    continue;
                }
                case 10: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 11: {
                    c2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 12: {
                    n7 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 13: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 14: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 15: {
                    g4 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 17: {
                    c4 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 16: {
                    c3 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 1000: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 19: {
                    n9 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 18: {
                    n8 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 21: {
                    c5 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 20: {
                    n10 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 22: {
                    c6 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + b, parcel);
        }
        return new GameEntity(g, n, n2, n3, n4, n5, n6, uri, uri2, uri3, c, c2, n7, g2, g3, g4, c3, c4, n8, n9, n10, c5, c6);
    }
    
    public GameEntity[] a(final int n) {
        return new GameEntity[n];
    }
}
