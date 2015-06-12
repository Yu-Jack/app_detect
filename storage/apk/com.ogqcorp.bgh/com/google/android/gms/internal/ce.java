// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Bundle;
import android.content.Intent;
import com.google.android.gms.a.d;
import com.google.android.gms.a.b;
import android.os.IBinder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ce implements SafeParcelable
{
    public static final bw CREATOR;
    public final int a;
    public final cb b;
    public final lh c;
    public final bx d;
    public final ep e;
    public final ag f;
    public final String g;
    public final boolean h;
    public final String i;
    public final cc j;
    public final int k;
    public final int l;
    public final String m;
    public final dx n;
    public final al o;
    public final String p;
    
    static {
        CREATOR = new bw();
    }
    
    ce(final int a, final cb b, final IBinder binder, final IBinder binder2, final IBinder binder3, final IBinder binder4, final String g, final boolean h, final String i, final IBinder binder5, final int k, final int l, final String m, final dx n, final IBinder binder6, final String p16) {
        this.a = a;
        this.b = b;
        this.c = com.google.android.gms.a.d.a(com.google.android.gms.a.b.a(binder));
        this.d = com.google.android.gms.a.d.a(com.google.android.gms.a.b.a(binder2));
        this.e = com.google.android.gms.a.d.a(com.google.android.gms.a.b.a(binder3));
        this.f = com.google.android.gms.a.d.a(com.google.android.gms.a.b.a(binder4));
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = com.google.android.gms.a.d.a(com.google.android.gms.a.b.a(binder5));
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = n;
        this.o = com.google.android.gms.a.d.a(com.google.android.gms.a.b.a(binder6));
        this.p = p16;
    }
    
    public ce(final cb b, final lh c, final bx d, final cc j, final dx n) {
        this.a = 3;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = null;
        this.j = j;
        this.k = -1;
        this.l = 4;
        this.m = null;
        this.n = n;
        this.o = null;
        this.p = null;
    }
    
    public ce(final lh c, final bx d, final ag f, final cc j, final ep e, final boolean h, final int k, final String m, final dx n, final al o) {
        this.a = 3;
        this.b = null;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = null;
        this.h = h;
        this.i = null;
        this.j = j;
        this.k = k;
        this.l = 3;
        this.m = m;
        this.n = n;
        this.o = o;
        this.p = null;
    }
    
    public ce(final lh c, final bx d, final ag f, final cc j, final ep e, final boolean h, final int k, final String i, final String g, final dx n, final al o) {
        this.a = 3;
        this.b = null;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = 3;
        this.m = null;
        this.n = n;
        this.o = o;
        this.p = null;
    }
    
    public ce(final lh c, final bx d, final cc j, final ep e, final int k, final dx n, final String p7) {
        this.a = 3;
        this.b = null;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = null;
        this.j = j;
        this.k = k;
        this.l = 1;
        this.m = null;
        this.n = n;
        this.o = null;
        this.p = p7;
    }
    
    public ce(final lh c, final bx d, final cc j, final ep e, final boolean h, final int k, final dx n) {
        this.a = 3;
        this.b = null;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = null;
        this.g = null;
        this.h = h;
        this.i = null;
        this.j = j;
        this.k = k;
        this.l = 2;
        this.m = null;
        this.n = n;
        this.o = null;
        this.p = null;
    }
    
    public static ce a(final Intent intent) {
        try {
            final Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(ce.class.getClassLoader());
            return (ce)bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    public static void a(final Intent intent, final ce ce) {
        final Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", (Parcelable)ce);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }
    
    IBinder a() {
        return com.google.android.gms.a.d.a(this.c).asBinder();
    }
    
    IBinder b() {
        return com.google.android.gms.a.d.a(this.d).asBinder();
    }
    
    IBinder c() {
        return com.google.android.gms.a.d.a(this.e).asBinder();
    }
    
    IBinder d() {
        return com.google.android.gms.a.d.a(this.f).asBinder();
    }
    
    public int describeContents() {
        return 0;
    }
    
    IBinder e() {
        return com.google.android.gms.a.d.a(this.o).asBinder();
    }
    
    IBinder f() {
        return com.google.android.gms.a.d.a(this.j).asBinder();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        bw.a(this, parcel, n);
    }
}
