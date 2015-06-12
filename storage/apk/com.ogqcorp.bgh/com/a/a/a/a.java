// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a.a;

import com.a.a.k;
import org.apache.http.HttpEntity;
import org.apache.http.impl.cookie.DateUtils;
import java.util.Date;
import com.a.a.c;
import com.a.a.u;
import com.a.a.x;
import java.io.Serializable;
import org.apache.http.StatusLine;
import com.a.a.n;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import com.a.a.y;
import com.a.a.h;

public class a implements h
{
    protected static final boolean a;
    private static int d;
    private static int e;
    protected final i b;
    protected final b c;
    
    static {
        a = y.b;
        com.a.a.a.a.d = 3000;
        com.a.a.a.a.e = 4096;
    }
    
    public a(final i i) {
        this(i, new b(com.a.a.a.a.e));
    }
    
    public a(final i b, final b c) {
        this.b = b;
        this.c = c;
    }
    
    private static Map<String, String> a(final Header[] array) {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        for (int i = 0; i < array.length; ++i) {
            hashMap.put(array[i].getName(), array[i].getValue());
        }
        return hashMap;
    }
    
    private void a(final long l, final n<?> n, final byte[] array, final StatusLine statusLine) {
        if (com.a.a.a.a.a || l > com.a.a.a.a.d) {
            final Object[] array2 = { n, l, null, null, null };
            Serializable value;
            if (array != null) {
                value = array.length;
            }
            else {
                value = "null";
            }
            array2[2] = value;
            array2[3] = statusLine.getStatusCode();
            array2[4] = n.t().b();
            y.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", array2);
        }
    }
    
    private static void a(final String s, final n<?> n, final x x) {
        final u t = n.t();
        final int s2 = n.s();
        try {
            t.a(x);
            n.a(String.format("%s-retry [timeout=%s]", s, s2));
        }
        catch (x x2) {
            n.a(String.format("%s-timeout-giveup [timeout=%s]", s, s2));
            throw x2;
        }
    }
    
    private void a(final Map<String, String> map, final c c) {
        if (c != null) {
            if (c.b != null) {
                map.put("If-None-Match", c.b);
            }
            if (c.c > 0L) {
                map.put("If-Modified-Since", DateUtils.formatDate(new Date(c.c)));
            }
        }
    }
    
    private byte[] a(final HttpEntity p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Lcom/a/a/a/l;
        //     3: dup            
        //     4: aload_0        
        //     5: getfield        com/a/a/a/a.c:Lcom/a/a/a/b;
        //     8: aload_1        
        //     9: invokeinterface org/apache/http/HttpEntity.getContentLength:()J
        //    14: l2i            
        //    15: invokespecial   com/a/a/a/l.<init>:(Lcom/a/a/a/b;I)V
        //    18: astore_2       
        //    19: aconst_null    
        //    20: astore_3       
        //    21: aload_1        
        //    22: invokeinterface org/apache/http/HttpEntity.getContent:()Ljava/io/InputStream;
        //    27: astore          6
        //    29: aconst_null    
        //    30: astore_3       
        //    31: aload           6
        //    33: ifnonnull       67
        //    36: new             Lcom/a/a/v;
        //    39: dup            
        //    40: invokespecial   com/a/a/v.<init>:()V
        //    43: athrow         
        //    44: astore          4
        //    46: aload_1        
        //    47: invokeinterface org/apache/http/HttpEntity.consumeContent:()V
        //    52: aload_0        
        //    53: getfield        com/a/a/a/a.c:Lcom/a/a/a/b;
        //    56: aload_3        
        //    57: invokevirtual   com/a/a/a/b.a:([B)V
        //    60: aload_2        
        //    61: invokevirtual   com/a/a/a/l.close:()V
        //    64: aload           4
        //    66: athrow         
        //    67: aload_0        
        //    68: getfield        com/a/a/a/a.c:Lcom/a/a/a/b;
        //    71: sipush          1024
        //    74: invokevirtual   com/a/a/a/b.a:(I)[B
        //    77: astore_3       
        //    78: aload           6
        //    80: aload_3        
        //    81: invokevirtual   java/io/InputStream.read:([B)I
        //    84: istore          7
        //    86: iload           7
        //    88: iconst_m1      
        //    89: if_icmpeq       103
        //    92: aload_2        
        //    93: aload_3        
        //    94: iconst_0       
        //    95: iload           7
        //    97: invokevirtual   com/a/a/a/l.write:([BII)V
        //   100: goto            78
        //   103: aload_2        
        //   104: invokevirtual   com/a/a/a/l.toByteArray:()[B
        //   107: astore          8
        //   109: aload_1        
        //   110: invokeinterface org/apache/http/HttpEntity.consumeContent:()V
        //   115: aload_0        
        //   116: getfield        com/a/a/a/a.c:Lcom/a/a/a/b;
        //   119: aload_3        
        //   120: invokevirtual   com/a/a/a/b.a:([B)V
        //   123: aload_2        
        //   124: invokevirtual   com/a/a/a/l.close:()V
        //   127: aload           8
        //   129: areturn        
        //   130: astore          9
        //   132: ldc             "Error occured when calling consumingContent"
        //   134: iconst_0       
        //   135: anewarray       Ljava/lang/Object;
        //   138: invokestatic    com/a/a/y.a:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   141: goto            115
        //   144: astore          5
        //   146: ldc             "Error occured when calling consumingContent"
        //   148: iconst_0       
        //   149: anewarray       Ljava/lang/Object;
        //   152: invokestatic    com/a/a/y.a:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   155: goto            52
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  21     29     44     67     Any
        //  36     44     44     67     Any
        //  46     52     144    158    Ljava/io/IOException;
        //  67     78     44     67     Any
        //  78     86     44     67     Any
        //  92     100    44     67     Any
        //  103    109    44     67     Any
        //  109    115    130    144    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0052:
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
    public k a(final n<?> p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: invokestatic    android/os/SystemClock.elapsedRealtime:()J
        //     3: lstore_2       
        //     4: aconst_null    
        //     5: astore          4
        //     7: aconst_null    
        //     8: astore          5
        //    10: new             Ljava/util/HashMap;
        //    13: dup            
        //    14: invokespecial   java/util/HashMap.<init>:()V
        //    17: astore          6
        //    19: new             Ljava/util/HashMap;
        //    22: dup            
        //    23: invokespecial   java/util/HashMap.<init>:()V
        //    26: astore          7
        //    28: aload_0        
        //    29: aload           7
        //    31: aload_1        
        //    32: invokevirtual   com/a/a/n.e:()Lcom/a/a/c;
        //    35: invokespecial   com/a/a/a/a.a:(Ljava/util/Map;Lcom/a/a/c;)V
        //    38: aload_0        
        //    39: getfield        com/a/a/a/a.b:Lcom/a/a/a/i;
        //    42: aload_1        
        //    43: aload           7
        //    45: invokeinterface com/a/a/a/i.a:(Lcom/a/a/n;Ljava/util/Map;)Lorg/apache/http/HttpResponse;
        //    50: astore          15
        //    52: aload           15
        //    54: invokeinterface org/apache/http/HttpResponse.getStatusLine:()Lorg/apache/http/StatusLine;
        //    59: astore          16
        //    61: aload           16
        //    63: invokeinterface org/apache/http/StatusLine.getStatusCode:()I
        //    68: istore          17
        //    70: aload           15
        //    72: invokeinterface org/apache/http/HttpResponse.getAllHeaders:()[Lorg/apache/http/Header;
        //    77: invokestatic    com/a/a/a/a.a:([Lorg/apache/http/Header;)Ljava/util/Map;
        //    80: astore          18
        //    82: iload           17
        //    84: sipush          304
        //    87: if_icmpne       128
        //    90: aload_1        
        //    91: invokevirtual   com/a/a/n.e:()Lcom/a/a/c;
        //    94: ifnonnull       116
        //    97: aconst_null    
        //    98: astore          21
        //   100: new             Lcom/a/a/k;
        //   103: dup            
        //   104: sipush          304
        //   107: aload           21
        //   109: aload           18
        //   111: iconst_1       
        //   112: invokespecial   com/a/a/k.<init>:(I[BLjava/util/Map;Z)V
        //   115: areturn        
        //   116: aload_1        
        //   117: invokevirtual   com/a/a/n.e:()Lcom/a/a/c;
        //   120: getfield        com/a/a/c.a:[B
        //   123: astore          21
        //   125: goto            100
        //   128: aload           15
        //   130: invokeinterface org/apache/http/HttpResponse.getEntity:()Lorg/apache/http/HttpEntity;
        //   135: astore          19
        //   137: aconst_null    
        //   138: astore          5
        //   140: aload           19
        //   142: ifnull          214
        //   145: aload_0        
        //   146: aload           15
        //   148: invokeinterface org/apache/http/HttpResponse.getEntity:()Lorg/apache/http/HttpEntity;
        //   153: invokespecial   com/a/a/a/a.a:(Lorg/apache/http/HttpEntity;)[B
        //   156: astore          5
        //   158: aload_0        
        //   159: invokestatic    android/os/SystemClock.elapsedRealtime:()J
        //   162: lload_2        
        //   163: lsub           
        //   164: aload_1        
        //   165: aload           5
        //   167: aload           16
        //   169: invokespecial   com/a/a/a/a.a:(JLcom/a/a/n;[BLorg/apache/http/StatusLine;)V
        //   172: iload           17
        //   174: sipush          200
        //   177: if_icmplt       188
        //   180: iload           17
        //   182: sipush          299
        //   185: if_icmple       222
        //   188: new             Ljava/io/IOException;
        //   191: dup            
        //   192: invokespecial   java/io/IOException.<init>:()V
        //   195: athrow         
        //   196: astore          14
        //   198: ldc             "socket"
        //   200: aload_1        
        //   201: new             Lcom/a/a/w;
        //   204: dup            
        //   205: invokespecial   com/a/a/w.<init>:()V
        //   208: invokestatic    com/a/a/a/a.a:(Ljava/lang/String;Lcom/a/a/n;Lcom/a/a/x;)V
        //   211: goto            4
        //   214: iconst_0       
        //   215: newarray        B
        //   217: astore          5
        //   219: goto            158
        //   222: new             Lcom/a/a/k;
        //   225: dup            
        //   226: iload           17
        //   228: aload           5
        //   230: aload           18
        //   232: iconst_0       
        //   233: invokespecial   com/a/a/k.<init>:(I[BLjava/util/Map;Z)V
        //   236: astore          20
        //   238: aload           20
        //   240: areturn        
        //   241: astore          13
        //   243: ldc             "connection"
        //   245: aload_1        
        //   246: new             Lcom/a/a/w;
        //   249: dup            
        //   250: invokespecial   com/a/a/w.<init>:()V
        //   253: invokestatic    com/a/a/a/a.a:(Ljava/lang/String;Lcom/a/a/n;Lcom/a/a/x;)V
        //   256: goto            4
        //   259: astore          12
        //   261: new             Ljava/lang/RuntimeException;
        //   264: dup            
        //   265: new             Ljava/lang/StringBuilder;
        //   268: dup            
        //   269: invokespecial   java/lang/StringBuilder.<init>:()V
        //   272: ldc_w           "Bad URL "
        //   275: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   278: aload_1        
        //   279: invokevirtual   com/a/a/n.c:()Ljava/lang/String;
        //   282: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   285: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   288: aload           12
        //   290: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   293: athrow         
        //   294: astore          8
        //   296: aload           4
        //   298: ifnull          402
        //   301: aload           4
        //   303: invokeinterface org/apache/http/HttpResponse.getStatusLine:()Lorg/apache/http/StatusLine;
        //   308: invokeinterface org/apache/http/StatusLine.getStatusCode:()I
        //   313: istore          9
        //   315: iconst_2       
        //   316: anewarray       Ljava/lang/Object;
        //   319: astore          10
        //   321: aload           10
        //   323: iconst_0       
        //   324: iload           9
        //   326: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   329: aastore        
        //   330: aload           10
        //   332: iconst_1       
        //   333: aload_1        
        //   334: invokevirtual   com/a/a/n.c:()Ljava/lang/String;
        //   337: aastore        
        //   338: ldc_w           "Unexpected response code %d for %s"
        //   341: aload           10
        //   343: invokestatic    com/a/a/y.c:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   346: aload           5
        //   348: ifnull          422
        //   351: new             Lcom/a/a/k;
        //   354: dup            
        //   355: iload           9
        //   357: aload           5
        //   359: aload           6
        //   361: iconst_0       
        //   362: invokespecial   com/a/a/k.<init>:(I[BLjava/util/Map;Z)V
        //   365: astore          11
        //   367: iload           9
        //   369: sipush          401
        //   372: if_icmpeq       383
        //   375: iload           9
        //   377: sipush          403
        //   380: if_icmpne       412
        //   383: ldc_w           "auth"
        //   386: aload_1        
        //   387: new             Lcom/a/a/a;
        //   390: dup            
        //   391: aload           11
        //   393: invokespecial   com/a/a/a.<init>:(Lcom/a/a/k;)V
        //   396: invokestatic    com/a/a/a/a.a:(Ljava/lang/String;Lcom/a/a/n;Lcom/a/a/x;)V
        //   399: goto            4
        //   402: new             Lcom/a/a/l;
        //   405: dup            
        //   406: aload           8
        //   408: invokespecial   com/a/a/l.<init>:(Ljava/lang/Throwable;)V
        //   411: athrow         
        //   412: new             Lcom/a/a/v;
        //   415: dup            
        //   416: aload           11
        //   418: invokespecial   com/a/a/v.<init>:(Lcom/a/a/k;)V
        //   421: athrow         
        //   422: new             Lcom/a/a/j;
        //   425: dup            
        //   426: aconst_null    
        //   427: invokespecial   com/a/a/j.<init>:(Lcom/a/a/k;)V
        //   430: athrow         
        //   431: astore          8
        //   433: aload           15
        //   435: astore          4
        //   437: aconst_null    
        //   438: astore          5
        //   440: goto            296
        //   443: astore          8
        //   445: aload           18
        //   447: astore          6
        //   449: aload           15
        //   451: astore          4
        //   453: goto            296
        //    Signature:
        //  (Lcom/a/a/n<*>;)Lcom/a/a/k;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                          
        //  -----  -----  -----  -----  ----------------------------------------------
        //  19     52     196    214    Ljava/net/SocketTimeoutException;
        //  19     52     241    259    Lorg/apache/http/conn/ConnectTimeoutException;
        //  19     52     259    294    Ljava/net/MalformedURLException;
        //  19     52     294    296    Ljava/io/IOException;
        //  52     82     196    214    Ljava/net/SocketTimeoutException;
        //  52     82     241    259    Lorg/apache/http/conn/ConnectTimeoutException;
        //  52     82     259    294    Ljava/net/MalformedURLException;
        //  52     82     431    443    Ljava/io/IOException;
        //  90     97     196    214    Ljava/net/SocketTimeoutException;
        //  90     97     241    259    Lorg/apache/http/conn/ConnectTimeoutException;
        //  90     97     259    294    Ljava/net/MalformedURLException;
        //  90     97     443    456    Ljava/io/IOException;
        //  100    116    196    214    Ljava/net/SocketTimeoutException;
        //  100    116    241    259    Lorg/apache/http/conn/ConnectTimeoutException;
        //  100    116    259    294    Ljava/net/MalformedURLException;
        //  100    116    443    456    Ljava/io/IOException;
        //  116    125    196    214    Ljava/net/SocketTimeoutException;
        //  116    125    241    259    Lorg/apache/http/conn/ConnectTimeoutException;
        //  116    125    259    294    Ljava/net/MalformedURLException;
        //  116    125    443    456    Ljava/io/IOException;
        //  128    137    196    214    Ljava/net/SocketTimeoutException;
        //  128    137    241    259    Lorg/apache/http/conn/ConnectTimeoutException;
        //  128    137    259    294    Ljava/net/MalformedURLException;
        //  128    137    443    456    Ljava/io/IOException;
        //  145    158    196    214    Ljava/net/SocketTimeoutException;
        //  145    158    241    259    Lorg/apache/http/conn/ConnectTimeoutException;
        //  145    158    259    294    Ljava/net/MalformedURLException;
        //  145    158    443    456    Ljava/io/IOException;
        //  158    172    196    214    Ljava/net/SocketTimeoutException;
        //  158    172    241    259    Lorg/apache/http/conn/ConnectTimeoutException;
        //  158    172    259    294    Ljava/net/MalformedURLException;
        //  158    172    443    456    Ljava/io/IOException;
        //  188    196    196    214    Ljava/net/SocketTimeoutException;
        //  188    196    241    259    Lorg/apache/http/conn/ConnectTimeoutException;
        //  188    196    259    294    Ljava/net/MalformedURLException;
        //  188    196    443    456    Ljava/io/IOException;
        //  214    219    196    214    Ljava/net/SocketTimeoutException;
        //  214    219    241    259    Lorg/apache/http/conn/ConnectTimeoutException;
        //  214    219    259    294    Ljava/net/MalformedURLException;
        //  214    219    443    456    Ljava/io/IOException;
        //  222    238    196    214    Ljava/net/SocketTimeoutException;
        //  222    238    241    259    Lorg/apache/http/conn/ConnectTimeoutException;
        //  222    238    259    294    Ljava/net/MalformedURLException;
        //  222    238    443    456    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 205, Size: 205
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
