// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a.a;

import java.io.FileOutputStream;
import com.a.a.c;
import java.io.EOFException;
import java.util.HashMap;
import java.util.Collections;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import android.os.SystemClock;
import com.a.a.y;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.io.File;
import java.util.Map;
import com.a.a.b;

public class c implements b
{
    private final Map<String, d> a;
    private long b;
    private final File c;
    private final int d;
    
    public c(final File c, final int d) {
        this.a = new LinkedHashMap<String, d>(16, 0.75f, true);
        this.b = 0L;
        this.c = c;
        this.d = d;
    }
    
    static int a(final InputStream inputStream) {
        return 0x0 | e(inputStream) << 0 | e(inputStream) << 8 | e(inputStream) << 16 | e(inputStream) << 24;
    }
    
    private void a(final int n) {
        if (this.b + n >= this.d) {
            if (y.b) {
                y.a("Pruning old cache entries.", new Object[0]);
            }
            final long b = this.b;
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            final Iterator<Map.Entry<String, d>> iterator = this.a.entrySet().iterator();
            int n2 = 0;
            while (true) {
                while (iterator.hasNext()) {
                    final d d = iterator.next().getValue();
                    if (this.c(d.b).delete()) {
                        this.b -= d.a;
                    }
                    else {
                        y.b("Could not delete cache entry for key=%s, filename=%s", d.b, this.d(d.b));
                    }
                    iterator.remove();
                    final int i = n2 + 1;
                    if (this.b + n < 0.9f * this.d) {
                        if (y.b) {
                            y.a("pruned %d files, %d bytes, %d ms", i, this.b - b, SystemClock.elapsedRealtime() - elapsedRealtime);
                        }
                        return;
                    }
                    else {
                        n2 = i;
                    }
                }
                final int i = n2;
                continue;
            }
        }
    }
    
    static void a(final OutputStream outputStream, final int n) {
        outputStream.write(0xFF & n >> 0);
        outputStream.write(0xFF & n >> 8);
        outputStream.write(0xFF & n >> 16);
        outputStream.write(0xFF & n >> 24);
    }
    
    static void a(final OutputStream outputStream, final long n) {
        outputStream.write((byte)(n >>> 0));
        outputStream.write((byte)(n >>> 8));
        outputStream.write((byte)(n >>> 16));
        outputStream.write((byte)(n >>> 24));
        outputStream.write((byte)(n >>> 32));
        outputStream.write((byte)(n >>> 40));
        outputStream.write((byte)(n >>> 48));
        outputStream.write((byte)(n >>> 56));
    }
    
    static void a(final OutputStream outputStream, final String s) {
        final byte[] bytes = s.getBytes("UTF-8");
        a(outputStream, (long)bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }
    
    private void a(final String s, final d d) {
        if (!this.a.containsKey(s)) {
            this.b += d.a;
        }
        else {
            this.b += d.a - this.a.get(s).a;
        }
        this.a.put(s, d);
    }
    
    static void a(final Map<String, String> map, final OutputStream outputStream) {
        if (map != null) {
            a(outputStream, map.size());
            for (final Map.Entry<String, String> entry : map.entrySet()) {
                a(outputStream, entry.getKey());
                a(outputStream, entry.getValue());
            }
        }
        else {
            a(outputStream, 0);
        }
    }
    
    private static byte[] a(final InputStream inputStream, final int i) {
        final byte[] b = new byte[i];
        int j;
        int read;
        for (j = 0; j < i; j += read) {
            read = inputStream.read(b, j, i - j);
            if (read == -1) {
                break;
            }
        }
        if (j != i) {
            throw new IOException("Expected " + i + " bytes, read " + j + " bytes");
        }
        return b;
    }
    
    static long b(final InputStream inputStream) {
        return 0x0L | (0xFFL & e(inputStream)) << 0 | (0xFFL & e(inputStream)) << 8 | (0xFFL & e(inputStream)) << 16 | (0xFFL & e(inputStream)) << 24 | (0xFFL & e(inputStream)) << 32 | (0xFFL & e(inputStream)) << 40 | (0xFFL & e(inputStream)) << 48 | (0xFFL & e(inputStream)) << 56;
    }
    
    static String c(final InputStream inputStream) {
        return new String(a(inputStream, (int)b(inputStream)), "UTF-8");
    }
    
    private String d(final String s) {
        final int n = s.length() / 2;
        return String.valueOf(s.substring(0, n).hashCode()) + String.valueOf(s.substring(n).hashCode());
    }
    
    static Map<String, String> d(final InputStream inputStream) {
        final int a = a(inputStream);
        Map<String, String> emptyMap;
        if (a == 0) {
            emptyMap = Collections.emptyMap();
        }
        else {
            emptyMap = new HashMap<String, String>(a);
        }
        for (int i = 0; i < a; ++i) {
            emptyMap.put(c(inputStream).intern(), c(inputStream).intern());
        }
        return emptyMap;
    }
    
    private static int e(final InputStream inputStream) {
        final int read = inputStream.read();
        if (read == -1) {
            throw new EOFException();
        }
        return read;
    }
    
    private void e(final String s) {
        final d d = this.a.get(s);
        if (d != null) {
            this.b -= d.a;
            this.a.remove(s);
        }
    }
    
    @Override
    public com.a.a.c a(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: monitorenter   
        //     2: aload_0        
        //     3: getfield        com/a/a/a/c.a:Ljava/util/Map;
        //     6: aload_1        
        //     7: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    12: checkcast       Lcom/a/a/a/d;
        //    15: astore_3       
        //    16: aload_3        
        //    17: ifnonnull       28
        //    20: aconst_null    
        //    21: astore          9
        //    23: aload_0        
        //    24: monitorexit    
        //    25: aload           9
        //    27: areturn        
        //    28: aload_0        
        //    29: aload_1        
        //    30: invokevirtual   com/a/a/a/c.c:(Ljava/lang/String;)Ljava/io/File;
        //    33: astore          4
        //    35: new             Lcom/a/a/a/e;
        //    38: dup            
        //    39: new             Ljava/io/FileInputStream;
        //    42: dup            
        //    43: aload           4
        //    45: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    48: aconst_null    
        //    49: invokespecial   com/a/a/a/e.<init>:(Ljava/io/InputStream;Lcom/a/a/a/c$1;)V
        //    52: astore          5
        //    54: aload           5
        //    56: invokestatic    com/a/a/a/d.a:(Ljava/io/InputStream;)Lcom/a/a/a/d;
        //    59: pop            
        //    60: aload_3        
        //    61: aload           5
        //    63: aload           4
        //    65: invokevirtual   java/io/File.length:()J
        //    68: aload           5
        //    70: invokestatic    com/a/a/a/e.a:(Lcom/a/a/a/e;)I
        //    73: i2l            
        //    74: lsub           
        //    75: l2i            
        //    76: invokestatic    com/a/a/a/c.a:(Ljava/io/InputStream;I)[B
        //    79: invokevirtual   com/a/a/a/d.a:([B)Lcom/a/a/c;
        //    82: astore          13
        //    84: aload           13
        //    86: astore          9
        //    88: aload           5
        //    90: ifnull          23
        //    93: aload           5
        //    95: invokevirtual   com/a/a/a/e.close:()V
        //    98: goto            23
        //   101: astore          14
        //   103: aconst_null    
        //   104: astore          9
        //   106: goto            23
        //   109: astore          6
        //   111: aconst_null    
        //   112: astore          5
        //   114: iconst_2       
        //   115: anewarray       Ljava/lang/Object;
        //   118: astore          10
        //   120: aload           10
        //   122: iconst_0       
        //   123: aload           4
        //   125: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //   128: aastore        
        //   129: aload           10
        //   131: iconst_1       
        //   132: aload           6
        //   134: invokevirtual   java/io/IOException.toString:()Ljava/lang/String;
        //   137: aastore        
        //   138: ldc_w           "%s: %s"
        //   141: aload           10
        //   143: invokestatic    com/a/a/y.b:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   146: aload_0        
        //   147: aload_1        
        //   148: invokevirtual   com/a/a/a/c.b:(Ljava/lang/String;)V
        //   151: aload           5
        //   153: ifnull          161
        //   156: aload           5
        //   158: invokevirtual   com/a/a/a/e.close:()V
        //   161: aconst_null    
        //   162: astore          9
        //   164: goto            23
        //   167: astore          11
        //   169: aconst_null    
        //   170: astore          9
        //   172: goto            23
        //   175: astore          7
        //   177: aconst_null    
        //   178: astore          5
        //   180: aload           5
        //   182: ifnull          190
        //   185: aload           5
        //   187: invokevirtual   com/a/a/a/e.close:()V
        //   190: aload           7
        //   192: athrow         
        //   193: astore_2       
        //   194: aload_0        
        //   195: monitorexit    
        //   196: aload_2        
        //   197: athrow         
        //   198: astore          8
        //   200: aconst_null    
        //   201: astore          9
        //   203: goto            23
        //   206: astore          7
        //   208: goto            180
        //   211: astore          6
        //   213: goto            114
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  2      16     193    198    Any
        //  28     35     193    198    Any
        //  35     54     109    114    Ljava/io/IOException;
        //  35     54     175    180    Any
        //  54     84     211    216    Ljava/io/IOException;
        //  54     84     206    211    Any
        //  93     98     101    109    Ljava/io/IOException;
        //  93     98     193    198    Any
        //  114    151    206    211    Any
        //  156    161    167    175    Ljava/io/IOException;
        //  156    161    193    198    Any
        //  185    190    198    206    Ljava/io/IOException;
        //  185    190    193    198    Any
        //  190    193    193    198    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0114:
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
    
    @Override
    public void a() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: monitorenter   
        //     2: aload_0        
        //     3: getfield        com/a/a/a/c.c:Ljava/io/File;
        //     6: invokevirtual   java/io/File.exists:()Z
        //     9: ifne            50
        //    12: aload_0        
        //    13: getfield        com/a/a/a/c.c:Ljava/io/File;
        //    16: invokevirtual   java/io/File.mkdirs:()Z
        //    19: ifne            47
        //    22: iconst_1       
        //    23: anewarray       Ljava/lang/Object;
        //    26: astore          17
        //    28: aload           17
        //    30: iconst_0       
        //    31: aload_0        
        //    32: getfield        com/a/a/a/c.c:Ljava/io/File;
        //    35: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //    38: aastore        
        //    39: ldc_w           "Unable to create cache dir %s"
        //    42: aload           17
        //    44: invokestatic    com/a/a/y.c:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    47: aload_0        
        //    48: monitorexit    
        //    49: return         
        //    50: aload_0        
        //    51: getfield        com/a/a/a/c.c:Ljava/io/File;
        //    54: invokevirtual   java/io/File.listFiles:()[Ljava/io/File;
        //    57: astore_2       
        //    58: aload_2        
        //    59: ifnull          47
        //    62: aload_2        
        //    63: arraylength    
        //    64: istore_3       
        //    65: iconst_0       
        //    66: istore          4
        //    68: iload           4
        //    70: iload_3        
        //    71: if_icmpge       47
        //    74: aload_2        
        //    75: iload           4
        //    77: aaload         
        //    78: astore          5
        //    80: aconst_null    
        //    81: astore          6
        //    83: new             Ljava/io/FileInputStream;
        //    86: dup            
        //    87: aload           5
        //    89: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    92: astore          7
        //    94: aload           7
        //    96: invokestatic    com/a/a/a/d.a:(Ljava/io/InputStream;)Lcom/a/a/a/d;
        //    99: astore          14
        //   101: aload           14
        //   103: aload           5
        //   105: invokevirtual   java/io/File.length:()J
        //   108: putfield        com/a/a/a/d.a:J
        //   111: aload_0        
        //   112: aload           14
        //   114: getfield        com/a/a/a/d.b:Ljava/lang/String;
        //   117: aload           14
        //   119: invokespecial   com/a/a/a/c.a:(Ljava/lang/String;Lcom/a/a/a/d;)V
        //   122: aload           7
        //   124: ifnull          132
        //   127: aload           7
        //   129: invokevirtual   java/io/FileInputStream.close:()V
        //   132: iinc            4, 1
        //   135: goto            68
        //   138: astore          16
        //   140: aconst_null    
        //   141: astore          7
        //   143: aload           5
        //   145: ifnull          154
        //   148: aload           5
        //   150: invokevirtual   java/io/File.delete:()Z
        //   153: pop            
        //   154: aload           7
        //   156: ifnull          132
        //   159: aload           7
        //   161: invokevirtual   java/io/FileInputStream.close:()V
        //   164: goto            132
        //   167: astore          9
        //   169: goto            132
        //   172: astore          11
        //   174: aload           6
        //   176: ifnull          184
        //   179: aload           6
        //   181: invokevirtual   java/io/FileInputStream.close:()V
        //   184: aload           11
        //   186: athrow         
        //   187: astore_1       
        //   188: aload_0        
        //   189: monitorexit    
        //   190: aload_1        
        //   191: athrow         
        //   192: astore          15
        //   194: goto            132
        //   197: astore          12
        //   199: goto            184
        //   202: astore          10
        //   204: aload           7
        //   206: astore          6
        //   208: aload           10
        //   210: astore          11
        //   212: goto            174
        //   215: astore          8
        //   217: goto            143
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  2      47     187    192    Any
        //  50     58     187    192    Any
        //  62     65     187    192    Any
        //  74     80     187    192    Any
        //  83     94     138    143    Ljava/io/IOException;
        //  83     94     172    174    Any
        //  94     122    215    220    Ljava/io/IOException;
        //  94     122    202    215    Any
        //  127    132    192    197    Ljava/io/IOException;
        //  127    132    187    192    Any
        //  148    154    202    215    Any
        //  159    164    167    172    Ljava/io/IOException;
        //  159    164    187    192    Any
        //  179    184    197    202    Ljava/io/IOException;
        //  179    184    187    192    Any
        //  184    187    187    192    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0132:
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
    
    @Override
    public void a(final String s, final com.a.a.c c) {
        synchronized (this) {
            this.a(c.a.length);
            final File c2 = this.c(s);
            try {
                final FileOutputStream fileOutputStream = new FileOutputStream(c2);
                final d d = new d(s, c);
                d.a(fileOutputStream);
                fileOutputStream.write(c.a);
                fileOutputStream.close();
                this.a(s, d);
            }
            catch (IOException ex) {
                if (!c2.delete()) {
                    y.b("Could not clean up file %s", c2.getAbsolutePath());
                }
            }
        }
    }
    
    public void b(final String s) {
        synchronized (this) {
            final boolean delete = this.c(s).delete();
            this.e(s);
            if (!delete) {
                y.b("Could not delete cache entry for key=%s, filename=%s", s, this.d(s));
            }
        }
    }
    
    public File c(final String s) {
        return new File(this.c, this.d(s));
    }
}
