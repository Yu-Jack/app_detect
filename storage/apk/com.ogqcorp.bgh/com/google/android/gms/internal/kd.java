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

public class kd implements Parcelable$Creator<jo>
{
    static void a(final jo jo, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, jo.a());
        c.a(parcel, 2, jo.a, false);
        c.a(parcel, 3, (Parcelable)jo.b, n, false);
        c.a(parcel, 4, jo.c, false);
        c.a(parcel, 5, (Parcelable)jo.d, n, false);
        c.a(parcel, a);
    }
    
    public jo a(final Parcel parcel) {
        ju ju = null;
        final int b = a.b(parcel);
        int g = 0;
        String n = null;
        jp jp = null;
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
                    jp = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, com.google.android.gms.internal.jp.CREATOR);
                    continue;
                }
                case 4: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 5: {
                    ju = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, com.google.android.gms.internal.ju.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new jo(g, n2, jp, n, ju);
    }
    
    public jo[] a(final int n) {
        return new jo[n];
    }
}
