// 
// Decompiled by Procyon v0.5.29
// 

package a.a.a.a.a;

import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import a.a.a.c.a;
import java.nio.charset.Charset;
import a.a.a.c.b;

abstract class a
{
    private static final b b;
    private static final b c;
    private static final b d;
    protected final Charset a;
    private final String e;
    private final String f;
    
    static {
        b = a(h.a, ": ");
        c = a(h.a, "\r\n");
        d = a(h.a, "--");
    }
    
    public a(final String e, Charset a, final String f) {
        a.a.a.c.a.a(e, "Multipart subtype");
        a.a.a.c.a.a(f, "Multipart boundary");
        this.e = e;
        if (a == null) {
            a = h.a;
        }
        this.a = a;
        this.f = f;
    }
    
    private static b a(final Charset charset, final String csq) {
        final ByteBuffer encode = charset.encode(CharBuffer.wrap(csq));
        final b b = new b(encode.remaining());
        b.a(encode.array(), encode.position(), encode.remaining());
        return b;
    }
    
    protected static void a(final i i, final OutputStream outputStream) {
        a(i.a(), outputStream);
        a(a.b, outputStream);
        a(i.b(), outputStream);
        a(a.c, outputStream);
    }
    
    protected static void a(final i i, final Charset charset, final OutputStream outputStream) {
        a(i.a(), charset, outputStream);
        a(a.b, outputStream);
        a(i.b(), charset, outputStream);
        a(a.c, outputStream);
    }
    
    private static void a(final b b, final OutputStream outputStream) {
        outputStream.write(b.b(), 0, b.a());
    }
    
    private static void a(final String s, final OutputStream outputStream) {
        a(a(h.a, s), outputStream);
    }
    
    private static void a(final String s, final Charset charset, final OutputStream outputStream) {
        a(a(charset, s), outputStream);
    }
    
    public abstract List<a.a.a.a.a.b> a();
    
    protected abstract void a(final a.a.a.a.a.b p0, final OutputStream p1);
    
    public void a(final OutputStream outputStream) {
        this.a(outputStream, true);
    }
    
    void a(final OutputStream outputStream, final boolean b) {
        final b a = a(this.a, this.b());
        for (final a.a.a.a.a.b b2 : this.a()) {
            a(a.a.a.a.a.a.d, outputStream);
            a(a, outputStream);
            a(a.a.a.a.a.a.c, outputStream);
            this.a(b2, outputStream);
            a(a.a.a.a.a.a.c, outputStream);
            if (b) {
                b2.b().a(outputStream);
            }
            a(a.a.a.a.a.a.c, outputStream);
        }
        a(a.a.a.a.a.a.d, outputStream);
        a(a, outputStream);
        a(a.a.a.a.a.a.d, outputStream);
        a(a.a.a.a.a.a.c, outputStream);
    }
    
    public String b() {
        return this.f;
    }
    
    public long c() {
        final Iterator<a.a.a.a.a.b> iterator = this.a().iterator();
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
            this.a(byteArrayOutputStream, false);
            return n + byteArrayOutputStream.toByteArray().length;
        }
        catch (IOException ex) {
            return -1L;
        }
    }
}
