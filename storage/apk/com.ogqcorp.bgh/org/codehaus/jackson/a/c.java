// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.a;

import org.codehaus.jackson.e;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicInteger;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.r;
import org.codehaus.jackson.q;
import org.codehaus.jackson.f;

public abstract class c extends f
{
    protected q b;
    protected int c;
    protected boolean d;
    protected g e;
    protected boolean f;
    
    protected c(final int c, final q b) {
        this.c = c;
        this.e = g.g();
        this.b = b;
        this.d = this.a(org.codehaus.jackson.g.e);
    }
    
    @Override
    public f a() {
        return this.a(new org.codehaus.jackson.g.f());
    }
    
    @Override
    public void a(final Object o) {
        if (o == null) {
            this.f();
            return;
        }
        if (this.b != null) {
            this.b.a(this, o);
            return;
        }
        this.b(o);
    }
    
    public final boolean a(final org.codehaus.jackson.g g) {
        return (this.c & g.c()) != 0x0;
    }
    
    @Override
    public void b() {
        this.h("start an array");
        this.e = this.e.h();
        if (this.a != null) {
            this.a.e(this);
            return;
        }
        this.i();
    }
    
    protected void b(final Object o) {
        if (o == null) {
            this.f();
            return;
        }
        if (o instanceof String) {
            this.b((String)o);
            return;
        }
        if (o instanceof Number) {
            final Number n = (Number)o;
            if (n instanceof Integer) {
                this.b(n.intValue());
                return;
            }
            if (n instanceof Long) {
                this.a(n.longValue());
                return;
            }
            if (n instanceof Double) {
                this.a(n.doubleValue());
                return;
            }
            if (n instanceof Float) {
                this.a(n.floatValue());
                return;
            }
            if (n instanceof Short) {
                this.b(n.shortValue());
                return;
            }
            if (n instanceof Byte) {
                this.b(n.byteValue());
                return;
            }
            if (n instanceof BigInteger) {
                this.a((BigInteger)n);
                return;
            }
            if (n instanceof BigDecimal) {
                this.a((BigDecimal)n);
                return;
            }
            if (n instanceof AtomicInteger) {
                this.b(((AtomicInteger)n).get());
                return;
            }
            if (n instanceof AtomicLong) {
                this.a(((AtomicLong)n).get());
                return;
            }
        }
        else {
            if (o instanceof byte[]) {
                this.a((byte[])o);
                return;
            }
            if (o instanceof Boolean) {
                this.a((boolean)o);
                return;
            }
            if (o instanceof AtomicBoolean) {
                this.a(((AtomicBoolean)o).get());
                return;
            }
        }
        throw new IllegalStateException("No ObjectCodec defined for the generator, can only serialize simple wrapper types (type passed " + o.getClass().getName() + ")");
    }
    
    @Override
    public void c() {
        if (!this.e.a()) {
            this.i("Current context not an ARRAY but " + this.e.d());
        }
        if (this.a != null) {
            this.a.b(this, this.e.e());
        }
        else {
            this.j();
        }
        this.e = this.e.j();
    }
    
    @Override
    public void close() {
        this.f = true;
    }
    
    @Override
    public void d() {
        this.h("start an object");
        this.e = this.e.i();
        if (this.a != null) {
            this.a.b(this);
            return;
        }
        this.k();
    }
    
    @Override
    public void d(final String s) {
        this.h("write raw value");
        this.c(s);
    }
    
    @Override
    public void e() {
        if (!this.e.c()) {
            this.i("Current context not an object but " + this.e.d());
        }
        this.e = this.e.j();
        if (this.a != null) {
            this.a.a(this, this.e.e());
            return;
        }
        this.l();
    }
    
    public final g h() {
        return this.e;
    }
    
    protected abstract void h(final String p0);
    
    @Deprecated
    protected void i() {
    }
    
    protected void i(final String s) {
        throw new e(s);
    }
    
    @Deprecated
    protected void j() {
    }
    
    @Deprecated
    protected void k() {
    }
    
    @Deprecated
    protected void l() {
    }
    
    protected void m() {
        throw new RuntimeException("Internal error: should never end up through this code path");
    }
}
