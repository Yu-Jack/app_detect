// 
// Decompiled by Procyon v0.5.29
// 

package com.appsflyer;

import android.content.Intent;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import android.content.SharedPreferences$Editor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import android.database.Cursor;
import android.content.ContentResolver;
import android.net.Uri;
import android.content.BroadcastReceiver;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import android.content.SharedPreferences;
import java.io.IOException;
import java.net.URLEncoder;
import android.util.Log;
import java.util.Date;
import java.net.URL;
import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;

final class c implements Runnable
{
    Map a;
    private String b;
    private WeakReference c;
    
    private c(final String b, final Map a, final Context referent) {
        this.c = null;
        this.b = b;
        this.a = a;
        this.c = new WeakReference((T)referent);
    }
    
    private void a(final URL p0, final String p1, final String p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/appsflyer/c.c:Ljava/lang/ref/WeakReference;
        //     4: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //     7: checkcast       Landroid/content/Context;
        //    10: astore          4
        //    12: aload_1        
        //    13: invokevirtual   java/net/URL.openConnection:()Ljava/net/URLConnection;
        //    16: checkcast       Ljava/net/HttpURLConnection;
        //    19: astore          6
        //    21: aload           6
        //    23: ldc             "POST"
        //    25: invokevirtual   java/net/HttpURLConnection.setRequestMethod:(Ljava/lang/String;)V
        //    28: aload_2        
        //    29: invokevirtual   java/lang/String.getBytes:()[B
        //    32: arraylength    
        //    33: istore          7
        //    35: aload           6
        //    37: ldc             "Content-Length"
        //    39: new             Ljava/lang/StringBuilder;
        //    42: dup            
        //    43: invokespecial   java/lang/StringBuilder.<init>:()V
        //    46: iload           7
        //    48: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    51: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    54: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //    57: aload           6
        //    59: ldc             "Connection"
        //    61: ldc             "close"
        //    63: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //    66: aload           6
        //    68: sipush          10000
        //    71: invokevirtual   java/net/HttpURLConnection.setConnectTimeout:(I)V
        //    74: aload           6
        //    76: iconst_1       
        //    77: invokevirtual   java/net/HttpURLConnection.setDoOutput:(Z)V
        //    80: new             Ljava/io/OutputStreamWriter;
        //    83: dup            
        //    84: aload           6
        //    86: invokevirtual   java/net/HttpURLConnection.getOutputStream:()Ljava/io/OutputStream;
        //    89: invokespecial   java/io/OutputStreamWriter.<init>:(Ljava/io/OutputStream;)V
        //    92: astore          8
        //    94: aload           8
        //    96: aload_2        
        //    97: invokevirtual   java/io/OutputStreamWriter.write:(Ljava/lang/String;)V
        //   100: aload           8
        //   102: invokevirtual   java/io/OutputStreamWriter.close:()V
        //   105: aload           6
        //   107: invokevirtual   java/net/HttpURLConnection.getResponseCode:()I
        //   110: istore          10
        //   112: ldc             "AppsFlyer_1.5.2"
        //   114: new             Ljava/lang/StringBuilder;
        //   117: dup            
        //   118: ldc             "response code: "
        //   120: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   123: iload           10
        //   125: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   128: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   131: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //   134: pop            
        //   135: ldc             "response from server. status="
        //   137: iload           10
        //   139: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //   142: aload           4
        //   144: invokestatic    com/appsflyer/AppsFlyerLib.a:(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
        //   147: aload           4
        //   149: ldc             "appsflyer-data"
        //   151: iconst_0       
        //   152: invokevirtual   android/content/Context.getSharedPreferences:(Ljava/lang/String;I)Landroid/content/SharedPreferences;
        //   155: astore          12
        //   157: iload           10
        //   159: sipush          200
        //   162: if_icmpne       226
        //   165: aload_0        
        //   166: getfield        com/appsflyer/c.c:Ljava/lang/ref/WeakReference;
        //   169: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //   172: ifnull          226
        //   175: aload           12
        //   177: invokeinterface android/content/SharedPreferences.edit:()Landroid/content/SharedPreferences$Editor;
        //   182: astore          15
        //   184: aload           15
        //   186: ldc             "sentSuccessfully"
        //   188: ldc             "true"
        //   190: invokeinterface android/content/SharedPreferences$Editor.putString:(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
        //   195: pop            
        //   196: aload           15
        //   198: ldc             "appsFlyerCount"
        //   200: iconst_1       
        //   201: aload           12
        //   203: ldc             "appsFlyerCount"
        //   205: iconst_1       
        //   206: invokeinterface android/content/SharedPreferences.getInt:(Ljava/lang/String;I)I
        //   211: iadd           
        //   212: invokeinterface android/content/SharedPreferences$Editor.putInt:(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
        //   217: pop            
        //   218: aload           15
        //   220: invokeinterface android/content/SharedPreferences$Editor.commit:()Z
        //   225: pop            
        //   226: aload           12
        //   228: ldc             "attributionId"
        //   230: aconst_null    
        //   231: invokeinterface android/content/SharedPreferences.getString:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   236: ifnonnull       316
        //   239: aload_3        
        //   240: ifnull          316
        //   243: iconst_1       
        //   244: invokestatic    java/util/concurrent/Executors.newScheduledThreadPool:(I)Ljava/util/concurrent/ScheduledExecutorService;
        //   247: new             Lcom/appsflyer/a;
        //   250: dup            
        //   251: aload           4
        //   253: invokevirtual   android/content/Context.getApplicationContext:()Landroid/content/Context;
        //   256: aload_3        
        //   257: invokespecial   com/appsflyer/a.<init>:(Landroid/content/Context;Ljava/lang/String;)V
        //   260: ldc2_w          10
        //   263: getstatic       java/util/concurrent/TimeUnit.MILLISECONDS:Ljava/util/concurrent/TimeUnit;
        //   266: invokeinterface java/util/concurrent/ScheduledExecutorService.schedule:(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
        //   271: pop            
        //   272: aload           6
        //   274: ifnull          282
        //   277: aload           6
        //   279: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   282: return         
        //   283: astore          9
        //   285: aconst_null    
        //   286: astore          8
        //   288: aload           8
        //   290: ifnull          298
        //   293: aload           8
        //   295: invokevirtual   java/io/OutputStreamWriter.close:()V
        //   298: aload           9
        //   300: athrow         
        //   301: astore          5
        //   303: aload           6
        //   305: ifnull          313
        //   308: aload           6
        //   310: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   313: aload           5
        //   315: athrow         
        //   316: aload_3        
        //   317: ifnonnull       272
        //   320: ldc             "AppsFlyer_1.5.2"
        //   322: ldc             "AppsFlyer dev key is missing."
        //   324: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   327: pop            
        //   328: goto            272
        //   331: astore          5
        //   333: aconst_null    
        //   334: astore          6
        //   336: goto            303
        //   339: astore          9
        //   341: goto            288
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  12     21     331    339    Any
        //  21     80     301    303    Any
        //  80     94     283    288    Any
        //  94     100    339    344    Any
        //  100    157    301    303    Any
        //  165    226    301    303    Any
        //  226    239    301    303    Any
        //  243    272    301    303    Any
        //  293    298    301    303    Any
        //  298    301    301    303    Any
        //  320    328    301    303    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0226:
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
    public final void run() {
    Label_0134_Outer:
        while (true) {
            boolean b = true;
            while (true) {
            Label_0608:
                while (true) {
                    Label_0602: {
                        Context context = null;
                        String s = null;
                        StringBuilder sb = null;
                    Label_0380:
                        while (true) {
                            String s2 = null;
                            Label_0367: {
                                try {
                                    context = (Context)this.c.get();
                                    if (context == null) {
                                        break Label_0602;
                                    }
                                    final String a = d.a().a(context);
                                    if (a != null && a.length() > 0 && this.a.get("referrer") == null) {
                                        this.a.put("referrer", a);
                                    }
                                    final SharedPreferences sharedPreferences = context.getSharedPreferences("appsflyer-data", 0);
                                    final int equals = "true".equals(sharedPreferences.getString("sentSuccessfully", "")) ? 1 : 0;
                                    this.a.put("counter", Integer.toString(sharedPreferences.getInt("appsFlyerCount", 1)));
                                    final Map a2 = this.a;
                                    if (equals != 0) {
                                        break Label_0608;
                                    }
                                    a2.put("isFirstCall", Boolean.toString(b));
                                    this.a.put("af_timestamp", Long.toString(new Date().getTime()));
                                    s = this.a.get("appsflyerKey");
                                    if (s == null || s.length() == 0) {
                                        Log.d("AppsFlyer_1.5.2", "Not sending data yet, waiting for dev key");
                                        return;
                                    }
                                    new i();
                                    this.a.put("af_v", i.a(this.a));
                                    sb = new StringBuilder();
                                    for (final String str : this.a.keySet()) {
                                        s2 = this.a.get(str);
                                        if (s2 != null) {
                                            break Label_0367;
                                        }
                                        final String encode = "";
                                        if (sb.length() > 0) {
                                            sb.append('&');
                                        }
                                        sb.append(str).append('=').append(encode);
                                    }
                                    break Label_0380;
                                }
                                catch (Throwable t) {
                                    Log.e("AppsFlyer_1.5.2", t.getMessage(), t);
                                    return;
                                }
                            }
                            final String encode = URLEncoder.encode(s2, "UTF-8");
                            continue;
                        }
                        final String string = sb.toString();
                        final URL url = new URL(this.b);
                        Log.i("AppsFlyer_1.5.2", "url: " + url.toString());
                        b("call server.", "\n" + url.toString() + "\nPOST:" + string, context);
                        Log.i("AppsFlyer_1.5.2", "data: " + string);
                        try {
                            this.a(url, string, s);
                            return;
                        }
                        catch (IOException ex) {
                            if (d.a().a("useHttpFallback", true)) {
                                b("https failed: " + ex.getLocalizedMessage(), "", context);
                                this.a(new URL(this.b.replace("https:", "http:")), string, s);
                                return;
                            }
                            Log.i("AppsFlyer_1.5.2", "failed to send requeset to server. " + ex.getLocalizedMessage());
                            return;
                        }
                    }
                    final int equals = 0;
                    continue Label_0134_Outer;
                }
                b = false;
                continue;
            }
        }
    }
}
