// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c;

import java.util.Iterator;
import org.codehaus.jackson.k;
import org.codehaus.jackson.h;
import java.util.LinkedList;
import org.codehaus.jackson.n;

public class z extends n
{
    protected LinkedList<aa> b;
    
    public z(final String s) {
        super(s);
    }
    
    public z(final String s, final Throwable t) {
        super(s, t);
    }
    
    public z(final String s, final h h) {
        super(s, h);
    }
    
    public z(final String s, final h h, final Throwable t) {
        super(s, h, t);
    }
    
    public static z a(final Throwable t, final Object o, final int n) {
        return a(t, new aa(o, n));
    }
    
    public static z a(final Throwable t, final Object o, final String s) {
        return a(t, new aa(o, s));
    }
    
    public static z a(final Throwable t, final aa aa) {
        z z;
        if (t instanceof z) {
            z = (z)t;
        }
        else {
            String s = t.getMessage();
            if (s == null || s.length() == 0) {
                s = "(was " + t.getClass().getName() + ")";
            }
            z = new z(s, null, t);
        }
        z.a(aa);
        return z;
    }
    
    public static z a(final k k, final String s) {
        return new z(s, k.h());
    }
    
    public static z a(final k k, final String s, final Throwable t) {
        return new z(s, k.h(), t);
    }
    
    public void a(final Object o, final String s) {
        this.a(new aa(o, s));
    }
    
    protected void a(final StringBuilder sb) {
        final Iterator<aa> iterator = (Iterator<aa>)this.b.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next().toString());
            if (iterator.hasNext()) {
                sb.append("->");
            }
        }
    }
    
    public void a(final aa e) {
        if (this.b == null) {
            this.b = new LinkedList<aa>();
        }
        if (this.b.size() < 1000) {
            this.b.addFirst(e);
        }
    }
    
    @Override
    public String getMessage() {
        final String message = super.getMessage();
        if (this.b == null) {
            return message;
        }
        StringBuilder sb;
        if (message == null) {
            sb = new StringBuilder();
        }
        else {
            sb = new StringBuilder(message);
        }
        sb.append(" (through reference chain: ");
        this.a(sb);
        sb.append(')');
        return sb.toString();
    }
    
    @Override
    public String toString() {
        return this.getClass().getName() + ": " + this.getMessage();
    }
}
