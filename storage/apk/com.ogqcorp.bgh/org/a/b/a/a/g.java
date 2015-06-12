// 
// Decompiled by Procyon v0.5.29
// 

package org.a.b.a.a;

import java.io.OutputStream;
import java.util.Iterator;
import java.io.InputStream;
import org.a.b.a.a.a.b;
import java.util.Random;
import org.apache.http.message.BasicHeader;
import java.nio.charset.Charset;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class g implements HttpEntity
{
    private static final char[] a;
    private final c b;
    private final Header c;
    private long d;
    private volatile boolean e;
    
    static {
        a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }
    
    public g() {
        this(org.a.b.a.a.d.a, null, null);
    }
    
    public g(final d d) {
        this(d, null, null);
    }
    
    public g(d a, String a2, final Charset charset) {
        if (a2 == null) {
            a2 = this.a();
        }
        if (a == null) {
            a = org.a.b.a.a.d.a;
        }
        this.b = new c("form-data", charset, a2, a);
        this.c = (Header)new BasicHeader("Content-Type", this.a(a2, charset));
        this.e = true;
    }
    
    protected String a() {
        final StringBuilder sb = new StringBuilder();
        final Random random = new Random();
        for (int n = 30 + random.nextInt(11), i = 0; i < n; ++i) {
            sb.append(g.a[random.nextInt(g.a.length)]);
        }
        return sb.toString();
    }
    
    protected String a(final String str, final Charset charset) {
        final StringBuilder sb = new StringBuilder();
        sb.append("multipart/form-data; boundary=");
        sb.append(str);
        if (charset != null) {
            sb.append("; charset=");
            sb.append(charset.name());
        }
        return sb.toString();
    }
    
    public void a(final String s, final b b) {
        this.a(new a(s, b));
    }
    
    public void a(final a a) {
        this.b.a(a);
        this.e = true;
    }
    
    public void consumeContent() {
        if (this.isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }
    
    public InputStream getContent() {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }
    
    public Header getContentEncoding() {
        return null;
    }
    
    public long getContentLength() {
        if (this.e) {
            this.d = this.b.c();
            this.e = false;
        }
        return this.d;
    }
    
    public Header getContentType() {
        return this.c;
    }
    
    public boolean isChunked() {
        return !this.isRepeatable();
    }
    
    public boolean isRepeatable() {
        final Iterator<a> iterator = this.b.a().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().b().e() < 0L) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isStreaming() {
        return !this.isRepeatable();
    }
    
    public void writeTo(final OutputStream outputStream) {
        this.b.a(outputStream);
    }
}
