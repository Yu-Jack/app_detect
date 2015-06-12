// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class ja implements Parcelable$Creator<hs>
{
    static void a(final hs hs, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, hs.b, false);
        c.a(parcel, 1000, hs.a);
        c.a(parcel, 2, hs.c, false);
        c.a(parcel, a);
    }
    
    public hs a(final Parcel parcel) {
        String n = null;
        final int b = a.b(parcel);
        int g = 0;
        String n2 = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 1000: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new hs(g, n2, n);
    }
    
    public hs[] a(final int n) {
        return new hs[n];
    }
}
