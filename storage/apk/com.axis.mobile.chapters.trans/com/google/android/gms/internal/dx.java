// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import android.location.Location;
import android.text.TextUtils;
import android.content.Context;

public final class dx extends dw$a
{
    private static final Object qp;
    private static dx qq;
    private final Context mContext;
    private final ed qr;
    private final bi qs;
    private final ay qt;
    
    static {
        qp = new Object();
    }
    
    dx(final Context mContext, final ay qt, final bi qs, final ed qr) {
        this.mContext = mContext;
        this.qr = qr;
        this.qs = qs;
        this.qt = qt;
    }
    
    private static du a(final Context context, final ay ay, final bi bi, final ed ed, final ds ds) {
        eu.z("Starting ad request from service.");
        bi.init();
        final ec ec = new ec(context);
        if (ec.rm == -1) {
            eu.z("Device is offline.");
            return new du(2);
        }
        final dz dz = new dz(ds.applicationInfo.packageName);
        if (ds.pX.extras != null) {
            final String string = ds.pX.extras.getString("_ad");
            if (string != null) {
                return dy.a(context, ds, string);
            }
        }
        final Location a = bi.a(250L);
        final String an = ay.aN();
        final String a2 = dy.a(ds, ec, a, ay.aO());
        if (a2 == null) {
            return new du(0);
        }
        et.sv.post((Runnable)new dx$1(context, ds, dz, s(a2), an));
        final eb bx = dz.bx();
        if (bx == null || TextUtils.isEmpty((CharSequence)bx.getUrl())) {
            return new du(dz.getErrorCode());
        }
        final boolean ba = bx.bA();
        String u = null;
        if (ba) {
            u = ed.u(ds.pY.packageName);
        }
        return a(context, ds.kQ.sw, bx.getUrl(), u, bx);
    }
    
    public static du a(final Context p0, final String p1, final String p2, final String p3, final eb p4) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Lcom/google/android/gms/internal/ea;
        //     3: dup            
        //     4: invokespecial   com/google/android/gms/internal/ea.<init>:()V
        //     7: astore          5
        //     9: new             Ljava/net/URL;
        //    12: dup            
        //    13: aload_2        
        //    14: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //    17: astore          6
        //    19: invokestatic    android/os/SystemClock.elapsedRealtime:()J
        //    22: lstore          8
        //    24: aload           6
        //    26: astore          10
        //    28: iconst_0       
        //    29: istore          11
        //    31: aload           10
        //    33: invokevirtual   java/net/URL.openConnection:()Ljava/net/URLConnection;
        //    36: checkcast       Ljava/net/HttpURLConnection;
        //    39: astore          12
        //    41: aload_0        
        //    42: aload_1        
        //    43: iconst_0       
        //    44: aload           12
        //    46: invokestatic    com/google/android/gms/internal/eo.a:(Landroid/content/Context;Ljava/lang/String;ZLjava/net/HttpURLConnection;)V
        //    49: aload_3        
        //    50: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //    53: ifne            64
        //    56: aload           12
        //    58: ldc             "x-afma-drt-cookie"
        //    60: aload_3        
        //    61: invokevirtual   java/net/HttpURLConnection.addRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //    64: aload           4
        //    66: ifnull          130
        //    69: aload           4
        //    71: invokevirtual   com/google/android/gms/internal/eb.bz:()Ljava/lang/String;
        //    74: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //    77: ifne            130
        //    80: aload           12
        //    82: iconst_1       
        //    83: invokevirtual   java/net/HttpURLConnection.setDoOutput:(Z)V
        //    86: aload           4
        //    88: invokevirtual   com/google/android/gms/internal/eb.bz:()Ljava/lang/String;
        //    91: invokevirtual   java/lang/String.getBytes:()[B
        //    94: astore          23
        //    96: aload           12
        //    98: aload           23
        //   100: arraylength    
        //   101: invokevirtual   java/net/HttpURLConnection.setFixedLengthStreamingMode:(I)V
        //   104: new             Ljava/io/BufferedOutputStream;
        //   107: dup            
        //   108: aload           12
        //   110: invokevirtual   java/net/HttpURLConnection.getOutputStream:()Ljava/io/OutputStream;
        //   113: invokespecial   java/io/BufferedOutputStream.<init>:(Ljava/io/OutputStream;)V
        //   116: astore          24
        //   118: aload           24
        //   120: aload           23
        //   122: invokevirtual   java/io/BufferedOutputStream.write:([B)V
        //   125: aload           24
        //   127: invokevirtual   java/io/BufferedOutputStream.close:()V
        //   130: aload           12
        //   132: invokevirtual   java/net/HttpURLConnection.getResponseCode:()I
        //   135: istore          14
        //   137: aload           12
        //   139: invokevirtual   java/net/HttpURLConnection.getHeaderFields:()Ljava/util/Map;
        //   142: astore          15
        //   144: iload           14
        //   146: sipush          200
        //   149: if_icmplt       223
        //   152: iload           14
        //   154: sipush          300
        //   157: if_icmpge       223
        //   160: aload           10
        //   162: invokevirtual   java/net/URL.toString:()Ljava/lang/String;
        //   165: astore          20
        //   167: new             Ljava/io/InputStreamReader;
        //   170: dup            
        //   171: aload           12
        //   173: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
        //   176: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //   179: invokestatic    com/google/android/gms/internal/eo.a:(Ljava/lang/Readable;)Ljava/lang/String;
        //   182: astore          21
        //   184: aload           20
        //   186: aload           15
        //   188: aload           21
        //   190: iload           14
        //   192: invokestatic    com/google/android/gms/internal/dx.a:(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V
        //   195: aload           5
        //   197: aload           20
        //   199: aload           15
        //   201: aload           21
        //   203: invokevirtual   com/google/android/gms/internal/ea.a:(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V
        //   206: aload           5
        //   208: lload           8
        //   210: invokevirtual   com/google/android/gms/internal/ea.i:(J)Lcom/google/android/gms/internal/du;
        //   213: astore          22
        //   215: aload           12
        //   217: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   220: aload           22
        //   222: areturn        
        //   223: aload           10
        //   225: invokevirtual   java/net/URL.toString:()Ljava/lang/String;
        //   228: aload           15
        //   230: aconst_null    
        //   231: iload           14
        //   233: invokestatic    com/google/android/gms/internal/dx.a:(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V
        //   236: iload           14
        //   238: sipush          300
        //   241: if_icmplt       338
        //   244: iload           14
        //   246: sipush          400
        //   249: if_icmpge       338
        //   252: aload           12
        //   254: ldc_w           "Location"
        //   257: invokevirtual   java/net/HttpURLConnection.getHeaderField:(Ljava/lang/String;)Ljava/lang/String;
        //   260: astore          17
        //   262: aload           17
        //   264: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   267: ifeq            294
        //   270: ldc_w           "No location header to follow redirect."
        //   273: invokestatic    com/google/android/gms/internal/eu.D:(Ljava/lang/String;)V
        //   276: new             Lcom/google/android/gms/internal/du;
        //   279: dup            
        //   280: iconst_0       
        //   281: invokespecial   com/google/android/gms/internal/du.<init>:(I)V
        //   284: astore          19
        //   286: aload           12
        //   288: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   291: aload           19
        //   293: areturn        
        //   294: new             Ljava/net/URL;
        //   297: dup            
        //   298: aload           17
        //   300: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //   303: astore          10
        //   305: iinc            11, 1
        //   308: iload           11
        //   310: iconst_5       
        //   311: if_icmple       380
        //   314: ldc_w           "Too many redirects."
        //   317: invokestatic    com/google/android/gms/internal/eu.D:(Ljava/lang/String;)V
        //   320: new             Lcom/google/android/gms/internal/du;
        //   323: dup            
        //   324: iconst_0       
        //   325: invokespecial   com/google/android/gms/internal/du.<init>:(I)V
        //   328: astore          18
        //   330: aload           12
        //   332: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   335: aload           18
        //   337: areturn        
        //   338: new             Ljava/lang/StringBuilder;
        //   341: dup            
        //   342: invokespecial   java/lang/StringBuilder.<init>:()V
        //   345: ldc_w           "Received error HTTP response code: "
        //   348: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   351: iload           14
        //   353: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   356: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   359: invokestatic    com/google/android/gms/internal/eu.D:(Ljava/lang/String;)V
        //   362: new             Lcom/google/android/gms/internal/du;
        //   365: dup            
        //   366: iconst_0       
        //   367: invokespecial   com/google/android/gms/internal/du.<init>:(I)V
        //   370: astore          16
        //   372: aload           12
        //   374: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   377: aload           16
        //   379: areturn        
        //   380: aload           5
        //   382: aload           15
        //   384: invokevirtual   com/google/android/gms/internal/ea.d:(Ljava/util/Map;)V
        //   387: aload           12
        //   389: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   392: goto            31
        //   395: astore          7
        //   397: new             Ljava/lang/StringBuilder;
        //   400: dup            
        //   401: invokespecial   java/lang/StringBuilder.<init>:()V
        //   404: ldc_w           "Error while connecting to ad server: "
        //   407: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   410: aload           7
        //   412: invokevirtual   java/io/IOException.getMessage:()Ljava/lang/String;
        //   415: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   418: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   421: invokestatic    com/google/android/gms/internal/eu.D:(Ljava/lang/String;)V
        //   424: new             Lcom/google/android/gms/internal/du;
        //   427: dup            
        //   428: iconst_2       
        //   429: invokespecial   com/google/android/gms/internal/du.<init>:(I)V
        //   432: areturn        
        //   433: astore          13
        //   435: aload           12
        //   437: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   440: aload           13
        //   442: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      24     395    433    Ljava/io/IOException;
        //  31     41     395    433    Ljava/io/IOException;
        //  41     64     433    443    Any
        //  69     130    433    443    Any
        //  130    144    433    443    Any
        //  160    215    433    443    Any
        //  215    220    395    433    Ljava/io/IOException;
        //  223    236    433    443    Any
        //  252    286    433    443    Any
        //  286    291    395    433    Ljava/io/IOException;
        //  294    305    433    443    Any
        //  314    330    433    443    Any
        //  330    335    395    433    Ljava/io/IOException;
        //  338    372    433    443    Any
        //  372    377    395    433    Ljava/io/IOException;
        //  380    387    433    443    Any
        //  387    392    395    433    Ljava/io/IOException;
        //  435    443    395    433    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0064:
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
    
    public static dx a(final Context context, final ay ay, final bi bi, final ed ed) {
        synchronized (dx.qp) {
            if (dx.qq == null) {
                dx.qq = new dx(context.getApplicationContext(), ay, bi, ed);
            }
            return dx.qq;
        }
    }
    
    private static void a(final String str, final Map map, final String s, final int i) {
        if (eu.p(2)) {
            eu.C("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (final String str2 : map.keySet()) {
                    eu.C("    " + str2 + ":");
                    final Iterator iterator2 = ((List)map.get(str2)).iterator();
                    while (iterator2.hasNext()) {
                        eu.C("      " + iterator2.next());
                    }
                }
            }
            eu.C("  Body:");
            if (s != null) {
                for (int j = 0; j < Math.min(s.length(), 100000); j += 1000) {
                    eu.C(s.substring(j, Math.min(s.length(), j + 1000)));
                }
            }
            else {
                eu.C("    null");
            }
            eu.C("  Response Code:\n    " + i + "\n}");
        }
    }
    
    private static ey$a s(final String s) {
        return new dx$2(s);
    }
    
    public du b(final ds ds) {
        return a(this.mContext, this.qt, this.qs, this.qr, ds);
    }
}
