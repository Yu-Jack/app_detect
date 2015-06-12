// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class hl implements Parcelable$Creator<gd$b>
{
    static void a(final gd$b gd$b, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, gd$b.a);
        c.a(parcel, 2, gd$b.b, false);
        c.a(parcel, 3, (Parcelable)gd$b.c, n, false);
        c.a(parcel, a);
    }
    
    public gd$b a(final Parcel parcel) {
        ga$a<?, ?> ga$a = null;
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
                    ga$a = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<ga$a<?, ?>>)com.google.android.gms.internal.ga$a.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new gd$b(g, n, ga$a);
    }
    
    public gd$b[] a(final int n) {
        return new gd$b[n];
    }
}
