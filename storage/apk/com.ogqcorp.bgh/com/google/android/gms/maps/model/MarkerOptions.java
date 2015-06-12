// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.a.b;
import android.os.IBinder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class MarkerOptions implements SafeParcelable
{
    public static final g CREATOR;
    private final int a;
    private LatLng b;
    private String c;
    private String d;
    private a e;
    private float f;
    private float g;
    private boolean h;
    private boolean i;
    private boolean j;
    private float k;
    private float l;
    private float m;
    private float n;
    
    static {
        CREATOR = new g();
    }
    
    public MarkerOptions() {
        this.f = 0.5f;
        this.g = 1.0f;
        this.i = true;
        this.j = false;
        this.k = 0.0f;
        this.l = 0.5f;
        this.m = 0.0f;
        this.n = 1.0f;
        this.a = 1;
    }
    
    MarkerOptions(final int a, final LatLng b, final String c, final String d, final IBinder binder, final float f, final float g, final boolean h, final boolean i, final boolean j, final float k, final float l, final float m, final float n) {
        this.f = 0.5f;
        this.g = 1.0f;
        this.i = true;
        this.j = false;
        this.k = 0.0f;
        this.l = 0.5f;
        this.m = 0.0f;
        this.n = 1.0f;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        a e;
        if (binder == null) {
            e = null;
        }
        else {
            e = new a(com.google.android.gms.a.b.a(binder));
        }
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = n;
    }
    
    int a() {
        return this.a;
    }
    
    IBinder b() {
        if (this.e == null) {
            return null;
        }
        return this.e.a().asBinder();
    }
    
    public LatLng c() {
        return this.b;
    }
    
    public String d() {
        return this.c;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public String e() {
        return this.d;
    }
    
    public float f() {
        return this.f;
    }
    
    public float g() {
        return this.g;
    }
    
    public boolean h() {
        return this.h;
    }
    
    public boolean i() {
        return this.i;
    }
    
    public boolean j() {
        return this.j;
    }
    
    public float k() {
        return this.k;
    }
    
    public float l() {
        return this.l;
    }
    
    public float m() {
        return this.m;
    }
    
    public float n() {
        return this.n;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (com.google.android.gms.maps.a.b.a()) {
            x.a(this, parcel, n);
            return;
        }
        com.google.android.gms.maps.model.g.a(this, parcel, n);
    }
}
