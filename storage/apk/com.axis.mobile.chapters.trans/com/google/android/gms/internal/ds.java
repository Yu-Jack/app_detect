// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ds implements SafeParcelable
{
    public static final dt CREATOR;
    public final ApplicationInfo applicationInfo;
    public final String kN;
    public final ev kQ;
    public final al kT;
    public final Bundle pW;
    public final ai pX;
    public final PackageInfo pY;
    public final String pZ;
    public final String qa;
    public final String qb;
    public final Bundle qc;
    public final String qd;
    public final int versionCode;
    
    static {
        CREATOR = new dt();
    }
    
    ds(final int versionCode, final Bundle pw, final ai px, final al kt, final String kn, final ApplicationInfo applicationInfo, final PackageInfo py, final String pz, final String qa, final String qb, final ev kq, final Bundle qc, final String qd) {
        this.versionCode = versionCode;
        this.pW = pw;
        this.pX = px;
        this.kT = kt;
        this.kN = kn;
        this.applicationInfo = applicationInfo;
        this.pY = py;
        this.pZ = pz;
        this.qa = qa;
        this.qb = qb;
        this.kQ = kq;
        this.qc = qc;
        this.qd = qd;
    }
    
    public ds(final Bundle bundle, final ai ai, final al al, final String s, final ApplicationInfo applicationInfo, final PackageInfo packageInfo, final String s2, final String s3, final String s4, final ev ev, final Bundle bundle2, final String s5) {
        this(3, bundle, ai, al, s, applicationInfo, packageInfo, s2, s3, s4, ev, bundle2, s5);
    }
    
    public ds(final ds$a ds$a, final String s, final String s2) {
        this(ds$a.pW, ds$a.pX, ds$a.kT, ds$a.kN, ds$a.applicationInfo, ds$a.pY, s, ds$a.qa, ds$a.qb, ds$a.kQ, ds$a.qc, s2);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        dt.a(this, parcel, n);
    }
}
