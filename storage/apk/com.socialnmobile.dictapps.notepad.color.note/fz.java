import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// 
// Decompiled by Procyon v0.5.29
// 

public final class fz
{
    private static final String a;
    private static final Set b;
    private static String c;
    
    static {
        a = fz.class.getSimpleName();
        final HashSet<String> s = new HashSet<String>();
        s.add("null");
        s.add("9774d56d682e549c");
        s.add("dead00beef");
        b = Collections.unmodifiableSet((Set<?>)s);
    }
    
    public static String a() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: ldc             Lfz;.class
        //     2: monitorenter   
        //     3: getstatic       fz.c:Ljava/lang/String;
        //     6: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //     9: ifeq            52
        //    12: getstatic       fq.a:Lfq;
        //    15: getfield        fq.b:Landroid/content/Context;
        //    18: invokevirtual   android/content/Context.getContentResolver:()Landroid/content/ContentResolver;
        //    21: ldc             "android_id"
        //    23: invokestatic    android/provider/Settings$Secure.getString:(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
        //    26: astore_2       
        //    27: aload_2        
        //    28: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //    31: ifeq            61
        //    34: iconst_0       
        //    35: istore_3       
        //    36: goto            322
        //    39: aload           4
        //    41: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //    44: ifne            115
        //    47: aload           4
        //    49: putstatic       fz.c:Ljava/lang/String;
        //    52: getstatic       fz.c:Ljava/lang/String;
        //    55: astore_1       
        //    56: ldc             Lfz;.class
        //    58: monitorexit    
        //    59: aload_1        
        //    60: areturn        
        //    61: aload_2        
        //    62: getstatic       java/util/Locale.US:Ljava/util/Locale;
        //    65: invokevirtual   java/lang/String.toLowerCase:(Ljava/util/Locale;)Ljava/lang/String;
        //    68: astore          13
        //    70: getstatic       fz.b:Ljava/util/Set;
        //    73: aload           13
        //    75: invokeinterface java/util/Set.contains:(Ljava/lang/Object;)Z
        //    80: istore          14
        //    82: iconst_0       
        //    83: istore_3       
        //    84: iload           14
        //    86: ifne            322
        //    89: iconst_1       
        //    90: istore_3       
        //    91: goto            322
        //    94: new             Ljava/lang/StringBuilder;
        //    97: dup            
        //    98: ldc             "AND"
        //   100: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   103: aload_2        
        //   104: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   107: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   110: astore          4
        //   112: goto            39
        //   115: invokestatic    fz.b:()Ljava/lang/String;
        //   118: astore          4
        //   120: aload           4
        //   122: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   125: ifeq            47
        //   128: invokestatic    fz.c:()Ljava/lang/String;
        //   131: astore          4
        //   133: aload           4
        //   135: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   138: ifeq            198
        //   141: invokestatic    java/lang/Math.random:()D
        //   144: invokestatic    java/lang/Double.doubleToLongBits:(D)J
        //   147: ldc2_w          37
        //   150: invokestatic    java/lang/System.nanoTime:()J
        //   153: bipush          37
        //   155: getstatic       fq.a:Lfq;
        //   158: getfield        fq.b:Landroid/content/Context;
        //   161: invokestatic    fv.a:(Landroid/content/Context;)Ljava/lang/String;
        //   164: invokevirtual   java/lang/String.hashCode:()I
        //   167: imul           
        //   168: i2l            
        //   169: ladd           
        //   170: lmul           
        //   171: ladd           
        //   172: lstore          11
        //   174: new             Ljava/lang/StringBuilder;
        //   177: dup            
        //   178: ldc             "ID"
        //   180: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   183: lload           11
        //   185: bipush          16
        //   187: invokestatic    java/lang/Long.toString:(JI)Ljava/lang/String;
        //   190: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   193: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   196: astore          4
        //   198: aload           4
        //   200: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   203: ifne            47
        //   206: getstatic       fq.a:Lfq;
        //   209: getfield        fq.b:Landroid/content/Context;
        //   212: ldc             ".flurryb."
        //   214: invokevirtual   android/content/Context.getFileStreamPath:(Ljava/lang/String;)Ljava/io/File;
        //   217: astore          5
        //   219: aload           5
        //   221: invokestatic    gf.a:(Ljava/io/File;)Z
        //   224: istore          6
        //   226: iload           6
        //   228: ifeq            47
        //   231: new             Ljava/io/DataOutputStream;
        //   234: dup            
        //   235: new             Ljava/io/FileOutputStream;
        //   238: dup            
        //   239: aload           5
        //   241: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //   244: invokespecial   java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V
        //   247: astore          7
        //   249: aload           7
        //   251: iconst_1       
        //   252: invokeinterface java/io/DataOutput.writeInt:(I)V
        //   257: aload           7
        //   259: aload           4
        //   261: invokeinterface java/io/DataOutput.writeUTF:(Ljava/lang/String;)V
        //   266: aload           7
        //   268: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   271: goto            47
        //   274: astore_0       
        //   275: ldc             Lfz;.class
        //   277: monitorexit    
        //   278: aload_0        
        //   279: athrow         
        //   280: astore          8
        //   282: aconst_null    
        //   283: astore          7
        //   285: getstatic       fz.a:Ljava/lang/String;
        //   288: pop            
        //   289: ldc             "Error when saving phoneId"
        //   291: aload           8
        //   293: invokestatic    gj.b:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   296: aload           7
        //   298: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   301: goto            47
        //   304: aload           7
        //   306: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   309: aload           9
        //   311: athrow         
        //   312: astore          9
        //   314: goto            304
        //   317: astore          8
        //   319: goto            285
        //   322: iload_3        
        //   323: ifne            94
        //   326: aconst_null    
        //   327: astore          4
        //   329: goto            39
        //   332: astore          9
        //   334: aconst_null    
        //   335: astore          7
        //   337: goto            304
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  3      34     274    280    Any
        //  39     47     274    280    Any
        //  47     52     274    280    Any
        //  52     56     274    280    Any
        //  61     82     274    280    Any
        //  94     112    274    280    Any
        //  115    198    274    280    Any
        //  198    226    274    280    Any
        //  231    249    280    285    Ljava/lang/Throwable;
        //  231    249    332    340    Any
        //  249    266    317    322    Ljava/lang/Throwable;
        //  249    266    312    317    Any
        //  266    271    274    280    Any
        //  285    296    312    317    Any
        //  296    301    274    280    Any
        //  304    312    274    280    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 150, Size: 150
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
    
    private static String b() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: getstatic       fq.a:Lfq;
        //     3: getfield        fq.b:Landroid/content/Context;
        //     6: ldc             ".flurryb."
        //     8: invokevirtual   android/content/Context.getFileStreamPath:(Ljava/lang/String;)Ljava/io/File;
        //    11: astore_0       
        //    12: aload_0        
        //    13: ifnull          23
        //    16: aload_0        
        //    17: invokevirtual   java/io/File.exists:()Z
        //    20: ifne            25
        //    23: aconst_null    
        //    24: areturn        
        //    25: new             Ljava/io/DataInputStream;
        //    28: dup            
        //    29: new             Ljava/io/FileInputStream;
        //    32: dup            
        //    33: aload_0        
        //    34: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    37: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    40: astore_1       
        //    41: aload_1        
        //    42: invokeinterface java/io/DataInput.readInt:()I
        //    47: istore          5
        //    49: aconst_null    
        //    50: astore          6
        //    52: iconst_1       
        //    53: iload           5
        //    55: if_icmpeq       65
        //    58: aload_1        
        //    59: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //    62: aload           6
        //    64: areturn        
        //    65: aload_1        
        //    66: invokeinterface java/io/DataInput.readUTF:()Ljava/lang/String;
        //    71: astore          7
        //    73: aload           7
        //    75: astore          6
        //    77: goto            58
        //    80: astore_2       
        //    81: aconst_null    
        //    82: astore_1       
        //    83: getstatic       fz.a:Ljava/lang/String;
        //    86: pop            
        //    87: ldc             "Error when loading phoneId"
        //    89: aload_2        
        //    90: invokestatic    gj.b:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //    93: aload_1        
        //    94: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //    97: aconst_null    
        //    98: areturn        
        //    99: astore          8
        //   101: aconst_null    
        //   102: astore_1       
        //   103: aload           8
        //   105: astore_3       
        //   106: aload_1        
        //   107: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   110: aload_3        
        //   111: athrow         
        //   112: astore_3       
        //   113: goto            106
        //   116: astore_2       
        //   117: goto            83
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  25     41     80     83     Ljava/lang/Throwable;
        //  25     41     99     106    Any
        //  41     49     116    120    Ljava/lang/Throwable;
        //  41     49     112    116    Any
        //  65     73     116    120    Ljava/lang/Throwable;
        //  65     73     112    116    Any
        //  83     93     112    116    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0058:
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
    
    private static String c() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: getstatic       fq.a:Lfq;
        //     3: getfield        fq.b:Landroid/content/Context;
        //     6: invokevirtual   android/content/Context.getFilesDir:()Ljava/io/File;
        //     9: astore_0       
        //    10: aload_0        
        //    11: ifnonnull       16
        //    14: aconst_null    
        //    15: areturn        
        //    16: aload_0        
        //    17: new             Lga;
        //    20: dup            
        //    21: invokespecial   ga.<init>:()V
        //    24: invokevirtual   java/io/File.list:(Ljava/io/FilenameFilter;)[Ljava/lang/String;
        //    27: astore_1       
        //    28: aload_1        
        //    29: ifnull          14
        //    32: aload_1        
        //    33: arraylength    
        //    34: ifeq            14
        //    37: aload_1        
        //    38: iconst_0       
        //    39: aaload         
        //    40: astore_2       
        //    41: getstatic       fq.a:Lfq;
        //    44: getfield        fq.b:Landroid/content/Context;
        //    47: aload_2        
        //    48: invokevirtual   android/content/Context.getFileStreamPath:(Ljava/lang/String;)Ljava/io/File;
        //    51: astore_3       
        //    52: aload_3        
        //    53: ifnull          14
        //    56: aload_3        
        //    57: invokevirtual   java/io/File.exists:()Z
        //    60: ifeq            14
        //    63: new             Ljava/io/DataInputStream;
        //    66: dup            
        //    67: new             Ljava/io/FileInputStream;
        //    70: dup            
        //    71: aload_3        
        //    72: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    75: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    78: astore          4
        //    80: aload           4
        //    82: invokeinterface java/io/DataInput.readUnsignedShort:()I
        //    87: istore          8
        //    89: aconst_null    
        //    90: astore          9
        //    92: ldc             46586
        //    94: iload           8
        //    96: if_icmpeq       107
        //    99: aload           4
        //   101: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   104: aload           9
        //   106: areturn        
        //   107: aload           4
        //   109: invokeinterface java/io/DataInput.readUnsignedShort:()I
        //   114: istore          10
        //   116: aconst_null    
        //   117: astore          9
        //   119: iconst_2       
        //   120: iload           10
        //   122: if_icmpne       99
        //   125: aload           4
        //   127: invokeinterface java/io/DataInput.readUTF:()Ljava/lang/String;
        //   132: pop            
        //   133: aload           4
        //   135: invokeinterface java/io/DataInput.readUTF:()Ljava/lang/String;
        //   140: astore          12
        //   142: aload           12
        //   144: astore          9
        //   146: goto            99
        //   149: astore          5
        //   151: aconst_null    
        //   152: astore          4
        //   154: getstatic       fz.a:Ljava/lang/String;
        //   157: pop            
        //   158: ldc             "Error when loading phoneId"
        //   160: aload           5
        //   162: invokestatic    gj.b:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   165: aload           4
        //   167: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   170: aconst_null    
        //   171: areturn        
        //   172: astore          13
        //   174: aconst_null    
        //   175: astore          4
        //   177: aload           13
        //   179: astore          6
        //   181: aload           4
        //   183: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   186: aload           6
        //   188: athrow         
        //   189: astore          6
        //   191: goto            181
        //   194: astore          5
        //   196: goto            154
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  63     80     149    154    Ljava/lang/Throwable;
        //  63     80     172    181    Any
        //  80     89     194    199    Ljava/lang/Throwable;
        //  80     89     189    194    Any
        //  107    116    194    199    Ljava/lang/Throwable;
        //  107    116    189    194    Any
        //  125    142    194    199    Ljava/lang/Throwable;
        //  125    142    189    194    Any
        //  154    165    189    194    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0099:
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
