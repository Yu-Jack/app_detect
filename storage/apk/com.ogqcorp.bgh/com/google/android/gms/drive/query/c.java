// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.query;

import java.util.List;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class c implements Parcelable$Creator<SortOrder>
{
    static void a(final SortOrder sortOrder, final Parcel parcel, final int n) {
        final int a = com.google.android.gms.common.internal.safeparcel.c.a(parcel);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1000, sortOrder.b);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, 1, sortOrder.a, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, a);
    }
    
    public SortOrder a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        Object c = null;
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
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, (android.os.Parcelable$Creator<Object>)FieldWithSortOrder.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new SortOrder(g, (List<FieldWithSortOrder>)c);
    }
    
    public SortOrder[] a(final int n) {
        return new SortOrder[n];
    }
}
