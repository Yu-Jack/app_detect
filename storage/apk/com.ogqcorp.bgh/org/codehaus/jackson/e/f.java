// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.e;

public abstract class f
{
    protected final String a;
    protected final int b;
    
    protected f(final String a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    public String a() {
        return this.a;
    }
    
    public abstract boolean a(final int p0);
    
    public abstract boolean a(final int p0, final int p1);
    
    public abstract boolean a(final int[] p0, final int p1);
    
    @Override
    public boolean equals(final Object o) {
        return o == this;
    }
    
    @Override
    public final int hashCode() {
        return this.b;
    }
    
    @Override
    public String toString() {
        return this.a;
    }
}
