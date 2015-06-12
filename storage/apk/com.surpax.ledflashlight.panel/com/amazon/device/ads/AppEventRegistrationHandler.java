// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import org.json.JSONArray;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class AppEventRegistrationHandler
{
    protected static final String APP_EVENTS_FILE = "AppEventsJsonFile";
    protected static final long APP_EVENTS_FILE_MAX_SIZE = 1048576L;
    protected static final String APP_EVENT_NAME_KEY = "evtName";
    protected static final String APP_EVENT_TIMESTAMP_KEY = "ts";
    private static final String LOG_TAG;
    protected static AppEventRegistrationHandler instance;
    protected final Object appEventsFileLock;
    protected final Set eventsSent;
    protected final Set newEventsToSave;
    
    static {
        LOG_TAG = AppEventRegistrationHandler.class.getSimpleName();
        AppEventRegistrationHandler.instance = new AppEventRegistrationHandler();
    }
    
    protected AppEventRegistrationHandler() {
        this.appEventsFileLock = new Object();
        this.newEventsToSave = Collections.synchronizedSet(new HashSet<Object>());
        this.eventsSent = Collections.synchronizedSet(new HashSet<Object>());
    }
    
    public static AppEventRegistrationHandler getInstance() {
        return AppEventRegistrationHandler.instance;
    }
    
    public void addEventToAppEventsCacheFile(final AppEvent appEvent) {
        ThreadUtils.executeRunnable(new Runnable() {
            @Override
            public void run() {
                AppEventRegistrationHandler.this.appendAppEventToFile(appEvent);
            }
        });
    }
    
    protected void appendAppEventToFile(final AppEvent p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: invokestatic    com/amazon/device/ads/InternalAdRegistration.getInstance:()Lcom/amazon/device/ads/IInternalAdRegistration;
        //     3: invokeinterface com/amazon/device/ads/IInternalAdRegistration.getApplicationContext:()Landroid/content/Context;
        //     8: astore_2       
        //     9: aload_2        
        //    10: ifnonnull       14
        //    13: return         
        //    14: new             Lorg/json/JSONObject;
        //    17: dup            
        //    18: invokespecial   org/json/JSONObject.<init>:()V
        //    21: astore_3       
        //    22: aload_3        
        //    23: ldc             "evtName"
        //    25: aload_1        
        //    26: invokevirtual   com/amazon/device/ads/AppEvent.getEventName:()Ljava/lang/String;
        //    29: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //    32: pop            
        //    33: aload_3        
        //    34: ldc             "ts"
        //    36: aload_1        
        //    37: invokevirtual   com/amazon/device/ads/AppEvent.getTimestamp:()J
        //    40: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;J)Lorg/json/JSONObject;
        //    43: pop            
        //    44: aload_1        
        //    45: invokevirtual   com/amazon/device/ads/AppEvent.getPropertyEntries:()Ljava/util/Set;
        //    48: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    53: astore          9
        //    55: aload           9
        //    57: invokeinterface java/util/Iterator.hasNext:()Z
        //    62: ifeq            133
        //    65: aload           9
        //    67: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    72: checkcast       Ljava/util/Map$Entry;
        //    75: astore          30
        //    77: aload_3        
        //    78: aload           30
        //    80: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //    85: checkcast       Ljava/lang/String;
        //    88: aload           30
        //    90: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //    95: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //    98: pop            
        //    99: goto            55
        //   102: astore          4
        //   104: getstatic       com/amazon/device/ads/AppEventRegistrationHandler.LOG_TAG:Ljava/lang/String;
        //   107: astore          5
        //   109: iconst_1       
        //   110: anewarray       Ljava/lang/Object;
        //   113: astore          6
        //   115: aload           6
        //   117: iconst_0       
        //   118: aload_1        
        //   119: invokevirtual   com/amazon/device/ads/AppEvent.toString:()Ljava/lang/String;
        //   122: aastore        
        //   123: aload           5
        //   125: ldc             "Internal error while persisting the application event %s."
        //   127: aload           6
        //   129: invokestatic    com/amazon/device/ads/Log.w:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   132: return         
        //   133: aload_0        
        //   134: getfield        com/amazon/device/ads/AppEventRegistrationHandler.newEventsToSave:Ljava/util/Set;
        //   137: aload_3        
        //   138: invokevirtual   org/json/JSONObject.toString:()Ljava/lang/String;
        //   141: invokeinterface java/util/Set.add:(Ljava/lang/Object;)Z
        //   146: pop            
        //   147: aload_0        
        //   148: getfield        com/amazon/device/ads/AppEventRegistrationHandler.appEventsFileLock:Ljava/lang/Object;
        //   151: astore          11
        //   153: aload           11
        //   155: monitorenter   
        //   156: new             Ljava/lang/StringBuilder;
        //   159: dup            
        //   160: invokespecial   java/lang/StringBuilder.<init>:()V
        //   163: aload_3        
        //   164: invokevirtual   org/json/JSONObject.toString:()Ljava/lang/String;
        //   167: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   170: ldc             "\n"
        //   172: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   175: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   178: astore          13
        //   180: new             Ljava/io/File;
        //   183: dup            
        //   184: aload_2        
        //   185: invokevirtual   android/content/Context.getFilesDir:()Ljava/io/File;
        //   188: ldc             "AppEventsJsonFile"
        //   190: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //   193: astore          14
        //   195: aload           14
        //   197: invokevirtual   java/io/File.length:()J
        //   200: aload           13
        //   202: invokevirtual   java/lang/String.length:()I
        //   205: i2l            
        //   206: ladd           
        //   207: ldc2_w          1048576
        //   210: lcmp           
        //   211: ifle            254
        //   214: getstatic       com/amazon/device/ads/AppEventRegistrationHandler.LOG_TAG:Ljava/lang/String;
        //   217: astore          28
        //   219: iconst_1       
        //   220: anewarray       Ljava/lang/Object;
        //   223: astore          29
        //   225: aload           29
        //   227: iconst_0       
        //   228: aload_1        
        //   229: invokevirtual   com/amazon/device/ads/AppEvent.toString:()Ljava/lang/String;
        //   232: aastore        
        //   233: aload           28
        //   235: ldc             "Couldn't write the application event %s to the cache file. Maximum size limit reached."
        //   237: aload           29
        //   239: invokestatic    com/amazon/device/ads/Log.w:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   242: aload           11
        //   244: monitorexit    
        //   245: return         
        //   246: astore          12
        //   248: aload           11
        //   250: monitorexit    
        //   251: aload           12
        //   253: athrow         
        //   254: aconst_null    
        //   255: astore          15
        //   257: new             Ljava/io/OutputStreamWriter;
        //   260: dup            
        //   261: new             Ljava/io/FileOutputStream;
        //   264: dup            
        //   265: aload           14
        //   267: iconst_1       
        //   268: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;Z)V
        //   271: invokespecial   java/io/OutputStreamWriter.<init>:(Ljava/io/OutputStream;)V
        //   274: astore          16
        //   276: aload           16
        //   278: aload           13
        //   280: invokevirtual   java/io/OutputStreamWriter.write:(Ljava/lang/String;)V
        //   283: getstatic       com/amazon/device/ads/AppEventRegistrationHandler.LOG_TAG:Ljava/lang/String;
        //   286: astore          24
        //   288: iconst_1       
        //   289: anewarray       Ljava/lang/Object;
        //   292: astore          25
        //   294: aload           25
        //   296: iconst_0       
        //   297: aload_1        
        //   298: invokevirtual   com/amazon/device/ads/AppEvent.toString:()Ljava/lang/String;
        //   301: aastore        
        //   302: aload           24
        //   304: ldc             "Added the application event %s to the cache file."
        //   306: aload           25
        //   308: invokestatic    com/amazon/device/ads/Log.d:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   311: aload           16
        //   313: invokevirtual   java/io/OutputStreamWriter.close:()V
        //   316: aload           11
        //   318: monitorexit    
        //   319: return         
        //   320: astore          26
        //   322: getstatic       com/amazon/device/ads/AppEventRegistrationHandler.LOG_TAG:Ljava/lang/String;
        //   325: ldc             "Problem while closing application events file."
        //   327: invokestatic    com/amazon/device/ads/Log.w:(Ljava/lang/String;Ljava/lang/String;)V
        //   330: goto            316
        //   333: astore          27
        //   335: aconst_null    
        //   336: astore          16
        //   338: getstatic       com/amazon/device/ads/AppEventRegistrationHandler.LOG_TAG:Ljava/lang/String;
        //   341: astore          21
        //   343: iconst_1       
        //   344: anewarray       Ljava/lang/Object;
        //   347: astore          22
        //   349: aload           22
        //   351: iconst_0       
        //   352: aload_1        
        //   353: invokevirtual   com/amazon/device/ads/AppEvent.toString:()Ljava/lang/String;
        //   356: aastore        
        //   357: aload           21
        //   359: ldc             "Couldn't write the application event %s to the file."
        //   361: aload           22
        //   363: invokestatic    com/amazon/device/ads/Log.w:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   366: aload           16
        //   368: ifnull          316
        //   371: aload           16
        //   373: invokevirtual   java/io/OutputStreamWriter.close:()V
        //   376: goto            316
        //   379: astore          23
        //   381: getstatic       com/amazon/device/ads/AppEventRegistrationHandler.LOG_TAG:Ljava/lang/String;
        //   384: ldc             "Problem while closing application events file."
        //   386: invokestatic    com/amazon/device/ads/Log.w:(Ljava/lang/String;Ljava/lang/String;)V
        //   389: goto            316
        //   392: astore          19
        //   394: aload           15
        //   396: ifnull          404
        //   399: aload           15
        //   401: invokevirtual   java/io/OutputStreamWriter.close:()V
        //   404: aload           19
        //   406: athrow         
        //   407: astore          20
        //   409: getstatic       com/amazon/device/ads/AppEventRegistrationHandler.LOG_TAG:Ljava/lang/String;
        //   412: ldc             "Problem while closing application events file."
        //   414: invokestatic    com/amazon/device/ads/Log.w:(Ljava/lang/String;Ljava/lang/String;)V
        //   417: goto            404
        //   420: astore          18
        //   422: aload           16
        //   424: astore          15
        //   426: aload           18
        //   428: astore          19
        //   430: goto            394
        //   433: astore          17
        //   435: goto            338
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                    
        //  -----  -----  -----  -----  ------------------------
        //  22     55     102    133    Lorg/json/JSONException;
        //  55     99     102    133    Lorg/json/JSONException;
        //  156    245    246    254    Any
        //  257    276    333    338    Ljava/io/IOException;
        //  257    276    392    394    Any
        //  276    311    433    438    Ljava/io/IOException;
        //  276    311    420    433    Any
        //  311    316    320    333    Ljava/io/IOException;
        //  311    316    246    254    Any
        //  316    319    246    254    Any
        //  322    330    246    254    Any
        //  338    366    420    433    Any
        //  371    376    379    392    Ljava/io/IOException;
        //  371    376    246    254    Any
        //  381    389    246    254    Any
        //  399    404    407    420    Ljava/io/IOException;
        //  399    404    246    254    Any
        //  404    407    246    254    Any
        //  409    417    246    254    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0316:
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
    
    public JSONArray getAppEventsJSONArray() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_1       
        //     2: invokestatic    com/amazon/device/ads/InternalAdRegistration.getInstance:()Lcom/amazon/device/ads/IInternalAdRegistration;
        //     5: invokeinterface com/amazon/device/ads/IInternalAdRegistration.getApplicationContext:()Landroid/content/Context;
        //    10: astore_2       
        //    11: aload_2        
        //    12: ifnonnull       17
        //    15: aconst_null    
        //    16: areturn        
        //    17: aload_0        
        //    18: getfield        com/amazon/device/ads/AppEventRegistrationHandler.appEventsFileLock:Ljava/lang/Object;
        //    21: astore_3       
        //    22: aload_3        
        //    23: monitorenter   
        //    24: new             Ljava/io/File;
        //    27: dup            
        //    28: aload_2        
        //    29: invokevirtual   android/content/Context.getFilesDir:()Ljava/io/File;
        //    32: ldc             "AppEventsJsonFile"
        //    34: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //    37: astore          4
        //    39: aload           4
        //    41: invokevirtual   java/io/File.exists:()Z
        //    44: ifne            58
        //    47: aload_3        
        //    48: monitorexit    
        //    49: aconst_null    
        //    50: areturn        
        //    51: astore          5
        //    53: aload_3        
        //    54: monitorexit    
        //    55: aload           5
        //    57: athrow         
        //    58: new             Ljava/io/FileInputStream;
        //    61: dup            
        //    62: aload           4
        //    64: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    67: astore          6
        //    69: new             Ljava/io/BufferedReader;
        //    72: dup            
        //    73: new             Ljava/io/InputStreamReader;
        //    76: dup            
        //    77: aload           6
        //    79: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //    82: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    85: astore          7
        //    87: aconst_null    
        //    88: astore          8
        //    90: aload           7
        //    92: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //    95: astore          15
        //    97: aload           15
        //    99: ifnull          360
        //   102: aload           15
        //   104: invokestatic    com/amazon/device/ads/JSONUtils.getJSONObjectFromString:(Ljava/lang/String;)Lorg/json/JSONObject;
        //   107: astore          16
        //   109: aload           16
        //   111: ifnonnull       132
        //   114: aload_0        
        //   115: invokevirtual   com/amazon/device/ads/AppEventRegistrationHandler.onAppEventsRegistered:()V
        //   118: aload           6
        //   120: invokevirtual   java/io/FileInputStream.close:()V
        //   123: aload           7
        //   125: invokevirtual   java/io/BufferedReader.close:()V
        //   128: aload_3        
        //   129: monitorexit    
        //   130: aload_1        
        //   131: areturn        
        //   132: aload           8
        //   134: ifnonnull       146
        //   137: new             Lorg/json/JSONArray;
        //   140: dup            
        //   141: invokespecial   org/json/JSONArray.<init>:()V
        //   144: astore          8
        //   146: aload           8
        //   148: aload           16
        //   150: invokevirtual   org/json/JSONArray.put:(Ljava/lang/Object;)Lorg/json/JSONArray;
        //   153: pop            
        //   154: aload_0        
        //   155: getfield        com/amazon/device/ads/AppEventRegistrationHandler.eventsSent:Ljava/util/Set;
        //   158: aload           16
        //   160: invokevirtual   org/json/JSONObject.toString:()Ljava/lang/String;
        //   163: invokeinterface java/util/Set.add:(Ljava/lang/Object;)Z
        //   168: pop            
        //   169: goto            90
        //   172: astore          12
        //   174: getstatic       com/amazon/device/ads/AppEventRegistrationHandler.LOG_TAG:Ljava/lang/String;
        //   177: ldc             "Problem while reading the application events file."
        //   179: invokestatic    com/amazon/device/ads/Log.w:(Ljava/lang/String;Ljava/lang/String;)V
        //   182: aload           6
        //   184: ifnull          192
        //   187: aload           6
        //   189: invokevirtual   java/io/FileInputStream.close:()V
        //   192: aconst_null    
        //   193: astore_1       
        //   194: aload           7
        //   196: ifnull          128
        //   199: aload           7
        //   201: invokevirtual   java/io/BufferedReader.close:()V
        //   204: aconst_null    
        //   205: astore_1       
        //   206: goto            128
        //   209: astore          13
        //   211: getstatic       com/amazon/device/ads/AppEventRegistrationHandler.LOG_TAG:Ljava/lang/String;
        //   214: ldc             "Problem while closing the application events file."
        //   216: invokestatic    com/amazon/device/ads/Log.w:(Ljava/lang/String;Ljava/lang/String;)V
        //   219: aconst_null    
        //   220: astore_1       
        //   221: goto            128
        //   224: astore          17
        //   226: getstatic       com/amazon/device/ads/AppEventRegistrationHandler.LOG_TAG:Ljava/lang/String;
        //   229: ldc             "Problem while closing the application events file."
        //   231: invokestatic    com/amazon/device/ads/Log.w:(Ljava/lang/String;Ljava/lang/String;)V
        //   234: goto            123
        //   237: astore          18
        //   239: getstatic       com/amazon/device/ads/AppEventRegistrationHandler.LOG_TAG:Ljava/lang/String;
        //   242: ldc             "Problem while closing the application events file."
        //   244: invokestatic    com/amazon/device/ads/Log.w:(Ljava/lang/String;Ljava/lang/String;)V
        //   247: goto            128
        //   250: astore          14
        //   252: getstatic       com/amazon/device/ads/AppEventRegistrationHandler.LOG_TAG:Ljava/lang/String;
        //   255: ldc             "Problem while closing the application events file."
        //   257: invokestatic    com/amazon/device/ads/Log.w:(Ljava/lang/String;Ljava/lang/String;)V
        //   260: goto            192
        //   263: astore          24
        //   265: aconst_null    
        //   266: astore          6
        //   268: aload           24
        //   270: astore          9
        //   272: aconst_null    
        //   273: astore          7
        //   275: aload           6
        //   277: ifnull          285
        //   280: aload           6
        //   282: invokevirtual   java/io/FileInputStream.close:()V
        //   285: aload           7
        //   287: ifnull          295
        //   290: aload           7
        //   292: invokevirtual   java/io/BufferedReader.close:()V
        //   295: aload           9
        //   297: athrow         
        //   298: astore          11
        //   300: getstatic       com/amazon/device/ads/AppEventRegistrationHandler.LOG_TAG:Ljava/lang/String;
        //   303: ldc             "Problem while closing the application events file."
        //   305: invokestatic    com/amazon/device/ads/Log.w:(Ljava/lang/String;Ljava/lang/String;)V
        //   308: goto            285
        //   311: astore          10
        //   313: getstatic       com/amazon/device/ads/AppEventRegistrationHandler.LOG_TAG:Ljava/lang/String;
        //   316: ldc             "Problem while closing the application events file."
        //   318: invokestatic    com/amazon/device/ads/Log.w:(Ljava/lang/String;Ljava/lang/String;)V
        //   321: goto            295
        //   324: astore          22
        //   326: aload           22
        //   328: astore          9
        //   330: aconst_null    
        //   331: astore          7
        //   333: goto            275
        //   336: astore          9
        //   338: goto            275
        //   341: astore          23
        //   343: aconst_null    
        //   344: astore          7
        //   346: aconst_null    
        //   347: astore          6
        //   349: goto            174
        //   352: astore          21
        //   354: aconst_null    
        //   355: astore          7
        //   357: goto            174
        //   360: aload           8
        //   362: astore_1       
        //   363: goto            118
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  24     49     51     58     Any
        //  58     69     341    352    Ljava/io/IOException;
        //  58     69     263    275    Any
        //  69     87     352    360    Ljava/io/IOException;
        //  69     87     324    336    Any
        //  90     97     172    174    Ljava/io/IOException;
        //  90     97     336    341    Any
        //  102    109    172    174    Ljava/io/IOException;
        //  102    109    336    341    Any
        //  114    118    172    174    Ljava/io/IOException;
        //  114    118    336    341    Any
        //  118    123    224    237    Ljava/io/IOException;
        //  118    123    51     58     Any
        //  123    128    237    250    Ljava/io/IOException;
        //  123    128    51     58     Any
        //  128    130    51     58     Any
        //  137    146    172    174    Ljava/io/IOException;
        //  137    146    336    341    Any
        //  146    169    172    174    Ljava/io/IOException;
        //  146    169    336    341    Any
        //  174    182    336    341    Any
        //  187    192    250    263    Ljava/io/IOException;
        //  187    192    51     58     Any
        //  199    204    209    224    Ljava/io/IOException;
        //  199    204    51     58     Any
        //  211    219    51     58     Any
        //  226    234    51     58     Any
        //  239    247    51     58     Any
        //  252    260    51     58     Any
        //  280    285    298    311    Ljava/io/IOException;
        //  280    285    51     58     Any
        //  290    295    311    324    Ljava/io/IOException;
        //  290    295    51     58     Any
        //  295    298    51     58     Any
        //  300    308    51     58     Any
        //  313    321    51     58     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 172, Size: 172
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:635)
        //     at java.util.ArrayList.get(ArrayList.java:411)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3305)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3419)
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
    
    public void onAppEventsRegistered() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: invokestatic    com/amazon/device/ads/InternalAdRegistration.getInstance:()Lcom/amazon/device/ads/IInternalAdRegistration;
        //     3: invokeinterface com/amazon/device/ads/IInternalAdRegistration.getApplicationContext:()Landroid/content/Context;
        //     8: astore_1       
        //     9: aload_1        
        //    10: ifnonnull       14
        //    13: return         
        //    14: aload_0        
        //    15: getfield        com/amazon/device/ads/AppEventRegistrationHandler.appEventsFileLock:Ljava/lang/Object;
        //    18: astore_2       
        //    19: aload_2        
        //    20: monitorenter   
        //    21: aload_0        
        //    22: getfield        com/amazon/device/ads/AppEventRegistrationHandler.newEventsToSave:Ljava/util/Set;
        //    25: aload_0        
        //    26: getfield        com/amazon/device/ads/AppEventRegistrationHandler.eventsSent:Ljava/util/Set;
        //    29: invokeinterface java/util/Set.removeAll:(Ljava/util/Collection;)Z
        //    34: pop            
        //    35: aload_0        
        //    36: getfield        com/amazon/device/ads/AppEventRegistrationHandler.newEventsToSave:Ljava/util/Set;
        //    39: invokeinterface java/util/Set.isEmpty:()Z
        //    44: ifne            287
        //    47: new             Ljava/lang/StringBuilder;
        //    50: dup            
        //    51: invokespecial   java/lang/StringBuilder.<init>:()V
        //    54: astore          5
        //    56: aload_0        
        //    57: getfield        com/amazon/device/ads/AppEventRegistrationHandler.newEventsToSave:Ljava/util/Set;
        //    60: astore          6
        //    62: aload           6
        //    64: monitorenter   
        //    65: aload_0        
        //    66: getfield        com/amazon/device/ads/AppEventRegistrationHandler.newEventsToSave:Ljava/util/Set;
        //    69: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    74: astore          8
        //    76: aload           8
        //    78: invokeinterface java/util/Iterator.hasNext:()Z
        //    83: ifeq            123
        //    86: aload           5
        //    88: aload           8
        //    90: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    95: checkcast       Ljava/lang/String;
        //    98: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   101: ldc             "\n"
        //   103: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   106: pop            
        //   107: goto            76
        //   110: astore          7
        //   112: aload           6
        //   114: monitorexit    
        //   115: aload           7
        //   117: athrow         
        //   118: astore_3       
        //   119: aload_2        
        //   120: monitorexit    
        //   121: aload_3        
        //   122: athrow         
        //   123: aload           6
        //   125: monitorexit    
        //   126: new             Ljava/io/File;
        //   129: dup            
        //   130: aload_1        
        //   131: invokevirtual   android/content/Context.getFilesDir:()Ljava/io/File;
        //   134: ldc             "AppEventsJsonFile"
        //   136: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //   139: astore          9
        //   141: aconst_null    
        //   142: astore          10
        //   144: new             Ljava/io/BufferedWriter;
        //   147: dup            
        //   148: new             Ljava/io/OutputStreamWriter;
        //   151: dup            
        //   152: new             Ljava/io/FileOutputStream;
        //   155: dup            
        //   156: aload           9
        //   158: iconst_0       
        //   159: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;Z)V
        //   162: invokespecial   java/io/OutputStreamWriter.<init>:(Ljava/io/OutputStream;)V
        //   165: invokespecial   java/io/BufferedWriter.<init>:(Ljava/io/Writer;)V
        //   168: astore          11
        //   170: aload           11
        //   172: aload           5
        //   174: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   177: invokevirtual   java/io/BufferedWriter.write:(Ljava/lang/String;)V
        //   180: aload_0        
        //   181: getfield        com/amazon/device/ads/AppEventRegistrationHandler.newEventsToSave:Ljava/util/Set;
        //   184: invokeinterface java/util/Set.clear:()V
        //   189: aload_0        
        //   190: getfield        com/amazon/device/ads/AppEventRegistrationHandler.eventsSent:Ljava/util/Set;
        //   193: invokeinterface java/util/Set.clear:()V
        //   198: aload           11
        //   200: invokevirtual   java/io/BufferedWriter.close:()V
        //   203: aload_2        
        //   204: monitorexit    
        //   205: return         
        //   206: astore          17
        //   208: getstatic       com/amazon/device/ads/AppEventRegistrationHandler.LOG_TAG:Ljava/lang/String;
        //   211: ldc             "Problem while closing application events file."
        //   213: invokestatic    com/amazon/device/ads/Log.w:(Ljava/lang/String;Ljava/lang/String;)V
        //   216: goto            203
        //   219: astore          18
        //   221: aconst_null    
        //   222: astore          11
        //   224: getstatic       com/amazon/device/ads/AppEventRegistrationHandler.LOG_TAG:Ljava/lang/String;
        //   227: ldc_w           "Couldn't write the application event(s) to the file."
        //   230: invokestatic    com/amazon/device/ads/Log.w:(Ljava/lang/String;Ljava/lang/String;)V
        //   233: aload           11
        //   235: ifnull          203
        //   238: aload           11
        //   240: invokevirtual   java/io/BufferedWriter.close:()V
        //   243: goto            203
        //   246: astore          16
        //   248: getstatic       com/amazon/device/ads/AppEventRegistrationHandler.LOG_TAG:Ljava/lang/String;
        //   251: ldc             "Problem while closing application events file."
        //   253: invokestatic    com/amazon/device/ads/Log.w:(Ljava/lang/String;Ljava/lang/String;)V
        //   256: goto            203
        //   259: astore          14
        //   261: aload           10
        //   263: ifnull          271
        //   266: aload           10
        //   268: invokevirtual   java/io/BufferedWriter.close:()V
        //   271: aload           14
        //   273: athrow         
        //   274: astore          15
        //   276: getstatic       com/amazon/device/ads/AppEventRegistrationHandler.LOG_TAG:Ljava/lang/String;
        //   279: ldc             "Problem while closing application events file."
        //   281: invokestatic    com/amazon/device/ads/Log.w:(Ljava/lang/String;Ljava/lang/String;)V
        //   284: goto            271
        //   287: aload_1        
        //   288: ldc             "AppEventsJsonFile"
        //   290: invokevirtual   android/content/Context.deleteFile:(Ljava/lang/String;)Z
        //   293: pop            
        //   294: aload_0        
        //   295: getfield        com/amazon/device/ads/AppEventRegistrationHandler.eventsSent:Ljava/util/Set;
        //   298: invokeinterface java/util/Set.clear:()V
        //   303: goto            203
        //   306: astore          13
        //   308: aload           11
        //   310: astore          10
        //   312: aload           13
        //   314: astore          14
        //   316: goto            261
        //   319: astore          12
        //   321: goto            224
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  21     65     118    123    Any
        //  65     76     110    118    Any
        //  76     107    110    118    Any
        //  112    118    118    123    Any
        //  123    126    110    118    Any
        //  126    141    118    123    Any
        //  144    170    219    224    Ljava/io/IOException;
        //  144    170    259    261    Any
        //  170    198    319    324    Ljava/io/IOException;
        //  170    198    306    319    Any
        //  198    203    206    219    Ljava/io/IOException;
        //  198    203    118    123    Any
        //  203    205    118    123    Any
        //  208    216    118    123    Any
        //  224    233    306    319    Any
        //  238    243    246    259    Ljava/io/IOException;
        //  238    243    118    123    Any
        //  248    256    118    123    Any
        //  266    271    274    287    Ljava/io/IOException;
        //  266    271    118    123    Any
        //  271    274    118    123    Any
        //  276    284    118    123    Any
        //  287    303    118    123    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0203:
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
