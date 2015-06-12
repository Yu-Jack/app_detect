// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class cd implements Parcelable$Creator
{
    static void a(final ce ce, final Parcel parcel, final int n) {
        final int c = b.C(parcel);
        b.c(parcel, 1, ce.versionCode);
        b.a(parcel, 2, ce.oa, false);
        b.a(parcel, 3, ce.ob, false);
        b.a(parcel, 4, ce.mimeType, false);
        b.a(parcel, 5, ce.packageName, false);
        b.a(parcel, 6, ce.oc, false);
        b.a(parcel, 7, ce.od, false);
        b.a(parcel, 8, ce.oe, false);
        b.G(parcel, c);
    }
    
    public ce e(final Parcel parcel) {
        String o = null;
        final int b = a.B(parcel);
        int g = 0;
        String o2 = null;
        String o3 = null;
        String o4 = null;
        String o5 = null;
        String o6 = null;
        String o7 = null;
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
                    o7 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 3: {
                    o6 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 4: {
                    o5 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 5: {
                    o4 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 6: {
                    o3 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 7: {
                    o2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
                case 8: {
                    o = com.google.android.gms.common.internal.safeparcel.a.o(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new a$a("Overread allowed size end=" + b, parcel);
        }
        return new ce(g, o7, o6, o5, o4, o3, o2, o);
    }
    
    public ce[] i(final int n) {
        return new ce[n];
    }
}
