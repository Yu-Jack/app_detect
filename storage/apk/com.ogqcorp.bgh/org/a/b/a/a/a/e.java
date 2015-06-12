// 
// Decompiled by Procyon v0.5.29
// 

package org.a.b.a.a.a;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class e extends a
{
    private final byte[] a;
    private final Charset b;
    
    public e(final String s, final String s2, Charset forName) {
        super(s2);
        if (s == null) {
            throw new IllegalArgumentException("Text may not be null");
        }
        if (forName == null) {
            forName = Charset.forName("US-ASCII");
        }
        this.a = s.getBytes(forName.name());
        this.b = forName;
    }
    
    @Override
    public void a(final OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.a);
        final byte[] array = new byte[4096];
        while (true) {
            final int read = byteArrayInputStream.read(array);
            if (read == -1) {
                break;
            }
            outputStream.write(array, 0, read);
        }
        outputStream.flush();
    }
    
    @Override
    public String b() {
        return null;
    }
    
    @Override
    public String c() {
        return this.b.name();
    }
    
    @Override
    public String d() {
        return "8bit";
    }
    
    @Override
    public long e() {
        return this.a.length;
    }
}
