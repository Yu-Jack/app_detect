// 
// Decompiled by Procyon v0.5.29
// 

package a.a.a.a.a.a;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.io.UnsupportedEncodingException;
import java.nio.charset.UnsupportedCharsetException;

public class e extends a
{
    private final byte[] a;
    
    public e(final String s, final a.a.a.a.a a) {
        super(a);
        final Charset b = a.b();
        Label_0031: {
            if (b == null) {
                break Label_0031;
            }
            String s2 = b.name();
            try {
                while (true) {
                    this.a = s.getBytes(s2);
                    return;
                    s2 = a.a.a.a.b.name();
                    continue;
                }
            }
            catch (UnsupportedEncodingException ex) {
                throw new UnsupportedCharsetException(s2);
            }
        }
    }
    
    @Override
    public void a(final OutputStream outputStream) {
        a.a.a.c.a.a(outputStream, "Output stream");
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
    public String c() {
        return null;
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
