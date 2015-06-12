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

public class d implements Parcelable$Creator<FilterHolder>
{
    static void a(final FilterHolder filterHolder, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, (Parcelable)filterHolder.b, n, false);
        c.a(parcel, 1000, filterHolder.a);
        c.a(parcel, 2, (Parcelable)filterHolder.c, n, false);
        c.a(parcel, 3, (Parcelable)filterHolder.d, n, false);
        c.a(parcel, 4, (Parcelable)filterHolder.e, n, false);
        c.a(parcel, 5, (Parcelable)filterHolder.f, n, false);
        c.a(parcel, 6, (Parcelable)filterHolder.g, n, false);
        c.a(parcel, a);
    }
    
    public FilterHolder a(final Parcel parcel) {
        MatchAllFilter matchAllFilter = null;
        final int b = a.b(parcel);
        int g = 0;
        InFilter<?> inFilter = null;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter<?> comparisonFilter = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    comparisonFilter = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<ComparisonFilter<?>>)ComparisonFilter.CREATOR);
                    continue;
                }
                case 1000: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    fieldOnlyFilter = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, FieldOnlyFilter.CREATOR);
                    continue;
                }
                case 3: {
                    logicalFilter = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, LogicalFilter.CREATOR);
                    continue;
                }
                case 4: {
                    notFilter = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, NotFilter.CREATOR);
                    continue;
                }
                case 5: {
                    inFilter = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<InFilter<?>>)InFilter.CREATOR);
                    continue;
                }
                case 6: {
                    matchAllFilter = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<MatchAllFilter>)MatchAllFilter.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new FilterHolder(g, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter, matchAllFilter);
    }
    
    public FilterHolder[] a(final int n) {
        return new FilterHolder[n];
    }
}
