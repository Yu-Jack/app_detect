// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.internal.safeparcel.b;
import android.app.PendingIntent;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class a implements Parcelable$Creator<AddEventListenerRequest>
{
    static void a(final AddEventListenerRequest addEventListenerRequest, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, addEventListenerRequest.a);
        c.a(parcel, 2, (Parcelable)addEventListenerRequest.b, n, false);
        c.a(parcel, 3, addEventListenerRequest.c);
        c.a(parcel, 4, (Parcelable)addEventListenerRequest.d, n, false);
        c.a(parcel, a);
    }
    
    public AddEventListenerRequest a(final Parcel parcel) {
        PendingIntent pendingIntent = null;
        int n = 0;
        final int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        DriveId driveId = null;
        int n2 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            PendingIntent pendingIntent2 = null;
            int n3 = 0;
            DriveId driveId2 = null;
            int n4 = 0;
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    pendingIntent2 = pendingIntent;
                    n3 = n;
                    driveId2 = driveId;
                    n4 = n2;
                    break;
                }
                case 1: {
                    final int g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    final PendingIntent pendingIntent3 = pendingIntent;
                    n3 = n;
                    driveId2 = driveId;
                    n4 = g;
                    pendingIntent2 = pendingIntent3;
                    break;
                }
                case 2: {
                    final DriveId driveId3 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, DriveId.CREATOR);
                    n4 = n2;
                    final int n5 = n;
                    driveId2 = driveId3;
                    pendingIntent2 = pendingIntent;
                    n3 = n5;
                    break;
                }
                case 3: {
                    final int g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    driveId2 = driveId;
                    n4 = n2;
                    final PendingIntent pendingIntent4 = pendingIntent;
                    n3 = g2;
                    pendingIntent2 = pendingIntent4;
                    break;
                }
                case 4: {
                    pendingIntent2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<PendingIntent>)PendingIntent.CREATOR);
                    n3 = n;
                    driveId2 = driveId;
                    n4 = n2;
                    break;
                }
            }
            n2 = n4;
            driveId = driveId2;
            n = n3;
            pendingIntent = pendingIntent2;
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new AddEventListenerRequest(n2, driveId, n, pendingIntent);
    }
    
    public AddEventListenerRequest[] a(final int n) {
        return new AddEventListenerRequest[n];
    }
}
