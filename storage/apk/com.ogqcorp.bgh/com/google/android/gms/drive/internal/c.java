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

public class c implements Parcelable$Creator<OnDriveIdResponse>
{
    static void a(final OnDriveIdResponse onDriveIdResponse, final Parcel parcel, final int n) {
        final int a = com.google.android.gms.common.internal.safeparcel.c.a(parcel);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1, onDriveIdResponse.a);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, (Parcelable)onDriveIdResponse.b, n, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, a);
    }
    
    public OnDriveIdResponse a(final Parcel parcel) {
        final int b = a.b(parcel);
        int g = 0;
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
                    driveId = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, DriveId.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new OnDriveIdResponse(g, driveId);
    }
    
    public OnDriveIdResponse[] a(final int n) {
        return new OnDriveIdResponse[n];
    }
}
