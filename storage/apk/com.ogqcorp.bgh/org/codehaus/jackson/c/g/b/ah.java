// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.ad;
import org.codehaus.jackson.c.a.b;
import org.codehaus.jackson.c.as;

@b
public final class ah extends y<String[]> implements as
{
    protected ad<Object> a;
    
    public ah(final f f) {
        super(String[].class, null, f);
    }
    
    private void a(final String[] array, final org.codehaus.jackson.f f, final ax ax, final ad<Object> ad) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == null) {
                ax.a(f);
            }
            else {
                ad.a(array[i], f, ax);
            }
        }
    }
    
    @Override
    public e<?> a(final ba ba) {
        return this;
    }
    
    @Override
    public void a(final ax ax) {
        final ad<Object> a = ax.a(String.class, this.f);
        if (a != null && a.getClass().getAnnotation(b.class) == null) {
            this.a = a;
        }
    }
    
    @Override
    public void a(final String[] array, final org.codehaus.jackson.f f, final ax ax) {
        final int length = array.length;
        if (length != 0) {
            if (this.a != null) {
                this.a(array, f, ax, this.a);
                return;
            }
            for (int i = 0; i < length; ++i) {
                if (array[i] == null) {
                    f.f();
                }
                else {
                    f.b(array[i]);
                }
            }
        }
    }
}
