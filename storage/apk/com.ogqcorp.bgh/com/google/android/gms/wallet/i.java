// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class i implements Parcelable$Creator<LineItem>
{
    static void a(final LineItem lineItem, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, lineItem.a());
        c.a(parcel, 2, lineItem.a, false);
        c.a(parcel, 3, lineItem.b, false);
        c.a(parcel, 4, lineItem.c, false);
        c.a(parcel, 5, lineItem.d, false);
        c.a(parcel, 6, lineItem.e);
        c.a(parcel, 7, lineItem.f, false);
        c.a(parcel, a);
    }
    
    public LineItem a(final Parcel parcel) {
        int g = 0;
        String n = null;
        final int b = a.b(parcel);
        String n2 = null;
        String n3 = null;
        String n4 = null;
        String n5 = null;
        int g2 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    n5 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 4: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 5: {
                    n2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 6: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 7: {
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new LineItem(g2, n5, n4, n3, n2, g, n);
    }
    
    public LineItem[] a(final int n) {
        return new LineItem[n];
    }
}
