// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class e implements Parcelable$Creator<OnListEntriesResponse>
{
    static void a(final OnListEntriesResponse onListEntriesResponse, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, onListEntriesResponse.a);
        c.a(parcel, 2, (Parcelable)onListEntriesResponse.b, n, false);
        c.a(parcel, 3, onListEntriesResponse.c);
        c.a(parcel, a);
    }
    
    public OnListEntriesResponse a(final Parcel parcel) {
        boolean b = false;
        final int b2 = a.b(parcel);
        DataHolder dataHolder = null;
        int n = 0;
        while (parcel.dataPosition() < b2) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            boolean c = false;
            DataHolder dataHolder2 = null;
            int n2 = 0;
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    c = b;
                    dataHolder2 = dataHolder;
                    n2 = n;
                    break;
                }
                case 1: {
                    final int g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    final boolean b3 = b;
                    dataHolder2 = dataHolder;
                    n2 = g;
                    c = b3;
                    break;
                }
                case 2: {
                    final DataHolder dataHolder3 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<DataHolder>)DataHolder.CREATOR);
                    n2 = n;
                    c = b;
                    dataHolder2 = dataHolder3;
                    break;
                }
                case 3: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a);
                    dataHolder2 = dataHolder;
                    n2 = n;
                    break;
                }
            }
            n = n2;
            dataHolder = dataHolder2;
            b = c;
        }
        if (parcel.dataPosition() != b2) {
            throw new b("Overread allowed size end=" + b2, parcel);
        }
        return new OnListEntriesResponse(n, dataHolder, b);
    }
    
    public OnListEntriesResponse[] a(final int n) {
        return new OnListEntriesResponse[n];
    }
}
