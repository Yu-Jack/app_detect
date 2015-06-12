// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Iterator;
import java.net.ProtocolException;
import java.util.Map;
import java.net.SocketTimeoutException;
import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;

class HttpURLConnectionWebRequest extends WebRequest
{
    private static final String LOG_TAG;
    
    static {
        LOG_TAG = HttpURLConnectionWebRequest.class.getSimpleName();
    }
    
    private void writePostBody(final HttpURLConnection p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Ljava/lang/StringBuilder;
        //     3: dup            
        //     4: invokespecial   java/lang/StringBuilder.<init>:()V
        //     7: astore_2       
        //     8: aload_0        
        //     9: getfield        com/amazon/device/ads/HttpURLConnectionWebRequest.requestBody:Ljava/lang/String;
        //    12: ifnull          97
        //    15: aload_2        
        //    16: aload_0        
        //    17: getfield        com/amazon/device/ads/HttpURLConnectionWebRequest.requestBody:Ljava/lang/String;
        //    20: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    23: pop            
        //    24: aload_0        
        //    25: getfield        com/amazon/device/ads/HttpURLConnectionWebRequest.logRequestBodyEnabled:Z
        //    28: ifeq            67
        //    31: aload_0        
        //    32: invokevirtual   com/amazon/device/ads/HttpURLConnectionWebRequest.getRequestBody:()Ljava/lang/String;
        //    35: ifnull          67
        //    38: aload_0        
        //    39: invokevirtual   com/amazon/device/ads/HttpURLConnectionWebRequest.getLogTag:()Ljava/lang/String;
        //    42: astore          16
        //    44: iconst_1       
        //    45: anewarray       Ljava/lang/Object;
        //    48: astore          17
        //    50: aload           17
        //    52: iconst_0       
        //    53: aload_0        
        //    54: invokevirtual   com/amazon/device/ads/HttpURLConnectionWebRequest.getRequestBody:()Ljava/lang/String;
        //    57: aastore        
        //    58: aload           16
        //    60: ldc             "Request Body: %s"
        //    62: aload           17
        //    64: invokestatic    com/amazon/device/ads/Log.d:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //    67: new             Ljava/io/OutputStreamWriter;
        //    70: dup            
        //    71: aload_1        
        //    72: invokevirtual   java/net/HttpURLConnection.getOutputStream:()Ljava/io/OutputStream;
        //    75: ldc             "UTF-8"
        //    77: invokespecial   java/io/OutputStreamWriter.<init>:(Ljava/io/OutputStream;Ljava/lang/String;)V
        //    80: astore          5
        //    82: aload           5
        //    84: aload_2        
        //    85: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    88: invokevirtual   java/io/OutputStreamWriter.write:(Ljava/lang/String;)V
        //    91: aload           5
        //    93: invokevirtual   java/io/OutputStreamWriter.close:()V
        //    96: return         
        //    97: aload_0        
        //    98: getfield        com/amazon/device/ads/HttpURLConnectionWebRequest.postParameters:Ljava/util/HashMap;
        //   101: ifnull          24
        //   104: aload_0        
        //   105: getfield        com/amazon/device/ads/HttpURLConnectionWebRequest.postParameters:Ljava/util/HashMap;
        //   108: invokevirtual   java/util/HashMap.isEmpty:()Z
        //   111: ifne            24
        //   114: aload_0        
        //   115: getfield        com/amazon/device/ads/HttpURLConnectionWebRequest.postParameters:Ljava/util/HashMap;
        //   118: invokevirtual   java/util/HashMap.entrySet:()Ljava/util/Set;
        //   121: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //   126: astore_3       
        //   127: aload_3        
        //   128: invokeinterface java/util/Iterator.hasNext:()Z
        //   133: ifeq            191
        //   136: aload_3        
        //   137: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   142: checkcast       Ljava/util/Map$Entry;
        //   145: astore          18
        //   147: aload_2        
        //   148: aload           18
        //   150: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   155: checkcast       Ljava/lang/String;
        //   158: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   161: ldc             "="
        //   163: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   166: aload           18
        //   168: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   173: checkcast       Ljava/lang/String;
        //   176: invokestatic    com/amazon/device/ads/Utils.getURLEncodedString:(Ljava/lang/String;)Ljava/lang/String;
        //   179: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   182: ldc             "&"
        //   184: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   187: pop            
        //   188: goto            127
        //   191: aload_2        
        //   192: aload_2        
        //   193: ldc             "&"
        //   195: invokevirtual   java/lang/StringBuilder.lastIndexOf:(Ljava/lang/String;)I
        //   198: invokevirtual   java/lang/StringBuilder.deleteCharAt:(I)Ljava/lang/StringBuilder;
        //   201: pop            
        //   202: goto            24
        //   205: astore          13
        //   207: aload_0        
        //   208: invokevirtual   com/amazon/device/ads/HttpURLConnectionWebRequest.getLogTag:()Ljava/lang/String;
        //   211: astore          14
        //   213: iconst_1       
        //   214: anewarray       Ljava/lang/Object;
        //   217: astore          15
        //   219: aload           15
        //   221: iconst_0       
        //   222: aload           13
        //   224: invokevirtual   java/io/IOException.getMessage:()Ljava/lang/String;
        //   227: aastore        
        //   228: aload           14
        //   230: ldc             "Problem while closing output stream writer for request body: %s"
        //   232: aload           15
        //   234: invokestatic    com/amazon/device/ads/Log.e:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   237: new             Lcom/amazon/device/ads/WebRequest$WebRequestException;
        //   240: dup            
        //   241: aload_0        
        //   242: getstatic       com/amazon/device/ads/WebRequest$WebRequestStatus.NETWORK_FAILURE:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;
        //   245: ldc             "Problem while closing output stream writer for request body"
        //   247: aload           13
        //   249: invokespecial   com/amazon/device/ads/WebRequest$WebRequestException.<init>:(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   252: athrow         
        //   253: astore          6
        //   255: aconst_null    
        //   256: astore          5
        //   258: aload_0        
        //   259: invokevirtual   com/amazon/device/ads/HttpURLConnectionWebRequest.getLogTag:()Ljava/lang/String;
        //   262: astore          11
        //   264: iconst_1       
        //   265: anewarray       Ljava/lang/Object;
        //   268: astore          12
        //   270: aload           12
        //   272: iconst_0       
        //   273: aload           6
        //   275: invokevirtual   java/io/IOException.getMessage:()Ljava/lang/String;
        //   278: aastore        
        //   279: aload           11
        //   281: ldc             "Problem while creating output steam for request body: %s"
        //   283: aload           12
        //   285: invokestatic    com/amazon/device/ads/Log.e:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   288: new             Lcom/amazon/device/ads/WebRequest$WebRequestException;
        //   291: dup            
        //   292: aload_0        
        //   293: getstatic       com/amazon/device/ads/WebRequest$WebRequestStatus.NETWORK_FAILURE:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;
        //   296: ldc             "Problem while creating output steam for request body"
        //   298: aload           6
        //   300: invokespecial   com/amazon/device/ads/WebRequest$WebRequestException.<init>:(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   303: athrow         
        //   304: astore          7
        //   306: aload           5
        //   308: ifnull          316
        //   311: aload           5
        //   313: invokevirtual   java/io/OutputStreamWriter.close:()V
        //   316: aload           7
        //   318: athrow         
        //   319: astore          8
        //   321: aload_0        
        //   322: invokevirtual   com/amazon/device/ads/HttpURLConnectionWebRequest.getLogTag:()Ljava/lang/String;
        //   325: astore          9
        //   327: iconst_1       
        //   328: anewarray       Ljava/lang/Object;
        //   331: astore          10
        //   333: aload           10
        //   335: iconst_0       
        //   336: aload           8
        //   338: invokevirtual   java/io/IOException.getMessage:()Ljava/lang/String;
        //   341: aastore        
        //   342: aload           9
        //   344: ldc             "Problem while closing output stream writer for request body: %s"
        //   346: aload           10
        //   348: invokestatic    com/amazon/device/ads/Log.e:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   351: new             Lcom/amazon/device/ads/WebRequest$WebRequestException;
        //   354: dup            
        //   355: aload_0        
        //   356: getstatic       com/amazon/device/ads/WebRequest$WebRequestStatus.NETWORK_FAILURE:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;
        //   359: ldc             "Problem while closing output stream writer for request body"
        //   361: aload           8
        //   363: invokespecial   com/amazon/device/ads/WebRequest$WebRequestException.<init>:(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   366: athrow         
        //   367: astore          7
        //   369: aconst_null    
        //   370: astore          5
        //   372: goto            306
        //   375: astore          6
        //   377: goto            258
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  67     82     253    258    Ljava/io/IOException;
        //  67     82     367    375    Any
        //  82     91     375    380    Ljava/io/IOException;
        //  82     91     304    306    Any
        //  91     96     205    253    Ljava/io/IOException;
        //  258    304    304    306    Any
        //  311    316    319    367    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0097:
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
    protected WebRequest$WebResponse doHttpNetworkCall(final URL url) {
        HttpURLConnection openConnection;
        try {
            openConnection = this.openConnection(url);
            this.setupRequestProperties(openConnection);
            final HttpURLConnection httpURLConnection = openConnection;
            httpURLConnection.connect();
            final HttpURLConnectionWebRequest httpURLConnectionWebRequest = this;
            final HttpURLConnection httpURLConnection2 = openConnection;
            return httpURLConnectionWebRequest.prepareResponse(httpURLConnection2);
        }
        catch (IOException ex) {
            Log.e(this.getLogTag(), "Problem while opening the URL connection: %s", ex.getMessage());
            throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.NETWORK_FAILURE, "Problem while opening the URL connection", ex);
        }
        try {
            final HttpURLConnection httpURLConnection = openConnection;
            httpURLConnection.connect();
            final HttpURLConnectionWebRequest httpURLConnectionWebRequest = this;
            final HttpURLConnection httpURLConnection2 = openConnection;
            return httpURLConnectionWebRequest.prepareResponse(httpURLConnection2);
        }
        catch (SocketTimeoutException ex2) {
            Log.e(this.getLogTag(), "Socket timed out while connecting to URL: %s", ex2.getMessage());
            throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.NETWORK_TIMEOUT, "Socket timed out while connecting to URL", ex2);
        }
        catch (IOException ex3) {
            Log.e(this.getLogTag(), "Problem while connecting to URL: %s", ex3.getMessage());
            throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.NETWORK_FAILURE, "Problem while connecting to URL", ex3);
        }
    }
    
    @Override
    protected String getSubLogTag() {
        return HttpURLConnectionWebRequest.LOG_TAG;
    }
    
    protected HttpURLConnection openConnection(final URL url) {
        return (HttpURLConnection)url.openConnection();
    }
    
    protected WebRequest$WebResponse prepareResponse(final HttpURLConnection p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Lcom/amazon/device/ads/WebRequest$WebResponse;
        //     3: dup            
        //     4: aload_0        
        //     5: invokespecial   com/amazon/device/ads/WebRequest$WebResponse.<init>:(Lcom/amazon/device/ads/WebRequest;)V
        //     8: astore_2       
        //     9: aload_2        
        //    10: aload_0        
        //    11: invokevirtual   com/amazon/device/ads/HttpURLConnectionWebRequest.getLogTag:()Ljava/lang/String;
        //    14: invokevirtual   com/amazon/device/ads/WebRequest$WebResponse.setLogTag:(Ljava/lang/String;)V
        //    17: aload_2        
        //    18: aload_0        
        //    19: getfield        com/amazon/device/ads/HttpURLConnectionWebRequest.logResponseEnabled:Z
        //    22: invokevirtual   com/amazon/device/ads/WebRequest$WebResponse.enableLog:(Z)V
        //    25: aload_2        
        //    26: aload_1        
        //    27: invokevirtual   java/net/HttpURLConnection.getResponseCode:()I
        //    30: invokevirtual   com/amazon/device/ads/WebRequest$WebResponse.setHttpStatusCode:(I)V
        //    33: aload_2        
        //    34: aload_1        
        //    35: invokevirtual   java/net/HttpURLConnection.getResponseMessage:()Ljava/lang/String;
        //    38: invokevirtual   com/amazon/device/ads/WebRequest$WebResponse.setHttpStatus:(Ljava/lang/String;)V
        //    41: aload_2        
        //    42: invokevirtual   com/amazon/device/ads/WebRequest$WebResponse.getHttpStatusCode:()I
        //    45: sipush          200
        //    48: if_icmpne       59
        //    51: aload_2        
        //    52: aload_1        
        //    53: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
        //    56: invokevirtual   com/amazon/device/ads/WebRequest$WebResponse.setInputStream:(Ljava/io/InputStream;)V
        //    59: aload_2        
        //    60: areturn        
        //    61: astore          6
        //    63: aload_0        
        //    64: invokevirtual   com/amazon/device/ads/HttpURLConnectionWebRequest.getLogTag:()Ljava/lang/String;
        //    67: astore          7
        //    69: iconst_1       
        //    70: anewarray       Ljava/lang/Object;
        //    73: astore          8
        //    75: aload           8
        //    77: iconst_0       
        //    78: aload           6
        //    80: invokevirtual   java/net/SocketTimeoutException.getMessage:()Ljava/lang/String;
        //    83: aastore        
        //    84: aload           7
        //    86: ldc             "Socket Timeout while getting the response status code: %s"
        //    88: aload           8
        //    90: invokestatic    com/amazon/device/ads/Log.e:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //    93: new             Lcom/amazon/device/ads/WebRequest$WebRequestException;
        //    96: dup            
        //    97: aload_0        
        //    98: getstatic       com/amazon/device/ads/WebRequest$WebRequestStatus.NETWORK_TIMEOUT:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;
        //   101: ldc             "Socket Timeout while getting the response status code"
        //   103: aload           6
        //   105: invokespecial   com/amazon/device/ads/WebRequest$WebRequestException.<init>:(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   108: athrow         
        //   109: astore_3       
        //   110: aload_0        
        //   111: invokevirtual   com/amazon/device/ads/HttpURLConnectionWebRequest.getLogTag:()Ljava/lang/String;
        //   114: astore          4
        //   116: iconst_1       
        //   117: anewarray       Ljava/lang/Object;
        //   120: astore          5
        //   122: aload           5
        //   124: iconst_0       
        //   125: aload_3        
        //   126: invokevirtual   java/io/IOException.getMessage:()Ljava/lang/String;
        //   129: aastore        
        //   130: aload           4
        //   132: ldc             "IOException while getting the response status code: %s"
        //   134: aload           5
        //   136: invokestatic    com/amazon/device/ads/Log.e:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   139: new             Lcom/amazon/device/ads/WebRequest$WebRequestException;
        //   142: dup            
        //   143: aload_0        
        //   144: getstatic       com/amazon/device/ads/WebRequest$WebRequestStatus.NETWORK_FAILURE:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;
        //   147: ldc             "IOException while getting the response status code"
        //   149: aload_3        
        //   150: invokespecial   com/amazon/device/ads/WebRequest$WebRequestException.<init>:(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   153: athrow         
        //   154: astore          9
        //   156: aload_0        
        //   157: invokevirtual   com/amazon/device/ads/HttpURLConnectionWebRequest.getLogTag:()Ljava/lang/String;
        //   160: astore          10
        //   162: iconst_1       
        //   163: anewarray       Ljava/lang/Object;
        //   166: astore          11
        //   168: aload           11
        //   170: iconst_0       
        //   171: aload           9
        //   173: invokevirtual   java/io/IOException.getMessage:()Ljava/lang/String;
        //   176: aastore        
        //   177: aload           10
        //   179: ldc             "IOException while reading the input stream from response: %s"
        //   181: aload           11
        //   183: invokestatic    com/amazon/device/ads/Log.e:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   186: new             Lcom/amazon/device/ads/WebRequest$WebRequestException;
        //   189: dup            
        //   190: aload_0        
        //   191: getstatic       com/amazon/device/ads/WebRequest$WebRequestStatus.NETWORK_FAILURE:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;
        //   194: ldc             "IOException while reading the input stream from response"
        //   196: aload           9
        //   198: invokespecial   com/amazon/device/ads/WebRequest$WebRequestException.<init>:(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   201: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  25     41     61     109    Ljava/net/SocketTimeoutException;
        //  25     41     109    154    Ljava/io/IOException;
        //  51     59     154    202    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0059:
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
    
    protected void setupRequestProperties(final HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.setRequestMethod(this.getHttpMethod().name());
            for (final Map.Entry<K, Object> entry : this.headers.entrySet()) {
                if (entry.getValue() != null && !entry.getValue().equals("")) {
                    httpURLConnection.setRequestProperty((String)entry.getKey(), entry.getValue());
                }
            }
        }
        catch (ProtocolException ex) {
            Log.e(this.getLogTag(), "Invalid client protocol: %s", ex.getMessage());
            throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.INVALID_CLIENT_PROTOCOL, "Invalid client protocol", ex);
        }
        httpURLConnection.setConnectTimeout(this.getTimeout());
        httpURLConnection.setReadTimeout(this.getTimeout());
        this.logUrl(httpURLConnection.getURL().toString());
        switch (this.getHttpMethod()) {
            default: {}
            case GET: {
                httpURLConnection.setDoOutput(false);
            }
            case POST: {
                httpURLConnection.setDoOutput(true);
                this.writePostBody(httpURLConnection);
            }
        }
    }
}
