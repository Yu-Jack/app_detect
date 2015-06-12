// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import java.util.LinkedHashMap;
import org.codehaus.jackson.c.i.s;
import java.util.List;
import java.util.ArrayList;
import org.codehaus.jackson.c.az;
import org.codehaus.jackson.c.o;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.a.b;

@b
public class ca extends an<Object>
{
    private static final Object[] a;
    
    static {
        a = new Object[0];
    }
    
    public ca() {
        super(Object.class);
    }
    
    @Override
    public Object a(final k k, final p p2) {
        switch (ca$1.a[k.e().ordinal()]) {
            default: {
                throw p2.b(Object.class);
            }
            case 1: {
                return this.c(k, p2);
            }
            case 3: {
                return this.b(k, p2);
            }
            case 5: {
                return this.c(k, p2);
            }
            case 6: {
                return k.z();
            }
            case 7: {
                return k.k();
            }
            case 8: {
                if (p2.a(o.h)) {
                    return k.v();
                }
                return k.p();
            }
            case 9: {
                if (p2.a(o.g)) {
                    return k.y();
                }
                return k.x();
            }
            case 10: {
                return Boolean.TRUE;
            }
            case 11: {
                return Boolean.FALSE;
            }
            case 12: {
                return null;
            }
        }
    }
    
    @Override
    public Object a(final k k, final p p3, final az az) {
        switch (ca$1.a[k.e().ordinal()]) {
            default: {
                throw p3.b(Object.class);
            }
            case 1:
            case 3:
            case 5: {
                return az.d(k, p3);
            }
            case 7: {
                return k.k();
            }
            case 8: {
                if (p3.a(o.h)) {
                    return k.v();
                }
                return k.t();
            }
            case 9: {
                if (p3.a(o.g)) {
                    return k.y();
                }
                return k.x();
            }
            case 10: {
                return Boolean.TRUE;
            }
            case 11: {
                return Boolean.FALSE;
            }
            case 6: {
                return k.z();
            }
            case 12: {
                return null;
            }
        }
    }
    
    protected Object b(final k k, final p p2) {
        if (p2.a(o.i)) {
            return this.d(k, p2);
        }
        if (k.b() == org.codehaus.jackson.p.e) {
            return new ArrayList(4);
        }
        final s g = p2.g();
        final Object[] a = g.a();
        int n = 0;
        Object[] a2 = a;
        int n2 = 0;
        do {
            final Object a3 = this.a(k, p2);
            ++n2;
            int n3;
            if (n >= a2.length) {
                a2 = g.a(a2);
                n3 = 0;
            }
            else {
                n3 = n;
            }
            n = n3 + 1;
            a2[n3] = a3;
        } while (k.b() != org.codehaus.jackson.p.e);
        final ArrayList list = new ArrayList<Object>(1 + (n2 + (n2 >> 3)));
        g.a(a2, n, (List<Object>)list);
        return list;
    }
    
    protected Object c(final k k, final p p2) {
        org.codehaus.jackson.p p3 = k.e();
        if (p3 == org.codehaus.jackson.p.b) {
            p3 = k.b();
        }
        if (p3 != org.codehaus.jackson.p.f) {
            return new LinkedHashMap(4);
        }
        final String i = k.k();
        k.b();
        final Object a = this.a(k, p2);
        if (k.b() != org.codehaus.jackson.p.f) {
            final LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<String, Object>(4);
            linkedHashMap.put(i, a);
            return linkedHashMap;
        }
        final String j = k.k();
        k.b();
        final Object a2 = this.a(k, p2);
        if (k.b() != org.codehaus.jackson.p.f) {
            final LinkedHashMap<String, Object> linkedHashMap2 = new LinkedHashMap<String, Object>(4);
            linkedHashMap2.put(i, a);
            linkedHashMap2.put(j, a2);
            return linkedHashMap2;
        }
        final LinkedHashMap<String, Object> linkedHashMap3 = new LinkedHashMap<String, Object>();
        linkedHashMap3.put(i, a);
        linkedHashMap3.put(j, a2);
        do {
            final String l = k.k();
            k.b();
            linkedHashMap3.put(l, this.a(k, p2));
        } while (k.b() != org.codehaus.jackson.p.c);
        return linkedHashMap3;
    }
    
    protected Object[] d(final k k, final p p2) {
        if (k.b() == org.codehaus.jackson.p.e) {
            return ca.a;
        }
        final s g = p2.g();
        Object[] array = g.a();
        int n = 0;
        do {
            final Object a = this.a(k, p2);
            int n2;
            if (n >= array.length) {
                array = g.a(array);
                n2 = 0;
            }
            else {
                n2 = n;
            }
            n = n2 + 1;
            array[n2] = a;
        } while (k.b() != org.codehaus.jackson.p.e);
        return g.a(array, n);
    }
}
