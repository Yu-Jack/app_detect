// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class h implements Parcelable$Creator<OnSyncMoreResponse>
{
    static void a(final OnSyncMoreResponse onSyncMoreResponse, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, onSyncMoreResponse.a);
        c.a(parcel, 2, onSyncMoreResponse.b);
        c.a(parcel, a);
    }
    
    public OnSyncMoreResponse a(final Parcel parcel) {
        boolean c = false;
        final int b = a.b(parcel);
        int g = 0;
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
                case 2: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new OnSyncMoreResponse(g, c);
    }
    
    public OnSyncMoreResponse[] a(final int n) {
        return new OnSyncMoreResponse[n];
    }
}
