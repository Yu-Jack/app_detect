// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.a;

import org.codehaus.jackson.f.a;
import java.util.Map;
import org.codehaus.jackson.c.ad;
import java.util.HashMap;

public final class k
{
    protected final b a;
    protected final m b;
    
    private k(final b a) {
        this.b = new m(this.getClass(), false);
        this.a = a;
    }
    
    public static k a(final HashMap<m, ad<Object>> hashMap) {
        return new k(new b(hashMap));
    }
    
    public ad<Object> a(final Class<?> clazz) {
        this.b.a(clazz);
        return this.a.a(this.b);
    }
    
    public ad<Object> a(final a a) {
        this.b.a(a);
        return this.a.a(this.b);
    }
    
    public k a() {
        return new k(this.a);
    }
    
    public ad<Object> b(final Class<?> clazz) {
        this.b.b(clazz);
        return this.a.a(this.b);
    }
    
    public ad<Object> b(final a a) {
        this.b.b(a);
        return this.a.a(this.b);
    }
}
