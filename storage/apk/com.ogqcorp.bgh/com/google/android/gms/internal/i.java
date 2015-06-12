// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.List;
import android.os.Bundle;
import com.google.android.gms.common.internal.safeparcel.b;
import android.location.Location;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class i implements Parcelable$Creator<ah>
{
    static void a(final ah ah, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, ah.a);
        c.a(parcel, 2, ah.b);
        c.a(parcel, 3, ah.c, false);
        c.a(parcel, 4, ah.d);
        c.a(parcel, 5, ah.e, false);
        c.a(parcel, 6, ah.f);
        c.a(parcel, 7, ah.g);
        c.a(parcel, 8, ah.h);
        c.a(parcel, 9, ah.i, false);
        c.a(parcel, 10, (Parcelable)ah.j, n, false);
        c.a(parcel, 11, (Parcelable)ah.k, n, false);
        c.a(parcel, 12, ah.l, false);
        c.a(parcel, a);
    }
    
    public ah a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        long i = 0L;
        Bundle p = null;
        int g2 = 0;
        List<String> a = null;
        boolean c = false;
        int g3 = 0;
        boolean c2 = false;
        String n = null;
        av av = null;
        Location location = null;
        String n2 = null;
        while (parcel.dataPosition() < b) {
            final int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a2)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a2);
                    continue;
                }
                case 1: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a2);
                    continue;
                }
                case 2: {
                    i = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a2);
                    continue;
                }
                case 3: {
                    p = com.google.android.gms.common.internal.safeparcel.a.p(parcel, a2);
                    continue;
                }
                case 4: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a2);
                    continue;
                }
                case 5: {
                    a = com.google.android.gms.common.internal.safeparcel.a.A(parcel, a2);
                    continue;
                }
                case 6: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a2);
                    continue;
                }
                case 7: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a2);
                    continue;
                }
                case 8: {
                    c2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a2);
                    continue;
                }
                case 9: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    continue;
                }
                case 10: {
                    av = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a2, (android.os.Parcelable$Creator<av>)com.google.android.gms.internal.av.CREATOR);
                    continue;
                }
                case 11: {
                    location = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a2, (android.os.Parcelable$Creator<Location>)Location.CREATOR);
                    continue;
                }
                case 12: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ah(g, i, p, g2, a, c, g3, c2, n, av, location, n2);
    }
    
    public ah[] a(final int n) {
        return new ah[n];
    }
}
