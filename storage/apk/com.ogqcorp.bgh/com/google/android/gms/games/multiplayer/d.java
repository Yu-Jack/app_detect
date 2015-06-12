// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.PlayerEntity;
import android.net.Uri;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class d implements Parcelable$Creator<ParticipantEntity>
{
    static void a(final ParticipantEntity participantEntity, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, participantEntity.k(), false);
        c.a(parcel, 2, participantEntity.f(), false);
        c.a(parcel, 3, (Parcelable)participantEntity.g(), n, false);
        c.a(parcel, 4, (Parcelable)participantEntity.i(), n, false);
        c.a(parcel, 5, participantEntity.b());
        c.a(parcel, 6, participantEntity.c(), false);
        c.a(parcel, 7, participantEntity.e());
        c.a(parcel, 8, (Parcelable)participantEntity.l(), n, false);
        c.a(parcel, 9, participantEntity.d());
        c.a(parcel, 10, (Parcelable)participantEntity.m(), n, false);
        c.a(parcel, 11, participantEntity.h(), false);
        c.a(parcel, 12, participantEntity.j(), false);
        c.a(parcel, 1000, participantEntity.n());
        c.a(parcel, a);
    }
    
    public ParticipantEntity a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        String n = null;
        String n2 = null;
        Uri uri = null;
        Uri uri2 = null;
        int g2 = 0;
        String n3 = null;
        boolean c = false;
        PlayerEntity playerEntity = null;
        int g3 = 0;
        ParticipantResult participantResult = null;
        String n4 = null;
        String n5 = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 2: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    uri = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<Uri>)Uri.CREATOR);
                    continue;
                }
                case 4: {
                    uri2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<Uri>)Uri.CREATOR);
                    continue;
                }
                case 5: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 6: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 7: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 8: {
                    playerEntity = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, PlayerEntity.CREATOR);
                    continue;
                }
                case 9: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 10: {
                    participantResult = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<ParticipantResult>)ParticipantResult.CREATOR);
                    continue;
                }
                case 11: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 12: {
                    n5 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 1000: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ParticipantEntity(g, n, n2, uri, uri2, g2, n3, c, playerEntity, g3, participantResult, n4, n5);
    }
    
    public ParticipantEntity[] a(final int n) {
        return new ParticipantEntity[n];
    }
}
