// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.z;
import java.lang.reflect.InvocationTargetException;
import java.io.IOException;
import org.codehaus.jackson.c.g.a.h;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.g.a.d;
import org.codehaus.jackson.c.ad;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.a.b;
import org.codehaus.jackson.c.as;

@b
public class q extends y<Object[]> implements as
{
    protected final boolean a;
    protected final a b;
    protected ad<Object> c;
    protected d d;
    
    public q(final a b, final boolean a, final ba ba, final f f, final ad<Object> c) {
        super(Object[].class, ba, f);
        this.b = b;
        this.a = a;
        this.d = org.codehaus.jackson.c.g.a.d.a();
        this.c = c;
    }
    
    protected final ad<Object> a(final d d, final Class<?> clazz, final ax ax) {
        final h a = d.a(clazz, ax, this.f);
        if (d != a.b) {
            this.d = a.b;
        }
        return a.a;
    }
    
    protected final ad<Object> a(final d d, final a a, final ax ax) {
        final h a2 = d.a(a, ax, this.f);
        if (d != a2.b) {
            this.d = a2.b;
        }
        return a2.a;
    }
    
    @Override
    public e<?> a(final ba ba) {
        return new q(this.b, this.a, ba, this.f, this.c);
    }
    
    @Override
    public void a(final ax ax) {
        if (this.a && this.c == null) {
            this.c = ax.a(this.b, this.f);
        }
    }
    
    @Override
    public void a(final Object[] array, final org.codehaus.jackson.f f, final ax ax) {
        final int length = array.length;
        if (length != 0) {
            if (this.c != null) {
                this.a(array, f, ax, this.c);
                return;
            }
            if (this.e != null) {
                this.b(array, f, ax);
                return;
            }
            while (true) {
                int n = 0;
                Object o = null;
                while (true) {
                    try {
                        final d d = this.d;
                        if (n >= length) {
                            break;
                        }
                        o = array[n];
                        if (o == null) {
                            ax.a(f);
                        }
                        else {
                            final Class<?> class1 = o.getClass();
                            ad<Object> ad = d.a(class1);
                            if (ad == null) {
                                if (!this.b.e()) {
                                    goto Label_0149;
                                }
                                ad = this.a(d, ax.a(this.b, class1), ax);
                            }
                            ad.a(o, f, ax);
                        }
                    }
                    catch (IOException ex) {
                        throw ex;
                    }
                    catch (Exception t) {
                        goto Label_0167;
                    }
                    ++n;
                    continue;
                }
            }
        }
    }
    
    public void a(final Object[] array, final org.codehaus.jackson.f f, final ax ax, final ad<Object> ad) {
        final int length = array.length;
        final ba e = this.e;
        Object o = null;
        for (int i = 0; i < length; ++i) {
            try {
                o = array[i];
                if (o == null) {
                    ax.a(f);
                    continue;
                }
                if (e == null) {
                    ad.a(o, f, ax);
                    continue;
                }
                goto Label_0064;
            }
            catch (IOException ex) {
                throw ex;
            }
            catch (Exception cause) {
                while (cause instanceof InvocationTargetException && cause.getCause() != null) {
                    cause = cause.getCause();
                }
                if (cause instanceof Error) {
                    throw (Error)cause;
                }
                throw z.a(cause, o, i);
            }
            break;
        }
    }
    
    public void b(final Object[] array, final org.codehaus.jackson.f f, final ax ax) {
        while (true) {
            final int length = array.length;
            final ba e = this.e;
            int n = 0;
            Object o = null;
            while (true) {
                Label_0155: {
                    try {
                        final d d = this.d;
                        if (n >= length) {
                            goto Label_0149;
                        }
                        o = array[n];
                        if (o == null) {
                            ax.a(f);
                            break Label_0155;
                        }
                        final Class<?> class1 = o.getClass();
                        ad<Object> ad = d.a(class1);
                        if (ad == null) {
                            ad = this.a(d, class1, ax);
                        }
                        ad.a(o, f, ax, e);
                        break Label_0155;
                    }
                    catch (IOException ex) {
                        throw ex;
                    }
                    catch (Exception ex2) {}
                    goto Label_0099;
                }
                ++n;
                continue;
            }
        }
    }
}
