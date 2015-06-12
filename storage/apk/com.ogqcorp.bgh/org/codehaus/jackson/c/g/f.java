// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g;

import org.codehaus.jackson.c.ad;
import java.util.List;
import org.codehaus.jackson.c.e.k;

public class f
{
    private static final d[] f;
    protected final k a;
    protected List<d> b;
    protected d[] c;
    protected a d;
    protected Object e;
    
    static {
        f = new d[0];
    }
    
    public f(final k a) {
        this.a = a;
    }
    
    public List<d> a() {
        return this.b;
    }
    
    public void a(final Object e) {
        this.e = e;
    }
    
    public void a(final List<d> b) {
        this.b = b;
    }
    
    public void a(final a d) {
        this.d = d;
    }
    
    public void a(final d[] c) {
        this.c = c;
    }
    
    public ad<?> b() {
        d[] f;
        if (this.b == null || this.b.isEmpty()) {
            if (this.d == null) {
                return null;
            }
            f = org.codehaus.jackson.c.g.f.f;
        }
        else {
            f = this.b.toArray(new d[this.b.size()]);
        }
        return new e(this.a.a(), f, this.c, this.d, this.e);
    }
    
    public e c() {
        return org.codehaus.jackson.c.g.e.a(this.a.b());
    }
}
