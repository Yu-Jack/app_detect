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

public final class dp extends dn
{
    private static final Object a;
    private static dp b;
    private final Context c;
    private final ao d;
    private final ae e;
    
    static {
        a = new Object();
    }
    
    private dp(final Context c, final ae e, final ao d) {
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    private static cz a(final Context context, final ae ae, final ao ao, final cx cx) {
        en.a("Starting ad request from service.");
        ao.a();
        final dt dt = new dt(context);
        if (dt.l == -1) {
            en.a("Device is offline.");
            return new cz(2);
        }
        final dr dr = new dr(cx.f.packageName);
        if (cx.c.c != null) {
            final String string = cx.c.c.getString("_ad");
            if (string != null) {
                return dq.a(context, cx, string);
            }
        }
        final Location a = ao.a(250L);
        final String a2 = ae.a();
        final String a3 = dq.a(cx, dt, a, ae.b());
        if (a3 == null) {
            return new cz(0);
        }
        em.a.post((Runnable)new Runnable() {
            final /* synthetic */ et d = a(a3);
            
            @Override
            public void run() {
                final ep a = ep.a(context, new ak(), false, false, null, cx.k);
                a.setWillNotDraw(true);
                dr.a(a);
                final es f = a.f();
                f.a("/invalidRequest", dr.a);
                f.a("/loadAdURL", dr.b);
                f.a("/log", ai.g);
                f.a(this.d);
                en.a("Loading the JS library.");
                a.loadUrl(a2);
            }
        });
        final String b = dr.b();
        if (TextUtils.isEmpty((CharSequence)b)) {
            return new cz(dr.a());
        }
        return a(context, cx.k.b, b);
    }
    
    public static cz a(final Context p0, final String p1, final String p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Lcom/google/android/gms/internal/ds;
        //     3: dup            
        //     4: invokespecial   com/google/android/gms/internal/ds.<init>:()V
        //     7: astore_3       
        //     8: new             Ljava/net/URL;
        //    11: dup            
        //    12: aload_2        
        //    13: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //    16: astore          4
        //    18: invokestatic    android/os/SystemClock.elapsedRealtime:()J
        //    21: lstore          6
        //    23: aload           4
        //    25: astore          8
        //    27: iconst_0       
        //    28: istore          9
        //    30: aload           8
        //    32: invokevirtual   java/net/URL.openConnection:()Ljava/net/URLConnection;
        //    35: checkcast       Ljava/net/HttpURLConnection;
        //    38: astore          10
        //    40: aload_0        
        //    41: aload_1        
        //    42: iconst_0       
        //    43: aload           10
        //    45: invokestatic    com/google/android/gms/internal/eg.a:(Landroid/content/Context;Ljava/lang/String;ZLjava/net/HttpURLConnection;)V
        //    48: aload           10
        //    50: invokevirtual   java/net/HttpURLConnection.getResponseCode:()I
        //    53: istore          12
        //    55: aload           10
        //    57: invokevirtual   java/net/HttpURLConnection.getHeaderFields:()Ljava/util/Map;
        //    60: astore          13
        //    62: iload           12
        //    64: sipush          200
        //    67: if_icmplt       139
        //    70: iload           12
        //    72: sipush          300
        //    75: if_icmpge       139
        //    78: aload           8
        //    80: invokevirtual   java/net/URL.toString:()Ljava/lang/String;
        //    83: astore          18
        //    85: new             Ljava/io/InputStreamReader;
        //    88: dup            
        //    89: aload           10
        //    91: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
        //    94: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //    97: invokestatic    com/google/android/gms/internal/eg.a:(Ljava/lang/Readable;)Ljava/lang/String;
        //   100: astore          19
        //   102: aload           18
        //   104: aload           13
        //   106: aload           19
        //   108: iload           12
        //   110: invokestatic    com/google/android/gms/internal/dp.a:(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V
        //   113: aload_3        
        //   114: aload           18
        //   116: aload           13
        //   118: aload           19
        //   120: invokevirtual   com/google/android/gms/internal/ds.a:(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V
        //   123: aload_3        
        //   124: lload           6
        //   126: invokevirtual   com/google/android/gms/internal/ds.a:(J)Lcom/google/android/gms/internal/cz;
        //   129: astore          20
        //   131: aload           10
        //   133: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   136: aload           20
        //   138: areturn        
        //   139: aload           8
        //   141: invokevirtual   java/net/URL.toString:()Ljava/lang/String;
        //   144: aload           13
        //   146: aconst_null    
        //   147: iload           12
        //   149: invokestatic    com/google/android/gms/internal/dp.a:(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V
        //   152: iload           12
        //   154: sipush          300
        //   157: if_icmplt       251
        //   160: iload           12
        //   162: sipush          400
        //   165: if_icmpge       251
        //   168: aload           10
        //   170: ldc             "Location"
        //   172: invokevirtual   java/net/HttpURLConnection.getHeaderField:(Ljava/lang/String;)Ljava/lang/String;
        //   175: astore          15
        //   177: aload           15
        //   179: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   182: ifeq            208
        //   185: ldc             "No location header to follow redirect."
        //   187: invokestatic    com/google/android/gms/internal/en.e:(Ljava/lang/String;)V
        //   190: new             Lcom/google/android/gms/internal/cz;
        //   193: dup            
        //   194: iconst_0       
        //   195: invokespecial   com/google/android/gms/internal/cz.<init>:(I)V
        //   198: astore          17
        //   200: aload           10
        //   202: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   205: aload           17
        //   207: areturn        
        //   208: new             Ljava/net/URL;
        //   211: dup            
        //   212: aload           15
        //   214: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //   217: astore          8
        //   219: iinc            9, 1
        //   222: iload           9
        //   224: iconst_5       
        //   225: if_icmple       292
        //   228: ldc             "Too many redirects."
        //   230: invokestatic    com/google/android/gms/internal/en.e:(Ljava/lang/String;)V
        //   233: new             Lcom/google/android/gms/internal/cz;
        //   236: dup            
        //   237: iconst_0       
        //   238: invokespecial   com/google/android/gms/internal/cz.<init>:(I)V
        //   241: astore          16
        //   243: aload           10
        //   245: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   248: aload           16
        //   250: areturn        
        //   251: new             Ljava/lang/StringBuilder;
        //   254: dup            
        //   255: invokespecial   java/lang/StringBuilder.<init>:()V
        //   258: ldc             "Received error HTTP response code: "
        //   260: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   263: iload           12
        //   265: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   268: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   271: invokestatic    com/google/android/gms/internal/en.e:(Ljava/lang/String;)V
        //   274: new             Lcom/google/android/gms/internal/cz;
        //   277: dup            
        //   278: iconst_0       
        //   279: invokespecial   com/google/android/gms/internal/cz.<init>:(I)V
        //   282: astore          14
        //   284: aload           10
        //   286: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   289: aload           14
        //   291: areturn        
        //   292: aload_3        
        //   293: aload           13
        //   295: invokevirtual   com/google/android/gms/internal/ds.a:(Ljava/util/Map;)V
        //   298: aload           10
        //   300: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   303: goto            30
        //   306: astore          5
        //   308: new             Ljava/lang/StringBuilder;
        //   311: dup            
        //   312: invokespecial   java/lang/StringBuilder.<init>:()V
        //   315: ldc             "Error while connecting to ad server: "
        //   317: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   320: aload           5
        //   322: invokevirtual   java/io/IOException.getMessage:()Ljava/lang/String;
        //   325: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   328: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   331: invokestatic    com/google/android/gms/internal/en.e:(Ljava/lang/String;)V
        //   334: new             Lcom/google/android/gms/internal/cz;
        //   337: dup            
        //   338: iconst_2       
        //   339: invokespecial   com/google/android/gms/internal/cz.<init>:(I)V
        //   342: areturn        
        //   343: astore          11
        //   345: aload           10
        //   347: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   350: aload           11
        //   352: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      23     306    343    Ljava/io/IOException;
        //  30     40     306    343    Ljava/io/IOException;
        //  40     62     343    353    Any
        //  78     131    343    353    Any
        //  131    136    306    343    Ljava/io/IOException;
        //  139    152    343    353    Any
        //  168    200    343    353    Any
        //  200    205    306    343    Ljava/io/IOException;
        //  208    219    343    353    Any
        //  228    243    343    353    Any
        //  243    248    306    343    Ljava/io/IOException;
        //  251    284    343    353    Any
        //  284    289    306    343    Ljava/io/IOException;
        //  292    298    343    353    Any
        //  298    303    306    343    Ljava/io/IOException;
        //  345    353    306    343    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0139:
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
    
    public static dp a(final Context context, final ae ae, final ao ao) {
        synchronized (dp.a) {
            if (dp.b == null) {
                dp.b = new dp(context.getApplicationContext(), ae, ao);
            }
            return dp.b;
        }
    }
    
    private static et a(final String s) {
        return new et() {
            @Override
            public void a(final ep ep) {
                final String format = String.format("javascript:%s(%s);", "AFMA_buildAdURL", s);
                en.d("About to execute: " + format);
                ep.loadUrl(format);
            }
        };
    }
    
    private static void a(final String str, final Map<String, List<String>> map, final String s, final int i) {
        if (en.a(2)) {
            en.d("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (final String str2 : map.keySet()) {
                    en.d("    " + str2 + ":");
                    final Iterator<String> iterator2 = map.get(str2).iterator();
                    while (iterator2.hasNext()) {
                        en.d("      " + iterator2.next());
                    }
                }
            }
            en.d("  Body:");
            if (s != null) {
                for (int j = 0; j < Math.min(s.length(), 100000); j += 1000) {
                    en.d(s.substring(j, Math.min(s.length(), j + 1000)));
                }
            }
            else {
                en.d("    null");
            }
            en.d("  Response Code:\n    " + i + "\n}");
        }
    }
    
    public cz a(final cx cx) {
        return a(this.c, this.e, this.d, cx);
    }
}
