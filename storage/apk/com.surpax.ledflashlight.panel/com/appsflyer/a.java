// 
// Decompiled by Procyon v0.5.29
// 

package com.appsflyer;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

final class a implements Runnable
{
    private static AtomicInteger c;
    private WeakReference a;
    private String b;
    
    static {
        a.c = new AtomicInteger(0);
    }
    
    public a(final Context referent, final String b) {
        this.a = null;
        this.a = new WeakReference((T)referent);
        this.b = b;
    }
    
    @Override
    public final void run() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/appsflyer/a.b:Ljava/lang/String;
        //     4: ifnull          17
        //     7: aload_0        
        //     8: getfield        com/appsflyer/a.b:Ljava/lang/String;
        //    11: invokevirtual   java/lang/String.length:()I
        //    14: ifne            18
        //    17: return         
        //    18: getstatic       com/appsflyer/a.c:Ljava/util/concurrent/atomic/AtomicInteger;
        //    21: invokevirtual   java/util/concurrent/atomic/AtomicInteger.incrementAndGet:()I
        //    24: pop            
        //    25: aload_0        
        //    26: getfield        com/appsflyer/a.a:Ljava/lang/ref/WeakReference;
        //    29: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //    32: checkcast       Landroid/content/Context;
        //    35: astore          10
        //    37: aload           10
        //    39: ifnonnull       50
        //    42: getstatic       com/appsflyer/a.c:Ljava/util/concurrent/atomic/AtomicInteger;
        //    45: invokevirtual   java/util/concurrent/atomic/AtomicInteger.decrementAndGet:()I
        //    48: pop            
        //    49: return         
        //    50: aload           10
        //    52: aload           10
        //    54: invokestatic    com/appsflyer/AppsFlyerLib.d:(Landroid/content/Context;)Ljava/lang/String;
        //    57: invokestatic    com/appsflyer/AppsFlyerLib.a:(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
        //    60: astore          11
        //    62: ldc             ""
        //    64: astore          12
        //    66: aload           11
        //    68: ifnull          90
        //    71: new             Ljava/lang/StringBuilder;
        //    74: dup            
        //    75: ldc             "-"
        //    77: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    80: aload           11
        //    82: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    85: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    88: astore          12
        //    90: new             Ljava/lang/StringBuilder;
        //    93: dup            
        //    94: ldc             "https://api.appsflyer.com/install_data/v2/"
        //    96: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    99: aload           10
        //   101: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //   104: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   107: aload           12
        //   109: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   112: ldc             "?devkey="
        //   114: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   117: aload_0        
        //   118: getfield        com/appsflyer/a.b:Ljava/lang/String;
        //   121: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   124: ldc             "&device_id="
        //   126: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   129: aload           10
        //   131: invokestatic    com/appsflyer/AppsFlyerLib.c:(Landroid/content/Context;)Ljava/lang/String;
        //   134: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   137: astore          13
        //   139: ldc             "AppsFlyer_1.5.2"
        //   141: new             Ljava/lang/StringBuilder;
        //   144: dup            
        //   145: ldc             "Calling server for attribution url: "
        //   147: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   150: aload           13
        //   152: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   155: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   158: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   161: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //   164: pop            
        //   165: new             Ljava/net/URL;
        //   168: dup            
        //   169: aload           13
        //   171: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   174: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //   177: invokevirtual   java/net/URL.openConnection:()Ljava/net/URLConnection;
        //   180: checkcast       Ljava/net/HttpURLConnection;
        //   183: astore_3       
        //   184: aload_3        
        //   185: ldc             "GET"
        //   187: invokevirtual   java/net/HttpURLConnection.setRequestMethod:(Ljava/lang/String;)V
        //   190: aload_3        
        //   191: sipush          10000
        //   194: invokevirtual   java/net/HttpURLConnection.setConnectTimeout:(I)V
        //   197: aload_3        
        //   198: ldc             "Connection"
        //   200: ldc             "close"
        //   202: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   205: aload_3        
        //   206: invokevirtual   java/net/HttpURLConnection.connect:()V
        //   209: aload_3        
        //   210: invokevirtual   java/net/HttpURLConnection.getResponseCode:()I
        //   213: sipush          200
        //   216: if_icmpne       577
        //   219: new             Ljava/lang/StringBuilder;
        //   222: dup            
        //   223: invokespecial   java/lang/StringBuilder.<init>:()V
        //   226: astore          15
        //   228: new             Ljava/io/InputStreamReader;
        //   231: dup            
        //   232: aload_3        
        //   233: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
        //   236: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //   239: astore          16
        //   241: new             Ljava/io/BufferedReader;
        //   244: dup            
        //   245: aload           16
        //   247: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //   250: astore          17
        //   252: aload           17
        //   254: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   257: astore          20
        //   259: aload           20
        //   261: ifnull          352
        //   264: aload           15
        //   266: aload           20
        //   268: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   271: bipush          10
        //   273: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   276: pop            
        //   277: goto            252
        //   280: astore          18
        //   282: aload           17
        //   284: astore          19
        //   286: aload           19
        //   288: ifnull          296
        //   291: aload           19
        //   293: invokevirtual   java/io/BufferedReader.close:()V
        //   296: aload           16
        //   298: ifnull          306
        //   301: aload           16
        //   303: invokevirtual   java/io/InputStreamReader.close:()V
        //   306: aload           18
        //   308: athrow         
        //   309: astore_2       
        //   310: invokestatic    com/appsflyer/AppsFlyerLib.a:()Lcom/appsflyer/f;
        //   313: ifnull          325
        //   316: invokestatic    com/appsflyer/AppsFlyerLib.a:()Lcom/appsflyer/f;
        //   319: pop            
        //   320: aload_2        
        //   321: invokevirtual   java/lang/Throwable.getMessage:()Ljava/lang/String;
        //   324: pop            
        //   325: ldc             "AppsFlyer_1.5.2"
        //   327: aload_2        
        //   328: invokevirtual   java/lang/Throwable.getMessage:()Ljava/lang/String;
        //   331: aload_2        
        //   332: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   335: pop            
        //   336: getstatic       com/appsflyer/a.c:Ljava/util/concurrent/atomic/AtomicInteger;
        //   339: invokevirtual   java/util/concurrent/atomic/AtomicInteger.decrementAndGet:()I
        //   342: pop            
        //   343: aload_3        
        //   344: ifnull          17
        //   347: aload_3        
        //   348: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   351: return         
        //   352: aload           17
        //   354: invokevirtual   java/io/BufferedReader.close:()V
        //   357: aload           16
        //   359: invokevirtual   java/io/InputStreamReader.close:()V
        //   362: ldc             "AppsFlyer_1.5.2"
        //   364: new             Ljava/lang/StringBuilder;
        //   367: dup            
        //   368: ldc             "Attribution data: "
        //   370: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   373: aload           15
        //   375: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   378: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   381: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   384: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //   387: pop            
        //   388: aload           15
        //   390: invokevirtual   java/lang/StringBuilder.length:()I
        //   393: ifle            532
        //   396: aload           10
        //   398: ifnull          532
        //   401: aload           15
        //   403: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   406: invokestatic    com/appsflyer/AppsFlyerLib.b:(Ljava/lang/String;)Ljava/util/Map;
        //   409: ldc             "iscache"
        //   411: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   416: checkcast       Ljava/lang/String;
        //   419: astore          23
        //   421: aload           23
        //   423: ifnull          436
        //   426: ldc             "true"
        //   428: aload           23
        //   430: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   433: ifeq            502
        //   436: aload           10
        //   438: ldc             "appsflyer-data"
        //   440: iconst_0       
        //   441: invokevirtual   android/content/Context.getSharedPreferences:(Ljava/lang/String;I)Landroid/content/SharedPreferences;
        //   444: invokeinterface android/content/SharedPreferences.edit:()Landroid/content/SharedPreferences$Editor;
        //   449: astore          24
        //   451: aload           24
        //   453: ldc             "attributionId"
        //   455: aload           15
        //   457: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   460: invokeinterface android/content/SharedPreferences$Editor.putString:(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
        //   465: pop            
        //   466: aload           24
        //   468: invokeinterface android/content/SharedPreferences$Editor.commit:()Z
        //   473: pop            
        //   474: ldc             "AppsFlyer_1.5.2"
        //   476: new             Ljava/lang/StringBuilder;
        //   479: dup            
        //   480: ldc             "iscache="
        //   482: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   485: aload           23
        //   487: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   490: ldc             " caching conversion data"
        //   492: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   495: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   498: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   501: pop            
        //   502: invokestatic    com/appsflyer/AppsFlyerLib.a:()Lcom/appsflyer/f;
        //   505: ifnull          532
        //   508: getstatic       com/appsflyer/a.c:Ljava/util/concurrent/atomic/AtomicInteger;
        //   511: invokevirtual   java/util/concurrent/atomic/AtomicInteger.intValue:()I
        //   514: istore          29
        //   516: iload           29
        //   518: iconst_1       
        //   519: if_icmpgt       532
        //   522: invokestatic    com/appsflyer/AppsFlyerLib.a:()Lcom/appsflyer/f;
        //   525: pop            
        //   526: aload           10
        //   528: invokestatic    com/appsflyer/AppsFlyerLib.b:(Landroid/content/Context;)Ljava/util/Map;
        //   531: pop            
        //   532: getstatic       com/appsflyer/a.c:Ljava/util/concurrent/atomic/AtomicInteger;
        //   535: invokevirtual   java/util/concurrent/atomic/AtomicInteger.decrementAndGet:()I
        //   538: pop            
        //   539: aload_3        
        //   540: ifnull          17
        //   543: aload_3        
        //   544: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   547: return         
        //   548: astore          30
        //   550: invokestatic    com/appsflyer/AppsFlyerLib.a:()Lcom/appsflyer/f;
        //   553: pop            
        //   554: goto            532
        //   557: astore          4
        //   559: getstatic       com/appsflyer/a.c:Ljava/util/concurrent/atomic/AtomicInteger;
        //   562: invokevirtual   java/util/concurrent/atomic/AtomicInteger.decrementAndGet:()I
        //   565: pop            
        //   566: aload_3        
        //   567: ifnull          574
        //   570: aload_3        
        //   571: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   574: aload           4
        //   576: athrow         
        //   577: invokestatic    com/appsflyer/AppsFlyerLib.a:()Lcom/appsflyer/f;
        //   580: ifnull          607
        //   583: invokestatic    com/appsflyer/AppsFlyerLib.a:()Lcom/appsflyer/f;
        //   586: pop            
        //   587: new             Ljava/lang/StringBuilder;
        //   590: dup            
        //   591: ldc             "Error connection to server: "
        //   593: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   596: aload_3        
        //   597: invokevirtual   java/net/HttpURLConnection.getResponseCode:()I
        //   600: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   603: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   606: pop            
        //   607: ldc             "AppsFlyer_1.5.2"
        //   609: new             Ljava/lang/StringBuilder;
        //   612: dup            
        //   613: ldc             "AttributionIdFetcher response code: "
        //   615: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   618: aload_3        
        //   619: invokevirtual   java/net/HttpURLConnection.getResponseCode:()I
        //   622: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   625: ldc             "  url: "
        //   627: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   630: aload           13
        //   632: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   635: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   638: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //   641: pop            
        //   642: goto            532
        //   645: astore          4
        //   647: aconst_null    
        //   648: astore_3       
        //   649: goto            559
        //   652: astore_2       
        //   653: aconst_null    
        //   654: astore_3       
        //   655: goto            310
        //   658: astore          18
        //   660: aconst_null    
        //   661: astore          16
        //   663: aconst_null    
        //   664: astore          19
        //   666: goto            286
        //   669: astore          18
        //   671: aconst_null    
        //   672: astore          19
        //   674: goto            286
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  25     37     652    658    Ljava/lang/Throwable;
        //  25     37     645    652    Any
        //  50     62     652    658    Ljava/lang/Throwable;
        //  50     62     645    652    Any
        //  71     90     652    658    Ljava/lang/Throwable;
        //  71     90     645    652    Any
        //  90     184    652    658    Ljava/lang/Throwable;
        //  90     184    645    652    Any
        //  184    228    309    310    Ljava/lang/Throwable;
        //  184    228    557    559    Any
        //  228    241    658    669    Any
        //  241    252    669    677    Any
        //  252    259    280    286    Any
        //  264    277    280    286    Any
        //  291    296    309    310    Ljava/lang/Throwable;
        //  291    296    557    559    Any
        //  301    306    309    310    Ljava/lang/Throwable;
        //  301    306    557    559    Any
        //  306    309    309    310    Ljava/lang/Throwable;
        //  306    309    557    559    Any
        //  310    325    557    559    Any
        //  325    336    557    559    Any
        //  352    396    309    310    Ljava/lang/Throwable;
        //  352    396    557    559    Any
        //  401    421    309    310    Ljava/lang/Throwable;
        //  401    421    557    559    Any
        //  426    436    309    310    Ljava/lang/Throwable;
        //  426    436    557    559    Any
        //  436    502    309    310    Ljava/lang/Throwable;
        //  436    502    557    559    Any
        //  502    516    309    310    Ljava/lang/Throwable;
        //  502    516    557    559    Any
        //  522    532    548    557    Lcom/appsflyer/e;
        //  522    532    309    310    Ljava/lang/Throwable;
        //  522    532    557    559    Any
        //  550    554    309    310    Ljava/lang/Throwable;
        //  550    554    557    559    Any
        //  577    607    309    310    Ljava/lang/Throwable;
        //  577    607    557    559    Any
        //  607    642    309    310    Ljava/lang/Throwable;
        //  607    642    557    559    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 298, Size: 298
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
