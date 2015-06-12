// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.events;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class b implements Parcelable$Creator<ConflictEvent>
{
    static void a(final ConflictEvent conflictEvent, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, conflictEvent.a);
        c.a(parcel, 2, (Parcelable)conflictEvent.b, n, false);
        c.a(parcel, a);
    }
    
    public ConflictEvent a(final Parcel parcel) {
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
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + b, parcel);
        }
        return new ConflictEvent(g, driveId);
    }
    
    public ConflictEvent[] a(final int n) {
        return new ConflictEvent[n];
    }
}
