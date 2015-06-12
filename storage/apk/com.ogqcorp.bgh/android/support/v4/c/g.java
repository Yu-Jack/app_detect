// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.c;

import java.util.Iterator;

final class g<T> implements Iterator<T>
{
    final int a;
    int b;
    int c;
    boolean d;
    final /* synthetic */ f e;
    
    g(final f e, final int a) {
        this.e = e;
        this.d = false;
        this.a = a;
        this.b = e.a();
    }
    
    @Override
    public boolean hasNext() {
        return this.c < this.b;
    }
    
    @Override
    public T next() {
        final Object a = this.e.a(this.c, this.a);
        ++this.c;
        this.d = true;
        return (T)a;
    }
    
    @Override
    public void remove() {
        if (!this.d) {
            throw new IllegalStateException();
        }
        --this.c;
        --this.b;
        this.d = false;
        this.e.a(this.c);
    }
}
