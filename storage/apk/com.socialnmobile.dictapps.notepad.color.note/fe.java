import java.util.ArrayList;
import android.os.Looper;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;
import java.io.File;
import java.util.LinkedHashMap;

// 
// Decompiled by Procyon v0.5.29
// 

public class fe
{
    static final Integer a;
    private static final String c;
    LinkedHashMap b;
    
    static {
        c = fe.class.getSimpleName();
        a = 50;
    }
    
    public fe() {
        this.b();
    }
    
    private boolean a(final File file) {
        // monitorenter(this)
        boolean delete = false;
        if (file == null) {
            return delete;
        }
        try {
            final boolean exists = file.exists();
            delete = false;
            if (exists) {
                final String c = fe.c;
                gj.a(4, "Trying to delete persistence file : " + file.getAbsolutePath());
                delete = file.delete();
                if (delete) {
                    final String c2 = fe.c;
                    gj.a(4, "Deleted persistence file");
                }
                else {
                    final String c3 = fe.c;
                    gj.a(6, "Cannot delete persistence file");
                }
            }
            return delete;
        }
        finally {
        }
        // monitorexit(this)
    }
    
    private boolean a(final String p0, final List p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: iconst_0       
        //     1: istore_3       
        //     2: aload_0        
        //     3: monitorenter   
        //     4: invokestatic    android/os/Looper.myLooper:()Landroid/os/Looper;
        //     7: invokestatic    android/os/Looper.getMainLooper:()Landroid/os/Looper;
        //    10: if_acmpne       24
        //    13: getstatic       fe.c:Ljava/lang/String;
        //    16: pop            
        //    17: bipush          6
        //    19: ldc             "saveToFile(byte[], ID) running on the MAIN thread!"
        //    21: invokestatic    gj.a:(ILjava/lang/String;)V
        //    24: getstatic       fq.a:Lfq;
        //    27: getfield        fq.b:Landroid/content/Context;
        //    30: new             Ljava/lang/StringBuilder;
        //    33: dup            
        //    34: ldc             ".FlurrySenderIndex.info."
        //    36: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    39: aload_1        
        //    40: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    43: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    46: invokevirtual   android/content/Context.getFileStreamPath:(Ljava/lang/String;)Ljava/io/File;
        //    49: astore          5
        //    51: aload           5
        //    53: invokestatic    gf.a:(Ljava/io/File;)Z
        //    56: istore          11
        //    58: iload           11
        //    60: ifne            71
        //    63: aconst_null    
        //    64: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //    67: aload_0        
        //    68: monitorexit    
        //    69: iload_3        
        //    70: ireturn        
        //    71: new             Ljava/io/DataOutputStream;
        //    74: dup            
        //    75: new             Ljava/io/FileOutputStream;
        //    78: dup            
        //    79: aload           5
        //    81: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //    84: invokespecial   java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    87: astore          7
        //    89: aload           7
        //    91: aload_2        
        //    92: invokeinterface java/util/List.size:()I
        //    97: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //   100: iconst_0       
        //   101: istore          12
        //   103: iload           12
        //   105: aload_2        
        //   106: invokeinterface java/util/List.size:()I
        //   111: if_icmpge       190
        //   114: aload_2        
        //   115: iload           12
        //   117: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   122: checkcast       Ljava/lang/String;
        //   125: invokevirtual   java/lang/String.getBytes:()[B
        //   128: astore          13
        //   130: aload           13
        //   132: arraylength    
        //   133: istore          14
        //   135: getstatic       fe.c:Ljava/lang/String;
        //   138: pop            
        //   139: iconst_4       
        //   140: new             Ljava/lang/StringBuilder;
        //   143: dup            
        //   144: ldc             "write iter "
        //   146: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   149: iload           12
        //   151: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   154: ldc             " dataLength = "
        //   156: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   159: iload           14
        //   161: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   164: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   167: invokestatic    gj.a:(ILjava/lang/String;)V
        //   170: aload           7
        //   172: iload           14
        //   174: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //   177: aload           7
        //   179: aload           13
        //   181: invokevirtual   java/io/DataOutputStream.write:([B)V
        //   184: iinc            12, 1
        //   187: goto            103
        //   190: aload           7
        //   192: iconst_0       
        //   193: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //   196: iconst_1       
        //   197: istore          10
        //   199: aload           7
        //   201: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   204: iload           10
        //   206: istore_3       
        //   207: goto            67
        //   210: astore          8
        //   212: aconst_null    
        //   213: astore          7
        //   215: getstatic       fe.c:Ljava/lang/String;
        //   218: pop            
        //   219: ldc             ""
        //   221: aload           8
        //   223: invokestatic    gj.b:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   226: aload           7
        //   228: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   231: iconst_0       
        //   232: istore          10
        //   234: goto            204
        //   237: aload           7
        //   239: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   242: aload           6
        //   244: athrow         
        //   245: astore          4
        //   247: aload_0        
        //   248: monitorexit    
        //   249: aload           4
        //   251: athrow         
        //   252: astore          6
        //   254: goto            237
        //   257: astore          8
        //   259: goto            215
        //   262: astore          6
        //   264: aconst_null    
        //   265: astore          7
        //   267: goto            237
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  4      24     245    252    Any
        //  24     51     245    252    Any
        //  51     58     210    215    Ljava/lang/Throwable;
        //  51     58     262    270    Any
        //  63     67     245    252    Any
        //  71     89     210    215    Ljava/lang/Throwable;
        //  71     89     262    270    Any
        //  89     100    257    262    Ljava/lang/Throwable;
        //  89     100    252    257    Any
        //  103    184    257    262    Ljava/lang/Throwable;
        //  103    184    252    257    Any
        //  190    196    257    262    Ljava/lang/Throwable;
        //  190    196    252    257    Any
        //  199    204    245    252    Any
        //  215    226    252    257    Any
        //  226    231    245    252    Any
        //  237    245    245    252    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0103:
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
    
    private void b() {
        this.b = new LinkedHashMap();
        final List d = this.d("Main");
        if (d != null) {
            for (final String key : d) {
                final List d2 = this.d(key);
                if (d2 != null) {
                    this.b.put(key, d2);
                }
            }
        }
    }
    
    private static boolean b(final String s) {
        return new fc(s).c();
    }
    
    private void c() {
        synchronized (this) {
            final LinkedList list = new LinkedList(this.b.keySet());
            this.a(fq.a.b.getFileStreamPath(".FlurrySenderIndex.info.Main"));
            if (!list.isEmpty()) {
                this.a("Main", list);
            }
        }
    }
    
    private boolean c(final String s) {
        synchronized (this) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                final String c = fe.c;
                gj.a(6, "discardOutdatedBlocksForDataKey(ID) running on the MAIN thread!");
            }
            final File fileStreamPath = fq.a.b.getFileStreamPath(".FlurrySenderIndex.info." + s);
            final List a = this.a(s);
            if (a != null) {
                final String c2 = fe.c;
                gj.a(4, "discardOutdatedBlocksForDataKey: notSentBlocks = " + a.size());
                for (int i = 0; i < a.size(); ++i) {
                    final String str = a.get(i);
                    b(str);
                    final String c3 = fe.c;
                    gj.a(4, "discardOutdatedBlocksForDataKey: removed block = " + str);
                }
            }
            this.b.remove(s);
            final boolean a2 = this.a(fileStreamPath);
            this.c();
            return a2;
        }
    }
    
    private List d(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_2       
        //     2: aload_0        
        //     3: monitorenter   
        //     4: invokestatic    android/os/Looper.myLooper:()Landroid/os/Looper;
        //     7: invokestatic    android/os/Looper.getMainLooper:()Landroid/os/Looper;
        //    10: if_acmpne       24
        //    13: getstatic       fe.c:Ljava/lang/String;
        //    16: pop            
        //    17: bipush          6
        //    19: ldc             "readFromFile(byte[], ID) running on the MAIN thread!"
        //    21: invokestatic    gj.a:(ILjava/lang/String;)V
        //    24: getstatic       fq.a:Lfq;
        //    27: getfield        fq.b:Landroid/content/Context;
        //    30: new             Ljava/lang/StringBuilder;
        //    33: dup            
        //    34: ldc             ".FlurrySenderIndex.info."
        //    36: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    39: aload_1        
        //    40: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    43: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    46: invokevirtual   android/content/Context.getFileStreamPath:(Ljava/lang/String;)Ljava/io/File;
        //    49: astore          4
        //    51: aload           4
        //    53: invokevirtual   java/io/File.exists:()Z
        //    56: istore          5
        //    58: iload           5
        //    60: ifeq            267
        //    63: new             Ljava/io/DataInputStream;
        //    66: dup            
        //    67: new             Ljava/io/FileInputStream;
        //    70: dup            
        //    71: aload           4
        //    73: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    76: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    79: astore          8
        //    81: aload           8
        //    83: invokevirtual   java/io/DataInputStream.readUnsignedShort:()I
        //    86: istore          13
        //    88: iload           13
        //    90: ifne            102
        //    93: aload           8
        //    95: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //    98: aload_0        
        //    99: monitorexit    
        //   100: aload_2        
        //   101: areturn        
        //   102: new             Ljava/util/ArrayList;
        //   105: dup            
        //   106: iload           13
        //   108: invokespecial   java/util/ArrayList.<init>:(I)V
        //   111: astore          7
        //   113: iconst_0       
        //   114: istore          14
        //   116: iload           14
        //   118: iload           13
        //   120: if_icmpge       201
        //   123: aload           8
        //   125: invokevirtual   java/io/DataInputStream.readUnsignedShort:()I
        //   128: istore          16
        //   130: getstatic       fe.c:Ljava/lang/String;
        //   133: pop            
        //   134: iconst_4       
        //   135: new             Ljava/lang/StringBuilder;
        //   138: dup            
        //   139: ldc             "read iter "
        //   141: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   144: iload           14
        //   146: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   149: ldc             " dataLength = "
        //   151: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   154: iload           16
        //   156: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   159: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   162: invokestatic    gj.a:(ILjava/lang/String;)V
        //   165: iload           16
        //   167: newarray        B
        //   169: astore          18
        //   171: aload           8
        //   173: aload           18
        //   175: invokevirtual   java/io/DataInputStream.readFully:([B)V
        //   178: aload           7
        //   180: new             Ljava/lang/String;
        //   183: dup            
        //   184: aload           18
        //   186: invokespecial   java/lang/String.<init>:([B)V
        //   189: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   194: pop            
        //   195: iinc            14, 1
        //   198: goto            116
        //   201: aload           8
        //   203: invokevirtual   java/io/DataInputStream.readUnsignedShort:()I
        //   206: pop            
        //   207: aload           8
        //   209: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   212: aload           7
        //   214: astore_2       
        //   215: goto            98
        //   218: astore          20
        //   220: aconst_null    
        //   221: astore          8
        //   223: aconst_null    
        //   224: astore          7
        //   226: aload           20
        //   228: astore          10
        //   230: getstatic       fe.c:Ljava/lang/String;
        //   233: pop            
        //   234: ldc             "Error when loading persistent file"
        //   236: aload           10
        //   238: invokestatic    gj.b:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   241: aload           8
        //   243: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   246: goto            212
        //   249: astore_3       
        //   250: aload_0        
        //   251: monitorexit    
        //   252: aload_3        
        //   253: athrow         
        //   254: astore          11
        //   256: aconst_null    
        //   257: astore          8
        //   259: aload           8
        //   261: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   264: aload           11
        //   266: athrow         
        //   267: getstatic       fe.c:Ljava/lang/String;
        //   270: pop            
        //   271: iconst_5       
        //   272: ldc             "Agent cache file doesn't exist."
        //   274: invokestatic    gj.a:(ILjava/lang/String;)V
        //   277: aconst_null    
        //   278: astore          7
        //   280: goto            212
        //   283: astore          11
        //   285: goto            259
        //   288: astore          9
        //   290: aload           9
        //   292: astore          10
        //   294: aconst_null    
        //   295: astore          7
        //   297: goto            230
        //   300: astore          10
        //   302: goto            230
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  4      24     249    254    Any
        //  24     58     249    254    Any
        //  63     81     218    230    Ljava/lang/Throwable;
        //  63     81     254    259    Any
        //  81     88     288    300    Ljava/lang/Throwable;
        //  81     88     283    288    Any
        //  93     98     249    254    Any
        //  102    113    288    300    Ljava/lang/Throwable;
        //  102    113    283    288    Any
        //  123    195    300    305    Ljava/lang/Throwable;
        //  123    195    283    288    Any
        //  201    207    300    305    Ljava/lang/Throwable;
        //  201    207    283    288    Any
        //  207    212    249    254    Any
        //  230    241    283    288    Any
        //  241    246    249    254    Any
        //  259    267    249    254    Any
        //  267    277    249    254    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 143, Size: 143
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
    
    public final List a() {
        return new ArrayList(this.b.keySet());
    }
    
    public final List a(final String key) {
        return this.b.get(key);
    }
    
    public final void a(final fc fc, final String s) {
        while (true) {
            while (true) {
                final List<String> list;
                synchronized (this) {
                    final String c = fe.c;
                    gj.a(4, "addBlockInfo");
                    final String a = fc.a();
                    list = this.b.get(s);
                    if (list == null) {
                        final String c2 = fe.c;
                        gj.a(4, "New Data Key");
                        final List<String> value = new LinkedList<String>();
                        final int n = 1;
                        value.add(a);
                        if (value.size() > fe.a) {
                            b(value.get(0));
                            value.remove(0);
                        }
                        this.b.put(s, value);
                        this.a(s, value);
                        if (n != 0) {
                            this.c();
                        }
                        return;
                    }
                }
                final List<String> value = list;
                final int n = 0;
                continue;
            }
        }
    }
    
    public final boolean a(final String s, final String s2) {
        final List value = this.b.get(s2);
        boolean remove = false;
        if (value != null) {
            b(s);
            remove = value.remove(s);
        }
        if (value != null && !value.isEmpty()) {
            this.b.put(s2, value);
            this.a(s2, value);
            return remove;
        }
        this.c(s2);
        return remove;
    }
}
