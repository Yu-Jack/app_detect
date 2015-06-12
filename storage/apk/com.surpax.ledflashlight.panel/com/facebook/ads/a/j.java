// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a;

import android.os.AsyncTask;
import android.content.pm.PackageInfo;
import android.util.DisplayMetrics;
import android.content.pm.PackageManager$NameNotFoundException;
import java.util.Locale;
import android.os.Build$VERSION;
import com.facebook.ads.d;
import java.util.HashMap;
import java.util.Iterator;
import java.net.URLEncoder;
import java.util.Map;
import com.facebook.ads.b;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.InputStream;
import com.facebook.ads.e;
import android.content.Context;

public class j
{
    private static final String a;
    private final Context b;
    private final String c;
    private final e d;
    private final String e;
    private final l f;
    private final q g;
    private final boolean h;
    
    static {
        a = j.class.getSimpleName();
    }
    
    public j(final Context b, final String c, final e d, final q g, final boolean h, final l f) {
        if (c == null || c.length() <= 0) {
            throw new IllegalArgumentException("placementId");
        }
        if (d == null) {
            throw new IllegalArgumentException("adSize");
        }
        if (f == null) {
            throw new IllegalArgumentException("callback");
        }
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = u.a(b);
        this.g = g;
        this.h = h;
        this.f = f;
    }
    
    private static k a(final InputStream inputStream) {
        final k k = new k((byte)0);
        while (true) {
            try {
                final Object nextValue = new JSONTokener(r.a(inputStream)).nextValue();
                if (nextValue instanceof JSONObject) {
                    final JSONObject a = (JSONObject)nextValue;
                    if (a.has("error")) {
                        final JSONObject jsonObject = (JSONObject)r.a(a, "error");
                        k.b = new b(jsonObject.optInt("code", -1), jsonObject.optString("message", (String)null));
                    }
                    else {
                        k.a = a;
                        k.b = null;
                    }
                }
                if (k.a == null && k.b == null) {
                    return null;
                }
                return k;
            }
            catch (Exception ex) {
                k.b = new b(-1, ex.getMessage());
                continue;
            }
            continue;
        }
    }
    
    private static String a(final Map map) {
        final StringBuilder sb = new StringBuilder(512);
        final Iterator<Map.Entry<String, V>> iterator = map.entrySet().iterator();
        int n = 1;
        while (iterator.hasNext()) {
            final Map.Entry<String, V> entry = iterator.next();
            int n2;
            if (n != 0) {
                n2 = 0;
            }
            else {
                sb.append("&");
                n2 = n;
            }
            sb.append(URLEncoder.encode(entry.getKey(), "utf-8")).append("=").append(URLEncoder.encode(String.valueOf(entry.getValue()), "utf-8"));
            n = n2;
        }
        return sb.toString();
    }
    
    private Map c() {
        HashMap<String, Integer> hashMap;
        v a2;
        while (true) {
            hashMap = new HashMap<String, Integer>();
            final s a = r.a(this.b.getContentResolver());
            hashMap.put("ad_type", this.g.a());
            hashMap.put("sdk_capabilities", (Integer)p.a());
            hashMap.put("sdk_version", (Integer)"3.16.0");
            hashMap.put("placement_id", (Integer)this.c);
            hashMap.put("attribution_id", (Integer)a.a);
            hashMap.put("width", this.d.a());
            hashMap.put("height", this.d.b());
            hashMap.put("test_mode", (Integer)(Object)this.h);
            hashMap.put("child_directed", (Integer)(Object)com.facebook.ads.d.b());
            hashMap.put("events", (Integer)com.facebook.ads.a.d.a());
            hashMap.put("os", (Integer)"Android");
            hashMap.put("os_version", (Integer)Build$VERSION.RELEASE);
            final DisplayMetrics displayMetrics = this.b.getResources().getDisplayMetrics();
            final int i = (int)(displayMetrics.widthPixels / displayMetrics.density);
            final int j = (int)(displayMetrics.heightPixels / displayMetrics.density);
            hashMap.put("screen_width", i);
            hashMap.put("screen_height", j);
            while (true) {
                try {
                    final PackageInfo packageInfo = this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 0);
                    hashMap.put("app_build", packageInfo.versionCode);
                    hashMap.put("app_version", (Integer)packageInfo.versionName);
                    Locale locale = this.b.getResources().getConfiguration().locale;
                    if (locale == null) {
                        locale = Locale.getDefault();
                    }
                    hashMap.put("locale", (Integer)locale.toString());
                    hashMap.put("package_name", (Integer)this.b.getPackageName());
                    a2 = v.a(this.b, a);
                    if (a2 == null) {
                        hashMap.put("tracking_enabled", (Integer)(Object)true);
                        return hashMap;
                    }
                }
                catch (PackageManager$NameNotFoundException ex) {
                    hashMap.put("app_version", 0);
                    continue;
                }
                break;
            }
            hashMap.put("tracking_enabled", (Integer)(Object)!a2.b());
            if (!a2.b()) {
                break;
            }
            return hashMap;
        }
        hashMap.put("device_id", (Integer)a2.a());
        return hashMap;
    }
    
    public final AsyncTask a() {
        com.facebook.ads.a.a.a(this.b);
        return new AsyncTask() {}.execute((Object[])new Void[0]);
    }
    
    public final k b() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_1       
        //     2: invokestatic    com/facebook/ads/d.a:()Ljava/lang/String;
        //     5: astore          12
        //     7: aload           12
        //     9: invokestatic    com/facebook/ads/a/ab.a:(Ljava/lang/String;)Z
        //    12: ifeq            263
        //    15: ldc_w           "https://graph.facebook.com"
        //    18: astore          13
        //    20: iconst_2       
        //    21: anewarray       Ljava/lang/Object;
        //    24: astore          14
        //    26: aload           14
        //    28: iconst_0       
        //    29: aload           13
        //    31: aastore        
        //    32: getstatic       com/facebook/ads/a/j$2.a:[I
        //    35: aload_0        
        //    36: getfield        com/facebook/ads/a/j.g:Lcom/facebook/ads/a/q;
        //    39: invokevirtual   com/facebook/ads/a/q.ordinal:()I
        //    42: iaload         
        //    43: tableswitch {
        //                2: 283
        //          default: 586
        //        }
        //    60: aload           14
        //    62: iconst_1       
        //    63: aload           15
        //    65: aastore        
        //    66: new             Ljava/net/URL;
        //    69: dup            
        //    70: ldc_w           "%s/%s"
        //    73: aload           14
        //    75: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //    78: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //    81: invokevirtual   java/net/URL.openConnection:()Ljava/net/URLConnection;
        //    84: checkcast       Ljava/net/HttpURLConnection;
        //    87: astore          16
        //    89: aload           16
        //    91: ldc_w           "User-Agent"
        //    94: aload_0        
        //    95: getfield        com/facebook/ads/a/j.e:Ljava/lang/String;
        //    98: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   101: aload           16
        //   103: ldc_w           "Content-Type"
        //   106: ldc_w           "application/x-www-form-urlencoded"
        //   109: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   112: aload           16
        //   114: ldc_w           "POST"
        //   117: invokevirtual   java/net/HttpURLConnection.setRequestMethod:(Ljava/lang/String;)V
        //   120: aload           16
        //   122: iconst_1       
        //   123: invokevirtual   java/net/HttpURLConnection.setDoOutput:(Z)V
        //   126: aload           16
        //   128: sipush          30000
        //   131: invokevirtual   java/net/HttpURLConnection.setConnectTimeout:(I)V
        //   134: aload           16
        //   136: sipush          30000
        //   139: invokevirtual   java/net/HttpURLConnection.setReadTimeout:(I)V
        //   142: aload_0        
        //   143: invokespecial   com/facebook/ads/a/j.c:()Ljava/util/Map;
        //   146: invokestatic    com/facebook/ads/a/j.a:(Ljava/util/Map;)Ljava/lang/String;
        //   149: astore          17
        //   151: new             Ljava/io/BufferedOutputStream;
        //   154: dup            
        //   155: aload           16
        //   157: invokevirtual   java/net/HttpURLConnection.getOutputStream:()Ljava/io/OutputStream;
        //   160: invokespecial   java/io/BufferedOutputStream.<init>:(Ljava/io/OutputStream;)V
        //   163: astore          18
        //   165: new             Ljava/io/BufferedWriter;
        //   168: dup            
        //   169: new             Ljava/io/OutputStreamWriter;
        //   172: dup            
        //   173: aload           18
        //   175: ldc             "utf-8"
        //   177: invokespecial   java/io/OutputStreamWriter.<init>:(Ljava/io/OutputStream;Ljava/lang/String;)V
        //   180: invokespecial   java/io/BufferedWriter.<init>:(Ljava/io/Writer;)V
        //   183: astore          19
        //   185: aload           19
        //   187: aload           17
        //   189: invokevirtual   java/io/BufferedWriter.write:(Ljava/lang/String;)V
        //   192: aload           19
        //   194: invokevirtual   java/io/BufferedWriter.flush:()V
        //   197: aload           19
        //   199: invokevirtual   java/io/BufferedWriter.close:()V
        //   202: aload           18
        //   204: invokevirtual   java/io/OutputStream.close:()V
        //   207: aload           16
        //   209: invokevirtual   java/net/HttpURLConnection.connect:()V
        //   212: aload           16
        //   214: invokevirtual   java/net/HttpURLConnection.getResponseCode:()I
        //   217: sipush          400
        //   220: if_icmplt       291
        //   223: aload           16
        //   225: invokevirtual   java/net/HttpURLConnection.getErrorStream:()Ljava/io/InputStream;
        //   228: astore          27
        //   230: aload           27
        //   232: astore          23
        //   234: aload           23
        //   236: invokestatic    com/facebook/ads/a/j.a:(Ljava/io/InputStream;)Lcom/facebook/ads/a/k;
        //   239: astore          26
        //   241: aload           23
        //   243: invokestatic    com/facebook/ads/a/r.a:(Ljava/io/Closeable;)V
        //   246: aload           16
        //   248: ifnull          256
        //   251: aload           16
        //   253: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   256: aload           26
        //   258: astore          7
        //   260: aload           7
        //   262: areturn        
        //   263: ldc_w           "http://graph.%s.facebook.com"
        //   266: iconst_1       
        //   267: anewarray       Ljava/lang/Object;
        //   270: dup            
        //   271: iconst_0       
        //   272: aload           12
        //   274: aastore        
        //   275: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   278: astore          13
        //   280: goto            20
        //   283: ldc_w           "network_ads_native"
        //   286: astore          15
        //   288: goto            60
        //   291: aload           16
        //   293: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
        //   296: astore          22
        //   298: aload           22
        //   300: astore          23
        //   302: goto            234
        //   305: astore          10
        //   307: aload           10
        //   309: astore          11
        //   311: aconst_null    
        //   312: astore_3       
        //   313: new             Lcom/facebook/ads/a/k;
        //   316: dup            
        //   317: iconst_0       
        //   318: invokespecial   com/facebook/ads/a/k.<init>:(B)V
        //   321: astore          7
        //   323: aload           7
        //   325: new             Lcom/facebook/ads/b;
        //   328: dup            
        //   329: iconst_m1      
        //   330: aload           11
        //   332: invokevirtual   java/net/SocketTimeoutException.getMessage:()Ljava/lang/String;
        //   335: invokespecial   com/facebook/ads/b.<init>:(ILjava/lang/String;)V
        //   338: putfield        com/facebook/ads/a/k.b:Lcom/facebook/ads/b;
        //   341: aload_3        
        //   342: invokestatic    com/facebook/ads/a/r.a:(Ljava/io/Closeable;)V
        //   345: aload_1        
        //   346: ifnull          260
        //   349: aload_1        
        //   350: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   353: aload           7
        //   355: areturn        
        //   356: astore          8
        //   358: aload           8
        //   360: astore          9
        //   362: aconst_null    
        //   363: astore_3       
        //   364: new             Lcom/facebook/ads/a/k;
        //   367: dup            
        //   368: iconst_0       
        //   369: invokespecial   com/facebook/ads/a/k.<init>:(B)V
        //   372: astore          7
        //   374: aload           7
        //   376: new             Lcom/facebook/ads/b;
        //   379: dup            
        //   380: iconst_m1      
        //   381: aload           9
        //   383: invokevirtual   java/io/IOException.getMessage:()Ljava/lang/String;
        //   386: invokespecial   com/facebook/ads/b.<init>:(ILjava/lang/String;)V
        //   389: putfield        com/facebook/ads/a/k.b:Lcom/facebook/ads/b;
        //   392: aload_3        
        //   393: invokestatic    com/facebook/ads/a/r.a:(Ljava/io/Closeable;)V
        //   396: aload_1        
        //   397: ifnull          260
        //   400: aload_1        
        //   401: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   404: aload           7
        //   406: areturn        
        //   407: astore          4
        //   409: aconst_null    
        //   410: astore          5
        //   412: getstatic       com/facebook/ads/a/j.a:Ljava/lang/String;
        //   415: ldc_w           "Unexpected error"
        //   418: aload           4
        //   420: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   423: pop            
        //   424: new             Lcom/facebook/ads/a/k;
        //   427: dup            
        //   428: iconst_0       
        //   429: invokespecial   com/facebook/ads/a/k.<init>:(B)V
        //   432: astore          7
        //   434: aload           7
        //   436: getstatic       com/facebook/ads/b.c:Lcom/facebook/ads/b;
        //   439: putfield        com/facebook/ads/a/k.b:Lcom/facebook/ads/b;
        //   442: aload           5
        //   444: invokestatic    com/facebook/ads/a/r.a:(Ljava/io/Closeable;)V
        //   447: aload_1        
        //   448: ifnull          260
        //   451: aload_1        
        //   452: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   455: aload           7
        //   457: areturn        
        //   458: astore_2       
        //   459: aconst_null    
        //   460: astore_3       
        //   461: aload_3        
        //   462: invokestatic    com/facebook/ads/a/r.a:(Ljava/io/Closeable;)V
        //   465: aload_1        
        //   466: ifnull          473
        //   469: aload_1        
        //   470: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   473: aload_2        
        //   474: athrow         
        //   475: astore          21
        //   477: aload           16
        //   479: astore_1       
        //   480: aload           21
        //   482: astore_2       
        //   483: aconst_null    
        //   484: astore_3       
        //   485: goto            461
        //   488: astore          25
        //   490: aload           23
        //   492: astore_3       
        //   493: aload           16
        //   495: astore_1       
        //   496: aload           25
        //   498: astore_2       
        //   499: goto            461
        //   502: astore_2       
        //   503: goto            461
        //   506: astore_2       
        //   507: aload           5
        //   509: astore_3       
        //   510: goto            461
        //   513: astore          20
        //   515: aload           16
        //   517: astore_1       
        //   518: aload           20
        //   520: astore          4
        //   522: aconst_null    
        //   523: astore          5
        //   525: goto            412
        //   528: astore          24
        //   530: aload           23
        //   532: astore          5
        //   534: aload           16
        //   536: astore_1       
        //   537: aload           24
        //   539: astore          4
        //   541: goto            412
        //   544: astore          9
        //   546: aload           16
        //   548: astore_1       
        //   549: aconst_null    
        //   550: astore_3       
        //   551: goto            364
        //   554: astore          9
        //   556: aload           23
        //   558: astore_3       
        //   559: aload           16
        //   561: astore_1       
        //   562: goto            364
        //   565: astore          11
        //   567: aload           16
        //   569: astore_1       
        //   570: aconst_null    
        //   571: astore_3       
        //   572: goto            313
        //   575: astore          11
        //   577: aload           23
        //   579: astore_3       
        //   580: aload           16
        //   582: astore_1       
        //   583: goto            313
        //   586: ldc_w           "network_ads"
        //   589: astore          15
        //   591: goto            60
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  2      15     305    313    Ljava/net/SocketTimeoutException;
        //  2      15     356    364    Ljava/io/IOException;
        //  2      15     407    412    Ljava/lang/Exception;
        //  2      15     458    461    Any
        //  20     60     305    313    Ljava/net/SocketTimeoutException;
        //  20     60     356    364    Ljava/io/IOException;
        //  20     60     407    412    Ljava/lang/Exception;
        //  20     60     458    461    Any
        //  60     212    305    313    Ljava/net/SocketTimeoutException;
        //  60     212    356    364    Ljava/io/IOException;
        //  60     212    407    412    Ljava/lang/Exception;
        //  60     212    458    461    Any
        //  212    230    565    575    Ljava/net/SocketTimeoutException;
        //  212    230    544    554    Ljava/io/IOException;
        //  212    230    513    528    Ljava/lang/Exception;
        //  212    230    475    488    Any
        //  234    241    575    586    Ljava/net/SocketTimeoutException;
        //  234    241    554    565    Ljava/io/IOException;
        //  234    241    528    544    Ljava/lang/Exception;
        //  234    241    488    502    Any
        //  263    280    305    313    Ljava/net/SocketTimeoutException;
        //  263    280    356    364    Ljava/io/IOException;
        //  263    280    407    412    Ljava/lang/Exception;
        //  263    280    458    461    Any
        //  291    298    565    575    Ljava/net/SocketTimeoutException;
        //  291    298    544    554    Ljava/io/IOException;
        //  291    298    513    528    Ljava/lang/Exception;
        //  291    298    475    488    Any
        //  313    341    502    506    Any
        //  364    392    502    506    Any
        //  412    442    506    513    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 279, Size: 279
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
}
