// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.query;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class b implements Parcelable$Creator<Query>
{
    static void a(final Query query, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1000, query.d);
        c.a(parcel, 1, (Parcelable)query.a, n, false);
        c.a(parcel, 3, query.b, false);
        c.a(parcel, 4, (Parcelable)query.c, n, false);
        c.a(parcel, a);
    }
    
    public Query a(final Parcel parcel) {
        SortOrder sortOrder = null;
        final int b = a.b(parcel);
        int n = 0;
        String s = null;
        LogicalFilter logicalFilter = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            SortOrder sortOrder2 = null;
            String s2 = null;
            LogicalFilter logicalFilter2 = null;
            int n2 = 0;
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    sortOrder2 = sortOrder;
                    s2 = s;
                    logicalFilter2 = logicalFilter;
                    n2 = n;
                    break;
                }
                case 1000: {
                    final int g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    final SortOrder sortOrder3 = sortOrder;
                    s2 = s;
                    logicalFilter2 = logicalFilter;
                    n2 = g;
                    sortOrder2 = sortOrder3;
                    break;
                }
                case 1: {
                    final LogicalFilter logicalFilter3 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, LogicalFilter.CREATOR);
                    n2 = n;
                    final String s3 = s;
                    logicalFilter2 = logicalFilter3;
                    sortOrder2 = sortOrder;
                    s2 = s3;
                    break;
                }
                case 3: {
                    final String n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    logicalFilter2 = logicalFilter;
                    n2 = n;
                    final SortOrder sortOrder4 = sortOrder;
                    s2 = n3;
                    sortOrder2 = sortOrder4;
                    break;
                }
                case 4: {
                    sortOrder2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, SortOrder.CREATOR);
                    s2 = s;
                    logicalFilter2 = logicalFilter;
                    n2 = n;
                    break;
                }
            }
            n = n2;
            logicalFilter = logicalFilter2;
            s = s2;
            sortOrder = sortOrder2;
        }
        if (parcel.dataPosition() != b) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + b, parcel);
        }
        return new Query(n, logicalFilter, s, sortOrder);
    }
    
    public Query[] a(final int n) {
        return new Query[n];
    }
}
