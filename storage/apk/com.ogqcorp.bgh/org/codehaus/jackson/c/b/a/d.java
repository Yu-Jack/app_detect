// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.a;

import java.util.HashMap;
import org.codehaus.jackson.c.i.l;
import java.lang.reflect.Member;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.b.b.bu;
import org.codehaus.jackson.c.b.t;
import org.codehaus.jackson.c.n;
import org.codehaus.jackson.c.e.i;
import org.codehaus.jackson.c.e.c;
import org.codehaus.jackson.c.e.k;

public class d
{
    final k a;
    final boolean b;
    protected c c;
    protected i d;
    protected i e;
    protected i f;
    protected i g;
    protected i h;
    protected i i;
    protected i j;
    protected e[] k;
    
    public d(final k a, final boolean b) {
        this.k = null;
        this.a = a;
        this.b = b;
    }
    
    public t a(final n n) {
        final bu bu = new bu(n, this.a.a());
        a a;
        if (this.i == null) {
            a = null;
        }
        else {
            a = this.a.j().a(this.i.b(0));
        }
        bu.a(this.c, this.i, a, this.j, this.k);
        bu.a(this.d);
        bu.b(this.e);
        bu.c(this.f);
        bu.d(this.g);
        bu.e(this.h);
        return bu;
    }
    
    protected i a(final i obj, final i obj2, final String str) {
        if (obj2 != null && obj2.getClass() == obj.getClass()) {
            throw new IllegalArgumentException("Conflicting " + str + " creators: already had " + obj2 + ", encountered " + obj);
        }
        if (this.b) {
            l.a((Member)obj.a());
        }
        return obj;
    }
    
    public void a(final c c) {
        this.c = c;
    }
    
    public void a(final i i) {
        this.d = this.a(i, this.d, "String");
    }
    
    public void a(final i i, final e[] k) {
        this.j = this.a(i, this.j, "property-based");
        if (k.length > 1) {
            final HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
            for (int length = k.length, j = 0; j < length; ++j) {
                final String c = k[j].c();
                if (c.length() != 0 || k[j].k() == null) {
                    final Integer obj = hashMap.put(c, j);
                    if (obj != null) {
                        throw new IllegalArgumentException("Duplicate creator property \"" + c + "\" (index " + obj + " vs " + j + ")");
                    }
                }
            }
        }
        this.k = k;
    }
    
    public void b(final i i) {
        this.e = this.a(i, this.e, "int");
    }
    
    public void c(final i i) {
        this.f = this.a(i, this.f, "long");
    }
    
    public void d(final i i) {
        this.g = this.a(i, this.g, "double");
    }
    
    public void e(final i i) {
        this.h = this.a(i, this.h, "boolean");
    }
    
    public void f(final i i) {
        this.i = this.a(i, this.i, "delegate");
    }
}
