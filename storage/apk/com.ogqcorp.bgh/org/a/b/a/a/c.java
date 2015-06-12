// 
// Decompiled by Procyon v0.5.29
// 

package org.a.b.a.a;

import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import java.nio.charset.Charset;
import org.apache.http.util.ByteArrayBuffer;

public class c
{
    private static final ByteArrayBuffer a;
    private static final ByteArrayBuffer b;
    private static final ByteArrayBuffer c;
    private final String d;
    private final Charset e;
    private final String f;
    private final List<a> g;
    private final d h;
    
    static {
        a = a(e.a, ": ");
        b = a(e.a, "\r\n");
        c = a(e.a, "--");
    }
    
    public c(final String d, Charset a, final String f, final d h) {
        if (d == null) {
            throw new IllegalArgumentException("Multipart subtype may not be null");
        }
        if (f == null) {
            throw new IllegalArgumentException("Multipart boundary may not be null");
        }
        this.d = d;
        if (a == null) {
            a = org.a.b.a.a.e.a;
        }
        this.e = a;
        this.f = f;
        this.g = new ArrayList<a>();
        this.h = h;
    }
    
    private static ByteArrayBuffer a(final Charset charset, final String csq) {
        final ByteBuffer encode = charset.encode(CharBuffer.wrap(csq));
        final ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(encode.remaining());
        byteArrayBuffer.append(encode.array(), encode.position(), encode.remaining());
        return byteArrayBuffer;
    }
    
    private static void a(final String s, final OutputStream outputStream) {
        a(a(e.a, s), outputStream);
    }
    
    private static void a(final String s, final Charset charset, final OutputStream outputStream) {
        a(a(charset, s), outputStream);
    }
    
    private void a(final d d, final OutputStream outputStream, final boolean b) {
        final ByteArrayBuffer a = a(this.e, this.b());
        for (final a a2 : this.g) {
            a(org.a.b.a.a.c.c, outputStream);
            a(a, outputStream);
            a(org.a.b.a.a.c.b, outputStream);
            final b c = a2.c();
            switch (c$1.a[d.ordinal()]) {
                case 1: {
                    final Iterator<f> iterator2 = c.iterator();
                    while (iterator2.hasNext()) {
                        a(iterator2.next(), outputStream);
                    }
                    break;
                }
                case 2: {
                    a(a2.c().a("Content-Disposition"), this.e, outputStream);
                    if (a2.b().b() != null) {
                        a(a2.c().a("Content-Type"), this.e, outputStream);
                        break;
                    }
                    break;
                }
            }
            a(org.a.b.a.a.c.b, outputStream);
            if (b) {
                a2.b().a(outputStream);
            }
            a(org.a.b.a.a.c.b, outputStream);
        }
        a(org.a.b.a.a.c.c, outputStream);
        a(a, outputStream);
        a(org.a.b.a.a.c.c, outputStream);
        a(org.a.b.a.a.c.b, outputStream);
    }
    
    private static void a(final f f, final OutputStream outputStream) {
        a(f.a(), outputStream);
        a(org.a.b.a.a.c.a, outputStream);
        a(f.b(), outputStream);
        a(org.a.b.a.a.c.b, outputStream);
    }
    
    private static void a(final f f, final Charset charset, final OutputStream outputStream) {
        a(f.a(), charset, outputStream);
        a(org.a.b.a.a.c.a, outputStream);
        a(f.b(), charset, outputStream);
        a(org.a.b.a.a.c.b, outputStream);
    }
    
    private static void a(final ByteArrayBuffer byteArrayBuffer, final OutputStream outputStream) {
        outputStream.write(byteArrayBuffer.buffer(), 0, byteArrayBuffer.length());
    }
    
    public List<a> a() {
        return this.g;
    }
    
    public void a(final OutputStream outputStream) {
        this.a(this.h, outputStream, true);
    }
    
    public void a(final a a) {
        if (a == null) {
            return;
        }
        this.g.add(a);
    }
    
    public String b() {
        return this.f;
    }
    
    public long c() {
        final Iterator<a> iterator = this.g.iterator();
        long n = 0L;
        while (iterator.hasNext()) {
            final long e = iterator.next().b().e();
            if (e < 0L) {
                return -1L;
            }
            n += e;
        }
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.a(this.h, byteArrayOutputStream, false);
            return n + byteArrayOutputStream.toByteArray().length;
        }
        catch (IOException ex) {
            return -1L;
        }
    }
}
