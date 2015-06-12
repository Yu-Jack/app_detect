// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.g.a.d;
import java.util.Iterator;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.c.ad;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.ba;
import java.util.Collection;

public class d extends a<Collection<?>>
{
    public d(final org.codehaus.jackson.f.a a, final boolean b, final ba ba, final f f, final ad<Object> ad) {
        super(Collection.class, a, b, ba, f, ad);
    }
    
    @Override
    public e<?> a(final ba ba) {
        return new d(this.b, this.a, ba, this.e, this.d);
    }
    
    @Override
    public void a(final Collection<?> collection, final org.codehaus.jackson.f f, final ax ax) {
        if (this.d != null) {
            this.a(collection, f, ax, this.d);
        }
        else {
            final Iterator<?> iterator = collection.iterator();
            if (iterator.hasNext()) {
                org.codehaus.jackson.c.g.a.d f2 = this.f;
                final ba c = this.c;
                int n = 0;
            Label_0071_Outer:
                while (true) {
                Label_0135_Outer:
                    while (true) {
                        Object next;
                        ad<Object> a;
                        while (true) {
                            Class<?> class1 = null;
                            try {
                                while (true) {
                                    next = iterator.next();
                                    Label_0085: {
                                        if (next != null) {
                                            break Label_0085;
                                        }
                                        ax.a(f);
                                        while (true) {
                                            ++n;
                                            try {
                                                if (!iterator.hasNext()) {
                                                    return;
                                                }
                                                break;
                                                // iftrue(Label_0197:, c != null)
                                                while (true) {
                                                    a.a(next, f, ax);
                                                    continue Label_0071_Outer;
                                                    final org.codehaus.jackson.c.g.a.d f3 = this.f;
                                                    final ad<Object> ad2;
                                                    final ad<Object> ad = ad2;
                                                    f2 = f3;
                                                    a = ad;
                                                    continue Label_0135_Outer;
                                                }
                                                class1 = next.getClass();
                                                a = f2.a(class1);
                                                // iftrue(Label_0153:, a != null)
                                                // iftrue(Label_0183:, !this.b.e())
                                                final ad<Object> ad2 = this.a(f2, ax.a(this.b, class1), ax);
                                            }
                                            catch (Exception ex) {
                                                this.a(ax, ex, collection, n);
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                            catch (Exception) {}
                            Label_0183: {
                                final ad<Object> ad2 = this.a(f2, class1, ax);
                            }
                            continue;
                        }
                        Label_0197: {
                            a.a(next, f, ax, c);
                        }
                        continue Label_0135_Outer;
                    }
                }
            }
        }
    }
    
    public void a(final Collection<?> collection, final org.codehaus.jackson.f f, final ax ax, final ad<Object> ad) {
        final Iterator<?> iterator = collection.iterator();
        while (true) {
            while (true) {
                Label_0027: {
                    if (iterator.hasNext()) {
                        final ba c = this.c;
                        final int n = 0;
                        break Label_0027;
                    }
                    return;
                    while (true) {
                    Label_0049_Outer:
                        while (true) {
                            final Object next;
                            while (true) {
                                try {
                                    ax.a(f);
                                    int n = 0;
                                    ++n;
                                    if (!iterator.hasNext()) {
                                        return;
                                    }
                                    break;
                                    while (true) {
                                        ad.a(next, f, ax);
                                        continue Label_0049_Outer;
                                        continue;
                                    }
                                }
                                // iftrue(Label_0092:, c != null)
                                catch (Exception ex) {
                                    final int n;
                                    this.a(ax, ex, collection, n);
                                    continue;
                                }
                                break;
                            }
                            Label_0092: {
                                final ba c;
                                ad.a(next, f, ax, c);
                            }
                            continue;
                        }
                    }
                }
                final Object next = iterator.next();
                if (next == null) {
                    continue;
                }
                break;
            }
            continue;
        }
    }
}
