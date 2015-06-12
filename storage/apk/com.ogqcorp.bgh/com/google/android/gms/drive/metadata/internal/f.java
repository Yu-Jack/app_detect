// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class f implements Parcelable$Creator<MetadataBundle>
{
    static void a(final MetadataBundle metadataBundle, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, metadataBundle.a);
        c.a(parcel, 2, metadataBundle.b, false);
        c.a(parcel, a);
    }
    
    public MetadataBundle a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        Bundle p = null;
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
                    p = com.google.android.gms.common.internal.safeparcel.a.p(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new MetadataBundle(g, p);
    }
    
    public MetadataBundle[] a(final int n) {
        return new MetadataBundle[n];
    }
}
