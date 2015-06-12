// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer;

import com.google.android.gms.internal.fe;
import com.google.android.gms.internal.gw;
import com.google.android.gms.games.Player;
import android.os.Parcelable$Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.PlayerEntity;
import android.net.Uri;
import android.os.Parcel;

final class c extends d
{
    @Override
    public ParticipantEntity a(final Parcel parcel) {
        boolean b = true;
        if (GamesDowngradeableSafeParcel.b(fe.B()) || fe.b(ParticipantEntity.class.getCanonicalName())) {
            return super.a(parcel);
        }
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
        final String string4 = parcel.readString();
        Uri parse2;
        if (string4 == null) {
            parse2 = null;
        }
        else {
            parse2 = Uri.parse(string4);
        }
        final int int1 = parcel.readInt();
        final String string5 = parcel.readString();
        final boolean b2 = parcel.readInt() > 0 && b;
        if (parcel.readInt() <= 0) {
            b = false;
        }
        PlayerEntity playerEntity;
        if (b) {
            playerEntity = (PlayerEntity)PlayerEntity.CREATOR.createFromParcel(parcel);
        }
        else {
            playerEntity = null;
        }
        return new ParticipantEntity(3, string, string2, parse, parse2, int1, string5, b2, playerEntity, 7, null, null, null);
    }
}
