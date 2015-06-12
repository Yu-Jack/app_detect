// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.a;

import java.util.Iterator;
import org.codehaus.jackson.c.ad;
import java.util.Map;

public class b
{
    private final c[] a;
    private final int b;
    
    public b(final Map<m, ad<Object>> map) {
        final int a = a(map.size());
        this.b = a;
        final int n = a - 1;
        final c[] a2 = new c[a];
        for (final Map.Entry<m, ad<Object>> entry : map.entrySet()) {
            final m m = entry.getKey();
            final int n2 = n & m.hashCode();
            a2[n2] = new c(a2[n2], m, entry.getValue());
        }
        this.a = a2;
    }
    
    private static final int a(final int n) {
        int n2;
        if (n <= 64) {
            n2 = n + n;
        }
        else {
            n2 = n + (n >> 2);
        }
        int i;
        for (i = 8; i < n2; i += i) {}
        return i;
    }
    
    public ad<Object> a(final m m) {
        c c = this.a[m.hashCode() & -1 + this.a.length];
        if (c == null) {
            return null;
        }
        if (m.equals(c.a)) {
            return c.b;
        }
        do {
            c = c.c;
            if (c != null) {
                continue;
            }
            return null;
        } while (!m.equals(c.a));
        return c.b;
    }
}
