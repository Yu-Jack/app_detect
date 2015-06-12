// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class p implements Parcelable$Creator<CloseContentsAndUpdateMetadataRequest>
{
    static void a(final CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, closeContentsAndUpdateMetadataRequest.a);
        c.a(parcel, 2, (Parcelable)closeContentsAndUpdateMetadataRequest.b, n, false);
        c.a(parcel, 3, (Parcelable)closeContentsAndUpdateMetadataRequest.c, n, false);
        c.a(parcel, 4, (Parcelable)closeContentsAndUpdateMetadataRequest.d, n, false);
        c.a(parcel, a);
    }
    
    public CloseContentsAndUpdateMetadataRequest a(final Parcel parcel) {
        Contents contents = null;
        final int b = a.b(parcel);
        int n = 0;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            Contents contents2 = null;
            MetadataBundle metadataBundle2 = null;
            DriveId driveId2 = null;
            int n2 = 0;
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    contents2 = contents;
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    n2 = n;
                    break;
                }
                case 1: {
                    final int g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    final Contents contents3 = contents;
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    n2 = g;
                    contents2 = contents3;
                    break;
                }
                case 2: {
                    final DriveId driveId3 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, DriveId.CREATOR);
                    n2 = n;
                    final MetadataBundle metadataBundle3 = metadataBundle;
                    driveId2 = driveId3;
                    contents2 = contents;
                    metadataBundle2 = metadataBundle3;
                    break;
                }
                case 3: {
                    final MetadataBundle metadataBundle4 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, MetadataBundle.CREATOR);
                    driveId2 = driveId;
                    n2 = n;
                    final Contents contents4 = contents;
                    metadataBundle2 = metadataBundle4;
                    contents2 = contents4;
                    break;
                }
                case 4: {
                    contents2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, Contents.CREATOR);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    n2 = n;
                    break;
                }
            }
            n = n2;
            driveId = driveId2;
            metadataBundle = metadataBundle2;
            contents = contents2;
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new CloseContentsAndUpdateMetadataRequest(n, driveId, metadataBundle, contents);
    }
    
    public CloseContentsAndUpdateMetadataRequest[] a(final int n) {
        return new CloseContentsAndUpdateMetadataRequest[n];
    }
}
