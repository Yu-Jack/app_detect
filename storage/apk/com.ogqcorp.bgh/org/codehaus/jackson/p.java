// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson;

public enum p
{
    a((String)null), 
    b("{"), 
    c("}"), 
    d("["), 
    e("]"), 
    f((String)null), 
    g((String)null), 
    h((String)null), 
    i((String)null), 
    j((String)null), 
    k("true"), 
    l("false"), 
    m("null");
    
    final String n;
    final char[] o;
    final byte[] p;
    
    private p(final String n) {
        if (n == null) {
            this.n = null;
            this.o = null;
            this.p = null;
        }
        else {
            this.n = n;
            this.o = n.toCharArray();
            final int length = this.o.length;
            this.p = new byte[length];
            for (int i = 0; i < length; ++i) {
                this.p[i] = (byte)this.o[i];
            }
        }
    }
    
    public String a() {
        return this.n;
    }
    
    public char[] b() {
        return this.o;
    }
    
    public boolean c() {
        return this == org.codehaus.jackson.p.i || this == org.codehaus.jackson.p.j;
    }
    
    public boolean d() {
        return this.ordinal() >= org.codehaus.jackson.p.g.ordinal();
    }
}
