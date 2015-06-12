// 
// Decompiled by Procyon v0.5.29
// 

package org.a.b.a.a;

public class f
{
    private final String a;
    private final String b;
    
    f(final String a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    public String a() {
        return this.a;
    }
    
    public String b() {
        return this.b;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(": ");
        sb.append(this.b);
        return sb.toString();
    }
}
