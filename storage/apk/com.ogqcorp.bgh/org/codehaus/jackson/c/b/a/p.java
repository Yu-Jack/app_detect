// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.a;

import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.c.e.e;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.g;

public class p extends g
{
    protected final Object e;
    
    public p(final String s, final a a, final org.codehaus.jackson.c.i.a a2, final e e, final Object e2) {
        super(s, a, a2, e);
        this.e = e2;
    }
    
    public Object a(final org.codehaus.jackson.c.p p2, final Object o) {
        return p2.a(this.e, this, o);
    }
    
    public void b(final org.codehaus.jackson.c.p p2, final Object o) {
        this.c.a(o, this.a(p2, o));
    }
}
