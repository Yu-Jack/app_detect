// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.a;

import java.util.NoSuchElementException;
import org.codehaus.jackson.c.b.i;
import java.util.Iterator;

final class c implements Iterator<i>
{
    private final b[] a;
    private b b;
    private int c;
    
    public c(final b[] a) {
        this.a = a;
        while (true) {
            int i;
            int c;
            for (i = 0; i < this.a.length; i = c) {
                final b[] a2 = this.a;
                c = i + 1;
                final b b = a2[i];
                if (b != null) {
                    this.b = b;
                    this.c = c;
                    return;
                }
            }
            c = i;
            continue;
        }
    }
    
    public i a() {
        final b b = this.b;
        if (b == null) {
            throw new NoSuchElementException();
        }
        b a;
        for (a = b.a; a == null && this.c < this.a.length; a = this.a[this.c++]) {}
        this.b = a;
        return b.c;
    }
    
    @Override
    public boolean hasNext() {
        return this.b != null;
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
