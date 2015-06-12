// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class o implements Parcelable$Creator<AuthorizeAccessRequest>
{
    static void a(final AuthorizeAccessRequest authorizeAccessRequest, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, authorizeAccessRequest.a);
        c.a(parcel, 2, authorizeAccessRequest.b);
        c.a(parcel, 3, (Parcelable)authorizeAccessRequest.c, n, false);
        c.a(parcel, a);
    }
    
    public AuthorizeAccessRequest a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
        long i = 0L;
        DriveId driveId = null;
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
                    i = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 3: {
                    driveId = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, DriveId.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new AuthorizeAccessRequest(g, i, driveId);
    }
    
    public AuthorizeAccessRequest[] a(final int n) {
        return new AuthorizeAccessRequest[n];
    }
}
