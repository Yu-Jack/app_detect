import java.util.Iterator;
import java.util.Map;
import java.util.Collection;
import java.util.Set;

// 
// Decompiled by Procyon v0.5.29
// 

final class bd implements Set
{
    final /* synthetic */ ba a;
    
    bd(final ba a) {
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
        return this.a.a(o) >= 0;
    }
    
    @Override
    public final boolean containsAll(final Collection collection) {
        final Map b = this.a.b();
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!b.containsKey(iterator.next())) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final boolean equals(final Object o) {
        return ba.a(this, o);
    }
    
    @Override
    public final int hashCode() {
        int i = -1 + this.a.a();
        int n = 0;
        while (i >= 0) {
            final Object a = this.a.a(i, 0);
            int hashCode;
            if (a == null) {
                hashCode = 0;
            }
            else {
                hashCode = a.hashCode();
            }
            n += hashCode;
            --i;
        }
        return n;
    }
    
    @Override
    public final boolean isEmpty() {
        return this.a.a() == 0;
    }
    
    @Override
    public final Iterator iterator() {
        return new bb(this.a, 0);
    }
    
    @Override
    public final boolean remove(final Object o) {
        final int a = this.a.a(o);
        if (a >= 0) {
            this.a.a(a);
            return true;
        }
        return false;
    }
    
    @Override
    public final boolean removeAll(final Collection collection) {
        final Map b = this.a.b();
        final int size = b.size();
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            b.remove(iterator.next());
        }
        return size != b.size();
    }
    
    @Override
    public final boolean retainAll(final Collection collection) {
        final Map b = this.a.b();
        final int size = b.size();
        final Iterator<Object> iterator = b.keySet().iterator();
        while (iterator.hasNext()) {
            if (!collection.contains(iterator.next())) {
                iterator.remove();
            }
        }
        return size != b.size();
    }
    
    @Override
    public final int size() {
        return this.a.a();
    }
    
    @Override
    public final Object[] toArray() {
        return this.a.b(0);
    }
    
    @Override
    public final Object[] toArray(final Object[] array) {
        return this.a.a(array, 0);
    }
}
