// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.common.api;

import android.os.Parcel;
import com.google.android.gms.internal.gw;
import android.app.PendingIntent;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Status implements SafeParcelable
{
    public static final e CREATOR;
    public static final Status a;
    public static final Status b;
    public static final Status c;
    public static final Status d;
    public static final Status e;
    private final int f;
    private final int g;
    private final String h;
    private final PendingIntent i;
    
    static {
        a = new Status(0);
        b = new Status(14);
        c = new Status(8);
        d = new Status(15);
        e = new Status(16);
        CREATOR = new e();
    }
    
    public Status(final int n) {
        this(1, n, null, null);
    }
    
    Status(final int f, final int g, final String h, final PendingIntent i) {
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }
    
    private String e() {
        if (this.h != null) {
            return this.h;
        }
        return com.google.android.gms.common.api.a.a(this.g);
    }
    
    PendingIntent a() {
        return this.i;
    }
    
    String b() {
        return this.h;
    }
    
    int c() {
        return this.f;
    }
    
    public int d() {
        return this.g;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof Status) {
            final Status status = (Status)o;
            if (this.f == status.f && this.g == status.g && gw.a(this.h, status.h) && gw.a(this.i, status.i)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return gw.a(this.f, this.g, this.h, this.i);
    }
    
    @Override
    public String toString() {
        return gw.a(this).a("statusCode", this.e()).a("resolution", this.i).toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.common.api.e.a(this, parcel, n);
    }
}
