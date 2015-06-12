// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games;

import com.google.android.gms.internal.fe;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.fw;
import android.os.Parcelable$Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import android.net.Uri;
import android.os.Parcel;

final class c extends d
{
    @Override
    public PlayerEntity a(final Parcel parcel) {
        if (GamesDowngradeableSafeParcel.b(fe.B()) || fe.b(PlayerEntity.class.getCanonicalName())) {
            return super.a(parcel);
        }
        final String string = parcel.readString();
        final String string2 = parcel.readString();
        final String string3 = parcel.readString();
        final String string4 = parcel.readString();
        Uri parse;
        if (string3 == null) {
            parse = null;
        }
        else {
            parse = Uri.parse(string3);
        }
        Uri parse2;
        if (string4 == null) {
            parse2 = null;
        }
        else {
            parse2 = Uri.parse(string4);
        }
        return new PlayerEntity(4, string, string2, parse, parse2, parcel.readLong(), -1, -1L, null, null);
    }
}
