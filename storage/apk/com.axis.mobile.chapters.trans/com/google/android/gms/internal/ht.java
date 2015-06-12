// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ht implements SafeParcelable
{
    public static final hu CREATOR;
    private final hv GV;
    private final int xM;
    
    static {
        CREATOR = new hu();
    }
    
    ht(final int xm, final hv gv) {
        this.xM = xm;
        this.GV = gv;
    }
    
    private ht(final hv gv) {
        this.xM = 1;
        this.GV = gv;
    }
    
    public static ht a(final hy$b hy$b) {
        if (hy$b instanceof hv) {
            return new ht((hv)hy$b);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }
    
    public int describeContents() {
        final hu creator = ht.CREATOR;
        return 0;
    }
    
    hv fB() {
        return this.GV;
    }
    
    public hy$b fC() {
        if (this.GV != null) {
            return this.GV;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }
    
    int getVersionCode() {
        return this.xM;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final hu creator = ht.CREATOR;
        hu.a(this, parcel, n);
    }
}
