// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import java.util.Iterator;
import org.codehaus.jackson.c.au;
import org.codehaus.jackson.c.g.a.h;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.c.h.k;
import org.codehaus.jackson.c.g.a.d;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.ad;
import java.util.HashSet;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.a.b;
import org.codehaus.jackson.c.as;
import java.util.Map;

@b
public class n extends e<Map<?, ?>> implements as
{
    protected static final a a;
    protected final f b;
    protected final HashSet<String> c;
    protected final boolean d;
    protected final a e;
    protected final a f;
    protected ad<Object> g;
    protected ad<Object> h;
    protected final ba i;
    protected d j;
    
    static {
        a = k.b();
    }
    
    protected n() {
        this(null, null, null, false, null, null, null, null);
    }
    
    protected n(final HashSet<String> c, final a e, final a f, final boolean d, final ba i, final ad<Object> g, final ad<Object> h, final f b) {
        super(Map.class, false);
        this.b = b;
        this.c = c;
        this.e = e;
        this.f = f;
        this.d = d;
        this.i = i;
        this.g = g;
        this.h = h;
        this.j = org.codehaus.jackson.c.g.a.d.a();
    }
    
    private static HashSet<String> a(final String[] array) {
        HashSet<String> set;
        if (array == null || array.length == 0) {
            set = null;
        }
        else {
            set = new HashSet<String>(array.length);
            for (int length = array.length, i = 0; i < length; ++i) {
                set.add(array[i]);
            }
        }
        return set;
    }
    
    public static n a(final String[] array, final a a, final boolean b, final ba ba, final f f, final ad<Object> ad, final ad<Object> ad2) {
        final HashSet<String> a2 = a(array);
        a a3;
        a g;
        if (a == null) {
            g = (a3 = n.a);
        }
        else {
            a3 = a.k();
            g = a.g();
        }
        boolean b2;
        if (!b) {
            b2 = (g != null && g.u());
        }
        else {
            b2 = b;
        }
        return new n(a2, a3, g, b2, ba, ad, ad2, f);
    }
    
    protected final ad<Object> a(final d d, final Class<?> clazz, final ax ax) {
        final h a = d.a(clazz, ax, this.b);
        if (d != a.b) {
            this.j = a.b;
        }
        return a.a;
    }
    
    protected final ad<Object> a(final d d, final a a, final ax ax) {
        final h a2 = d.a(a, ax, this.b);
        if (d != a2.b) {
            this.j = a2.b;
        }
        return a2.a;
    }
    
    @Override
    public e<?> a(final ba ba) {
        final n n = new n(this.c, this.e, this.f, this.d, ba, this.g, this.h, this.b);
        if (this.h != null) {
            n.h = this.h;
        }
        return n;
    }
    
    @Override
    public void a(final Map<?, ?> map, final org.codehaus.jackson.f f, final ax ax) {
        f.d();
        if (!map.isEmpty()) {
            if (this.h != null) {
                this.a(map, f, ax, this.h);
            }
            else {
                this.b(map, f, ax);
            }
        }
        f.e();
    }
    
    protected void a(final Map<?, ?> map, final org.codehaus.jackson.f f, final ax ax, final ad<Object> ad) {
        final ad<Object> g = this.g;
        final HashSet<String> c = this.c;
        final ba i = this.i;
        final boolean b = !ax.a(au.v);
        for (final Map.Entry<K, Object> entry : map.entrySet()) {
            final Object value = entry.getValue();
            final K key = entry.getKey();
            if (key == null) {
                ax.c().a(null, f, ax);
            }
            else {
                if ((b && value == null) || (c != null && c.contains(key))) {
                    continue;
                }
                g.a(key, f, ax);
            }
            if (value == null) {
                ax.a(f);
            }
            else if (i == null) {
                try {
                    ad.a(value, f, ax);
                }
                catch (Exception ex) {
                    this.a(ax, ex, map, "" + key);
                }
            }
            else {
                ad.a(value, f, ax, i);
            }
        }
    }
    
    @Override
    public void a(final Map<?, ?> map, final org.codehaus.jackson.f f, final ax ax, final ba ba) {
        ba.b(map, f);
        if (!map.isEmpty()) {
            if (this.h != null) {
                this.a(map, f, ax, this.h);
            }
            else {
                this.b(map, f, ax);
            }
        }
        ba.e(map, f);
    }
    
    @Override
    public void a(final ax ax) {
        if (this.d && this.h == null) {
            this.h = ax.a(this.f, this.b);
        }
        if (this.g == null) {
            this.g = ax.b(this.e, this.b);
        }
    }
    
    public void b(final Map<?, ?> map, final org.codehaus.jackson.f f, final ax ax) {
        if (this.i != null) {
            this.c(map, f, ax);
        }
        else {
            final ad<Object> g = this.g;
            final HashSet<String> c = this.c;
            final boolean b = !ax.a(au.v);
            final d j = this.j;
            final Iterator<Map.Entry<?, Object>> iterator = (Iterator<Map.Entry<?, Object>>)map.entrySet().iterator();
            d d = j;
            while (iterator.hasNext()) {
                final Map.Entry<K, Object> entry = iterator.next();
                final Object value = entry.getValue();
                final K key = entry.getKey();
                if (key == null) {
                    ax.c().a(null, f, ax);
                }
                else {
                    if ((b && value == null) || (c != null && c.contains(key))) {
                        continue;
                    }
                    g.a(key, f, ax);
                }
                d d2;
                if (value == null) {
                    ax.a(f);
                    d2 = d;
                }
                else {
                    final Class<?> class1 = value.getClass();
                    final ad<Object> a = d.a(class1);
                    ad<Object> ad3;
                    if (a == null) {
                        ad<Object> ad;
                        if (this.f.e()) {
                            ad = this.a(d, ax.a(this.f, class1), ax);
                        }
                        else {
                            ad = this.a(d, class1, ax);
                        }
                        final d i = this.j;
                        final ad<Object> ad2 = ad;
                        d2 = i;
                        ad3 = ad2;
                    }
                    else {
                        d2 = d;
                        ad3 = a;
                    }
                    try {
                        ad3.a(value, f, ax);
                    }
                    catch (Exception ex) {
                        this.a(ax, ex, map, "" + key);
                    }
                }
                d = d2;
            }
        }
    }
    
    protected void c(final Map<?, ?> map, final org.codehaus.jackson.f f, final ax ax) {
        final ad<Object> g = this.g;
        final HashSet<String> c = this.c;
        final boolean b = !ax.a(au.v);
        final Iterator<Map.Entry<?, Object>> iterator = (Iterator<Map.Entry<?, Object>>)map.entrySet().iterator();
        Class<?> clazz = null;
        ad<Object> ad = null;
        while (iterator.hasNext()) {
            final Map.Entry<K, Object> entry = iterator.next();
            final Object value = entry.getValue();
            final K key = entry.getKey();
            if (key == null) {
                ax.c().a(null, f, ax);
            }
            else {
                if ((b && value == null) || (c != null && c.contains(key))) {
                    continue;
                }
                g.a(key, f, ax);
            }
            Class<?> class1;
            ad<Object> a;
            if (value == null) {
                ax.a(f);
                class1 = clazz;
                a = ad;
            }
            else {
                class1 = value.getClass();
                if (class1 == clazz) {
                    class1 = clazz;
                    a = ad;
                }
                else {
                    ad = (a = ax.a(class1, this.b));
                }
                try {
                    ad.a(value, f, ax, this.i);
                }
                catch (Exception ex) {
                    this.a(ax, ex, map, "" + key);
                }
            }
            ad = a;
            clazz = class1;
        }
    }
}
