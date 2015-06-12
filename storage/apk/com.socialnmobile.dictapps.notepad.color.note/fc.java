import java.util.UUID;
import java.io.File;

// 
// Decompiled by Procyon v0.5.29
// 

public class fc
{
    private static final String d;
    String a;
    long b;
    int c;
    private File e;
    
    static {
        d = fc.class.getSimpleName();
    }
    
    public fc() {
        this.a = null;
        this.b = -1L;
        this.c = -1;
        this.e = null;
        this.a = UUID.randomUUID().toString();
        this.e = fq.a.b.getFileStreamPath(".flurrydatasenderblock." + this.a);
    }
    
    public fc(final String a) {
        this.a = null;
        this.b = -1L;
        this.c = -1;
        this.e = null;
        this.a = a;
        this.e = fq.a.b.getFileStreamPath(".flurrydatasenderblock." + this.a);
    }
    
    public final String a() {
        return this.a;
    }
    
    public final boolean a(final byte[] p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: iconst_0       
        //     1: istore_2       
        //     2: invokestatic    android/os/Looper.myLooper:()Landroid/os/Looper;
        //     5: invokestatic    android/os/Looper.getMainLooper:()Landroid/os/Looper;
        //     8: if_acmpne       22
        //    11: getstatic       fc.d:Ljava/lang/String;
        //    14: pop            
        //    15: bipush          6
        //    17: ldc             "setData(byte[]) running on the MAIN thread!"
        //    19: invokestatic    gj.a:(ILjava/lang/String;)V
        //    22: getstatic       fc.d:Ljava/lang/String;
        //    25: pop            
        //    26: iconst_4       
        //    27: new             Ljava/lang/StringBuilder;
        //    30: dup            
        //    31: ldc             "Writing FlurryDataSenderBlockInfo: "
        //    33: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    36: aload_0        
        //    37: getfield        fc.e:Ljava/io/File;
        //    40: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //    43: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    46: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    49: invokestatic    gj.a:(ILjava/lang/String;)V
        //    52: aload_0        
        //    53: getfield        fc.e:Ljava/io/File;
        //    56: invokestatic    gf.a:(Ljava/io/File;)Z
        //    59: istore          8
        //    61: iload           8
        //    63: ifne            72
        //    66: aconst_null    
        //    67: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //    70: iconst_0       
        //    71: ireturn        
        //    72: new             Ljava/io/DataOutputStream;
        //    75: dup            
        //    76: new             Ljava/io/FileOutputStream;
        //    79: dup            
        //    80: aload_0        
        //    81: getfield        fc.e:Ljava/io/File;
        //    84: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //    87: invokespecial   java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    90: astore          5
        //    92: aload_1        
        //    93: arraylength    
        //    94: istore          9
        //    96: aload           5
        //    98: iload           9
        //   100: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //   103: aload           5
        //   105: aload_1        
        //   106: invokevirtual   java/io/DataOutputStream.write:([B)V
        //   109: aload           5
        //   111: iconst_0       
        //   112: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //   115: iconst_1       
        //   116: istore_2       
        //   117: aload_0        
        //   118: iload           9
        //   120: putfield        fc.c:I
        //   123: aload_0        
        //   124: invokestatic    java/lang/System.currentTimeMillis:()J
        //   127: putfield        fc.b:J
        //   130: aload           5
        //   132: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   135: iload_2        
        //   136: ireturn        
        //   137: astore          6
        //   139: aconst_null    
        //   140: astore          5
        //   142: getstatic       fc.d:Ljava/lang/String;
        //   145: pop            
        //   146: ldc             ""
        //   148: aload           6
        //   150: invokestatic    gj.b:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   153: aload           5
        //   155: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   158: iload_2        
        //   159: ireturn        
        //   160: astore          4
        //   162: aconst_null    
        //   163: astore          5
        //   165: aload           5
        //   167: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   170: aload           4
        //   172: athrow         
        //   173: astore          4
        //   175: goto            165
        //   178: astore          6
        //   180: goto            142
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  52     61     137    142    Ljava/lang/Throwable;
        //  52     61     160    165    Any
        //  72     92     137    142    Ljava/lang/Throwable;
        //  72     92     160    165    Any
        //  92     115    178    183    Ljava/lang/Throwable;
        //  92     115    173    178    Any
        //  117    130    178    183    Ljava/lang/Throwable;
        //  117    130    173    178    Any
        //  142    153    173    178    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0142:
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
    
    public final byte[] b() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_1       
        //     2: invokestatic    android/os/Looper.myLooper:()Landroid/os/Looper;
        //     5: invokestatic    android/os/Looper.getMainLooper:()Landroid/os/Looper;
        //     8: if_acmpne       22
        //    11: getstatic       fc.d:Ljava/lang/String;
        //    14: pop            
        //    15: bipush          6
        //    17: ldc             "getData() running on the MAIN thread!"
        //    19: invokestatic    gj.a:(ILjava/lang/String;)V
        //    22: aload_0        
        //    23: getfield        fc.e:Ljava/io/File;
        //    26: invokevirtual   java/io/File.exists:()Z
        //    29: ifeq            165
        //    32: getstatic       fc.d:Ljava/lang/String;
        //    35: pop            
        //    36: iconst_4       
        //    37: new             Ljava/lang/StringBuilder;
        //    40: dup            
        //    41: ldc             "Reading FlurryDataSenderBlockInfo: "
        //    43: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    46: aload_0        
        //    47: getfield        fc.e:Ljava/io/File;
        //    50: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //    53: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    56: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    59: invokestatic    gj.a:(ILjava/lang/String;)V
        //    62: new             Ljava/io/DataInputStream;
        //    65: dup            
        //    66: new             Ljava/io/FileInputStream;
        //    69: dup            
        //    70: aload_0        
        //    71: getfield        fc.e:Ljava/io/File;
        //    74: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    77: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    80: astore          4
        //    82: aload           4
        //    84: invokevirtual   java/io/DataInputStream.readUnsignedShort:()I
        //    87: istore          8
        //    89: iload           8
        //    91: ifne            101
        //    94: aload           4
        //    96: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //    99: aconst_null    
        //   100: areturn        
        //   101: iload           8
        //   103: newarray        B
        //   105: astore_1       
        //   106: aload           4
        //   108: aload_1        
        //   109: invokevirtual   java/io/DataInputStream.readFully:([B)V
        //   112: aload           4
        //   114: invokevirtual   java/io/DataInputStream.readUnsignedShort:()I
        //   117: pop            
        //   118: aload           4
        //   120: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   123: aload_1        
        //   124: areturn        
        //   125: astore          5
        //   127: aconst_null    
        //   128: astore          4
        //   130: getstatic       fc.d:Ljava/lang/String;
        //   133: pop            
        //   134: ldc             "Error when loading persistent file"
        //   136: aload           5
        //   138: invokestatic    gj.b:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   141: aload           4
        //   143: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   146: aload_1        
        //   147: areturn        
        //   148: astore          10
        //   150: aconst_null    
        //   151: astore          4
        //   153: aload           10
        //   155: astore          6
        //   157: aload           4
        //   159: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   162: aload           6
        //   164: athrow         
        //   165: getstatic       fc.d:Ljava/lang/String;
        //   168: pop            
        //   169: iconst_4       
        //   170: ldc             "Agent cache file doesn't exist."
        //   172: invokestatic    gj.a:(ILjava/lang/String;)V
        //   175: aconst_null    
        //   176: areturn        
        //   177: astore          6
        //   179: goto            157
        //   182: astore          5
        //   184: goto            130
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  62     82     125    130    Ljava/lang/Throwable;
        //  62     82     148    157    Any
        //  82     89     182    187    Ljava/lang/Throwable;
        //  82     89     177    182    Any
        //  101    118    182    187    Ljava/lang/Throwable;
        //  101    118    177    182    Any
        //  130    141    177    182    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0101:
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
    
    public final boolean c() {
        if (this.e.exists()) {
            if (this.e.delete()) {
                final String d = fc.d;
                gj.a(4, "Deleted persistence file");
                this.b = -1L;
                this.c = -1;
                return true;
            }
            final String d2 = fc.d;
            gj.a(6, "Cannot delete persistence file");
        }
        return false;
    }
}
