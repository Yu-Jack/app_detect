// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.util.Log;
import android.os.ParcelFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri$Builder;
import java.net.URLEncoder;
import android.text.TextUtils;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;
import org.json.JSONObject;
import com.facebook.c.h;
import java.util.regex.Matcher;
import android.os.Handler;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.OutputStream;
import java.net.URL;
import com.facebook.b.v;
import org.json.JSONArray;
import java.util.Map;
import java.util.Iterator;
import java.util.HashSet;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Collection;
import java.util.Arrays;
import com.facebook.b.al;
import com.facebook.c.i;
import com.facebook.b.ad;
import android.os.Bundle;
import com.facebook.c.c;
import java.util.regex.Pattern;

public class Request
{
    public static final String a;
    private static String b;
    private static Pattern c;
    private static volatile String p;
    private bc d;
    private aj e;
    private String f;
    private c g;
    private String h;
    private String i;
    private boolean j;
    private Bundle k;
    private aq l;
    private String m;
    private Object n;
    private String o;
    
    static {
        a = Request.class.getSimpleName();
        Request.c = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    }
    
    public Request() {
        this(null, null, null, null, null);
    }
    
    public Request(final bc bc, final String s, final Bundle bundle, final aj aj, final aq aq) {
        this(bc, s, bundle, aj, aq, (byte)0);
    }
    
    private Request(final bc d, final String f, final Bundle bundle, aj a, final aq l, final byte b) {
        this.j = true;
        this.d = d;
        this.f = f;
        this.l = l;
        this.o = null;
        if (this.m != null && a != aj.a) {
            throw new ab("Can't change HTTP method on request with overridden URL.");
        }
        if (a == null) {
            a = aj.a;
        }
        this.e = a;
        if (bundle != null) {
            this.k = new Bundle(bundle);
        }
        else {
            this.k = new Bundle();
        }
        if (this.o == null) {
            this.o = ad.d();
        }
    }
    
    public static Request a(final bc bc, final ar ar) {
        return new Request(bc, "me", null, null, new aq() {
            @Override
            public final void a(final bb bb) {
                if (ar != null) {
                    ar.a((i)bb.a(i.class), bb);
                }
            }
        });
    }
    
    public static Request a(final String s) {
        return new Request(null, s, null, null, null);
    }
    
    public static Request a(final String s, final c g) {
        final Request request = new Request(null, s, null, aj.b, null);
        request.g = g;
        return request;
    }
    
    public static av a(final Request... a) {
        al.a(a, "requests");
        return b(new aw(Arrays.asList(a)));
    }
    
    public static List a(final aw aw) {
        al.a(aw, "requests");
        try {
            return a(c(aw), aw);
        }
        catch (Exception ex) {
            final List a = bb.a(aw.d(), null, new ab(ex));
            a(aw, a);
            return a;
        }
    }
    
    public static List a(final HttpURLConnection httpURLConnection, final aw aw) {
        final List a = bb.a(httpURLConnection, aw);
        com.facebook.b.aj.a(httpURLConnection);
        final int size = aw.size();
        if (size != a.size()) {
            throw new ab(String.format("Received %d responses while expecting %d", a.size(), size));
        }
        a(aw, a);
        final HashSet<bc> set = new HashSet<bc>();
        for (final Request request : aw) {
            if (request.d != null) {
                set.add(request.d);
            }
        }
        final Iterator<bc> iterator2 = set.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().h();
        }
        return a;
    }
    
    private static void a(final Bundle bundle, final au au, final Request request) {
        for (final String s : bundle.keySet()) {
            final Object value = bundle.get(s);
            if (e(value)) {
                au.a(s, value, request);
            }
        }
    }
    
    private static void a(final au au, final Collection collection, final Map map) {
        final JSONArray jsonArray = new JSONArray();
        final Iterator<Request> iterator = collection.iterator();
        while (iterator.hasNext()) {
            iterator.next().a(jsonArray, map);
        }
        au.a("batch", jsonArray, collection);
    }
    
    private static void a(final aw aw, final v v, final int n, final URL url, final OutputStream outputStream) {
        final au au = new au(outputStream, v);
        if (n == 1) {
            final Request a = aw.a(0);
            final HashMap<String, ap> hashMap = new HashMap<String, ap>();
            for (final String s : a.k.keySet()) {
                final Object value = a.k.get(s);
                if (d(value)) {
                    hashMap.put(s, new ap(a, value));
                }
            }
            if (v != null) {
                v.b("  Parameters:\n");
            }
            a(a.k, au, a);
            if (v != null) {
                v.b("  Attachments:\n");
            }
            a(hashMap, au);
            if (a.g != null) {
                a(a.g, url.getPath(), au);
            }
            return;
        }
        final String e = e(aw);
        if (com.facebook.b.aj.a(e)) {
            throw new ab("At least one request in a batch must have an open Session, or a default app ID must be specified.");
        }
        au.a("batch_app_id", e);
        final HashMap hashMap2 = new HashMap();
        a(au, aw, hashMap2);
        if (v != null) {
            v.b("  Attachments:\n");
        }
        a(hashMap2, au);
    }
    
    private static void a(final aw aw, final List list) {
        final int size = aw.size();
        final ArrayList<Pair> list2 = new ArrayList<Pair>();
        for (int i = 0; i < size; ++i) {
            final Request a = aw.a(i);
            if (a.l != null) {
                list2.add(new Pair((Object)a.l, (Object)list.get(i)));
            }
        }
        if (list2.size() > 0) {
            final Runnable runnable = new Runnable() {
                @Override
                public final void run() {
                    for (final Pair pair : list2) {
                        ((aq)pair.first).a((bb)pair.second);
                    }
                    for (final ax ax : aw.e()) {
                        final aw b = aw;
                        ax.a();
                    }
                }
            };
            final Handler c = aw.c();
            if (c != null) {
                c.post((Runnable)runnable);
                return;
            }
            runnable.run();
        }
    }
    
    private static void a(final c c, final String input, final as as) {
        final Matcher matcher = Request.c.matcher(input);
        String group;
        if (matcher.matches()) {
            group = matcher.group(1);
        }
        else {
            group = input;
        }
        int n;
        if (group.startsWith("me/") || group.startsWith("/me/")) {
            n = 1;
        }
        else {
            n = 0;
        }
        int n3;
        if (n != 0) {
            final int index = input.indexOf(":");
            final int index2 = input.indexOf("?");
            int n2;
            if (index > 3 && (index2 == -1 || index < index2)) {
                n2 = 1;
            }
            else {
                n2 = 0;
            }
            n3 = n2;
        }
        else {
            n3 = 0;
        }
        for (final Map.Entry<String, V> entry : c.c().entrySet()) {
            a(entry.getKey(), entry.getValue(), as, n3 != 0 && entry.getKey().equalsIgnoreCase("image"));
        }
    }
    
    private static void a(final String s, final Object o, final as as, final boolean b) {
        Object o2 = o;
        Serializable class1 = null;
        Label_0244: {
            while (true) {
                JSONObject jsonObject = null;
                Iterator keys = null;
                Label_0129: {
                Label_0087:
                    while (true) {
                        class1 = ((c)o2).getClass();
                        if (c.class.isAssignableFrom((Class<?>)class1)) {
                            final JSONObject d = ((c)o2).d();
                            final Class<? extends JSONObject> class2 = d.getClass();
                            o2 = d;
                            class1 = class2;
                        }
                        else if (h.class.isAssignableFrom((Class<?>)class1)) {
                            final JSONArray a = ((h)o2).a();
                            final Class<? extends JSONArray> class3 = a.getClass();
                            o2 = a;
                            class1 = class3;
                        }
                        if (!JSONObject.class.isAssignableFrom((Class<?>)class1)) {
                            break Label_0244;
                        }
                        jsonObject = (JSONObject)o2;
                        if (b) {
                            keys = jsonObject.keys();
                            while (true) {
                                if (!keys.hasNext()) {
                                    break Label_0087;
                                }
                                break Label_0129;
                            }
                        }
                        else if (jsonObject.has("id")) {
                            o2 = jsonObject.optString("id");
                        }
                        else if (jsonObject.has("url")) {
                            o2 = jsonObject.optString("url");
                        }
                        else {
                            if (!jsonObject.has("fbsdk:create_object")) {
                                break;
                            }
                            o2 = jsonObject.toString();
                        }
                    }
                    return;
                }
                final String s2 = keys.next();
                a(String.format("%s[%s]", s, s2), jsonObject.opt(s2), as, b);
                continue;
            }
        }
        if (JSONArray.class.isAssignableFrom((Class<?>)class1)) {
            final JSONArray jsonArray = (JSONArray)o2;
            for (int length = jsonArray.length(), i = 0; i < length; ++i) {
                a(String.format("%s[%d]", s, i), jsonArray.opt(i), as, b);
            }
            return;
        }
        if (String.class.isAssignableFrom((Class<?>)class1) || Number.class.isAssignableFrom((Class<?>)class1) || Boolean.class.isAssignableFrom((Class<?>)class1)) {
            as.a(s, o2.toString());
            return;
        }
        if (Date.class.isAssignableFrom((Class<?>)class1)) {
            as.a(s, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date)o2));
        }
    }
    
    private static void a(final Map map, final au au) {
        for (final String s : map.keySet()) {
            final ap ap = (ap)map.get(s);
            if (d(ap.b())) {
                au.a(s, ap.b(), ap.a());
            }
        }
    }
    
    private void a(final JSONArray jsonArray, final Map map) {
        final JSONObject jsonObject = new JSONObject();
        if (this.h != null) {
            jsonObject.put("name", (Object)this.h);
            jsonObject.put("omit_response_on_success", this.j);
        }
        if (this.i != null) {
            jsonObject.put("depends_on", (Object)this.i);
        }
        final String i = this.i();
        jsonObject.put("relative_url", (Object)i);
        jsonObject.put("method", (Object)this.e);
        if (this.d != null) {
            v.a(this.d.d());
        }
        final ArrayList<String> list = new ArrayList<String>();
        final Iterator<String> iterator = this.k.keySet().iterator();
        while (iterator.hasNext()) {
            final Object value = this.k.get((String)iterator.next());
            if (d(value)) {
                final String format = String.format("%s%d", "file", map.size());
                list.add(format);
                map.put(format, new ap(this, value));
            }
        }
        if (!list.isEmpty()) {
            jsonObject.put("attached_files", (Object)TextUtils.join((CharSequence)",", (Iterable)list));
        }
        if (this.g != null) {
            final ArrayList list2 = new ArrayList();
            a(this.g, i, new as() {
                @Override
                public final void a(final String s, final String s2) {
                    list2.add(String.format("%s=%s", s, URLEncoder.encode(s2, "UTF-8")));
                }
            });
            jsonObject.put("body", (Object)TextUtils.join((CharSequence)"&", (Iterable)list2));
        }
        jsonArray.put((Object)jsonObject);
    }
    
    public static av b(final aw aw) {
        al.a(aw, "requests");
        final av av = new av(aw);
        av.a();
        return av;
    }
    
    private String b(final String s) {
        final Uri$Builder encodedPath = new Uri$Builder().encodedPath(s);
        for (final String s2 : this.k.keySet()) {
            Object value = this.k.get(s2);
            if (value == null) {
                value = "";
            }
            if (e(value)) {
                encodedPath.appendQueryParameter(s2, f(value).toString());
            }
            else {
                if (this.e == aj.a) {
                    throw new IllegalArgumentException(String.format("Unsupported parameter type for GET request: %s", value.getClass().getSimpleName()));
                }
                continue;
            }
        }
        return encodedPath.toString();
    }
    
    private static HttpURLConnection c(final aw p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: invokevirtual   com/facebook/aw.size:()I
        //     4: iconst_1       
        //     5: if_icmpne       290
        //     8: new             Ljava/net/URL;
        //    11: dup            
        //    12: aload_0        
        //    13: iconst_0       
        //    14: invokevirtual   com/facebook/aw.a:(I)Lcom/facebook/Request;
        //    17: invokevirtual   com/facebook/Request.g:()Ljava/lang/String;
        //    20: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //    23: astore_2       
        //    24: aload_2        
        //    25: invokevirtual   java/net/URL.openConnection:()Ljava/net/URLConnection;
        //    28: checkcast       Ljava/net/HttpURLConnection;
        //    31: astore          5
        //    33: getstatic       com/facebook/Request.p:Ljava/lang/String;
        //    36: ifnonnull       64
        //    39: ldc_w           "%s.%s"
        //    42: iconst_2       
        //    43: anewarray       Ljava/lang/Object;
        //    46: dup            
        //    47: iconst_0       
        //    48: ldc_w           "FBAndroidSDK"
        //    51: aastore        
        //    52: dup            
        //    53: iconst_1       
        //    54: ldc_w           "3.17.0"
        //    57: aastore        
        //    58: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //    61: putstatic       com/facebook/Request.p:Ljava/lang/String;
        //    64: aload           5
        //    66: ldc_w           "User-Agent"
        //    69: getstatic       com/facebook/Request.p:Ljava/lang/String;
        //    72: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //    75: aload           5
        //    77: ldc_w           "Content-Type"
        //    80: ldc_w           "multipart/form-data; boundary=%s"
        //    83: iconst_1       
        //    84: anewarray       Ljava/lang/Object;
        //    87: dup            
        //    88: iconst_0       
        //    89: ldc_w           "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f"
        //    92: aastore        
        //    93: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //    96: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //    99: aload           5
        //   101: ldc_w           "Accept-Language"
        //   104: invokestatic    java/util/Locale.getDefault:()Ljava/util/Locale;
        //   107: invokevirtual   java/util/Locale.toString:()Ljava/lang/String;
        //   110: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   113: aload           5
        //   115: iconst_0       
        //   116: invokevirtual   java/net/HttpURLConnection.setChunkedStreamingMode:(I)V
        //   119: new             Lcom/facebook/b/v;
        //   122: dup            
        //   123: getstatic       com/facebook/ak.a:Lcom/facebook/ak;
        //   126: ldc_w           "Request"
        //   129: invokespecial   com/facebook/b/v.<init>:(Lcom/facebook/ak;Ljava/lang/String;)V
        //   132: astore          6
        //   134: aload_0        
        //   135: invokevirtual   com/facebook/aw.size:()I
        //   138: istore          7
        //   140: iload           7
        //   142: iconst_1       
        //   143: if_icmpne       317
        //   146: aload_0        
        //   147: iconst_0       
        //   148: invokevirtual   com/facebook/aw.a:(I)Lcom/facebook/Request;
        //   151: getfield        com/facebook/Request.e:Lcom/facebook/aj;
        //   154: astore          8
        //   156: aload           5
        //   158: aload           8
        //   160: invokevirtual   com/facebook/aj.name:()Ljava/lang/String;
        //   163: invokevirtual   java/net/HttpURLConnection.setRequestMethod:(Ljava/lang/String;)V
        //   166: aload           5
        //   168: invokevirtual   java/net/HttpURLConnection.getURL:()Ljava/net/URL;
        //   171: astore          9
        //   173: aload           6
        //   175: ldc_w           "Request:\n"
        //   178: invokevirtual   com/facebook/b/v.b:(Ljava/lang/String;)V
        //   181: aload           6
        //   183: ldc_w           "Id"
        //   186: aload_0        
        //   187: invokevirtual   com/facebook/aw.b:()Ljava/lang/String;
        //   190: invokevirtual   com/facebook/b/v.a:(Ljava/lang/String;Ljava/lang/Object;)V
        //   193: aload           6
        //   195: ldc_w           "URL"
        //   198: aload           9
        //   200: invokevirtual   com/facebook/b/v.a:(Ljava/lang/String;Ljava/lang/Object;)V
        //   203: aload           6
        //   205: ldc_w           "Method"
        //   208: aload           5
        //   210: invokevirtual   java/net/HttpURLConnection.getRequestMethod:()Ljava/lang/String;
        //   213: invokevirtual   com/facebook/b/v.a:(Ljava/lang/String;Ljava/lang/Object;)V
        //   216: aload           6
        //   218: ldc_w           "User-Agent"
        //   221: aload           5
        //   223: ldc_w           "User-Agent"
        //   226: invokevirtual   java/net/HttpURLConnection.getRequestProperty:(Ljava/lang/String;)Ljava/lang/String;
        //   229: invokevirtual   com/facebook/b/v.a:(Ljava/lang/String;Ljava/lang/Object;)V
        //   232: aload           6
        //   234: ldc_w           "Content-Type"
        //   237: aload           5
        //   239: ldc_w           "Content-Type"
        //   242: invokevirtual   java/net/HttpURLConnection.getRequestProperty:(Ljava/lang/String;)Ljava/lang/String;
        //   245: invokevirtual   com/facebook/b/v.a:(Ljava/lang/String;Ljava/lang/Object;)V
        //   248: aload           5
        //   250: aload_0        
        //   251: invokevirtual   com/facebook/aw.a:()I
        //   254: invokevirtual   java/net/HttpURLConnection.setConnectTimeout:(I)V
        //   257: aload           5
        //   259: aload_0        
        //   260: invokevirtual   com/facebook/aw.a:()I
        //   263: invokevirtual   java/net/HttpURLConnection.setReadTimeout:(I)V
        //   266: aload           8
        //   268: getstatic       com/facebook/aj.b:Lcom/facebook/aj;
        //   271: if_acmpne       495
        //   274: iconst_1       
        //   275: istore          10
        //   277: iload           10
        //   279: ifne            325
        //   282: aload           6
        //   284: invokevirtual   com/facebook/b/v.a:()V
        //   287: aload           5
        //   289: areturn        
        //   290: new             Ljava/net/URL;
        //   293: dup            
        //   294: invokestatic    com/facebook/b/ad.b:()Ljava/lang/String;
        //   297: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //   300: astore_2       
        //   301: goto            24
        //   304: astore_1       
        //   305: new             Lcom/facebook/ab;
        //   308: dup            
        //   309: ldc_w           "could not construct URL for request"
        //   312: aload_1        
        //   313: invokespecial   com/facebook/ab.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   316: athrow         
        //   317: getstatic       com/facebook/aj.b:Lcom/facebook/aj;
        //   320: astore          8
        //   322: goto            156
        //   325: aload           5
        //   327: iconst_1       
        //   328: invokevirtual   java/net/HttpURLConnection.setDoOutput:(Z)V
        //   331: aload_0        
        //   332: invokestatic    com/facebook/Request.d:(Lcom/facebook/aw;)Z
        //   335: ifeq            447
        //   338: new             Lcom/facebook/an;
        //   341: dup            
        //   342: aload_0        
        //   343: invokevirtual   com/facebook/aw.c:()Landroid/os/Handler;
        //   346: invokespecial   com/facebook/an.<init>:(Landroid/os/Handler;)V
        //   349: astore          13
        //   351: aload_0        
        //   352: aconst_null    
        //   353: iload           7
        //   355: aload           9
        //   357: aload           13
        //   359: invokestatic    com/facebook/Request.a:(Lcom/facebook/aw;Lcom/facebook/b/v;ILjava/net/URL;Ljava/io/OutputStream;)V
        //   362: aload           13
        //   364: invokevirtual   com/facebook/an.a:()I
        //   367: istore          14
        //   369: aload           13
        //   371: invokevirtual   com/facebook/an.b:()Ljava/util/Map;
        //   374: astore          15
        //   376: new             Lcom/facebook/ao;
        //   379: dup            
        //   380: new             Ljava/io/BufferedOutputStream;
        //   383: dup            
        //   384: aload           5
        //   386: invokevirtual   java/net/HttpURLConnection.getOutputStream:()Ljava/io/OutputStream;
        //   389: invokespecial   java/io/BufferedOutputStream.<init>:(Ljava/io/OutputStream;)V
        //   392: aload_0        
        //   393: aload           15
        //   395: iload           14
        //   397: i2l            
        //   398: invokespecial   com/facebook/ao.<init>:(Ljava/io/OutputStream;Lcom/facebook/aw;Ljava/util/Map;J)V
        //   401: astore          16
        //   403: aload           16
        //   405: astore          12
        //   407: aload_0        
        //   408: aload           6
        //   410: iload           7
        //   412: aload           9
        //   414: aload           12
        //   416: invokestatic    com/facebook/Request.a:(Lcom/facebook/aw;Lcom/facebook/b/v;ILjava/net/URL;Ljava/io/OutputStream;)V
        //   419: aload           12
        //   421: invokevirtual   java/io/OutputStream.close:()V
        //   424: aload           6
        //   426: invokevirtual   com/facebook/b/v.a:()V
        //   429: aload           5
        //   431: areturn        
        //   432: astore          4
        //   434: new             Lcom/facebook/ab;
        //   437: dup            
        //   438: ldc_w           "could not construct request body"
        //   441: aload           4
        //   443: invokespecial   com/facebook/ab.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   446: athrow         
        //   447: new             Ljava/io/BufferedOutputStream;
        //   450: dup            
        //   451: aload           5
        //   453: invokevirtual   java/net/HttpURLConnection.getOutputStream:()Ljava/io/OutputStream;
        //   456: invokespecial   java/io/BufferedOutputStream.<init>:(Ljava/io/OutputStream;)V
        //   459: astore          12
        //   461: goto            407
        //   464: astore          11
        //   466: aconst_null    
        //   467: astore          12
        //   469: aload           12
        //   471: invokevirtual   java/io/OutputStream.close:()V
        //   474: aload           11
        //   476: athrow         
        //   477: astore_3       
        //   478: new             Lcom/facebook/ab;
        //   481: dup            
        //   482: ldc_w           "could not construct request body"
        //   485: aload_3        
        //   486: invokespecial   com/facebook/ab.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   489: athrow         
        //   490: astore          11
        //   492: goto            469
        //   495: iconst_0       
        //   496: istore          10
        //   498: goto            277
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  0      24     304    317    Ljava/net/MalformedURLException;
        //  24     64     432    447    Ljava/io/IOException;
        //  24     64     477    490    Lorg/json/JSONException;
        //  64     140    432    447    Ljava/io/IOException;
        //  64     140    477    490    Lorg/json/JSONException;
        //  146    156    432    447    Ljava/io/IOException;
        //  146    156    477    490    Lorg/json/JSONException;
        //  156    274    432    447    Ljava/io/IOException;
        //  156    274    477    490    Lorg/json/JSONException;
        //  282    287    432    447    Ljava/io/IOException;
        //  282    287    477    490    Lorg/json/JSONException;
        //  290    301    304    317    Ljava/net/MalformedURLException;
        //  317    322    432    447    Ljava/io/IOException;
        //  317    322    477    490    Lorg/json/JSONException;
        //  325    331    432    447    Ljava/io/IOException;
        //  325    331    477    490    Lorg/json/JSONException;
        //  331    403    464    469    Any
        //  407    419    490    495    Any
        //  419    429    432    447    Ljava/io/IOException;
        //  419    429    477    490    Lorg/json/JSONException;
        //  447    461    464    469    Any
        //  469    477    432    447    Ljava/io/IOException;
        //  469    477    477    490    Lorg/json/JSONException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 226, Size: 226
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
    
    private static boolean d(final aw aw) {
        final Iterator iterator = aw.e().iterator();
        while (iterator.hasNext()) {
            if (((ax)iterator.next()) instanceof ay) {
                return true;
            }
        }
        final Iterator<Request> iterator2 = aw.iterator();
        while (iterator2.hasNext()) {
            if (iterator2.next().l instanceof at) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean d(final Object o) {
        return o instanceof Bitmap || o instanceof byte[] || o instanceof ParcelFileDescriptor || o instanceof Request$ParcelFileDescriptorWithMimeType;
    }
    
    private static String e(final aw aw) {
        if (!com.facebook.b.aj.a(aw.f())) {
            return aw.f();
        }
        final Iterator<Request> iterator = aw.iterator();
        while (iterator.hasNext()) {
            final bc d = iterator.next().d;
            if (d != null) {
                return d.c();
            }
        }
        return Request.b;
    }
    
    private static boolean e(final Object o) {
        return o instanceof String || o instanceof Boolean || o instanceof Number || o instanceof Date;
    }
    
    private static String f(final Object obj) {
        if (obj instanceof String) {
            return (String)obj;
        }
        if (obj instanceof Boolean || obj instanceof Number) {
            return obj.toString();
        }
        if (obj instanceof Date) {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(obj);
        }
        throw new IllegalArgumentException("Unsupported parameter type.");
    }
    
    private void h() {
        if (this.d != null) {
            if (!this.d.a()) {
                throw new ab("Session provided to a Request in un-opened state.");
            }
            if (!this.k.containsKey("access_token")) {
                final String d = this.d.d();
                v.a(d);
                this.k.putString("access_token", d);
            }
        }
        else if (!this.k.containsKey("access_token")) {
            final String h = bq.h();
            final String i = bq.i();
            if (!com.facebook.b.aj.a(h) && !com.facebook.b.aj.a(i)) {
                this.k.putString("access_token", String.valueOf(h) + "|" + i);
            }
            else {
                Log.d(Request.a, "Warning: Sessionless Request needs token but missing either application ID or client token.");
            }
        }
        this.k.putString("sdk", "android");
        this.k.putString("format", "json");
    }
    
    private String i() {
        if (this.m != null) {
            throw new ab("Can't override URL for a batch request");
        }
        final String j = this.j();
        this.h();
        return this.b(j);
    }
    
    private String j() {
        if (Request.c.matcher(this.f).matches()) {
            return this.f;
        }
        return String.format("%s/%s", this.o, this.f);
    }
    
    public final c a() {
        return this.g;
    }
    
    public final void a(final Bundle k) {
        this.k = k;
    }
    
    public final void a(final aq l) {
        this.l = l;
    }
    
    public final void a(final c g) {
        this.g = g;
    }
    
    public final void a(final Object n) {
        this.n = n;
    }
    
    public final Bundle b() {
        return this.k;
    }
    
    public final bc c() {
        return this.d;
    }
    
    public final aq d() {
        return this.l;
    }
    
    public final Object e() {
        return this.n;
    }
    
    public final bb f() {
        final Request[] a = { this };
        al.a(a, "requests");
        final List a2 = a(new aw(Arrays.asList(a)));
        if (a2 == null || a2.size() != 1) {
            throw new ab("invalid state: expected a single response");
        }
        return a2.get(0);
    }
    
    final String g() {
        if (this.m != null) {
            return this.m.toString();
        }
        String s;
        if (this.e == aj.b && this.f != null && this.f.endsWith("/videos")) {
            s = ad.c();
        }
        else {
            s = ad.b();
        }
        final String format = String.format("%s/%s", s, this.j());
        this.h();
        return this.b(format);
    }
    
    @Override
    public String toString() {
        return "{Request:  session: " + this.d + ", graphPath: " + this.f + ", graphObject: " + this.g + ", httpMethod: " + this.e + ", parameters: " + this.k + "}";
    }
}
