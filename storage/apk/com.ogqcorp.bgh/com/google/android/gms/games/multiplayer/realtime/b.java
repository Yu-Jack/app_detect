// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer.realtime;

import java.util.Collection;
import com.google.android.gms.internal.fe;
import com.google.android.gms.internal.gw;
import com.google.android.gms.games.multiplayer.Participant;
import android.os.Parcelable$Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import android.os.Bundle;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;
import android.os.Parcel;

final class b extends c
{
    @Override
    public RoomEntity a(final Parcel parcel) {
        if (GamesDowngradeableSafeParcel.b(fe.B()) || fe.b(RoomEntity.class.getCanonicalName())) {
            return super.a(parcel);
        }
        final String string = parcel.readString();
        final String string2 = parcel.readString();
        final long long1 = parcel.readLong();
        final int int1 = parcel.readInt();
        final String string3 = parcel.readString();
        final int int2 = parcel.readInt();
        final Bundle bundle = parcel.readBundle();
        final int int3 = parcel.readInt();
        final ArrayList list = new ArrayList<ParticipantEntity>(int3);
        for (int i = 0; i < int3; ++i) {
            list.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
        }
        return new RoomEntity(2, string, string2, long1, int1, string3, int2, bundle, (ArrayList<ParticipantEntity>)list, -1);
    }
}
