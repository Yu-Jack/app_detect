// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Map;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import android.text.TextUtils;
import android.content.Context;
import com.google.android.gms.internal.ef;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

class bc extends Thread implements aj
{
    private static bc g;
    private final LinkedBlockingQueue<Runnable> a;
    private volatile boolean b;
    private volatile boolean c;
    private volatile List<ef> d;
    private volatile String e;
    private volatile String f;
    private volatile w h;
    private final Context i;
    
    private bc(final Context i) {
        super("GAThread");
        this.a = new LinkedBlockingQueue<Runnable>();
        this.b = false;
        this.c = false;
        if (i != null) {
            this.i = i.getApplicationContext();
        }
        else {
            this.i = i;
        }
        this.start();
    }
    
    static int a(final String s) {
        int n = 1;
        if (!TextUtils.isEmpty((CharSequence)s)) {
            final int n2 = -1 + s.length();
            n = 0;
            for (int i = n2; i >= 0; --i) {
                final char char1 = s.charAt(i);
                n = char1 + (0xFFFFFFF & n << 6) + (char1 << 14);
                final int n3 = 0xFE00000 & n;
                if (n3 != 0) {
                    n ^= n3 >> 21;
                }
            }
        }
        return n;
    }
    
    static bc a(final Context context) {
        if (bc.g == null) {
            bc.g = new bc(context);
        }
        return bc.g;
    }
    
    private String a(final Throwable t) {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final PrintStream s = new PrintStream(out);
        t.printStackTrace(s);
        s.flush();
        return new String(out.toByteArray());
    }
    
    static String b(final Context context) {
        try {
            final FileInputStream openFileInput = context.openFileInput("gaInstallData");
            final int read = openFileInput.read(new byte[8192], 0, 8192);
            if (openFileInput.available() > 0) {
                p.a("Too much campaign data, ignoring it.");
                openFileInput.close();
                context.deleteFile("gaInstallData");
                return null;
            }
            openFileInput.close();
            context.deleteFile("gaInstallData");
            if (read <= 0) {
                p.d("Campaign file is empty.");
                return null;
            }
            goto Label_0087;
        }
        catch (FileNotFoundException ex) {
            p.b("No campaign data found.");
            return null;
        }
        catch (IOException ex2) {
            p.a("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
    }
    
    private String b(final Map<String, String> map) {
        if (!map.containsKey("useSecure")) {
            return "https:";
        }
        if (ab.a(map.get("useSecure"), true)) {
            return "https:";
        }
        return "http:";
    }
    
    private boolean c(final Map<String, String> map) {
        if (map.get("&sf") == null) {
            return false;
        }
        final double a = ab.a(map.get("&sf"), 100.0);
        if (a >= 100.0) {
            return false;
        }
        if (a(map.get("&cid")) % 10000 >= a * 100.0) {
            String s;
            if (map.get("&t") == null) {
                s = "unknown";
            }
            else {
                s = map.get("&t");
            }
            p.c(String.format("%s hit sampled out", s));
            return true;
        }
        return false;
    }
    
    private void d(final Map<String, String> map) {
        final ar a = o.a(this.i);
        ab.a(map, "&adid", a.a("&adid"));
        ab.a(map, "&ate", a.a("&ate"));
    }
    
    private void e(final Map<String, String> map) {
        final ak a = ak.a();
        ab.a(map, "&an", a.a("&an"));
        ab.a(map, "&av", a.a("&av"));
        ab.a(map, "&aid", a.a("&aid"));
        ab.a(map, "&aiid", a.a("&aiid"));
        map.put("&v", "1");
    }
    
    @Override
    public void a() {
        this.a(new Runnable() {
            @Override
            public void run() {
                bc.this.h.b();
            }
        });
    }
    
    void a(final Runnable e) {
        this.a.add(e);
    }
    
    @Override
    public void a(final Map<String, String> m) {
        final HashMap<String, String> hashMap = new HashMap<String, String>(m);
        String s = m.get("&ht");
        while (true) {
            if (s == null) {
                break Label_0031;
            }
            try {
                Long.valueOf(s);
                if (s == null) {
                    hashMap.put("&ht", Long.toString(System.currentTimeMillis()));
                }
                this.a(new Runnable() {
                    @Override
                    public void run() {
                        if (TextUtils.isEmpty((CharSequence)hashMap.get("&cid"))) {
                            hashMap.put("&cid", bc.this.f);
                        }
                        if (com.google.android.gms.analytics.c.a(bc.this.i).c() || bc.this.c(hashMap)) {
                            return;
                        }
                        if (!TextUtils.isEmpty((CharSequence)bc.this.e)) {
                            bd.a().a(true);
                            hashMap.putAll(new h<h>().d(bc.this.e).a());
                            bd.a().a(false);
                            bc.this.e = null;
                        }
                        bc.this.e(hashMap);
                        bc.this.d(hashMap);
                        bc.this.h.a(bj.a(hashMap), Long.valueOf(hashMap.get("&ht")), bc.this.b(hashMap), bc.this.d);
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
    public void b() {
        this.a(new Runnable() {
            @Override
            public void run() {
                bc.this.h.a();
            }
        });
    }
    
    @Override
    public LinkedBlockingQueue<Runnable> c() {
        return this.a;
    }
    
    @Override
    public Thread d() {
        return this;
    }
    
    protected void e() {
        this.h.c();
        (this.d = new ArrayList<ef>()).add(new ef("appendVersion", "&_v".substring(1), "ma4.0.1"));
        this.d.add(new ef("appendQueueTime", "&qt".substring(1), null));
        this.d.add(new ef("appendCacheBuster", "&z".substring(1), null));
    }
    
    @Override
    public void run() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: bipush          10
        //     2: invokestatic    android/os/Process.setThreadPriority:(I)V
        //     5: ldc2_w          5000
        //     8: invokestatic    java/lang/Thread.sleep:(J)V
        //    11: aload_0        
        //    12: getfield        com/google/android/gms/analytics/bc.h:Lcom/google/android/gms/analytics/w;
        //    15: ifnonnull       34
        //    18: aload_0        
        //    19: new             Lcom/google/android/gms/analytics/aw;
        //    22: dup            
        //    23: aload_0        
        //    24: getfield        com/google/android/gms/analytics/bc.i:Landroid/content/Context;
        //    27: aload_0        
        //    28: invokespecial   com/google/android/gms/analytics/aw.<init>:(Landroid/content/Context;Lcom/google/android/gms/analytics/aj;)V
        //    31: putfield        com/google/android/gms/analytics/bc.h:Lcom/google/android/gms/analytics/w;
        //    34: aload_0        
        //    35: invokevirtual   com/google/android/gms/analytics/bc.e:()V
        //    38: aload_0        
        //    39: invokestatic    com/google/android/gms/analytics/al.a:()Lcom/google/android/gms/analytics/al;
        //    42: ldc             "&cid"
        //    44: invokevirtual   com/google/android/gms/analytics/al.a:(Ljava/lang/String;)Ljava/lang/String;
        //    47: putfield        com/google/android/gms/analytics/bc.f:Ljava/lang/String;
        //    50: aload_0        
        //    51: getfield        com/google/android/gms/analytics/bc.f:Ljava/lang/String;
        //    54: ifnonnull       62
        //    57: aload_0        
        //    58: iconst_1       
        //    59: putfield        com/google/android/gms/analytics/bc.b:Z
        //    62: aload_0        
        //    63: aload_0        
        //    64: getfield        com/google/android/gms/analytics/bc.i:Landroid/content/Context;
        //    67: invokestatic    com/google/android/gms/analytics/bc.b:(Landroid/content/Context;)Ljava/lang/String;
        //    70: putfield        com/google/android/gms/analytics/bc.e:Ljava/lang/String;
        //    73: ldc_w           "Initialized GA Thread"
        //    76: invokestatic    com/google/android/gms/analytics/p.c:(Ljava/lang/String;)V
        //    79: aload_0        
        //    80: getfield        com/google/android/gms/analytics/bc.c:Z
        //    83: ifne            222
        //    86: aload_0        
        //    87: getfield        com/google/android/gms/analytics/bc.a:Ljava/util/concurrent/LinkedBlockingQueue;
        //    90: invokevirtual   java/util/concurrent/LinkedBlockingQueue.take:()Ljava/lang/Object;
        //    93: checkcast       Ljava/lang/Runnable;
        //    96: astore          5
        //    98: aload_0        
        //    99: getfield        com/google/android/gms/analytics/bc.b:Z
        //   102: ifne            79
        //   105: aload           5
        //   107: invokeinterface java/lang/Runnable.run:()V
        //   112: goto            79
        //   115: astore          4
        //   117: aload           4
        //   119: invokevirtual   java/lang/InterruptedException.toString:()Ljava/lang/String;
        //   122: invokestatic    com/google/android/gms/analytics/p.b:(Ljava/lang/String;)V
        //   125: goto            79
        //   128: astore_3       
        //   129: new             Ljava/lang/StringBuilder;
        //   132: dup            
        //   133: invokespecial   java/lang/StringBuilder.<init>:()V
        //   136: ldc_w           "Error on GAThread: "
        //   139: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   142: aload_0        
        //   143: aload_3        
        //   144: invokespecial   com/google/android/gms/analytics/bc.a:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   147: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   150: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   153: invokestatic    com/google/android/gms/analytics/p.a:(Ljava/lang/String;)V
        //   156: ldc_w           "Google Analytics is shutting down."
        //   159: invokestatic    com/google/android/gms/analytics/p.a:(Ljava/lang/String;)V
        //   162: aload_0        
        //   163: iconst_1       
        //   164: putfield        com/google/android/gms/analytics/bc.b:Z
        //   167: goto            79
        //   170: astore_1       
        //   171: ldc_w           "sleep interrupted in GAThread initialize"
        //   174: invokestatic    com/google/android/gms/analytics/p.d:(Ljava/lang/String;)V
        //   177: goto            11
        //   180: astore_2       
        //   181: new             Ljava/lang/StringBuilder;
        //   184: dup            
        //   185: invokespecial   java/lang/StringBuilder.<init>:()V
        //   188: ldc_w           "Error initializing the GAThread: "
        //   191: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   194: aload_0        
        //   195: aload_2        
        //   196: invokespecial   com/google/android/gms/analytics/bc.a:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   199: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   202: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   205: invokestatic    com/google/android/gms/analytics/p.a:(Ljava/lang/String;)V
        //   208: ldc_w           "Google Analytics will not start up."
        //   211: invokestatic    com/google/android/gms/analytics/p.a:(Ljava/lang/String;)V
        //   214: aload_0        
        //   215: iconst_1       
        //   216: putfield        com/google/android/gms/analytics/bc.b:Z
        //   219: goto            79
        //   222: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  5      11     170    180    Ljava/lang/InterruptedException;
        //  11     34     180    222    Ljava/lang/Throwable;
        //  34     62     180    222    Ljava/lang/Throwable;
        //  62     79     180    222    Ljava/lang/Throwable;
        //  86     112    115    128    Ljava/lang/InterruptedException;
        //  86     112    128    170    Ljava/lang/Throwable;
        //  117    125    128    170    Ljava/lang/Throwable;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0011:
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
