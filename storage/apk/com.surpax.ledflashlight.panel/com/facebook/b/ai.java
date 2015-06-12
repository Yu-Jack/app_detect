// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import java.io.OutputStream;
import java.io.Closeable;
import java.io.IOException;
import com.facebook.ak;
import java.net.URI;
import android.content.Context;

class ai
{
    static final String a;
    private static final String b;
    private static volatile c c;
    
    static {
        a = ai.class.getSimpleName();
        b = String.valueOf(ai.a) + "_Redirect";
    }
    
    static URI a(final Context p0, final URI p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_1        
        //     1: ifnonnull       6
        //     4: aconst_null    
        //     5: areturn        
        //     6: aload_1        
        //     7: invokevirtual   java/net/URI.toString:()Ljava/lang/String;
        //    10: astore_2       
        //    11: aload_0        
        //    12: invokestatic    com/facebook/b/ai.b:(Landroid/content/Context;)Lcom/facebook/b/c;
        //    15: astore          8
        //    17: aload_2        
        //    18: astore          9
        //    20: iconst_0       
        //    21: istore          10
        //    23: aconst_null    
        //    24: astore          4
        //    26: aload           8
        //    28: aload           9
        //    30: getstatic       com/facebook/b/ai.b:Ljava/lang/String;
        //    33: invokevirtual   com/facebook/b/c.a:(Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
        //    36: astore          14
        //    38: aload           14
        //    40: ifnonnull       67
        //    43: iload           10
        //    45: ifeq            154
        //    48: new             Ljava/net/URI;
        //    51: dup            
        //    52: aload           9
        //    54: invokespecial   java/net/URI.<init>:(Ljava/lang/String;)V
        //    57: astore          21
        //    59: aload           4
        //    61: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //    64: aload           21
        //    66: areturn        
        //    67: new             Ljava/io/InputStreamReader;
        //    70: dup            
        //    71: aload           14
        //    73: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //    76: astore          7
        //    78: sipush          128
        //    81: newarray        C
        //    83: astore          17
        //    85: new             Ljava/lang/StringBuilder;
        //    88: dup            
        //    89: invokespecial   java/lang/StringBuilder.<init>:()V
        //    92: astore          18
        //    94: aload           7
        //    96: aload           17
        //    98: iconst_0       
        //    99: aload           17
        //   101: arraylength    
        //   102: invokevirtual   java/io/InputStreamReader.read:([CII)I
        //   105: istore          19
        //   107: iload           19
        //   109: ifgt            134
        //   112: aload           7
        //   114: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //   117: aload           18
        //   119: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   122: astore          9
        //   124: aload           7
        //   126: astore          4
        //   128: iconst_1       
        //   129: istore          10
        //   131: goto            26
        //   134: aload           18
        //   136: aload           17
        //   138: iconst_0       
        //   139: iload           19
        //   141: invokevirtual   java/lang/StringBuilder.append:([CII)Ljava/lang/StringBuilder;
        //   144: pop            
        //   145: goto            94
        //   148: astore          16
        //   150: aload           7
        //   152: astore          4
        //   154: aload           4
        //   156: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //   159: aconst_null    
        //   160: areturn        
        //   161: astore          6
        //   163: aconst_null    
        //   164: astore          7
        //   166: aload           7
        //   168: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //   171: aload           6
        //   173: athrow         
        //   174: astore          6
        //   176: goto            166
        //   179: astore          13
        //   181: aload           4
        //   183: astore          7
        //   185: aload           13
        //   187: astore          6
        //   189: goto            166
        //   192: astore          5
        //   194: aconst_null    
        //   195: astore          4
        //   197: goto            154
        //   200: astore          15
        //   202: aload           7
        //   204: astore          4
        //   206: goto            154
        //   209: astore          12
        //   211: goto            154
        //   214: astore_3       
        //   215: aconst_null    
        //   216: astore          4
        //   218: goto            154
        //   221: astore          11
        //   223: goto            154
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                         
        //  -----  -----  -----  -----  -----------------------------
        //  11     17     214    221    Ljava/net/URISyntaxException;
        //  11     17     192    200    Ljava/io/IOException;
        //  11     17     161    166    Any
        //  26     38     221    226    Ljava/net/URISyntaxException;
        //  26     38     209    214    Ljava/io/IOException;
        //  26     38     179    192    Any
        //  48     59     221    226    Ljava/net/URISyntaxException;
        //  48     59     209    214    Ljava/io/IOException;
        //  48     59     179    192    Any
        //  67     78     221    226    Ljava/net/URISyntaxException;
        //  67     78     209    214    Ljava/io/IOException;
        //  67     78     179    192    Any
        //  78     94     148    154    Ljava/net/URISyntaxException;
        //  78     94     200    209    Ljava/io/IOException;
        //  78     94     174    179    Any
        //  94     107    148    154    Ljava/net/URISyntaxException;
        //  94     107    200    209    Ljava/io/IOException;
        //  94     107    174    179    Any
        //  112    124    148    154    Ljava/net/URISyntaxException;
        //  112    124    200    209    Ljava/io/IOException;
        //  112    124    174    179    Any
        //  134    145    148    154    Ljava/net/URISyntaxException;
        //  134    145    200    209    Ljava/io/IOException;
        //  134    145    174    179    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0026:
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
    
    static void a(final Context context) {
        try {
            b(context).a();
        }
        catch (IOException ex) {
            v.a(ak.d, 5, ai.a, "clearCache failed " + ex.getMessage());
        }
    }
    
    static void a(final Context context, final URI uri, final URI uri2) {
        if (uri == null || uri2 == null) {
            return;
        }
        OutputStream outputStream = null;
        try {
            final OutputStream b;
            outputStream = (b = b(context).b(uri.toString(), ai.b));
            final URI uri3 = uri2;
            final String s = uri3.toString();
            final byte[] array = s.getBytes();
            b.write(array);
            final OutputStream outputStream2 = outputStream;
            aj.a(outputStream2);
            return;
        }
        catch (IOException ex) {
            aj.a(outputStream);
            return;
        }
        finally {
            final Object o2;
            final Object o = o2;
            final Closeable closeable = null;
            final Object o3 = o;
        }
        while (true) {
            try {
                final OutputStream b = outputStream;
                final URI uri3 = uri2;
                final String s = uri3.toString();
                final byte[] array = s.getBytes();
                b.write(array);
                final OutputStream outputStream2 = outputStream;
                aj.a(outputStream2);
                return;
                final Closeable closeable;
                aj.a(closeable);
                throw;
            }
            finally {
                final Closeable closeable = outputStream;
                final Throwable t;
                final Object o3 = t;
                continue;
            }
            break;
        }
    }
    
    private static c b(final Context context) {
        synchronized (ai.class) {
            if (ai.c == null) {
                ai.c = new c(context.getApplicationContext(), ai.a, new g());
            }
            return ai.c;
        }
    }
}
