// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps;

import com.google.android.gms.maps.a.b;
import android.os.Parcel;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GoogleMapOptions implements SafeParcelable
{
    public static final a CREATOR;
    private final int a;
    private Boolean b;
    private Boolean c;
    private int d;
    private CameraPosition e;
    private Boolean f;
    private Boolean g;
    private Boolean h;
    private Boolean i;
    private Boolean j;
    private Boolean k;
    
    static {
        CREATOR = new a();
    }
    
    public GoogleMapOptions() {
        this.d = -1;
        this.a = 1;
    }
    
    GoogleMapOptions(final int a, final byte b, final byte b2, final int d, final CameraPosition e, final byte b3, final byte b4, final byte b5, final byte b6, final byte b7, final byte b8) {
        this.d = -1;
        this.a = a;
        this.b = com.google.android.gms.maps.a.a.a(b);
        this.c = com.google.android.gms.maps.a.a.a(b2);
        this.d = d;
        this.e = e;
        this.f = com.google.android.gms.maps.a.a.a(b3);
        this.g = com.google.android.gms.maps.a.a.a(b4);
        this.h = com.google.android.gms.maps.a.a.a(b5);
        this.i = com.google.android.gms.maps.a.a.a(b6);
        this.j = com.google.android.gms.maps.a.a.a(b7);
        this.k = com.google.android.gms.maps.a.a.a(b8);
    }
    
    int a() {
        return this.a;
    }
    
    byte b() {
        return com.google.android.gms.maps.a.a.a(this.b);
    }
    
    byte c() {
        return com.google.android.gms.maps.a.a.a(this.c);
    }
    
    byte d() {
        return com.google.android.gms.maps.a.a.a(this.f);
    }
    
    public int describeContents() {
        return 0;
    }
    
    byte e() {
        return com.google.android.gms.maps.a.a.a(this.g);
    }
    
    byte f() {
        return com.google.android.gms.maps.a.a.a(this.h);
    }
    
    byte g() {
        return com.google.android.gms.maps.a.a.a(this.i);
    }
    
    byte h() {
        return com.google.android.gms.maps.a.a.a(this.j);
    }
    
    byte i() {
        return com.google.android.gms.maps.a.a.a(this.k);
    }
    
    public int j() {
        return this.d;
    }
    
    public CameraPosition k() {
        return this.e;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (com.google.android.gms.maps.a.b.a()) {
            com.google.android.gms.maps.c.a(this, parcel, n);
            return;
        }
        com.google.android.gms.maps.a.a(this, parcel, n);
    }
}
