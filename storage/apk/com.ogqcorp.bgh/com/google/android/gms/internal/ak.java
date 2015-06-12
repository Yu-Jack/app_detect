// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.g;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.d;
import android.content.Context;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ak implements SafeParcelable
{
    public static final k CREATOR;
    public final int a;
    public final String b;
    public final int c;
    public final int d;
    public final boolean e;
    public final int f;
    public final int g;
    public final ak[] h;
    
    static {
        CREATOR = new k();
    }
    
    public ak() {
        this(2, "interstitial_mb", 0, 0, true, 0, 0, null);
    }
    
    ak(final int a, final String b, final int c, final int d, final boolean e, final int f, final int g, final ak[] h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    public ak(final Context context, final d d) {
        this(context, new d[] { d });
    }
    
    public ak(final Context context, final d[] array) {
        int i = 0;
        final d d = array[0];
        this.a = 2;
        this.e = false;
        this.f = d.b();
        this.c = d.a();
        boolean b;
        if (this.f == -1) {
            b = true;
        }
        else {
            b = false;
        }
        boolean b2;
        if (this.c == -2) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int j;
        if (b) {
            this.g = a(displayMetrics);
            j = (int)(this.g / displayMetrics.density);
        }
        else {
            final int f = this.f;
            this.g = em.a(displayMetrics, this.f);
            j = f;
        }
        int k;
        if (b2) {
            k = c(displayMetrics);
        }
        else {
            k = this.c;
        }
        this.d = em.a(displayMetrics, k);
        if (b || b2) {
            this.b = j + "x" + k + "_as";
        }
        else {
            this.b = d.toString();
        }
        if (array.length > 1) {
            this.h = new ak[array.length];
            while (i < array.length) {
                this.h[i] = new ak(context, array[i]);
                ++i;
            }
        }
        else {
            this.h = null;
        }
    }
    
    public ak(final ak ak, final ak[] array) {
        this(2, ak.b, ak.c, ak.d, ak.e, ak.f, ak.g, array);
    }
    
    public static int a(final DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }
    
    public static int b(final DisplayMetrics displayMetrics) {
        return (int)(c(displayMetrics) * displayMetrics.density);
    }
    
    private static int c(final DisplayMetrics displayMetrics) {
        final int n = (int)(displayMetrics.heightPixels / displayMetrics.density);
        if (n <= 400) {
            return 32;
        }
        if (n <= 720) {
            return 50;
        }
        return 90;
    }
    
    public d a() {
        return com.google.android.gms.ads.g.a(this.f, this.c, this.b);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        k.a(this, parcel, n);
    }
}
