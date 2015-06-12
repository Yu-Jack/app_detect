// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.i;

import java.util.NoSuchElementException;
import java.util.Iterator;

final class c<T> implements Iterable<T>, Iterator<T>
{
    private final T[] a;
    private int b;
    
    public c(final T[] a) {
        this.a = a;
        this.b = 0;
    }
    
    @Override
    public boolean hasNext() {
        return this.b < this.a.length;
    }
    
    @Override
    public Iterator<T> iterator() {
        return this;
    }
    
    @Override
    public T next() {
        if (this.b >= this.a.length) {
            throw new NoSuchElementException();
        }
        return (T)this.a[this.b++];
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
