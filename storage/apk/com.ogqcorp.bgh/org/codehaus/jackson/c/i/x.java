// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.i;

import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.ai;
import org.codehaus.jackson.b.k;
import org.codehaus.jackson.c.h.b;

public class x
{
    protected q<b, k> a;
    
    public k a(final Class<?> clazz, final ai<?> ai) {
        while (true) {
            while (true) {
                final String b2;
                Label_0124: {
                    synchronized (this) {
                        final b b = new b(clazz);
                        if (this.a == null) {
                            this.a = new q<b, k>(20, 200);
                        }
                        else {
                            final k value = this.a.get(b);
                            if (value != null) {
                                return value;
                            }
                        }
                        b2 = ai.a().b(ai.c(clazz).c());
                        if (b2 != null) {
                            break Label_0124;
                        }
                        final String simpleName = clazz.getSimpleName();
                        final k value = new k(simpleName);
                        this.a.put(b, value);
                        return value;
                    }
                }
                final String simpleName = b2;
                continue;
            }
        }
    }
    
    public k a(final a a, final ai<?> ai) {
        return this.a(a.p(), ai);
    }
}
