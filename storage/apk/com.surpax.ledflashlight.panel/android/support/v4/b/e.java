// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.b;

import java.util.Map;
import java.util.LinkedHashMap;

public class e
{
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;
    
    public e(final int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = maxSize;
        this.map = new LinkedHashMap(0, 0.75f, true);
    }
    
    private int safeSizeOf(final Object obj, final Object obj2) {
        final int size = this.sizeOf(obj, obj2);
        if (size < 0) {
            throw new IllegalStateException("Negative size: " + obj + "=" + obj2);
        }
        return size;
    }
    
    protected Object create(final Object o) {
        return null;
    }
    
    public final int createCount() {
        synchronized (this) {
            return this.createCount;
        }
    }
    
    protected void entryRemoved(final boolean b, final Object o, final Object o2, final Object o3) {
    }
    
    public final void evictAll() {
        this.trimToSize(-1);
    }
    
    public final int evictionCount() {
        synchronized (this) {
            return this.evictionCount;
        }
    }
    
    public final Object get(final Object key) {
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        final Object create;
        synchronized (this) {
            final Object value = this.map.get(key);
            if (value != null) {
                ++this.hitCount;
                return value;
            }
            ++this.missCount;
            // monitorexit(this)
            create = this.create(key);
            if (create == null) {
                return null;
            }
        }
        synchronized (this) {
            ++this.createCount;
            final Object put = this.map.put(key, create);
            if (put != null) {
                this.map.put(key, put);
            }
            else {
                this.size += this.safeSizeOf(key, create);
            }
            // monitorexit(this)
            if (put != null) {
                this.entryRemoved(false, key, create, put);
                return put;
            }
        }
        this.trimToSize(this.maxSize);
        return create;
    }
    
    public final int hitCount() {
        synchronized (this) {
            return this.hitCount;
        }
    }
    
    public final int maxSize() {
        synchronized (this) {
            return this.maxSize;
        }
    }
    
    public final int missCount() {
        synchronized (this) {
            return this.missCount;
        }
    }
    
    public final Object put(final Object key, final Object value) {
        if (key == null || value == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            ++this.putCount;
            this.size += this.safeSizeOf(key, value);
            final Object put = this.map.put(key, value);
            if (put != null) {
                this.size -= this.safeSizeOf(key, put);
            }
            // monitorexit(this)
            if (put != null) {
                this.entryRemoved(false, key, put, value);
            }
            this.trimToSize(this.maxSize);
            return put;
        }
    }
    
    public final int putCount() {
        synchronized (this) {
            return this.putCount;
        }
    }
    
    public final Object remove(final Object key) {
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            final Object remove = this.map.remove(key);
            if (remove != null) {
                this.size -= this.safeSizeOf(key, remove);
            }
            // monitorexit(this)
            if (remove != null) {
                this.entryRemoved(false, key, remove, null);
            }
            return remove;
        }
    }
    
    public final int size() {
        synchronized (this) {
            return this.size;
        }
    }
    
    protected int sizeOf(final Object o, final Object o2) {
        return 1;
    }
    
    public final Map snapshot() {
        synchronized (this) {
            return new LinkedHashMap(this.map);
        }
    }
    
    @Override
    public final String toString() {
        synchronized (this) {
            final int n = this.hitCount + this.missCount;
            int i = 0;
            if (n != 0) {
                i = 100 * this.hitCount / n;
            }
            return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", this.maxSize, this.hitCount, this.missCount, i);
        }
    }
    
    public void trimToSize(final int n) {
        while (true) {
            synchronized (this) {
                if (this.size < 0 || (this.map.isEmpty() && this.size != 0)) {
                    throw new IllegalStateException(this.getClass().getName() + ".sizeOf() is reporting inconsistent results!");
                }
            }
            if (this.size <= n || this.map.isEmpty()) {
                break;
            }
            final Map.Entry entry = (Map.Entry)this.map.entrySet().iterator().next();
            final Object key = entry.getKey();
            final Object value = entry.getValue();
            this.map.remove(key);
            this.size -= this.safeSizeOf(key, value);
            ++this.evictionCount;
            // monitorexit(this)
            this.entryRemoved(true, key, value, null);
        }
    }
    // monitorexit(this)
}
