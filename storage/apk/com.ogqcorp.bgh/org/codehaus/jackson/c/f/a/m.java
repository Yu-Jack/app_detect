// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.f.a;

import org.codehaus.jackson.c.p;
import org.codehaus.jackson.c.x;
import java.util.HashMap;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.f.c;
import org.codehaus.jackson.c.az;

public abstract class m extends az
{
    protected final c b;
    protected final a c;
    protected final f d;
    protected final a e;
    protected final HashMap<String, x<Object>> f;
    protected x<Object> g;
    
    protected m(final a c, final c b, final f d, final Class<?> clazz) {
        this.c = c;
        this.b = b;
        this.d = d;
        this.f = new HashMap<String, x<Object>>();
        if (clazz == null) {
            this.e = null;
            return;
        }
        this.e = c.g(clazz);
    }
    
    protected final x<Object> a(final p p) {
        if (this.e == null) {
            return null;
        }
        synchronized (this.e) {
            if (this.g == null) {
                this.g = p.b().a(p.a(), this.e, this.d);
            }
            return this.g;
        }
    }
    
    protected final x<Object> a(final p p2, final String s) {
        // monitorexit(hashMap)
        while (true) {
            a a = null;
            Label_0089: {
                x<Object> value = null;
                Label_0084: {
                    synchronized (this.f) {
                        value = this.f.get(s);
                        if (value != null) {
                            break Label_0084;
                        }
                        a = this.b.a(s);
                        if (a != null) {
                            break Label_0089;
                        }
                        if (this.e == null) {
                            throw p2.a(this.c, s);
                        }
                    }
                    value = this.a(p2);
                    this.f.put(s, value);
                }
                return value;
            }
            if (this.c != null && this.c.getClass() == a.getClass()) {
                a = this.c.f(a.p());
            }
            x<Object> value = p2.b().a(p2.a(), a, this.d);
            continue;
        }
    }
    
    @Override
    public String b() {
        return null;
    }
    
    public String c() {
        return this.c.p().getName();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.getClass().getName());
        sb.append("; base-type:").append(this.c);
        sb.append("; id-resolver: ").append(this.b);
        sb.append(']');
        return sb.toString();
    }
}
