// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.content.pm.PackageInfo;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class cx implements SafeParcelable
{
    public static final dk CREATOR;
    public final int a;
    public final Bundle b;
    public final ah c;
    public final ak d;
    public final String e;
    public final ApplicationInfo f;
    public final PackageInfo g;
    public final String h;
    public final String i;
    public final String j;
    public final dx k;
    public final Bundle l;
    
    static {
        CREATOR = new dk();
    }
    
    cx(final int a, final Bundle b, final ah c, final ak d, final String e, final ApplicationInfo f, final PackageInfo g, final String h, final String i, final String j, final dx k, final Bundle l) {
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
    
    public cx(final Bundle bundle, final ah ah, final ak ak, final String s, final ApplicationInfo applicationInfo, final PackageInfo packageInfo, final String s2, final String s3, final String s4, final dx dx, final Bundle bundle2) {
        this(2, bundle, ah, ak, s, applicationInfo, packageInfo, s2, s3, s4, dx, bundle2);
    }
    
    public cx(final dj dj, final String s) {
        this(dj.a, dj.b, dj.c, dj.d, dj.e, dj.f, s, dj.g, dj.h, dj.j, dj.i);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        dk.a(this, parcel, n);
    }
}
