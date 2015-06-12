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

public class kh implements Parcelable$Creator<jy>
{
    static void a(final jy jy, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, jy.a());
        c.a(parcel, 2, jy.a, false);
        c.a(parcel, 3, jy.b, false);
        c.a(parcel, 4, (Parcelable)jy.c, n, false);
        c.a(parcel, 5, (Parcelable)jy.d, n, false);
        c.a(parcel, 6, (Parcelable)jy.e, n, false);
        c.a(parcel, a);
    }
    
    public jy a(final Parcel parcel) {
        jw jw = null;
        final int b = a.b(parcel);
        int g = 0;
        jw jw2 = null;
        ju ju = null;
        String n = null;
        String n2 = null;
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
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 4: {
                    ju = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, com.google.android.gms.internal.ju.CREATOR);
                    continue;
                }
                case 5: {
                    jw2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, com.google.android.gms.internal.jw.CREATOR);
                    continue;
                }
                case 6: {
                    jw = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, com.google.android.gms.internal.jw.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new jy(g, n2, n, ju, jw2, jw);
    }
    
    public jy[] a(final int n) {
        return new jy[n];
    }
}
