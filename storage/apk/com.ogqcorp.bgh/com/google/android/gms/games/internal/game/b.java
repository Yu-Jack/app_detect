// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.internal.game;

import java.util.ArrayList;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.List;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class b implements Parcelable$Creator<ExtendedGameEntity>
{
    static void a(final ExtendedGameEntity extendedGameEntity, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, (Parcelable)extendedGameEntity.m(), n, false);
        c.a(parcel, 1000, extendedGameEntity.l());
        c.a(parcel, 2, extendedGameEntity.d());
        c.a(parcel, 3, extendedGameEntity.e());
        c.a(parcel, 4, extendedGameEntity.f());
        c.a(parcel, 5, extendedGameEntity.g());
        c.a(parcel, 6, extendedGameEntity.h());
        c.a(parcel, 7, extendedGameEntity.i(), false);
        c.a(parcel, 8, extendedGameEntity.j());
        c.a(parcel, 9, extendedGameEntity.k(), false);
        c.b(parcel, 10, extendedGameEntity.c(), false);
        c.a(parcel, a);
    }
    
    public ExtendedGameEntity a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        GameEntity gameEntity = null;
        int g2 = 0;
        boolean c = false;
        int g3 = 0;
        long i = 0L;
        long j = 0L;
        String n = null;
        long k = 0L;
        String n2 = null;
        ArrayList<GameBadgeEntity> c2 = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    gameEntity = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, GameEntity.CREATOR);
                    continue;
                }
                case 1000: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 3: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 4: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 5: {
                    i = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 6: {
                    j = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 7: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 8: {
                    k = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 9: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 10: {
                    c2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, (android.os.Parcelable$Creator<GameBadgeEntity>)GameBadgeEntity.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + b, parcel);
        }
        return new ExtendedGameEntity(g, gameEntity, g2, c, g3, i, j, n, k, n2, c2);
    }
    
    public ExtendedGameEntity[] a(final int n) {
        return new ExtendedGameEntity[n];
    }
}
