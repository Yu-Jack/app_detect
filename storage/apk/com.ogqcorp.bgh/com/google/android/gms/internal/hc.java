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

public class hc implements Parcelable$Creator<fx>
{
    static void a(final fx fx, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, fx.a());
        c.b(parcel, 2, fx.b(), false);
        c.a(parcel, a);
    }
    
    public fx a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        ArrayList<fx$a> c = null;
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
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, (android.os.Parcelable$Creator<fx$a>)fx$a.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new fx(g, c);
    }
    
    public fx[] a(final int n) {
        return new fx[n];
    }
}
