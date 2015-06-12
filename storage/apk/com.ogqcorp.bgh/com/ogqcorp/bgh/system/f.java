// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import java.util.Set;
import android.content.Context;
import com.ogqcorp.bgh.item.Country;
import com.ogqcorp.bgh.item.Ready;

public final class f
{
    private static f a;
    private Ready b;
    private Country c;
    private z d;
    private String e;
    
    static {
        f.a = new f();
    }
    
    public f() {
        this.e = "en_US";
    }
    
    public static f a() {
        return f.a;
    }
    
    private void g(final Context context) {
        try {
            (this.d = new z()).a(context);
        }
        catch (aa aa) {
            l.b(aa);
        }
    }
    
    public void a(final Context p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: monitorenter   
        //     2: aload_1        
        //     3: invokestatic    com/ogqcorp/bgh/system/ac.d:(Landroid/content/Context;)Ljava/lang/String;
        //     6: astore_3       
        //     7: invokestatic    com/ogqcorp/bgh/system/o.b:()Lcom/ogqcorp/bgh/system/o;
        //    10: invokevirtual   com/ogqcorp/bgh/system/o.h:()Ljava/lang/String;
        //    13: astore          10
        //    15: iconst_3       
        //    16: anewarray       Ljava/lang/Object;
        //    19: astore          11
        //    21: aload           11
        //    23: iconst_0       
        //    24: aload_3        
        //    25: aastore        
        //    26: aload           11
        //    28: iconst_1       
        //    29: aload_1        
        //    30: invokestatic    com/ogqcorp/commons/l.a:(Landroid/content/Context;)Ljava/lang/String;
        //    33: aastore        
        //    34: aload           11
        //    36: iconst_2       
        //    37: ldc             "and_phone"
        //    39: aastore        
        //    40: aload           11
        //    42: invokestatic    com/ogqcorp/bgh/system/n.a:([Ljava/lang/Object;)Ljava/util/HashMap;
        //    45: astore          12
        //    47: aload_0        
        //    48: new             Lcom/ogqcorp/bgh/system/q;
        //    51: dup            
        //    52: invokespecial   com/ogqcorp/bgh/system/q.<init>:()V
        //    55: aload           10
        //    57: aload           12
        //    59: sipush          5000
        //    62: getstatic       com/ogqcorp/bgh/system/r.a:Lorg/codehaus/jackson/f/b;
        //    65: invokevirtual   com/ogqcorp/bgh/system/q.a:(Ljava/lang/String;Ljava/util/HashMap;ILorg/codehaus/jackson/f/b;)Ljava/lang/Object;
        //    68: checkcast       Lcom/ogqcorp/bgh/item/Ready;
        //    71: putfield        com/ogqcorp/bgh/system/f.b:Lcom/ogqcorp/bgh/item/Ready;
        //    74: aload_1        
        //    75: aload_0        
        //    76: getfield        com/ogqcorp/bgh/system/f.b:Lcom/ogqcorp/bgh/item/Ready;
        //    79: invokestatic    com/ogqcorp/bgh/item/Ready.a:(Landroid/content/Context;Lcom/ogqcorp/bgh/item/Ready;)V
        //    82: aload_0        
        //    83: aload_1        
        //    84: invokespecial   com/ogqcorp/bgh/system/f.g:(Landroid/content/Context;)V
        //    87: aload_0        
        //    88: aload_1        
        //    89: invokevirtual   com/ogqcorp/bgh/system/f.c:(Landroid/content/Context;)V
        //    92: invokestatic    com/ogqcorp/bgh/system/o.b:()Lcom/ogqcorp/bgh/system/o;
        //    95: invokevirtual   com/ogqcorp/bgh/system/o.i:()Ljava/lang/String;
        //    98: astore          9
        //   100: aload_0        
        //   101: new             Lcom/ogqcorp/bgh/system/q;
        //   104: dup            
        //   105: invokespecial   com/ogqcorp/bgh/system/q.<init>:()V
        //   108: aload           9
        //   110: sipush          1000
        //   113: getstatic       com/ogqcorp/bgh/system/r.b:Lorg/codehaus/jackson/f/b;
        //   116: invokevirtual   com/ogqcorp/bgh/system/q.a:(Ljava/lang/String;ILorg/codehaus/jackson/f/b;)Ljava/lang/Object;
        //   119: checkcast       Lcom/ogqcorp/bgh/item/Country;
        //   122: putfield        com/ogqcorp/bgh/system/f.c:Lcom/ogqcorp/bgh/item/Country;
        //   125: aload_0        
        //   126: monitorexit    
        //   127: return         
        //   128: astore          4
        //   130: aload           4
        //   132: invokestatic    com/ogqcorp/bgh/system/l.c:(Ljava/lang/Throwable;)I
        //   135: pop            
        //   136: aload_0        
        //   137: aload_1        
        //   138: invokestatic    com/ogqcorp/bgh/item/Ready.a:(Landroid/content/Context;)Lcom/ogqcorp/bgh/item/Ready;
        //   141: putfield        com/ogqcorp/bgh/system/f.b:Lcom/ogqcorp/bgh/item/Ready;
        //   144: aload_0        
        //   145: getfield        com/ogqcorp/bgh/system/f.b:Lcom/ogqcorp/bgh/item/Ready;
        //   148: ifnonnull       170
        //   151: aload_0        
        //   152: new             Lcom/ogqcorp/bgh/item/Ready;
        //   155: dup            
        //   156: invokespecial   com/ogqcorp/bgh/item/Ready.<init>:()V
        //   159: putfield        com/ogqcorp/bgh/system/f.b:Lcom/ogqcorp/bgh/item/Ready;
        //   162: aload_0        
        //   163: getfield        com/ogqcorp/bgh/system/f.b:Lcom/ogqcorp/bgh/item/Ready;
        //   166: aload_3        
        //   167: invokevirtual   com/ogqcorp/bgh/item/Ready.setLatestVersion:(Ljava/lang/String;)V
        //   170: aload_0        
        //   171: getfield        com/ogqcorp/bgh/system/f.b:Lcom/ogqcorp/bgh/item/Ready;
        //   174: fconst_0       
        //   175: invokevirtual   com/ogqcorp/bgh/item/Ready.setAutumnWeight:(F)V
        //   178: aload_0        
        //   179: getfield        com/ogqcorp/bgh/system/f.b:Lcom/ogqcorp/bgh/item/Ready;
        //   182: fconst_0       
        //   183: invokevirtual   com/ogqcorp/bgh/item/Ready.setWinterWeight:(F)V
        //   186: goto            82
        //   189: astore_2       
        //   190: aload_0        
        //   191: monitorexit    
        //   192: aload_2        
        //   193: athrow         
        //   194: astore          6
        //   196: aload           6
        //   198: invokestatic    com/ogqcorp/bgh/system/l.c:(Ljava/lang/Throwable;)I
        //   201: pop            
        //   202: aload_0        
        //   203: new             Lcom/ogqcorp/bgh/item/Country;
        //   206: dup            
        //   207: invokespecial   com/ogqcorp/bgh/item/Country.<init>:()V
        //   210: putfield        com/ogqcorp/bgh/system/f.c:Lcom/ogqcorp/bgh/item/Country;
        //   213: aload_1        
        //   214: invokestatic    com/ogqcorp/bgh/system/ac.a:(Landroid/content/Context;)Ljava/util/Locale;
        //   217: invokevirtual   java/util/Locale.getCountry:()Ljava/lang/String;
        //   220: astore          8
        //   222: aload_0        
        //   223: getfield        com/ogqcorp/bgh/system/f.c:Lcom/ogqcorp/bgh/item/Country;
        //   226: aload           8
        //   228: invokevirtual   com/ogqcorp/bgh/item/Country.setCountry:(Ljava/lang/String;)V
        //   231: goto            125
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  2      7      189    194    Any
        //  7      82     128    189    Ljava/lang/Exception;
        //  7      82     189    194    Any
        //  82     92     189    194    Any
        //  92     125    194    234    Ljava/lang/Exception;
        //  92     125    189    194    Any
        //  130    170    189    194    Any
        //  170    186    189    194    Any
        //  196    231    189    194    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0125:
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
    
    public String b() {
        synchronized (this) {
            return this.e;
        }
    }
    
    public int[] b(final Context context) {
        synchronized (this) {
            if (this.d == null) {
                this.g(context);
            }
            return this.d.a();
        }
    }
    
    public void c(final Context context) {
        synchronized (this) {
            final String string = ac.a(context).toString();
            final Set<String> supportedLocalesSet = this.b.getSupportedLocalesSet();
            if (supportedLocalesSet != null && supportedLocalesSet.contains(string)) {
                this.e = string;
            }
        }
    }
    
    public boolean d(final Context context) {
        synchronized (this) {
            if (this.b == null) {
                this.a(context);
            }
            return Math.random() < this.b.getAutumnWeight();
        }
    }
    
    public boolean e(final Context context) {
        synchronized (this) {
            if (this.b == null) {
                this.a(context);
            }
            return Math.random() < this.b.getWinterWeight();
        }
    }
    
    public String f(final Context context) {
        synchronized (this) {
            String s;
            if (this.c == null) {
                s = ac.a(context).getCountry();
            }
            else {
                s = this.c.getCountry();
            }
            return s;
        }
    }
}
