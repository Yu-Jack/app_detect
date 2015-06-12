// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.internal.request;

import java.util.ArrayList;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.request.GameRequestEntity;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.games.request.GameRequest;
import java.util.List;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class a implements Parcelable$Creator<GameRequestCluster>
{
    static void a(final GameRequestCluster gameRequestCluster, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.b(parcel, 1, gameRequestCluster.c(), false);
        c.a(parcel, 1000, gameRequestCluster.b());
        c.a(parcel, a);
    }
    
    public GameRequestCluster a(final Parcel parcel) {
        final int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int g = 0;
        ArrayList<GameRequestEntity> c = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, (android.os.Parcelable$Creator<GameRequestEntity>)GameRequestEntity.CREATOR);
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
        return new GameRequestCluster(g, c);
    }
    
    public GameRequestCluster[] a(final int n) {
        return new GameRequestCluster[n];
    }
}
