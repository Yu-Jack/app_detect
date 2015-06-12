// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.b;

import java.util.Iterator;

final class g implements Iterator
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
    public final boolean hasNext() {
        return this.c < this.b;
    }
    
    @Override
    public final Object next() {
        final Object a = this.e.a(this.c, this.a);
        ++this.c;
        this.d = true;
        return a;
    }
    
    @Override
    public final void remove() {
        if (!this.d) {
            throw new IllegalStateException();
        }
        --this.c;
        --this.b;
        this.d = false;
        this.e.a(this.c);
    }
}
