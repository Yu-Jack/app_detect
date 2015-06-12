// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.location.Location;
import java.util.List;
import android.os.Bundle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ah implements SafeParcelable
{
    public static final i CREATOR;
    public final int a;
    public final long b;
    public final Bundle c;
    public final int d;
    public final List<String> e;
    public final boolean f;
    public final int g;
    public final boolean h;
    public final String i;
    public final av j;
    public final Location k;
    public final String l;
    
    static {
        CREATOR = new i();
    }
    
    public ah(final int a, final long b, final Bundle c, final int d, final List<String> e, final boolean f, final int g, final boolean h, final String i, final av j, final Location k, final String l) {
        this.a = a;
        this.b = b;
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
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.internal.i.a(this, parcel, n);
    }
}
