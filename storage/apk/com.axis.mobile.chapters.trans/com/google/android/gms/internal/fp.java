// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fp implements SafeParcelable
{
    public static final fq CREATOR;
    public final String name;
    public final int weight;
    final int xM;
    public final String yb;
    public final boolean yc;
    public final boolean yd;
    public final String ye;
    public final fm[] yf;
    final int[] yg;
    public final String yh;
    
    static {
        CREATOR = new fq();
    }
    
    fp(final int xm, final String name, final String yb, final boolean yc, final int weight, final boolean yd, final String ye, final fm[] yf, final int[] yg, final String yh) {
        this.xM = xm;
        this.name = name;
        this.yb = yb;
        this.yc = yc;
        this.weight = weight;
        this.yd = yd;
        this.ye = ye;
        this.yf = yf;
        this.yg = yg;
        this.yh = yh;
    }
    
    fp(final String s, final String s2, final boolean b, final int n, final boolean b2, final String s3, final fm[] array, final int[] array2, final String s4) {
        this(2, s, s2, b, n, b2, s3, array, array2, s4);
    }
    
    public int describeContents() {
        final fq creator = fp.CREATOR;
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof fp;
        boolean b2 = false;
        if (b) {
            final fp fp = (fp)o;
            final boolean equals = this.name.equals(fp.name);
            b2 = false;
            if (equals) {
                final boolean equals2 = this.yb.equals(fp.yb);
                b2 = false;
                if (equals2) {
                    final boolean yc = this.yc;
                    final boolean yc2 = fp.yc;
                    b2 = false;
                    if (yc == yc2) {
                        b2 = true;
                    }
                }
            }
        }
        return b2;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final fq creator = fp.CREATOR;
        fq.a(this, parcel, n);
    }
}
