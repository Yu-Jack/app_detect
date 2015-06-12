// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.e;

import com.ogqcorp.bgh.system.l;
import com.ogqcorp.bgh.system.u;
import com.ogqcorp.bgh.system.v;
import java.util.HashMap;
import android.content.Context;

public final class d implements f
{
    private static double a(final String s) {
        return 1000.0 * (a(s, 1000) / (System.currentTimeMillis() - System.currentTimeMillis()));
    }
    
    private static long a(final String p0, final int p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_2       
        //     2: lconst_0       
        //     3: lstore_3       
        //     4: invokestatic    java/lang/System.currentTimeMillis:()J
        //     7: lstore          16
        //     9: new             Ljava/net/URL;
        //    12: dup            
        //    13: aload_0        
        //    14: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //    17: invokevirtual   java/net/URL.openConnection:()Ljava/net/URLConnection;
        //    20: checkcast       Ljava/net/HttpURLConnection;
        //    23: astore          18
        //    25: aload           18
        //    27: iload_1        
        //    28: iconst_3       
        //    29: imul           
        //    30: invokevirtual   java/net/HttpURLConnection.setReadTimeout:(I)V
        //    33: aload           18
        //    35: iload_1        
        //    36: iconst_3       
        //    37: imul           
        //    38: invokevirtual   java/net/HttpURLConnection.setConnectTimeout:(I)V
        //    41: new             Ljava/io/BufferedInputStream;
        //    44: dup            
        //    45: aload           18
        //    47: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
        //    50: sipush          8192
        //    53: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;I)V
        //    56: astore          8
        //    58: sipush          4096
        //    61: newarray        B
        //    63: astore          20
        //    65: aload           8
        //    67: aload           20
        //    69: invokevirtual   java/io/BufferedInputStream.read:([B)I
        //    72: istore          21
        //    74: iload           21
        //    76: iconst_m1      
        //    77: if_icmpne       91
        //    80: lload_3        
        //    81: lstore          24
        //    83: aload           8
        //    85: invokevirtual   java/io/BufferedInputStream.close:()V
        //    88: lload           24
        //    90: lreturn        
        //    91: lload_3        
        //    92: iload           21
        //    94: i2l            
        //    95: ladd           
        //    96: lstore_3       
        //    97: invokestatic    java/lang/System.currentTimeMillis:()J
        //   100: lstore          22
        //   102: lload           22
        //   104: lload           16
        //   106: lsub           
        //   107: iload_1        
        //   108: i2l            
        //   109: lcmp           
        //   110: ifle            65
        //   113: lload_3        
        //   114: lstore          24
        //   116: goto            83
        //   119: astore          7
        //   121: aconst_null    
        //   122: astore          8
        //   124: lload_3        
        //   125: lstore          9
        //   127: aload           7
        //   129: astore          11
        //   131: lload           9
        //   133: lstore          12
        //   135: aload           11
        //   137: invokestatic    com/ogqcorp/bgh/system/l.c:(Ljava/lang/Throwable;)I
        //   140: pop            
        //   141: aload           8
        //   143: invokevirtual   java/io/BufferedInputStream.close:()V
        //   146: lload           12
        //   148: lreturn        
        //   149: astore          15
        //   151: lload           12
        //   153: lreturn        
        //   154: astore          5
        //   156: aload_2        
        //   157: invokevirtual   java/io/BufferedInputStream.close:()V
        //   160: aload           5
        //   162: athrow         
        //   163: astore          26
        //   165: lload           24
        //   167: lreturn        
        //   168: astore          6
        //   170: goto            160
        //   173: astore          5
        //   175: aload           8
        //   177: astore_2       
        //   178: goto            156
        //   181: astore          19
        //   183: lload_3        
        //   184: lstore          12
        //   186: aload           19
        //   188: astore          11
        //   190: goto            135
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  4      58     119    135    Ljava/lang/Exception;
        //  4      58     154    156    Any
        //  58     65     181    193    Ljava/lang/Exception;
        //  58     65     173    181    Any
        //  65     74     181    193    Ljava/lang/Exception;
        //  65     74     173    181    Any
        //  83     88     163    168    Ljava/lang/Exception;
        //  97     102    181    193    Ljava/lang/Exception;
        //  97     102    173    181    Any
        //  135    141    173    181    Any
        //  141    146    149    154    Ljava/lang/Exception;
        //  156    160    168    173    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0065:
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
    public CharSequence a(final Context context) {
        return context.getString(2131427446, new Object[] { 0 });
    }
    
    @Override
    public void a(final Context context, final a a, final HashMap<String, Object> hashMap) {
        if (v.a().f(context) != null) {
            return;
        }
        final double[] array = { 0.0, 0.0 };
        final String[] array2 = { "summer", "summer" };
        try {
            final String[] b = u.b;
            for (int i = 0; i < b.length; ++i) {
                final String str = b[i];
                final double a2 = a("http://" + str + ".bghcdn.ogqcorp.com/preview/1100/720/");
                if (array[0] < a2) {
                    array[0] = a2;
                    array2[0] = str;
                }
                if (array[1] < a2 && !str.equals("summer")) {
                    array[1] = a2;
                    array2[1] = str;
                }
                a.a(context.getString(2131427447, new Object[] { 100 * (i + 1) / b.length }));
                l.a("## [SERVER CHECK] SERVER_NAME: %-3s, BPS: %6.1fkB/s ##", str, a2);
            }
        }
        catch (Exception ex) {
            l.c(ex);
        }
        if (array[1] > 204800.0) {
            v.a().b(context, array2[1]);
            return;
        }
        v.a().b(context, array2[0]);
    }
}
