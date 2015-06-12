// 
// Decompiled by Procyon v0.5.29
// 

package org.a.a.a;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Closeable;
import java.nio.charset.Charset;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.io.PrintWriter;
import org.a.a.a.a.a;
import java.io.File;

public class d
{
    public static final char a;
    public static final String b;
    
    static {
        a = File.separatorChar;
        final a out = new a(4);
        final PrintWriter printWriter = new PrintWriter(out);
        printWriter.println();
        b = out.toString();
        printWriter.close();
    }
    
    public static int a(final Reader reader, final Writer writer) {
        final long b = b(reader, writer);
        if (b > 2147483647L) {
            return -1;
        }
        return (int)b;
    }
    
    public static long a(final InputStream inputStream, final OutputStream outputStream) {
        return a(inputStream, outputStream, new byte[4096]);
    }
    
    public static long a(final InputStream inputStream, final OutputStream outputStream, final byte[] array) {
        long n = 0L;
        while (true) {
            final int read = inputStream.read(array);
            if (-1 == read) {
                break;
            }
            outputStream.write(array, 0, read);
            n += read;
        }
        return n;
    }
    
    public static long a(final Reader reader, final Writer writer, final char[] cbuf) {
        long n = 0L;
        while (true) {
            final int read = reader.read(cbuf);
            if (-1 == read) {
                break;
            }
            writer.write(cbuf, 0, read);
            n += read;
        }
        return n;
    }
    
    public static String a(final InputStream inputStream, final Charset charset) {
        final a a = new a();
        a(inputStream, a, charset);
        return a.toString();
    }
    
    public static void a(final Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        }
        catch (IOException ex) {}
    }
    
    public static void a(final InputStream inputStream) {
        a((Closeable)inputStream);
    }
    
    public static void a(final InputStream in, final Writer writer, final Charset charset) {
        a(new InputStreamReader(in, org.a.a.a.a.a(charset)), writer);
    }
    
    public static void a(final OutputStream outputStream) {
        a((Closeable)outputStream);
    }
    
    public static byte[] a(final InputStream inputStream, final int n) {
        int i = 0;
        if (n < 0) {
            throw new IllegalArgumentException("Size must be equal or greater than zero: " + n);
        }
        byte[] b;
        if (n == 0) {
            b = new byte[0];
        }
        else {
            b = new byte[n];
            while (i < n) {
                final int read = inputStream.read(b, i, n - i);
                if (read == -1) {
                    break;
                }
                i += read;
            }
            if (i != n) {
                throw new IOException("Unexpected readed size. current: " + i + ", excepted: " + n);
            }
        }
        return b;
    }
    
    public static byte[] a(final InputStream inputStream, final long lng) {
        if (lng > 2147483647L) {
            throw new IllegalArgumentException("Size cannot be greater than Integer max value: " + lng);
        }
        return a(inputStream, (int)lng);
    }
    
    public static long b(final Reader reader, final Writer writer) {
        return a(reader, writer, new char[4096]);
    }
    
    public static String b(final InputStream inputStream) {
        return a(inputStream, Charset.defaultCharset());
    }
}
