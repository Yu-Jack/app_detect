// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class am implements Parcelable$Creator
{
    static void a(final al al, final Parcel parcel, final int n) {
        final int c = b.C(parcel);
        b.c(parcel, 1, al.versionCode);
        b.a(parcel, 2, al.me, false);
        b.c(parcel, 3, al.height);
        b.c(parcel, 4, al.heightPixels);
        b.a(parcel, 5, al.mf);
        b.c(parcel, 6, al.width);
        b.c(parcel, 7, al.widthPixels);
        b.a(parcel, 8, (Parcelable[])al.mg, n, false);
        b.G(parcel, c);
    }
    
    public al c(final Parcel parcel) {
        al[] array = null;
        int g = 0;
        final int b = a.B(parcel);
        int g2 = 0;
        boolean c = false;
        int g3 = 0;
        int g4 = 0;
        String o = null;
        int g5 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g5 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    o = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 3: {
                    g4 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 4: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 5: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 6: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 7: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 8: {
                    array = (al[])com.google.android.gms.common.internal.safeparcel.a.b(parcel, a, (Parcelable$Creator)al.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new a$a("Overread allowed size end=" + b, parcel);
        }
        return new al(g5, o, g4, g3, c, g2, g, array);
    }
    
    public al[] d(final int n) {
        return new al[n];
    }
}
