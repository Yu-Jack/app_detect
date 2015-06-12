// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.IBinder;
import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class cp implements Parcelable$Creator
{
    static void a(final cq cq, final Parcel parcel, final int n) {
        final int c = b.C(parcel);
        b.c(parcel, 1, cq.versionCode);
        b.a(parcel, 2, cq.bd(), false);
        b.a(parcel, 3, cq.be(), false);
        b.a(parcel, 4, cq.bf(), false);
        b.a(parcel, 5, cq.bg(), false);
        b.G(parcel, c);
    }
    
    public cq g(final Parcel parcel) {
        IBinder p = null;
        final int b = a.B(parcel);
        int g = 0;
        IBinder p2 = null;
        IBinder p3 = null;
        IBinder p4 = null;
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
                case 2: {
                    p4 = com.google.android.gms.common.internal.safeparcel.a.p(parcel, a);
                    continue;
                }
                case 3: {
                    p3 = com.google.android.gms.common.internal.safeparcel.a.p(parcel, a);
                    continue;
                }
                case 4: {
                    p2 = com.google.android.gms.common.internal.safeparcel.a.p(parcel, a);
                    continue;
                }
                case 5: {
                    p = com.google.android.gms.common.internal.safeparcel.a.p(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new a$a("Overread allowed size end=" + b, parcel);
        }
        return new cq(g, p4, p3, p2, p);
    }
    
    public cq[] k(final int n) {
        return new cq[n];
    }
}
