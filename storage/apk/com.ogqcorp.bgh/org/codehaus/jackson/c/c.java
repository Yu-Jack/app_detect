// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c;

public class c
{
    private final d a;
    private final String b;
    
    public c(final d a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    public static c a(final String s) {
        return new c(d.a, s);
    }
    
    public static c b(final String s) {
        return new c(d.b, s);
    }
    
    public String a() {
        return this.b;
    }
    
    public boolean b() {
        return this.a == d.a;
    }
    
    public boolean c() {
        return this.a == d.b;
    }
}
