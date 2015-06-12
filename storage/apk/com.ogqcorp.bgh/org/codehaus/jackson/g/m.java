// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.g;

import java.io.IOException;
import org.codehaus.jackson.e;
import org.codehaus.jackson.s;
import org.codehaus.jackson.a;
import java.math.BigInteger;
import java.math.BigDecimal;
import org.codehaus.jackson.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.l;
import org.codehaus.jackson.a.g;
import org.codehaus.jackson.q;
import org.codehaus.jackson.f;

public class m extends f
{
    protected static final int b;
    protected q c;
    protected int d;
    protected boolean e;
    protected o f;
    protected o g;
    protected int h;
    protected g i;
    
    static {
        b = l.a();
    }
    
    public m(final q c) {
        this.c = c;
        this.d = m.b;
        this.i = org.codehaus.jackson.a.g.g();
        final o o = new o();
        this.g = o;
        this.f = o;
        this.h = 0;
    }
    
    @Override
    public f a() {
        return this;
    }
    
    public k a(final k k) {
        final n n = new n(this.f, k.a());
        n.a(k.h());
        return n;
    }
    
    public k a(final q q) {
        return new n(this.f, q);
    }
    
    @Override
    public void a(final char c) {
        this.i();
    }
    
    @Override
    public void a(final double d) {
        this.a(p.j, d);
    }
    
    @Override
    public void a(final float f) {
        this.a(p.j, f);
    }
    
    @Override
    public void a(final long l) {
        this.a(p.i, l);
    }
    
    @Override
    public void a(final Object o) {
        this.a(p.g, o);
    }
    
    @Override
    public final void a(final String s) {
        this.a(p.f, s);
        this.i.a(s);
    }
    
    @Override
    public void a(final BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            this.f();
            return;
        }
        this.a(p.j, bigDecimal);
    }
    
    @Override
    public void a(final BigInteger bigInteger) {
        if (bigInteger == null) {
            this.f();
            return;
        }
        this.a(p.i, bigInteger);
    }
    
    @Override
    public void a(final a a, final byte[] array, final int n, final int n2) {
        final byte[] array2 = new byte[n2];
        System.arraycopy(array, n, array2, 0, n2);
        this.a((Object)array2);
    }
    
    @Override
    public void a(final org.codehaus.jackson.b.k k) {
        this.a(p.f, k);
        this.i.a(k.a());
    }
    
    public void a(final f f) {
        final o f2 = this.f;
        int n = -1;
        o o = f2;
        while (true) {
            final int n2 = n + 1;
            int n3;
            o o2;
            if (n2 >= 16) {
                final o a = o.a();
                if (a == null) {
                    break;
                }
                n3 = 0;
                o2 = a;
            }
            else {
                o2 = o;
                n3 = n2;
            }
            final p a2 = o2.a(n3);
            if (a2 == null) {
                break;
            }
            switch (m$1.a[a2.ordinal()]) {
                default: {
                    throw new RuntimeException("Internal error: should never end up through this code path");
                }
                case 1: {
                    f.d();
                    break;
                }
                case 2: {
                    f.e();
                    break;
                }
                case 3: {
                    f.b();
                    break;
                }
                case 4: {
                    f.c();
                    break;
                }
                case 5: {
                    final Object b = o2.b(n3);
                    if (b instanceof s) {
                        f.a((s)b);
                        break;
                    }
                    f.a((String)b);
                    break;
                }
                case 6: {
                    final Object b2 = o2.b(n3);
                    if (b2 instanceof s) {
                        f.b((s)b2);
                        break;
                    }
                    f.b((String)b2);
                    break;
                }
                case 7: {
                    final Number n4 = (Number)o2.b(n3);
                    if (n4 instanceof BigInteger) {
                        f.a((BigInteger)n4);
                        break;
                    }
                    if (n4 instanceof Long) {
                        f.a(n4.longValue());
                        break;
                    }
                    f.b(n4.intValue());
                    break;
                }
                case 8: {
                    final Object b3 = o2.b(n3);
                    if (b3 instanceof BigDecimal) {
                        f.a((BigDecimal)b3);
                        break;
                    }
                    if (b3 instanceof Float) {
                        f.a((float)b3);
                        break;
                    }
                    if (b3 instanceof Double) {
                        f.a((double)b3);
                        break;
                    }
                    if (b3 == null) {
                        f.f();
                        break;
                    }
                    if (b3 instanceof String) {
                        f.e((String)b3);
                        break;
                    }
                    throw new e("Unrecognized value type for VALUE_NUMBER_FLOAT: " + ((String)b3).getClass().getName() + ", can not serialize");
                }
                case 9: {
                    f.a(true);
                    break;
                }
                case 10: {
                    f.a(false);
                    break;
                }
                case 11: {
                    f.f();
                    break;
                }
                case 12: {
                    f.a(o2.b(n3));
                    break;
                }
            }
            n = n3;
            o = o2;
        }
    }
    
    protected final void a(final p p) {
        final o a = this.g.a(this.h, p);
        if (a == null) {
            ++this.h;
            return;
        }
        this.g = a;
        this.h = 1;
    }
    
    protected final void a(final p p2, final Object o) {
        final o a = this.g.a(this.h, p2, o);
        if (a == null) {
            ++this.h;
            return;
        }
        this.g = a;
        this.h = 1;
    }
    
    @Override
    public void a(final s s) {
        this.a(p.f, s);
        this.i.a(s.a());
    }
    
    @Override
    public void a(final boolean b) {
        p p;
        if (b) {
            p = org.codehaus.jackson.p.k;
        }
        else {
            p = org.codehaus.jackson.p.l;
        }
        this.a(p);
    }
    
    @Override
    public void a(final char[] value, final int offset, final int count) {
        this.b(new String(value, offset, count));
    }
    
    @Override
    public final void b() {
        this.a(p.d);
        this.i = this.i.h();
    }
    
    @Override
    public void b(final int i) {
        this.a(p.i, i);
    }
    
    @Override
    public void b(final String s) {
        if (s == null) {
            this.f();
            return;
        }
        this.a(p.h, s);
    }
    
    public void b(final k k) {
        switch (m$1.a[k.e().ordinal()]) {
            default: {
                throw new RuntimeException("Internal error: should never end up through this code path");
            }
            case 1: {
                this.d();
            }
            case 2: {
                this.e();
            }
            case 3: {
                this.b();
            }
            case 4: {
                this.c();
            }
            case 5: {
                this.a(k.g());
            }
            case 6: {
                if (k.o()) {
                    this.a(k.l(), k.n(), k.m());
                    return;
                }
                this.b(k.k());
            }
            case 7: {
                switch (m$1.b[k.q().ordinal()]) {
                    default: {
                        this.a(k.u());
                        return;
                    }
                    case 1: {
                        this.b(k.t());
                        return;
                    }
                    case 2: {
                        this.a(k.v());
                        return;
                    }
                }
                break;
            }
            case 8: {
                switch (m$1.b[k.q().ordinal()]) {
                    default: {
                        this.a(k.x());
                        return;
                    }
                    case 3: {
                        this.a(k.y());
                        return;
                    }
                    case 4: {
                        this.a(k.w());
                        return;
                    }
                }
                break;
            }
            case 9: {
                this.a(true);
            }
            case 10: {
                this.a(false);
            }
            case 11: {
                this.f();
            }
            case 12: {
                this.a(k.z());
            }
        }
    }
    
    @Override
    public void b(final s s) {
        if (s == null) {
            this.f();
            return;
        }
        this.a(p.h, s);
    }
    
    @Override
    public void b(final char[] array, final int n, final int n2) {
        this.i();
    }
    
    @Override
    public final void c() {
        this.a(p.e);
        final g j = this.i.j();
        if (j != null) {
            this.i = j;
        }
    }
    
    @Override
    public void c(final String s) {
        this.i();
    }
    
    public void c(final k k) {
        p p = k.e();
        if (p == org.codehaus.jackson.p.f) {
            this.a(k.g());
            p = k.b();
        }
        switch (m$1.a[p.ordinal()]) {
            default: {
                this.b(k);
            }
            case 3: {
                this.b();
                while (k.b() != org.codehaus.jackson.p.e) {
                    this.c(k);
                }
                this.c();
            }
            case 1: {
                this.d();
                while (k.b() != org.codehaus.jackson.p.c) {
                    this.c(k);
                }
                this.e();
            }
        }
    }
    
    @Override
    public void close() {
        this.e = true;
    }
    
    @Override
    public final void d() {
        this.a(p.b);
        this.i = this.i.i();
    }
    
    @Override
    public void d(final String s) {
        this.i();
    }
    
    @Override
    public final void e() {
        this.a(p.c);
        final g j = this.i.j();
        if (j != null) {
            this.i = j;
        }
    }
    
    @Override
    public void e(final String s) {
        this.a(p.j, s);
    }
    
    @Override
    public void f() {
        this.a(p.m);
    }
    
    @Override
    public void g() {
    }
    
    public k h() {
        return this.a(this.c);
    }
    
    protected void i() {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[TokenBuffer: ");
        final k h = this.h();
        int n = 0;
        while (true) {
            p b;
            try {
                b = h.b();
                if (b == null) {
                    if (n >= 100) {
                        sb.append(" ... (truncated ").append(n - 100).append(" entries)");
                    }
                    sb.append(']');
                    return sb.toString();
                }
            }
            catch (IOException cause) {
                throw new IllegalStateException(cause);
            }
            if (n < 100) {
                if (n > 0) {
                    sb.append(", ");
                }
                sb.append(b.toString());
            }
            ++n;
        }
    }
}
