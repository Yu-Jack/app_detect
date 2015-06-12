// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.location;

import android.os.Parcel;
import java.util.List;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ActivityRecognitionResult implements SafeParcelable
{
    public static final a CREATOR;
    List<DetectedActivity> a;
    long b;
    long c;
    private final int d;
    
    static {
        CREATOR = new a();
    }
    
    public ActivityRecognitionResult(final int n, final List<DetectedActivity> a, final long b, final long c) {
        this.d = 1;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int a() {
        return this.d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.a + ", timeMillis=" + this.b + ", elapsedRealtimeMillis=" + this.c + "]";
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.location.a.a(this, parcel, n);
    }
}
