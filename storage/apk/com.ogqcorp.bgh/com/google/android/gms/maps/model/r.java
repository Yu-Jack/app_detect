// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class r implements Parcelable$Creator<VisibleRegion>
{
    static void a(final VisibleRegion visibleRegion, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, visibleRegion.a());
        c.a(parcel, 2, (Parcelable)visibleRegion.a, n, false);
        c.a(parcel, 3, (Parcelable)visibleRegion.b, n, false);
        c.a(parcel, 4, (Parcelable)visibleRegion.c, n, false);
        c.a(parcel, 5, (Parcelable)visibleRegion.d, n, false);
        c.a(parcel, 6, (Parcelable)visibleRegion.e, n, false);
        c.a(parcel, a);
    }
    
    public VisibleRegion a(final Parcel parcel) {
        LatLngBounds latLngBounds = null;
        final int b = a.b(parcel);
        int g = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
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
                    latLng4 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<LatLng>)LatLng.CREATOR);
                    continue;
                }
                case 3: {
                    latLng3 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<LatLng>)LatLng.CREATOR);
                    continue;
                }
                case 4: {
                    latLng2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<LatLng>)LatLng.CREATOR);
                    continue;
                }
                case 5: {
                    latLng = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<LatLng>)LatLng.CREATOR);
                    continue;
                }
                case 6: {
                    latLngBounds = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<LatLngBounds>)LatLngBounds.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new VisibleRegion(g, latLng4, latLng3, latLng2, latLng, latLngBounds);
    }
    
    public VisibleRegion[] a(final int n) {
        return new VisibleRegion[n];
    }
}
