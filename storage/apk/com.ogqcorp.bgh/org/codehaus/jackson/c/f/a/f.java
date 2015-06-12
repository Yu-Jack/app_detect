// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.f.a;

import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.f.c;

public class f extends b
{
    protected final String a;
    
    public f(final c c, final org.codehaus.jackson.c.f f, final String a) {
        super(c, f);
        this.a = a;
    }
    
    @Override
    public void b(final Object o, final org.codehaus.jackson.f f) {
        f.d();
        f.a(this.a, this.b.a(o));
    }
    
    @Override
    public void e(final Object o, final org.codehaus.jackson.f f) {
        f.e();
    }
}
