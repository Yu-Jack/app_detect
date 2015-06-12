// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.aa;
import org.codehaus.jackson.c.g.j;
import org.codehaus.jackson.c.z;
import org.codehaus.jackson.c.g.c;
import org.codehaus.jackson.c.ad;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.g.a;
import org.codehaus.jackson.c.g.d;
import org.codehaus.jackson.c.as;

public abstract class b extends v<Object> implements as
{
    protected static final d[] a;
    protected final d[] b;
    protected final d[] c;
    protected final a d;
    protected final Object e;
    
    static {
        a = new d[0];
    }
    
    public b(final Class<?> clazz, final d[] b, final d[] c, final a d, final Object e) {
        super(clazz);
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    protected b(final b b) {
        this(b.k, b.b, b.c, b.d, b.e);
    }
    
    protected b(final org.codehaus.jackson.f.a a, final d[] b, final d[] c, final a d, final Object e) {
        super(a);
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    @Override
    public void a(final Object o, final f f, final ax ax, final ba ba) {
        ba.b(o, f);
        if (this.e != null) {
            this.c(o, f, ax);
        }
        else {
            this.b(o, f, ax);
        }
        ba.e(o, f);
    }
    
    @Override
    public void a(final ax ax) {
        int length;
        if (this.c == null) {
            length = 0;
        }
        else {
            length = this.c.length;
        }
        for (int length2 = this.b.length, i = 0; i < length2; ++i) {
            final d d = this.b[i];
            if (!d.e()) {
                org.codehaus.jackson.f.a a = d.f();
                if (a == null) {
                    a = ax.a(d.g());
                    if (!a.u()) {
                        if (a.f() || a.h() > 0) {
                            d.a(a);
                        }
                        continue;
                    }
                }
                Object o = ax.a(a, d);
                if (a.f()) {
                    final ba ba = a.g().o();
                    if (ba != null && o instanceof e) {
                        o = ((e<Object>)o).b(ba);
                    }
                }
                this.b[i] = d.a((ad<Object>)o);
                if (i < length) {
                    final d d2 = this.c[i];
                    if (d2 != null) {
                        this.c[i] = d2.a((ad<Object>)o);
                    }
                }
            }
        }
        if (this.d != null) {
            this.d.a(ax);
        }
    }
    
    protected c b(final ax ax) {
        final Object e = this.e;
        final j b = ax.b();
        if (b == null) {
            throw new z("Can not resolve BeanPropertyFilter with id '" + e + "'; no FilterProvider configured");
        }
        return b.a(e);
    }
    
    protected void b(final Object o, final f f, final ax ax) {
        Label_0061: {
            if (this.c == null || ax.a() == null) {
                break Label_0061;
            }
            d[] array = this.c;
            while (true) {
                int i = 0;
                try {
                    while (i < array.length) {
                        final d d = array[i];
                        if (d != null) {
                            d.a(o, f, ax);
                        }
                        ++i;
                    }
                    if (this.d != null) {
                        this.d.a(o, f, ax);
                    }
                    return;
                    array = this.b;
                }
                catch (Exception ex) {
                    String d2;
                    if (i == array.length) {
                        d2 = "[anySetter]";
                    }
                    else {
                        d2 = array[i].d();
                    }
                    this.a(ax, ex, o, d2);
                }
                catch (StackOverflowError stackOverflowError) {
                    final z z = new z("Infinite recursion (StackOverflowError)", stackOverflowError);
                    String d3;
                    if (i == array.length) {
                        d3 = "[anySetter]";
                    }
                    else {
                        d3 = array[i].d();
                    }
                    z.a(new aa(o, d3));
                    throw z;
                }
            }
        }
    }
    
    protected void c(final Object o, final f f, final ax ax) {
        d[] array;
        if (this.c != null && ax.a() != null) {
            array = this.c;
        }
        else {
            array = this.b;
        }
        final c b = this.b(ax);
        if (b == null) {
            this.b(o, f, ax);
        }
        else {
            while (true) {
                int n = 0;
                while (true) {
                    try {
                        final int length = array.length;
                        if (n < length) {
                            final d d = array[n];
                            if (d != null) {
                                b.a(o, f, ax, d);
                            }
                        }
                        else {
                            if (this.d != null) {
                                this.d.a(o, f, ax);
                                return;
                            }
                            break;
                        }
                    }
                    catch (Exception ex) {
                        String d2;
                        if (n == array.length) {
                            d2 = "[anySetter]";
                        }
                        else {
                            d2 = array[n].d();
                        }
                        this.a(ax, ex, o, d2);
                        return;
                    }
                    catch (StackOverflowError stackOverflowError) {
                        final z z = new z("Infinite recursion (StackOverflowError)", stackOverflowError);
                        String d3;
                        if (n == array.length) {
                            d3 = "[anySetter]";
                        }
                        else {
                            d3 = array[n].d();
                        }
                        z.a(new aa(o, d3));
                        throw z;
                    }
                    ++n;
                    continue;
                }
            }
        }
    }
}
