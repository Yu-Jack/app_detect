// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class a implements Parcelable$Creator<GoogleMapOptions>
{
    static void a(final GoogleMapOptions googleMapOptions, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, googleMapOptions.a());
        c.a(parcel, 2, googleMapOptions.b());
        c.a(parcel, 3, googleMapOptions.c());
        c.a(parcel, 4, googleMapOptions.j());
        c.a(parcel, 5, (Parcelable)googleMapOptions.k(), n, false);
        c.a(parcel, 6, googleMapOptions.d());
        c.a(parcel, 7, googleMapOptions.e());
        c.a(parcel, 8, googleMapOptions.f());
        c.a(parcel, 9, googleMapOptions.g());
        c.a(parcel, 10, googleMapOptions.h());
        c.a(parcel, 11, googleMapOptions.i());
        c.a(parcel, a);
    }
    
    public GoogleMapOptions a(final Parcel parcel) {
        byte e = 0;
        final int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        CameraPosition cameraPosition = null;
        byte e2 = 0;
        byte e3 = 0;
        byte e4 = 0;
        byte e5 = 0;
        byte e6 = 0;
        int g = 0;
        byte e7 = 0;
        byte e8 = 0;
        int g2 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    e8 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, a);
                    continue;
                }
                case 3: {
                    e7 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, a);
                    continue;
                }
                case 4: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 5: {
                    cameraPosition = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<CameraPosition>)CameraPosition.CREATOR);
                    continue;
                }
                case 6: {
                    e6 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, a);
                    continue;
                }
                case 7: {
                    e5 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, a);
                    continue;
                }
                case 8: {
                    e4 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, a);
                    continue;
                }
                case 9: {
                    e3 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, a);
                    continue;
                }
                case 10: {
                    e2 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, a);
                    continue;
                }
                case 11: {
                    e = com.google.android.gms.common.internal.safeparcel.a.e(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new GoogleMapOptions(g2, e8, e7, g, cameraPosition, e6, e5, e4, e3, e2, e);
    }
    
    public GoogleMapOptions[] a(final int n) {
        return new GoogleMapOptions[n];
    }
}
