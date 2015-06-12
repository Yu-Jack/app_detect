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

public class hn implements Parcelable$Creator<gd>
{
    static void a(final gd gd, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, gd.b());
        c.b(parcel, 2, gd.c(), false);
        c.a(parcel, 3, gd.d(), false);
        c.a(parcel, a);
    }
    
    public gd a(final Parcel parcel) {
        String n = null;
        final int b = a.b(parcel);
        int g = 0;
        ArrayList<gd$a> c = null;
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
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, (android.os.Parcelable$Creator<gd$a>)gd$a.CREATOR);
                    continue;
                }
                case 3: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new gd(g, c, n);
    }
    
    public gd[] a(final int n) {
        return new gd[n];
    }
}
