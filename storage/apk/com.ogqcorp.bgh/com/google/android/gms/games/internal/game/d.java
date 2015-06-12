// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.internal.safeparcel.b;
import android.net.Uri;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class d implements Parcelable$Creator<GameBadgeEntity>
{
    static void a(final GameBadgeEntity gameBadgeEntity, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, gameBadgeEntity.b());
        c.a(parcel, 1000, gameBadgeEntity.f());
        c.a(parcel, 2, gameBadgeEntity.c(), false);
        c.a(parcel, 3, gameBadgeEntity.d(), false);
        c.a(parcel, 4, (Parcelable)gameBadgeEntity.e(), n, false);
        c.a(parcel, a);
    }
    
    public GameBadgeEntity a(final Parcel parcel) {
        int g = 0;
        Uri uri = null;
        final int b = a.b(parcel);
        String n = null;
        String n2 = null;
        int g2 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 1000: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 4: {
                    uri = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<Uri>)Uri.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new GameBadgeEntity(g2, g, n2, n, uri);
    }
    
    public GameBadgeEntity[] a(final int n) {
        return new GameBadgeEntity[n];
    }
}
