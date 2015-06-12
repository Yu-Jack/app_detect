// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.cast;

import java.util.List;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class b implements Parcelable$Creator<CastDevice>
{
    static void a(final CastDevice castDevice, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, castDevice.a());
        c.a(parcel, 2, castDevice.b(), false);
        c.a(parcel, 3, castDevice.a, false);
        c.a(parcel, 4, castDevice.c(), false);
        c.a(parcel, 5, castDevice.d(), false);
        c.a(parcel, 6, castDevice.e(), false);
        c.a(parcel, 7, castDevice.f());
        c.b(parcel, 8, castDevice.g(), false);
        c.a(parcel, a);
    }
    
    public CastDevice a(final Parcel parcel) {
        int g = 0;
        List<WebImage> c = null;
        final int b = a.b(parcel);
        String n = null;
        String n2 = null;
        String n3 = null;
        String n4 = null;
        String n5 = null;
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
                    n5 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 4: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
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
                case 7: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 8: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, WebImage.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + b, parcel);
        }
        return new CastDevice(g2, n5, n4, n3, n2, n, g, c);
    }
    
    public CastDevice[] a(final int n) {
        return new CastDevice[n];
    }
}
