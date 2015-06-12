// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class k implements Parcelable$Creator<StreetViewPanoramaLink>
{
    static void a(final StreetViewPanoramaLink streetViewPanoramaLink, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, streetViewPanoramaLink.a());
        c.a(parcel, 2, streetViewPanoramaLink.a, false);
        c.a(parcel, 3, streetViewPanoramaLink.b);
        c.a(parcel, a);
    }
    
    public StreetViewPanoramaLink a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        String n = null;
        float k = 0.0f;
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
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    k = com.google.android.gms.common.internal.safeparcel.a.k(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new StreetViewPanoramaLink(g, n, k);
    }
    
    public StreetViewPanoramaLink[] a(final int n) {
        return new StreetViewPanoramaLink[n];
    }
}
