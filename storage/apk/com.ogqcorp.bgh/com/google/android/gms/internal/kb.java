// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.ArrayList;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.List;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class kb implements Parcelable$Creator<jm>
{
    static void a(final jm jm, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, jm.a());
        c.a(parcel, 2, jm.a, false);
        c.a(parcel, 3, jm.b, false);
        c.b(parcel, 4, jm.c, false);
        c.a(parcel, a);
    }
    
    public jm a(final Parcel parcel) {
        String n = null;
        final int b = a.b(parcel);
        int g = 0;
        ArrayList<jk> list = hr.a();
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
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 4: {
                    list = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, jk.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new jm(g, n2, n, list);
    }
    
    public jm[] a(final int n) {
        return new jm[n];
    }
}
