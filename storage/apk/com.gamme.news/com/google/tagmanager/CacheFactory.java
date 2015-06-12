// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.os.Build$VERSION;
import com.google.android.gms.common.util.VisibleForTesting;

class CacheFactory<K, V>
{
    @VisibleForTesting
    final CacheSizeManager<K, V> mDefaultSizeManager;
    
    public CacheFactory() {
        this.mDefaultSizeManager = (CacheSizeManager<K, V>)new CacheSizeManager<K, V>() {
            @Override
            public int sizeOf(final K k, final V v) {
                return 1;
            }
        };
    }
    
    public Cache<K, V> createCache(final int n) {
        return this.createCache(n, this.mDefaultSizeManager);
    }
    
    public Cache<K, V> createCache(final int n, final CacheSizeManager<K, V> cacheSizeManager) {
        if (n <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (this.getSdkVersion() < 12) {
            return new SimpleCache<K, V>(n, cacheSizeManager);
        }
        return new LRUCache<K, V>(n, cacheSizeManager);
    }
    
    @VisibleForTesting
    int getSdkVersion() {
        return Build$VERSION.SDK_INT;
    }
    
    public interface CacheSizeManager<K, V>
    {
        int sizeOf(K p0, V p1);
    }
}
