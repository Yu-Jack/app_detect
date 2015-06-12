// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.List;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class iz implements Parcelable$Creator<ho>
{
    static void a(final ho ho, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, ho.a(), false);
        c.a(parcel, 1000, ho.a);
        c.a(parcel, 2, (Parcelable)ho.b(), n, false);
        c.a(parcel, 3, ho.c(), false);
        c.b(parcel, 4, ho.d(), false);
        c.a(parcel, 5, ho.e(), false);
        c.a(parcel, 6, ho.f(), false);
        c.a(parcel, a);
    }
    
    public ho a(final Parcel parcel) {
        String n = null;
        final int b = a.b(parcel);
        int g = 0;
        String n2 = null;
        List<hm> c = null;
        String n3 = null;
        LatLng latLng = null;
        String n4 = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 1000: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    latLng = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<LatLng>)LatLng.CREATOR);
                    continue;
                }
                case 3: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 4: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, (android.os.Parcelable$Creator<hm>)hm.CREATOR);
                    continue;
                }
                case 5: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 6: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ho(g, n4, latLng, n3, c, n2, n);
    }
    
    public ho[] a(final int n) {
        return new ho[n];
    }
}
