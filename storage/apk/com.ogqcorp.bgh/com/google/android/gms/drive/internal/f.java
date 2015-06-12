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

public class f implements Parcelable$Creator<OnListParentsResponse>
{
    static void a(final OnListParentsResponse onListParentsResponse, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, onListParentsResponse.a);
        c.a(parcel, 2, (Parcelable)onListParentsResponse.b, n, false);
        c.a(parcel, a);
    }
    
    public OnListParentsResponse a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        DataHolder dataHolder = null;
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
                    dataHolder = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<DataHolder>)DataHolder.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new OnListParentsResponse(g, dataHolder);
    }
    
    public OnListParentsResponse[] a(final int n) {
        return new OnListParentsResponse[n];
    }
}
