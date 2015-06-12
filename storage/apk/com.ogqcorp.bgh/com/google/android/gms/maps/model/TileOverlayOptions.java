// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.maps.model.a.b;
import android.os.IBinder;
import com.google.android.gms.maps.model.a.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class TileOverlayOptions implements SafeParcelable
{
    public static final p CREATOR;
    private final int a;
    private a b;
    private q c;
    private boolean d;
    private float e;
    private boolean f;
    
    static {
        CREATOR = new p();
    }
    
    public TileOverlayOptions() {
        this.d = true;
        this.f = true;
        this.a = 1;
    }
    
    TileOverlayOptions(final int a, final IBinder binder, final boolean d, final float e, final boolean f) {
        this.d = true;
        this.f = true;
        this.a = a;
        this.b = com.google.android.gms.maps.model.a.b.a(binder);
        q c;
        if (this.b == null) {
            c = null;
        }
        else {
            c = new q() {
                private final a c = TileOverlayOptions.this.b;
            };
        }
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    int a() {
        return this.a;
    }
    
    IBinder b() {
        return this.b.asBinder();
    }
    
    public float c() {
        return this.e;
    }
    
    public boolean d() {
        return this.d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public boolean e() {
        return this.f;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (com.google.android.gms.maps.a.b.a()) {
            ab.a(this, parcel, n);
            return;
        }
        p.a(this, parcel, n);
    }
}
