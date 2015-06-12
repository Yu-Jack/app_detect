// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.a;

import org.codehaus.jackson.c.as;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.ad;
import java.util.HashMap;

public final class l
{
    private HashMap<m, ad<Object>> a;
    private k b;
    
    public l() {
        this.a = new HashMap<m, ad<Object>>(64);
        this.b = null;
    }
    
    public ad<Object> a(final Class<?> clazz) {
        synchronized (this) {
            return this.a.get(new m(clazz, false));
        }
    }
    
    public ad<Object> a(final a a) {
        synchronized (this) {
            return this.a.get(new m(a, false));
        }
    }
    
    public k a() {
        synchronized (this) {
            k b = this.b;
            if (b == null) {
                b = k.a(this.a);
                this.b = b;
            }
            return b.a();
        }
    }
    
    public void a(final Class<?> clazz, final ad<Object> value) {
        synchronized (this) {
            if (this.a.put(new m(clazz, true), value) == null) {
                this.b = null;
            }
        }
    }
    
    public void a(final Class<?> clazz, final ad<Object> value, final ax ax) {
        synchronized (this) {
            if (this.a.put(new m(clazz, false), value) == null) {
                this.b = null;
            }
            if (value instanceof as) {
                ((as)value).a(ax);
            }
        }
    }
    
    public void a(final a a, final ad<Object> value) {
        synchronized (this) {
            if (this.a.put(new m(a, true), value) == null) {
                this.b = null;
            }
        }
    }
    
    public void a(final a a, final ad<Object> value, final ax ax) {
        synchronized (this) {
            if (this.a.put(new m(a, false), value) == null) {
                this.b = null;
            }
            if (value instanceof as) {
                ((as)value).a(ax);
            }
        }
    }
    
    public ad<Object> b(final Class<?> clazz) {
        synchronized (this) {
            return this.a.get(new m(clazz, true));
        }
    }
    
    public ad<Object> b(final a a) {
        synchronized (this) {
            return this.a.get(new m(a, true));
        }
    }
}
