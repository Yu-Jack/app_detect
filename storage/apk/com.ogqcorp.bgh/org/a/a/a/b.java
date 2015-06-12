// 
// Decompiled by Procyon v0.5.29
// 

package org.a.a.a;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.io.File;
import java.math.BigInteger;

public class b
{
    public static final BigInteger a;
    public static final BigInteger b;
    public static final BigInteger c;
    public static final BigInteger d;
    public static final BigInteger e;
    public static final BigInteger f;
    public static final BigInteger g;
    public static final BigInteger h;
    public static final File[] i;
    private static final Charset j;
    
    static {
        a = BigInteger.valueOf(1024L);
        b = org.a.a.a.b.a.multiply(org.a.a.a.b.a);
        c = org.a.a.a.b.a.multiply(org.a.a.a.b.b);
        d = org.a.a.a.b.a.multiply(org.a.a.a.b.c);
        e = org.a.a.a.b.a.multiply(org.a.a.a.b.d);
        f = org.a.a.a.b.a.multiply(org.a.a.a.b.e);
        g = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
        h = org.a.a.a.b.a.multiply(org.a.a.a.b.g);
        i = new File[0];
        j = Charset.forName("UTF-8");
    }
    
    public static FileInputStream a(final File file) {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        }
        if (!file.canRead()) {
            throw new IOException("File '" + file + "' cannot be read");
        }
        return new FileInputStream(file);
    }
    
    public static FileOutputStream a(final File file, final boolean append) {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canWrite()) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        }
        else {
            final File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
        }
        return new FileOutputStream(file, append);
    }
    
    public static void a(final File file, final File file2) {
        a(file, file2, true);
    }
    
    public static void a(final File obj, final File file, final boolean b) {
        if (obj == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!obj.exists()) {
            throw new FileNotFoundException("Source '" + obj + "' does not exist");
        }
        if (obj.isDirectory()) {
            throw new IOException("Source '" + obj + "' exists but is a directory");
        }
        if (obj.getCanonicalPath().equals(file.getCanonicalPath())) {
            throw new IOException("Source '" + obj + "' and destination '" + file + "' are the same");
        }
        final File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new IOException("Destination '" + parentFile + "' directory cannot be created");
        }
        if (file.exists() && !file.canWrite()) {
            throw new IOException("Destination '" + file + "' exists but is read-only");
        }
        b(obj, file, b);
    }
    
    public static void a(final File file, final byte[] array) {
        a(file, array, false);
    }
    
    public static void a(final File file, final byte[] b, final boolean b2) {
        OutputStream a = null;
        try {
            a = a(file, b2);
            a.write(b);
            a.close();
        }
        finally {
            org.a.a.a.d.a(a);
        }
    }
    
    public static void b(final File obj) {
        if (obj.exists()) {
            if (!h(obj)) {
                c(obj);
            }
            if (!obj.delete()) {
                throw new IOException("Unable to delete directory " + obj + ".");
            }
        }
    }
    
    private static void b(final File p0, final File p1, final boolean p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_3       
        //     2: aload_1        
        //     3: invokevirtual   java/io/File.exists:()Z
        //     6: ifeq            48
        //     9: aload_1        
        //    10: invokevirtual   java/io/File.isDirectory:()Z
        //    13: ifeq            48
        //    16: new             Ljava/io/IOException;
        //    19: dup            
        //    20: new             Ljava/lang/StringBuilder;
        //    23: dup            
        //    24: invokespecial   java/lang/StringBuilder.<init>:()V
        //    27: ldc             "Destination '"
        //    29: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    32: aload_1        
        //    33: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    36: ldc             "' exists but is a directory"
        //    38: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    41: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    44: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //    47: athrow         
        //    48: new             Ljava/io/FileInputStream;
        //    51: dup            
        //    52: aload_0        
        //    53: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    56: astore          4
        //    58: new             Ljava/io/FileOutputStream;
        //    61: dup            
        //    62: aload_1        
        //    63: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //    66: astore          5
        //    68: aload           4
        //    70: invokevirtual   java/io/FileInputStream.getChannel:()Ljava/nio/channels/FileChannel;
        //    73: astore          10
        //    75: aload           5
        //    77: invokevirtual   java/io/FileOutputStream.getChannel:()Ljava/nio/channels/FileChannel;
        //    80: astore          11
        //    82: aload           10
        //    84: invokevirtual   java/nio/channels/FileChannel.size:()J
        //    87: lstore          13
        //    89: lconst_0       
        //    90: lstore          15
        //    92: goto            326
        //    95: aload           11
        //    97: aload           10
        //    99: lload           15
        //   101: lload           18
        //   103: invokevirtual   java/nio/channels/FileChannel.transferFrom:(Ljava/nio/channels/ReadableByteChannel;JJ)J
        //   106: lstore          20
        //   108: lload           15
        //   110: lload           20
        //   112: ladd           
        //   113: lstore          15
        //   115: goto            326
        //   118: lload           13
        //   120: lload           15
        //   122: lsub           
        //   123: lstore          18
        //   125: goto            95
        //   128: aload           11
        //   130: invokestatic    org/a/a/a/d.a:(Ljava/io/Closeable;)V
        //   133: aload           5
        //   135: invokestatic    org/a/a/a/d.a:(Ljava/io/OutputStream;)V
        //   138: aload           10
        //   140: invokestatic    org/a/a/a/d.a:(Ljava/io/Closeable;)V
        //   143: aload           4
        //   145: invokestatic    org/a/a/a/d.a:(Ljava/io/InputStream;)V
        //   148: aload_0        
        //   149: invokevirtual   java/io/File.length:()J
        //   152: aload_1        
        //   153: invokevirtual   java/io/File.length:()J
        //   156: lcmp           
        //   157: ifeq            234
        //   160: new             Ljava/io/IOException;
        //   163: dup            
        //   164: new             Ljava/lang/StringBuilder;
        //   167: dup            
        //   168: invokespecial   java/lang/StringBuilder.<init>:()V
        //   171: ldc             "Failed to copy full contents from '"
        //   173: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   176: aload_0        
        //   177: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   180: ldc             "' to '"
        //   182: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   185: aload_1        
        //   186: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   189: ldc             "'"
        //   191: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   194: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   197: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   200: athrow         
        //   201: astore          6
        //   203: aconst_null    
        //   204: astore          9
        //   206: aconst_null    
        //   207: astore          7
        //   209: aconst_null    
        //   210: astore          8
        //   212: aload           9
        //   214: invokestatic    org/a/a/a/d.a:(Ljava/io/Closeable;)V
        //   217: aload           7
        //   219: invokestatic    org/a/a/a/d.a:(Ljava/io/OutputStream;)V
        //   222: aload_3        
        //   223: invokestatic    org/a/a/a/d.a:(Ljava/io/Closeable;)V
        //   226: aload           8
        //   228: invokestatic    org/a/a/a/d.a:(Ljava/io/InputStream;)V
        //   231: aload           6
        //   233: athrow         
        //   234: iload_2        
        //   235: ifeq            247
        //   238: aload_1        
        //   239: aload_0        
        //   240: invokevirtual   java/io/File.lastModified:()J
        //   243: invokevirtual   java/io/File.setLastModified:(J)Z
        //   246: pop            
        //   247: return         
        //   248: astore          6
        //   250: aload           4
        //   252: astore          8
        //   254: aconst_null    
        //   255: astore          9
        //   257: aconst_null    
        //   258: astore_3       
        //   259: aconst_null    
        //   260: astore          7
        //   262: goto            212
        //   265: astore          6
        //   267: aload           5
        //   269: astore          7
        //   271: aload           4
        //   273: astore          8
        //   275: aconst_null    
        //   276: astore          9
        //   278: aconst_null    
        //   279: astore_3       
        //   280: goto            212
        //   283: astore          6
        //   285: aload           5
        //   287: astore          7
        //   289: aload           4
        //   291: astore          8
        //   293: aload           10
        //   295: astore_3       
        //   296: aconst_null    
        //   297: astore          9
        //   299: goto            212
        //   302: astore          12
        //   304: aload           5
        //   306: astore          7
        //   308: aload           4
        //   310: astore          8
        //   312: aload           11
        //   314: astore          9
        //   316: aload           12
        //   318: astore          6
        //   320: aload           10
        //   322: astore_3       
        //   323: goto            212
        //   326: lload           15
        //   328: lload           13
        //   330: lcmp           
        //   331: ifge            128
        //   334: lload           13
        //   336: lload           15
        //   338: lsub           
        //   339: ldc2_w          31457280
        //   342: lcmp           
        //   343: ifle            118
        //   346: ldc2_w          31457280
        //   349: lstore          18
        //   351: goto            95
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  48     58     201    212    Any
        //  58     68     248    265    Any
        //  68     75     265    283    Any
        //  75     82     283    302    Any
        //  82     89     302    326    Any
        //  95     108    302    326    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 172, Size: 172
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:635)
        //     at java.util.ArrayList.get(ArrayList.java:411)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3305)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:114)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:210)
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
    
    public static void c(final File obj) {
        if (!obj.exists()) {
            throw new IllegalArgumentException(obj + " does not exist");
        }
        if (!obj.isDirectory()) {
            throw new IllegalArgumentException(obj + " is not a directory");
        }
        final File[] listFiles = obj.listFiles();
        if (listFiles == null) {
            throw new IOException("Failed to list contents of " + obj);
        }
        final int length = listFiles.length;
        final IOException ex = null;
        int n = 0;
        File file;
        Label_0129_Outer:Label_0135_Outer:
        while (true) {
            while (true) {
                if (n < length) {
                    file = listFiles[n];
                    while (true) {
                        try {
                            e(file);
                            ++n;
                            continue Label_0129_Outer;
                            // iftrue(Label_0145:, ex == null)
                            throw ex;
                        }
                        catch (IOException ex) {
                            continue Label_0135_Outer;
                        }
                        break;
                    }
                    break;
                }
                continue;
            }
        }
        Label_0145:;
    }
    
    public static byte[] d(final File file) {
        InputStream a = null;
        try {
            a = a(file);
            return org.a.a.a.d.a(a, file.length());
        }
        finally {
            org.a.a.a.d.a(a);
        }
    }
    
    public static void e(final File file) {
        if (file.isDirectory()) {
            b(file);
        }
        else {
            final boolean exists = file.exists();
            if (!file.delete()) {
                if (!exists) {
                    throw new FileNotFoundException("File does not exist: " + file);
                }
                throw new IOException("Unable to delete file: " + file);
            }
        }
    }
    
    public static long f(final File obj) {
        if (!obj.exists()) {
            throw new IllegalArgumentException(obj + " does not exist");
        }
        if (obj.isDirectory()) {
            return g(obj);
        }
        return obj.length();
    }
    
    public static long g(final File file) {
        i(file);
        final File[] listFiles = file.listFiles();
        long n;
        if (listFiles == null) {
            n = 0L;
        }
        else {
            final int length = listFiles.length;
            int i = 0;
            n = 0L;
            while (i < length) {
                final File file2 = listFiles[i];
                while (true) {
                    try {
                        if (!h(file2)) {
                            n += f(file2);
                            if (n < 0L) {
                                break;
                            }
                        }
                        ++i;
                    }
                    catch (IOException ex) {
                        continue;
                    }
                    break;
                }
            }
        }
        return n;
    }
    
    public static boolean h(File file) {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        }
        if (org.a.a.a.c.a()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }
    
    private static void i(final File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
    }
}
