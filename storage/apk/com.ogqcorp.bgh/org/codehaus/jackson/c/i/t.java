// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.i;

final class t
{
    final Object[] a;
    t b;
    
    public t(final Object[] a) {
        this.a = a;
    }
    
    public void a(final t b) {
        if (this.b != null) {
            throw new IllegalStateException();
        }
        this.b = b;
    }
    
    public Object[] a() {
        return this.a;
    }
    
    public t b() {
        return this.b;
    }
}
