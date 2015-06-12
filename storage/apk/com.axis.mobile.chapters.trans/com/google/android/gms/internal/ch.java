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
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ch implements SafeParcelable
{
    public static final cg CREATOR;
    public final ev kQ;
    public final String oA;
    public final boolean oB;
    public final String oC;
    public final cl oD;
    public final int oE;
    public final bd oF;
    public final String oG;
    public final v oH;
    public final String ob;
    public final int orientation;
    public final ce ov;
    public final t ow;
    public final ci ox;
    public final ex oy;
    public final ba oz;
    public final int versionCode;
    
    static {
        CREATOR = new cg();
    }
    
    ch(final int versionCode, final ce ov, final IBinder binder, final IBinder binder2, final IBinder binder3, final IBinder binder4, final String oa, final boolean ob, final String oc, final IBinder binder5, final int orientation, final int oe, final String ob2, final ev kq, final IBinder binder6, final String og, final v oh) {
        this.versionCode = versionCode;
        this.ov = ov;
        this.ow = (t)e.e(d$a.ag(binder));
        this.ox = (ci)e.e(d$a.ag(binder2));
        this.oy = (ex)e.e(d$a.ag(binder3));
        this.oz = (ba)e.e(d$a.ag(binder4));
        this.oA = oa;
        this.oB = ob;
        this.oC = oc;
        this.oD = (cl)e.e(d$a.ag(binder5));
        this.orientation = orientation;
        this.oE = oe;
        this.ob = ob2;
        this.kQ = kq;
        this.oF = (bd)e.e(d$a.ag(binder6));
        this.oG = og;
        this.oH = oh;
    }
    
    public ch(final ce ov, final t ow, final ci ox, final cl od, final ev kq) {
        this.versionCode = 4;
        this.ov = ov;
        this.ow = ow;
        this.ox = ox;
        this.oy = null;
        this.oz = null;
        this.oA = null;
        this.oB = false;
        this.oC = null;
        this.oD = od;
        this.orientation = -1;
        this.oE = 4;
        this.ob = null;
        this.kQ = kq;
        this.oF = null;
        this.oG = null;
        this.oH = null;
    }
    
    public ch(final t ow, final ci ox, final ba oz, final cl od, final ex oy, final boolean ob, final int orientation, final String ob2, final ev kq, final bd of) {
        this.versionCode = 4;
        this.ov = null;
        this.ow = ow;
        this.ox = ox;
        this.oy = oy;
        this.oz = oz;
        this.oA = null;
        this.oB = ob;
        this.oC = null;
        this.oD = od;
        this.orientation = orientation;
        this.oE = 3;
        this.ob = ob2;
        this.kQ = kq;
        this.oF = of;
        this.oG = null;
        this.oH = null;
    }
    
    public ch(final t ow, final ci ox, final ba oz, final cl od, final ex oy, final boolean ob, final int orientation, final String oc, final String oa, final ev kq, final bd of) {
        this.versionCode = 4;
        this.ov = null;
        this.ow = ow;
        this.ox = ox;
        this.oy = oy;
        this.oz = oz;
        this.oA = oa;
        this.oB = ob;
        this.oC = oc;
        this.oD = od;
        this.orientation = orientation;
        this.oE = 3;
        this.ob = null;
        this.kQ = kq;
        this.oF = of;
        this.oG = null;
        this.oH = null;
    }
    
    public ch(final t ow, final ci ox, final cl od, final ex oy, final int orientation, final ev kq, final String og, final v oh) {
        this.versionCode = 4;
        this.ov = null;
        this.ow = ow;
        this.ox = ox;
        this.oy = oy;
        this.oz = null;
        this.oA = null;
        this.oB = false;
        this.oC = null;
        this.oD = od;
        this.orientation = orientation;
        this.oE = 1;
        this.ob = null;
        this.kQ = kq;
        this.oF = null;
        this.oG = og;
        this.oH = oh;
    }
    
    public ch(final t ow, final ci ox, final cl od, final ex oy, final boolean ob, final int orientation, final ev kq) {
        this.versionCode = 4;
        this.ov = null;
        this.ow = ow;
        this.ox = ox;
        this.oy = oy;
        this.oz = null;
        this.oA = null;
        this.oB = ob;
        this.oC = null;
        this.oD = od;
        this.orientation = orientation;
        this.oE = 2;
        this.ob = null;
        this.kQ = kq;
        this.oF = null;
        this.oG = null;
        this.oH = null;
    }
    
    public static ch a(final Intent intent) {
        try {
            final Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(ch.class.getClassLoader());
            return (ch)bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    public static void a(final Intent intent, final ch ch) {
        final Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", (Parcelable)ch);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }
    
    IBinder aU() {
        return e.h(this.ow).asBinder();
    }
    
    IBinder aV() {
        return e.h(this.ox).asBinder();
    }
    
    IBinder aW() {
        return e.h(this.oy).asBinder();
    }
    
    IBinder aX() {
        return e.h(this.oz).asBinder();
    }
    
    IBinder aY() {
        return e.h(this.oF).asBinder();
    }
    
    IBinder aZ() {
        return e.h(this.oD).asBinder();
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        cg.a(this, parcel, n);
    }
}
