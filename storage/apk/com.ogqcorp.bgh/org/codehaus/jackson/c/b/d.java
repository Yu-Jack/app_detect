// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b;

import java.util.ArrayList;
import java.util.Map;
import org.codehaus.jackson.c.e;
import org.codehaus.jackson.c.b.a.a;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.c.f;
import java.util.LinkedHashMap;
import java.util.HashSet;
import org.codehaus.jackson.c.b.a.p;
import java.util.List;
import java.util.HashMap;
import org.codehaus.jackson.c.e.k;

public class d
{
    protected final k a;
    protected final HashMap<String, i> b;
    protected List<p> c;
    protected HashMap<String, i> d;
    protected HashSet<String> e;
    protected t f;
    protected h g;
    protected boolean h;
    
    public d(final k a) {
        this.b = new LinkedHashMap<String, i>();
        this.a = a;
    }
    
    public x<?> a(final f f) {
        final a a = new a(this.b.values());
        a.a();
        return new c(this.a, f, this.f, a, this.d, this.e, this.h, this.g, this.c);
    }
    
    public void a(final String e) {
        if (this.e == null) {
            this.e = new HashSet<String>();
        }
        this.e.add(e);
    }
    
    public void a(final String key, final i value) {
        if (this.d == null) {
            this.d = new HashMap<String, i>(4);
        }
        this.d.put(key, value);
        if (this.b != null) {
            this.b.remove(value.c());
        }
    }
    
    public void a(final String s, final org.codehaus.jackson.f.a a, final org.codehaus.jackson.c.i.a a2, final org.codehaus.jackson.c.e.e e, final Object o) {
        if (this.c == null) {
            this.c = new ArrayList<p>();
        }
        this.c.add(new p(s, a, a2, e, o));
    }
    
    public void a(final h g) {
        if (this.g != null && g != null) {
            throw new IllegalStateException("_anySetter already set to non-null");
        }
        this.g = g;
    }
    
    public void a(final i value) {
        final i i = this.b.put(value.c(), value);
        if (i != null && i != value) {
            throw new IllegalArgumentException("Duplicate property '" + value.c() + "' for " + this.a.a());
        }
    }
    
    public void a(final i value, final boolean b) {
        this.b.put(value.c(), value);
    }
    
    public void a(final t f) {
        this.f = f;
    }
    
    public void a(final org.codehaus.jackson.c.h h) {
    }
    
    public void a(final boolean h) {
        this.h = h;
    }
    
    public boolean b(final String key) {
        return this.b.containsKey(key);
    }
}
