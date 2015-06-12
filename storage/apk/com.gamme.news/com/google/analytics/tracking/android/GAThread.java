// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import android.content.Context;
import com.google.android.gms.analytics.internal.Command;
import java.util.List;

class GAThread extends Thread implements AnalyticsThread
{
    static final String API_VERSION = "1";
    private static final String CLIENT_VERSION = "ma3.0.2";
    private static final int MAX_SAMPLE_RATE = 100;
    private static final int SAMPLE_RATE_MODULO = 10000;
    private static final int SAMPLE_RATE_MULTIPLIER = 100;
    private static GAThread sInstance;
    private volatile String mClientId;
    private volatile boolean mClosed;
    private volatile List<Command> mCommands;
    private final Context mContext;
    private volatile boolean mDisabled;
    private volatile String mInstallCampaign;
    private volatile ServiceProxy mServiceProxy;
    private final LinkedBlockingQueue<Runnable> queue;
    
    private GAThread(final Context mContext) {
        super("GAThread");
        this.queue = new LinkedBlockingQueue<Runnable>();
        this.mDisabled = false;
        this.mClosed = false;
        if (mContext != null) {
            this.mContext = mContext.getApplicationContext();
        }
        else {
            this.mContext = mContext;
        }
        this.start();
    }
    
    GAThread(final Context mContext, final ServiceProxy mServiceProxy) {
        super("GAThread");
        this.queue = new LinkedBlockingQueue<Runnable>();
        this.mDisabled = false;
        this.mClosed = false;
        if (mContext != null) {
            this.mContext = mContext.getApplicationContext();
        }
        else {
            this.mContext = mContext;
        }
        this.mServiceProxy = mServiceProxy;
        this.start();
    }
    
    private void fillAppParameters(final Map<String, String> map) {
        final AppFieldsDefaultProvider provider = AppFieldsDefaultProvider.getProvider();
        Utils.putIfAbsent(map, "&an", provider.getValue("&an"));
        Utils.putIfAbsent(map, "&av", provider.getValue("&av"));
        Utils.putIfAbsent(map, "&aid", provider.getValue("&aid"));
        Utils.putIfAbsent(map, "&aiid", provider.getValue("&aiid"));
        map.put("&v", "1");
    }
    
    @VisibleForTesting
    static String getAndClearCampaign(final Context context) {
        try {
            final FileInputStream openFileInput = context.openFileInput("gaInstallData");
            final byte[] array = new byte[8192];
            final int read = openFileInput.read(array, 0, 8192);
            if (openFileInput.available() > 0) {
                Log.e("Too much campaign data, ignoring it.");
                openFileInput.close();
                context.deleteFile("gaInstallData");
                return null;
            }
            openFileInput.close();
            context.deleteFile("gaInstallData");
            if (read <= 0) {
                Log.w("Campaign file is empty.");
                return null;
            }
            final String str = new String(array, 0, read);
            Log.i("Campaign found: " + str);
            return str;
        }
        catch (FileNotFoundException ex) {
            Log.i("No campaign data found.");
            return null;
        }
        catch (IOException ex2) {
            Log.e("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
    }
    
    static GAThread getInstance(final Context context) {
        if (GAThread.sInstance == null) {
            GAThread.sInstance = new GAThread(context);
        }
        return GAThread.sInstance;
    }
    
    private String getUrlScheme(final Map<String, String> map) {
        if (!map.containsKey("useSecure")) {
            return "https:";
        }
        if (Utils.safeParseBoolean(map.get("useSecure"), true)) {
            return "https:";
        }
        return "http:";
    }
    
    @VisibleForTesting
    static int hashClientIdForSampling(final String s) {
        int n = 1;
        if (!TextUtils.isEmpty((CharSequence)s)) {
            n = 0;
            for (int i = -1 + s.length(); i >= 0; --i) {
                final char char1 = s.charAt(i);
                n = char1 + (0xFFFFFFF & n << 6) + (char1 << 14);
                final int n2 = n & 0xFE00000;
                if (n2 != 0) {
                    n ^= n2 >> 21;
                }
            }
        }
        return n;
    }
    
    private boolean isSampledOut(final Map<String, String> map) {
        if (map.get("&sf") == null) {
            return false;
        }
        final double safeParseDouble = Utils.safeParseDouble(map.get("&sf"), 100.0);
        if (safeParseDouble >= 100.0) {
            return false;
        }
        if (hashClientIdForSampling(map.get("&cid")) % 10000 >= 100.0 * safeParseDouble) {
            String s;
            if (map.get("&t") == null) {
                s = "unknown";
            }
            else {
                s = map.get("&t");
            }
            Log.v(String.format("%s hit sampled out", s));
            return true;
        }
        return false;
    }
    
    private String printStackTrace(final Throwable t) {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final PrintStream s = new PrintStream(out);
        t.printStackTrace(s);
        s.flush();
        return new String(out.toByteArray());
    }
    
    @Override
    public void clearHits() {
        this.queueToThread(new Runnable() {
            @Override
            public void run() {
                GAThread.this.mServiceProxy.clearHits();
            }
        });
    }
    
    @VisibleForTesting
    void close() {
        this.mClosed = true;
        this.interrupt();
    }
    
    @Override
    public void dispatch() {
        this.queueToThread(new Runnable() {
            @Override
            public void run() {
                GAThread.this.mServiceProxy.dispatch();
            }
        });
    }
    
    @Override
    public LinkedBlockingQueue<Runnable> getQueue() {
        return this.queue;
    }
    
    @Override
    public Thread getThread() {
        return this;
    }
    
    @VisibleForTesting
    protected void init() {
        this.mServiceProxy.createService();
        (this.mCommands = new ArrayList<Command>()).add(new Command("appendVersion", "&_v".substring(1), "ma3.0.2"));
        this.mCommands.add(new Command("appendQueueTime", "&qt".substring(1), null));
        this.mCommands.add(new Command("appendCacheBuster", "&z".substring(1), null));
    }
    
    @VisibleForTesting
    boolean isDisabled() {
        return this.mDisabled;
    }
    
    @VisibleForTesting
    void queueToThread(final Runnable e) {
        this.queue.add(e);
    }
    
    @Override
    public void run() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: ldc2_w          5000
        //     3: invokestatic    java/lang/Thread.sleep:(J)V
        //     6: aload_0        
        //     7: getfield        com/google/analytics/tracking/android/GAThread.mServiceProxy:Lcom/google/analytics/tracking/android/ServiceProxy;
        //    10: ifnonnull       29
        //    13: aload_0        
        //    14: new             Lcom/google/analytics/tracking/android/GAServiceProxy;
        //    17: dup            
        //    18: aload_0        
        //    19: getfield        com/google/analytics/tracking/android/GAThread.mContext:Landroid/content/Context;
        //    22: aload_0        
        //    23: invokespecial   com/google/analytics/tracking/android/GAServiceProxy.<init>:(Landroid/content/Context;Lcom/google/analytics/tracking/android/AnalyticsThread;)V
        //    26: putfield        com/google/analytics/tracking/android/GAThread.mServiceProxy:Lcom/google/analytics/tracking/android/ServiceProxy;
        //    29: aload_0        
        //    30: invokevirtual   com/google/analytics/tracking/android/GAThread.init:()V
        //    33: aload_0        
        //    34: invokestatic    com/google/analytics/tracking/android/ClientIdDefaultProvider.getProvider:()Lcom/google/analytics/tracking/android/ClientIdDefaultProvider;
        //    37: ldc             "&cid"
        //    39: invokevirtual   com/google/analytics/tracking/android/ClientIdDefaultProvider.getValue:(Ljava/lang/String;)Ljava/lang/String;
        //    42: putfield        com/google/analytics/tracking/android/GAThread.mClientId:Ljava/lang/String;
        //    45: aload_0        
        //    46: aload_0        
        //    47: getfield        com/google/analytics/tracking/android/GAThread.mContext:Landroid/content/Context;
        //    50: invokestatic    com/google/analytics/tracking/android/GAThread.getAndClearCampaign:(Landroid/content/Context;)Ljava/lang/String;
        //    53: putfield        com/google/analytics/tracking/android/GAThread.mInstallCampaign:Ljava/lang/String;
        //    56: aload_0        
        //    57: getfield        com/google/analytics/tracking/android/GAThread.mClosed:Z
        //    60: ifne            199
        //    63: aload_0        
        //    64: getfield        com/google/analytics/tracking/android/GAThread.queue:Ljava/util/concurrent/LinkedBlockingQueue;
        //    67: invokevirtual   java/util/concurrent/LinkedBlockingQueue.take:()Ljava/lang/Object;
        //    70: checkcast       Ljava/lang/Runnable;
        //    73: astore          5
        //    75: aload_0        
        //    76: getfield        com/google/analytics/tracking/android/GAThread.mDisabled:Z
        //    79: ifne            56
        //    82: aload           5
        //    84: invokeinterface java/lang/Runnable.run:()V
        //    89: goto            56
        //    92: astore          4
        //    94: aload           4
        //    96: invokevirtual   java/lang/InterruptedException.toString:()Ljava/lang/String;
        //    99: invokestatic    com/google/analytics/tracking/android/Log.i:(Ljava/lang/String;)V
        //   102: goto            56
        //   105: astore_3       
        //   106: new             Ljava/lang/StringBuilder;
        //   109: dup            
        //   110: invokespecial   java/lang/StringBuilder.<init>:()V
        //   113: ldc_w           "Error on GAThread: "
        //   116: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   119: aload_0        
        //   120: aload_3        
        //   121: invokespecial   com/google/analytics/tracking/android/GAThread.printStackTrace:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   124: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   127: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   130: invokestatic    com/google/analytics/tracking/android/Log.e:(Ljava/lang/String;)V
        //   133: ldc_w           "Google Analytics is shutting down."
        //   136: invokestatic    com/google/analytics/tracking/android/Log.e:(Ljava/lang/String;)V
        //   139: aload_0        
        //   140: iconst_1       
        //   141: putfield        com/google/analytics/tracking/android/GAThread.mDisabled:Z
        //   144: goto            56
        //   147: astore_1       
        //   148: ldc_w           "sleep interrupted in GAThread initialize"
        //   151: invokestatic    com/google/analytics/tracking/android/Log.w:(Ljava/lang/String;)V
        //   154: goto            6
        //   157: astore_2       
        //   158: new             Ljava/lang/StringBuilder;
        //   161: dup            
        //   162: invokespecial   java/lang/StringBuilder.<init>:()V
        //   165: ldc_w           "Error initializing the GAThread: "
        //   168: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   171: aload_0        
        //   172: aload_2        
        //   173: invokespecial   com/google/analytics/tracking/android/GAThread.printStackTrace:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   176: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   179: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   182: invokestatic    com/google/analytics/tracking/android/Log.e:(Ljava/lang/String;)V
        //   185: ldc_w           "Google Analytics will not start up."
        //   188: invokestatic    com/google/analytics/tracking/android/Log.e:(Ljava/lang/String;)V
        //   191: aload_0        
        //   192: iconst_1       
        //   193: putfield        com/google/analytics/tracking/android/GAThread.mDisabled:Z
        //   196: goto            56
        //   199: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  0      6      147    157    Ljava/lang/InterruptedException;
        //  6      29     157    199    Ljava/lang/Throwable;
        //  29     56     157    199    Ljava/lang/Throwable;
        //  63     89     92     105    Ljava/lang/InterruptedException;
        //  63     89     105    147    Ljava/lang/Throwable;
        //  94     102    105    147    Ljava/lang/Throwable;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0006:
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
    public void sendHit(final Map<String, String> m) {
        final HashMap<String, String> hashMap = new HashMap<String, String>(m);
        String s = m.get("&ht");
        while (true) {
            if (s == null) {
                break Label_0034;
            }
            try {
                Long.valueOf(s);
                if (s == null) {
                    hashMap.put("&ht", Long.toString(System.currentTimeMillis()));
                }
                this.queueToThread(new Runnable() {
                    @Override
                    public void run() {
                        if (TextUtils.isEmpty((CharSequence)hashMap.get("&cid"))) {
                            hashMap.put("&cid", GAThread.this.mClientId);
                        }
                        if (GoogleAnalytics.getInstance(GAThread.this.mContext).getAppOptOut() || GAThread.this.isSampledOut(hashMap)) {
                            return;
                        }
                        if (!TextUtils.isEmpty((CharSequence)GAThread.this.mInstallCampaign)) {
                            GAUsage.getInstance().setDisableUsage(true);
                            hashMap.putAll(new MapBuilder().setCampaignParamsFromUrl(GAThread.this.mInstallCampaign).build());
                            GAUsage.getInstance().setDisableUsage(false);
                            GAThread.this.mInstallCampaign = null;
                        }
                        GAThread.this.fillAppParameters(hashMap);
                        GAThread.this.mServiceProxy.putHit(HitBuilder.generateHitParams(hashMap), Long.valueOf(hashMap.get("&ht")), GAThread.this.getUrlScheme(hashMap), GAThread.this.mCommands);
                    }
                });
            }
            catch (NumberFormatException ex) {
                s = null;
                continue;
            }
            break;
        }
    }
    
    @Override
    public void setForceLocalDispatch() {
        this.queueToThread(new Runnable() {
            @Override
            public void run() {
                GAThread.this.mServiceProxy.setForceLocalDispatch();
            }
        });
    }
}
