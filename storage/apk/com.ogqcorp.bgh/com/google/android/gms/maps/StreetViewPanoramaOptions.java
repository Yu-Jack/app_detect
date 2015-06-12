// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.maps.a.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class StreetViewPanoramaOptions implements SafeParcelable
{
    public static final b CREATOR;
    private final int a;
    private StreetViewPanoramaCamera b;
    private String c;
    private LatLng d;
    private Integer e;
    private Boolean f;
    private Boolean g;
    private Boolean h;
    private Boolean i;
    private Boolean j;
    
    static {
        CREATOR = new b();
    }
    
    public StreetViewPanoramaOptions() {
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.a = 1;
    }
    
    StreetViewPanoramaOptions(final int a, final StreetViewPanoramaCamera b, final String c, final LatLng d, final Integer e, final byte b2, final byte b3, final byte b4, final byte b5, final byte b6) {
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.a = a;
        this.b = b;
        this.d = d;
        this.e = e;
        this.c = c;
        this.f = com.google.android.gms.maps.a.a.a(b2);
        this.g = com.google.android.gms.maps.a.a.a(b3);
        this.h = com.google.android.gms.maps.a.a.a(b4);
        this.i = com.google.android.gms.maps.a.a.a(b5);
        this.j = com.google.android.gms.maps.a.a.a(b6);
    }
    
    int a() {
        return this.a;
    }
    
    byte b() {
        return com.google.android.gms.maps.a.a.a(this.f);
    }
    
    byte c() {
        return com.google.android.gms.maps.a.a.a(this.g);
    }
    
    byte d() {
        return com.google.android.gms.maps.a.a.a(this.h);
    }
    
    public int describeContents() {
        return 0;
    }
    
    byte e() {
        return com.google.android.gms.maps.a.a.a(this.i);
    }
    
    byte f() {
        return com.google.android.gms.maps.a.a.a(this.j);
    }
    
    public StreetViewPanoramaCamera g() {
        return this.b;
    }
    
    public LatLng h() {
        return this.d;
    }
    
    public Integer i() {
        return this.e;
    }
    
    public String j() {
        return this.c;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.maps.b.a(this, parcel, n);
    }
}
