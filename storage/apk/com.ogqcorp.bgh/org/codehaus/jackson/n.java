// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson;

import java.io.IOException;

public class n extends IOException
{
    protected h a;
    
    protected n(final String message) {
        super(message);
    }
    
    protected n(final String s, final Throwable t) {
        this(s, null, t);
    }
    
    protected n(final String s, final h h) {
        this(s, h, null);
    }
    
    protected n(final String message, final h a, final Throwable cause) {
        super(message);
        if (cause != null) {
            this.initCause(cause);
        }
        this.a = a;
    }
    
    public h a() {
        return this.a;
    }
    
    @Override
    public String getMessage() {
        String str = super.getMessage();
        if (str == null) {
            str = "N/A";
        }
        final h a = this.a();
        if (a != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append('\n');
            sb.append(" at ");
            sb.append(a.toString());
            str = sb.toString();
        }
        return str;
    }
    
    @Override
    public String toString() {
        return this.getClass().getName() + ": " + this.getMessage();
    }
}
