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

public class e implements Parcelable$Creator<LatLngBounds>
{
    static void a(final LatLngBounds latLngBounds, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, latLngBounds.a());
        c.a(parcel, 2, (Parcelable)latLngBounds.a, n, false);
        c.a(parcel, 3, (Parcelable)latLngBounds.b, n, false);
        c.a(parcel, a);
    }
    
    public LatLngBounds a(final Parcel parcel) {
        LatLng latLng = null;
        final int b = a.b(parcel);
        int n = 0;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            LatLng latLng3 = null;
            LatLng latLng4 = null;
            int n2 = 0;
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    latLng3 = latLng;
                    latLng4 = latLng2;
                    n2 = n;
                    break;
                }
                case 1: {
                    final int g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    final LatLng latLng5 = latLng;
                    latLng4 = latLng2;
                    n2 = g;
                    latLng3 = latLng5;
                    break;
                }
                case 2: {
                    final LatLng latLng6 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<LatLng>)LatLng.CREATOR);
                    n2 = n;
                    latLng3 = latLng;
                    latLng4 = latLng6;
                    break;
                }
                case 3: {
                    latLng3 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<LatLng>)LatLng.CREATOR);
                    latLng4 = latLng2;
                    n2 = n;
                    break;
                }
            }
            n = n2;
            latLng2 = latLng4;
            latLng = latLng3;
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new LatLngBounds(n, latLng2, latLng);
    }
    
    public LatLngBounds[] a(final int n) {
        return new LatLngBounds[n];
    }
}
