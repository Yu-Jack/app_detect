// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class cb implements SafeParcelable
{
    public static final br CREATOR;
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    
    static {
        CREATOR = new br();
    }
    
    public cb(final int a, final String b, final String c, final String d, final String e, final String f, final String g, final String h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    public cb(final String s, final String s2, final String s3, final String s4, final String s5, final String s6, final String s7) {
        this(1, s, s2, s3, s4, s5, s6, s7);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        br.a(this, parcel, n);
    }
}
