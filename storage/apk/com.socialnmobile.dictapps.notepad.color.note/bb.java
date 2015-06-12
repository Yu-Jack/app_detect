import java.util.Iterator;

// 
// Decompiled by Procyon v0.5.29
// 

final class bb implements Iterator
{
    final int a;
    int b;
    int c;
    boolean d;
    final /* synthetic */ ba e;
    
    bb(final ba e, final int a) {
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
