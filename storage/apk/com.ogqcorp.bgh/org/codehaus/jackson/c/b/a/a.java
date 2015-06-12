// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.a;

import java.util.NoSuchElementException;
import java.util.Iterator;
import org.codehaus.jackson.c.b.i;
import java.util.Collection;

public final class a
{
    private final b[] a;
    private final int b;
    private final int c;
    
    public a(final Collection<i> collection) {
        this.c = collection.size();
        final int a = a(this.c);
        this.b = a - 1;
        final b[] a2 = new b[a];
        for (final i i : collection) {
            final String c = i.c();
            final int n = c.hashCode() & this.b;
            a2[n] = new b(a2[n], c, i);
        }
        this.a = a2;
    }
    
    private static final int a(final int n) {
        int n2;
        if (n <= 32) {
            n2 = n + n;
        }
        else {
            n2 = n + (n >> 2);
        }
        int i;
        for (i = 2; i < n2; i += i) {}
        return i;
    }
    
    private i a(final String s, final int n) {
        for (b a = this.a[n]; a != null; a = a.a) {
            if (s.equals(a.b)) {
                return a.c;
            }
        }
        return null;
    }
    
    public i a(final String s) {
        final int n = s.hashCode() & this.b;
        b a = this.a[n];
        if (a == null) {
            return null;
        }
        if (a.b == s) {
            return a.c;
        }
        do {
            a = a.a;
            if (a != null) {
                continue;
            }
            return this.a(s, n);
        } while (a.b != s);
        return a.c;
    }
    
    public void a() {
        final b[] a = this.a;
        final int length = a.length;
        int i = 0;
        int n = 0;
        while (i < length) {
            int n2;
            for (b a2 = a[i]; a2 != null; a2 = a2.a, n = n2) {
                final i c = a2.c;
                n2 = n + 1;
                c.a(n);
            }
            ++i;
        }
    }
    
    public void a(final i obj) {
        final String c = obj.c();
        final int n = c.hashCode() & -1 + this.a.length;
        b a = this.a[n];
        int n2 = 0;
        b b = null;
        while (a != null) {
            if (n2 == 0 && a.b.equals(c)) {
                n2 = 1;
            }
            else {
                b = new b(b, a.b, a.c);
            }
            a = a.a;
        }
        if (n2 == 0) {
            throw new NoSuchElementException("No entry '" + obj + "' found, can't replace");
        }
        this.a[n] = new b(b, c, obj);
    }
    
    public int b() {
        return this.c;
    }
    
    public void b(final i obj) {
        final String c = obj.c();
        final int n = c.hashCode() & -1 + this.a.length;
        b a = this.a[n];
        int n2 = 0;
        b b = null;
        while (a != null) {
            if (n2 == 0 && a.b.equals(c)) {
                n2 = 1;
            }
            else {
                b = new b(b, a.b, a.c);
            }
            a = a.a;
        }
        if (n2 == 0) {
            throw new NoSuchElementException("No entry '" + obj + "' found, can't remove");
        }
        this.a[n] = b;
    }
    
    public Iterator<i> c() {
        return new c(this.a);
    }
}
