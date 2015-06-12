// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson;

import java.util.Iterator;
import java.util.Collections;
import java.util.List;

public abstract class i implements Iterable<i>
{
    protected static final List<i> a;
    protected static final List<String> b;
    
    static {
        a = Collections.emptyList();
        b = Collections.emptyList();
    }
    
    public abstract String a();
    
    public i a(final String s) {
        return null;
    }
    
    public int b() {
        return 0;
    }
    
    public Iterator<i> c() {
        return i.a.iterator();
    }
    
    @Override
    public abstract boolean equals(final Object p0);
    
    @Override
    public final Iterator<i> iterator() {
        return this.c();
    }
    
    @Override
    public abstract String toString();
}
