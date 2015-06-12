// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Bundle;
import android.content.Intent;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.d$a;
import android.os.IBinder;
import android.content.Context;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class cq implements SafeParcelable
{
    public static final cp CREATOR;
    public final dg kX;
    public final cz kZ;
    public final db oT;
    public final Context oU;
    public final int versionCode;
    
    static {
        CREATOR = new cp();
    }
    
    cq(final int versionCode, final IBinder binder, final IBinder binder2, final IBinder binder3, final IBinder binder4) {
        this.versionCode = versionCode;
        this.kX = (dg)e.e(d$a.ag(binder));
        this.kZ = (cz)e.e(d$a.ag(binder2));
        this.oT = (db)e.e(d$a.ag(binder3));
        this.oU = (Context)e.e(d$a.ag(binder4));
    }
    
    public cq(final db ot, final dg kx, final cz kz, final Context ou) {
        this.versionCode = 1;
        this.oT = ot;
        this.kX = kx;
        this.kZ = kz;
        this.oU = ou;
    }
    
    public static void a(final Intent intent, final cq cq) {
        final Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", (Parcelable)cq);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }
    
    public static cq b(final Intent intent) {
        try {
            final Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(cq.class.getClassLoader());
            return (cq)bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    IBinder bd() {
        return e.h(this.kX).asBinder();
    }
    
    IBinder be() {
        return e.h(this.kZ).asBinder();
    }
    
    IBinder bf() {
        return e.h(this.oT).asBinder();
    }
    
    IBinder bg() {
        return e.h(this.oU).asBinder();
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        cp.a(this, parcel, n);
    }
}
