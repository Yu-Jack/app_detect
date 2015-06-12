// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.g;

import java.math.BigInteger;
import java.math.BigDecimal;
import org.codehaus.jackson.p;
import org.codehaus.jackson.a;
import org.codehaus.jackson.h;
import org.codehaus.jackson.a.f;
import org.codehaus.jackson.q;
import org.codehaus.jackson.a.e;

public final class n extends e
{
    protected q d;
    protected o e;
    protected int f;
    protected f g;
    protected boolean h;
    protected transient d i;
    protected h j;
    
    public n(final o e, final q d) {
        super(0);
        this.j = null;
        this.e = e;
        this.f = -1;
        this.d = d;
        this.g = org.codehaus.jackson.a.f.a(-1, -1);
    }
    
    protected final Object C() {
        return this.e.b(this.f);
    }
    
    protected final void D() {
        if (this.b == null || !this.b.c()) {
            throw this.a("Current token (" + this.b + ") not numeric, can not use numeric value accessors");
        }
    }
    
    @Override
    protected void J() {
        this.W();
    }
    
    @Override
    public q a() {
        return this.d;
    }
    
    public void a(final h j) {
        this.j = j;
    }
    
    @Override
    public byte[] a(final a a) {
        if (this.b == p.g) {
            final Object c = this.C();
            if (c instanceof byte[]) {
                return (byte[])c;
            }
        }
        if (this.b != p.h) {
            throw this.a("Current token (" + this.b + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), can not access as binary");
        }
        final String k = this.k();
        if (k == null) {
            return null;
        }
        d i = this.i;
        if (i == null) {
            i = new d(100);
            this.i = i;
        }
        else {
            this.i.a();
        }
        this.a(k, i, a);
        return i.b();
    }
    
    @Override
    public p b() {
        if (!this.h && this.e != null) {
            if (++this.f >= 16) {
                this.f = 0;
                this.e = this.e.a();
                if (this.e == null) {
                    return null;
                }
            }
            this.b = this.e.a(this.f);
            if (this.b == p.f) {
                final Object c = this.C();
                String string;
                if (c instanceof String) {
                    string = (String)c;
                }
                else {
                    string = c.toString();
                }
                this.g.a(string);
            }
            else if (this.b == p.b) {
                this.g = this.g.c(-1, -1);
            }
            else if (this.b == p.d) {
                this.g = this.g.b(-1, -1);
            }
            else if (this.b == p.c || this.b == p.e) {
                this.g = this.g.i();
                if (this.g == null) {
                    this.g = org.codehaus.jackson.a.f.a(-1, -1);
                }
            }
            return this.b;
        }
        return null;
    }
    
    @Override
    public void close() {
        if (!this.h) {
            this.h = true;
        }
    }
    
    @Override
    public String g() {
        return this.g.h();
    }
    
    @Override
    public h h() {
        return this.i();
    }
    
    @Override
    public h i() {
        if (this.j == null) {
            return org.codehaus.jackson.h.a;
        }
        return this.j;
    }
    
    @Override
    public String k() {
        String s;
        if (this.b == p.h || this.b == p.f) {
            final Object c = this.C();
            if (!(c instanceof String)) {
                String string;
                if (c == null) {
                    string = null;
                }
                else {
                    string = c.toString();
                }
                return string;
            }
            s = (String)c;
        }
        else {
            final p b = this.b;
            s = null;
            if (b != null) {
                switch (m.m$1.a[this.b.ordinal()]) {
                    default: {
                        return this.b.a();
                    }
                    case 7:
                    case 8: {
                        final Object c2 = this.C();
                        s = null;
                        if (c2 != null) {
                            return c2.toString();
                        }
                        break;
                    }
                }
            }
        }
        return s;
    }
    
    @Override
    public char[] l() {
        final String k = this.k();
        if (k == null) {
            return null;
        }
        return k.toCharArray();
    }
    
    @Override
    public int m() {
        final String k = this.k();
        if (k == null) {
            return 0;
        }
        return k.length();
    }
    
    @Override
    public int n() {
        return 0;
    }
    
    @Override
    public boolean o() {
        return false;
    }
    
    @Override
    public final Number p() {
        this.D();
        return (Number)this.C();
    }
    
    @Override
    public org.codehaus.jackson.m q() {
        final Number p = this.p();
        if (p instanceof Integer) {
            return org.codehaus.jackson.m.a;
        }
        if (p instanceof Long) {
            return org.codehaus.jackson.m.b;
        }
        if (p instanceof Double) {
            return org.codehaus.jackson.m.e;
        }
        if (p instanceof BigDecimal) {
            return org.codehaus.jackson.m.f;
        }
        if (p instanceof Float) {
            return org.codehaus.jackson.m.d;
        }
        if (p instanceof BigInteger) {
            return org.codehaus.jackson.m.c;
        }
        return null;
    }
    
    @Override
    public int t() {
        if (this.b == p.i) {
            return ((Number)this.C()).intValue();
        }
        return this.p().intValue();
    }
    
    @Override
    public long u() {
        return this.p().longValue();
    }
    
    @Override
    public BigInteger v() {
        final Number p = this.p();
        if (p instanceof BigInteger) {
            return (BigInteger)p;
        }
        switch (m.m$1.b[this.q().ordinal()]) {
            default: {
                return BigInteger.valueOf(p.longValue());
            }
            case 3: {
                return ((BigDecimal)p).toBigInteger();
            }
        }
    }
    
    @Override
    public float w() {
        return this.p().floatValue();
    }
    
    @Override
    public double x() {
        return this.p().doubleValue();
    }
    
    @Override
    public BigDecimal y() {
        final Number p = this.p();
        if (p instanceof BigDecimal) {
            return (BigDecimal)p;
        }
        switch (m.m$1.b[this.q().ordinal()]) {
            default: {
                return BigDecimal.valueOf(p.doubleValue());
            }
            case 1:
            case 5: {
                return BigDecimal.valueOf(p.longValue());
            }
            case 2: {
                return new BigDecimal((BigInteger)p);
            }
        }
    }
    
    @Override
    public Object z() {
        if (this.b == p.g) {
            return this.C();
        }
        return null;
    }
}
