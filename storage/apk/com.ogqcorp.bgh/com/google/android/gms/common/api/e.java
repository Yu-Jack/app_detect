// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.safeparcel.b;
import android.app.PendingIntent;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class e implements Parcelable$Creator<Status>
{
    static void a(final Status status, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, status.d());
        c.a(parcel, 1000, status.c());
        c.a(parcel, 2, status.b(), false);
        c.a(parcel, 3, (Parcelable)status.a(), n, false);
        c.a(parcel, a);
    }
    
    public Status a(final Parcel parcel) {
        PendingIntent pendingIntent = null;
        int g = 0;
        final int b = a.b(parcel);
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
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 1000: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    pendingIntent = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<PendingIntent>)PendingIntent.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new Status(g2, g, n, pendingIntent);
    }
    
    public Status[] a(final int n) {
        return new Status[n];
    }
}
