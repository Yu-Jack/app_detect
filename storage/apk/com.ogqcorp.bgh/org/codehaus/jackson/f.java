// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson;

import org.codehaus.jackson.b.k;
import java.math.BigInteger;
import java.math.BigDecimal;
import org.codehaus.jackson.b.b;
import java.io.Closeable;

public abstract class f implements Closeable
{
    protected r a;
    
    public abstract f a();
    
    public f a(final int n) {
        return this;
    }
    
    public f a(final b b) {
        return this;
    }
    
    public f a(final r a) {
        this.a = a;
        return this;
    }
    
    public abstract void a(final char p0);
    
    public abstract void a(final double p0);
    
    public abstract void a(final float p0);
    
    public abstract void a(final long p0);
    
    public abstract void a(final Object p0);
    
    public abstract void a(final String p0);
    
    public void a(final String s, final String s2) {
        this.a(s);
        this.b(s2);
    }
    
    public abstract void a(final BigDecimal p0);
    
    public abstract void a(final BigInteger p0);
    
    public abstract void a(final a p0, final byte[] p1, final int p2, final int p3);
    
    public void a(final k k) {
        this.a(k.a());
    }
    
    public void a(final s s) {
        this.a(s.a());
    }
    
    public abstract void a(final boolean p0);
    
    public void a(final byte[] array) {
        this.a(org.codehaus.jackson.b.a(), array, 0, array.length);
    }
    
    public abstract void a(final char[] p0, final int p1, final int p2);
    
    public abstract void b();
    
    public abstract void b(final int p0);
    
    public abstract void b(final String p0);
    
    public void b(final s s) {
        this.b(s.a());
    }
    
    public abstract void b(final char[] p0, final int p1, final int p2);
    
    public abstract void c();
    
    public abstract void c(final String p0);
    
    @Override
    public abstract void close();
    
    public abstract void d();
    
    public abstract void d(final String p0);
    
    public abstract void e();
    
    public abstract void e(final String p0);
    
    public abstract void f();
    
    public final void f(final String s) {
        this.a(s);
        this.b();
    }
    
    public abstract void g();
    
    public final void g(final String s) {
        this.a(s);
        this.d();
    }
}
