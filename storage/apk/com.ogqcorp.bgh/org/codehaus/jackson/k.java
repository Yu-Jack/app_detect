// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.io.Closeable;

public abstract class k implements Closeable
{
    protected int a;
    protected p b;
    protected p c;
    
    protected k() {
    }
    
    protected k(final int a) {
        this.a = a;
    }
    
    public int A() {
        return this.a(0);
    }
    
    public long B() {
        return this.a(0L);
    }
    
    public int a(final int n) {
        return n;
    }
    
    public long a(final long n) {
        return n;
    }
    
    protected j a(final String s) {
        return new j(s, this.i());
    }
    
    public abstract q a();
    
    public boolean a(final l l) {
        return (this.a & l.c()) != 0x0;
    }
    
    public abstract byte[] a(final a p0);
    
    public abstract p b();
    
    public p c() {
        p p = this.b();
        if (p == org.codehaus.jackson.p.f) {
            p = this.b();
        }
        return p;
    }
    
    @Override
    public abstract void close();
    
    public abstract k d();
    
    public p e() {
        return this.b;
    }
    
    public void f() {
        if (this.b != null) {
            this.c = this.b;
            this.b = null;
        }
    }
    
    public abstract String g();
    
    public abstract h h();
    
    public abstract h i();
    
    public boolean j() {
        return this.e() == p.d;
    }
    
    public abstract String k();
    
    public abstract char[] l();
    
    public abstract int m();
    
    public abstract int n();
    
    public boolean o() {
        return false;
    }
    
    public abstract Number p();
    
    public abstract m q();
    
    public byte r() {
        final int t = this.t();
        if (t < -128 || t > 255) {
            throw this.a("Numeric value (" + this.k() + ") out of range of Java byte");
        }
        return (byte)t;
    }
    
    public short s() {
        final int t = this.t();
        if (t < -32768 || t > 32767) {
            throw this.a("Numeric value (" + this.k() + ") out of range of Java short");
        }
        return (short)t;
    }
    
    public abstract int t();
    
    public abstract long u();
    
    public abstract BigInteger v();
    
    public abstract float w();
    
    public abstract double x();
    
    public abstract BigDecimal y();
    
    public Object z() {
        return null;
    }
}
