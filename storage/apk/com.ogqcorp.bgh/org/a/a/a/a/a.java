// 
// Decompiled by Procyon v0.5.29
// 

package org.a.a.a.a;

import java.io.Serializable;
import java.io.Writer;

public class a extends Writer implements Serializable
{
    private final StringBuilder a;
    
    public a() {
        this.a = new StringBuilder();
    }
    
    public a(final int capacity) {
        this.a = new StringBuilder(capacity);
    }
    
    @Override
    public Writer append(final char c) {
        this.a.append(c);
        return this;
    }
    
    @Override
    public Writer append(final CharSequence s) {
        this.a.append(s);
        return this;
    }
    
    @Override
    public Writer append(final CharSequence s, final int start, final int end) {
        this.a.append(s, start, end);
        return this;
    }
    
    @Override
    public void close() {
    }
    
    @Override
    public void flush() {
    }
    
    @Override
    public String toString() {
        return this.a.toString();
    }
    
    @Override
    public void write(final String str) {
        if (str != null) {
            this.a.append(str);
        }
    }
    
    @Override
    public void write(final char[] str, final int offset, final int len) {
        if (str != null) {
            this.a.append(str, offset, len);
        }
    }
}
