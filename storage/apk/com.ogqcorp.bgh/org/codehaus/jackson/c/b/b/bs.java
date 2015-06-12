// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import org.codehaus.jackson.c.i.l;
import org.codehaus.jackson.c.h.k;
import org.codehaus.jackson.c.n;
import org.codehaus.jackson.c.e.f;
import org.codehaus.jackson.c.i.o;
import org.codehaus.jackson.c.af;
import org.codehaus.jackson.f.a;
import java.util.HashMap;

public class bs
{
    protected final HashMap<a, af> a;
    
    protected bs() {
        this.a = new HashMap<a, af>();
        this.a(new bd());
        this.a(new be());
        this.a(new bg());
        this.a(new bn());
        this.a(new bl());
        this.a(new bm());
        this.a(new bk());
        this.a(new bi());
        this.a(new bh());
        this.a(new bf());
        this.a(new br());
    }
    
    public static HashMap<a, af> a() {
        return new bs().a;
    }
    
    public static af a(final o<?> o) {
        return new bj(o, null);
    }
    
    public static af a(final o<?> o, final f f) {
        return new bj(o, f);
    }
    
    public static af a(final n n, final a a) {
        return bq.a(a.getClass());
    }
    
    private void a(final bc value) {
        this.a.put(k.a().a(value.a()), value);
    }
    
    public static af b(final n n, final a a) {
        final org.codehaus.jackson.c.e.k k = n.b(a);
        final Constructor<?> a2 = k.a((Class<?>[])new Class[] { String.class });
        if (a2 != null) {
            if (n.a(org.codehaus.jackson.c.o.f)) {
                l.a(a2);
            }
            return new bo(a2);
        }
        final Method b = k.b(String.class);
        if (b != null) {
            if (n.a(org.codehaus.jackson.c.o.f)) {
                l.a((Member)b);
            }
            return new bp(b);
        }
        return null;
    }
}
