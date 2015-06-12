// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;

public class a extends l implements Map
{
    f a;
    
    private f b() {
        if (this.a == null) {
            this.a = new f() {
                @Override
                protected final int a() {
                    return android.support.v4.b.a.this.h;
                }
                
                @Override
                protected final int a(final Object o) {
                    if (o == null) {
                        return android.support.v4.b.a.this.a();
                    }
                    return android.support.v4.b.a.this.a(o, o.hashCode());
                }
                
                @Override
                protected final Object a(final int n, final int n2) {
                    return android.support.v4.b.a.this.g[n2 + (n << 1)];
                }
                
                @Override
                protected final Object a(final int n, final Object o) {
                    final a a = android.support.v4.b.a.this;
                    final int n2 = 1 + (n << 1);
                    final Object o2 = a.g[n2];
                    a.g[n2] = o;
                    return o2;
                }
                
                @Override
                protected final void a(final int n) {
                    android.support.v4.b.a.this.c(n);
                }
                
                @Override
                protected final void a(final Object o, final Object o2) {
                    android.support.v4.b.a.this.put(o, o2);
                }
                
                @Override
                protected final int b(final Object o) {
                    return android.support.v4.b.a.this.a(o);
                }
                
                @Override
                protected final Map b() {
                    return android.support.v4.b.a.this;
                }
                
                @Override
                protected final void c() {
                    android.support.v4.b.a.this.clear();
                }
            };
        }
        return this.a;
    }
    
    @Override
    public Set entrySet() {
        final f b = this.b();
        if (b.b == null) {
            b.b = new h(b);
        }
        return b.b;
    }
    
    @Override
    public Set keySet() {
        final f b = this.b();
        if (b.c == null) {
            b.c = new i(b);
        }
        return b.c;
    }
    
    @Override
    public void putAll(final Map map) {
        this.a(this.h + map.size());
        for (final Entry<Object, V> entry : map.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }
    
    @Override
    public Collection values() {
        final f b = this.b();
        if (b.d == null) {
            b.d = new k(b);
        }
        return b.d;
    }
}
