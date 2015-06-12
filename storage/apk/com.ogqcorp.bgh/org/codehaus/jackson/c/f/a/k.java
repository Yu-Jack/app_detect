// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.f.a;

import java.util.List;
import org.codehaus.jackson.c.e.e;
import java.util.Iterator;
import java.util.ArrayList;
import org.codehaus.jackson.c.j;
import java.util.HashMap;
import java.util.Collection;
import org.codehaus.jackson.c.ai;
import org.codehaus.jackson.c.f.a;
import java.util.LinkedHashSet;
import org.codehaus.jackson.c.f.b;

public class k extends b
{
    protected LinkedHashSet<a> a;
    
    @Override
    public Collection<a> a(final org.codehaus.jackson.c.e.b b, final ai<?> ai, final org.codehaus.jackson.c.b b2) {
        final HashMap<a, a> hashMap = new HashMap<a, a>();
        if (this.a != null) {
            final Class<?> d = b.d();
            for (final a a : this.a) {
                if (d.isAssignableFrom(a.a())) {
                    this.a(org.codehaus.jackson.c.e.b.b(a.a(), b2, ai), a, ai, b2, hashMap);
                }
            }
        }
        this.a(b, new a(b.d(), null), ai, b2, hashMap);
        return new ArrayList<a>(hashMap.values());
    }
    
    @Override
    public Collection<a> a(final e e, final ai<?> ai, final org.codehaus.jackson.c.b b) {
        final HashMap<a, a> hashMap = new HashMap<a, a>();
        if (this.a != null) {
            final Class<?> d = e.d();
            for (final a a : this.a) {
                if (d.isAssignableFrom(a.a())) {
                    this.a(org.codehaus.jackson.c.e.b.b(a.a(), b, ai), a, ai, b, hashMap);
                }
            }
        }
        final List<a> a2 = b.a((org.codehaus.jackson.c.e.a)e);
        if (a2 != null) {
            for (final a a3 : a2) {
                this.a(org.codehaus.jackson.c.e.b.b(a3.a(), b, ai), a3, ai, b, hashMap);
            }
        }
        this.a(org.codehaus.jackson.c.e.b.b(e.d(), b, ai), new a(e.d(), null), ai, b, hashMap);
        return new ArrayList<a>(hashMap.values());
    }
    
    protected void a(final org.codehaus.jackson.c.e.b b, a a, final ai<?> ai, final org.codehaus.jackson.c.b b2, final HashMap<a, a> hashMap) {
        if (!a.c()) {
            final String g = b2.g(b);
            if (g != null) {
                a = new a(a.a(), g);
            }
        }
        if (hashMap.containsKey(a)) {
            if (a.c() && !hashMap.get(a).c()) {
                hashMap.put(a, a);
            }
        }
        else {
            hashMap.put(a, a);
            final List<a> a2 = b2.a((org.codehaus.jackson.c.e.a)b);
            if (a2 != null && !a2.isEmpty()) {
                for (final a a3 : a2) {
                    final org.codehaus.jackson.c.e.b b3 = org.codehaus.jackson.c.e.b.b(a3.a(), b2, ai);
                    a a4;
                    if (!a3.c()) {
                        a4 = new a(a3.a(), b2.g(b3));
                    }
                    else {
                        a4 = a3;
                    }
                    this.a(b3, a4, ai, b2, hashMap);
                }
            }
        }
    }
}
