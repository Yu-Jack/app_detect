// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Iterator;
import java.util.Map;

public final class db
{
    private int a;
    private String b;
    private Map c;
    private long d;
    private boolean e;
    private boolean f;
    private long g;
    
    public db(final int a, final String b, final Map c, final long d, final boolean e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        if (this.e) {
            this.f = false;
            return;
        }
        this.f = true;
    }
    
    public final void a(final long n) {
        this.f = true;
        this.g = n - this.d;
        eo.a(3, "FlurryAgent", "Ended event '" + this.b + "' (" + this.d + ") after " + this.g + "ms");
    }
    
    public final void a(final Map c) {
        if (this.c == null || this.c.size() == 0) {
            this.c = c;
        }
        else {
            for (final Map.Entry<Object, V> entry : c.entrySet()) {
                if (this.c.containsKey(entry.getKey())) {
                    this.c.remove(entry.getKey());
                    this.c.put(entry.getKey(), entry.getValue());
                }
                else {
                    this.c.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }
    
    public final boolean a() {
        return this.e;
    }
    
    public final boolean a(final String anObject) {
        return this.e && this.g == 0L && this.b.equals(anObject);
    }
    
    public final void b(final Map c) {
        this.c = c;
    }
    
    public final boolean b() {
        return this.f;
    }
    
    public final Map c() {
        return this.c;
    }
    
    public final int d() {
        return this.e().length;
    }
    
    public final byte[] e() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Ljava/io/ByteArrayOutputStream;
        //     3: dup            
        //     4: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //     7: astore_1       
        //     8: new             Ljava/io/DataOutputStream;
        //    11: dup            
        //    12: aload_1        
        //    13: invokespecial   java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    16: astore_2       
        //    17: aload_2        
        //    18: aload_0        
        //    19: getfield        com/flurry/sdk/db.a:I
        //    22: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //    25: aload_2        
        //    26: aload_0        
        //    27: getfield        com/flurry/sdk/db.b:Ljava/lang/String;
        //    30: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //    33: aload_0        
        //    34: getfield        com/flurry/sdk/db.c:Ljava/util/Map;
        //    37: ifnonnull       78
        //    40: aload_2        
        //    41: iconst_0       
        //    42: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //    45: aload_2        
        //    46: aload_0        
        //    47: getfield        com/flurry/sdk/db.d:J
        //    50: invokevirtual   java/io/DataOutputStream.writeLong:(J)V
        //    53: aload_2        
        //    54: aload_0        
        //    55: getfield        com/flurry/sdk/db.g:J
        //    58: invokevirtual   java/io/DataOutputStream.writeLong:(J)V
        //    61: aload_2        
        //    62: invokevirtual   java/io/DataOutputStream.flush:()V
        //    65: aload_1        
        //    66: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //    69: astore          9
        //    71: aload_2        
        //    72: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //    75: aload           9
        //    77: areturn        
        //    78: aload_2        
        //    79: aload_0        
        //    80: getfield        com/flurry/sdk/db.c:Ljava/util/Map;
        //    83: invokeinterface java/util/Map.size:()I
        //    88: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //    91: aload_0        
        //    92: getfield        com/flurry/sdk/db.c:Ljava/util/Map;
        //    95: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //   100: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //   105: astore          7
        //   107: aload           7
        //   109: invokeinterface java/util/Iterator.hasNext:()Z
        //   114: ifeq            45
        //   117: aload           7
        //   119: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   124: checkcast       Ljava/util/Map$Entry;
        //   127: astore          8
        //   129: aload_2        
        //   130: aload           8
        //   132: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   137: checkcast       Ljava/lang/String;
        //   140: invokestatic    com/flurry/sdk/fe.a:(Ljava/lang/String;)Ljava/lang/String;
        //   143: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   146: aload_2        
        //   147: aload           8
        //   149: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   154: checkcast       Ljava/lang/String;
        //   157: invokestatic    com/flurry/sdk/fe.a:(Ljava/lang/String;)Ljava/lang/String;
        //   160: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   163: goto            107
        //   166: astore          4
        //   168: aload_2        
        //   169: astore          5
        //   171: iconst_0       
        //   172: newarray        B
        //   174: astore          6
        //   176: aload           5
        //   178: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   181: aload           6
        //   183: areturn        
        //   184: astore          11
        //   186: aconst_null    
        //   187: astore_2       
        //   188: aload           11
        //   190: astore_3       
        //   191: aload_2        
        //   192: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   195: aload_3        
        //   196: athrow         
        //   197: astore_3       
        //   198: goto            191
        //   201: astore_3       
        //   202: aload           5
        //   204: astore_2       
        //   205: goto            191
        //   208: astore          10
        //   210: aconst_null    
        //   211: astore          5
        //   213: goto            171
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      17     208    216    Ljava/io/IOException;
        //  0      17     184    191    Any
        //  17     45     166    171    Ljava/io/IOException;
        //  17     45     197    201    Any
        //  45     71     166    171    Ljava/io/IOException;
        //  45     71     197    201    Any
        //  78     107    166    171    Ljava/io/IOException;
        //  78     107    197    201    Any
        //  107    163    166    171    Ljava/io/IOException;
        //  107    163    197    201    Any
        //  171    176    201    208    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0171:
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
}
