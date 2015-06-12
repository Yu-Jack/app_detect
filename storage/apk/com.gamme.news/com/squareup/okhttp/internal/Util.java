// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Reader;
import java.io.EOFException;
import java.nio.ByteOrder;
import java.util.Collections;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.net.URL;
import java.net.URI;
import java.io.File;
import java.util.concurrent.ThreadFactory;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicReference;
import java.nio.charset.Charset;

public final class Util
{
    private static final char[] DIGITS;
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final String[] EMPTY_STRING_ARRAY;
    public static final Charset ISO_8859_1;
    public static final Charset US_ASCII;
    public static final Charset UTF_8;
    private static AtomicReference<byte[]> skipBuffer;
    
    static {
        EMPTY_BYTE_ARRAY = new byte[0];
        EMPTY_STRING_ARRAY = new String[0];
        ISO_8859_1 = Charset.forName("ISO-8859-1");
        US_ASCII = Charset.forName("US-ASCII");
        UTF_8 = Charset.forName("UTF-8");
        Util.skipBuffer = new AtomicReference<byte[]>();
        DIGITS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    }
    
    private static String bytesToHexString(final byte[] array) {
        final char[] digits = Util.DIGITS;
        final char[] value = new char[2 * array.length];
        final int length = array.length;
        int i = 0;
        int n = 0;
        while (i < length) {
            final byte b = array[i];
            final int n2 = n + 1;
            value[n] = digits[0xF & b >> 4];
            n = n2 + 1;
            value[n2] = digits[b & 0xF];
            ++i;
        }
        return new String(value);
    }
    
    public static void checkOffsetAndCount(final int n, final int n2, final int n3) {
        if ((n2 | n3) < 0 || n2 > n || n - n2 < n3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    public static void closeAll(final Closeable p0, final Closeable p1) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_2       
        //     2: aload_0        
        //     3: invokeinterface java/io/Closeable.close:()V
        //     8: aload_1        
        //     9: invokeinterface java/io/Closeable.close:()V
        //    14: aload_2        
        //    15: ifnonnull       37
        //    18: return         
        //    19: astore_3       
        //    20: aload_3        
        //    21: astore_2       
        //    22: goto            8
        //    25: astore          4
        //    27: aload_2        
        //    28: ifnonnull       14
        //    31: aload           4
        //    33: astore_2       
        //    34: goto            14
        //    37: aload_2        
        //    38: instanceof      Ljava/io/IOException;
        //    41: ifeq            49
        //    44: aload_2        
        //    45: checkcast       Ljava/io/IOException;
        //    48: athrow         
        //    49: aload_2        
        //    50: instanceof      Ljava/lang/RuntimeException;
        //    53: ifeq            61
        //    56: aload_2        
        //    57: checkcast       Ljava/lang/RuntimeException;
        //    60: athrow         
        //    61: aload_2        
        //    62: instanceof      Ljava/lang/Error;
        //    65: ifeq            73
        //    68: aload_2        
        //    69: checkcast       Ljava/lang/Error;
        //    72: athrow         
        //    73: new             Ljava/lang/AssertionError;
        //    76: dup            
        //    77: aload_2        
        //    78: invokespecial   java/lang/AssertionError.<init>:(Ljava/lang/Object;)V
        //    81: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  2      8      19     25     Ljava/lang/Throwable;
        //  8      14     25     37     Ljava/lang/Throwable;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0008:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:314)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:235)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:120)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static void closeQuietly(final Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        }
        catch (RuntimeException ex) {
            throw ex;
        }
        catch (Exception ex2) {}
    }
    
    public static void closeQuietly(final ServerSocket serverSocket) {
        if (serverSocket == null) {
            return;
        }
        try {
            serverSocket.close();
        }
        catch (RuntimeException ex) {
            throw ex;
        }
        catch (Exception ex2) {}
    }
    
    public static void closeQuietly(final Socket socket) {
        if (socket == null) {
            return;
        }
        try {
            socket.close();
        }
        catch (RuntimeException ex) {
            throw ex;
        }
        catch (Exception ex2) {}
    }
    
    public static int copy(final InputStream inputStream, final OutputStream outputStream) throws IOException {
        int n = 0;
        final byte[] array = new byte[8192];
        while (true) {
            final int read = inputStream.read(array);
            if (read == -1) {
                break;
            }
            n += read;
            outputStream.write(array, 0, read);
        }
        return n;
    }
    
    public static ThreadFactory daemonThreadFactory(final String s) {
        return new ThreadFactory() {
            @Override
            public Thread newThread(final Runnable target) {
                final Thread thread = new Thread(target, s);
                thread.setDaemon(true);
                return thread;
            }
        };
    }
    
    public static void deleteContents(final File obj) throws IOException {
        final File[] listFiles = obj.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + obj);
        }
        for (final File obj2 : listFiles) {
            if (obj2.isDirectory()) {
                deleteContents(obj2);
            }
            if (!obj2.delete()) {
                throw new IOException("failed to delete file: " + obj2);
            }
        }
    }
    
    public static boolean equal(final Object o, final Object obj) {
        return o == obj || (o != null && o.equals(obj));
    }
    
    public static int getDefaultPort(final String s) {
        if ("http".equalsIgnoreCase(s)) {
            return 80;
        }
        if ("https".equalsIgnoreCase(s)) {
            return 443;
        }
        return -1;
    }
    
    private static int getEffectivePort(final String s, final int n) {
        if (n != -1) {
            return n;
        }
        return getDefaultPort(s);
    }
    
    public static int getEffectivePort(final URI uri) {
        return getEffectivePort(uri.getScheme(), uri.getPort());
    }
    
    public static int getEffectivePort(final URL url) {
        return getEffectivePort(url.getProtocol(), url.getPort());
    }
    
    public static String hash(final String s) {
        try {
            return bytesToHexString(MessageDigest.getInstance("MD5").digest(s.getBytes("UTF-8")));
        }
        catch (NoSuchAlgorithmException detailMessage) {
            throw new AssertionError((Object)detailMessage);
        }
        catch (UnsupportedEncodingException detailMessage2) {
            throw new AssertionError((Object)detailMessage2);
        }
    }
    
    public static <T> List<T> immutableList(final List<T> c) {
        return Collections.unmodifiableList((List<? extends T>)new ArrayList<T>((Collection<? extends T>)c));
    }
    
    public static void pokeInt(final byte[] array, final int n, final int n2, final ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            final int n3 = n + 1;
            array[n] = (byte)(0xFF & n2 >> 24);
            final int n4 = n3 + 1;
            array[n3] = (byte)(0xFF & n2 >> 16);
            final int n5 = n4 + 1;
            array[n4] = (byte)(0xFF & n2 >> 8);
            array[n5] = (byte)(0xFF & n2 >> 0);
            return;
        }
        final int n6 = n + 1;
        array[n] = (byte)(0xFF & n2 >> 0);
        final int n7 = n6 + 1;
        array[n6] = (byte)(0xFF & n2 >> 8);
        final int n8 = n7 + 1;
        array[n7] = (byte)(0xFF & n2 >> 16);
        array[n8] = (byte)(0xFF & n2 >> 24);
    }
    
    public static String readAsciiLine(final InputStream inputStream) throws IOException {
        final StringBuilder sb = new StringBuilder(80);
        while (true) {
            final int read = inputStream.read();
            if (read == -1) {
                throw new EOFException();
            }
            if (read == 10) {
                final int length = sb.length();
                if (length > 0 && sb.charAt(length - 1) == '\r') {
                    sb.setLength(length - 1);
                }
                return sb.toString();
            }
            sb.append((char)read);
        }
    }
    
    public static String readFully(final Reader reader) throws IOException {
        try {
            final StringWriter stringWriter = new StringWriter();
            final char[] array = new char[1024];
            while (true) {
                final int read = reader.read(array);
                if (read == -1) {
                    break;
                }
                stringWriter.write(array, 0, read);
            }
            return stringWriter.toString();
        }
        finally {
            reader.close();
        }
    }
    
    public static void readFully(final InputStream inputStream, final byte[] array) throws IOException {
        readFully(inputStream, array, 0, array.length);
    }
    
    public static void readFully(final InputStream inputStream, final byte[] b, int off, int i) throws IOException {
        if (i != 0) {
            if (inputStream == null) {
                throw new NullPointerException("in == null");
            }
            if (b == null) {
                throw new NullPointerException("dst == null");
            }
            checkOffsetAndCount(b.length, off, i);
            while (i > 0) {
                final int read = inputStream.read(b, off, i);
                if (read < 0) {
                    throw new EOFException();
                }
                off += read;
                i -= read;
            }
        }
    }
    
    public static int readSingleByte(final InputStream inputStream) throws IOException {
        int n = -1;
        final byte[] b = { 0 };
        if (inputStream.read(b, 0, 1) != n) {
            n = (0xFF & b[0]);
        }
        return n;
    }
    
    public static void skipAll(final InputStream inputStream) throws IOException {
        do {
            inputStream.skip(Long.MAX_VALUE);
        } while (inputStream.read() != -1);
    }
    
    public static long skipByReading(final InputStream inputStream, final long n) throws IOException {
        if (n == 0L) {
            return 0L;
        }
        byte[] array = Util.skipBuffer.getAndSet(null);
        if (array == null) {
            array = new byte[4096];
        }
        long n2 = 0L;
        while (n2 < n) {
            final int len = (int)Math.min(n - n2, array.length);
            final int read = inputStream.read(array, 0, len);
            if (read == -1) {
                break;
            }
            n2 += read;
            if (read < len) {
                break;
            }
        }
        Util.skipBuffer.set(array);
        return n2;
    }
    
    public static void writeSingleByte(final OutputStream outputStream, final int n) throws IOException {
        outputStream.write(new byte[] { (byte)(n & 0xFF) });
    }
}
