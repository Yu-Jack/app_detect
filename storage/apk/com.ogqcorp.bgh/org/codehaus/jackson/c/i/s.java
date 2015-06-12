// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.i;

import java.lang.reflect.Array;
import java.util.List;

public final class s
{
    private t a;
    private t b;
    private int c;
    private Object[] d;
    
    protected final void a(final Object o, final int i, final Object[] array, final int n) {
        t t = this.a;
        int n2 = 0;
        while (t != null) {
            final Object[] a = t.a();
            final int length = a.length;
            System.arraycopy(a, 0, o, n2, length);
            n2 += length;
            t = t.b();
        }
        System.arraycopy(array, 0, o, n2, n);
        final int j = n2 + n;
        if (j != i) {
            throw new IllegalStateException("Should have gotten " + i + " entries, got " + j);
        }
    }
    
    public void a(final Object[] array, final int n, final List<Object> list) {
        t t = this.a;
        int i;
        while (true) {
            i = 0;
            if (t == null) {
                break;
            }
            final Object[] a = t.a();
            for (int length = a.length, j = 0; j < length; ++j) {
                list.add(a[j]);
            }
            t = t.b();
        }
        while (i < n) {
            list.add(array[i]);
            ++i;
        }
    }
    
    public Object[] a() {
        this.c();
        if (this.d == null) {
            return new Object[12];
        }
        return this.d;
    }
    
    public Object[] a(final Object[] array) {
        final t b = new t(array);
        if (this.a == null) {
            this.b = b;
            this.a = b;
        }
        else {
            this.b.a(b);
            this.b = b;
        }
        final int length = array.length;
        this.c += length;
        int n;
        if (length < 16384) {
            n = length + length;
        }
        else {
            n = length + (length >> 2);
        }
        return new Object[n];
    }
    
    public Object[] a(final Object[] array, final int n) {
        final int n2 = n + this.c;
        final Object[] array2 = new Object[n2];
        this.a(array2, n2, array, n);
        return array2;
    }
    
    public <T> T[] a(final Object[] array, final int n, final Class<T> componentType) {
        final int length = n + this.c;
        final Object[] array2 = (Object[])Array.newInstance(componentType, length);
        this.a(array2, length, array, n);
        this.c();
        return (T[])array2;
    }
    
    public int b() {
        if (this.d == null) {
            return 0;
        }
        return this.d.length;
    }
    
    protected void c() {
        if (this.b != null) {
            this.d = this.b.a();
        }
        this.b = null;
        this.a = null;
        this.c = 0;
    }
}
