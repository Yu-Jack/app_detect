// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c;

import org.codehaus.jackson.c.h.k;
import org.codehaus.jackson.c.e.x;
import org.codehaus.jackson.c.f.b;

abstract class al<CFG extends ak, T extends al<CFG, T>> extends ai<T>
{
    protected int i;
    
    protected al(final al<CFG, T> al, final aj aj, final b b) {
        super(al, aj, b);
        this.i = al.i;
    }
    
    protected al(final i<? extends e> i, final org.codehaus.jackson.c.b b, final x<?> x, final b b2, final ao ao, final k k, final v v, final int j) {
        super(i, b, x, b2, ao, k, v);
        this.i = j;
    }
    
    static <F extends Enum> int d(final Class<F> clazz) {
        final java.lang.Enum[] array = (java.lang.Enum[])clazz.getEnumConstants();
        final int length = array.length;
        int i = 0;
        int n = 0;
        while (i < length) {
            final java.lang.Enum enum1 = array[i];
            int n2;
            if (((ak)enum1).a()) {
                n2 = (n | ((ak)enum1).b());
            }
            else {
                n2 = n;
            }
            ++i;
            n = n2;
        }
        return n;
    }
    
    @Deprecated
    public void a(final CFG cfg) {
        this.i &= (-1 ^ cfg.b());
    }
    
    @Deprecated
    public void a(final CFG cfg, final boolean b) {
        if (b) {
            this.b(cfg);
            return;
        }
        this.a(cfg);
    }
    
    @Deprecated
    public void b(final CFG cfg) {
        this.i |= cfg.b();
    }
}
