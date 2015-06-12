// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g;

import org.codehaus.jackson.c.i.b;
import org.codehaus.jackson.c.ay;
import org.codehaus.jackson.c.aw;

public class h extends aw
{
    protected static final ay[] a;
    protected static final i[] b;
    protected final ay[] c;
    protected final ay[] d;
    protected final i[] e;
    
    static {
        a = new ay[0];
        b = new i[0];
    }
    
    public h() {
        this(null, null, null);
    }
    
    protected h(ay[] a, ay[] a2, i[] b) {
        if (a == null) {
            a = h.a;
        }
        this.c = a;
        if (a2 == null) {
            a2 = h.a;
        }
        this.d = a2;
        if (b == null) {
            b = h.b;
        }
        this.e = b;
    }
    
    @Override
    public boolean a() {
        return this.d.length > 0;
    }
    
    @Override
    public boolean b() {
        return this.e.length > 0;
    }
    
    @Override
    public Iterable<ay> c() {
        return org.codehaus.jackson.c.i.b.b(this.c);
    }
    
    @Override
    public Iterable<ay> d() {
        return org.codehaus.jackson.c.i.b.b(this.d);
    }
    
    @Override
    public Iterable<i> e() {
        return org.codehaus.jackson.c.i.b.b(this.e);
    }
}
