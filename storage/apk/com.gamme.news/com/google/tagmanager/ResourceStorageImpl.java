// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.containertag.proto.Serving;
import android.content.res.AssetManager;
import org.json.JSONException;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.InputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import android.content.Context;
import com.google.tagmanager.proto.Resource;

class ResourceStorageImpl implements ResourceStorage
{
    private static final String SAVED_RESOURCE_FILENAME_PREFIX = "resource_";
    private static final String SAVED_RESOURCE_SUB_DIR = "google_tagmanager";
    private LoadCallback<Resource.ResourceWithMetadata> mCallback;
    private final String mContainerId;
    private final Context mContext;
    private final ExecutorService mExecutor;
    
    ResourceStorageImpl(final Context mContext, final String mContainerId) {
        this.mContext = mContext;
        this.mContainerId = mContainerId;
        this.mExecutor = Executors.newSingleThreadExecutor();
    }
    
    private String stringFromInputStream(final InputStream in) throws IOException {
        final StringWriter stringWriter = new StringWriter();
        final char[] cbuf = new char[1024];
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        while (true) {
            final int read = bufferedReader.read(cbuf);
            if (read == -1) {
                break;
            }
            stringWriter.write(cbuf, 0, read);
        }
        return stringWriter.toString();
    }
    
    @Override
    public void close() {
        synchronized (this) {
            this.mExecutor.shutdown();
        }
    }
    
    @VisibleForTesting
    File getResourceFile() {
        return new File(this.mContext.getDir("google_tagmanager", 0), "resource_" + this.mContainerId);
    }
    
    @Override
    public ResourceUtil.ExpandedResource loadExpandedResourceFromJsonAsset(final String str) {
        ResourceUtil.ExpandedResource expandedResourceFromJsonString = null;
        Log.v("loading default container from " + str);
        final AssetManager assets = this.mContext.getAssets();
        if (assets == null) {
            Log.w("Looking for default JSON container in package, but no assets were found.");
        }
        else {
            InputStream open = null;
            try {
                open = assets.open(str);
                expandedResourceFromJsonString = JsonUtils.expandedResourceFromJsonString(this.stringFromInputStream(open));
                if (open == null) {
                    return expandedResourceFromJsonString;
                }
                try {
                    open.close();
                    return expandedResourceFromJsonString;
                }
                catch (IOException ex) {
                    return expandedResourceFromJsonString;
                }
            }
            catch (IOException ex2) {
                Log.w("No asset file: " + str + " found (or errors reading it).");
                expandedResourceFromJsonString = null;
                if (open == null) {
                    return expandedResourceFromJsonString;
                }
                try {
                    open.close();
                    return null;
                }
                catch (IOException ex3) {
                    return null;
                }
            }
            catch (JSONException obj) {
                Log.w("Error parsing JSON file" + str + " : " + obj);
                expandedResourceFromJsonString = null;
                if (open == null) {
                    return expandedResourceFromJsonString;
                }
                try {
                    open.close();
                    return null;
                }
                catch (IOException ex4) {
                    return null;
                }
            }
            finally {
                Label_0194: {
                    if (open == null) {
                        break Label_0194;
                    }
                    try {
                        open.close();
                    }
                    catch (IOException ex5) {}
                }
            }
        }
        return expandedResourceFromJsonString;
    }
    
    @Override
    public Serving.Resource loadResourceFromContainerAsset(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Ljava/lang/StringBuilder;
        //     3: dup            
        //     4: invokespecial   java/lang/StringBuilder.<init>:()V
        //     7: ldc             "Loading default container from "
        //     9: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    12: aload_1        
        //    13: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    16: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    19: invokestatic    com/google/tagmanager/Log.v:(Ljava/lang/String;)V
        //    22: aload_0        
        //    23: getfield        com/google/tagmanager/ResourceStorageImpl.mContext:Landroid/content/Context;
        //    26: invokevirtual   android/content/Context.getAssets:()Landroid/content/res/AssetManager;
        //    29: astore_2       
        //    30: aload_2        
        //    31: ifnonnull       41
        //    34: ldc             "No assets found in package"
        //    36: invokestatic    com/google/tagmanager/Log.e:(Ljava/lang/String;)V
        //    39: aconst_null    
        //    40: areturn        
        //    41: aload_2        
        //    42: aload_1        
        //    43: invokevirtual   android/content/res/AssetManager.open:(Ljava/lang/String;)Ljava/io/InputStream;
        //    46: astore          4
        //    48: new             Ljava/io/ByteArrayOutputStream;
        //    51: dup            
        //    52: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //    55: astore          5
        //    57: aload           4
        //    59: aload           5
        //    61: invokestatic    com/google/tagmanager/ResourceUtil.copyStream:(Ljava/io/InputStream;Ljava/io/OutputStream;)V
        //    64: aload           5
        //    66: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //    69: invokestatic    com/google/analytics/containertag/proto/Serving$Resource.parseFrom:([B)Lcom/google/analytics/containertag/proto/Serving$Resource;
        //    72: astore          10
        //    74: new             Ljava/lang/StringBuilder;
        //    77: dup            
        //    78: invokespecial   java/lang/StringBuilder.<init>:()V
        //    81: ldc             "Parsed default container: "
        //    83: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    86: aload           10
        //    88: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    91: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    94: invokestatic    com/google/tagmanager/Log.v:(Ljava/lang/String;)V
        //    97: aload           4
        //    99: invokevirtual   java/io/InputStream.close:()V
        //   102: aload           10
        //   104: areturn        
        //   105: astore          11
        //   107: aload           10
        //   109: areturn        
        //   110: astore_3       
        //   111: new             Ljava/lang/StringBuilder;
        //   114: dup            
        //   115: invokespecial   java/lang/StringBuilder.<init>:()V
        //   118: ldc             "No asset file: "
        //   120: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   123: aload_1        
        //   124: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   127: ldc             " found."
        //   129: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   132: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   135: invokestatic    com/google/tagmanager/Log.w:(Ljava/lang/String;)V
        //   138: aconst_null    
        //   139: areturn        
        //   140: astore          8
        //   142: new             Ljava/lang/StringBuilder;
        //   145: dup            
        //   146: invokespecial   java/lang/StringBuilder.<init>:()V
        //   149: ldc             "Error when parsing: "
        //   151: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   154: aload_1        
        //   155: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   158: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   161: invokestatic    com/google/tagmanager/Log.w:(Ljava/lang/String;)V
        //   164: aload           4
        //   166: invokevirtual   java/io/InputStream.close:()V
        //   169: aconst_null    
        //   170: areturn        
        //   171: astore          6
        //   173: aload           4
        //   175: invokevirtual   java/io/InputStream.close:()V
        //   178: aload           6
        //   180: athrow         
        //   181: astore          9
        //   183: goto            169
        //   186: astore          7
        //   188: goto            178
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  41     48     110    140    Ljava/io/IOException;
        //  48     97     140    171    Ljava/io/IOException;
        //  48     97     171    181    Any
        //  97     102    105    110    Ljava/io/IOException;
        //  142    164    171    181    Any
        //  164    169    181    186    Ljava/io/IOException;
        //  173    178    186    191    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 87, Size: 87
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
    
    @VisibleForTesting
    void loadResourceFromDisk() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/google/tagmanager/ResourceStorageImpl.mCallback:Lcom/google/tagmanager/LoadCallback;
        //     4: ifnonnull       17
        //     7: new             Ljava/lang/IllegalStateException;
        //    10: dup            
        //    11: ldc             "callback must be set before execute"
        //    13: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    16: athrow         
        //    17: aload_0        
        //    18: getfield        com/google/tagmanager/ResourceStorageImpl.mCallback:Lcom/google/tagmanager/LoadCallback;
        //    21: invokeinterface com/google/tagmanager/LoadCallback.startLoad:()V
        //    26: ldc             "Start loading resource from disk ..."
        //    28: invokestatic    com/google/tagmanager/Log.v:(Ljava/lang/String;)V
        //    31: invokestatic    com/google/tagmanager/PreviewManager.getInstance:()Lcom/google/tagmanager/PreviewManager;
        //    34: invokevirtual   com/google/tagmanager/PreviewManager.getPreviewMode:()Lcom/google/tagmanager/PreviewManager$PreviewMode;
        //    37: getstatic       com/google/tagmanager/PreviewManager$PreviewMode.CONTAINER:Lcom/google/tagmanager/PreviewManager$PreviewMode;
        //    40: if_acmpeq       55
        //    43: invokestatic    com/google/tagmanager/PreviewManager.getInstance:()Lcom/google/tagmanager/PreviewManager;
        //    46: invokevirtual   com/google/tagmanager/PreviewManager.getPreviewMode:()Lcom/google/tagmanager/PreviewManager$PreviewMode;
        //    49: getstatic       com/google/tagmanager/PreviewManager$PreviewMode.CONTAINER_DEBUG:Lcom/google/tagmanager/PreviewManager$PreviewMode;
        //    52: if_acmpne       84
        //    55: aload_0        
        //    56: getfield        com/google/tagmanager/ResourceStorageImpl.mContainerId:Ljava/lang/String;
        //    59: invokestatic    com/google/tagmanager/PreviewManager.getInstance:()Lcom/google/tagmanager/PreviewManager;
        //    62: invokevirtual   com/google/tagmanager/PreviewManager.getContainerId:()Ljava/lang/String;
        //    65: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    68: ifeq            84
        //    71: aload_0        
        //    72: getfield        com/google/tagmanager/ResourceStorageImpl.mCallback:Lcom/google/tagmanager/LoadCallback;
        //    75: getstatic       com/google/tagmanager/LoadCallback$Failure.NOT_AVAILABLE:Lcom/google/tagmanager/LoadCallback$Failure;
        //    78: invokeinterface com/google/tagmanager/LoadCallback.onFailure:(Lcom/google/tagmanager/LoadCallback$Failure;)V
        //    83: return         
        //    84: new             Ljava/io/FileInputStream;
        //    87: dup            
        //    88: aload_0        
        //    89: invokevirtual   com/google/tagmanager/ResourceStorageImpl.getResourceFile:()Ljava/io/File;
        //    92: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    95: astore_1       
        //    96: new             Ljava/io/ByteArrayOutputStream;
        //    99: dup            
        //   100: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //   103: astore_2       
        //   104: aload_1        
        //   105: aload_2        
        //   106: invokestatic    com/google/tagmanager/ResourceUtil.copyStream:(Ljava/io/InputStream;Ljava/io/OutputStream;)V
        //   109: aload_0        
        //   110: getfield        com/google/tagmanager/ResourceStorageImpl.mCallback:Lcom/google/tagmanager/LoadCallback;
        //   113: aload_2        
        //   114: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //   117: invokestatic    com/google/tagmanager/proto/Resource$ResourceWithMetadata.parseFrom:([B)Lcom/google/tagmanager/proto/Resource$ResourceWithMetadata;
        //   120: invokeinterface com/google/tagmanager/LoadCallback.onSuccess:(Ljava/lang/Object;)V
        //   125: aload_1        
        //   126: invokevirtual   java/io/FileInputStream.close:()V
        //   129: ldc_w           "Load resource from disk finished."
        //   132: invokestatic    com/google/tagmanager/Log.v:(Ljava/lang/String;)V
        //   135: return         
        //   136: astore          8
        //   138: ldc_w           "resource not on disk"
        //   141: invokestatic    com/google/tagmanager/Log.d:(Ljava/lang/String;)V
        //   144: aload_0        
        //   145: getfield        com/google/tagmanager/ResourceStorageImpl.mCallback:Lcom/google/tagmanager/LoadCallback;
        //   148: getstatic       com/google/tagmanager/LoadCallback$Failure.NOT_AVAILABLE:Lcom/google/tagmanager/LoadCallback$Failure;
        //   151: invokeinterface com/google/tagmanager/LoadCallback.onFailure:(Lcom/google/tagmanager/LoadCallback$Failure;)V
        //   156: return         
        //   157: astore          7
        //   159: ldc_w           "error closing stream for reading resource from disk"
        //   162: invokestatic    com/google/tagmanager/Log.w:(Ljava/lang/String;)V
        //   165: goto            129
        //   168: astore          5
        //   170: ldc_w           "error reading resource from disk"
        //   173: invokestatic    com/google/tagmanager/Log.w:(Ljava/lang/String;)V
        //   176: aload_0        
        //   177: getfield        com/google/tagmanager/ResourceStorageImpl.mCallback:Lcom/google/tagmanager/LoadCallback;
        //   180: getstatic       com/google/tagmanager/LoadCallback$Failure.IO_ERROR:Lcom/google/tagmanager/LoadCallback$Failure;
        //   183: invokeinterface com/google/tagmanager/LoadCallback.onFailure:(Lcom/google/tagmanager/LoadCallback$Failure;)V
        //   188: aload_1        
        //   189: invokevirtual   java/io/FileInputStream.close:()V
        //   192: goto            129
        //   195: astore          6
        //   197: ldc_w           "error closing stream for reading resource from disk"
        //   200: invokestatic    com/google/tagmanager/Log.w:(Ljava/lang/String;)V
        //   203: goto            129
        //   206: astore_3       
        //   207: aload_1        
        //   208: invokevirtual   java/io/FileInputStream.close:()V
        //   211: aload_3        
        //   212: athrow         
        //   213: astore          4
        //   215: ldc_w           "error closing stream for reading resource from disk"
        //   218: invokestatic    com/google/tagmanager/Log.w:(Ljava/lang/String;)V
        //   221: goto            211
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  84     96     136    157    Ljava/io/FileNotFoundException;
        //  96     125    168    206    Ljava/io/IOException;
        //  96     125    206    224    Any
        //  125    129    157    168    Ljava/io/IOException;
        //  170    188    206    224    Any
        //  188    192    195    206    Ljava/io/IOException;
        //  207    211    213    224    Ljava/io/IOException;
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
    
    @Override
    public void loadResourceFromDiskInBackground() {
        this.mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                ResourceStorageImpl.this.loadResourceFromDisk();
            }
        });
    }
    
    @VisibleForTesting
    boolean saveResourceToDisk(final Resource.ResourceWithMetadata p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   com/google/tagmanager/ResourceStorageImpl.getResourceFile:()Ljava/io/File;
        //     4: astore_2       
        //     5: new             Ljava/io/FileOutputStream;
        //     8: dup            
        //     9: aload_2        
        //    10: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //    13: astore_3       
        //    14: aload_3        
        //    15: aload_1        
        //    16: invokestatic    com/google/tagmanager/protobuf/nano/MessageNano.toByteArray:(Lcom/google/tagmanager/protobuf/nano/MessageNano;)[B
        //    19: invokevirtual   java/io/FileOutputStream.write:([B)V
        //    22: aload_3        
        //    23: invokevirtual   java/io/FileOutputStream.close:()V
        //    26: iconst_1       
        //    27: ireturn        
        //    28: astore          10
        //    30: ldc_w           "Error opening resource file for writing"
        //    33: invokestatic    com/google/tagmanager/Log.e:(Ljava/lang/String;)V
        //    36: iconst_0       
        //    37: ireturn        
        //    38: astore          9
        //    40: ldc_w           "error closing stream for writing resource to disk"
        //    43: invokestatic    com/google/tagmanager/Log.w:(Ljava/lang/String;)V
        //    46: goto            26
        //    49: astore          6
        //    51: ldc_w           "Error writing resource to disk. Removing resource from disk."
        //    54: invokestatic    com/google/tagmanager/Log.w:(Ljava/lang/String;)V
        //    57: aload_2        
        //    58: invokevirtual   java/io/File.delete:()Z
        //    61: pop            
        //    62: aload_3        
        //    63: invokevirtual   java/io/FileOutputStream.close:()V
        //    66: iconst_0       
        //    67: ireturn        
        //    68: astore          8
        //    70: ldc_w           "error closing stream for writing resource to disk"
        //    73: invokestatic    com/google/tagmanager/Log.w:(Ljava/lang/String;)V
        //    76: goto            66
        //    79: astore          4
        //    81: aload_3        
        //    82: invokevirtual   java/io/FileOutputStream.close:()V
        //    85: aload           4
        //    87: athrow         
        //    88: astore          5
        //    90: ldc_w           "error closing stream for writing resource to disk"
        //    93: invokestatic    com/google/tagmanager/Log.w:(Ljava/lang/String;)V
        //    96: goto            85
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  5      14     28     38     Ljava/io/FileNotFoundException;
        //  14     22     49     79     Ljava/io/IOException;
        //  14     22     79     99     Any
        //  22     26     38     49     Ljava/io/IOException;
        //  51     62     79     99     Any
        //  62     66     68     79     Ljava/io/IOException;
        //  81     85     88     99     Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0026:
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
    public void saveResourceToDiskInBackground(final Resource.ResourceWithMetadata resourceWithMetadata) {
        this.mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                ResourceStorageImpl.this.saveResourceToDisk(resourceWithMetadata);
            }
        });
    }
    
    @Override
    public void setLoadCallback(final LoadCallback<Resource.ResourceWithMetadata> mCallback) {
        this.mCallback = mCallback;
    }
}
