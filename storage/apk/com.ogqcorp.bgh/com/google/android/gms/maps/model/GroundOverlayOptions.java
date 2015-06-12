// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.a.b;
import android.os.IBinder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GroundOverlayOptions implements SafeParcelable
{
    public static final d CREATOR;
    private final int a;
    private a b;
    private LatLng c;
    private float d;
    private float e;
    private LatLngBounds f;
    private float g;
    private float h;
    private boolean i;
    private float j;
    private float k;
    private float l;
    
    static {
        CREATOR = new d();
    }
    
    public GroundOverlayOptions() {
        this.i = true;
        this.j = 0.0f;
        this.k = 0.5f;
        this.l = 0.5f;
        this.a = 1;
    }
    
    GroundOverlayOptions(final int a, final IBinder binder, final LatLng c, final float d, final float e, final LatLngBounds f, final float g, final float h, final boolean i, final float j, final float k, final float l) {
        this.i = true;
        this.j = 0.0f;
        this.k = 0.5f;
        this.l = 0.5f;
        this.a = a;
        this.b = new a(com.google.android.gms.a.b.a(binder));
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;
    }
    
    IBinder a() {
        return this.b.a().asBinder();
    }
    
    int b() {
        return this.a;
    }
    
    public LatLng c() {
        return this.c;
    }
    
    public float d() {
        return this.d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public float e() {
        return this.e;
    }
    
    public LatLngBounds f() {
        return this.f;
    }
    
    public float g() {
        return this.g;
    }
    
    public float h() {
        return this.h;
    }
    
    public float i() {
        return this.j;
    }
    
    public float j() {
        return this.k;
    }
    
    public float k() {
        return this.l;
    }
    
    public boolean l() {
        return this.i;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (com.google.android.gms.maps.a.b.a()) {
            u.a(this, parcel, n);
            return;
        }
        com.google.android.gms.maps.model.d.a(this, parcel, n);
    }
}
