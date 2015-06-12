// 
// Decompiled by Procyon v0.5.29
// 

public final class fb extends gm
{
    static int a;
    private String b;
    private String e;
    private String f;
    private byte[] g;
    private fd h;
    
    static {
        fb.a = 15000;
    }
    
    public fb(final String b, final String e, final String f, final byte[] g, final fd h) {
        this.b = b;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    @Override
    public final void a() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_1       
        //     2: invokestatic    java/lang/Thread.currentThread:()Ljava/lang/Thread;
        //     5: invokevirtual   java/lang/Thread.getId:()J
        //     8: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //    11: astore_2       
        //    12: invokestatic    java/lang/Thread.currentThread:()Ljava/lang/Thread;
        //    15: new             Ljava/lang/StringBuilder;
        //    18: dup            
        //    19: ldc             "DataSender Sending Executor Thread, id = "
        //    21: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    24: aload_2        
        //    25: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    28: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    31: invokevirtual   java/lang/Thread.setName:(Ljava/lang/String;)V
        //    34: new             Lorg/apache/http/entity/ByteArrayEntity;
        //    37: dup            
        //    38: aload_0        
        //    39: getfield        fb.g:[B
        //    42: invokespecial   org/apache/http/entity/ByteArrayEntity.<init>:([B)V
        //    45: astore_3       
        //    46: aload_3        
        //    47: ldc             "application/octet-stream"
        //    49: invokevirtual   org/apache/http/entity/ByteArrayEntity.setContentType:(Ljava/lang/String;)V
        //    52: new             Lorg/apache/http/client/methods/HttpPost;
        //    55: dup            
        //    56: aload_0        
        //    57: getfield        fb.b:Ljava/lang/String;
        //    60: invokespecial   org/apache/http/client/methods/HttpPost.<init>:(Ljava/lang/String;)V
        //    63: astore          15
        //    65: aload           15
        //    67: aload_3        
        //    68: invokevirtual   org/apache/http/client/methods/HttpPost.setEntity:(Lorg/apache/http/HttpEntity;)V
        //    71: new             Lorg/apache/http/params/BasicHttpParams;
        //    74: dup            
        //    75: invokespecial   org/apache/http/params/BasicHttpParams.<init>:()V
        //    78: astore          16
        //    80: aload           16
        //    82: sipush          10000
        //    85: invokestatic    org/apache/http/params/HttpConnectionParams.setConnectionTimeout:(Lorg/apache/http/params/HttpParams;I)V
        //    88: aload           16
        //    90: getstatic       fb.a:I
        //    93: invokestatic    org/apache/http/params/HttpConnectionParams.setSoTimeout:(Lorg/apache/http/params/HttpParams;I)V
        //    96: aload           15
        //    98: invokevirtual   org/apache/http/client/methods/HttpPost.getParams:()Lorg/apache/http/params/HttpParams;
        //   101: ldc             "http.protocol.expect-continue"
        //   103: iconst_0       
        //   104: invokeinterface org/apache/http/params/HttpParams.setBooleanParameter:(Ljava/lang/String;Z)Lorg/apache/http/params/HttpParams;
        //   109: pop            
        //   110: new             Lorg/apache/http/impl/client/DefaultHttpClient;
        //   113: dup            
        //   114: new             Lorg/apache/http/impl/conn/SingleClientConnManager;
        //   117: dup            
        //   118: aload           16
        //   120: invokestatic    gi.a:()Lorg/apache/http/conn/scheme/SchemeRegistry;
        //   123: invokespecial   org/apache/http/impl/conn/SingleClientConnManager.<init>:(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V
        //   126: aload           16
        //   128: invokespecial   org/apache/http/impl/client/DefaultHttpClient.<init>:(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
        //   131: astore          6
        //   133: aload           6
        //   135: aload           15
        //   137: invokeinterface org/apache/http/client/HttpClient.execute:(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
        //   142: astore          18
        //   144: aload           18
        //   146: astore          7
        //   148: aload           6
        //   150: invokeinterface org/apache/http/client/HttpClient.getConnectionManager:()Lorg/apache/http/conn/ClientConnectionManager;
        //   155: invokeinterface org/apache/http/conn/ClientConnectionManager.shutdown:()V
        //   160: aload           7
        //   162: ifnull          175
        //   165: aload           7
        //   167: invokeinterface org/apache/http/HttpResponse.getStatusLine:()Lorg/apache/http/StatusLine;
        //   172: ifnonnull       258
        //   175: aload_0        
        //   176: getfield        fb.h:Lfd;
        //   179: astore          9
        //   181: aload_0        
        //   182: getfield        fb.e:Ljava/lang/String;
        //   185: astore          10
        //   187: aload_0        
        //   188: getfield        fb.f:Ljava/lang/String;
        //   191: pop            
        //   192: aload           9
        //   194: aload           10
        //   196: invokeinterface fd.a:(Ljava/lang/String;)V
        //   201: return         
        //   202: astore          5
        //   204: aconst_null    
        //   205: astore          6
        //   207: aload           5
        //   209: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   212: aconst_null    
        //   213: astore          7
        //   215: aload           6
        //   217: ifnull          160
        //   220: aload           6
        //   222: invokeinterface org/apache/http/client/HttpClient.getConnectionManager:()Lorg/apache/http/conn/ClientConnectionManager;
        //   227: invokeinterface org/apache/http/conn/ClientConnectionManager.shutdown:()V
        //   232: aconst_null    
        //   233: astore          7
        //   235: goto            160
        //   238: astore          4
        //   240: aload_1        
        //   241: ifnull          255
        //   244: aload_1        
        //   245: invokeinterface org/apache/http/client/HttpClient.getConnectionManager:()Lorg/apache/http/conn/ClientConnectionManager;
        //   250: invokeinterface org/apache/http/conn/ClientConnectionManager.shutdown:()V
        //   255: aload           4
        //   257: athrow         
        //   258: aload           7
        //   260: invokeinterface org/apache/http/HttpResponse.getStatusLine:()Lorg/apache/http/StatusLine;
        //   265: astore          12
        //   267: aload           12
        //   269: invokeinterface org/apache/http/StatusLine.getStatusCode:()I
        //   274: istore          13
        //   276: aload           12
        //   278: invokeinterface org/apache/http/StatusLine.getReasonPhrase:()Ljava/lang/String;
        //   283: astore          14
        //   285: aload_0        
        //   286: getfield        fb.h:Lfd;
        //   289: iload           13
        //   291: aload           14
        //   293: aload_0        
        //   294: getfield        fb.e:Ljava/lang/String;
        //   297: aload_0        
        //   298: getfield        fb.f:Ljava/lang/String;
        //   301: invokeinterface fd.a:(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   306: return         
        //   307: astore          8
        //   309: aload           8
        //   311: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   314: return         
        //   315: astore          4
        //   317: aload           6
        //   319: astore_1       
        //   320: goto            240
        //   323: astore          5
        //   325: goto            207
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  34     133    202    207    Ljava/lang/Exception;
        //  34     133    238    240    Any
        //  133    144    323    328    Ljava/lang/Exception;
        //  133    144    315    323    Any
        //  165    175    307    315    Ljava/lang/Exception;
        //  175    201    307    315    Ljava/lang/Exception;
        //  207    212    315    323    Any
        //  258    306    307    315    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0160:
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
}
