// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.f.a;

import org.codehaus.jackson.c.e.k;
import java.util.Iterator;
import java.util.Collection;
import org.codehaus.jackson.f.a;
import java.util.HashMap;
import org.codehaus.jackson.c.ai;

public class o extends n
{
    protected final ai<?> a;
    protected final HashMap<String, String> b;
    protected final HashMap<String, a> e;
    
    protected o(final ai<?> a, final a a2, final HashMap<String, String> b, final HashMap<String, a> e) {
        super(a2, a.m());
        this.a = a;
        this.b = b;
        this.e = e;
    }
    
    protected static String a(final Class<?> clazz) {
        final String name = clazz.getName();
        final int lastIndex = name.lastIndexOf(46);
        if (lastIndex < 0) {
            return name;
        }
        return name.substring(lastIndex + 1);
    }
    
    public static o a(final ai<?> ai, final a a, final Collection<org.codehaus.jackson.c.f.a> collection, final boolean b, final boolean b2) {
        if (b == b2) {
            throw new IllegalArgumentException();
        }
        HashMap<String, String> hashMap;
        if (b) {
            hashMap = new HashMap<String, String>();
        }
        else {
            hashMap = null;
        }
        HashMap<String, a> hashMap2;
        if (b2) {
            hashMap2 = new HashMap<String, a>();
        }
        else {
            hashMap2 = null;
        }
        if (collection != null) {
            for (final org.codehaus.jackson.c.f.a a2 : collection) {
                final Class<?> a3 = a2.a();
                String key;
                if (a2.c()) {
                    key = a2.b();
                }
                else {
                    key = a(a3);
                }
                if (b) {
                    hashMap.put(a3.getName(), key);
                }
                if (b2) {
                    final a a4 = hashMap2.get(key);
                    if (a4 != null && a3.isAssignableFrom(a4.p())) {
                        continue;
                    }
                    hashMap2.put(key, ai.b(a3));
                }
            }
        }
        return new o(ai, a, hashMap, hashMap2);
    }
    
    @Override
    public String a(final Object o) {
        final Class<?> class1 = o.getClass();
        final String name = class1.getName();
        synchronized (this.b) {
            String value = this.b.get(name);
            if (value == null) {
                if (this.a.b()) {
                    value = this.a.a().g(this.a.c(class1).c());
                }
                if (value == null) {
                    value = a(class1);
                }
                this.b.put(name, value);
            }
            return value;
        }
    }
    
    @Override
    public String a(final Object o, final Class<?> clazz) {
        return this.a(o);
    }
    
    @Override
    public a a(final String key) {
        return this.e.get(key);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.getClass().getName());
        sb.append("; id-to-type=").append(this.e);
        sb.append(']');
        return sb.toString();
    }
}
