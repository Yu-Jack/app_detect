// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson;

import java.io.StringReader;
import org.codehaus.jackson.a.h;
import java.io.Reader;
import java.io.InputStream;
import java.io.FileInputStream;
import org.codehaus.jackson.a.k;
import java.io.FileOutputStream;
import java.io.File;
import java.io.OutputStreamWriter;
import org.codehaus.jackson.b.m;
import java.io.Writer;
import java.io.OutputStream;
import org.codehaus.jackson.b.i;
import org.codehaus.jackson.b.b;
import org.codehaus.jackson.e.d;
import org.codehaus.jackson.g.a;
import java.lang.ref.SoftReference;

public class d
{
    static final int a;
    static final int b;
    protected static final ThreadLocal<SoftReference<a>> c;
    protected org.codehaus.jackson.e.d d;
    protected org.codehaus.jackson.e.a e;
    protected q f;
    protected int g;
    protected int h;
    protected b i;
    protected org.codehaus.jackson.b.d j;
    protected i k;
    
    static {
        a = l.a();
        b = g.a();
        c = new ThreadLocal<SoftReference<a>>();
    }
    
    public d(final q f) {
        this.d = org.codehaus.jackson.e.d.a();
        this.e = org.codehaus.jackson.e.a.a();
        this.g = org.codehaus.jackson.d.a;
        this.h = org.codehaus.jackson.d.b;
        this.f = f;
    }
    
    protected Writer a(final OutputStream out, final c c, final org.codehaus.jackson.b.c c2) {
        if (c == c.a) {
            return new m(c2, out);
        }
        return new OutputStreamWriter(out, c.a());
    }
    
    protected org.codehaus.jackson.b.c a(final Object o, final boolean b) {
        return new org.codehaus.jackson.b.c(this.b(), o, b);
    }
    
    public d a(final q f) {
        this.f = f;
        return this;
    }
    
    public f a(final File file, final c c) {
        OutputStream a = new FileOutputStream(file);
        final org.codehaus.jackson.b.c a2 = this.a(a, true);
        a2.a(c);
        if (c == c.a) {
            if (this.k != null) {
                a = this.k.a(a2, a);
            }
            return this.a(a, a2);
        }
        Writer writer = this.a(a, c, a2);
        if (this.k != null) {
            writer = this.k.a(a2, writer);
        }
        return this.a(writer, a2);
    }
    
    protected f a(final OutputStream outputStream, final org.codehaus.jackson.b.c c) {
        final org.codehaus.jackson.a.i i = new org.codehaus.jackson.a.i(c, this.h, this.f, outputStream);
        if (this.i != null) {
            i.a(this.i);
        }
        return i;
    }
    
    public f a(Writer a) {
        final org.codehaus.jackson.b.c a2 = this.a(a, false);
        if (this.k != null) {
            a = this.k.a(a2, a);
        }
        return this.a(a, a2);
    }
    
    protected f a(final Writer writer, final org.codehaus.jackson.b.c c) {
        final k k = new k(c, this.h, this.f, writer);
        if (this.i != null) {
            k.a(this.i);
        }
        return k;
    }
    
    public org.codehaus.jackson.k a(final File file) {
        final org.codehaus.jackson.b.c a = this.a(file, true);
        InputStream a2 = new FileInputStream(file);
        if (this.j != null) {
            a2 = this.j.a(a, a2);
        }
        return this.a(a2, a);
    }
    
    protected org.codehaus.jackson.k a(final InputStream inputStream, final org.codehaus.jackson.b.c c) {
        return new org.codehaus.jackson.a.a(c, inputStream).a(this.g, this.f, this.e, this.d);
    }
    
    protected org.codehaus.jackson.k a(final Reader reader, final org.codehaus.jackson.b.c c) {
        return new h(c, this.g, reader, this.f, this.d.a(this.a(l.j), this.a(l.i)));
    }
    
    public org.codehaus.jackson.k a(final String s) {
        Reader a = new StringReader(s);
        final org.codehaus.jackson.b.c a2 = this.a(a, true);
        if (this.j != null) {
            a = this.j.a(a2, a);
        }
        return this.a(a, a2);
    }
    
    public org.codehaus.jackson.k a(final byte[] array) {
        final org.codehaus.jackson.b.c a = this.a(array, true);
        if (this.j != null) {
            final InputStream a2 = this.j.a(a, array, 0, array.length);
            if (a2 != null) {
                return this.a(a2, a);
            }
        }
        return this.a(array, 0, array.length, a);
    }
    
    protected org.codehaus.jackson.k a(final byte[] array, final int n, final int n2, final org.codehaus.jackson.b.c c) {
        return new org.codehaus.jackson.a.a(c, array, n, n2).a(this.g, this.f, this.e, this.d);
    }
    
    public q a() {
        return this.f;
    }
    
    public final boolean a(final l l) {
        return (this.g & l.c()) != 0x0;
    }
    
    public a b() {
        final SoftReference<a> softReference = org.codehaus.jackson.d.c.get();
        a referent;
        if (softReference == null) {
            referent = null;
        }
        else {
            referent = softReference.get();
        }
        if (referent == null) {
            referent = new a();
            org.codehaus.jackson.d.c.set(new SoftReference<a>(referent));
        }
        return referent;
    }
}
