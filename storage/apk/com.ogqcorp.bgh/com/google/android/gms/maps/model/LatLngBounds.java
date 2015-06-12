// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import com.google.android.gms.maps.a.b;
import android.os.Parcel;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gz;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LatLngBounds implements SafeParcelable
{
    public static final e CREATOR;
    public final LatLng a;
    public final LatLng b;
    private final int c;
    
    static {
        CREATOR = new e();
    }
    
    LatLngBounds(final int c, final LatLng a, final LatLng b) {
        gz.a(a, "null southwest");
        gz.a(b, "null northeast");
        gz.a(b.a >= a.a, "southern latitude exceeds northern latitude (%s > %s)", a.a, b.a);
        this.c = c;
        this.a = a;
        this.b = b;
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
            if (!(o instanceof LatLngBounds)) {
                return false;
            }
            final LatLngBounds latLngBounds = (LatLngBounds)o;
            if (!this.a.equals(latLngBounds.a) || !this.b.equals(latLngBounds.b)) {
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
        return gw.a(this).a("southwest", this.a).a("northeast", this.b).toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (com.google.android.gms.maps.a.b.a()) {
            v.a(this, parcel, n);
            return;
        }
        e.a(this, parcel, n);
    }
}
