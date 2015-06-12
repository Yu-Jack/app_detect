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

public class hb implements Parcelable$Creator<fv>
{
    static void a(final fv fv, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, fv.a());
        c.a(parcel, 2, (Parcelable)fv.b(), n, false);
        c.a(parcel, a);
    }
    
    public fv a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        fx fx = null;
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
                    fx = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<fx>)com.google.android.gms.internal.fx.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new fv(g, fx);
    }
    
    public fv[] a(final int n) {
        return new fv[n];
    }
}
