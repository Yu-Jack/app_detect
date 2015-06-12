// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.internal.multiplayer;

import java.util.ArrayList;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.games.multiplayer.Invitation;
import java.util.List;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class a implements Parcelable$Creator<ZInvitationCluster>
{
    static void a(final ZInvitationCluster zInvitationCluster, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.b(parcel, 1, zInvitationCluster.c(), false);
        c.a(parcel, 1000, zInvitationCluster.b());
        c.a(parcel, a);
    }
    
    public ZInvitationCluster a(final Parcel parcel) {
        final int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int g = 0;
        ArrayList<InvitationEntity> c = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, InvitationEntity.CREATOR);
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
        return new ZInvitationCluster(g, c);
    }
    
    public ZInvitationCluster[] a(final int n) {
        return new ZInvitationCluster[n];
    }
}
