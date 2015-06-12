// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.internal.gw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LocationRequest implements SafeParcelable
{
    public static final d CREATOR;
    int a;
    long b;
    long c;
    boolean d;
    long e;
    int f;
    float g;
    private final int h;
    
    static {
        CREATOR = new d();
    }
    
    public LocationRequest() {
        this.h = 1;
        this.a = 102;
        this.b = 3600000L;
        this.c = 600000L;
        this.d = false;
        this.e = Long.MAX_VALUE;
        this.f = Integer.MAX_VALUE;
        this.g = 0.0f;
    }
    
    LocationRequest(final int h, final int a, final long b, final long c, final boolean d, final long e, final int f, final float g) {
        this.h = h;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    public static String a(final int n) {
        switch (n) {
            default: {
                return "???";
            }
            case 100: {
                return "PRIORITY_HIGH_ACCURACY";
            }
            case 102: {
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            }
            case 104: {
                return "PRIORITY_LOW_POWER";
            }
            case 105: {
                return "PRIORITY_NO_POWER";
            }
        }
    }
    
    int a() {
        return this.h;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof LocationRequest)) {
                return false;
            }
            final LocationRequest locationRequest = (LocationRequest)o;
            if (this.a != locationRequest.a || this.b != locationRequest.b || this.c != locationRequest.c || this.d != locationRequest.d || this.e != locationRequest.e || this.f != locationRequest.f || this.g != locationRequest.g) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return gw.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Request[").append(a(this.a));
        if (this.a != 105) {
            sb.append(" requested=");
            sb.append(this.b + "ms");
        }
        sb.append(" fastest=");
        sb.append(this.c + "ms");
        if (this.e != Long.MAX_VALUE) {
            final long lng = this.e - SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(lng + "ms");
        }
        if (this.f != Integer.MAX_VALUE) {
            sb.append(" num=").append(this.f);
        }
        sb.append(']');
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.location.d.a(this, parcel, n);
    }
}
