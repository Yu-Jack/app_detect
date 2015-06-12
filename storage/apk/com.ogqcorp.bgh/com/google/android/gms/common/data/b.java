// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.internal.safeparcel.b;
import android.database.CursorWindow;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class b implements Parcelable$Creator<DataHolder>
{
    static void a(final DataHolder dataHolder, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, dataHolder.c(), false);
        c.a(parcel, 1000, dataHolder.b());
        c.a(parcel, 2, dataHolder.d(), n, false);
        c.a(parcel, 3, dataHolder.e());
        c.a(parcel, 4, dataHolder.f(), false);
        c.a(parcel, a);
    }
    
    public DataHolder a(final Parcel parcel) {
        int g = 0;
        Bundle p = null;
        final int b = a.b(parcel);
        CursorWindow[] array = null;
        String[] z = null;
        int g2 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    z = com.google.android.gms.common.internal.safeparcel.a.z(parcel, a);
                    continue;
                }
                case 1000: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    array = com.google.android.gms.common.internal.safeparcel.a.b(parcel, a, (android.os.Parcelable$Creator<CursorWindow>)CursorWindow.CREATOR);
                    continue;
                }
                case 3: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 4: {
                    p = com.google.android.gms.common.internal.safeparcel.a.p(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + b, parcel);
        }
        final DataHolder dataHolder = new DataHolder(g2, z, array, g, p);
        dataHolder.a();
        return dataHolder;
    }
    
    public DataHolder[] a(final int n) {
        return new DataHolder[n];
    }
}
