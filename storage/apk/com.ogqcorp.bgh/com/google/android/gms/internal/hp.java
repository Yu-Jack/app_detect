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

public class hp implements Parcelable$Creator<gd$a>
{
    static void a(final gd$a gd$a, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, gd$a.a);
        c.a(parcel, 2, gd$a.b, false);
        c.b(parcel, 3, gd$a.c, false);
        c.a(parcel, a);
    }
    
    public gd$a a(final Parcel parcel) {
        ArrayList<gd$b> c = null;
        final int b = a.b(parcel);
        int g = 0;
        String n = null;
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
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, (android.os.Parcelable$Creator<gd$b>)gd$b.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new gd$a(g, n, c);
    }
    
    public gd$a[] a(final int n) {
        return new gd$a[n];
    }
}
