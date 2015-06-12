// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer;

import java.util.ArrayList;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.List;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class b implements Parcelable$Creator<InvitationEntity>
{
    static void a(final InvitationEntity invitationEntity, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, (Parcelable)invitationEntity.d(), n, false);
        c.a(parcel, 1000, invitationEntity.b());
        c.a(parcel, 2, invitationEntity.e(), false);
        c.a(parcel, 3, invitationEntity.g());
        c.a(parcel, 4, invitationEntity.h());
        c.a(parcel, 5, (Parcelable)invitationEntity.f(), n, false);
        c.b(parcel, 6, invitationEntity.l(), false);
        c.a(parcel, 7, invitationEntity.i());
        c.a(parcel, 8, invitationEntity.j());
        c.a(parcel, a);
    }
    
    public InvitationEntity a(final Parcel parcel) {
        ArrayList<ParticipantEntity> c = null;
        int g = 0;
        final int b = a.b(parcel);
        long i = 0L;
        int g2 = 0;
        ParticipantEntity participantEntity = null;
        int g3 = 0;
        String n = null;
        GameEntity gameEntity = null;
        int g4 = 0;
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
                    g4 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
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
                    participantEntity = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, ParticipantEntity.CREATOR);
                    continue;
                }
                case 6: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, ParticipantEntity.CREATOR);
                    continue;
                }
                case 7: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 8: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + b, parcel);
        }
        return new InvitationEntity(g4, gameEntity, n, i, g3, participantEntity, c, g2, g);
    }
    
    public InvitationEntity[] a(final int n) {
        return new InvitationEntity[n];
    }
}
