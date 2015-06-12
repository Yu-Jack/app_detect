// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gz;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StreetViewPanoramaCamera implements SafeParcelable
{
    public static final j CREATOR;
    public final float a;
    public final float b;
    public final float c;
    private final int d;
    private StreetViewPanoramaOrientation e;
    
    static {
        CREATOR = new j();
    }
    
    StreetViewPanoramaCamera(final int d, final float a, final float n, final float n2) {
        gz.b(-90.0f <= n && n <= 90.0f, "Tilt needs to be between -90 and 90 inclusive");
        this.d = d;
        this.a = a;
        this.b = 0.0f + n;
        float n3;
        if (n2 <= 0.0) {
            n3 = 360.0f + n2 % 360.0f;
        }
        else {
            n3 = n2;
        }
        this.c = n3 % 360.0f;
        this.e = new m().a(n).b(n2).a();
    }
    
    int a() {
        return this.d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof StreetViewPanoramaCamera)) {
                return false;
            }
            final StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera)o;
            if (Float.floatToIntBits(this.a) != Float.floatToIntBits(streetViewPanoramaCamera.a) || Float.floatToIntBits(this.b) != Float.floatToIntBits(streetViewPanoramaCamera.b) || Float.floatToIntBits(this.c) != Float.floatToIntBits(streetViewPanoramaCamera.c)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return gw.a(this.a, this.b, this.c);
    }
    
    @Override
    public String toString() {
        return gw.a(this).a("zoom", this.a).a("tilt", this.b).a("bearing", this.c).toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        j.a(this, parcel, n);
    }
}
