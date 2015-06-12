// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fk implements SafeParcelable
{
    public static final fl CREATOR;
    public static final int xT;
    final int xM;
    public final String xU;
    final fp xV;
    public final int xW;
    public final byte[] xX;
    
    static {
        xT = Integer.parseInt("-1");
        CREATOR = new fl();
    }
    
    fk(final int xm, final String xu, final fp xv, final int n, final byte[] xx) {
        hm.b(n == fk.xT || fo.H(n) != null, (Object)("Invalid section type " + n));
        this.xM = xm;
        this.xU = xu;
        this.xV = xv;
        this.xW = n;
        this.xX = xx;
        final String do1 = this.dO();
        if (do1 != null) {
            throw new IllegalArgumentException(do1);
        }
    }
    
    public fk(final String s, final fp fp) {
        this(1, s, fp, fk.xT, null);
    }
    
    public fk(final String s, final fp fp, final String s2) {
        this(1, s, fp, fo.Y(s2), null);
    }
    
    public fk(final byte[] array, final fp fp) {
        this(1, null, fp, fk.xT, array);
    }
    
    public String dO() {
        if (this.xW != fk.xT && fo.H(this.xW) == null) {
            return "Invalid section type " + this.xW;
        }
        if (this.xU != null && this.xX != null) {
            return "Both content and blobContent set";
        }
        return null;
    }
    
    public int describeContents() {
        final fl creator = fk.CREATOR;
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final fl creator = fk.CREATOR;
        fl.a(this, parcel, n);
    }
}
