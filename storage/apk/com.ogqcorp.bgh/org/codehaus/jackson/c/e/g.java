// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.e;

import java.util.Collections;
import java.util.Iterator;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

public final class g implements Iterable<f>
{
    protected LinkedHashMap<r, f> a;
    
    public f a(final String s, final Class<?>[] array) {
        if (this.a == null) {
            return null;
        }
        return this.a.get(new r(s, array));
    }
    
    public f a(final Method method) {
        if (this.a != null) {
            return this.a.remove(new r(method));
        }
        return null;
    }
    
    public void a(final f value) {
        if (this.a == null) {
            this.a = new LinkedHashMap<r, f>();
        }
        this.a.put(new r(value.e()), value);
    }
    
    public boolean a() {
        return this.a == null || this.a.size() == 0;
    }
    
    public f b(final Method method) {
        if (this.a == null) {
            return null;
        }
        return this.a.get(new r(method));
    }
    
    @Override
    public Iterator<f> iterator() {
        if (this.a != null) {
            return this.a.values().iterator();
        }
        return Collections.emptyList().iterator();
    }
}
