// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class jv implements Parcelable$Creator<ix>
{
    static void a(final ix ix, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, ix.a());
        c.a(parcel, 2, ix.a, false);
        c.a(parcel, 3, ix.b, false);
        c.a(parcel, a);
    }
    
    public ix a(final Parcel parcel) {
        String[] z = null;
        final int b = a.b(parcel);
        int g = 0;
        byte[][] r = null;
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
                    z = com.google.android.gms.common.internal.safeparcel.a.z(parcel, a);
                    continue;
                }
                case 3: {
                    r = com.google.android.gms.common.internal.safeparcel.a.r(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ix(g, z, r);
    }
    
    public ix[] a(final int n) {
        return new ix[n];
    }
}
