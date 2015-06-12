// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.d;

import java.math.BigInteger;
import java.math.BigDecimal;

public class k
{
    public static final k a;
    
    static {
        a = new k();
    }
    
    public d a(final byte[] array) {
        return d.a(array);
    }
    
    public e a(final boolean b) {
        if (b) {
            return e.d();
        }
        return e.e();
    }
    
    public m a() {
        return m.d();
    }
    
    public n a(final double n) {
        return i.a(n);
    }
    
    public n a(final int n) {
        return j.a(n);
    }
    
    public n a(final long n) {
        return l.a(n);
    }
    
    public n a(final BigDecimal bigDecimal) {
        return h.a(bigDecimal);
    }
    
    public n a(final BigInteger bigInteger) {
        return c.a(bigInteger);
    }
    
    public p a(final Object o) {
        return new p(o);
    }
    
    public q a(final String s) {
        return q.b(s);
    }
    
    public a b() {
        return new a(this);
    }
    
    public o c() {
        return new o(this);
    }
}
