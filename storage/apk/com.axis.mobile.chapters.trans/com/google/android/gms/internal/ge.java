// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ge implements SafeParcelable
{
    public static final Parcelable$Creator CREATOR;
    private String BC;
    private final int xM;
    
    static {
        CREATOR = (Parcelable$Creator)new gf();
    }
    
    public ge() {
        this(1, null);
    }
    
    ge(final int xm, final String bc) {
        this.xM = xm;
        this.BC = bc;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public String ec() {
        return this.BC;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o == this || (o instanceof ge && gi.a(this.BC, ((ge)o).BC));
    }
    
    public int getVersionCode() {
        return this.xM;
    }
    
    @Override
    public int hashCode() {
        return hk.hashCode(this.BC);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        gf.a(this, parcel, n);
    }
}
