// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons;

import java.io.InputStream;
import org.a.a.a.d;
import java.nio.charset.Charset;
import android.content.Context;
import java.io.File;

public class f extends e
{
    private boolean a(final File file, final long n) {
        return file.exists() && file.length() != 0L && Math.abs(System.currentTimeMillis() - file.lastModified()) <= n;
    }
    
    private File b(final Context context, final String child) {
        return new File(context.getFilesDir(), child);
    }
    
    public String a(final Context context, final String s, final long n, final String s2) {
        return this.a(context, s, n, s2, 10000);
    }
    
    public String a(final Context context, final String s, final long n, final String s2, final int n2) {
        return this.a(context, s, n, s2, n2, f.a);
    }
    
    public String a(final Context context, final String s, final long n, final String s2, final int n2, final Charset charset) {
        return d.a(this.b(context, s, n, s2, n2), charset);
    }
    
    public void a(final Context context, final String s) {
        this.b(context, s).delete();
    }
    
    public InputStream b(final Context p0, final String p1, final long p2, final String p3, final int p4) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore          7
        //     3: aload_0        
        //     4: aload_1        
        //     5: aload_2        
        //     6: invokespecial   com/ogqcorp/commons/f.b:(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
        //     9: astore          8
        //    11: aload_0        
        //    12: aload           8
        //    14: lload_3        
        //    15: invokespecial   com/ogqcorp/commons/f.a:(Ljava/io/File;J)Z
        //    18: ifne            70
        //    21: new             Ljava/io/BufferedInputStream;
        //    24: dup            
        //    25: aload_0        
        //    26: aload           5
        //    28: iload           6
        //    30: invokevirtual   com/ogqcorp/commons/f.b:(Ljava/lang/String;I)Ljava/io/InputStream;
        //    33: sipush          30720
        //    36: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;I)V
        //    39: astore          9
        //    41: new             Ljava/io/FileOutputStream;
        //    44: dup            
        //    45: aload           8
        //    47: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //    50: astore          10
        //    52: aload           9
        //    54: aload           10
        //    56: invokestatic    org/a/a/a/d.a:(Ljava/io/InputStream;Ljava/io/OutputStream;)J
        //    59: pop2           
        //    60: aload           10
        //    62: invokevirtual   java/io/FileOutputStream.close:()V
        //    65: aload           9
        //    67: invokevirtual   java/io/BufferedInputStream.close:()V
        //    70: new             Ljava/io/FileInputStream;
        //    73: dup            
        //    74: aload           8
        //    76: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    79: areturn        
        //    80: astore          11
        //    82: aconst_null    
        //    83: astore          10
        //    85: aload           11
        //    87: invokestatic    com/ogqcorp/commons/n.c:(Ljava/lang/Throwable;)I
        //    90: pop            
        //    91: aload           10
        //    93: invokevirtual   java/io/FileOutputStream.close:()V
        //    96: aload           7
        //    98: invokevirtual   java/io/BufferedInputStream.close:()V
        //   101: goto            70
        //   104: astore          17
        //   106: goto            70
        //   109: astore          12
        //   111: aconst_null    
        //   112: astore          9
        //   114: aload           7
        //   116: invokevirtual   java/io/FileOutputStream.close:()V
        //   119: aload           9
        //   121: invokevirtual   java/io/BufferedInputStream.close:()V
        //   124: aload           12
        //   126: athrow         
        //   127: astore          20
        //   129: goto            65
        //   132: astore          21
        //   134: goto            70
        //   137: astore          16
        //   139: goto            96
        //   142: astore          13
        //   144: goto            119
        //   147: astore          14
        //   149: goto            124
        //   152: astore          12
        //   154: aconst_null    
        //   155: astore          7
        //   157: goto            114
        //   160: astore          12
        //   162: aload           10
        //   164: astore          7
        //   166: goto            114
        //   169: astore          12
        //   171: aload           7
        //   173: astore          9
        //   175: aload           10
        //   177: astore          7
        //   179: goto            114
        //   182: astore          11
        //   184: aload           9
        //   186: astore          7
        //   188: aconst_null    
        //   189: astore          10
        //   191: goto            85
        //   194: astore          11
        //   196: aload           9
        //   198: astore          7
        //   200: goto            85
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  21     41     80     85     Ljava/lang/Exception;
        //  21     41     109    114    Any
        //  41     52     182    194    Ljava/lang/Exception;
        //  41     52     152    160    Any
        //  52     60     194    203    Ljava/lang/Exception;
        //  52     60     160    169    Any
        //  60     65     127    132    Ljava/lang/Exception;
        //  65     70     132    137    Ljava/lang/Exception;
        //  85     91     169    182    Any
        //  91     96     137    142    Ljava/lang/Exception;
        //  96     101    104    109    Ljava/lang/Exception;
        //  114    119    142    147    Ljava/lang/Exception;
        //  119    124    147    152    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 95, Size: 95
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:635)
        //     at java.util.ArrayList.get(ArrayList.java:411)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3305)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3419)
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
}
