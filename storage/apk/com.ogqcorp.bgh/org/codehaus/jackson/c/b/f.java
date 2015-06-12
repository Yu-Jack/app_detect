// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b;

import java.lang.reflect.Member;
import org.codehaus.jackson.c.b.b.bx;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import org.codehaus.jackson.c.z;
import org.codehaus.jackson.c.c;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.c.az;
import org.codehaus.jackson.c.e.h;
import java.util.Iterator;
import org.codehaus.jackson.c.i.o;
import org.codehaus.jackson.c.b.b.bs;
import org.codehaus.jackson.c.i.l;
import org.codehaus.jackson.c.e.k;
import org.codehaus.jackson.c.af;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.n;
import org.codehaus.jackson.c.i.b;
import org.codehaus.jackson.c.a;
import org.codehaus.jackson.c.ah;
import org.codehaus.jackson.c.s;

public class f extends s
{
    protected static final ah[] a;
    protected static final g[] b;
    protected static final a[] c;
    protected static final u[] d;
    protected final org.codehaus.jackson.c.u[] e;
    protected final ah[] f;
    protected final g[] g;
    protected final a[] h;
    protected final u[] i;
    
    static {
        a = new ah[0];
        b = new g[0];
        c = new a[0];
        d = new u[0];
    }
    
    public f() {
        this(null, null, null, null, null);
    }
    
    protected f(org.codehaus.jackson.c.u[] a, ah[] a2, g[] b, a[] c, u[] d) {
        if (a == null) {
            a = org.codehaus.jackson.c.b.e.a;
        }
        this.e = a;
        if (a2 == null) {
            a2 = org.codehaus.jackson.c.b.f.a;
        }
        this.f = a2;
        if (b == null) {
            b = org.codehaus.jackson.c.b.f.b;
        }
        this.g = b;
        if (c == null) {
            c = org.codehaus.jackson.c.b.f.c;
        }
        this.h = c;
        if (d == null) {
            d = org.codehaus.jackson.c.b.f.d;
        }
        this.i = d;
    }
    
    @Override
    public Iterable<org.codehaus.jackson.c.u> a() {
        return org.codehaus.jackson.c.i.b.b(this.e);
    }
    
    @Override
    public Iterable<ah> b() {
        return org.codehaus.jackson.c.i.b.b(this.f);
    }
    
    @Override
    public Iterable<g> c() {
        return org.codehaus.jackson.c.i.b.b(this.g);
    }
    
    @Override
    public Iterable<a> d() {
        return org.codehaus.jackson.c.i.b.b(this.h);
    }
    
    @Override
    public Iterable<u> e() {
        return org.codehaus.jackson.c.i.b.b(this.i);
    }
    
    @Override
    public boolean f() {
        return this.f.length > 0;
    }
    
    @Override
    public boolean g() {
        return this.g.length > 0;
    }
    
    @Override
    public boolean h() {
        return this.h.length > 0;
    }
    
    @Override
    public boolean i() {
        return this.i.length > 0;
    }
}
