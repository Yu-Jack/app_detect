// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.c;

import java.util.Map;
import java.util.LinkedHashMap;

public class e<K, V>
{
    private final LinkedHashMap<K, V> a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    
    public e(final int c) {
        if (c <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.c = c;
        this.a = new LinkedHashMap<K, V>(0, 0.75f, true);
    }
    
    private int c(final K obj, final V obj2) {
        final int b = this.b(obj, obj2);
        if (b < 0) {
            throw new IllegalStateException("Negative size: " + obj + "=" + obj2);
        }
        return b;
    }
    
    public final V a(final K key) {
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        final V b;
        synchronized (this) {
            final V value = this.a.get(key);
            if (value != null) {
                ++this.g;
                return value;
            }
            ++this.h;
            // monitorexit(this)
            b = this.b(key);
            if (b == null) {
                return null;
            }
        }
        synchronized (this) {
            ++this.e;
            final V put = this.a.put(key, b);
            if (put != null) {
                this.a.put(key, put);
            }
            else {
                this.b += this.c(key, b);
            }
            // monitorexit(this)
            if (put != null) {
                this.a(false, key, b, put);
                return put;
            }
        }
        this.a(this.c);
        return b;
    }
    
    public final V a(final K key, final V value) {
        if (key == null || value == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            ++this.d;
            this.b += this.c(key, value);
            final V put = this.a.put(key, value);
            if (put != null) {
                this.b -= this.c(key, put);
            }
            // monitorexit(this)
            if (put != null) {
                this.a(false, key, put, value);
            }
            this.a(this.c);
            return put;
        }
    }
    
    public void a(final int n) {
        while (true) {
            synchronized (this) {
                if (this.b < 0 || (this.a.isEmpty() && this.b != 0)) {
                    throw new IllegalStateException(this.getClass().getName() + ".sizeOf() is reporting inconsistent results!");
                }
            }
            if (this.b <= n || this.a.isEmpty()) {
                break;
            }
            final Map.Entry<Object, Object> entry = this.a.entrySet().iterator().next();
            final K key = entry.getKey();
            final V value = entry.getValue();
            this.a.remove(key);
            this.b -= this.c(key, value);
            ++this.f;
            // monitorexit(this)
            this.a(true, key, value, null);
        }
    }
    // monitorexit(this)
    
    protected void a(final boolean b, final K k, final V v, final V v2) {
    }
    
    protected int b(final K k, final V v) {
        return 1;
    }
    
    protected V b(final K k) {
        return null;
    }
    
    @Override
    public final String toString() {
        synchronized (this) {
            final int n = this.g + this.h;
            int i = 0;
            if (n != 0) {
                i = 100 * this.g / n;
            }
            return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", this.c, this.g, this.h, i);
        }
    }
}
