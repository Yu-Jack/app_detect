// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public final class fp$a
{
    private final String mName;
    private String yi;
    private boolean yj;
    private int yk;
    private boolean yl;
    private String ym;
    private final List yn;
    private BitSet yo;
    private String yp;
    
    public fp$a(final String mName) {
        this.mName = mName;
        this.yk = 1;
        this.yn = new ArrayList();
    }
    
    public fp$a I(final int bitIndex) {
        if (this.yo == null) {
            this.yo = new BitSet();
        }
        this.yo.set(bitIndex);
        return this;
    }
    
    public fp$a Z(final String yi) {
        this.yi = yi;
        return this;
    }
    
    public fp$a aa(final String yp) {
        this.yp = yp;
        return this;
    }
    
    public fp dQ() {
        int n = 0;
        final BitSet yo = this.yo;
        int[] array = null;
        if (yo != null) {
            array = new int[this.yo.cardinality()];
            int n2;
            for (int i = this.yo.nextSetBit(0); i >= 0; i = this.yo.nextSetBit(i + 1), n = n2) {
                n2 = n + 1;
                array[n] = i;
            }
        }
        return new fp(this.mName, this.yi, this.yj, this.yk, this.yl, this.ym, this.yn.toArray(new fm[this.yn.size()]), array, this.yp);
    }
    
    public fp$a w(final boolean yj) {
        this.yj = yj;
        return this;
    }
    
    public fp$a x(final boolean yl) {
        this.yl = yl;
        return this;
    }
}
