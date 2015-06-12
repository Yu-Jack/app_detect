// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.identity.intents.model;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class b implements Parcelable$Creator<UserAddress>
{
    static void a(final UserAddress userAddress, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, userAddress.a());
        c.a(parcel, 2, userAddress.a, false);
        c.a(parcel, 3, userAddress.b, false);
        c.a(parcel, 4, userAddress.c, false);
        c.a(parcel, 5, userAddress.d, false);
        c.a(parcel, 6, userAddress.e, false);
        c.a(parcel, 7, userAddress.f, false);
        c.a(parcel, 8, userAddress.g, false);
        c.a(parcel, 9, userAddress.h, false);
        c.a(parcel, 10, userAddress.i, false);
        c.a(parcel, 11, userAddress.j, false);
        c.a(parcel, 12, userAddress.k, false);
        c.a(parcel, 13, userAddress.l, false);
        c.a(parcel, 14, userAddress.m);
        c.a(parcel, 15, userAddress.n, false);
        c.a(parcel, 16, userAddress.o, false);
        c.a(parcel, a);
    }
    
    public UserAddress a(final Parcel parcel) {
        final int b = a.b(parcel);
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
        String n10 = null;
        String n11 = null;
        String n12 = null;
        boolean c = false;
        String n13 = null;
        String n14 = null;
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
                    n10 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 12: {
                    n11 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 13: {
                    n12 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 14: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
                case 15: {
                    n13 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 16: {
                    n14 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + b, parcel);
        }
        return new UserAddress(g, n, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, c, n13, n14);
    }
    
    public UserAddress[] a(final int n) {
        return new UserAddress[n];
    }
}
