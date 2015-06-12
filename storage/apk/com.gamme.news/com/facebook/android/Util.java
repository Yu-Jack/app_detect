// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.android;

import android.app.AlertDialog$Builder;
import android.content.Context;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import android.os.Bundle;

public final class Util
{
    private static final String UTF8 = "UTF-8";
    
    @Deprecated
    public static Bundle decodeUrl(final String s) {
        int i = 0;
        final Bundle bundle = new Bundle();
        if (s != null) {
            for (String[] split = s.split("&"); i < split.length; ++i) {
                final String[] split2 = split[i].split("=");
                try {
                    if (split2.length == 2) {
                        bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode(split2[1], "UTF-8"));
                    }
                    else if (split2.length == 1) {
                        bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), "");
                    }
                }
                catch (UnsupportedEncodingException ex) {}
            }
        }
        return bundle;
    }
    
    @Deprecated
    public static String encodePostBody(final Bundle bundle, final String str) {
        if (bundle == null) {
            return "";
        }
        final StringBuilder sb = new StringBuilder();
        for (final String str2 : bundle.keySet()) {
            final Object value = bundle.get(str2);
            if (value instanceof String) {
                sb.append("Content-Disposition: form-data; name=\"" + str2 + "\"\r\n\r\n" + (String)value);
                sb.append("\r\n--" + str + "\r\n");
            }
        }
        return sb.toString();
    }
    
    @Deprecated
    public static String encodeUrl(final Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        final StringBuilder sb = new StringBuilder();
        int n = 1;
        for (final String s : bundle.keySet()) {
            if (bundle.get(s) instanceof String) {
                if (n != 0) {
                    n = 0;
                }
                else {
                    sb.append("&");
                }
                sb.append(String.valueOf(URLEncoder.encode(s)) + "=" + URLEncoder.encode(bundle.getString(s)));
            }
        }
        return sb.toString();
    }
    
    @Deprecated
    public static String openUrl(final String p0, final String p1, final Bundle p2) throws MalformedURLException, IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_1        
        //     1: ldc             "GET"
        //     3: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //     6: ifeq            36
        //     9: new             Ljava/lang/StringBuilder;
        //    12: dup            
        //    13: aload_0        
        //    14: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    17: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    20: ldc             "?"
        //    22: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    25: aload_2        
        //    26: invokestatic    com/facebook/android/Util.encodeUrl:(Landroid/os/Bundle;)Ljava/lang/String;
        //    29: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    32: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    35: astore_0       
        //    36: ldc             "Facebook-Util"
        //    38: new             Ljava/lang/StringBuilder;
        //    41: dup            
        //    42: aload_1        
        //    43: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    46: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    49: ldc             " URL: "
        //    51: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    54: aload_0        
        //    55: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    58: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    61: invokestatic    com/facebook/internal/Utility.logd:(Ljava/lang/String;Ljava/lang/String;)V
        //    64: new             Ljava/net/URL;
        //    67: dup            
        //    68: aload_0        
        //    69: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //    72: invokevirtual   java/net/URL.openConnection:()Ljava/net/URLConnection;
        //    75: checkcast       Ljava/net/HttpURLConnection;
        //    78: astore_3       
        //    79: aload_3        
        //    80: ldc             "User-Agent"
        //    82: new             Ljava/lang/StringBuilder;
        //    85: dup            
        //    86: invokestatic    java/lang/System.getProperties:()Ljava/util/Properties;
        //    89: ldc             "http.agent"
        //    91: invokevirtual   java/util/Properties.getProperty:(Ljava/lang/String;)Ljava/lang/String;
        //    94: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    97: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   100: ldc             " FacebookAndroidSDK"
        //   102: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   105: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   108: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   111: aload_1        
        //   112: ldc             "GET"
        //   114: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   117: ifne            376
        //   120: new             Landroid/os/Bundle;
        //   123: dup            
        //   124: invokespecial   android/os/Bundle.<init>:()V
        //   127: astore          4
        //   129: aload_2        
        //   130: invokevirtual   android/os/Bundle.keySet:()Ljava/util/Set;
        //   133: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //   138: astore          5
        //   140: aload           5
        //   142: invokeinterface java/util/Iterator.hasNext:()Z
        //   147: ifne            388
        //   150: aload_2        
        //   151: ldc             "method"
        //   153: invokevirtual   android/os/Bundle.containsKey:(Ljava/lang/String;)Z
        //   156: ifne            166
        //   159: aload_2        
        //   160: ldc             "method"
        //   162: aload_1        
        //   163: invokevirtual   android/os/Bundle.putString:(Ljava/lang/String;Ljava/lang/String;)V
        //   166: aload_2        
        //   167: ldc             "access_token"
        //   169: invokevirtual   android/os/Bundle.containsKey:(Ljava/lang/String;)Z
        //   172: ifeq            190
        //   175: aload_2        
        //   176: ldc             "access_token"
        //   178: aload_2        
        //   179: ldc             "access_token"
        //   181: invokevirtual   android/os/Bundle.getString:(Ljava/lang/String;)Ljava/lang/String;
        //   184: invokestatic    java/net/URLDecoder.decode:(Ljava/lang/String;)Ljava/lang/String;
        //   187: invokevirtual   android/os/Bundle.putString:(Ljava/lang/String;Ljava/lang/String;)V
        //   190: aload_3        
        //   191: ldc             "POST"
        //   193: invokevirtual   java/net/HttpURLConnection.setRequestMethod:(Ljava/lang/String;)V
        //   196: aload_3        
        //   197: ldc             "Content-Type"
        //   199: new             Ljava/lang/StringBuilder;
        //   202: dup            
        //   203: ldc             "multipart/form-data;boundary="
        //   205: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   208: ldc             "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f"
        //   210: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   213: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   216: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   219: aload_3        
        //   220: iconst_1       
        //   221: invokevirtual   java/net/HttpURLConnection.setDoOutput:(Z)V
        //   224: aload_3        
        //   225: iconst_1       
        //   226: invokevirtual   java/net/HttpURLConnection.setDoInput:(Z)V
        //   229: aload_3        
        //   230: ldc             "Connection"
        //   232: ldc             "Keep-Alive"
        //   234: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   237: aload_3        
        //   238: invokevirtual   java/net/HttpURLConnection.connect:()V
        //   241: new             Ljava/io/BufferedOutputStream;
        //   244: dup            
        //   245: aload_3        
        //   246: invokevirtual   java/net/HttpURLConnection.getOutputStream:()Ljava/io/OutputStream;
        //   249: invokespecial   java/io/BufferedOutputStream.<init>:(Ljava/io/OutputStream;)V
        //   252: astore          8
        //   254: aload           8
        //   256: new             Ljava/lang/StringBuilder;
        //   259: dup            
        //   260: ldc             "--"
        //   262: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   265: ldc             "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f"
        //   267: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   270: ldc             "\r\n"
        //   272: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   275: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   278: invokevirtual   java/lang/String.getBytes:()[B
        //   281: invokevirtual   java/io/OutputStream.write:([B)V
        //   284: aload           8
        //   286: aload_2        
        //   287: ldc             "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f"
        //   289: invokestatic    com/facebook/android/Util.encodePostBody:(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;
        //   292: invokevirtual   java/lang/String.getBytes:()[B
        //   295: invokevirtual   java/io/OutputStream.write:([B)V
        //   298: aload           8
        //   300: new             Ljava/lang/StringBuilder;
        //   303: dup            
        //   304: ldc             "\r\n"
        //   306: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   309: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   312: ldc             "--"
        //   314: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   317: ldc             "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f"
        //   319: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   322: ldc             "\r\n"
        //   324: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   327: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   330: invokevirtual   java/lang/String.getBytes:()[B
        //   333: invokevirtual   java/io/OutputStream.write:([B)V
        //   336: aload           4
        //   338: invokevirtual   android/os/Bundle.isEmpty:()Z
        //   341: ifne            366
        //   344: aload           4
        //   346: invokevirtual   android/os/Bundle.keySet:()Ljava/util/Set;
        //   349: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //   354: astore          12
        //   356: aload           12
        //   358: invokeinterface java/util/Iterator.hasNext:()Z
        //   363: ifne            431
        //   366: aload           8
        //   368: invokevirtual   java/io/OutputStream.flush:()V
        //   371: aload           8
        //   373: invokevirtual   java/io/OutputStream.close:()V
        //   376: aload_3        
        //   377: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
        //   380: invokestatic    com/facebook/android/Util.read:(Ljava/io/InputStream;)Ljava/lang/String;
        //   383: astore          11
        //   385: aload           11
        //   387: areturn        
        //   388: aload           5
        //   390: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   395: checkcast       Ljava/lang/String;
        //   398: astore          6
        //   400: aload_2        
        //   401: aload           6
        //   403: invokevirtual   android/os/Bundle.get:(Ljava/lang/String;)Ljava/lang/Object;
        //   406: astore          7
        //   408: aload           7
        //   410: instanceof      [B
        //   413: ifeq            140
        //   416: aload           4
        //   418: aload           6
        //   420: aload           7
        //   422: checkcast       [B
        //   425: invokevirtual   android/os/Bundle.putByteArray:(Ljava/lang/String;[B)V
        //   428: goto            140
        //   431: aload           12
        //   433: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   438: checkcast       Ljava/lang/String;
        //   441: astore          13
        //   443: aload           8
        //   445: new             Ljava/lang/StringBuilder;
        //   448: dup            
        //   449: ldc             "Content-Disposition: form-data; filename=\""
        //   451: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   454: aload           13
        //   456: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   459: ldc             "\""
        //   461: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   464: ldc             "\r\n"
        //   466: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   469: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   472: invokevirtual   java/lang/String.getBytes:()[B
        //   475: invokevirtual   java/io/OutputStream.write:([B)V
        //   478: aload           8
        //   480: new             Ljava/lang/StringBuilder;
        //   483: dup            
        //   484: ldc             "Content-Type: content/unknown"
        //   486: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   489: ldc             "\r\n"
        //   491: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   494: ldc             "\r\n"
        //   496: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   499: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   502: invokevirtual   java/lang/String.getBytes:()[B
        //   505: invokevirtual   java/io/OutputStream.write:([B)V
        //   508: aload           8
        //   510: aload           4
        //   512: aload           13
        //   514: invokevirtual   android/os/Bundle.getByteArray:(Ljava/lang/String;)[B
        //   517: invokevirtual   java/io/OutputStream.write:([B)V
        //   520: aload           8
        //   522: new             Ljava/lang/StringBuilder;
        //   525: dup            
        //   526: ldc             "\r\n"
        //   528: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   531: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   534: ldc             "--"
        //   536: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   539: ldc             "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f"
        //   541: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   544: ldc             "\r\n"
        //   546: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   549: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   552: invokevirtual   java/lang/String.getBytes:()[B
        //   555: invokevirtual   java/io/OutputStream.write:([B)V
        //   558: goto            356
        //   561: astore          9
        //   563: aload           8
        //   565: invokevirtual   java/io/OutputStream.close:()V
        //   568: aload           9
        //   570: athrow         
        //   571: astore          10
        //   573: aload_3        
        //   574: invokevirtual   java/net/HttpURLConnection.getErrorStream:()Ljava/io/InputStream;
        //   577: invokestatic    com/facebook/android/Util.read:(Ljava/io/InputStream;)Ljava/lang/String;
        //   580: areturn        
        //    Exceptions:
        //  throws java.net.MalformedURLException
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  254    356    561    571    Any
        //  356    366    561    571    Any
        //  366    371    561    571    Any
        //  376    385    571    581    Ljava/io/FileNotFoundException;
        //  431    558    561    571    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0376:
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
    
    @Deprecated
    public static JSONObject parseJson(String s) throws JSONException, FacebookError {
        if (s.equals("false")) {
            throw new FacebookError("request failed");
        }
        if (s.equals("true")) {
            s = "{value : true}";
        }
        final JSONObject jsonObject = new JSONObject(s);
        if (jsonObject.has("error")) {
            final JSONObject jsonObject2 = jsonObject.getJSONObject("error");
            throw new FacebookError(jsonObject2.getString("message"), jsonObject2.getString("type"), 0);
        }
        if (jsonObject.has("error_code") && jsonObject.has("error_msg")) {
            throw new FacebookError(jsonObject.getString("error_msg"), "", Integer.parseInt(jsonObject.getString("error_code")));
        }
        if (jsonObject.has("error_code")) {
            throw new FacebookError("request failed", "", Integer.parseInt(jsonObject.getString("error_code")));
        }
        if (jsonObject.has("error_msg")) {
            throw new FacebookError(jsonObject.getString("error_msg"));
        }
        if (jsonObject.has("error_reason")) {
            throw new FacebookError(jsonObject.getString("error_reason"));
        }
        return jsonObject;
    }
    
    @Deprecated
    public static Bundle parseUrl(final String s) {
        final String replace = s.replace("fbconnect", "http");
        try {
            final URL url = new URL(replace);
            final Bundle decodeUrl = decodeUrl(url.getQuery());
            decodeUrl.putAll(decodeUrl(url.getRef()));
            return decodeUrl;
        }
        catch (MalformedURLException ex) {
            return new Bundle();
        }
    }
    
    @Deprecated
    private static String read(final InputStream in) throws IOException {
        final StringBuilder sb = new StringBuilder();
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in), 1000);
        for (String str = bufferedReader.readLine(); str != null; str = bufferedReader.readLine()) {
            sb.append(str);
        }
        in.close();
        return sb.toString();
    }
    
    @Deprecated
    public static void showAlert(final Context context, final String title, final String message) {
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder(context);
        alertDialog$Builder.setTitle((CharSequence)title);
        alertDialog$Builder.setMessage((CharSequence)message);
        alertDialog$Builder.create().show();
    }
}
