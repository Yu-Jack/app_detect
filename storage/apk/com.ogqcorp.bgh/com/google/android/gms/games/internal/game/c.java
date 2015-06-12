// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.internal.game;

import com.google.android.gms.internal.fe;
import com.google.android.gms.internal.gw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import android.net.Uri;
import android.os.Parcel;

final class c extends d
{
    @Override
    public GameBadgeEntity a(final Parcel parcel) {
        if (GamesDowngradeableSafeParcel.b(fe.B()) || fe.b(GameBadgeEntity.class.getCanonicalName())) {
            return super.a(parcel);
        }
        final int int1 = parcel.readInt();
        final String string = parcel.readString();
        final String string2 = parcel.readString();
        final String string3 = parcel.readString();
        Uri parse;
        if (string3 == null) {
            parse = null;
        }
        else {
            parse = Uri.parse(string3);
        }
        return new GameBadgeEntity(1, int1, string, string2, parse);
    }
}
