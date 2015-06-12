// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.BitSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fg implements SafeParcelable
{
    public static final fh CREATOR;
    final int xM;
    final fk[] xN;
    public final String xO;
    public final boolean xP;
    
    static {
        CREATOR = new fh();
    }
    
    fg(final int xm, final fk[] xn, final String xo, final boolean xp) {
        this.xM = xm;
        this.xN = xn;
        this.xO = xo;
        this.xP = xp;
    }
    
    public fg(final String s, final boolean b, final fk... array) {
        this(1, array, s, b);
        final BitSet set = new BitSet(fo.dP());
        for (int i = 0; i < array.length; ++i) {
            final int xw = array[i].xW;
            if (xw != -1) {
                if (set.get(xw)) {
                    throw new IllegalArgumentException("Duplicate global search section type " + fo.H(xw));
                }
                set.set(xw);
            }
        }
    }
    
    public int describeContents() {
        final fh creator = fg.CREATOR;
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final fh creator = fg.CREATOR;
        fh.a(this, parcel, n);
    }
}
