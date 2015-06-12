// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ba;
import java.util.Iterator;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.ad;
import org.codehaus.jackson.c.a.b;
import org.codehaus.jackson.c.as;
import java.util.Collection;

@b
public class ax extends w<Collection<String>> implements as
{
    protected ad<String> a;
    
    public ax(final f f, final ad<?> a) {
        super(Collection.class, f);
        this.a = (ad<String>)a;
    }
    
    private final void b(final Collection<String> collection, final org.codehaus.jackson.f f, final org.codehaus.jackson.c.ax ax) {
        if (this.a != null) {
            this.c(collection, f, ax);
        }
        else {
            final Iterator<String> iterator = collection.iterator();
            int n = 0;
            while (iterator.hasNext()) {
                final String s = iterator.next();
                int n2 = 0;
                Label_0095: {
                    Label_0061: {
                        if (s != null) {
                            break Label_0061;
                        }
                        try {
                            ax.a(f);
                            break Label_0061;
                            f.b(s);
                        }
                        catch (Exception ex) {
                            this.a(ax, ex, collection, n);
                            n2 = n;
                            break Label_0095;
                        }
                    }
                    n2 = n + 1;
                }
                n = n2;
            }
        }
    }
    
    private void c(final Collection<String> collection, final org.codehaus.jackson.f f, final org.codehaus.jackson.c.ax ax) {
        final ad<String> a = this.a;
        for (final String s : collection) {
            if (s == null) {
                try {
                    ax.a(f);
                }
                catch (Exception ex) {
                    this.a(ax, ex, collection, 0);
                }
            }
            else {
                a.a(s, f, ax);
            }
        }
    }
    
    @Override
    public void a(final Collection<String> collection, final org.codehaus.jackson.f f, final org.codehaus.jackson.c.ax ax) {
        f.b();
        if (this.a == null) {
            this.b(collection, f, ax);
        }
        else {
            this.c(collection, f, ax);
        }
        f.c();
    }
    
    @Override
    public void a(final Collection<String> collection, final org.codehaus.jackson.f f, final org.codehaus.jackson.c.ax ax, final ba ba) {
        ba.c(collection, f);
        if (this.a == null) {
            this.b(collection, f, ax);
        }
        else {
            this.c(collection, f, ax);
        }
        ba.f(collection, f);
    }
    
    @Override
    public void a(final org.codehaus.jackson.c.ax ax) {
        if (this.a == null) {
            final ad<Object> a = ax.a(String.class, this.b);
            if (!this.a(a)) {
                this.a = (ad<String>)a;
            }
        }
    }
}
