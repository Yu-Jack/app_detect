// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.annotation.SuppressLint;
import com.facebook.c.d;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import org.json.JSONTokener;
import com.facebook.b.v;
import com.facebook.b.aj;
import java.util.List;
import java.io.InputStream;
import com.facebook.c.h;
import java.net.HttpURLConnection;
import com.facebook.b.c;

public class bb
{
    static final /* synthetic */ boolean a;
    private static c i;
    private final HttpURLConnection b;
    private final com.facebook.c.c c;
    private final h d;
    private final boolean e;
    private final ae f;
    private final String g;
    private final Request h;
    
    static {
        a = !bb.class.desiredAssertionStatus();
    }
    
    bb(final Request request, final HttpURLConnection httpURLConnection, final ae ae) {
        this(request, httpURLConnection, null, null, null, false, ae);
    }
    
    private bb(final Request h, final HttpURLConnection b, final String g, final com.facebook.c.c c, final h d, final boolean e, final ae f) {
        this.h = h;
        this.b = b;
        this.g = g;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    bb(final Request request, final HttpURLConnection httpURLConnection, final String s, final com.facebook.c.c c, final boolean b) {
        this(request, httpURLConnection, s, c, null, b, null);
    }
    
    private bb(final Request request, final HttpURLConnection httpURLConnection, final String s, final h h, final boolean b) {
        this(request, httpURLConnection, s, null, h, b, null);
    }
    
    private static List a(final InputStream inputStream, final HttpURLConnection httpURLConnection, final aw aw, final boolean b) {
        final String a = aj.a(inputStream);
        v.a(ak.c, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", a.length(), a);
        return a(a, httpURLConnection, aw, b);
    }
    
    static List a(final String s, final HttpURLConnection httpURLConnection, final aw aw, final boolean b) {
        final List a = a(httpURLConnection, aw, new JSONTokener(s).nextValue(), b);
        v.a(ak.a, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", aw.b(), s.length(), a);
        return a;
    }
    
    static List a(final HttpURLConnection p0, final aw p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_2       
        //     2: aload_1        
        //     3: instanceof      Lcom/facebook/b/b;
        //     6: ifeq            533
        //     9: aload_1        
        //    10: checkcast       Lcom/facebook/b/b;
        //    13: astore          17
        //    15: getstatic       com/facebook/bb.i:Lcom/facebook/b/c;
        //    18: ifnonnull       52
        //    21: invokestatic    com/facebook/bc.g:()Landroid/content/Context;
        //    24: astore          31
        //    26: aload           31
        //    28: ifnull          52
        //    31: new             Lcom/facebook/b/c;
        //    34: dup            
        //    35: aload           31
        //    37: ldc             "ResponseCache"
        //    39: new             Lcom/facebook/b/g;
        //    42: dup            
        //    43: invokespecial   com/facebook/b/g.<init>:()V
        //    46: invokespecial   com/facebook/b/c.<init>:(Landroid/content/Context;Ljava/lang/String;Lcom/facebook/b/g;)V
        //    49: putstatic       com/facebook/bb.i:Lcom/facebook/b/c;
        //    52: getstatic       com/facebook/bb.i:Lcom/facebook/b/c;
        //    55: astore          18
        //    57: aload           17
        //    59: invokevirtual   com/facebook/b/b.i:()Ljava/lang/String;
        //    62: astore          19
        //    64: aload           19
        //    66: invokestatic    com/facebook/b/aj.a:(Ljava/lang/String;)Z
        //    69: ifeq            90
        //    72: aload_1        
        //    73: invokevirtual   com/facebook/aw.size:()I
        //    76: iconst_1       
        //    77: if_icmpne       143
        //    80: aload_1        
        //    81: iconst_0       
        //    82: invokevirtual   com/facebook/aw.a:(I)Lcom/facebook/Request;
        //    85: invokevirtual   com/facebook/Request.g:()Ljava/lang/String;
        //    88: astore          19
        //    90: aload           17
        //    92: invokevirtual   com/facebook/b/b.j:()Z
        //    95: ifne            520
        //    98: aload           18
        //   100: ifnull          520
        //   103: aload           19
        //   105: invokestatic    com/facebook/b/aj.a:(Ljava/lang/String;)Z
        //   108: ifne            520
        //   111: aload           18
        //   113: aload           19
        //   115: invokevirtual   com/facebook/b/c.a:(Ljava/lang/String;)Ljava/io/InputStream;
        //   118: astore          27
        //   120: aload           27
        //   122: astore_2       
        //   123: aload_2        
        //   124: ifnull          266
        //   127: aload_2        
        //   128: aconst_null    
        //   129: aload_1        
        //   130: iconst_1       
        //   131: invokestatic    com/facebook/bb.a:(Ljava/io/InputStream;Ljava/net/HttpURLConnection;Lcom/facebook/aw;Z)Ljava/util/List;
        //   134: astore          30
        //   136: aload_2        
        //   137: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //   140: aload           30
        //   142: areturn        
        //   143: getstatic       com/facebook/ak.a:Lcom/facebook/ak;
        //   146: ldc             "ResponseCache"
        //   148: ldc             "Not using cache for cacheable request because no key was specified"
        //   150: invokestatic    com/facebook/b/v.a:(Lcom/facebook/ak;Ljava/lang/String;Ljava/lang/String;)V
        //   153: goto            90
        //   156: astore          25
        //   158: aconst_null    
        //   159: astore          26
        //   161: aload           26
        //   163: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //   166: aload           19
        //   168: astore          5
        //   170: aload           26
        //   172: astore          4
        //   174: aload           18
        //   176: astore_3       
        //   177: aload_0        
        //   178: invokevirtual   java/net/HttpURLConnection.getResponseCode:()I
        //   181: sipush          400
        //   184: if_icmplt       287
        //   187: aload_0        
        //   188: invokevirtual   java/net/HttpURLConnection.getErrorStream:()Ljava/io/InputStream;
        //   191: astore          4
        //   193: aload           4
        //   195: aload_0        
        //   196: aload_1        
        //   197: iconst_0       
        //   198: invokestatic    com/facebook/bb.a:(Ljava/io/InputStream;Ljava/net/HttpURLConnection;Lcom/facebook/aw;Z)Ljava/util/List;
        //   201: astore          16
        //   203: aload           4
        //   205: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //   208: aload           16
        //   210: areturn        
        //   211: astore          23
        //   213: aload_2        
        //   214: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //   217: aload           18
        //   219: astore_3       
        //   220: aload           19
        //   222: astore          24
        //   224: aload_2        
        //   225: astore          4
        //   227: aload           24
        //   229: astore          5
        //   231: goto            177
        //   234: astore          21
        //   236: aload_2        
        //   237: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //   240: aload           18
        //   242: astore_3       
        //   243: aload           19
        //   245: astore          22
        //   247: aload_2        
        //   248: astore          4
        //   250: aload           22
        //   252: astore          5
        //   254: goto            177
        //   257: astore          20
        //   259: aload_2        
        //   260: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //   263: aload           20
        //   265: athrow         
        //   266: aload_2        
        //   267: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //   270: aload           18
        //   272: astore_3       
        //   273: aload           19
        //   275: astore          28
        //   277: aload_2        
        //   278: astore          4
        //   280: aload           28
        //   282: astore          5
        //   284: goto            177
        //   287: aload_0        
        //   288: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
        //   291: astore          4
        //   293: aload_3        
        //   294: ifnull          193
        //   297: aload           5
        //   299: ifnull          193
        //   302: aload           4
        //   304: ifnull          193
        //   307: aload_3        
        //   308: aload           5
        //   310: aload           4
        //   312: invokevirtual   com/facebook/b/c.a:(Ljava/lang/String;Ljava/io/InputStream;)Ljava/io/InputStream;
        //   315: astore          15
        //   317: aload           15
        //   319: ifnull          193
        //   322: aload           15
        //   324: astore          4
        //   326: goto            193
        //   329: astore          13
        //   331: getstatic       com/facebook/ak.a:Lcom/facebook/ak;
        //   334: ldc             "Response"
        //   336: ldc             "Response <Error>: %s"
        //   338: iconst_1       
        //   339: anewarray       Ljava/lang/Object;
        //   342: dup            
        //   343: iconst_0       
        //   344: aload           13
        //   346: aastore        
        //   347: invokestatic    com/facebook/b/v.a:(Lcom/facebook/ak;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   350: aload_1        
        //   351: aload_0        
        //   352: aload           13
        //   354: invokestatic    com/facebook/bb.a:(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/ab;)Ljava/util/List;
        //   357: astore          14
        //   359: aload           4
        //   361: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //   364: aload           14
        //   366: areturn        
        //   367: astore          11
        //   369: getstatic       com/facebook/ak.a:Lcom/facebook/ak;
        //   372: ldc             "Response"
        //   374: ldc             "Response <Error>: %s"
        //   376: iconst_1       
        //   377: anewarray       Ljava/lang/Object;
        //   380: dup            
        //   381: iconst_0       
        //   382: aload           11
        //   384: aastore        
        //   385: invokestatic    com/facebook/b/v.a:(Lcom/facebook/ak;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   388: aload_1        
        //   389: aload_0        
        //   390: new             Lcom/facebook/ab;
        //   393: dup            
        //   394: aload           11
        //   396: invokespecial   com/facebook/ab.<init>:(Ljava/lang/Throwable;)V
        //   399: invokestatic    com/facebook/bb.a:(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/ab;)Ljava/util/List;
        //   402: astore          12
        //   404: aload           4
        //   406: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //   409: aload           12
        //   411: areturn        
        //   412: astore          9
        //   414: getstatic       com/facebook/ak.a:Lcom/facebook/ak;
        //   417: ldc             "Response"
        //   419: ldc             "Response <Error>: %s"
        //   421: iconst_1       
        //   422: anewarray       Ljava/lang/Object;
        //   425: dup            
        //   426: iconst_0       
        //   427: aload           9
        //   429: aastore        
        //   430: invokestatic    com/facebook/b/v.a:(Lcom/facebook/ak;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   433: aload_1        
        //   434: aload_0        
        //   435: new             Lcom/facebook/ab;
        //   438: dup            
        //   439: aload           9
        //   441: invokespecial   com/facebook/ab.<init>:(Ljava/lang/Throwable;)V
        //   444: invokestatic    com/facebook/bb.a:(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/ab;)Ljava/util/List;
        //   447: astore          10
        //   449: aload           4
        //   451: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //   454: aload           10
        //   456: areturn        
        //   457: astore          7
        //   459: getstatic       com/facebook/ak.a:Lcom/facebook/ak;
        //   462: ldc             "Response"
        //   464: ldc             "Response <Error>: %s"
        //   466: iconst_1       
        //   467: anewarray       Ljava/lang/Object;
        //   470: dup            
        //   471: iconst_0       
        //   472: aload           7
        //   474: aastore        
        //   475: invokestatic    com/facebook/b/v.a:(Lcom/facebook/ak;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   478: aload_1        
        //   479: aload_0        
        //   480: new             Lcom/facebook/ab;
        //   483: dup            
        //   484: aload           7
        //   486: invokespecial   com/facebook/ab.<init>:(Ljava/lang/Throwable;)V
        //   489: invokestatic    com/facebook/bb.a:(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/ab;)Ljava/util/List;
        //   492: astore          8
        //   494: aload           4
        //   496: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //   499: aload           8
        //   501: areturn        
        //   502: astore          6
        //   504: aload           4
        //   506: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //   509: aload           6
        //   511: athrow         
        //   512: astore          29
        //   514: aload_2        
        //   515: astore          26
        //   517: goto            161
        //   520: aload           18
        //   522: astore_3       
        //   523: aload           19
        //   525: astore          5
        //   527: aconst_null    
        //   528: astore          4
        //   530: goto            177
        //   533: aconst_null    
        //   534: astore_3       
        //   535: aconst_null    
        //   536: astore          4
        //   538: aconst_null    
        //   539: astore          5
        //   541: goto            177
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                         
        //  -----  -----  -----  -----  -----------------------------
        //  111    120    156    161    Lcom/facebook/ab;
        //  111    120    211    234    Lorg/json/JSONException;
        //  111    120    234    257    Ljava/io/IOException;
        //  111    120    257    266    Any
        //  127    136    512    520    Lcom/facebook/ab;
        //  127    136    211    234    Lorg/json/JSONException;
        //  127    136    234    257    Ljava/io/IOException;
        //  127    136    257    266    Any
        //  177    193    329    367    Lcom/facebook/ab;
        //  177    193    367    412    Lorg/json/JSONException;
        //  177    193    412    457    Ljava/io/IOException;
        //  177    193    457    502    Ljava/lang/SecurityException;
        //  177    193    502    512    Any
        //  193    203    329    367    Lcom/facebook/ab;
        //  193    203    367    412    Lorg/json/JSONException;
        //  193    203    412    457    Ljava/io/IOException;
        //  193    203    457    502    Ljava/lang/SecurityException;
        //  193    203    502    512    Any
        //  287    293    329    367    Lcom/facebook/ab;
        //  287    293    367    412    Lorg/json/JSONException;
        //  287    293    412    457    Ljava/io/IOException;
        //  287    293    457    502    Ljava/lang/SecurityException;
        //  287    293    502    512    Any
        //  307    317    329    367    Lcom/facebook/ab;
        //  307    317    367    412    Lorg/json/JSONException;
        //  307    317    412    457    Ljava/io/IOException;
        //  307    317    457    502    Ljava/lang/SecurityException;
        //  307    317    502    512    Any
        //  331    359    502    512    Any
        //  369    404    502    512    Any
        //  414    449    502    512    Any
        //  459    494    502    512    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:635)
        //     at java.util.ArrayList.get(ArrayList.java:411)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:3037)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2446)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:109)
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
    
    @SuppressLint({ "Assert" })
    private static List a(final HttpURLConnection httpURLConnection, final List list, final Object o, final boolean b) {
        if (!bb.a && httpURLConnection == null && !b) {
            throw new AssertionError();
        }
        final int size = list.size();
        final ArrayList list2 = new ArrayList<bb>(size);
        while (true) {
            Label_0219: {
                if (size != 1) {
                    break Label_0219;
                }
                final Request request = list.get(0);
                Object o2 = null;
                Label_0225: {
                    try {
                        final JSONObject jsonObject = new JSONObject();
                        jsonObject.put("body", o);
                        int responseCode;
                        if (httpURLConnection != null) {
                            responseCode = httpURLConnection.getResponseCode();
                        }
                        else {
                            responseCode = 200;
                        }
                        jsonObject.put("code", responseCode);
                        o2 = new JSONArray();
                        ((JSONArray)o2).put((Object)jsonObject);
                        if (!(o2 instanceof JSONArray) || ((JSONArray)o2).length() != size) {
                            throw new ab("Unexpected number of results");
                        }
                        break Label_0225;
                    }
                    catch (JSONException ex) {
                        list2.add(new bb(request, httpURLConnection, new ae(httpURLConnection, (Exception)ex)));
                        o2 = o;
                        continue;
                    }
                    catch (IOException ex2) {
                        list2.add(new bb(request, httpURLConnection, new ae(httpURLConnection, ex2)));
                    }
                    break Label_0219;
                }
                final JSONArray jsonArray = (JSONArray)o2;
                for (int i = 0; i < jsonArray.length(); ++i) {
                Label_0522_Outer:
                    while (true) {
                        final Request request2 = list.get(i);
                        Label_0591: {
                            while (true) {
                                Object value = null;
                                Label_0584: {
                                    Object null;
                                    while (true) {
                                        try {
                                            value = jsonArray.get(i);
                                            if (value instanceof JSONObject) {
                                                final JSONObject jsonObject2 = (JSONObject)value;
                                                final ae a = ae.a(jsonObject2, o, httpURLConnection);
                                                bb bb;
                                                if (a != null) {
                                                    if (a.b() == 190) {
                                                        final bc c = request2.c();
                                                        if (c != null) {
                                                            c.e();
                                                        }
                                                    }
                                                    bb = new bb(request2, httpURLConnection, a);
                                                }
                                                else {
                                                    final Object a2 = aj.a(jsonObject2, "body", "FACEBOOK_NON_JSON_RESULT");
                                                    if (!(a2 instanceof JSONObject)) {
                                                        goto Label_0440;
                                                    }
                                                    bb = new bb(request2, httpURLConnection, a2.toString(), d.a((JSONObject)a2), b);
                                                }
                                                list2.add(bb);
                                                break Label_0591;
                                            }
                                            break Label_0584;
                                        }
                                        catch (JSONException ex3) {
                                            list2.add(new bb(request2, httpURLConnection, new ae(httpURLConnection, (Exception)ex3)));
                                            break Label_0591;
                                        }
                                        catch (ab ab) {
                                            list2.add(new bb(request2, httpURLConnection, new ae(httpURLConnection, ab)));
                                            break Label_0591;
                                        }
                                        null = JSONObject.NULL;
                                        if (null == JSONObject.NULL) {
                                            final bb bb = new bb(request2, httpURLConnection, null.toString(), (com.facebook.c.c)null, b);
                                            continue Label_0522_Outer;
                                        }
                                        break;
                                    }
                                    throw new ab("Got unexpected object type in response, class: " + null.getClass().getSimpleName());
                                }
                                Object null = value;
                                continue;
                            }
                        }
                        break;
                    }
                }
                return list2;
            }
            Object o2 = o;
            continue;
        }
    }
    
    static List a(final List list, final HttpURLConnection httpURLConnection, final ab ab) {
        final int size = list.size();
        final ArrayList list2 = new ArrayList<bb>(size);
        for (int i = 0; i < size; ++i) {
            list2.add(new bb(list.get(i), httpURLConnection, new ae(httpURLConnection, ab)));
        }
        return list2;
    }
    
    public final ae a() {
        return this.f;
    }
    
    public final com.facebook.c.c a(final Class clazz) {
        if (this.c == null) {
            return null;
        }
        if (clazz == null) {
            throw new NullPointerException("Must pass in a valid interface that extends GraphObject");
        }
        return this.c.b();
    }
    
    public final com.facebook.c.c b() {
        return this.c;
    }
    
    @Override
    public String toString() {
        try {
            int responseCode;
            if (this.b != null) {
                responseCode = this.b.getResponseCode();
            }
            else {
                responseCode = 200;
            }
            final String value = String.valueOf(responseCode);
            return "{Response:  responseCode: " + value + ", graphObject: " + this.c + ", error: " + this.f + ", isFromCache:" + this.e + "}";
        }
        catch (IOException ex) {
            final String value = "unknown";
            return "{Response:  responseCode: " + value + ", graphObject: " + this.c + ", error: " + this.f + ", isFromCache:" + this.e + "}";
        }
    }
}
