// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class gj implements SafeParcelable
{
    public static final Parcelable$Creator CREATOR;
    private double AP;
    private boolean AQ;
    private int BR;
    private final int xM;
    
    static {
        CREATOR = (Parcelable$Creator)new gk();
    }
    
    public gj() {
        this(1, Double.NaN, false, -1);
    }
    
    gj(final int xm, final double ap, final boolean aq, final int br) {
        this.xM = xm;
        this.AP = ap;
        this.AQ = aq;
        this.BR = br;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public double eh() {
        return this.AP;
    }
    
    public boolean en() {
        return this.AQ;
    }
    
    public int eo() {
        return this.BR;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof gj)) {
                return false;
            }
            final gj gj = (gj)o;
            if (this.AP != gj.AP || this.AQ != gj.AQ || this.BR != gj.BR) {
                return false;
            }
        }
        return true;
    }
    
    public int getVersionCode() {
        return this.xM;
    }
    
    @Override
    public int hashCode() {
        return hk.hashCode(this.AP, this.AQ, this.BR);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        gk.a(this, parcel, n);
    }
}
