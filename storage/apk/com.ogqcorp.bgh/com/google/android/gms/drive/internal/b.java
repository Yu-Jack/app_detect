// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class b implements Parcelable$Creator<OnDownloadProgressResponse>
{
    static void a(final OnDownloadProgressResponse onDownloadProgressResponse, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, onDownloadProgressResponse.a);
        c.a(parcel, 2, onDownloadProgressResponse.b);
        c.a(parcel, 3, onDownloadProgressResponse.c);
        c.a(parcel, a);
    }
    
    public OnDownloadProgressResponse a(final Parcel parcel) {
        long i = 0L;
        final int b = a.b(parcel);
        int g = 0;
        long j = i;
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
                    j = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 3: {
                    i = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + b, parcel);
        }
        return new OnDownloadProgressResponse(g, j, i);
    }
    
    public OnDownloadProgressResponse[] a(final int n) {
        return new OnDownloadProgressResponse[n];
    }
}
