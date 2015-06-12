// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.i;

import java.util.Map;
import java.util.LinkedHashMap;

public class q<K, V> extends LinkedHashMap<K, V>
{
    protected final int a;
    
    public q(final int initialCapacity, final int a) {
        super(initialCapacity, 0.8f, true);
        this.a = a;
    }
    
    @Override
    protected boolean removeEldestEntry(final Map.Entry<K, V> entry) {
        return this.size() > this.a;
    }
}
