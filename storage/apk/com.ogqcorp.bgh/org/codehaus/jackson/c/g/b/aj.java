// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.g.a.d;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.c.ad;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.a.b;
import java.util.List;

@b
public class aj extends a<List<?>>
{
    public aj(final org.codehaus.jackson.f.a a, final boolean b, final ba ba, final f f, final ad<Object> ad) {
        super(List.class, a, b, ba, f, ad);
    }
    
    @Override
    public e<?> a(final ba ba) {
        return new aj(this.b, this.a, ba, this.e, this.d);
    }
    
    @Override
    public void a(final List<?> list, final org.codehaus.jackson.f f, final ax ax) {
        if (this.d != null) {
            this.a(list, f, ax, this.d);
        }
        else {
            if (this.c != null) {
                this.b(list, f, ax);
                return;
            }
            final int size = list.size();
            if (size != 0) {
                while (true) {
                    int n = 0;
                    while (true) {
                        Label_0197: {
                            while (true) {
                                d f2 = null;
                                Class<?> class1 = null;
                                Label_0179: {
                                    try {
                                        f2 = this.f;
                                        if (n >= size) {
                                            break;
                                        }
                                        final Object value = list.get(n);
                                        if (value == null) {
                                            ax.a(f);
                                            break Label_0197;
                                        }
                                        class1 = value.getClass();
                                        ad<Object> a = f2.a(class1);
                                        if (a == null) {
                                            if (!this.b.e()) {
                                                break Label_0179;
                                            }
                                            final ad<Object> ad = this.a(f2, ax.a(this.b, class1), ax);
                                            final d f3 = this.f;
                                            final ad<Object> ad2 = ad;
                                            f2 = f3;
                                            a = ad2;
                                        }
                                        a.a(value, f, ax);
                                        break Label_0197;
                                    }
                                    catch (Exception ex) {
                                        this.a(ax, ex, list, n);
                                        return;
                                    }
                                }
                                final ad<Object> ad = this.a(f2, class1, ax);
                                continue;
                            }
                        }
                        ++n;
                        continue;
                    }
                }
            }
        }
    }
    
    public void a(final List<?> list, final org.codehaus.jackson.f f, final ax ax, final ad<Object> ad) {
        final int size = list.size();
        if (size != 0) {
            final ba c = this.c;
        Block_4_Outer:
            for (int i = 0; i < size; ++i) {
                final Object value = list.get(i);
                Label_0053: {
                    if (value != null) {
                        break Label_0053;
                    }
                    try {
                        ax.a(f);
                        continue Block_4_Outer;
                        while (true) {
                            ad.a(value, f, ax);
                            continue Block_4_Outer;
                            continue;
                        }
                    }
                    // iftrue(Label_0085:, c != null)
                    catch (Exception ex) {
                        this.a(ax, ex, list, i);
                    }
                }
                continue;
                Label_0085: {
                    ad.a(value, f, ax, c);
                }
            }
        }
    }
    
    public void b(final List<?> list, final org.codehaus.jackson.f f, final ax ax) {
        final int size = list.size();
        if (size != 0) {
            while (true) {
                int n = 0;
                while (true) {
                    Label_0172: {
                        while (true) {
                            d f2 = null;
                            Class<?> class1 = null;
                            Label_0154: {
                                try {
                                    final ba c = this.c;
                                    f2 = this.f;
                                    if (n >= size) {
                                        break;
                                    }
                                    final Object value = list.get(n);
                                    if (value == null) {
                                        ax.a(f);
                                        break Label_0172;
                                    }
                                    class1 = value.getClass();
                                    ad<Object> a = f2.a(class1);
                                    if (a == null) {
                                        if (!this.b.e()) {
                                            break Label_0154;
                                        }
                                        final ad<Object> ad = this.a(f2, ax.a(this.b, class1), ax);
                                        final d f3 = this.f;
                                        final ad<Object> ad2 = ad;
                                        f2 = f3;
                                        a = ad2;
                                    }
                                    a.a(value, f, ax, c);
                                    break Label_0172;
                                }
                                catch (Exception ex) {
                                    this.a(ax, ex, list, n);
                                    return;
                                }
                            }
                            final ad<Object> ad = this.a(f2, class1, ax);
                            continue;
                        }
                    }
                    ++n;
                    continue;
                }
            }
        }
    }
}
