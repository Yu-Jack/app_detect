// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.a;

import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.g.m;
import java.util.HashMap;

public class f
{
    private final h[] a;
    private final HashMap<String, Integer> b;
    private final String[] c;
    private final m[] d;
    
    protected f(final f f) {
        this.a = f.a;
        this.b = f.b;
        final int length = this.a.length;
        this.c = new String[length];
        this.d = new m[length];
    }
    
    protected f(final h[] a, final HashMap<String, Integer> b, final String[] c, final m[] d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public Object a(final k k, final p p3, final Object o) {
        for (int i = 0; i < this.a.length; ++i) {
            if (this.c[i] == null) {
                if (this.d[i] != null) {
                    throw p3.b("Missing external type id property '" + this.a[i].a() + "'");
                }
            }
            else {
                if (this.d[i] == null) {
                    throw p3.b("Missing property '" + this.a[i].b().c() + "' for external type id '" + this.a[i].a());
                }
                this.a(k, p3, o, i);
            }
        }
        return o;
    }
    
    public f a() {
        return new f(this);
    }
    
    protected final void a(final k k, final p p4, final Object o, final int n) {
        final m m = new m(k.a());
        m.b();
        m.b(this.c[n]);
        final k a = this.d[n].a(k);
        a.b();
        m.c(a);
        m.c();
        final k a2 = m.a(k);
        a2.b();
        this.a[n].b().a(a2, p4, o);
    }
    
    public boolean a(final k k, final p p4, final String key, final Object o) {
        final Integer n = this.b.get(key);
        if (n == null) {
            return false;
        }
        final int intValue = n;
        if (!this.a[intValue].a(key)) {
            return false;
        }
        this.c[intValue] = k.k();
        boolean b = false;
        if (o != null) {
            final m m = this.d[intValue];
            b = false;
            if (m != null) {
                b = true;
            }
        }
        if (b) {
            this.a(k, p4, o, intValue);
            this.c[intValue] = null;
            this.d[intValue] = null;
        }
        return true;
    }
    
    public boolean b(final k k, final p p4, final String key, final Object o) {
        final Integer n = this.b.get(key);
        if (n == null) {
            return false;
        }
        final int intValue = n;
        int n2;
        if (this.a[intValue].a(key)) {
            this.c[intValue] = k.k();
            k.d();
            if (o != null && this.d[intValue] != null) {
                n2 = 1;
            }
            else {
                n2 = 0;
            }
        }
        else {
            final m m = new m(k.a());
            m.c(k);
            this.d[intValue] = m;
            int n3 = 0;
            if (o != null) {
                final String s = this.c[intValue];
                n3 = 0;
                if (s != null) {
                    n3 = 1;
                }
            }
            n2 = n3;
        }
        if (n2 != 0) {
            this.a(k, p4, o, intValue);
            this.c[intValue] = null;
            this.d[intValue] = null;
        }
        return true;
    }
}
