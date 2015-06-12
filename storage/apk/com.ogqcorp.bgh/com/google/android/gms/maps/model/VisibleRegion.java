// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import com.google.android.gms.maps.a.b;
import android.os.Parcel;
import com.google.android.gms.internal.gw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class VisibleRegion implements SafeParcelable
{
    public static final r CREATOR;
    public final LatLng a;
    public final LatLng b;
    public final LatLng c;
    public final LatLng d;
    public final LatLngBounds e;
    private final int f;
    
    static {
        CREATOR = new r();
    }
    
    VisibleRegion(final int f, final LatLng a, final LatLng b, final LatLng c, final LatLng d, final LatLngBounds e) {
        this.f = f;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    int a() {
        return this.f;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof VisibleRegion)) {
                return false;
            }
            final VisibleRegion visibleRegion = (VisibleRegion)o;
            if (!this.a.equals(visibleRegion.a) || !this.b.equals(visibleRegion.b) || !this.c.equals(visibleRegion.c) || !this.d.equals(visibleRegion.d) || !this.e.equals(visibleRegion.e)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return gw.a(this.a, this.b, this.c, this.d, this.e);
    }
    
    @Override
    public String toString() {
        return gw.a(this).a("nearLeft", this.a).a("nearRight", this.b).a("farLeft", this.c).a("farRight", this.d).a("latLngBounds", this.e).toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (com.google.android.gms.maps.a.b.a()) {
            ac.a(this, parcel, n);
            return;
        }
        r.a(this, parcel, n);
    }
}
