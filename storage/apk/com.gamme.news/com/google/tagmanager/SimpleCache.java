// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

class SimpleCache<K, V> implements Cache<K, V>
{
    private final Map<K, V> mHashMap;
    private final int mMaxSize;
    private final CacheFactory.CacheSizeManager<K, V> mSizeManager;
    private int mTotalSize;
    
    SimpleCache(final int mMaxSize, final CacheFactory.CacheSizeManager<K, V> mSizeManager) {
        this.mHashMap = new HashMap<K, V>();
        this.mMaxSize = mMaxSize;
        this.mSizeManager = mSizeManager;
    }
    
    @Override
    public V get(final K k) {
        synchronized (this) {
            return this.mHashMap.get(k);
        }
    }
    
    @Override
    public void put(final K k, final V v) {
        // monitorenter(this)
        Label_0025: {
            if (k != null) {
                if (v != null) {
                    break Label_0025;
                }
            }
            try {
                throw new NullPointerException("key == null || value == null");
            }
            finally {
            }
            // monitorexit(this)
        }
        this.mTotalSize += this.mSizeManager.sizeOf(k, v);
        if (this.mTotalSize > this.mMaxSize) {
            final Iterator<Map.Entry<K, V>> iterator = this.mHashMap.entrySet().iterator();
            while (iterator.hasNext()) {
                final Map.Entry<K, V> entry = iterator.next();
                this.mTotalSize -= this.mSizeManager.sizeOf(entry.getKey(), entry.getValue());
                iterator.remove();
                if (this.mTotalSize <= this.mMaxSize) {
                    break;
                }
            }
        }
        this.mHashMap.put(k, v);
    }
    // monitorexit(this)
}
