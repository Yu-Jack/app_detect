// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import android.content.Context;
import com.google.analytics.containertag.proto.Serving;
import com.google.android.gms.common.util.VisibleForTesting;

class ResourceLoader implements Runnable
{
    private static final String CTFE_URL_PREFIX = "/r?id=";
    private static final String CTFE_URL_SUFFIX = "&v=a62676326";
    private static final String PREVIOUS_CONTAINER_VERSION_QUERY_NAME = "pv";
    @VisibleForTesting
    static final String SDK_VERSION = "a62676326";
    private LoadCallback<Serving.SupplementedResource> mCallback;
    private final NetworkClientFactory mClientFactory;
    private final String mContainerId;
    private final Context mContext;
    private volatile CtfeHost mCtfeHost;
    private volatile String mCtfeUrlPathAndQuery;
    private final String mDefaultCtfeUrlPathAndQuery;
    private volatile String mPreviousVersion;
    
    public ResourceLoader(final Context context, final String s, final CtfeHost ctfeHost) {
        this(context, s, new NetworkClientFactory(), ctfeHost);
    }
    
    ResourceLoader(final Context mContext, final String s, final NetworkClientFactory mClientFactory, final CtfeHost mCtfeHost) {
        this.mContext = mContext;
        this.mClientFactory = mClientFactory;
        this.mContainerId = s;
        this.mCtfeHost = mCtfeHost;
        this.mDefaultCtfeUrlPathAndQuery = "/r?id=" + s;
        this.mCtfeUrlPathAndQuery = this.mDefaultCtfeUrlPathAndQuery;
        this.mPreviousVersion = null;
    }
    
    private void loadResource() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: invokespecial   com/google/tagmanager/ResourceLoader.okToLoad:()Z
        //     4: ifne            20
        //     7: aload_0        
        //     8: getfield        com/google/tagmanager/ResourceLoader.mCallback:Lcom/google/tagmanager/LoadCallback;
        //    11: getstatic       com/google/tagmanager/LoadCallback$Failure.NOT_AVAILABLE:Lcom/google/tagmanager/LoadCallback$Failure;
        //    14: invokeinterface com/google/tagmanager/LoadCallback.onFailure:(Lcom/google/tagmanager/LoadCallback$Failure;)V
        //    19: return         
        //    20: ldc             "Start loading resource from network ..."
        //    22: invokestatic    com/google/tagmanager/Log.v:(Ljava/lang/String;)V
        //    25: aload_0        
        //    26: invokevirtual   com/google/tagmanager/ResourceLoader.getCtfeUrl:()Ljava/lang/String;
        //    29: astore_1       
        //    30: aload_0        
        //    31: getfield        com/google/tagmanager/ResourceLoader.mClientFactory:Lcom/google/tagmanager/NetworkClientFactory;
        //    34: invokevirtual   com/google/tagmanager/NetworkClientFactory.createNetworkClient:()Lcom/google/tagmanager/NetworkClient;
        //    37: astore_2       
        //    38: aload_2        
        //    39: aload_1        
        //    40: invokeinterface com/google/tagmanager/NetworkClient.getInputStream:(Ljava/lang/String;)Ljava/io/InputStream;
        //    45: astore          6
        //    47: new             Ljava/io/ByteArrayOutputStream;
        //    50: dup            
        //    51: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //    54: astore          7
        //    56: aload           6
        //    58: aload           7
        //    60: invokestatic    com/google/tagmanager/ResourceUtil.copyStream:(Ljava/io/InputStream;Ljava/io/OutputStream;)V
        //    63: aload           7
        //    65: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //    68: invokestatic    com/google/analytics/containertag/proto/Serving$SupplementedResource.parseFrom:([B)Lcom/google/analytics/containertag/proto/Serving$SupplementedResource;
        //    71: astore          9
        //    73: new             Ljava/lang/StringBuilder;
        //    76: dup            
        //    77: invokespecial   java/lang/StringBuilder.<init>:()V
        //    80: ldc             "Successfully loaded supplemented resource: "
        //    82: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    85: aload           9
        //    87: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    90: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    93: invokestatic    com/google/tagmanager/Log.v:(Ljava/lang/String;)V
        //    96: aload           9
        //    98: getfield        com/google/analytics/containertag/proto/Serving$SupplementedResource.resource:Lcom/google/analytics/containertag/proto/Serving$Resource;
        //   101: ifnonnull       129
        //   104: new             Ljava/lang/StringBuilder;
        //   107: dup            
        //   108: invokespecial   java/lang/StringBuilder.<init>:()V
        //   111: ldc             "No change for container: "
        //   113: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   116: aload_0        
        //   117: getfield        com/google/tagmanager/ResourceLoader.mContainerId:Ljava/lang/String;
        //   120: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   123: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   126: invokestatic    com/google/tagmanager/Log.v:(Ljava/lang/String;)V
        //   129: aload_0        
        //   130: getfield        com/google/tagmanager/ResourceLoader.mCallback:Lcom/google/tagmanager/LoadCallback;
        //   133: aload           9
        //   135: invokeinterface com/google/tagmanager/LoadCallback.onSuccess:(Ljava/lang/Object;)V
        //   140: aload_2        
        //   141: invokeinterface com/google/tagmanager/NetworkClient.close:()V
        //   146: ldc             "Load resource from network finished."
        //   148: invokestatic    com/google/tagmanager/Log.v:(Ljava/lang/String;)V
        //   151: return         
        //   152: astore          5
        //   154: new             Ljava/lang/StringBuilder;
        //   157: dup            
        //   158: invokespecial   java/lang/StringBuilder.<init>:()V
        //   161: ldc             "No data is retrieved from the given url: "
        //   163: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   166: aload_1        
        //   167: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   170: ldc             ". Make sure container_id: "
        //   172: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   175: aload_0        
        //   176: getfield        com/google/tagmanager/ResourceLoader.mContainerId:Ljava/lang/String;
        //   179: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   182: ldc             " is correct."
        //   184: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   187: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   190: invokestatic    com/google/tagmanager/Log.w:(Ljava/lang/String;)V
        //   193: aload_0        
        //   194: getfield        com/google/tagmanager/ResourceLoader.mCallback:Lcom/google/tagmanager/LoadCallback;
        //   197: getstatic       com/google/tagmanager/LoadCallback$Failure.SERVER_ERROR:Lcom/google/tagmanager/LoadCallback$Failure;
        //   200: invokeinterface com/google/tagmanager/LoadCallback.onFailure:(Lcom/google/tagmanager/LoadCallback$Failure;)V
        //   205: aload_2        
        //   206: invokeinterface com/google/tagmanager/NetworkClient.close:()V
        //   211: return         
        //   212: astore          4
        //   214: new             Ljava/lang/StringBuilder;
        //   217: dup            
        //   218: invokespecial   java/lang/StringBuilder.<init>:()V
        //   221: ldc             "Error when loading resources from url: "
        //   223: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   226: aload_1        
        //   227: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   230: ldc             " "
        //   232: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   235: aload           4
        //   237: invokevirtual   java/io/IOException.getMessage:()Ljava/lang/String;
        //   240: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   243: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   246: aload           4
        //   248: invokestatic    com/google/tagmanager/Log.w:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   251: aload_0        
        //   252: getfield        com/google/tagmanager/ResourceLoader.mCallback:Lcom/google/tagmanager/LoadCallback;
        //   255: getstatic       com/google/tagmanager/LoadCallback$Failure.IO_ERROR:Lcom/google/tagmanager/LoadCallback$Failure;
        //   258: invokeinterface com/google/tagmanager/LoadCallback.onFailure:(Lcom/google/tagmanager/LoadCallback$Failure;)V
        //   263: aload_2        
        //   264: invokeinterface com/google/tagmanager/NetworkClient.close:()V
        //   269: return         
        //   270: astore          8
        //   272: new             Ljava/lang/StringBuilder;
        //   275: dup            
        //   276: invokespecial   java/lang/StringBuilder.<init>:()V
        //   279: ldc             "Error when parsing downloaded resources from url: "
        //   281: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   284: aload_1        
        //   285: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   288: ldc             " "
        //   290: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   293: aload           8
        //   295: invokevirtual   java/io/IOException.getMessage:()Ljava/lang/String;
        //   298: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   301: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   304: aload           8
        //   306: invokestatic    com/google/tagmanager/Log.w:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   309: aload_0        
        //   310: getfield        com/google/tagmanager/ResourceLoader.mCallback:Lcom/google/tagmanager/LoadCallback;
        //   313: getstatic       com/google/tagmanager/LoadCallback$Failure.SERVER_ERROR:Lcom/google/tagmanager/LoadCallback$Failure;
        //   316: invokeinterface com/google/tagmanager/LoadCallback.onFailure:(Lcom/google/tagmanager/LoadCallback$Failure;)V
        //   321: aload_2        
        //   322: invokeinterface com/google/tagmanager/NetworkClient.close:()V
        //   327: return         
        //   328: astore_3       
        //   329: aload_2        
        //   330: invokeinterface com/google/tagmanager/NetworkClient.close:()V
        //   335: aload_3        
        //   336: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  38     47     152    212    Ljava/io/FileNotFoundException;
        //  38     47     212    270    Ljava/io/IOException;
        //  38     47     328    337    Any
        //  47     129    270    328    Ljava/io/IOException;
        //  47     129    328    337    Any
        //  129    140    270    328    Ljava/io/IOException;
        //  129    140    328    337    Any
        //  154    205    328    337    Any
        //  214    263    328    337    Any
        //  272    321    328    337    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0129:
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
    
    private boolean okToLoad() {
        final NetworkInfo activeNetworkInfo = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            Log.v("...no network connectivity");
            return false;
        }
        return true;
    }
    
    @VisibleForTesting
    String getCtfeUrl() {
        String s = this.mCtfeHost.getCtfeServerAddress() + this.mCtfeUrlPathAndQuery + "&v=a62676326";
        if (this.mPreviousVersion != null && !this.mPreviousVersion.trim().equals("")) {
            s = s + "&pv=" + this.mPreviousVersion;
        }
        if (PreviewManager.getInstance().getPreviewMode().equals(PreviewManager.PreviewMode.CONTAINER_DEBUG)) {
            s += "&gtm_debug=x";
        }
        return s;
    }
    
    @Override
    public void run() {
        if (this.mCallback == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.mCallback.startLoad();
        this.loadResource();
    }
    
    @VisibleForTesting
    void setCtfeURLPathAndQuery(final String s) {
        if (s == null) {
            this.mCtfeUrlPathAndQuery = this.mDefaultCtfeUrlPathAndQuery;
            return;
        }
        Log.d("Setting CTFE URL path: " + s);
        this.mCtfeUrlPathAndQuery = s;
    }
    
    void setLoadCallback(final LoadCallback<Serving.SupplementedResource> mCallback) {
        this.mCallback = mCallback;
    }
    
    @VisibleForTesting
    void setPreviousVersion(final String s) {
        Log.d("Setting previous container version: " + s);
        this.mPreviousVersion = s;
    }
}
