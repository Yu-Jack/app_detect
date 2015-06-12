// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public final class a<E> extends ArrayList<E> implements Set<E>
{
    private Set<E> a;
    
    public a() {
        this.a = new HashSet<E>();
    }
    
    @Override
    public void add(final int index, final E element) {
        this.a.add(element);
        super.add(index, element);
    }
    
    @Override
    public boolean add(final E e) {
        this.a.add(e);
        return super.add(e);
    }
    
    @Override
    public boolean addAll(final int index, final Collection<? extends E> c) {
        this.a.addAll(c);
        return super.addAll(index, c);
    }
    
    @Override
    public boolean addAll(final Collection<? extends E> c) {
        this.a.addAll(c);
        return super.addAll(c);
    }
    
    @Override
    public void clear() {
        this.a.clear();
        super.clear();
    }
    
    @Override
    public boolean contains(final Object o) {
        return this.a.contains(o);
    }
    
    @Override
    public boolean containsAll(final Collection<?> collection) {
        return this.a.containsAll(collection);
    }
    
    @Override
    public E remove(final int index) {
        final E remove = super.remove(index);
        this.a.remove(remove);
        return remove;
    }
    
    @Override
    public boolean remove(final Object o) {
        this.a.remove(o);
        return super.remove(o);
    }
    
    @Override
    public boolean removeAll(final Collection<?> c) {
        this.a.removeAll(c);
        return super.removeAll(c);
    }
    
    @Override
    public boolean retainAll(final Collection<?> c) {
        this.a.retainAll(c);
        return super.retainAll(c);
    }
    
    @Override
    public E set(final int index, final E element) {
        final E set = super.set(index, element);
        while (true) {
            if (!this.a.remove(set)) {
                this.a.add(element);
                return set;
            }
            continue;
        }
    }
}
