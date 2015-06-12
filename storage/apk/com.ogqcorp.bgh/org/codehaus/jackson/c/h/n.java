// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.h;

import java.util.StringTokenizer;

final class n extends StringTokenizer
{
    protected final String a;
    protected int b;
    protected String c;
    
    public n(final String s) {
        super(s, "<,>", true);
        this.a = s;
    }
    
    public String a() {
        return this.a;
    }
    
    public void a(final String c) {
        this.c = c;
        this.b -= c.length();
    }
    
    public String b() {
        return this.a.substring(this.b);
    }
    
    @Override
    public boolean hasMoreTokens() {
        return this.c != null || super.hasMoreTokens();
    }
    
    @Override
    public String nextToken() {
        String s;
        if (this.c != null) {
            s = this.c;
            this.c = null;
        }
        else {
            s = super.nextToken();
        }
        this.b += s.length();
        return s;
    }
}
