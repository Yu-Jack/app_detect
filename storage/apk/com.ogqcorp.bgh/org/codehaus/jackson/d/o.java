// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.d;

import org.codehaus.jackson.c.ba;
import java.util.Iterator;
import java.util.Map;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.i;
import java.util.LinkedHashMap;

public class o extends f
{
    protected LinkedHashMap<String, i> c;
    
    public o(final k k) {
        super(k);
        this.c = null;
    }
    
    private final i b(final String key, final i value) {
        if (this.c == null) {
            this.c = new LinkedHashMap<String, i>();
        }
        return this.c.put(key, value);
    }
    
    @Override
    public i a(final String key) {
        if (this.c != null) {
            return this.c.get(key);
        }
        return null;
    }
    
    public i a(final String s, i d) {
        if (d == null) {
            d = this.d();
        }
        return this.b(s, d);
    }
    
    @Override
    public final void a(final org.codehaus.jackson.f f, final ax ax) {
        f.d();
        if (this.c != null) {
            for (final Map.Entry<Object, Object> entry : this.c.entrySet()) {
                f.a(entry.getKey());
                entry.getValue().a(f, ax);
            }
        }
        f.e();
    }
    
    @Override
    public void a(final org.codehaus.jackson.f f, final ax ax, final ba ba) {
        ba.b(this, f);
        if (this.c != null) {
            for (final Map.Entry<Object, Object> entry : this.c.entrySet()) {
                f.a(entry.getKey());
                entry.getValue().a(f, ax);
            }
        }
        ba.e(this, f);
    }
    
    @Override
    public int b() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }
    
    @Override
    public Iterator<i> c() {
        if (this.c == null) {
            return g.a();
        }
        return this.c.values().iterator();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        final o o2 = (o)o;
        if (o2.b() != this.b()) {
            return false;
        }
        if (this.c != null) {
            for (final Map.Entry<Object, Object> entry : this.c.entrySet()) {
                final String s = entry.getKey();
                final i i = entry.getValue();
                final i a = o2.a(s);
                if (a == null || !a.equals(i)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        if (this.c == null) {
            return -1;
        }
        return this.c.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32 + (this.b() << 4));
        sb.append("{");
        if (this.c != null) {
            final Iterator<Map.Entry<Object, Object>> iterator = this.c.entrySet().iterator();
            int n = 0;
            while (iterator.hasNext()) {
                final Map.Entry<Object, Object> entry = iterator.next();
                if (n > 0) {
                    sb.append(",");
                }
                final int n2 = n + 1;
                q.a(sb, entry.getKey());
                sb.append(':');
                sb.append(entry.getValue().toString());
                n = n2;
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
