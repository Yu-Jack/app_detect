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

public class j implements Parcelable$Creator<OpenFileIntentSenderRequest>
{
    static void a(final OpenFileIntentSenderRequest openFileIntentSenderRequest, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, openFileIntentSenderRequest.a);
        c.a(parcel, 2, openFileIntentSenderRequest.b, false);
        c.a(parcel, 3, openFileIntentSenderRequest.c, false);
        c.a(parcel, 4, (Parcelable)openFileIntentSenderRequest.d, n, false);
        c.a(parcel, a);
    }
    
    public OpenFileIntentSenderRequest a(final Parcel parcel) {
        DriveId driveId = null;
        final int b = a.b(parcel);
        int g = 0;
        String[] z = null;
        String n = null;
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
                    n = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a);
                    continue;
                }
                case 3: {
                    z = com.google.android.gms.common.internal.safeparcel.a.z(parcel, a);
                    continue;
                }
                case 4: {
                    driveId = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, DriveId.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new OpenFileIntentSenderRequest(g, n, z, driveId);
    }
    
    public OpenFileIntentSenderRequest[] a(final int n) {
        return new OpenFileIntentSenderRequest[n];
    }
}
