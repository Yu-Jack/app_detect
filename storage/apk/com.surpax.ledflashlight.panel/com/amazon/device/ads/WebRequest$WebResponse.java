// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Map;
import java.net.URL;
import java.net.URI;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;

public class WebRequest$WebResponse
{
    private String body;
    private String httpStatus;
    private int httpStatusCode;
    private InputStream inputStream;
    private boolean logEnabled;
    private String logTag;
    final /* synthetic */ WebRequest this$0;
    
    protected WebRequest$WebResponse(final WebRequest this$0) {
        this.this$0 = this$0;
        this.logTag = WebRequest.LOG_TAG;
    }
    
    protected void enableLog(final boolean logEnabled) {
        this.logEnabled = logEnabled;
    }
    
    public String getBody() {
        if (this.body == null) {
            this.readResponseString();
        }
        return this.body;
    }
    
    public String getHttpStatus() {
        return this.httpStatus;
    }
    
    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }
    
    public JSONObject getJSONObjectBody() {
        if (this.getBody() == null) {
            return null;
        }
        try {
            return new JSONObject(this.getBody());
        }
        catch (JSONException ex) {
            Log.e(this.this$0.getLogTag(), "Unable to parse the body into a JSONObject.");
            return null;
        }
    }
    
    public boolean isHttpStatusCodeOK() {
        return this.getHttpStatusCode() == 200;
    }
    
    protected void readResponseString() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/amazon/device/ads/WebRequest$WebResponse.inputStream:Ljava/io/InputStream;
        //     4: ifnull          117
        //     7: new             Ljava/lang/StringBuilder;
        //    10: dup            
        //    11: invokespecial   java/lang/StringBuilder.<init>:()V
        //    14: astore_1       
        //    15: sipush          4096
        //    18: newarray        B
        //    20: astore_2       
        //    21: aload_0        
        //    22: getfield        com/amazon/device/ads/WebRequest$WebResponse.inputStream:Ljava/io/InputStream;
        //    25: aload_2        
        //    26: invokevirtual   java/io/InputStream.read:([B)I
        //    29: istore          11
        //    31: iload           11
        //    33: iconst_m1      
        //    34: if_icmpeq       118
        //    37: aload_1        
        //    38: new             Ljava/lang/String;
        //    41: dup            
        //    42: aload_2        
        //    43: iconst_0       
        //    44: iload           11
        //    46: invokespecial   java/lang/String.<init>:([BII)V
        //    49: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    52: pop            
        //    53: goto            21
        //    56: astore          7
        //    58: aload_0        
        //    59: getfield        com/amazon/device/ads/WebRequest$WebResponse.logTag:Ljava/lang/String;
        //    62: ldc             "Unable to read the stream from the network."
        //    64: invokestatic    com/amazon/device/ads/Log.e:(Ljava/lang/String;Ljava/lang/String;)V
        //    67: aload_0        
        //    68: getfield        com/amazon/device/ads/WebRequest$WebResponse.inputStream:Ljava/io/InputStream;
        //    71: invokevirtual   java/io/InputStream.close:()V
        //    74: aload_0        
        //    75: aload_1        
        //    76: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    79: invokevirtual   com/amazon/device/ads/WebRequest$WebResponse.setBody:(Ljava/lang/String;)V
        //    82: aload_0        
        //    83: getfield        com/amazon/device/ads/WebRequest$WebResponse.logEnabled:Z
        //    86: ifeq            117
        //    89: invokestatic    com/amazon/device/ads/WebRequest.access$000:()Ljava/lang/String;
        //    92: astore          9
        //    94: iconst_1       
        //    95: anewarray       Ljava/lang/Object;
        //    98: astore          10
        //   100: aload           10
        //   102: iconst_0       
        //   103: aload_0        
        //   104: invokevirtual   com/amazon/device/ads/WebRequest$WebResponse.getBody:()Ljava/lang/String;
        //   107: aastore        
        //   108: aload           9
        //   110: ldc             "Response: %s"
        //   112: aload           10
        //   114: invokestatic    com/amazon/device/ads/Log.d:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   117: return         
        //   118: aload_0        
        //   119: getfield        com/amazon/device/ads/WebRequest$WebResponse.inputStream:Ljava/io/InputStream;
        //   122: invokevirtual   java/io/InputStream.close:()V
        //   125: aload_0        
        //   126: aload_1        
        //   127: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   130: invokevirtual   com/amazon/device/ads/WebRequest$WebResponse.setBody:(Ljava/lang/String;)V
        //   133: aload_0        
        //   134: getfield        com/amazon/device/ads/WebRequest$WebResponse.logEnabled:Z
        //   137: ifeq            117
        //   140: invokestatic    com/amazon/device/ads/WebRequest.access$000:()Ljava/lang/String;
        //   143: astore          14
        //   145: iconst_1       
        //   146: anewarray       Ljava/lang/Object;
        //   149: astore          15
        //   151: aload           15
        //   153: iconst_0       
        //   154: aload_0        
        //   155: invokevirtual   com/amazon/device/ads/WebRequest$WebResponse.getBody:()Ljava/lang/String;
        //   158: aastore        
        //   159: aload           14
        //   161: ldc             "Response: %s"
        //   163: aload           15
        //   165: invokestatic    com/amazon/device/ads/Log.d:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   168: return         
        //   169: astore          13
        //   171: aload_0        
        //   172: getfield        com/amazon/device/ads/WebRequest$WebResponse.logTag:Ljava/lang/String;
        //   175: ldc             "IOException while trying to close the stream"
        //   177: invokestatic    com/amazon/device/ads/Log.e:(Ljava/lang/String;Ljava/lang/String;)V
        //   180: goto            125
        //   183: astore          8
        //   185: aload_0        
        //   186: getfield        com/amazon/device/ads/WebRequest$WebResponse.logTag:Ljava/lang/String;
        //   189: ldc             "IOException while trying to close the stream"
        //   191: invokestatic    com/amazon/device/ads/Log.e:(Ljava/lang/String;Ljava/lang/String;)V
        //   194: goto            74
        //   197: astore_3       
        //   198: aload_0        
        //   199: getfield        com/amazon/device/ads/WebRequest$WebResponse.inputStream:Ljava/io/InputStream;
        //   202: invokevirtual   java/io/InputStream.close:()V
        //   205: aload_0        
        //   206: aload_1        
        //   207: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   210: invokevirtual   com/amazon/device/ads/WebRequest$WebResponse.setBody:(Ljava/lang/String;)V
        //   213: aload_0        
        //   214: getfield        com/amazon/device/ads/WebRequest$WebResponse.logEnabled:Z
        //   217: ifeq            248
        //   220: invokestatic    com/amazon/device/ads/WebRequest.access$000:()Ljava/lang/String;
        //   223: astore          5
        //   225: iconst_1       
        //   226: anewarray       Ljava/lang/Object;
        //   229: astore          6
        //   231: aload           6
        //   233: iconst_0       
        //   234: aload_0        
        //   235: invokevirtual   com/amazon/device/ads/WebRequest$WebResponse.getBody:()Ljava/lang/String;
        //   238: aastore        
        //   239: aload           5
        //   241: ldc             "Response: %s"
        //   243: aload           6
        //   245: invokestatic    com/amazon/device/ads/Log.d:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   248: aload_3        
        //   249: athrow         
        //   250: astore          4
        //   252: aload_0        
        //   253: getfield        com/amazon/device/ads/WebRequest$WebResponse.logTag:Ljava/lang/String;
        //   256: ldc             "IOException while trying to close the stream"
        //   258: invokestatic    com/amazon/device/ads/Log.e:(Ljava/lang/String;Ljava/lang/String;)V
        //   261: goto            205
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  21     31     56     117    Ljava/io/IOException;
        //  21     31     197    264    Any
        //  37     53     56     117    Ljava/io/IOException;
        //  37     53     197    264    Any
        //  58     67     197    264    Any
        //  67     74     183    197    Ljava/io/IOException;
        //  118    125    169    183    Ljava/io/IOException;
        //  198    205    250    264    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0074:
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
    
    protected void setBody(final String body) {
        this.body = body;
    }
    
    protected void setHttpStatus(final String httpStatus) {
        this.httpStatus = httpStatus;
    }
    
    protected void setHttpStatusCode(final int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }
    
    protected void setInputStream(final InputStream inputStream) {
        this.inputStream = inputStream;
    }
    
    protected void setLogTag(final String logTag) {
        this.logTag = logTag;
    }
}
