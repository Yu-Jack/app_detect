// 
// Decompiled by Procyon v0.5.29
// 

package a.a.a.a.a.a;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.File;

public class d extends a
{
    private final File a;
    private final String b;
    
    public d(final File a, final a.a.a.a.a a2, final String b) {
        super(a2);
        a.a.a.c.a.a(a, "File");
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void a(final OutputStream outputStream) {
        a.a.a.c.a.a(outputStream, "Output stream");
        final FileInputStream fileInputStream = new FileInputStream(this.a);
        try {
            final byte[] array = new byte[4096];
            while (true) {
                final int read = fileInputStream.read(array);
                if (read == -1) {
                    break;
                }
                outputStream.write(array, 0, read);
            }
        }
        finally {
            fileInputStream.close();
        }
        outputStream.flush();
        fileInputStream.close();
    }
    
    @Override
    public String c() {
        return this.b;
    }
    
    @Override
    public String d() {
        return "binary";
    }
    
    @Override
    public long e() {
        return this.a.length();
    }
}
