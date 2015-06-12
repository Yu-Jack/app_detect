// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.ad;
import org.codehaus.jackson.c.a.b;
import org.codehaus.jackson.c.as;
import java.util.List;

@b
public final class j extends w<List<String>> implements as
{
    protected ad<String> a;
    
    public j(final f f, final ad<?> a) {
        super(List.class, f);
        this.a = (ad<String>)a;
    }
    
    private final void b(final List<String> list, final org.codehaus.jackson.f f, final ax ax) {
        while (true) {
            int n = 0;
            while (true) {
                Label_0066: {
                    try {
                        final int size = list.size();
                        if (n < size) {
                            final String s = list.get(n);
                            if (s == null) {
                                ax.a(f);
                                break Label_0066;
                            }
                            f.b(s);
                            break Label_0066;
                        }
                    }
                    catch (Exception ex) {
                        this.a(ax, ex, list, n);
                    }
                    break;
                }
                ++n;
                continue;
            }
        }
    }
    
    private final void c(final List<String> list, final org.codehaus.jackson.f f, final ax ax) {
        while (true) {
            int n = 0;
            while (true) {
                Label_0075: {
                    try {
                        final int size = list.size();
                        final ad<String> a = this.a;
                        if (n < size) {
                            final String s = list.get(n);
                            if (s == null) {
                                ax.a(f);
                                break Label_0075;
                            }
                            a.a(s, f, ax);
                            break Label_0075;
                        }
                    }
                    catch (Exception ex) {
                        this.a(ax, ex, list, n);
                    }
                    break;
                }
                ++n;
                continue;
            }
        }
    }
    
    @Override
    public void a(final List<String> list, final org.codehaus.jackson.f f, final ax ax) {
        f.b();
        if (this.a == null) {
            this.b(list, f, ax);
        }
        else {
            this.c(list, f, ax);
        }
        f.c();
    }
    
    @Override
    public void a(final List<String> list, final org.codehaus.jackson.f f, final ax ax, final ba ba) {
        ba.c(list, f);
        if (this.a == null) {
            this.b(list, f, ax);
        }
        else {
            this.c(list, f, ax);
        }
        ba.f(list, f);
    }
    
    @Override
    public void a(final ax ax) {
        if (this.a == null) {
            final ad<Object> a = ax.a(String.class, this.b);
            if (!this.a(a)) {
                this.a = (ad<String>)a;
            }
        }
    }
}
