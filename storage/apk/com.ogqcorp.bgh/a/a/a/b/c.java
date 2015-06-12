// 
// Decompiled by Procyon v0.5.29
// 

package a.a.a.b;

import a.a.a.b;
import a.a.a.c.a;
import a.a.a.c.c;

public class c
{
    @Deprecated
    public static final c a;
    public static final c b;
    
    static {
        a = new c();
        b = new c();
    }
    
    protected a.a.a.c.c a(final a.a.a.c.c c) {
        if (c != null) {
            c.a();
            return c;
        }
        return new a.a.a.c.c(64);
    }
    
    public a.a.a.c.c a(final a.a.a.c.c c, final a.a.a.c c2) {
        a.a.a.c.a.a(c2, "Header");
        if (c2 instanceof b) {
            return ((b)c2).a();
        }
        final a.a.a.c.c a = this.a(c);
        this.b(a, c2);
        return a;
    }
    
    protected void b(final a.a.a.c.c c, final a.a.a.c c2) {
        final String b = c2.b();
        final String c3 = c2.c();
        int n = 2 + b.length();
        if (c3 != null) {
            n += c3.length();
        }
        c.a(n);
        c.a(b);
        c.a(": ");
        if (c3 != null) {
            c.a(c3);
        }
    }
}
