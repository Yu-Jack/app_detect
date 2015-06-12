// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.g;

import java.util.Map;
import java.util.LinkedHashMap;

public final class i extends LinkedHashMap<String, String>
{
    public static final i a;
    
    static {
        a = new i();
    }
    
    private i() {
        super(192, 0.8f, true);
    }
    
    public String a(final String key) {
        synchronized (this) {
            String intern = ((LinkedHashMap<K, String>)this).get(key);
            if (intern == null) {
                intern = key.intern();
                this.put(intern, intern);
            }
            return intern;
        }
    }
    
    @Override
    protected boolean removeEldestEntry(final Map.Entry<String, String> entry) {
        return this.size() > 192;
    }
}
