import java.util.Iterator;
import java.util.Map;
import java.util.Collection;
import java.util.Set;

// 
// Decompiled by Procyon v0.5.29
// 

final class bc implements Set
{
    final /* synthetic */ ba a;
    
    bc(final ba a) {
        this.a = a;
    }
    
    @Override
    public final boolean addAll(final Collection collection) {
        final int a = this.a.a();
        for (final Map.Entry<Object, V> entry : collection) {
            this.a.a(entry.getKey(), entry.getValue());
        }
        return a != this.a.a();
    }
    
    @Override
    public final void clear() {
        this.a.c();
    }
    
    @Override
    public final boolean contains(final Object o) {
        if (o instanceof Map.Entry) {
            final Map.Entry entry = (Map.Entry)o;
            final int a = this.a.a(entry.getKey());
            if (a >= 0) {
                return ax.a(this.a.a(a, 1), entry.getValue());
            }
        }
        return false;
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
    public final boolean equals(final Object o) {
        return ba.a(this, o);
    }
    
    @Override
    public final int hashCode() {
        int i = -1 + this.a.a();
        int n = 0;
        while (i >= 0) {
            final Object a = this.a.a(i, 0);
            final Object a2 = this.a.a(i, 1);
            int hashCode;
            if (a == null) {
                hashCode = 0;
            }
            else {
                hashCode = a.hashCode();
            }
            int hashCode2;
            if (a2 == null) {
                hashCode2 = 0;
            }
            else {
                hashCode2 = a2.hashCode();
            }
            final int n2 = n + (hashCode2 ^ hashCode);
            --i;
            n = n2;
        }
        return n;
    }
    
    @Override
    public final boolean isEmpty() {
        return this.a.a() == 0;
    }
    
    @Override
    public final Iterator iterator() {
        return new be(this.a);
    }
    
    @Override
    public final boolean remove(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public final boolean removeAll(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public final boolean retainAll(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public final int size() {
        return this.a.a();
    }
    
    @Override
    public final Object[] toArray() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public final Object[] toArray(final Object[] array) {
        throw new UnsupportedOperationException();
    }
}
