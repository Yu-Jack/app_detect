// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson;

public enum c
{
    a("UTF-8", false), 
    b("UTF-16BE", true), 
    c("UTF-16LE", false), 
    d("UTF-32BE", true), 
    e("UTF-32LE", false);
    
    protected final String f;
    protected final boolean g;
    
    private c(final String f, final boolean g) {
        this.f = f;
        this.g = g;
    }
    
    public String a() {
        return this.f;
    }
    
    public boolean b() {
        return this.g;
    }
}
