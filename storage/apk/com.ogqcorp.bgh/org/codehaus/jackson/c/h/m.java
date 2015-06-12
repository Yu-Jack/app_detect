// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.h;

import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.i.l;

public class m
{
    final k a;
    
    public m(final k a) {
        this.a = a;
    }
    
    protected Class<?> a(final String str, final n n) {
        try {
            return l.a(str);
        }
        catch (Exception ex) {
            if (ex instanceof RuntimeException) {
                throw (RuntimeException)ex;
            }
            throw this.a(n, "Can not locate class '" + str + "', problem: " + ex.getMessage());
        }
    }
    
    protected IllegalArgumentException a(final n n, final String str) {
        return new IllegalArgumentException("Failed to parse type '" + n.a() + "' (remaining: '" + n.b() + "'): " + str);
    }
    
    public a a(final String s) {
        final n n = new n(s.trim());
        final a a = this.a(n);
        if (n.hasMoreTokens()) {
            throw this.a(n, "Unexpected tokens after complete type");
        }
        return a;
    }
    
    protected a a(final n n) {
        if (!n.hasMoreTokens()) {
            throw this.a(n, "Unexpected end-of-string");
        }
        final Class<?> a = this.a(n.nextToken(), n);
        if (n.hasMoreTokens()) {
            final String nextToken = n.nextToken();
            if ("<".equals(nextToken)) {
                return this.a.a(a, this.b(n));
            }
            n.a(nextToken);
        }
        return this.a.a(a, (j)null);
    }
    
    protected List<a> b(final n n) {
        final ArrayList<a> list = new ArrayList<a>();
        while (n.hasMoreTokens()) {
            list.add(this.a(n));
            if (!n.hasMoreTokens()) {
                break;
            }
            final String nextToken = n.nextToken();
            if (">".equals(nextToken)) {
                return list;
            }
            if (!",".equals(nextToken)) {
                throw this.a(n, "Unexpected token '" + nextToken + "', expected ',' or '>')");
            }
        }
        throw this.a(n, "Unexpected end-of-string");
    }
}
