// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.location;

import java.util.List;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class a implements Parcelable$Creator<ActivityRecognitionResult>
{
    static void a(final ActivityRecognitionResult activityRecognitionResult, final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.b(parcel, 1, activityRecognitionResult.a, false);
        c.a(parcel, 1000, activityRecognitionResult.a());
        c.a(parcel, 2, activityRecognitionResult.b);
        c.a(parcel, 3, activityRecognitionResult.c);
        c.a(parcel, a);
    }
    
    public ActivityRecognitionResult a(final Parcel parcel) {
        long i = 0L;
        final int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int g = 0;
        List<DetectedActivity> c = null;
        long j = i;
        while (parcel.dataPosition() < b) {
            final int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(a)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
                    continue;
                }
                case 1: {
                    c = com.google.android.gms.common.internal.safeparcel.a.c(parcel, a, (android.os.Parcelable$Creator<DetectedActivity>)DetectedActivity.CREATOR);
                    continue;
                }
                case 1000: {
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, a);
                    continue;
                }
                case 2: {
                    j = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
                case 3: {
                    i = com.google.android.gms.common.internal.safeparcel.a.i(parcel, a);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        return new ActivityRecognitionResult(g, c, j, i);
    }
    
    public ActivityRecognitionResult[] a(final int n) {
        return new ActivityRecognitionResult[n];
    }
}
