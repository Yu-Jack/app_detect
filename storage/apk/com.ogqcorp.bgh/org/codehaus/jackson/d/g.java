// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.d;

import java.util.NoSuchElementException;
import org.codehaus.jackson.i;
import java.util.Iterator;

public class g implements Iterator<i>
{
    static final g a;
    
    static {
        a = new g();
    }
    
    public static g a() {
        return g.a;
    }
    
    public i b() {
        throw new NoSuchElementException();
    }
    
    @Override
    public boolean hasNext() {
        return false;
    }
    
    @Override
    public void remove() {
        throw new IllegalStateException();
    }
}
