// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ce implements SafeParcelable
{
    public static final cd CREATOR;
    public final String mimeType;
    public final String oa;
    public final String ob;
    public final String oc;
    public final String od;
    public final String oe;
    public final String packageName;
    public final int versionCode;
    
    static {
        CREATOR = new cd();
    }
    
    public ce(final int versionCode, final String oa, final String ob, final String mimeType, final String packageName, final String oc, final String od, final String oe) {
        this.versionCode = versionCode;
        this.oa = oa;
        this.ob = ob;
        this.mimeType = mimeType;
        this.packageName = packageName;
        this.oc = oc;
        this.od = od;
        this.oe = oe;
    }
    
    public ce(final String s, final String s2, final String s3, final String s4, final String s5, final String s6, final String s7) {
        this(1, s, s2, s3, s4, s5, s6, s7);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        cd.a(this, parcel, n);
    }
}
