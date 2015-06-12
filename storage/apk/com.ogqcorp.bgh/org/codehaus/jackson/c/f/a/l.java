// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.f.a;

import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.at;
import org.codehaus.jackson.c.ai;
import org.codehaus.jackson.c.az;
import org.codehaus.jackson.c.f;
import java.util.Collection;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.n;
import org.codehaus.jackson.c.f.c;
import org.codehaus.jackson.annotate.JsonTypeInfo$As;
import org.codehaus.jackson.annotate.JsonTypeInfo$Id;
import org.codehaus.jackson.c.f.d;

public class l implements d<l>
{
    protected JsonTypeInfo$Id a;
    protected JsonTypeInfo$As b;
    protected String c;
    protected Class<?> d;
    protected c e;
    
    public static l b() {
        return new l().b(JsonTypeInfo$Id.NONE, null);
    }
    
    @Override
    public Class<?> a() {
        return this.d;
    }
    
    @Override
    public az a(final n n, final a a, final Collection<org.codehaus.jackson.c.f.a> collection, final f f) {
        if (this.a == JsonTypeInfo$Id.NONE) {
            return null;
        }
        final c a2 = this.a(n, a, collection, false, true);
        switch (l$1.a[this.b.ordinal()]) {
            default: {
                throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.b);
            }
            case 1: {
                return new org.codehaus.jackson.c.f.a.a(a, a2, f, this.d);
            }
            case 2: {
                return new e(a, a2, f, this.d, this.c);
            }
            case 3: {
                return new g(a, a2, f, this.d);
            }
            case 4: {
                return new org.codehaus.jackson.c.f.a.c(a, a2, f, this.d, this.c);
            }
        }
    }
    
    @Override
    public ba a(final at at, final a a, final Collection<org.codehaus.jackson.c.f.a> collection, final f f) {
        if (this.a == JsonTypeInfo$Id.NONE) {
            return null;
        }
        final c a2 = this.a(at, a, collection, true, false);
        switch (l$1.a[this.b.ordinal()]) {
            default: {
                throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.b);
            }
            case 1: {
                return new b(a2, f);
            }
            case 2: {
                return new org.codehaus.jackson.c.f.a.f(a2, f, this.c);
            }
            case 3: {
                return new h(a2, f);
            }
            case 4: {
                return new org.codehaus.jackson.c.f.a.d(a2, f, this.c);
            }
        }
    }
    
    protected c a(final ai<?> ai, final a a, final Collection<org.codehaus.jackson.c.f.a> collection, final boolean b, final boolean b2) {
        if (this.e != null) {
            return this.e;
        }
        if (this.a == null) {
            throw new IllegalStateException("Can not build, 'init()' not yet called");
        }
        switch (l$1.b[this.a.ordinal()]) {
            default: {
                throw new IllegalStateException("Do not know how to construct standard type id resolver for idType: " + this.a);
            }
            case 1: {
                return new i(a, ai.m());
            }
            case 2: {
                return new j(a, ai.m());
            }
            case 3: {
                return o.a(ai, a, collection, b, b2);
            }
            case 4: {
                return null;
            }
        }
    }
    
    public l b(final Class<?> d) {
        this.d = d;
        return this;
    }
    
    public l b(String defaultPropertyName) {
        if (defaultPropertyName == null || defaultPropertyName.length() == 0) {
            defaultPropertyName = this.a.getDefaultPropertyName();
        }
        this.c = defaultPropertyName;
        return this;
    }
    
    public l b(final JsonTypeInfo$As b) {
        if (b == null) {
            throw new IllegalArgumentException("includeAs can not be null");
        }
        this.b = b;
        return this;
    }
    
    public l b(final JsonTypeInfo$Id a, final c e) {
        if (a == null) {
            throw new IllegalArgumentException("idType can not be null");
        }
        this.a = a;
        this.e = e;
        this.c = a.getDefaultPropertyName();
        return this;
    }
}
