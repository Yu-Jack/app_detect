// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.internal.game;

import java.util.Collection;
import com.google.android.gms.internal.fe;
import com.google.android.gms.internal.gw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;
import com.google.android.gms.games.GameEntity;
import android.os.Parcel;

final class a extends b
{
    @Override
    public ExtendedGameEntity a(final Parcel parcel) {
        if (GamesDowngradeableSafeParcel.b(fe.B()) || fe.b(ExtendedGameEntity.class.getCanonicalName())) {
            return super.a(parcel);
        }
        final GameEntity gameEntity = (GameEntity)GameEntity.CREATOR.createFromParcel(parcel);
        final int int1 = parcel.readInt();
        final boolean b = parcel.readInt() == 1;
        final int int2 = parcel.readInt();
        final long long1 = parcel.readLong();
        final long long2 = parcel.readLong();
        final String string = parcel.readString();
        final long long3 = parcel.readLong();
        final String string2 = parcel.readString();
        final int int3 = parcel.readInt();
        final ArrayList list = new ArrayList<GameBadgeEntity>(int3);
        for (int i = 0; i < int3; ++i) {
            list.add(GameBadgeEntity.CREATOR.a(parcel));
        }
        return new ExtendedGameEntity(1, gameEntity, int1, b, int2, long1, long2, string, long3, string2, (ArrayList<GameBadgeEntity>)list);
    }
}
