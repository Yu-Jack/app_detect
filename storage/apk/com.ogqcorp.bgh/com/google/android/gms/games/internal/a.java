// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class a implements Parcelable$Creator<ConnectionInfo>
{
    static void a(final ConnectionInfo connectionInfo, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, connectionInfo.b(), false);
        c.a(parcel, 1000, connectionInfo.a());
        c.a(parcel, 2, connectionInfo.c());
        c.a(parcel, a);
    }
    
    public ConnectionInfo a(final Parcel parcel) {
        int g = 0;
        final int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        String n = null;
        int g2 = 0;
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
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ConnectionInfo(g2, n, g);
    }
    
    public ConnectionInfo[] a(final int n) {
        return new ConnectionInfo[n];
    }
}
