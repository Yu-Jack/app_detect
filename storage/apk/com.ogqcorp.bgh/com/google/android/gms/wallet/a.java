// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class a implements Parcelable$Creator<Address>
{
    static void a(final Address address, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, address.a());
        c.a(parcel, 2, address.a, false);
        c.a(parcel, 3, address.b, false);
        c.a(parcel, 4, address.c, false);
        c.a(parcel, 5, address.d, false);
        c.a(parcel, 6, address.e, false);
        c.a(parcel, 7, address.f, false);
        c.a(parcel, 8, address.g, false);
        c.a(parcel, 9, address.h, false);
        c.a(parcel, 10, address.i, false);
        c.a(parcel, 11, address.j);
        c.a(parcel, 12, address.k, false);
        c.a(parcel, a);
    }
    
    public Address a(final Parcel parcel) {
        final int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int g = 0;
        String n = null;
        String n2 = null;
        String n3 = null;
        String n4 = null;
        String n5 = null;
        String n6 = null;
        String n7 = null;
        String n8 = null;
        String n9 = null;
        boolean c = false;
        String n10 = null;
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
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 4: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 5: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 6: {
                    n5 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 7: {
                    n6 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 8: {
                    n7 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 9: {
                    n8 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 10: {
                    n9 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 11: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 12: {
                    n10 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new Address(g, n, n2, n3, n4, n5, n6, n7, n8, n9, c, n10);
    }
    
    public Address[] a(final int n) {
        return new Address[n];
    }
}
