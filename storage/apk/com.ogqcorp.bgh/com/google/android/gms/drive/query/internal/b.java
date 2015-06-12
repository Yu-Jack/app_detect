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

public class b implements Parcelable$Creator<FieldOnlyFilter>
{
    static void a(final FieldOnlyFilter fieldOnlyFilter, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1000, fieldOnlyFilter.b);
        c.a(parcel, 1, (Parcelable)fieldOnlyFilter.a, n, false);
        c.a(parcel, a);
    }
    
    public FieldOnlyFilter a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        MetadataBundle metadataBundle = null;
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
                    metadataBundle = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, MetadataBundle.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + b, parcel);
        }
        return new FieldOnlyFilter(g, metadataBundle);
    }
    
    public FieldOnlyFilter[] a(final int n) {
        return new FieldOnlyFilter[n];
    }
}
