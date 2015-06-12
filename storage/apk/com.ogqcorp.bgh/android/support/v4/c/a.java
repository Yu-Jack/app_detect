// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;

public class a<K, V> extends l<K, V> implements Map<K, V>
{
    f<K, V> a;
    
    private f<K, V> b() {
        if (this.a == null) {
            this.a = new f<K, V>() {
                @Override
                protected int a() {
                    return android.support.v4.c.a.this.h;
                }
                
                @Override
                protected int a(final Object o) {
                    if (o == null) {
                        return android.support.v4.c.a.this.a();
                    }
                    return android.support.v4.c.a.this.a(o, o.hashCode());
                }
                
                @Override
                protected Object a(final int n, final int n2) {
                    return android.support.v4.c.a.this.g[n2 + (n << 1)];
                }
                
                @Override
                protected V a(final int n, final V v) {
                    return android.support.v4.c.a.this.a(n, v);
                }
                
                @Override
                protected void a(final int n) {
                    android.support.v4.c.a.this.d(n);
                }
                
                @Override
                protected void a(final K k, final V v) {
                    android.support.v4.c.a.this.put(k, v);
                }
                
                @Override
                protected int b(final Object o) {
                    return android.support.v4.c.a.this.a(o);
                }
                
                @Override
                protected Map<K, V> b() {
                    return (Map<K, V>)android.support.v4.c.a.this;
                }
                
                @Override
                protected void c() {
                    android.support.v4.c.a.this.clear();
                }
            };
        }
        return this.a;
    }
    
    @Override
    public Set<Entry<K, V>> entrySet() {
        return this.b().d();
    }
    
    @Override
    public Set<K> keySet() {
        return this.b().e();
    }
    
    @Override
    public void putAll(final Map<? extends K, ? extends V> map) {
        this.a(this.h + map.size());
        for (final Entry<? extends K, ? extends V> entry : map.entrySet()) {
            this.put((K)entry.getKey(), (V)entry.getValue());
        }
    }
    
    @Override
    public Collection<V> values() {
        return this.b().f();
    }
}
