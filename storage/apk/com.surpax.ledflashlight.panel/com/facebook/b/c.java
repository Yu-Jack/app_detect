// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import java.io.OutputStream;
import org.json.JSONObject;
import java.io.IOException;
import com.facebook.ak;
import java.util.Date;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import com.facebook.bq;
import android.content.Context;
import java.io.File;
import java.util.concurrent.atomic.AtomicLong;

public final class c
{
    static final String a;
    private static final AtomicLong b;
    private final String c;
    private final g d;
    private final File e;
    private boolean f;
    private boolean g;
    private final Object h;
    private AtomicLong i;
    
    static {
        a = c.class.getSimpleName();
        b = new AtomicLong();
    }
    
    public c(final Context context, final String s, final g d) {
        this.i = new AtomicLong(0L);
        this.c = s;
        this.d = d;
        this.e = new File(context.getCacheDir(), s);
        this.h = new Object();
        if (this.e.mkdirs() || this.e.isDirectory()) {
            com.facebook.b.d.a(this.e);
        }
    }
    
    static /* synthetic */ void b(final c p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/facebook/b/c.h:Ljava/lang/Object;
        //     4: astore_1       
        //     5: aload_1        
        //     6: monitorenter   
        //     7: aload_0        
        //     8: iconst_0       
        //     9: putfield        com/facebook/b/c.f:Z
        //    12: aload_0        
        //    13: iconst_1       
        //    14: putfield        com/facebook/b/c.g:Z
        //    17: aload_1        
        //    18: monitorexit    
        //    19: getstatic       com/facebook/ak.d:Lcom/facebook/ak;
        //    22: getstatic       com/facebook/b/c.a:Ljava/lang/String;
        //    25: ldc             "trim started"
        //    27: invokestatic    com/facebook/b/v.a:(Lcom/facebook/ak;Ljava/lang/String;Ljava/lang/String;)V
        //    30: new             Ljava/util/PriorityQueue;
        //    33: dup            
        //    34: invokespecial   java/util/PriorityQueue.<init>:()V
        //    37: astore          6
        //    39: lconst_0       
        //    40: lstore          7
        //    42: lconst_0       
        //    43: lstore          9
        //    45: aload_0        
        //    46: getfield        com/facebook/b/c.e:Ljava/io/File;
        //    49: invokestatic    com/facebook/b/d.a:()Ljava/io/FilenameFilter;
        //    52: invokevirtual   java/io/File.listFiles:(Ljava/io/FilenameFilter;)[Ljava/io/File;
        //    55: astore          11
        //    57: aload           11
        //    59: ifnull          353
        //    62: aload           11
        //    64: arraylength    
        //    65: istore          12
        //    67: iconst_0       
        //    68: istore          13
        //    70: goto            368
        //    73: lload           23
        //    75: aload_0        
        //    76: getfield        com/facebook/b/c.d:Lcom/facebook/b/g;
        //    79: invokevirtual   com/facebook/b/g.a:()I
        //    82: i2l            
        //    83: lcmp           
        //    84: ifgt            239
        //    87: aload_0        
        //    88: getfield        com/facebook/b/c.d:Lcom/facebook/b/g;
        //    91: invokevirtual   com/facebook/b/g.b:()I
        //    94: istore          31
        //    96: lload           25
        //    98: iload           31
        //   100: i2l            
        //   101: lcmp           
        //   102: ifgt            239
        //   105: aload_0        
        //   106: getfield        com/facebook/b/c.h:Ljava/lang/Object;
        //   109: astore          32
        //   111: aload           32
        //   113: monitorenter   
        //   114: aload_0        
        //   115: iconst_0       
        //   116: putfield        com/facebook/b/c.g:Z
        //   119: aload_0        
        //   120: getfield        com/facebook/b/c.h:Ljava/lang/Object;
        //   123: invokevirtual   java/lang/Object.notifyAll:()V
        //   126: aload           32
        //   128: monitorexit    
        //   129: return         
        //   130: astore_2       
        //   131: aload_1        
        //   132: monitorexit    
        //   133: aload_2        
        //   134: athrow         
        //   135: aload           11
        //   137: iload           13
        //   139: aaload         
        //   140: astore          14
        //   142: new             Lcom/facebook/b/h;
        //   145: dup            
        //   146: aload           14
        //   148: invokespecial   com/facebook/b/h.<init>:(Ljava/io/File;)V
        //   151: astore          15
        //   153: aload           6
        //   155: aload           15
        //   157: invokevirtual   java/util/PriorityQueue.add:(Ljava/lang/Object;)Z
        //   160: pop            
        //   161: getstatic       com/facebook/ak.d:Lcom/facebook/ak;
        //   164: getstatic       com/facebook/b/c.a:Ljava/lang/String;
        //   167: new             Ljava/lang/StringBuilder;
        //   170: dup            
        //   171: ldc             "  trim considering time="
        //   173: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   176: aload           15
        //   178: invokevirtual   com/facebook/b/h.b:()J
        //   181: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   184: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   187: ldc             " name="
        //   189: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   192: aload           15
        //   194: invokevirtual   com/facebook/b/h.a:()Ljava/io/File;
        //   197: invokevirtual   java/io/File.getName:()Ljava/lang/String;
        //   200: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   203: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   206: invokestatic    com/facebook/b/v.a:(Lcom/facebook/ak;Ljava/lang/String;Ljava/lang/String;)V
        //   209: lload           7
        //   211: aload           14
        //   213: invokevirtual   java/io/File.length:()J
        //   216: ladd           
        //   217: lstore          17
        //   219: lload           9
        //   221: lconst_1       
        //   222: ladd           
        //   223: lstore          19
        //   225: iinc            13, 1
        //   228: lload           19
        //   230: lstore          9
        //   232: lload           17
        //   234: lstore          7
        //   236: goto            368
        //   239: aload           6
        //   241: invokevirtual   java/util/PriorityQueue.remove:()Ljava/lang/Object;
        //   244: checkcast       Lcom/facebook/b/h;
        //   247: invokevirtual   com/facebook/b/h.a:()Ljava/io/File;
        //   250: astore          27
        //   252: getstatic       com/facebook/ak.d:Lcom/facebook/ak;
        //   255: getstatic       com/facebook/b/c.a:Ljava/lang/String;
        //   258: new             Ljava/lang/StringBuilder;
        //   261: dup            
        //   262: ldc             "  trim removing "
        //   264: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   267: aload           27
        //   269: invokevirtual   java/io/File.getName:()Ljava/lang/String;
        //   272: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   275: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   278: invokestatic    com/facebook/b/v.a:(Lcom/facebook/ak;Ljava/lang/String;Ljava/lang/String;)V
        //   281: lload           23
        //   283: aload           27
        //   285: invokevirtual   java/io/File.length:()J
        //   288: lsub           
        //   289: lstore          23
        //   291: lload           25
        //   293: lconst_1       
        //   294: lsub           
        //   295: lstore          28
        //   297: aload           27
        //   299: invokevirtual   java/io/File.delete:()Z
        //   302: pop            
        //   303: lload           28
        //   305: lstore          25
        //   307: goto            73
        //   310: astore_3       
        //   311: aload_0        
        //   312: getfield        com/facebook/b/c.h:Ljava/lang/Object;
        //   315: astore          4
        //   317: aload           4
        //   319: monitorenter   
        //   320: aload_0        
        //   321: iconst_0       
        //   322: putfield        com/facebook/b/c.g:Z
        //   325: aload_0        
        //   326: getfield        com/facebook/b/c.h:Ljava/lang/Object;
        //   329: invokevirtual   java/lang/Object.notifyAll:()V
        //   332: aload           4
        //   334: monitorexit    
        //   335: aload_3        
        //   336: athrow         
        //   337: astore          5
        //   339: aload           4
        //   341: monitorexit    
        //   342: aload           5
        //   344: athrow         
        //   345: astore          33
        //   347: aload           32
        //   349: monitorexit    
        //   350: aload           33
        //   352: athrow         
        //   353: lload           9
        //   355: lstore          34
        //   357: lload           7
        //   359: lstore          23
        //   361: lload           34
        //   363: lstore          25
        //   365: goto            73
        //   368: iload           13
        //   370: iload           12
        //   372: if_icmplt       135
        //   375: lload           9
        //   377: lstore          21
        //   379: lload           7
        //   381: lstore          23
        //   383: lload           21
        //   385: lstore          25
        //   387: goto            73
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  7      19     130    135    Any
        //  19     39     310    345    Any
        //  45     57     310    345    Any
        //  62     67     310    345    Any
        //  73     96     310    345    Any
        //  114    129    345    353    Any
        //  135    219    310    345    Any
        //  239    291    310    345    Any
        //  297    303    310    345    Any
        //  320    335    337    345    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 193, Size: 193
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
    
    public final InputStream a(final String s) {
        return this.a(s, (String)null);
    }
    
    public final InputStream a(final String s, final InputStream inputStream) {
        return new f(inputStream, this.b(s, null));
    }
    
    public final InputStream a(final String anObject, final String s) {
        final File file = new File(this.e, aj.b(anObject));
        try {
            final BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
            try {
                final JSONObject a = j.a(bufferedInputStream);
                if (a == null) {
                    return null;
                }
                final String optString = a.optString("key");
                if (optString == null || !optString.equals(anObject)) {
                    return null;
                }
                final String optString2 = a.optString("tag", (String)null);
                if ((s == null && optString2 != null) || (s != null && !s.equals(optString2))) {
                    return null;
                }
                final long time = new Date().getTime();
                v.a(ak.d, com.facebook.b.c.a, "Setting lastModified to " + (Object)time + " for " + file.getName());
                file.setLastModified(time);
                return bufferedInputStream;
            }
            finally {
                bufferedInputStream.close();
            }
        }
        catch (IOException ex) {
            return null;
        }
    }
    
    public final void a() {
        final File[] listFiles = this.e.listFiles(com.facebook.b.d.a());
        this.i.set(System.currentTimeMillis());
        if (listFiles != null) {
            bq.b().execute(new Runnable() {
                @Override
                public final void run() {
                    final File[] b = listFiles;
                    for (int length = b.length, i = 0; i < length; ++i) {
                        b[i].delete();
                    }
                }
            });
        }
    }
    
    public final OutputStream b(final String p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/facebook/b/c.e:Ljava/io/File;
        //     4: invokestatic    com/facebook/b/d.b:(Ljava/io/File;)Ljava/io/File;
        //     7: astore_3       
        //     8: aload_3        
        //     9: invokevirtual   java/io/File.delete:()Z
        //    12: pop            
        //    13: aload_3        
        //    14: invokevirtual   java/io/File.createNewFile:()Z
        //    17: ifne            48
        //    20: new             Ljava/io/IOException;
        //    23: dup            
        //    24: new             Ljava/lang/StringBuilder;
        //    27: dup            
        //    28: ldc_w           "Could not create file at "
        //    31: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    34: aload_3        
        //    35: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //    38: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    41: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    44: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //    47: athrow         
        //    48: new             Ljava/io/FileOutputStream;
        //    51: dup            
        //    52: aload_3        
        //    53: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //    56: astore          5
        //    58: new             Ljava/io/BufferedOutputStream;
        //    61: dup            
        //    62: new             Lcom/facebook/b/e;
        //    65: dup            
        //    66: aload           5
        //    68: new             Lcom/facebook/b/c$1;
        //    71: dup            
        //    72: aload_0        
        //    73: invokestatic    java/lang/System.currentTimeMillis:()J
        //    76: aload_3        
        //    77: aload_1        
        //    78: invokespecial   com/facebook/b/c$1.<init>:(Lcom/facebook/b/c;JLjava/io/File;Ljava/lang/String;)V
        //    81: invokespecial   com/facebook/b/e.<init>:(Ljava/io/OutputStream;Lcom/facebook/b/i;)V
        //    84: sipush          8192
        //    87: invokespecial   java/io/BufferedOutputStream.<init>:(Ljava/io/OutputStream;I)V
        //    90: astore          6
        //    92: new             Lorg/json/JSONObject;
        //    95: dup            
        //    96: invokespecial   org/json/JSONObject.<init>:()V
        //    99: astore          7
        //   101: aload           7
        //   103: ldc             "key"
        //   105: aload_1        
        //   106: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   109: pop            
        //   110: aload_2        
        //   111: invokestatic    com/facebook/b/aj.a:(Ljava/lang/String;)Z
        //   114: ifne            126
        //   117: aload           7
        //   119: ldc             "tag"
        //   121: aload_2        
        //   122: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   125: pop            
        //   126: aload           7
        //   128: invokevirtual   org/json/JSONObject.toString:()Ljava/lang/String;
        //   131: invokevirtual   java/lang/String.getBytes:()[B
        //   134: astore          11
        //   136: aload           6
        //   138: iconst_0       
        //   139: invokevirtual   java/io/OutputStream.write:(I)V
        //   142: aload           6
        //   144: sipush          255
        //   147: aload           11
        //   149: arraylength    
        //   150: bipush          16
        //   152: ishr           
        //   153: iand           
        //   154: invokevirtual   java/io/OutputStream.write:(I)V
        //   157: aload           6
        //   159: sipush          255
        //   162: aload           11
        //   164: arraylength    
        //   165: bipush          8
        //   167: ishr           
        //   168: iand           
        //   169: invokevirtual   java/io/OutputStream.write:(I)V
        //   172: aload           6
        //   174: sipush          255
        //   177: aload           11
        //   179: arraylength    
        //   180: iconst_0       
        //   181: ishr           
        //   182: iand           
        //   183: invokevirtual   java/io/OutputStream.write:(I)V
        //   186: aload           6
        //   188: aload           11
        //   190: invokevirtual   java/io/OutputStream.write:([B)V
        //   193: aload           6
        //   195: areturn        
        //   196: astore          13
        //   198: getstatic       com/facebook/ak.d:Lcom/facebook/ak;
        //   201: iconst_5       
        //   202: getstatic       com/facebook/b/c.a:Ljava/lang/String;
        //   205: new             Ljava/lang/StringBuilder;
        //   208: dup            
        //   209: ldc_w           "Error creating buffer output stream: "
        //   212: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   215: aload           13
        //   217: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   220: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   223: invokestatic    com/facebook/b/v.a:(Lcom/facebook/ak;ILjava/lang/String;Ljava/lang/String;)V
        //   226: new             Ljava/io/IOException;
        //   229: dup            
        //   230: aload           13
        //   232: invokevirtual   java/io/FileNotFoundException.getMessage:()Ljava/lang/String;
        //   235: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   238: athrow         
        //   239: astore          9
        //   241: getstatic       com/facebook/ak.d:Lcom/facebook/ak;
        //   244: iconst_5       
        //   245: getstatic       com/facebook/b/c.a:Ljava/lang/String;
        //   248: new             Ljava/lang/StringBuilder;
        //   251: dup            
        //   252: ldc_w           "Error creating JSON header for cache file: "
        //   255: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   258: aload           9
        //   260: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   263: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   266: invokestatic    com/facebook/b/v.a:(Lcom/facebook/ak;ILjava/lang/String;Ljava/lang/String;)V
        //   269: new             Ljava/io/IOException;
        //   272: dup            
        //   273: aload           9
        //   275: invokevirtual   org/json/JSONException.getMessage:()Ljava/lang/String;
        //   278: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   281: athrow         
        //   282: astore          8
        //   284: aload           6
        //   286: invokevirtual   java/io/BufferedOutputStream.close:()V
        //   289: aload           8
        //   291: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  48     58     196    239    Ljava/io/FileNotFoundException;
        //  92     126    239    282    Lorg/json/JSONException;
        //  92     126    282    292    Any
        //  126    193    239    282    Lorg/json/JSONException;
        //  126    193    282    292    Any
        //  241    282    282    292    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0126:
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
    public final String toString() {
        return "{FileLruCache: tag:" + this.c + " file:" + this.e.getName() + "}";
    }
}
