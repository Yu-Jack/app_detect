// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Locale;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hd implements SafeParcelable
{
    public static final is CREATOR;
    private final int a;
    private final String b;
    private final long c;
    private final short d;
    private final double e;
    private final double f;
    private final float g;
    private final int h;
    private final int i;
    private final int j;
    
    static {
        CREATOR = new is();
    }
    
    public hd(final int a, final String b, final int n, final short d, final double e, final double f, final float g, final long c, final int i, final int j) {
        a(b);
        a(g);
        a(e, f);
        final int a2 = a(n);
        this.a = a;
        this.d = d;
        this.b = b;
        this.e = e;
        this.f = f;
        this.g = g;
        this.c = c;
        this.h = a2;
        this.i = i;
        this.j = j;
    }
    
    private static int a(final int i) {
        final int n = i & 0x7;
        if (n == 0) {
            throw new IllegalArgumentException("No supported transition specified: " + i);
        }
        return n;
    }
    
    private static void a(final double d, final double d2) {
        if (d > 90.0 || d < -90.0) {
            throw new IllegalArgumentException("invalid latitude: " + d);
        }
        if (d2 > 180.0 || d2 < -180.0) {
            throw new IllegalArgumentException("invalid longitude: " + d2);
        }
    }
    
    private static void a(final float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("invalid radius: " + f);
        }
    }
    
    private static void a(final String str) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: " + str);
        }
    }
    
    private static String b(final int n) {
        switch (n) {
            default: {
                return null;
            }
            case 1: {
                return "CIRCLE";
            }
        }
    }
    
    public int a() {
        return this.a;
    }
    
    public short b() {
        return this.d;
    }
    
    public double c() {
        return this.e;
    }
    
    public double d() {
        return this.f;
    }
    
    public int describeContents() {
        final is creator = hd.CREATOR;
        return 0;
    }
    
    public float e() {
        return this.g;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o == null) {
                return false;
            }
            if (!(o instanceof hd)) {
                return false;
            }
            final hd hd = (hd)o;
            if (this.g != hd.g) {
                return false;
            }
            if (this.e != hd.e) {
                return false;
            }
            if (this.f != hd.f) {
                return false;
            }
            if (this.d != hd.d) {
                return false;
            }
        }
        return true;
    }
    
    public String f() {
        return this.b;
    }
    
    public long g() {
        return this.c;
    }
    
    public int h() {
        return this.h;
    }
    
    @Override
    public int hashCode() {
        final long doubleToLongBits = Double.doubleToLongBits(this.e);
        final int n = 31 + (int)(doubleToLongBits ^ doubleToLongBits >>> 32);
        final long doubleToLongBits2 = Double.doubleToLongBits(this.f);
        return 31 * (31 * (31 * (n * 31 + (int)(doubleToLongBits2 ^ doubleToLongBits2 >>> 32)) + Float.floatToIntBits(this.g)) + this.d) + this.h;
    }
    
    public int i() {
        return this.i;
    }
    
    public int j() {
        return this.j;
    }
    
    @Override
    public String toString() {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", b(this.d), this.b, this.h, this.e, this.f, this.g, this.i / 1000, this.j, this.c);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final is creator = hd.CREATOR;
        is.a(this, parcel, n);
    }
}
