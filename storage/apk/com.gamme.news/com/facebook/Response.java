// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import java.net.MalformedURLException;
import java.net.URL;
import android.content.Context;
import org.json.JSONTokener;
import com.facebook.internal.Logger;
import java.io.InputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONArray;
import com.facebook.internal.Utility;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import com.facebook.model.GraphObjectList;
import com.facebook.model.GraphObject;
import java.net.HttpURLConnection;
import com.facebook.internal.FileLruCache;

public class Response
{
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    private static final int INVALID_SESSION_FACEBOOK_ERROR_CODE = 190;
    public static final String NON_JSON_RESPONSE_PROPERTY = "FACEBOOK_NON_JSON_RESULT";
    private static final String RESPONSE_CACHE_TAG = "ResponseCache";
    private static final String RESPONSE_LOG_TAG = "Response";
    private static FileLruCache responseCache;
    private final HttpURLConnection connection;
    private final FacebookRequestError error;
    private final GraphObject graphObject;
    private final GraphObjectList<GraphObject> graphObjectList;
    private final boolean isFromCache;
    private final String rawResponse;
    private final Request request;
    
    Response(final Request request, final HttpURLConnection httpURLConnection, final FacebookRequestError facebookRequestError) {
        this(request, httpURLConnection, null, null, null, false, facebookRequestError);
    }
    
    Response(final Request request, final HttpURLConnection connection, final String rawResponse, final GraphObject graphObject, final GraphObjectList<GraphObject> graphObjectList, final boolean isFromCache, final FacebookRequestError error) {
        this.request = request;
        this.connection = connection;
        this.rawResponse = rawResponse;
        this.graphObject = graphObject;
        this.graphObjectList = graphObjectList;
        this.isFromCache = isFromCache;
        this.error = error;
    }
    
    Response(final Request request, final HttpURLConnection httpURLConnection, final String s, final GraphObject graphObject, final boolean b) {
        this(request, httpURLConnection, s, graphObject, null, b, null);
    }
    
    Response(final Request request, final HttpURLConnection httpURLConnection, final String s, final GraphObjectList<GraphObject> list, final boolean b) {
        this(request, httpURLConnection, s, null, list, b, null);
    }
    
    static List<Response> constructErrorResponses(final List<Request> list, final HttpURLConnection httpURLConnection, final FacebookException ex) {
        final int size = list.size();
        final ArrayList list2 = new ArrayList<Response>(size);
        for (int i = 0; i < size; ++i) {
            list2.add(new Response(list.get(i), httpURLConnection, new FacebookRequestError(httpURLConnection, ex)));
        }
        return (List<Response>)list2;
    }
    
    private static Response createResponseFromObject(final Request request, final HttpURLConnection httpURLConnection, Object null, final boolean b, final Object o) throws JSONException {
        if (null instanceof JSONObject) {
            final JSONObject jsonObject = (JSONObject)null;
            final FacebookRequestError checkResponseAndCreateError = FacebookRequestError.checkResponseAndCreateError(jsonObject, o, httpURLConnection);
            if (checkResponseAndCreateError != null) {
                if (checkResponseAndCreateError.getErrorCode() == 190) {
                    final Session session = request.getSession();
                    if (session != null) {
                        session.closeAndClearTokenInformation();
                    }
                }
                return new Response(request, httpURLConnection, checkResponseAndCreateError);
            }
            final Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jsonObject, "body", "FACEBOOK_NON_JSON_RESULT");
            if (stringPropertyAsJSON instanceof JSONObject) {
                return new Response(request, httpURLConnection, stringPropertyAsJSON.toString(), GraphObject.Factory.create((JSONObject)stringPropertyAsJSON), b);
            }
            if (stringPropertyAsJSON instanceof JSONArray) {
                return new Response(request, httpURLConnection, stringPropertyAsJSON.toString(), GraphObject.Factory.createList((JSONArray)stringPropertyAsJSON, GraphObject.class), b);
            }
            null = JSONObject.NULL;
        }
        if (null == JSONObject.NULL) {
            return new Response(request, httpURLConnection, null.toString(), (GraphObject)null, b);
        }
        throw new FacebookException("Got unexpected object type in response, class: " + null.getClass().getSimpleName());
    }
    
    private static List<Response> createResponsesFromObject(final HttpURLConnection httpURLConnection, final List<Request> list, Object o, final boolean b) throws FacebookException, JSONException {
        assert !(!b);
        final int size = list.size();
        final ArrayList list2 = new ArrayList<Response>(size);
        final Object o2 = o;
        while (true) {
            if (size == 1) {
                final Request request = list.get(0);
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
                    final JSONArray jsonArray = new JSONArray();
                    jsonArray.put((Object)jsonObject);
                    o = jsonArray;
                    if (!(o instanceof JSONArray) || ((JSONArray)o).length() != size) {
                        throw new FacebookException("Unexpected number of results");
                    }
                }
                catch (JSONException ex) {
                    list2.add(new Response(request, httpURLConnection, new FacebookRequestError(httpURLConnection, (Exception)ex)));
                    continue;
                }
                catch (IOException ex2) {
                    list2.add(new Response(request, httpURLConnection, new FacebookRequestError(httpURLConnection, ex2)));
                    continue;
                }
                final JSONArray jsonArray2 = (JSONArray)o;
                int i = 0;
                while (i < jsonArray2.length()) {
                    final Request request2 = list.get(i);
                    while (true) {
                        try {
                            list2.add(createResponseFromObject(request2, httpURLConnection, jsonArray2.get(i), b, o2));
                            ++i;
                        }
                        catch (JSONException ex3) {
                            list2.add(new Response(request2, httpURLConnection, new FacebookRequestError(httpURLConnection, (Exception)ex3)));
                            continue;
                        }
                        catch (FacebookException ex4) {
                            list2.add(new Response(request2, httpURLConnection, new FacebookRequestError(httpURLConnection, ex4)));
                            continue;
                        }
                        break;
                    }
                }
                return (List<Response>)list2;
            }
            continue;
        }
    }
    
    static List<Response> createResponsesFromStream(final InputStream inputStream, final HttpURLConnection httpURLConnection, final RequestBatch requestBatch, final boolean b) throws FacebookException, JSONException, IOException {
        final String streamToString = Utility.readStreamToString(inputStream);
        Logger.log(LoggingBehavior.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", streamToString.length(), streamToString);
        return createResponsesFromString(streamToString, httpURLConnection, requestBatch, b);
    }
    
    static List<Response> createResponsesFromString(final String s, final HttpURLConnection httpURLConnection, final RequestBatch requestBatch, final boolean b) throws FacebookException, JSONException, IOException {
        final List<Response> responsesFromObject = createResponsesFromObject(httpURLConnection, requestBatch, new JSONTokener(s).nextValue(), b);
        Logger.log(LoggingBehavior.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", requestBatch.getId(), s.length(), responsesFromObject);
        return responsesFromObject;
    }
    
    static List<Response> fromHttpConnection(final HttpURLConnection p0, final RequestBatch p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_1        
        //     1: instanceof      Lcom/facebook/internal/CacheableRequestBatch;
        //     4: istore_2       
        //     5: aconst_null    
        //     6: astore_3       
        //     7: aconst_null    
        //     8: astore          4
        //    10: aconst_null    
        //    11: astore          5
        //    13: iload_2        
        //    14: ifeq            149
        //    17: aload_1        
        //    18: checkcast       Lcom/facebook/internal/CacheableRequestBatch;
        //    21: astore          17
        //    23: invokestatic    com/facebook/Response.getResponseCache:()Lcom/facebook/internal/FileLruCache;
        //    26: astore_3       
        //    27: aload           17
        //    29: invokevirtual   com/facebook/internal/CacheableRequestBatch.getCacheKeyOverride:()Ljava/lang/String;
        //    32: astore          4
        //    34: aload           4
        //    36: invokestatic    com/facebook/internal/Utility.isNullOrEmpty:(Ljava/lang/String;)Z
        //    39: ifeq            60
        //    42: aload_1        
        //    43: invokevirtual   com/facebook/RequestBatch.size:()I
        //    46: iconst_1       
        //    47: if_icmpne       128
        //    50: aload_1        
        //    51: iconst_0       
        //    52: invokevirtual   com/facebook/RequestBatch.get:(I)Lcom/facebook/Request;
        //    55: invokevirtual   com/facebook/Request.getUrlForSingleRequest:()Ljava/lang/String;
        //    58: astore          4
        //    60: aload           17
        //    62: invokevirtual   com/facebook/internal/CacheableRequestBatch.getForceRoundTrip:()Z
        //    65: istore          18
        //    67: aconst_null    
        //    68: astore          5
        //    70: iload           18
        //    72: ifne            149
        //    75: aconst_null    
        //    76: astore          5
        //    78: aload_3        
        //    79: ifnull          149
        //    82: aload           4
        //    84: invokestatic    com/facebook/internal/Utility.isNullOrEmpty:(Ljava/lang/String;)Z
        //    87: istore          19
        //    89: aconst_null    
        //    90: astore          5
        //    92: iload           19
        //    94: ifne            149
        //    97: aload_3        
        //    98: aload           4
        //   100: invokevirtual   com/facebook/internal/FileLruCache.get:(Ljava/lang/String;)Ljava/io/InputStream;
        //   103: astore          5
        //   105: aload           5
        //   107: ifnull          213
        //   110: aload           5
        //   112: aconst_null    
        //   113: aload_1        
        //   114: iconst_1       
        //   115: invokestatic    com/facebook/Response.createResponsesFromStream:(Ljava/io/InputStream;Ljava/net/HttpURLConnection;Lcom/facebook/RequestBatch;Z)Ljava/util/List;
        //   118: astore          24
        //   120: aload           5
        //   122: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
        //   125: aload           24
        //   127: areturn        
        //   128: getstatic       com/facebook/LoggingBehavior.REQUESTS:Lcom/facebook/LoggingBehavior;
        //   131: ldc             "ResponseCache"
        //   133: ldc_w           "Not using cache for cacheable request because no key was specified"
        //   136: invokestatic    com/facebook/internal/Logger.log:(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
        //   139: goto            60
        //   142: astore          23
        //   144: aload           5
        //   146: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
        //   149: aload_0        
        //   150: invokevirtual   java/net/HttpURLConnection.getResponseCode:()I
        //   153: sipush          400
        //   156: if_icmplt       221
        //   159: aload_0        
        //   160: invokevirtual   java/net/HttpURLConnection.getErrorStream:()Ljava/io/InputStream;
        //   163: astore          5
        //   165: aload           5
        //   167: aload_0        
        //   168: aload_1        
        //   169: iconst_0       
        //   170: invokestatic    com/facebook/Response.createResponsesFromStream:(Ljava/io/InputStream;Ljava/net/HttpURLConnection;Lcom/facebook/RequestBatch;Z)Ljava/util/List;
        //   173: astore          16
        //   175: aload           5
        //   177: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
        //   180: aload           16
        //   182: areturn        
        //   183: astore          22
        //   185: aload           5
        //   187: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
        //   190: goto            149
        //   193: astore          21
        //   195: aload           5
        //   197: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
        //   200: goto            149
        //   203: astore          20
        //   205: aload           5
        //   207: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
        //   210: aload           20
        //   212: athrow         
        //   213: aload           5
        //   215: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
        //   218: goto            149
        //   221: aload_0        
        //   222: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
        //   225: astore          5
        //   227: aload_3        
        //   228: ifnull          165
        //   231: aload           4
        //   233: ifnull          165
        //   236: aload           5
        //   238: ifnull          165
        //   241: aload_3        
        //   242: aload           4
        //   244: aload           5
        //   246: invokevirtual   com/facebook/internal/FileLruCache.interceptAndPut:(Ljava/lang/String;Ljava/io/InputStream;)Ljava/io/InputStream;
        //   249: astore          15
        //   251: aload           15
        //   253: ifnull          165
        //   256: aload           15
        //   258: astore          5
        //   260: goto            165
        //   263: astore          13
        //   265: getstatic       com/facebook/LoggingBehavior.REQUESTS:Lcom/facebook/LoggingBehavior;
        //   268: ldc             "Response"
        //   270: ldc_w           "Response <Error>: %s"
        //   273: iconst_1       
        //   274: anewarray       Ljava/lang/Object;
        //   277: dup            
        //   278: iconst_0       
        //   279: aload           13
        //   281: aastore        
        //   282: invokestatic    com/facebook/internal/Logger.log:(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   285: aload_1        
        //   286: aload_0        
        //   287: aload           13
        //   289: invokestatic    com/facebook/Response.constructErrorResponses:(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
        //   292: astore          14
        //   294: aload           5
        //   296: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
        //   299: aload           14
        //   301: areturn        
        //   302: astore          11
        //   304: getstatic       com/facebook/LoggingBehavior.REQUESTS:Lcom/facebook/LoggingBehavior;
        //   307: ldc             "Response"
        //   309: ldc_w           "Response <Error>: %s"
        //   312: iconst_1       
        //   313: anewarray       Ljava/lang/Object;
        //   316: dup            
        //   317: iconst_0       
        //   318: aload           11
        //   320: aastore        
        //   321: invokestatic    com/facebook/internal/Logger.log:(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   324: aload_1        
        //   325: aload_0        
        //   326: new             Lcom/facebook/FacebookException;
        //   329: dup            
        //   330: aload           11
        //   332: invokespecial   com/facebook/FacebookException.<init>:(Ljava/lang/Throwable;)V
        //   335: invokestatic    com/facebook/Response.constructErrorResponses:(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
        //   338: astore          12
        //   340: aload           5
        //   342: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
        //   345: aload           12
        //   347: areturn        
        //   348: astore          9
        //   350: getstatic       com/facebook/LoggingBehavior.REQUESTS:Lcom/facebook/LoggingBehavior;
        //   353: ldc             "Response"
        //   355: ldc_w           "Response <Error>: %s"
        //   358: iconst_1       
        //   359: anewarray       Ljava/lang/Object;
        //   362: dup            
        //   363: iconst_0       
        //   364: aload           9
        //   366: aastore        
        //   367: invokestatic    com/facebook/internal/Logger.log:(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   370: aload_1        
        //   371: aload_0        
        //   372: new             Lcom/facebook/FacebookException;
        //   375: dup            
        //   376: aload           9
        //   378: invokespecial   com/facebook/FacebookException.<init>:(Ljava/lang/Throwable;)V
        //   381: invokestatic    com/facebook/Response.constructErrorResponses:(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
        //   384: astore          10
        //   386: aload           5
        //   388: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
        //   391: aload           10
        //   393: areturn        
        //   394: astore          7
        //   396: getstatic       com/facebook/LoggingBehavior.REQUESTS:Lcom/facebook/LoggingBehavior;
        //   399: ldc             "Response"
        //   401: ldc_w           "Response <Error>: %s"
        //   404: iconst_1       
        //   405: anewarray       Ljava/lang/Object;
        //   408: dup            
        //   409: iconst_0       
        //   410: aload           7
        //   412: aastore        
        //   413: invokestatic    com/facebook/internal/Logger.log:(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   416: aload_1        
        //   417: aload_0        
        //   418: new             Lcom/facebook/FacebookException;
        //   421: dup            
        //   422: aload           7
        //   424: invokespecial   com/facebook/FacebookException.<init>:(Ljava/lang/Throwable;)V
        //   427: invokestatic    com/facebook/Response.constructErrorResponses:(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
        //   430: astore          8
        //   432: aload           5
        //   434: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
        //   437: aload           8
        //   439: areturn        
        //   440: astore          6
        //   442: aload           5
        //   444: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
        //   447: aload           6
        //   449: athrow         
        //    Signature:
        //  (Ljava/net/HttpURLConnection;Lcom/facebook/RequestBatch;)Ljava/util/List<Lcom/facebook/Response;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  97     105    142    149    Lcom/facebook/FacebookException;
        //  97     105    183    193    Lorg/json/JSONException;
        //  97     105    193    203    Ljava/io/IOException;
        //  97     105    203    213    Any
        //  110    120    142    149    Lcom/facebook/FacebookException;
        //  110    120    183    193    Lorg/json/JSONException;
        //  110    120    193    203    Ljava/io/IOException;
        //  110    120    203    213    Any
        //  149    165    263    302    Lcom/facebook/FacebookException;
        //  149    165    302    348    Lorg/json/JSONException;
        //  149    165    348    394    Ljava/io/IOException;
        //  149    165    394    440    Ljava/lang/SecurityException;
        //  149    165    440    450    Any
        //  165    175    263    302    Lcom/facebook/FacebookException;
        //  165    175    302    348    Lorg/json/JSONException;
        //  165    175    348    394    Ljava/io/IOException;
        //  165    175    394    440    Ljava/lang/SecurityException;
        //  165    175    440    450    Any
        //  221    227    263    302    Lcom/facebook/FacebookException;
        //  221    227    302    348    Lorg/json/JSONException;
        //  221    227    348    394    Ljava/io/IOException;
        //  221    227    394    440    Ljava/lang/SecurityException;
        //  221    227    440    450    Any
        //  241    251    263    302    Lcom/facebook/FacebookException;
        //  241    251    302    348    Lorg/json/JSONException;
        //  241    251    348    394    Ljava/io/IOException;
        //  241    251    394    440    Ljava/lang/SecurityException;
        //  241    251    440    450    Any
        //  265    294    440    450    Any
        //  304    340    440    450    Any
        //  350    386    440    450    Any
        //  396    432    440    450    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0149:
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
    
    static FileLruCache getResponseCache() {
        if (Response.responseCache == null) {
            final Context staticContext = Session.getStaticContext();
            if (staticContext != null) {
                Response.responseCache = new FileLruCache(staticContext, "ResponseCache", new FileLruCache.Limits());
            }
        }
        return Response.responseCache;
    }
    
    public final HttpURLConnection getConnection() {
        return this.connection;
    }
    
    public final FacebookRequestError getError() {
        return this.error;
    }
    
    public final GraphObject getGraphObject() {
        return this.graphObject;
    }
    
    public final <T extends GraphObject> T getGraphObjectAs(final Class<T> clazz) {
        if (this.graphObject == null) {
            return null;
        }
        if (clazz == null) {
            throw new NullPointerException("Must pass in a valid interface that extends GraphObject");
        }
        return this.graphObject.cast(clazz);
    }
    
    public final GraphObjectList<GraphObject> getGraphObjectList() {
        return this.graphObjectList;
    }
    
    public final <T extends GraphObject> GraphObjectList<T> getGraphObjectListAs(final Class<T> clazz) {
        if (this.graphObjectList == null) {
            return null;
        }
        return this.graphObjectList.castToListOf(clazz);
    }
    
    public final boolean getIsFromCache() {
        return this.isFromCache;
    }
    
    public String getRawResponse() {
        return this.rawResponse;
    }
    
    public Request getRequest() {
        return this.request;
    }
    
    public Request getRequestForPagedResults(final PagingDirection pagingDirection) {
        final GraphObject graphObject = this.graphObject;
        String spec = null;
        if (graphObject != null) {
            final PagingInfo paging = this.graphObject.cast(PagedResults.class).getPaging();
            spec = null;
            if (paging != null) {
                if (pagingDirection == PagingDirection.NEXT) {
                    spec = paging.getNext();
                }
                else {
                    spec = paging.getPrevious();
                }
            }
        }
        if (Utility.isNullOrEmpty(spec)) {
            return null;
        }
        if (spec != null && spec.equals(this.request.getUrlForSingleRequest())) {
            return null;
        }
        try {
            return new Request(this.request.getSession(), new URL(spec));
        }
        catch (MalformedURLException ex) {
            return null;
        }
    }
    
    @Override
    public String toString() {
        try {
            final Object[] args = { null };
            int responseCode;
            if (this.connection != null) {
                responseCode = this.connection.getResponseCode();
            }
            else {
                responseCode = 200;
            }
            args[0] = responseCode;
            final String format = String.format("%d", args);
            return "{Response: " + " responseCode: " + format + ", graphObject: " + this.graphObject + ", error: " + this.error + ", isFromCache:" + this.isFromCache + "}";
        }
        catch (IOException ex) {
            final String format = "unknown";
            return "{Response: " + " responseCode: " + format + ", graphObject: " + this.graphObject + ", error: " + this.error + ", isFromCache:" + this.isFromCache + "}";
        }
    }
    
    interface PagedResults extends GraphObject
    {
        GraphObjectList<GraphObject> getData();
        
        PagingInfo getPaging();
    }
    
    public enum PagingDirection
    {
        NEXT("NEXT", 0), 
        PREVIOUS("PREVIOUS", 1);
        
        private PagingDirection(final String name, final int ordinal) {
        }
    }
    
    interface PagingInfo extends GraphObject
    {
        String getNext();
        
        String getPrevious();
    }
}
