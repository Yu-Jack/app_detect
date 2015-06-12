// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c;

import org.codehaus.jackson.c.e.e;
import org.codehaus.jackson.f.a;

public class g implements f
{
    protected final String a;
    protected final a b;
    protected final e c;
    protected final org.codehaus.jackson.c.i.a d;
    
    public g(final String a, final a b, final org.codehaus.jackson.c.i.a d, final e c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public g a(final a a) {
        return new g(this.a, a, this.d, this.c);
    }
    
    @Override
    public a a() {
        return this.b;
    }
    
    @Override
    public e b() {
        return this.c;
    }
    
    public String c() {
        return this.a;
    }
}
