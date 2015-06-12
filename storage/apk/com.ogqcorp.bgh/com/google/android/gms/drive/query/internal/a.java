// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.query.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class a implements Parcelable$Creator<ComparisonFilter>
{
    static void a(final ComparisonFilter comparisonFilter, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1000, comparisonFilter.c);
        c.a(parcel, 1, (Parcelable)comparisonFilter.a, n, false);
        c.a(parcel, 2, (Parcelable)comparisonFilter.b, n, false);
        c.a(parcel, a);
    }
    
    public ComparisonFilter a(final Parcel parcel) {
        MetadataBundle metadataBundle = null;
        final int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int n = 0;
        Operator operator = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            MetadataBundle metadataBundle2 = null;
            Operator operator2 = null;
            int n2 = 0;
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    metadataBundle2 = metadataBundle;
                    operator2 = operator;
                    n2 = n;
                    break;
                }
                case 1000: {
                    final int g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    final MetadataBundle metadataBundle3 = metadataBundle;
                    operator2 = operator;
                    n2 = g;
                    metadataBundle2 = metadataBundle3;
                    break;
                }
                case 1: {
                    final Operator operator3 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, Operator.CREATOR);
                    n2 = n;
                    metadataBundle2 = metadataBundle;
                    operator2 = operator3;
                    break;
                }
                case 2: {
                    metadataBundle2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, MetadataBundle.CREATOR);
                    operator2 = operator;
                    n2 = n;
                    break;
                }
            }
            n = n2;
            operator = operator2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ComparisonFilter(n, operator, metadataBundle);
    }
    
    public ComparisonFilter[] a(final int n) {
        return new ComparisonFilter[n];
    }
}
