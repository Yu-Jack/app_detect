// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.b.i;
import org.codehaus.jackson.c.z;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.c.b.c;

public class bx extends c
{
    public bx(final c c) {
        super(c);
    }
    
    protected bx(final c c, final boolean b) {
        super(c, b);
    }
    
    @Override
    public x<Object> a() {
        if (this.getClass() != bx.class) {
            return this;
        }
        return new bx(this, true);
    }
    
    @Override
    public Object b(final k k, final p p2) {
        Object o;
        if (this.f != null) {
            o = this.i(k, p2);
        }
        else {
            if (this.e != null) {
                return this.d.a(this.e.a(k, p2));
            }
            if (this.b.c()) {
                throw z.a(k, "Can not instantiate abstract type " + this.b + " (need to add/enable type information?)");
            }
            final boolean c = this.d.c();
            final boolean h = this.d.h();
            if (!c && !h) {
                throw new z("Can not deserialize Throwable of type " + this.b + " without having a default contructor, a single-String-arg constructor; or explicit @JsonCreator");
            }
            int n = 0;
            Object[] array = null;
            o = null;
            while (k.e() != org.codehaus.jackson.p.c) {
                final String g = k.g();
                final i a = this.h.a(g);
                k.b();
                int n2 = 0;
                Object[] array2 = null;
                Object o2 = null;
                Label_0217: {
                    if (a != null) {
                        if (o != null) {
                            a.a(k, p2, o);
                            n2 = n;
                            array2 = array;
                            o2 = o;
                        }
                        else {
                            if (array == null) {
                                final int b = this.h.b();
                                array = new Object[b + b];
                            }
                            final int n3 = n + 1;
                            array[n] = a;
                            n2 = n3 + 1;
                            array[n3] = a.a(k, p2);
                            array2 = array;
                            o2 = o;
                        }
                    }
                    else {
                        if ("message".equals(g) && c) {
                            o = this.d.a(k.k());
                            if (array != null) {
                                for (int i = 0; i < n; i += 2) {
                                    ((i)array[i]).a(o, array[i + 1]);
                                }
                                n2 = n;
                                o2 = o;
                                array2 = null;
                                break Label_0217;
                            }
                        }
                        else {
                            if (this.k != null && this.k.contains(g)) {
                                k.d();
                                n2 = n;
                                array2 = array;
                                o2 = o;
                                break Label_0217;
                            }
                            if (this.j != null) {
                                this.j.a(k, p2, o, g);
                                n2 = n;
                                array2 = array;
                                o2 = o;
                                break Label_0217;
                            }
                            this.a(k, p2, o, g);
                        }
                        n2 = n;
                        array2 = array;
                        o2 = o;
                    }
                }
                k.b();
                o = o2;
                array = array2;
                n = n2;
            }
            if (o == null) {
                if (c) {
                    o = this.d.a((String)null);
                }
                else {
                    o = this.d.m();
                }
                int j = 0;
                if (array != null) {
                    while (j < n) {
                        ((i)array[j]).a(o, array[j + 1]);
                        j += 2;
                    }
                }
            }
        }
        return o;
    }
}
