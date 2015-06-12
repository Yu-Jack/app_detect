// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class z implements Parcelable$Creator<OnContentsResponse>
{
    static void a(final OnContentsResponse onContentsResponse, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, onContentsResponse.a);
        c.a(parcel, 2, (Parcelable)onContentsResponse.b, n, false);
        c.a(parcel, a);
    }
    
    public OnContentsResponse a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        Contents contents = null;
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
                    contents = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, Contents.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new OnContentsResponse(g, contents);
    }
    
    public OnContentsResponse[] a(final int n) {
        return new OnContentsResponse[n];
    }
}
