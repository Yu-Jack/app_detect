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

public class i implements Parcelable$Creator<OpenContentsRequest>
{
    static void a(final OpenContentsRequest openContentsRequest, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, openContentsRequest.a);
        c.a(parcel, 2, (Parcelable)openContentsRequest.b, n, false);
        c.a(parcel, 3, openContentsRequest.c);
        c.a(parcel, a);
    }
    
    public OpenContentsRequest a(final Parcel parcel) {
        int n = 0;
        final int b = a.b(parcel);
        DriveId driveId = null;
        int n2 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            int g = 0;
            DriveId driveId2 = null;
            int n3 = 0;
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    g = n;
                    driveId2 = driveId;
                    n3 = n2;
                    break;
                }
                case 1: {
                    final int g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    final int n4 = n;
                    driveId2 = driveId;
                    n3 = g2;
                    g = n4;
                    break;
                }
                case 2: {
                    final DriveId driveId3 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, DriveId.CREATOR);
                    n3 = n2;
                    g = n;
                    driveId2 = driveId3;
                    break;
                }
                case 3: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    driveId2 = driveId;
                    n3 = n2;
                    break;
                }
            }
            n2 = n3;
            driveId = driveId2;
            n = g;
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new OpenContentsRequest(n2, driveId, n);
    }
    
    public OpenContentsRequest[] a(final int n) {
        return new OpenContentsRequest[n];
    }
}
