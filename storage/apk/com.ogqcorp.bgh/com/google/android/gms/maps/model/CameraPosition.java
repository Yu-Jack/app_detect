// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gz;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CameraPosition implements SafeParcelable
{
    public static final b CREATOR;
    public final LatLng a;
    public final float b;
    public final float c;
    public final float d;
    private final int e;
    
    static {
        CREATOR = new b();
    }
    
    CameraPosition(final int e, final LatLng a, final float b, final float n, float n2) {
        gz.a(a, "null camera target");
        gz.b(0.0f <= n && n <= 90.0f, "Tilt needs to be between 0 and 90 inclusive");
        this.e = e;
        this.a = a;
        this.b = b;
        this.c = n + 0.0f;
        if (n2 <= 0.0) {
            n2 = 360.0f + n2 % 360.0f;
        }
        this.d = n2 % 360.0f;
    }
    
    int a() {
        return this.e;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof CameraPosition)) {
                return false;
            }
            final CameraPosition cameraPosition = (CameraPosition)o;
            if (!this.a.equals(cameraPosition.a) || Float.floatToIntBits(this.b) != Float.floatToIntBits(cameraPosition.b) || Float.floatToIntBits(this.c) != Float.floatToIntBits(cameraPosition.c) || Float.floatToIntBits(this.d) != Float.floatToIntBits(cameraPosition.d)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return gw.a(this.a, this.b, this.c, this.d);
    }
    
    @Override
    public String toString() {
        return gw.a(this).a("target", this.a).a("zoom", this.b).a("tilt", this.c).a("bearing", this.d).toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (com.google.android.gms.maps.a.b.a()) {
            s.a(this, parcel, n);
            return;
        }
        com.google.android.gms.maps.model.b.a(this, parcel, n);
    }
}
