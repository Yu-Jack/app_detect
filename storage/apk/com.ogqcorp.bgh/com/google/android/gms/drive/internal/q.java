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

public class q implements Parcelable$Creator<CloseContentsRequest>
{
    static void a(final CloseContentsRequest closeContentsRequest, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, closeContentsRequest.a);
        c.a(parcel, 2, (Parcelable)closeContentsRequest.b, n, false);
        c.a(parcel, 3, closeContentsRequest.c, false);
        c.a(parcel, a);
    }
    
    public CloseContentsRequest a(final Parcel parcel) {
        Boolean b = null;
        final int b2 = a.b(parcel);
        int n = 0;
        Contents contents = null;
        while (parcel.dataPosition() < b2) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            Boolean d = null;
            Contents contents2 = null;
            int n2 = 0;
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    d = b;
                    contents2 = contents;
                    n2 = n;
                    break;
                }
                case 1: {
                    final int g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    final Boolean b3 = b;
                    contents2 = contents;
                    n2 = g;
                    d = b3;
                    break;
                }
                case 2: {
                    final Contents contents3 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, Contents.CREATOR);
                    n2 = n;
                    d = b;
                    contents2 = contents3;
                    break;
                }
                case 3: {
                    d = com.google.android.gms.common.internal.safeparcel.a.d(parcel, a);
                    contents2 = contents;
                    n2 = n;
                    break;
                }
            }
            n = n2;
            contents = contents2;
            b = d;
        }
        if (parcel.dataPosition() != b2) {
            throw new b("Overread allowed size end=" + b2, parcel);
        }
        return new CloseContentsRequest(n, contents, b);
    }
    
    public CloseContentsRequest[] a(final int n) {
        return new CloseContentsRequest[n];
    }
}
