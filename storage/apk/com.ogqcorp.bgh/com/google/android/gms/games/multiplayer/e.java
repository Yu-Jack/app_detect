// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class e implements Parcelable$Creator<ParticipantResult>
{
    static void a(final ParticipantResult participantResult, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, participantResult.b(), false);
        c.a(parcel, 1000, participantResult.a());
        c.a(parcel, 2, participantResult.c());
        c.a(parcel, 3, participantResult.d());
        c.a(parcel, a);
    }
    
    public ParticipantResult a(final Parcel parcel) {
        int g = 0;
        final int b = a.b(parcel);
        String n = null;
        int g2 = 0;
        int g3 = 0;
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
                case 1000: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 3: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ParticipantResult(g3, n, g2, g);
    }
    
    public ParticipantResult[] a(final int n) {
        return new ParticipantResult[n];
    }
}
