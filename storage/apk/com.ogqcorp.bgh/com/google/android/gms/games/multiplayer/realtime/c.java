// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import java.util.ArrayList;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.games.multiplayer.Participant;
import java.util.List;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class c implements Parcelable$Creator<RoomEntity>
{
    static void a(final RoomEntity roomEntity, final Parcel parcel, final int n) {
        final int a = com.google.android.gms.common.internal.safeparcel.c.a(parcel);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1, roomEntity.b(), false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1000, roomEntity.j());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, roomEntity.c(), false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 3, roomEntity.d());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 4, roomEntity.e());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 5, roomEntity.f(), false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 6, roomEntity.g());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 7, roomEntity.h(), false);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, 8, roomEntity.l(), false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 9, roomEntity.i());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, a);
    }
    
    public RoomEntity a(final Parcel parcel) {
        int g = 0;
        ArrayList<ParticipantEntity> c = null;
        final int b = a.b(parcel);
        long i = 0L;
        Bundle p = null;
        int g2 = 0;
        String n = null;
        int g3 = 0;
        String n2 = null;
        String n3 = null;
        int g4 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 1000: {
                    g4 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    i = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 4: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 5: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 6: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 7: {
                    p = com.google.android.gms.common.internal.safeparcel.a.p(parcel, a);
                    continue;
                }
                case 8: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, ParticipantEntity.CREATOR);
                    continue;
                }
                case 9: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new RoomEntity(g4, n3, n2, i, g3, n, g2, p, c, g);
    }
    
    public RoomEntity[] a(final int n) {
        return new RoomEntity[n];
    }
}
