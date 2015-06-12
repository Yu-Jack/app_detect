// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.b;

import java.util.Iterator;
import java.util.Collection;

final class k implements Collection
{
    final /* synthetic */ f a;
    
    k(final f a) {
        this.a = a;
    }
    
    @Override
    public final boolean add(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public final boolean addAll(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public final void clear() {
        this.a.c();
    }
    
    @Override
    public final boolean contains(final Object o) {
        return this.a.b(o) >= 0;
    }
    
    @Override
    public final boolean containsAll(final Collection collection) {
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!this.contains(iterator.next())) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final boolean isEmpty() {
        return this.a.a() == 0;
    }
    
    @Override
    public final Iterator iterator() {
        return new g(this.a, 1);
    }
    
    @Override
    public final boolean remove(final Object o) {
        final int b = this.a.b(o);
        if (b >= 0) {
            this.a.a(b);
            return true;
        }
        return false;
    }
    
    @Override
    public final boolean removeAll(final Collection collection) {
        int i = 0;
        int a = this.a.a();
        boolean b = false;
        while (i < a) {
            if (collection.contains(this.a.a(i, 1))) {
                this.a.a(i);
                --i;
                --a;
                b = true;
            }
            ++i;
        }
        return b;
    }
    
    @Override
    public final boolean retainAll(final Collection collection) {
        int i = 0;
        int a = this.a.a();
        boolean b = false;
        while (i < a) {
            if (!collection.contains(this.a.a(i, 1))) {
                this.a.a(i);
                --i;
                --a;
                b = true;
            }
            ++i;
        }
        return b;
    }
    
    @Override
    public final int size() {
        return this.a.a();
    }
    
    @Override
    public final Object[] toArray() {
        return this.a.b(1);
    }
    
    @Override
    public final Object[] toArray(final Object[] array) {
        return this.a.a(array, 1);
    }
}
