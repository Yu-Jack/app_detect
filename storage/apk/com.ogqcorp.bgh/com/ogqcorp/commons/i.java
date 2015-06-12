// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons;

import java.util.Iterator;
import android.os.Handler;
import android.graphics.Bitmap$Config;
import android.view.View;
import java.io.File;
import java.util.LinkedList;

class i extends Thread
{
    final /* synthetic */ g a;
    
    public i(final g a) {
        this.a = a;
        super("DownloadThread");
    }
    
    private void a(final j p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_1        
        //     1: aload_1        
        //     2: getfield        com/ogqcorp/commons/j.c:Ljava/io/File;
        //     5: aload_1        
        //     6: getfield        com/ogqcorp/commons/j.e:Landroid/graphics/Bitmap$Config;
        //     9: iconst_m1      
        //    10: invokestatic    com/ogqcorp/commons/k.b:(Ljava/io/File;Landroid/graphics/Bitmap$Config;I)Landroid/graphics/Bitmap;
        //    13: invokestatic    com/ogqcorp/commons/j.a:(Lcom/ogqcorp/commons/j;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
        //    16: pop            
        //    17: aload_1        
        //    18: invokestatic    com/ogqcorp/commons/j.a:(Lcom/ogqcorp/commons/j;)Landroid/graphics/Bitmap;
        //    21: ifnonnull       247
        //    24: iconst_0       
        //    25: istore          5
        //    27: iload           5
        //    29: iconst_3       
        //    30: if_icmpge       230
        //    33: aconst_null    
        //    34: astore          7
        //    36: invokestatic    java/lang/System.currentTimeMillis:()J
        //    39: lstore          14
        //    41: new             Ljava/net/URL;
        //    44: dup            
        //    45: aload_1        
        //    46: getfield        com/ogqcorp/commons/j.b:Ljava/lang/String;
        //    49: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //    52: invokevirtual   java/net/URL.openConnection:()Ljava/net/URLConnection;
        //    55: checkcast       Ljava/net/HttpURLConnection;
        //    58: astore          16
        //    60: aload           16
        //    62: sipush          5000
        //    65: invokevirtual   java/net/HttpURLConnection.setReadTimeout:(I)V
        //    68: aload           16
        //    70: sipush          10000
        //    73: invokevirtual   java/net/HttpURLConnection.setConnectTimeout:(I)V
        //    76: new             Ljava/io/BufferedInputStream;
        //    79: dup            
        //    80: aload           16
        //    82: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
        //    85: sipush          30720
        //    88: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;I)V
        //    91: astore          11
        //    93: new             Ljava/io/FileOutputStream;
        //    96: dup            
        //    97: aload_1        
        //    98: getfield        com/ogqcorp/commons/j.c:Ljava/io/File;
        //   101: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //   104: astore          17
        //   106: aconst_null    
        //   107: astore          18
        //   109: aconst_null    
        //   110: astore          19
        //   112: aload           17
        //   114: invokevirtual   java/io/FileOutputStream.getChannel:()Ljava/nio/channels/FileChannel;
        //   117: astore          18
        //   119: aload           17
        //   121: invokevirtual   java/io/FileOutputStream.getChannel:()Ljava/nio/channels/FileChannel;
        //   124: invokevirtual   java/nio/channels/FileChannel.lock:()Ljava/nio/channels/FileLock;
        //   127: astore          19
        //   129: aload           11
        //   131: aload           17
        //   133: invokestatic    org/a/a/a/d.a:(Ljava/io/InputStream;Ljava/io/OutputStream;)J
        //   136: lstore          22
        //   138: lload           22
        //   140: lconst_0       
        //   141: lcmp           
        //   142: ifne            176
        //   145: aload           19
        //   147: ifnull          155
        //   150: aload           19
        //   152: invokevirtual   java/nio/channels/FileLock.release:()V
        //   155: aload           18
        //   157: invokestatic    org/a/a/a/d.a:(Ljava/io/Closeable;)V
        //   160: aload           17
        //   162: invokestatic    org/a/a/a/d.a:(Ljava/io/OutputStream;)V
        //   165: aload           11
        //   167: invokestatic    org/a/a/a/d.a:(Ljava/io/InputStream;)V
        //   170: iinc            5, 1
        //   173: goto            27
        //   176: aload           19
        //   178: ifnull          186
        //   181: aload           19
        //   183: invokevirtual   java/nio/channels/FileLock.release:()V
        //   186: aload           18
        //   188: invokestatic    org/a/a/a/d.a:(Ljava/io/Closeable;)V
        //   191: invokestatic    java/lang/System.currentTimeMillis:()J
        //   194: lload           14
        //   196: lsub           
        //   197: lstore          24
        //   199: aload_1        
        //   200: ldc             1000.0
        //   202: aload_1        
        //   203: getfield        com/ogqcorp/commons/j.c:Ljava/io/File;
        //   206: invokevirtual   java/io/File.length:()J
        //   209: l2f            
        //   210: fmul           
        //   211: lload           24
        //   213: l2f            
        //   214: fdiv           
        //   215: f2i            
        //   216: invokestatic    com/ogqcorp/commons/j.a:(Lcom/ogqcorp/commons/j;I)I
        //   219: pop            
        //   220: aload           17
        //   222: invokestatic    org/a/a/a/d.a:(Ljava/io/OutputStream;)V
        //   225: aload           11
        //   227: invokestatic    org/a/a/a/d.a:(Ljava/io/InputStream;)V
        //   230: aload_1        
        //   231: aload_1        
        //   232: getfield        com/ogqcorp/commons/j.c:Ljava/io/File;
        //   235: aload_1        
        //   236: getfield        com/ogqcorp/commons/j.e:Landroid/graphics/Bitmap$Config;
        //   239: iconst_m1      
        //   240: invokestatic    com/ogqcorp/commons/k.b:(Ljava/io/File;Landroid/graphics/Bitmap$Config;I)Landroid/graphics/Bitmap;
        //   243: invokestatic    com/ogqcorp/commons/j.a:(Lcom/ogqcorp/commons/j;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
        //   246: pop            
        //   247: aload_1        
        //   248: getfield        com/ogqcorp/commons/j.f:Landroid/os/Handler;
        //   251: iconst_0       
        //   252: aload_1        
        //   253: invokevirtual   android/os/Handler.obtainMessage:(ILjava/lang/Object;)Landroid/os/Message;
        //   256: astore_3       
        //   257: aload_1        
        //   258: getfield        com/ogqcorp/commons/j.f:Landroid/os/Handler;
        //   261: aload_3        
        //   262: invokevirtual   android/os/Handler.sendMessage:(Landroid/os/Message;)Z
        //   265: pop            
        //   266: return         
        //   267: astore          20
        //   269: aload           19
        //   271: ifnull          279
        //   274: aload           19
        //   276: invokevirtual   java/nio/channels/FileLock.release:()V
        //   279: aload           18
        //   281: invokestatic    org/a/a/a/d.a:(Ljava/io/Closeable;)V
        //   284: aload           20
        //   286: athrow         
        //   287: astore          8
        //   289: aload           17
        //   291: astore          7
        //   293: aload           11
        //   295: astore          9
        //   297: aload           8
        //   299: invokestatic    com/ogqcorp/commons/n.c:(Ljava/lang/Throwable;)I
        //   302: pop            
        //   303: aload           7
        //   305: invokestatic    org/a/a/a/d.a:(Ljava/io/OutputStream;)V
        //   308: aload           9
        //   310: invokestatic    org/a/a/a/d.a:(Ljava/io/InputStream;)V
        //   313: ldc2_w          1000
        //   316: invokestatic    java/lang/Thread.sleep:(J)V
        //   319: goto            170
        //   322: astore          13
        //   324: goto            230
        //   327: astore          10
        //   329: aconst_null    
        //   330: astore          11
        //   332: aload           7
        //   334: invokestatic    org/a/a/a/d.a:(Ljava/io/OutputStream;)V
        //   337: aload           11
        //   339: invokestatic    org/a/a/a/d.a:(Ljava/io/InputStream;)V
        //   342: aload           10
        //   344: athrow         
        //   345: astore          28
        //   347: goto            155
        //   350: astore          27
        //   352: goto            186
        //   355: astore          21
        //   357: goto            279
        //   360: astore          10
        //   362: aconst_null    
        //   363: astore          7
        //   365: goto            332
        //   368: astore          10
        //   370: aload           17
        //   372: astore          7
        //   374: goto            332
        //   377: astore          10
        //   379: aload           9
        //   381: astore          11
        //   383: goto            332
        //   386: astore          8
        //   388: aconst_null    
        //   389: astore          7
        //   391: aconst_null    
        //   392: astore          9
        //   394: goto            297
        //   397: astore          8
        //   399: aload           11
        //   401: astore          9
        //   403: aconst_null    
        //   404: astore          7
        //   406: goto            297
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  36     93     386    397    Ljava/lang/Exception;
        //  36     93     327    332    Any
        //  93     106    397    409    Ljava/lang/Exception;
        //  93     106    360    368    Any
        //  112    138    267    287    Any
        //  150    155    345    350    Ljava/lang/Exception;
        //  150    155    368    377    Any
        //  155    160    287    297    Ljava/lang/Exception;
        //  155    160    368    377    Any
        //  181    186    350    355    Ljava/lang/Exception;
        //  181    186    368    377    Any
        //  186    220    287    297    Ljava/lang/Exception;
        //  186    220    368    377    Any
        //  274    279    355    360    Ljava/lang/Exception;
        //  274    279    368    377    Any
        //  279    287    287    297    Ljava/lang/Exception;
        //  279    287    368    377    Any
        //  297    303    377    386    Any
        //  313    319    322    327    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 192, Size: 192
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
    
    @Override
    public void run() {
        while (true) {
            try {
                synchronized (this.a.d) {
                    while (this.a.d.isEmpty()) {
                        this.a.d.wait();
                    }
                }
            }
            catch (InterruptedException ex) {
                n.a("Release DownloadThread", new Object[0]);
                return;
            }
            final j j = this.a.d.removeFirst();
            // monitorexit(list)
            this.a(j);
        }
    }
}
