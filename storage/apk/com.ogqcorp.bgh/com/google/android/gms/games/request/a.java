// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.request;

import android.os.Bundle;
import java.util.ArrayList;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class a implements Parcelable$Creator<GameRequestEntity>
{
    static void a(final GameRequestEntity gameRequestEntity, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, (Parcelable)gameRequestEntity.e(), n, false);
        c.a(parcel, 1000, gameRequestEntity.b());
        c.a(parcel, 2, (Parcelable)gameRequestEntity.f(), n, false);
        c.a(parcel, 3, gameRequestEntity.h(), false);
        c.a(parcel, 4, gameRequestEntity.d(), false);
        c.b(parcel, 5, gameRequestEntity.n(), false);
        c.a(parcel, 7, gameRequestEntity.i());
        c.a(parcel, 9, gameRequestEntity.j());
        c.a(parcel, 10, gameRequestEntity.k());
        c.a(parcel, 11, gameRequestEntity.c(), false);
        c.a(parcel, 12, gameRequestEntity.l());
        c.a(parcel, a);
    }
    
    public GameRequestEntity a(final Parcel parcel) {
        final int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int g = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        byte[] q = null;
        String n = null;
        ArrayList<PlayerEntity> c = null;
        int g2 = 0;
        long i = 0L;
        long j = 0L;
        Bundle p = null;
        int g3 = 0;
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
                    playerEntity = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, PlayerEntity.CREATOR);
                    continue;
                }
                case 3: {
                    q = com.google.android.gms.common.internal.safeparcel.a.q(parcel, a);
                    continue;
                }
                case 4: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 5: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, PlayerEntity.CREATOR);
                    continue;
                }
                case 7: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 9: {
                    i = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 10: {
                    j = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 11: {
                    p = com.google.android.gms.common.internal.safeparcel.a.p(parcel, a);
                    continue;
                }
                case 12: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new GameRequestEntity(g, gameEntity, playerEntity, q, n, c, g2, i, j, p, g3);
    }
    
    public GameRequestEntity[] a(final int n) {
        return new GameRequestEntity[n];
    }
}
