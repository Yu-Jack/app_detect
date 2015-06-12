// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class km implements Parcelable$Creator<ki>
{
    static void a(final ki ki, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, ki.a);
        c.a(parcel, 2, ki.a());
        c.a(parcel, 3, ki.b(), false);
        c.a(parcel, 4, ki.c(), false);
        c.a(parcel, 5, ki.d(), false);
        c.a(parcel, a);
    }
    
    public ki a(final Parcel parcel) {
        int g = 0;
        String n = null;
        final int b = a.b(parcel);
        byte[] q = null;
        String n2 = null;
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
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 3: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 4: {
                    q = com.google.android.gms.common.internal.safeparcel.a.q(parcel, a);
                    continue;
                }
                case 5: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ki(g2, g, n2, q, n);
    }
    
    public ki[] a(final int n) {
        return new ki[n];
    }
}
