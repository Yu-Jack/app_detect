// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import com.google.android.gms.maps.a.b;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LatLng implements SafeParcelable
{
    public static final f CREATOR;
    public final double a;
    public final double b;
    private final int c;
    
    static {
        CREATOR = new f();
    }
    
    LatLng(final int c, final double b, final double b2) {
        this.c = c;
        if (-180.0 <= b2 && b2 < 180.0) {
            this.b = b2;
        }
        else {
            this.b = (360.0 + (b2 - 180.0) % 360.0) % 360.0 - 180.0;
        }
        this.a = Math.max(-90.0, Math.min(90.0, b));
    }
    
    int a() {
        return this.c;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof LatLng)) {
                return false;
            }
            final LatLng latLng = (LatLng)o;
            if (Double.doubleToLongBits(this.a) != Double.doubleToLongBits(latLng.a) || Double.doubleToLongBits(this.b) != Double.doubleToLongBits(latLng.b)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        final long doubleToLongBits = Double.doubleToLongBits(this.a);
        final int n = 31 + (int)(doubleToLongBits ^ doubleToLongBits >>> 32);
        final long doubleToLongBits2 = Double.doubleToLongBits(this.b);
        return n * 31 + (int)(doubleToLongBits2 ^ doubleToLongBits2 >>> 32);
    }
    
    @Override
    public String toString() {
        return "lat/lng: (" + this.a + "," + this.b + ")";
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (com.google.android.gms.maps.a.b.a()) {
            w.a(this, parcel, n);
            return;
        }
        f.a(this, parcel, n);
    }
}
