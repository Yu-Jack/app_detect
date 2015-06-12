// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.util.LruCache;
import android.annotation.TargetApi;

@TargetApi(12)
class LRUCache<K, V> implements Cache<K, V>
{
    private LruCache<K, V> lruCache;
    
    LRUCache(final int n, final CacheFactory.CacheSizeManager<K, V> cacheSizeManager) {
        this.lruCache = new LruCache<K, V>(n) {
            protected int sizeOf(final K k, final V v) {
                return cacheSizeManager.sizeOf(k, v);
            }
        };
    }
    
    @Override
    public V get(final K k) {
        return (V)this.lruCache.get((Object)k);
    }
    
    @Override
    public void put(final K k, final V v) {
        this.lruCache.put((Object)k, (Object)v);
    }
}
