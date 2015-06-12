import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.File;

// 
// Decompiled by Procyon v0.5.29
// 

package java.lang;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class eo
{
    private static final String a;
    private File b;
    
    static {
        a = eo.class.getSimpleName();
    }
    
    public eo(final File b) {
        this.b = b;
        final String a = eo.a;
        gj.a(3, "Referrer file Name if it exists:  " + this.b);
    }
    
    private static String a(final File p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Ljava/io/FileInputStream;
        //     3: dup            
        //     4: aload_0        
        //     5: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //     8: astore_1       
        //     9: new             Ljava/lang/StringBuffer;
        //    12: dup            
        //    13: invokespecial   java/lang/StringBuffer.<init>:()V
        //    16: astore_2       
        //    17: sipush          1024
        //    20: newarray        B
        //    22: astore          7
        //    24: aload_1        
        //    25: aload           7
        //    27: invokevirtual   java/io/FileInputStream.read:([B)I
        //    30: istore          8
        //    32: iload           8
        //    34: ifle            90
        //    37: aload_2        
        //    38: new             Ljava/lang/String;
        //    41: dup            
        //    42: aload           7
        //    44: iconst_0       
        //    45: iload           8
        //    47: invokespecial   java/lang/String.<init>:([BII)V
        //    50: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //    53: pop            
        //    54: goto            24
        //    57: astore          4
        //    59: getstatic       eo.a:Ljava/lang/String;
        //    62: pop            
        //    63: ldc             "Error when loading persistent file"
        //    65: aload           4
        //    67: invokestatic    gj.b:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //    70: aload_1        
        //    71: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //    74: aconst_null    
        //    75: astore          6
        //    77: aload_2        
        //    78: ifnull          87
        //    81: aload_2        
        //    82: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //    85: astore          6
        //    87: aload           6
        //    89: areturn        
        //    90: aload_1        
        //    91: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //    94: goto            74
        //    97: astore          10
        //    99: aconst_null    
        //   100: astore_1       
        //   101: aload           10
        //   103: astore_3       
        //   104: aload_1        
        //   105: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   108: aload_3        
        //   109: athrow         
        //   110: astore_3       
        //   111: goto            104
        //   114: astore          4
        //   116: aconst_null    
        //   117: astore_2       
        //   118: aconst_null    
        //   119: astore_1       
        //   120: goto            59
        //   123: astore          4
        //   125: aconst_null    
        //   126: astore_2       
        //   127: goto            59
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      9      114    123    Ljava/lang/Throwable;
        //  0      9      97     104    Any
        //  9      17     123    130    Ljava/lang/Throwable;
        //  9      17     110    114    Any
        //  17     24     57     59     Ljava/lang/Throwable;
        //  17     24     110    114    Any
        //  24     32     57     59     Ljava/lang/Throwable;
        //  24     32     110    114    Any
        //  37     54     57     59     Ljava/lang/Throwable;
        //  37     54     110    114    Any
        //  59     70     110    114    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0024:
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
    
    private static Map a(final String str) {
        final HashMap<Object, ArrayList<String>> hashMap = new HashMap<Object, ArrayList<String>>();
        final String[] split = str.split("&");
        for (int length = split.length, i = 0; i < length; ++i) {
            final String[] split2 = split[i].split("=");
            if (split2.length != 2) {
                final String a = eo.a;
                gj.a(3, "Invalid referrer Element: " + split[i] + " in referrer tag " + str);
            }
            else {
                final String decode = URLDecoder.decode(split2[0]);
                final String decode2 = URLDecoder.decode(split2[1]);
                if (hashMap.get(decode) == null) {
                    hashMap.put(decode, new ArrayList<String>());
                }
                hashMap.get(decode).add(decode2);
            }
        }
        final StringBuilder sb = new StringBuilder();
        if (hashMap.get("utm_source") == null) {
            sb.append("Campaign Source is missing.\n");
        }
        if (hashMap.get("utm_medium") == null) {
            sb.append("Campaign Medium is missing.\n");
        }
        if (hashMap.get("utm_campaign") == null) {
            sb.append("Campaign Name is missing.\n");
        }
        if (sb.length() > 0) {
            gj.a(5, sb.toString());
        }
        return hashMap;
    }
    
    public final Map a() {
        final boolean exists = this.b.exists();
        Map a = null;
        if (exists) {
            final String a2 = eo.a;
            gj.a(4, "Loading referrer info from file:  " + this.b.getAbsolutePath());
            final String a3 = a(this.b);
            a = null;
            if (a3 != null) {
                final String a4 = eo.a;
                gj.a(3, "Parsing referrer map");
                a = a(a3);
            }
        }
        return a;
    }
}
