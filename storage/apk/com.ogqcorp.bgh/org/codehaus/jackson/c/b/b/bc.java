// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.b.g;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.c.af;

public abstract class bc extends af
{
    protected final Class<?> a;
    
    protected bc(final Class<?> a) {
        this.a = a;
    }
    
    protected int a(final String s) {
        return Integer.parseInt(s);
    }
    
    public Class<?> a() {
        return this.a;
    }
    
    @Override
    public final Object a(final String s, final p p2) {
        Object b;
        if (s == null) {
            b = null;
        }
        else {
            try {
                b = this.b(s, p2);
                if (b == null) {
                    throw p2.a(this.a, s, "not a valid representation");
                }
            }
            catch (Exception ex) {
                throw p2.a(this.a, s, "not a valid representation: " + ex.getMessage());
            }
        }
        return b;
    }
    
    protected long b(final String s) {
        return Long.parseLong(s);
    }
    
    protected abstract Object b(final String p0, final p p1);
    
    protected double c(final String s) {
        return g.c(s);
    }
}
