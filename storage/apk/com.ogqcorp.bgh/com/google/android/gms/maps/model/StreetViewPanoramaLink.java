// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.internal.gw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StreetViewPanoramaLink implements SafeParcelable
{
    public static final k CREATOR;
    public final String a;
    public final float b;
    private final int c;
    
    static {
        CREATOR = new k();
    }
    
    StreetViewPanoramaLink(final int c, final String a, float n) {
        this.c = c;
        this.a = a;
        if (n <= 0.0) {
            n = 360.0f + n % 360.0f;
        }
        this.b = n % 360.0f;
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
            if (!(o instanceof StreetViewPanoramaLink)) {
                return false;
            }
            final StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink)o;
            if (!this.a.equals(streetViewPanoramaLink.a) || Float.floatToIntBits(this.b) != Float.floatToIntBits(streetViewPanoramaLink.b)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return gw.a(new Object[] { this.a, this.b });
    }
    
    @Override
    public String toString() {
        return gw.a(this).a("panoId", this.a).a("bearing", this.b).toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        k.a(this, parcel, n);
    }
}
