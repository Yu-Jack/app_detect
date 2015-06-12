// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Arrays;

public final class ku
{
    final int a;
    final byte[] b;
    
    @Override
    public boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof ku)) {
                return false;
            }
            final ku ku = (ku)o;
            if (this.a != ku.a || !Arrays.equals(this.b, ku.b)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return 31 * (527 + this.a) + Arrays.hashCode(this.b);
    }
}
