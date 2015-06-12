// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import java.util.Iterator;
import java.util.Map;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.ad;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.i.p;
import org.codehaus.jackson.c.a.b;
import org.codehaus.jackson.c.as;
import java.util.EnumMap;

@b
public class g extends e<EnumMap<? extends Enum<?>, ?>> implements as
{
    protected final boolean a;
    protected final p b;
    protected final a c;
    protected final f d;
    protected ad<Object> e;
    protected final ba f;
    
    public g(final a c, final boolean b, final p b2, final ba f, final f d, final ad<Object> e) {
        super(EnumMap.class, false);
        boolean a = false;
        Label_0035: {
            if (!b) {
                a = false;
                if (c == null) {
                    break Label_0035;
                }
                final boolean u = c.u();
                a = false;
                if (!u) {
                    break Label_0035;
                }
            }
            a = true;
        }
        this.a = a;
        this.c = c;
        this.b = b2;
        this.f = f;
        this.d = d;
        this.e = e;
    }
    
    @Override
    public e<?> a(final ba ba) {
        return new g(this.c, this.a, this.b, ba, this.d, this.e);
    }
    
    @Override
    public void a(final EnumMap<? extends Enum<?>, ?> enumMap, final org.codehaus.jackson.f f, final ax ax) {
        f.d();
        if (!enumMap.isEmpty()) {
            this.b(enumMap, f, ax);
        }
        f.e();
    }
    
    protected void a(final EnumMap<? extends Enum<?>, ?> enumMap, final org.codehaus.jackson.f f, final ax ax, final ad<Object> ad) {
        final p b = this.b;
        final Iterator<Map.Entry<? extends Enum<?>, ?>> iterator = enumMap.entrySet().iterator();
        p d = b;
        while (iterator.hasNext()) {
            final Map.Entry<? extends Enum<?>, ?> entry = iterator.next();
            final Enum<?> enum1 = (Enum<?>)entry.getKey();
            if (d == null) {
                d = ((h)(v)ax.a(enum1.getDeclaringClass(), this.d)).d();
            }
            f.a(d.a(enum1));
            final Object value = entry.getValue();
            if (value == null) {
                ax.a(f);
            }
            else {
                try {
                    ad.a(value, f, ax);
                }
                catch (Exception ex) {
                    this.a(ax, ex, enumMap, ((Enum<?>)entry.getKey()).name());
                }
            }
        }
    }
    
    @Override
    public void a(final EnumMap<? extends Enum<?>, ?> enumMap, final org.codehaus.jackson.f f, final ax ax, final ba ba) {
        ba.b(enumMap, f);
        if (!enumMap.isEmpty()) {
            this.b(enumMap, f, ax);
        }
        ba.e(enumMap, f);
    }
    
    @Override
    public void a(final ax ax) {
        if (this.a && this.e == null) {
            this.e = ax.a(this.c, this.d);
        }
    }
    
    protected void b(final EnumMap<? extends Enum<?>, ?> enumMap, final org.codehaus.jackson.f f, final ax ax) {
        Class<?> clazz = null;
        if (this.e != null) {
            this.a(enumMap, f, ax, this.e);
        }
        else {
            final p b = this.b;
            final Iterator<Map.Entry<? extends Enum<?>, ?>> iterator = enumMap.entrySet().iterator();
            p p3 = b;
            ad<Object> ad = null;
        Label_0109_Outer:
            while (iterator.hasNext()) {
                final Map.Entry<? extends Enum<?>, ?> entry = iterator.next();
                final Enum enum1 = (Enum)entry.getKey();
                while (true) {
                    Label_0257: {
                        if (p3 != null) {
                            break Label_0257;
                        }
                        final p d = ((h)(v)ax.a(enum1.getDeclaringClass(), this.d)).d();
                        f.a(d.a(enum1));
                        final Object value = entry.getValue();
                        Class<?> clazz2 = null;
                        ad<Object> ad2 = null;
                        Label_0147: {
                            if (value != null) {
                                Class<?> class1 = value.getClass();
                                Label_0204: {
                                    if (class1 != clazz) {
                                        break Label_0204;
                                    }
                                    class1 = clazz;
                                    ad<Object> a = ad;
                                    try {
                                        while (true) {
                                            ad.a(value, f, ax);
                                            clazz2 = class1;
                                            ad2 = a;
                                            break Label_0147;
                                            ad = (a = ax.a(class1, this.d));
                                            continue;
                                        }
                                    }
                                    catch (Exception ex) {
                                        this.a(ax, ex, enumMap, ((Enum)entry.getKey()).name());
                                        clazz2 = class1;
                                        ad2 = a;
                                        break Label_0147;
                                    }
                                }
                                break Label_0257;
                            }
                            ax.a(f);
                            clazz2 = clazz;
                            ad2 = ad;
                        }
                        p3 = d;
                        clazz = clazz2;
                        ad = ad2;
                        continue Label_0109_Outer;
                    }
                    final p d = p3;
                    continue;
                }
            }
        }
    }
}
