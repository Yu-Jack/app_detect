// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.query.internal;

import java.util.ArrayList;
import java.util.List;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class g implements Parcelable$Creator<LogicalFilter>
{
    static void a(final LogicalFilter logicalFilter, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1000, logicalFilter.c);
        c.a(parcel, 1, (Parcelable)logicalFilter.a, n, false);
        c.b(parcel, 2, logicalFilter.b, false);
        c.a(parcel, a);
    }
    
    public LogicalFilter a(final Parcel parcel) {
        ArrayList<FilterHolder> list = null;
        final int b = a.b(parcel);
        int n = 0;
        Operator operator = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            ArrayList<FilterHolder> c = null;
            Operator operator2 = null;
            int n2 = 0;
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    c = list;
                    operator2 = operator;
                    n2 = n;
                    break;
                }
                case 1000: {
                    final int g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    final ArrayList<FilterHolder> list2 = list;
                    operator2 = operator;
                    n2 = g;
                    c = list2;
                    break;
                }
                case 1: {
                    final Operator operator3 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, Operator.CREATOR);
                    n2 = n;
                    c = list;
                    operator2 = operator3;
                    break;
                }
                case 2: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, FilterHolder.CREATOR);
                    operator2 = operator;
                    n2 = n;
                    break;
                }
            }
            n = n2;
            operator = operator2;
            list = c;
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new LogicalFilter(n, operator, list);
    }
    
    public LogicalFilter[] a(final int n) {
        return new LogicalFilter[n];
    }
}
