// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.internal;

import org.json.JSONException;
import org.json.JSONTokener;
import java.security.InvalidParameterException;
import java.io.FilenameFilter;
import java.io.OutputStream;
import org.json.JSONObject;
import com.facebook.LoggingBehavior;
import java.util.Date;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import com.facebook.Settings;
import android.content.Context;
import java.io.File;
import java.util.concurrent.atomic.AtomicLong;

public final class FileLruCache
{
    private static final String HEADER_CACHEKEY_KEY = "key";
    private static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
    static final String TAG;
    private static final AtomicLong bufferIndex;
    private final File directory;
    private boolean isTrimInProgress;
    private boolean isTrimPending;
    private AtomicLong lastClearCacheTime;
    private final Limits limits;
    private final Object lock;
    private final String tag;
    
    static {
        TAG = FileLruCache.class.getSimpleName();
        bufferIndex = new AtomicLong();
    }
    
    public FileLruCache(final Context context, final String s, final Limits limits) {
        this.lastClearCacheTime = new AtomicLong(0L);
        this.tag = s;
        this.limits = limits;
        this.directory = new File(context.getCacheDir(), s);
        this.lock = new Object();
        if (this.directory.mkdirs() || this.directory.isDirectory()) {
            BufferFile.deleteAll(this.directory);
        }
    }
    
    private void postTrim() {
        synchronized (this.lock) {
            if (!this.isTrimPending) {
                this.isTrimPending = true;
                Settings.getExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        FileLruCache.this.trim();
                    }
                });
            }
        }
    }
    
    private void renameToTargetAndTrim(final String s, final File file) {
        if (!file.renameTo(new File(this.directory, Utility.md5hash(s)))) {
            file.delete();
        }
        this.postTrim();
    }
    
    private void trim() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/facebook/internal/FileLruCache.lock:Ljava/lang/Object;
        //     4: astore_1       
        //     5: aload_1        
        //     6: monitorenter   
        //     7: aload_0        
        //     8: iconst_0       
        //     9: putfield        com/facebook/internal/FileLruCache.isTrimPending:Z
        //    12: aload_0        
        //    13: iconst_1       
        //    14: putfield        com/facebook/internal/FileLruCache.isTrimInProgress:Z
        //    17: aload_1        
        //    18: monitorexit    
        //    19: getstatic       com/facebook/LoggingBehavior.CACHE:Lcom/facebook/LoggingBehavior;
        //    22: getstatic       com/facebook/internal/FileLruCache.TAG:Ljava/lang/String;
        //    25: ldc             "trim started"
        //    27: invokestatic    com/facebook/internal/Logger.log:(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
        //    30: new             Ljava/util/PriorityQueue;
        //    33: dup            
        //    34: invokespecial   java/util/PriorityQueue.<init>:()V
        //    37: astore          6
        //    39: lconst_0       
        //    40: lstore          7
        //    42: lconst_0       
        //    43: lstore          9
        //    45: aload_0        
        //    46: getfield        com/facebook/internal/FileLruCache.directory:Ljava/io/File;
        //    49: invokestatic    com/facebook/internal/FileLruCache$BufferFile.excludeBufferFiles:()Ljava/io/FilenameFilter;
        //    52: invokevirtual   java/io/File.listFiles:(Ljava/io/FilenameFilter;)[Ljava/io/File;
        //    55: astore          11
        //    57: aload           11
        //    59: ifnull          73
        //    62: aload           11
        //    64: arraylength    
        //    65: istore          12
        //    67: iconst_0       
        //    68: istore          13
        //    70: goto            341
        //    73: lload           7
        //    75: aload_0        
        //    76: getfield        com/facebook/internal/FileLruCache.limits:Lcom/facebook/internal/FileLruCache$Limits;
        //    79: invokevirtual   com/facebook/internal/FileLruCache$Limits.getByteCount:()I
        //    82: i2l            
        //    83: lcmp           
        //    84: ifgt            231
        //    87: aload_0        
        //    88: getfield        com/facebook/internal/FileLruCache.limits:Lcom/facebook/internal/FileLruCache$Limits;
        //    91: invokevirtual   com/facebook/internal/FileLruCache$Limits.getFileCount:()I
        //    94: istore          16
        //    96: lload           9
        //    98: iload           16
        //   100: i2l            
        //   101: lcmp           
        //   102: ifgt            231
        //   105: aload_0        
        //   106: getfield        com/facebook/internal/FileLruCache.lock:Ljava/lang/Object;
        //   109: astore          17
        //   111: aload           17
        //   113: monitorenter   
        //   114: aload_0        
        //   115: iconst_0       
        //   116: putfield        com/facebook/internal/FileLruCache.isTrimInProgress:Z
        //   119: aload_0        
        //   120: getfield        com/facebook/internal/FileLruCache.lock:Ljava/lang/Object;
        //   123: invokevirtual   java/lang/Object.notifyAll:()V
        //   126: aload           17
        //   128: monitorexit    
        //   129: return         
        //   130: astore_2       
        //   131: aload_1        
        //   132: monitorexit    
        //   133: aload_2        
        //   134: athrow         
        //   135: aload           11
        //   137: iload           13
        //   139: aaload         
        //   140: astore          19
        //   142: new             Lcom/facebook/internal/FileLruCache$ModifiedFile;
        //   145: dup            
        //   146: aload           19
        //   148: invokespecial   com/facebook/internal/FileLruCache$ModifiedFile.<init>:(Ljava/io/File;)V
        //   151: astore          20
        //   153: aload           6
        //   155: aload           20
        //   157: invokevirtual   java/util/PriorityQueue.add:(Ljava/lang/Object;)Z
        //   160: pop            
        //   161: getstatic       com/facebook/LoggingBehavior.CACHE:Lcom/facebook/LoggingBehavior;
        //   164: getstatic       com/facebook/internal/FileLruCache.TAG:Ljava/lang/String;
        //   167: new             Ljava/lang/StringBuilder;
        //   170: dup            
        //   171: ldc             "  trim considering time="
        //   173: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   176: aload           20
        //   178: invokevirtual   com/facebook/internal/FileLruCache$ModifiedFile.getModified:()J
        //   181: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   184: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   187: ldc             " name="
        //   189: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   192: aload           20
        //   194: invokevirtual   com/facebook/internal/FileLruCache$ModifiedFile.getFile:()Ljava/io/File;
        //   197: invokevirtual   java/io/File.getName:()Ljava/lang/String;
        //   200: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   203: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   206: invokestatic    com/facebook/internal/Logger.log:(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
        //   209: lload           7
        //   211: aload           19
        //   213: invokevirtual   java/io/File.length:()J
        //   216: ladd           
        //   217: lstore          7
        //   219: lload           9
        //   221: lconst_1       
        //   222: ladd           
        //   223: lstore          9
        //   225: iinc            13, 1
        //   228: goto            341
        //   231: aload           6
        //   233: invokevirtual   java/util/PriorityQueue.remove:()Ljava/lang/Object;
        //   236: checkcast       Lcom/facebook/internal/FileLruCache$ModifiedFile;
        //   239: invokevirtual   com/facebook/internal/FileLruCache$ModifiedFile.getFile:()Ljava/io/File;
        //   242: astore          14
        //   244: getstatic       com/facebook/LoggingBehavior.CACHE:Lcom/facebook/LoggingBehavior;
        //   247: getstatic       com/facebook/internal/FileLruCache.TAG:Ljava/lang/String;
        //   250: new             Ljava/lang/StringBuilder;
        //   253: dup            
        //   254: ldc             "  trim removing "
        //   256: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   259: aload           14
        //   261: invokevirtual   java/io/File.getName:()Ljava/lang/String;
        //   264: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   267: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   270: invokestatic    com/facebook/internal/Logger.log:(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
        //   273: lload           7
        //   275: aload           14
        //   277: invokevirtual   java/io/File.length:()J
        //   280: lsub           
        //   281: lstore          7
        //   283: lload           9
        //   285: lconst_1       
        //   286: lsub           
        //   287: lstore          9
        //   289: aload           14
        //   291: invokevirtual   java/io/File.delete:()Z
        //   294: pop            
        //   295: goto            73
        //   298: astore_3       
        //   299: aload_0        
        //   300: getfield        com/facebook/internal/FileLruCache.lock:Ljava/lang/Object;
        //   303: astore          4
        //   305: aload           4
        //   307: monitorenter   
        //   308: aload_0        
        //   309: iconst_0       
        //   310: putfield        com/facebook/internal/FileLruCache.isTrimInProgress:Z
        //   313: aload_0        
        //   314: getfield        com/facebook/internal/FileLruCache.lock:Ljava/lang/Object;
        //   317: invokevirtual   java/lang/Object.notifyAll:()V
        //   320: aload           4
        //   322: monitorexit    
        //   323: aload_3        
        //   324: athrow         
        //   325: astore          5
        //   327: aload           4
        //   329: monitorexit    
        //   330: aload           5
        //   332: athrow         
        //   333: astore          18
        //   335: aload           17
        //   337: monitorexit    
        //   338: aload           18
        //   340: athrow         
        //   341: iload           13
        //   343: iload           12
        //   345: if_icmplt       135
        //   348: goto            73
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  7      19     130    135    Any
        //  19     39     298    333    Any
        //  45     57     298    333    Any
        //  62     67     298    333    Any
        //  73     96     298    333    Any
        //  114    129    333    341    Any
        //  131    133    130    135    Any
        //  135    219    298    333    Any
        //  231    283    298    333    Any
        //  289    295    298    333    Any
        //  308    323    325    333    Any
        //  327    330    325    333    Any
        //  335    338    333    341    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 174, Size: 174
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
    
    public void clearCache() {
        final File[] listFiles = this.directory.listFiles(BufferFile.excludeBufferFiles());
        this.lastClearCacheTime.set(System.currentTimeMillis());
        if (listFiles != null) {
            Settings.getExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    final File[] val$filesToDelete = listFiles;
                    for (int length = val$filesToDelete.length, i = 0; i < length; ++i) {
                        val$filesToDelete[i].delete();
                    }
                }
            });
        }
    }
    
    public InputStream get(final String s) throws IOException {
        return this.get(s, null);
    }
    
    public InputStream get(final String anObject, final String s) throws IOException {
        final File file = new File(this.directory, Utility.md5hash(anObject));
        Label_0067: {
            BufferedInputStream bufferedInputStream;
            try {
                final BufferedInputStream bufferedInputStream2;
                bufferedInputStream = (bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file), 8192));
                final JSONObject jsonObject = StreamHeader.readHeader(bufferedInputStream2);
                final JSONObject jsonObject3;
                final JSONObject jsonObject2 = jsonObject3 = jsonObject;
                if (jsonObject3 == null) {
                    return null;
                }
                break Label_0067;
            }
            catch (IOException ex) {
                return null;
            }
            try {
                final BufferedInputStream bufferedInputStream2 = bufferedInputStream;
                final JSONObject jsonObject = StreamHeader.readHeader(bufferedInputStream2);
                final JSONObject jsonObject3;
                final JSONObject jsonObject2 = jsonObject3 = jsonObject;
                if (jsonObject3 == null) {
                    return null;
                }
                final String optString = jsonObject2.optString("key");
                if (optString == null || !optString.equals(anObject)) {
                    return null;
                }
                final String optString2 = jsonObject2.optString("tag", (String)null);
                if ((s == null && optString2 != null) || (s != null && !s.equals(optString2))) {
                    return null;
                }
                final long time = new Date().getTime();
                Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "Setting lastModified to " + (Object)time + " for " + file.getName());
                file.setLastModified(time);
                if (!true) {
                    bufferedInputStream.close();
                }
                return bufferedInputStream;
            }
            finally {
                if (!false) {
                    bufferedInputStream.close();
                }
            }
        }
    }
    
    public InputStream interceptAndPut(final String s, final InputStream inputStream) throws IOException {
        return new CopyingInputStream(inputStream, this.openPutStream(s));
    }
    
    OutputStream openPutStream(final String s) throws IOException {
        return this.openPutStream(s, null);
    }
    
    public OutputStream openPutStream(final String p0, final String p1) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/facebook/internal/FileLruCache.directory:Ljava/io/File;
        //     4: invokestatic    com/facebook/internal/FileLruCache$BufferFile.newFile:(Ljava/io/File;)Ljava/io/File;
        //     7: astore_3       
        //     8: aload_3        
        //     9: invokevirtual   java/io/File.delete:()Z
        //    12: pop            
        //    13: aload_3        
        //    14: invokevirtual   java/io/File.createNewFile:()Z
        //    17: ifne            48
        //    20: new             Ljava/io/IOException;
        //    23: dup            
        //    24: new             Ljava/lang/StringBuilder;
        //    27: dup            
        //    28: ldc_w           "Could not create file at "
        //    31: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    34: aload_3        
        //    35: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //    38: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    41: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    44: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //    47: athrow         
        //    48: new             Ljava/io/FileOutputStream;
        //    51: dup            
        //    52: aload_3        
        //    53: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //    56: astore          5
        //    58: new             Ljava/io/BufferedOutputStream;
        //    61: dup            
        //    62: new             Lcom/facebook/internal/FileLruCache$CloseCallbackOutputStream;
        //    65: dup            
        //    66: aload           5
        //    68: new             Lcom/facebook/internal/FileLruCache$1;
        //    71: dup            
        //    72: aload_0        
        //    73: invokestatic    java/lang/System.currentTimeMillis:()J
        //    76: aload_3        
        //    77: aload_1        
        //    78: invokespecial   com/facebook/internal/FileLruCache$1.<init>:(Lcom/facebook/internal/FileLruCache;JLjava/io/File;Ljava/lang/String;)V
        //    81: invokespecial   com/facebook/internal/FileLruCache$CloseCallbackOutputStream.<init>:(Ljava/io/OutputStream;Lcom/facebook/internal/FileLruCache$StreamCloseCallback;)V
        //    84: sipush          8192
        //    87: invokespecial   java/io/BufferedOutputStream.<init>:(Ljava/io/OutputStream;I)V
        //    90: astore          6
        //    92: new             Lorg/json/JSONObject;
        //    95: dup            
        //    96: invokespecial   org/json/JSONObject.<init>:()V
        //    99: astore          7
        //   101: aload           7
        //   103: ldc             "key"
        //   105: aload_1        
        //   106: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   109: pop            
        //   110: aload_2        
        //   111: invokestatic    com/facebook/internal/Utility.isNullOrEmpty:(Ljava/lang/String;)Z
        //   114: ifne            126
        //   117: aload           7
        //   119: ldc             "tag"
        //   121: aload_2        
        //   122: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   125: pop            
        //   126: aload           6
        //   128: aload           7
        //   130: invokestatic    com/facebook/internal/FileLruCache$StreamHeader.writeHeader:(Ljava/io/OutputStream;Lorg/json/JSONObject;)V
        //   133: iconst_1       
        //   134: ifne            142
        //   137: aload           6
        //   139: invokevirtual   java/io/BufferedOutputStream.close:()V
        //   142: aload           6
        //   144: areturn        
        //   145: astore          12
        //   147: getstatic       com/facebook/LoggingBehavior.CACHE:Lcom/facebook/LoggingBehavior;
        //   150: iconst_5       
        //   151: getstatic       com/facebook/internal/FileLruCache.TAG:Ljava/lang/String;
        //   154: new             Ljava/lang/StringBuilder;
        //   157: dup            
        //   158: ldc_w           "Error creating buffer output stream: "
        //   161: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   164: aload           12
        //   166: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   169: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   172: invokestatic    com/facebook/internal/Logger.log:(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;)V
        //   175: new             Ljava/io/IOException;
        //   178: dup            
        //   179: aload           12
        //   181: invokevirtual   java/io/FileNotFoundException.getMessage:()Ljava/lang/String;
        //   184: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   187: athrow         
        //   188: astore          9
        //   190: getstatic       com/facebook/LoggingBehavior.CACHE:Lcom/facebook/LoggingBehavior;
        //   193: iconst_5       
        //   194: getstatic       com/facebook/internal/FileLruCache.TAG:Ljava/lang/String;
        //   197: new             Ljava/lang/StringBuilder;
        //   200: dup            
        //   201: ldc_w           "Error creating JSON header for cache file: "
        //   204: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   207: aload           9
        //   209: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   212: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   215: invokestatic    com/facebook/internal/Logger.log:(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;)V
        //   218: new             Ljava/io/IOException;
        //   221: dup            
        //   222: aload           9
        //   224: invokevirtual   org/json/JSONException.getMessage:()Ljava/lang/String;
        //   227: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   230: athrow         
        //   231: astore          8
        //   233: iconst_0       
        //   234: ifne            242
        //   237: aload           6
        //   239: invokevirtual   java/io/BufferedOutputStream.close:()V
        //   242: aload           8
        //   244: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  48     58     145    188    Ljava/io/FileNotFoundException;
        //  92     126    188    231    Lorg/json/JSONException;
        //  92     126    231    245    Any
        //  126    133    188    231    Lorg/json/JSONException;
        //  126    133    231    245    Any
        //  190    231    231    245    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0126:
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
    
    long sizeInBytesForTest() {
        // monitorenter(this.lock)
        while (true) {
            while (true) {
                File[] listFiles = null;
                long n = 0L;
                int n2 = 0;
                Label_0077: {
                    try {
                        while (this.isTrimPending || this.isTrimInProgress) {
                            try {
                                this.lock.wait();
                            }
                            catch (InterruptedException ex) {}
                        }
                        // monitorexit(this.lock)
                        listFiles = this.directory.listFiles();
                        n = 0L;
                        if (listFiles != null) {
                            final int length = listFiles.length;
                            n2 = 0;
                            if (n2 < length) {
                                break Label_0077;
                            }
                        }
                        return n;
                    }
                    finally {
                    }
                    // monitorexit(this.lock)
                }
                n += listFiles[n2].length();
                ++n2;
                continue;
            }
        }
    }
    
    @Override
    public String toString() {
        return "{FileLruCache: tag:" + this.tag + " file:" + this.directory.getName() + "}";
    }
    
    private static class BufferFile
    {
        private static final String FILE_NAME_PREFIX = "buffer";
        private static final FilenameFilter filterExcludeBufferFiles;
        private static final FilenameFilter filterExcludeNonBufferFiles;
        
        static {
            filterExcludeBufferFiles = new FilenameFilter() {
                @Override
                public boolean accept(final File file, final String s) {
                    return !s.startsWith("buffer");
                }
            };
            filterExcludeNonBufferFiles = new FilenameFilter() {
                @Override
                public boolean accept(final File file, final String s) {
                    return s.startsWith("buffer");
                }
            };
        }
        
        static void deleteAll(final File file) {
            final File[] listFiles = file.listFiles(excludeNonBufferFiles());
            if (listFiles != null) {
                for (int length = listFiles.length, i = 0; i < length; ++i) {
                    listFiles[i].delete();
                }
            }
        }
        
        static FilenameFilter excludeBufferFiles() {
            return BufferFile.filterExcludeBufferFiles;
        }
        
        static FilenameFilter excludeNonBufferFiles() {
            return BufferFile.filterExcludeNonBufferFiles;
        }
        
        static File newFile(final File parent) {
            return new File(parent, "buffer" + Long.valueOf(FileLruCache.bufferIndex.incrementAndGet()).toString());
        }
    }
    
    private static class CloseCallbackOutputStream extends OutputStream
    {
        final StreamCloseCallback callback;
        final OutputStream innerStream;
        
        CloseCallbackOutputStream(final OutputStream innerStream, final StreamCloseCallback callback) {
            this.innerStream = innerStream;
            this.callback = callback;
        }
        
        @Override
        public void close() throws IOException {
            try {
                this.innerStream.close();
            }
            finally {
                this.callback.onClose();
            }
        }
        
        @Override
        public void flush() throws IOException {
            this.innerStream.flush();
        }
        
        @Override
        public void write(final int n) throws IOException {
            this.innerStream.write(n);
        }
        
        @Override
        public void write(final byte[] b) throws IOException {
            this.innerStream.write(b);
        }
        
        @Override
        public void write(final byte[] b, final int off, final int len) throws IOException {
            this.innerStream.write(b, off, len);
        }
    }
    
    private static final class CopyingInputStream extends InputStream
    {
        final InputStream input;
        final OutputStream output;
        
        CopyingInputStream(final InputStream input, final OutputStream output) {
            this.input = input;
            this.output = output;
        }
        
        @Override
        public int available() throws IOException {
            return this.input.available();
        }
        
        @Override
        public void close() throws IOException {
            try {
                this.input.close();
            }
            finally {
                this.output.close();
            }
        }
        
        @Override
        public void mark(final int n) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean markSupported() {
            return false;
        }
        
        @Override
        public int read() throws IOException {
            final int read = this.input.read();
            if (read >= 0) {
                this.output.write(read);
            }
            return read;
        }
        
        @Override
        public int read(final byte[] array) throws IOException {
            final int read = this.input.read(array);
            if (read > 0) {
                this.output.write(array, 0, read);
            }
            return read;
        }
        
        @Override
        public int read(final byte[] array, final int n, final int len) throws IOException {
            final int read = this.input.read(array, n, len);
            if (read > 0) {
                this.output.write(array, n, read);
            }
            return read;
        }
        
        @Override
        public void reset() {
            synchronized (this) {
                throw new UnsupportedOperationException();
            }
        }
        
        @Override
        public long skip(final long n) throws IOException {
            final byte[] array = new byte[1024];
            long n2;
            int read;
            for (n2 = 0L; n2 < n; n2 += read) {
                read = this.read(array, 0, (int)Math.min(n - n2, array.length));
                if (read < 0) {
                    break;
                }
            }
            return n2;
        }
    }
    
    public static final class Limits
    {
        private int byteCount;
        private int fileCount;
        
        public Limits() {
            this.fileCount = 1024;
            this.byteCount = 1048576;
        }
        
        int getByteCount() {
            return this.byteCount;
        }
        
        int getFileCount() {
            return this.fileCount;
        }
        
        void setByteCount(final int byteCount) {
            if (byteCount < 0) {
                throw new InvalidParameterException("Cache byte-count limit must be >= 0");
            }
            this.byteCount = byteCount;
        }
        
        void setFileCount(final int fileCount) {
            if (fileCount < 0) {
                throw new InvalidParameterException("Cache file count limit must be >= 0");
            }
            this.fileCount = fileCount;
        }
    }
    
    private static final class ModifiedFile implements Comparable<ModifiedFile>
    {
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        private final File file;
        private final long modified;
        
        ModifiedFile(final File file) {
            this.file = file;
            this.modified = file.lastModified();
        }
        
        @Override
        public int compareTo(final ModifiedFile modifiedFile) {
            if (this.getModified() < modifiedFile.getModified()) {
                return -1;
            }
            if (this.getModified() > modifiedFile.getModified()) {
                return 1;
            }
            return this.getFile().compareTo(modifiedFile.getFile());
        }
        
        @Override
        public boolean equals(final Object o) {
            return o instanceof ModifiedFile && this.compareTo((ModifiedFile)o) == 0;
        }
        
        File getFile() {
            return this.file;
        }
        
        long getModified() {
            return this.modified;
        }
        
        @Override
        public int hashCode() {
            return 37 * (1073 + this.file.hashCode()) + (int)(this.modified % 2147483647L);
        }
    }
    
    private interface StreamCloseCallback
    {
        void onClose();
    }
    
    private static final class StreamHeader
    {
        private static final int HEADER_VERSION;
        
        static JSONObject readHeader(final InputStream inputStream) throws IOException {
            if (inputStream.read() != 0) {
                return null;
            }
            int n = 0;
            int n2 = 0;
        Label_0026_Outer:
            while (true) {
                Label_0101: {
                    if (n2 < 3) {
                        break Label_0101;
                    }
                    final byte[] array = new byte[n];
                    int n3 = 0;
                Block_8_Outer:
                    while (true) {
                        Label_0141: {
                            if (n3 < array.length) {
                                break Label_0141;
                            }
                            final JSONTokener jsonTokener = new JSONTokener(new String(array));
                            try {
                                final Object nextValue = jsonTokener.nextValue();
                                if (!(nextValue instanceof JSONObject)) {
                                    Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: expected JSONObject, got " + ((JSONObject)nextValue).getClass().getCanonicalName());
                                    return null;
                                }
                                return (JSONObject)nextValue;
                                // iftrue(Label_0205:, read2 >= 1)
                                while (true) {
                                    Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read stopped at " + (Object)n3 + " when expected " + array.length);
                                    return null;
                                    Label_0124: {
                                        final int read;
                                        n = (n << 8) + (read & 0xFF);
                                    }
                                    ++n2;
                                    continue Label_0026_Outer;
                                    final int read2 = inputStream.read(array, n3, array.length - n3);
                                    continue;
                                }
                                final int read = inputStream.read();
                                // iftrue(Label_0124:, read != -1)
                                Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read returned -1 while reading header size");
                                return null;
                                Label_0205: {
                                    final int read2;
                                    n3 += read2;
                                }
                                continue Block_8_Outer;
                            }
                            catch (JSONException ex) {
                                throw new IOException(ex.getMessage());
                            }
                        }
                        break;
                    }
                }
            }
        }
        
        static void writeHeader(final OutputStream outputStream, final JSONObject jsonObject) throws IOException {
            final byte[] bytes = jsonObject.toString().getBytes();
            outputStream.write(0);
            outputStream.write(0xFF & bytes.length >> 16);
            outputStream.write(0xFF & bytes.length >> 8);
            outputStream.write(0xFF & bytes.length >> 0);
            outputStream.write(bytes);
        }
    }
}
