// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.b;

import org.codehaus.jackson.g.a;
import org.codehaus.jackson.g.l;
import java.io.Writer;

public final class j extends Writer
{
    protected final l a;
    
    public j(final a a) {
        this.a = new l(a);
    }
    
    public String a() {
        final String f = this.a.f();
        this.a.a();
        return f;
    }
    
    @Override
    public Writer append(final char c) {
        this.write(c);
        return this;
    }
    
    @Override
    public Writer append(final CharSequence charSequence) {
        final String string = charSequence.toString();
        this.a.a(string, 0, string.length());
        return this;
    }
    
    @Override
    public Writer append(final CharSequence charSequence, final int n, final int n2) {
        final String string = charSequence.subSequence(n, n2).toString();
        this.a.a(string, 0, string.length());
        return this;
    }
    
    @Override
    public void close() {
    }
    
    @Override
    public void flush() {
    }
    
    @Override
    public void write(final int n) {
        this.a.a((char)n);
    }
    
    @Override
    public void write(final String s) {
        this.a.a(s, 0, s.length());
    }
    
    @Override
    public void write(final String s, final int n, final int n2) {
        this.a.a(s, n, n2);
    }
    
    @Override
    public void write(final char[] array) {
        this.a.c(array, 0, array.length);
    }
    
    @Override
    public void write(final char[] array, final int n, final int n2) {
        this.a.c(array, n, n2);
    }
}
