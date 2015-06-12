// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fi implements SafeParcelable
{
    public static final fj CREATOR;
    final int xM;
    final String xQ;
    final String xR;
    final String xS;
    
    static {
        CREATOR = new fj();
    }
    
    fi(final int xm, final String xq, final String xr, final String xs) {
        this.xM = xm;
        this.xQ = xq;
        this.xR = xr;
        this.xS = xs;
    }
    
    public fi(final String s, final String s2, final String s3) {
        this(1, s, s2, s3);
    }
    
    public int describeContents() {
        final fj creator = fi.CREATOR;
        return 0;
    }
    
    @Override
    public String toString() {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", this.xQ, this.xR, this.xS);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final fj creator = fi.CREATOR;
        fj.a(this, parcel, n);
    }
}
