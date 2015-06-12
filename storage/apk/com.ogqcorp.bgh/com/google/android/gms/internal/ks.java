// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.io.IOException;

public abstract class ks
{
    protected volatile int f;
    
    public ks() {
        this.f = -1;
    }
    
    public static final void a(final ks ks, final byte[] array, final int n, final int n2) {
        try {
            final kp a = kp.a(array, n, n2);
            ks.a(a);
            a.b();
        }
        catch (IOException cause) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", cause);
        }
    }
    
    public static final byte[] a(final ks ks) {
        final byte[] array = new byte[ks.b()];
        a(ks, array, 0, array.length);
        return array;
    }
    
    public void a(final kp kp) {
    }
    
    public int b() {
        return this.f = this.c();
    }
    
    protected int c() {
        return 0;
    }
    
    @Override
    public String toString() {
        return kt.a(this);
    }
}
