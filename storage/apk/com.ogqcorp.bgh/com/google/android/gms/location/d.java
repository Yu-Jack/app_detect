// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.location;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class d implements Parcelable$Creator<LocationRequest>
{
    static void a(final LocationRequest locationRequest, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, locationRequest.a);
        c.a(parcel, 1000, locationRequest.a());
        c.a(parcel, 2, locationRequest.b);
        c.a(parcel, 3, locationRequest.c);
        c.a(parcel, 4, locationRequest.d);
        c.a(parcel, 5, locationRequest.e);
        c.a(parcel, 6, locationRequest.f);
        c.a(parcel, 7, locationRequest.g);
        c.a(parcel, a);
    }
    
    public LocationRequest a(final Parcel parcel) {
        boolean c = false;
        final int b = a.b(parcel);
        int g = 102;
        long i = 3600000L;
        long j = 600000L;
        long k = Long.MAX_VALUE;
        int g2 = Integer.MAX_VALUE;
        float l = 0.0f;
        int g3 = 0;
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
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    i = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 3: {
                    j = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 4: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 5: {
                    k = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 6: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 7: {
                    l = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new LocationRequest(g3, g, i, j, c, k, g2, l);
    }
    
    public LocationRequest[] a(final int n) {
        return new LocationRequest[n];
    }
}
