// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.location;

import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class c implements Parcelable$Creator<DetectedActivity>
{
    static void a(final DetectedActivity detectedActivity, final Parcel parcel, final int n) {
        final int a = com.google.android.gms.common.internal.safeparcel.c.a(parcel);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1, detectedActivity.a);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 1000, detectedActivity.b());
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, detectedActivity.b);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, a);
    }
    
    public DetectedActivity a(final Parcel parcel) {
        int g = 0;
        final int b = a.b(parcel);
        int g2 = 0;
        int g3 = 0;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    g2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 1000: {
                    g3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new DetectedActivity(g3, g2, g);
    }
    
    public DetectedActivity[] a(final int n) {
        return new DetectedActivity[n];
    }
}
