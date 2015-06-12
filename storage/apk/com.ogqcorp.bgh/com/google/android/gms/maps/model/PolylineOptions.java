// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import com.google.android.gms.maps.a.b;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PolylineOptions implements SafeParcelable
{
    public static final i CREATOR;
    private final int a;
    private final List<LatLng> b;
    private float c;
    private int d;
    private float e;
    private boolean f;
    private boolean g;
    
    static {
        CREATOR = new i();
    }
    
    public PolylineOptions() {
        this.c = 10.0f;
        this.d = -16777216;
        this.e = 0.0f;
        this.f = true;
        this.g = false;
        this.a = 1;
        this.b = new ArrayList<LatLng>();
    }
    
    PolylineOptions(final int a, final List b, final float c, final int d, final float e, final boolean f, final boolean g) {
        this.c = 10.0f;
        this.d = -16777216;
        this.e = 0.0f;
        this.f = true;
        this.g = false;
        this.a = a;
        this.b = (List<LatLng>)b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    int a() {
        return this.a;
    }
    
    public List<LatLng> b() {
        return this.b;
    }
    
    public float c() {
        return this.c;
    }
    
    public int d() {
        return this.d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public float e() {
        return this.e;
    }
    
    public boolean f() {
        return this.f;
    }
    
    public boolean g() {
        return this.g;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (com.google.android.gms.maps.a.b.a()) {
            z.a(this, parcel, n);
            return;
        }
        i.a(this, parcel, n);
    }
}
