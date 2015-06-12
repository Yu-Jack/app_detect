// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.query.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class c implements Parcelable$Creator<FieldWithSortOrder>
{
    static void a(final FieldWithSortOrder fieldWithSortOrder, final Parcel parcel, final int n) {
        final int a = com.google.android.gms.common.internal.safeparcel.c.a(parcel);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1000, fieldWithSortOrder.c);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1, fieldWithSortOrder.a, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, fieldWithSortOrder.b);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, a);
    }
    
    public FieldWithSortOrder a(final Parcel parcel) {
        boolean c = false;
        final int b = a.b(parcel);
        String n = null;
        int g = 0;
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
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 2: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new FieldWithSortOrder(g, n, c);
    }
    
    public FieldWithSortOrder[] a(final int n) {
        return new FieldWithSortOrder[n];
    }
}
