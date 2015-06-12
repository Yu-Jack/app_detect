import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;

// 
// Decompiled by Procyon v0.5.29
// 

public class av extends bg implements Map
{
    ba a;
    
    private ba b() {
        if (this.a == null) {
            this.a = new aw(this);
        }
        return this.a;
    }
    
    @Override
    public Set entrySet() {
        final ba b = this.b();
        if (b.b == null) {
            b.b = new bc(b);
        }
        return b.b;
    }
    
    @Override
    public Set keySet() {
        final ba b = this.b();
        if (b.c == null) {
            b.c = new bd(b);
        }
        return b.c;
    }
    
    @Override
    public void putAll(final Map map) {
        final int n = this.h + map.size();
        if (super.f.length < n) {
            final int[] f = super.f;
            final Object[] g = super.g;
            super.a(n);
            if (super.h > 0) {
                System.arraycopy(f, 0, super.f, 0, super.h);
                System.arraycopy(g, 0, super.g, 0, super.h << 1);
            }
            bg.a(f, g, super.h);
        }
        for (final Entry<Object, V> entry : map.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }
    
    @Override
    public Collection values() {
        final ba b = this.b();
        if (b.d == null) {
            b.d = new bf(b);
        }
        return b.d;
    }
}
