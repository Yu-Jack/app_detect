// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import com.google.android.gms.maps.a.b;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CircleOptions implements SafeParcelable
{
    public static final c CREATOR;
    private final int a;
    private LatLng b;
    private double c;
    private float d;
    private int e;
    private int f;
    private float g;
    private boolean h;
    
    static {
        CREATOR = new c();
    }
    
    public CircleOptions() {
        this.b = null;
        this.c = 0.0;
        this.d = 10.0f;
        this.e = -16777216;
        this.f = 0;
        this.g = 0.0f;
        this.h = true;
        this.a = 1;
    }
    
    CircleOptions(final int a, final LatLng b, final double c, final float d, final int e, final int f, final float g, final boolean h) {
        this.b = null;
        this.c = 0.0;
        this.d = 10.0f;
        this.e = -16777216;
        this.f = 0;
        this.g = 0.0f;
        this.h = true;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    int a() {
        return this.a;
    }
    
    public LatLng b() {
        return this.b;
    }
    
    public double c() {
        return this.c;
    }
    
    public float d() {
        return this.d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public int e() {
        return this.e;
    }
    
    public int f() {
        return this.f;
    }
    
    public float g() {
        return this.g;
    }
    
    public boolean h() {
        return this.h;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (com.google.android.gms.maps.a.b.a()) {
            t.a(this, parcel, n);
            return;
        }
        com.google.android.gms.maps.model.c.a(this, parcel, n);
    }
}
