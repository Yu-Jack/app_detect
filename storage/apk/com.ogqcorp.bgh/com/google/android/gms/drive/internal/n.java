// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class n implements Parcelable$Creator<UpdateMetadataRequest>
{
    static void a(final UpdateMetadataRequest updateMetadataRequest, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, updateMetadataRequest.a);
        c.a(parcel, 2, (Parcelable)updateMetadataRequest.b, n, false);
        c.a(parcel, 3, (Parcelable)updateMetadataRequest.c, n, false);
        c.a(parcel, a);
    }
    
    public UpdateMetadataRequest a(final Parcel parcel) {
        MetadataBundle metadataBundle = null;
        final int b = a.b(parcel);
        int n = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            MetadataBundle metadataBundle2 = null;
            DriveId driveId2 = null;
            int n2 = 0;
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    n2 = n;
                    break;
                }
                case 1: {
                    final int g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    final MetadataBundle metadataBundle3 = metadataBundle;
                    driveId2 = driveId;
                    n2 = g;
                    metadataBundle2 = metadataBundle3;
                    break;
                }
                case 2: {
                    final DriveId driveId3 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, DriveId.CREATOR);
                    n2 = n;
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId3;
                    break;
                }
                case 3: {
                    metadataBundle2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, MetadataBundle.CREATOR);
                    driveId2 = driveId;
                    n2 = n;
                    break;
                }
            }
            n = n2;
            driveId = driveId2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new UpdateMetadataRequest(n, driveId, metadataBundle);
    }
    
    public UpdateMetadataRequest[] a(final int n) {
        return new UpdateMetadataRequest[n];
    }
}
