// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DetectedActivity implements SafeParcelable
{
    public static final c CREATOR;
    int a;
    int b;
    private final int c;
    
    static {
        CREATOR = new c();
    }
    
    public DetectedActivity(final int c, final int a, final int b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    private int a(int n) {
        if (n > 8) {
            n = 4;
        }
        return n;
    }
    
    public int a() {
        return this.a(this.a);
    }
    
    public int b() {
        return this.c;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public String toString() {
        return "DetectedActivity [type=" + this.a() + ", confidence=" + this.b + "]";
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.location.c.a(this, parcel, n);
    }
}
