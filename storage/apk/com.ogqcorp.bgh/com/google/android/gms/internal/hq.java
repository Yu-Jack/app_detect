// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class hq implements Parcelable$Creator<gg>
{
    static void a(final gg gg, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, gg.a());
        c.a(parcel, 2, gg.e(), false);
        c.a(parcel, 3, (Parcelable)gg.f(), n, false);
        c.a(parcel, a);
    }
    
    public gg a(final Parcel parcel) {
        gd gd = null;
        final int b = a.b(parcel);
        int g = 0;
        Parcel b2 = null;
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
                    b2 = com.google.android.gms.common.internal.safeparcel.a.B(parcel, a);
                    continue;
                }
                case 3: {
                    gd = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<gd>)com.google.android.gms.internal.gd.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new gg(g, b2, gd);
    }
    
    public gg[] a(final int n) {
        return new gg[n];
    }
}
