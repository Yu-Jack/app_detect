// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gz;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StreetViewPanoramaOrientation implements SafeParcelable
{
    public static final n CREATOR;
    public final float a;
    public final float b;
    private final int c;
    
    static {
        CREATOR = new n();
    }
    
    public StreetViewPanoramaOrientation(final float n, final float n2) {
        this(1, n, n2);
    }
    
    StreetViewPanoramaOrientation(final int c, final float n, float n2) {
        gz.b(-90.0f <= n && n <= 90.0f, "Tilt needs to be between -90 and 90 inclusive");
        this.c = c;
        this.a = 0.0f + n;
        if (n2 <= 0.0) {
            n2 = 360.0f + n2 % 360.0f;
        }
        this.b = n2 % 360.0f;
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
            if (!(o instanceof StreetViewPanoramaOrientation)) {
                return false;
            }
            final StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation)o;
            if (Float.floatToIntBits(this.a) != Float.floatToIntBits(streetViewPanoramaOrientation.a) || Float.floatToIntBits(this.b) != Float.floatToIntBits(streetViewPanoramaOrientation.b)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return gw.a(this.a, this.b);
    }
    
    @Override
    public String toString() {
        return gw.a(this).a("tilt", this.a).a("bearing", this.b).toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        n.a(this, parcel, n);
    }
}
