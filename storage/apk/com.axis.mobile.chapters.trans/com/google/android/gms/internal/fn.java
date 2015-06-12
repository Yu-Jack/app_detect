// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class fn implements Parcelable$Creator
{
    static void a(final fm fm, final Parcel parcel, final int n) {
        final int c = b.C(parcel);
        b.c(parcel, 1, fm.id);
        b.c(parcel, 1000, fm.xM);
        b.a(parcel, 2, fm.xY, false);
        b.G(parcel, c);
    }
    
    public fm[] G(final int n) {
        return new fm[n];
    }
    
    public fm o(final Parcel parcel) {
        int g = 0;
        final int b = a.B(parcel);
        Bundle q = null;
        int g2 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 1000: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    q = com.google.android.gms.common.internal.safeparcel.a.q(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new a$a("Overread allowed size end=" + b, parcel);
        }
        return new fm(g2, g, q);
    }
}
