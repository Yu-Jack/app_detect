// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer;

import java.util.Collection;
import com.google.android.gms.games.Game;
import com.google.android.gms.internal.fe;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gz;
import android.os.Parcelable$Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;
import com.google.android.gms.games.GameEntity;
import android.os.Parcel;

final class a extends b
{
    @Override
    public InvitationEntity a(final Parcel parcel) {
        if (GamesDowngradeableSafeParcel.b(fe.B()) || fe.b(InvitationEntity.class.getCanonicalName())) {
            return super.a(parcel);
        }
        final GameEntity gameEntity = (GameEntity)GameEntity.CREATOR.createFromParcel(parcel);
        final String string = parcel.readString();
        final long long1 = parcel.readLong();
        final int int1 = parcel.readInt();
        final ParticipantEntity participantEntity = (ParticipantEntity)ParticipantEntity.CREATOR.createFromParcel(parcel);
        final int int2 = parcel.readInt();
        final ArrayList list = new ArrayList<ParticipantEntity>(int2);
        for (int i = 0; i < int2; ++i) {
            list.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
        }
        return new InvitationEntity(2, gameEntity, string, long1, int1, participantEntity, (ArrayList<ParticipantEntity>)list, -1, 0);
    }
}
