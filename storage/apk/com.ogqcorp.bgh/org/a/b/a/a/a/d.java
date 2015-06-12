// 
// Decompiled by Procyon v0.5.29
// 

package org.a.b.a.a.a;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.File;

public class d extends a
{
    private final File a;
    private final String b;
    private final String c;
    
    public d(final File file) {
        this(file, "application/octet-stream");
    }
    
    public d(final File file, final String s) {
        this(file, s, null);
    }
    
    public d(final File file, final String s, final String s2) {
        this(file, null, s, s2);
    }
    
    public d(final File a, final String b, final String s, final String c) {
        super(s);
        if (a == null) {
            throw new IllegalArgumentException("File may not be null");
        }
        this.a = a;
        if (b != null) {
            this.b = b;
        }
        else {
            this.b = a.getName();
        }
        this.c = c;
    }
    
    @Override
    public void a(final OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
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
    public String b() {
        return this.b;
    }
    
    @Override
    public String c() {
        return this.c;
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
