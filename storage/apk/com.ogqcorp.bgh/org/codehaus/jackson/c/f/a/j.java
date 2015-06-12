// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.f.a;

import org.codehaus.jackson.c.h.k;
import org.codehaus.jackson.f.a;

public class j extends i
{
    protected final String a;
    protected final String b;
    
    protected j(final a a, final k k) {
        super(a, k);
        final String name = a.p().getName();
        final int lastIndex = name.lastIndexOf(46);
        if (lastIndex < 0) {
            this.a = "";
            this.b = ".";
            return;
        }
        this.b = name.substring(0, lastIndex + 1);
        this.a = name.substring(0, lastIndex);
    }
    
    @Override
    public String a(final Object o) {
        String s = o.getClass().getName();
        if (s.startsWith(this.b)) {
            s = s.substring(-1 + this.b.length());
        }
        return s;
    }
    
    @Override
    public a a(String string) {
        if (string.startsWith(".")) {
            final StringBuilder sb = new StringBuilder(string.length() + this.a.length());
            if (this.a.length() == 0) {
                sb.append(string.substring(1));
            }
            else {
                sb.append(this.a).append(string);
            }
            string = sb.toString();
        }
        return super.a(string);
    }
}
