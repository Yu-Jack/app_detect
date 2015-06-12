// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.query.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class i implements Parcelable$Creator<NotFilter>
{
    static void a(final NotFilter notFilter, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1000, notFilter.b);
        c.a(parcel, 1, (Parcelable)notFilter.a, n, false);
        c.a(parcel, a);
    }
    
    public NotFilter a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        FilterHolder filterHolder = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1000: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 1: {
                    filterHolder = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, FilterHolder.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new NotFilter(g, filterHolder);
    }
    
    public NotFilter[] a(final int n) {
        return new NotFilter[n];
    }
}
