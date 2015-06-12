// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import java.util.ArrayList;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.games.multiplayer.Participant;
import java.util.List;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class b implements Parcelable$Creator<TurnBasedMatchEntity>
{
    static void a(final TurnBasedMatchEntity turnBasedMatchEntity, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, (Parcelable)turnBasedMatchEntity.b(), n, false);
        c.a(parcel, 2, turnBasedMatchEntity.c(), false);
        c.a(parcel, 3, turnBasedMatchEntity.d(), false);
        c.a(parcel, 4, turnBasedMatchEntity.e());
        c.a(parcel, 5, turnBasedMatchEntity.j(), false);
        c.a(parcel, 6, turnBasedMatchEntity.k());
        c.a(parcel, 7, turnBasedMatchEntity.m(), false);
        c.a(parcel, 8, turnBasedMatchEntity.f());
        c.a(parcel, 10, turnBasedMatchEntity.i());
        c.a(parcel, 11, turnBasedMatchEntity.o());
        c.a(parcel, 12, turnBasedMatchEntity.n(), false);
        c.b(parcel, 13, turnBasedMatchEntity.l(), false);
        c.a(parcel, 14, turnBasedMatchEntity.p(), false);
        c.a(parcel, 15, turnBasedMatchEntity.q(), false);
        c.a(parcel, 17, turnBasedMatchEntity.s(), false);
        c.a(parcel, 16, turnBasedMatchEntity.r());
        c.a(parcel, 1000, turnBasedMatchEntity.w());
        c.a(parcel, 19, turnBasedMatchEntity.u());
        c.a(parcel, 18, turnBasedMatchEntity.g());
        c.a(parcel, 21, turnBasedMatchEntity.v(), false);
        c.a(parcel, 20, turnBasedMatchEntity.h(), false);
        c.a(parcel, a);
    }
    
    public TurnBasedMatchEntity a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        GameEntity gameEntity = null;
        String n = null;
        String n2 = null;
        long i = 0L;
        String n3 = null;
        long j = 0L;
        String n4 = null;
        int g2 = 0;
        int g3 = 0;
        int g4 = 0;
        byte[] q = null;
        ArrayList<ParticipantEntity> c = null;
        String n5 = null;
        byte[] q2 = null;
        int g5 = 0;
        Bundle p = null;
        int g6 = 0;
        boolean c2 = false;
        String n6 = null;
        String n7 = null;
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
                case 2: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 4: {
                    i = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 5: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 6: {
                    j = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 7: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 8: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 10: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 11: {
                    g4 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 12: {
                    q = com.google.android.gms.common.internal.safeparcel.a.q(parcel, a);
                    continue;
                }
                case 13: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, ParticipantEntity.CREATOR);
                    continue;
                }
                case 14: {
                    n5 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 15: {
                    q2 = com.google.android.gms.common.internal.safeparcel.a.q(parcel, a);
                    continue;
                }
                case 17: {
                    p = com.google.android.gms.common.internal.safeparcel.a.p(parcel, a);
                    continue;
                }
                case 16: {
                    g5 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 1000: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 19: {
                    c2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 18: {
                    g6 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 21: {
                    n7 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 20: {
                    n6 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + b, parcel);
        }
        return new TurnBasedMatchEntity(g, gameEntity, n, n2, i, n3, j, n4, g2, g3, g4, q, c, n5, q2, g5, p, g6, c2, n6, n7);
    }
    
    public TurnBasedMatchEntity[] a(final int n) {
        return new TurnBasedMatchEntity[n];
    }
}
