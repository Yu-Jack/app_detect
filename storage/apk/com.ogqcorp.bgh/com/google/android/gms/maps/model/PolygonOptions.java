// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import com.google.android.gms.maps.a.b;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PolygonOptions implements SafeParcelable
{
    public static final h CREATOR;
    private final int a;
    private final List<LatLng> b;
    private final List<List<LatLng>> c;
    private float d;
    private int e;
    private int f;
    private float g;
    private boolean h;
    private boolean i;
    
    static {
        CREATOR = new h();
    }
    
    public PolygonOptions() {
        this.d = 10.0f;
        this.e = -16777216;
        this.f = 0;
        this.g = 0.0f;
        this.h = true;
        this.i = false;
        this.a = 1;
        this.b = new ArrayList<LatLng>();
        this.c = new ArrayList<List<LatLng>>();
    }
    
    PolygonOptions(final int a, final List<LatLng> b, final List c, final float d, final int e, final int f, final float g, final boolean h, final boolean i) {
        this.d = 10.0f;
        this.e = -16777216;
        this.f = 0;
        this.g = 0.0f;
        this.h = true;
        this.i = false;
        this.a = a;
        this.b = b;
        this.c = (List<List<LatLng>>)c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }
    
    int a() {
        return this.a;
    }
    
    List b() {
        return this.c;
    }
    
    public List<LatLng> c() {
        return this.b;
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
    
    public boolean i() {
        return this.i;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (com.google.android.gms.maps.a.b.a()) {
            y.a(this, parcel, n);
            return;
        }
        com.google.android.gms.maps.model.h.a(this, parcel, n);
    }
}
