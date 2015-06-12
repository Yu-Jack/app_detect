// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive;

import com.google.android.gms.common.internal.safeparcel.b;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.safeparcel.a;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class a implements Parcelable$Creator<Contents>
{
    static void a(final Contents contents, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.a(parcel, 1, contents.a);
        c.a(parcel, 2, (Parcelable)contents.b, n, false);
        c.a(parcel, 3, contents.c);
        c.a(parcel, 4, contents.d);
        c.a(parcel, 5, (Parcelable)contents.e, n, false);
        c.a(parcel, a);
    }
    
    public Contents a(final Parcel parcel) {
        DriveId driveId = null;
        int g = 0;
        final int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int g2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int g3 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    parcelFileDescriptor = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, (android.os.Parcelable$Creator<ParcelFileDescriptor>)ParcelFileDescriptor.CREATOR);
                    continue;
                }
                case 3: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 4: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 5: {
                    driveId = com.google.android.gms.common.internal.safeparcel.a.a(parcel, a, DriveId.CREATOR);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new Contents(g3, parcelFileDescriptor, g2, g, driveId);
    }
    
    public Contents[] a(final int n) {
        return new Contents[n];
    }
}
