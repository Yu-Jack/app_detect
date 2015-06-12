// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import java.util.List;
import com.facebook.b.a;
import org.json.JSONException;
import org.json.JSONArray;
import java.util.Iterator;
import com.facebook.b.v;
import android.os.Bundle;
import com.facebook.c.c;
import com.facebook.b.aj;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import android.content.Context;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.Map;

public class d
{
    private static final String a;
    private static Map d;
    private static ScheduledThreadPoolExecutor e;
    private static g f;
    private static boolean g;
    private static Context h;
    private static Object i;
    private static String j;
    private final Context b;
    private final e c;
    
    static {
        a = d.class.getCanonicalName();
        com.facebook.d.d = new ConcurrentHashMap();
        com.facebook.d.f = com.facebook.g.a;
        com.facebook.d.i = new Object();
    }
    
    private d(final Context p0, final String p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: invokespecial   java/lang/Object.<init>:()V
        //     4: aload_1        
        //     5: ldc             "context"
        //     7: invokestatic    com/facebook/b/al.a:(Ljava/lang/Object;Ljava/lang/String;)V
        //    10: aload_0        
        //    11: aload_1        
        //    12: putfield        com/facebook/d.b:Landroid/content/Context;
        //    15: invokestatic    com/facebook/bc.f:()Lcom/facebook/bc;
        //    18: astore_3       
        //    19: aload_3        
        //    20: ifnull          106
        //    23: aload_2        
        //    24: ifnull          38
        //    27: aload_2        
        //    28: aload_3        
        //    29: invokevirtual   com/facebook/bc.c:()Ljava/lang/String;
        //    32: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    35: ifeq            106
        //    38: aload_0        
        //    39: new             Lcom/facebook/e;
        //    42: dup            
        //    43: aload_3        
        //    44: invokespecial   com/facebook/e.<init>:(Lcom/facebook/bc;)V
        //    47: putfield        com/facebook/d.c:Lcom/facebook/e;
        //    50: getstatic       com/facebook/d.i:Ljava/lang/Object;
        //    53: astore          4
        //    55: aload           4
        //    57: monitorenter   
        //    58: getstatic       com/facebook/d.j:Ljava/lang/String;
        //    61: ifnonnull       72
        //    64: aload_1        
        //    65: aload_2        
        //    66: invokestatic    com/facebook/b/aj.a:(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
        //    69: putstatic       com/facebook/d.j:Ljava/lang/String;
        //    72: getstatic       com/facebook/d.h:Landroid/content/Context;
        //    75: ifnonnull       85
        //    78: aload_1        
        //    79: invokevirtual   android/content/Context.getApplicationContext:()Landroid/content/Context;
        //    82: putstatic       com/facebook/d.h:Landroid/content/Context;
        //    85: aload           4
        //    87: monitorexit    
        //    88: getstatic       com/facebook/d.i:Ljava/lang/Object;
        //    91: astore          6
        //    93: aload           6
        //    95: monitorenter   
        //    96: getstatic       com/facebook/d.e:Ljava/util/concurrent/ScheduledThreadPoolExecutor;
        //    99: ifnull          139
        //   102: aload           6
        //   104: monitorexit    
        //   105: return         
        //   106: aload_2        
        //   107: ifnonnull       115
        //   110: aload_1        
        //   111: invokestatic    com/facebook/b/aj.a:(Landroid/content/Context;)Ljava/lang/String;
        //   114: astore_2       
        //   115: aload_0        
        //   116: new             Lcom/facebook/e;
        //   119: dup            
        //   120: aconst_null    
        //   121: aload_2        
        //   122: invokespecial   com/facebook/e.<init>:(Ljava/lang/String;Ljava/lang/String;)V
        //   125: putfield        com/facebook/d.c:Lcom/facebook/e;
        //   128: goto            50
        //   131: astore          5
        //   133: aload           4
        //   135: monitorexit    
        //   136: aload           5
        //   138: athrow         
        //   139: new             Ljava/util/concurrent/ScheduledThreadPoolExecutor;
        //   142: dup            
        //   143: iconst_1       
        //   144: invokespecial   java/util/concurrent/ScheduledThreadPoolExecutor.<init>:(I)V
        //   147: putstatic       com/facebook/d.e:Ljava/util/concurrent/ScheduledThreadPoolExecutor;
        //   150: aload           6
        //   152: monitorexit    
        //   153: new             Lcom/facebook/d$1;
        //   156: dup            
        //   157: invokespecial   com/facebook/d$1.<init>:()V
        //   160: astore          8
        //   162: getstatic       com/facebook/d.e:Ljava/util/concurrent/ScheduledThreadPoolExecutor;
        //   165: aload           8
        //   167: lconst_0       
        //   168: ldc2_w          60
        //   171: getstatic       java/util/concurrent/TimeUnit.SECONDS:Ljava/util/concurrent/TimeUnit;
        //   174: invokevirtual   java/util/concurrent/ScheduledThreadPoolExecutor.scheduleAtFixedRate:(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
        //   177: pop            
        //   178: new             Lcom/facebook/d$2;
        //   181: dup            
        //   182: invokespecial   com/facebook/d$2.<init>:()V
        //   185: astore          10
        //   187: getstatic       com/facebook/d.e:Ljava/util/concurrent/ScheduledThreadPoolExecutor;
        //   190: aload           10
        //   192: lconst_0       
        //   193: ldc2_w          86400
        //   196: getstatic       java/util/concurrent/TimeUnit.SECONDS:Ljava/util/concurrent/TimeUnit;
        //   199: invokevirtual   java/util/concurrent/ScheduledThreadPoolExecutor.scheduleAtFixedRate:(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
        //   202: pop            
        //   203: return         
        //   204: astore          7
        //   206: aload           6
        //   208: monitorexit    
        //   209: aload           7
        //   211: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  58     72     131    139    Any
        //  72     85     131    139    Any
        //  85     88     131    139    Any
        //  96     105    204    212    Any
        //  139    153    204    212    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0106:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:692)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:529)
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
    
    public static d a(final Context context) {
        return new d(context, null);
    }
    
    public static d a(final Context context, final String s) {
        return new d(context, s);
    }
    
    public static g a() {
        synchronized (com.facebook.d.i) {
            return com.facebook.d.f;
        }
    }
    
    private static j a(final h h, final Set set) {
        final j j = new j((byte)0);
        final boolean a = bq.a(com.facebook.d.h);
        final ArrayList<Request> list = new ArrayList<Request>();
        for (final e e : set) {
            final l a2 = a(e);
            if (a2 != null) {
                final String b = e.b();
                final com.facebook.b.ak a3 = aj.a(b, false);
                final Request a4 = Request.a(String.format("%s/activities", b), null);
                Bundle b2 = a4.b();
                if (b2 == null) {
                    b2 = new Bundle();
                }
                b2.putString("access_token", e.a());
                a4.a(b2);
                final int a5 = a2.a(a4, a3.b(), a3.a(), a);
                Request request;
                if (a5 == 0) {
                    request = null;
                }
                else {
                    j.a += a5;
                    a4.a(new aq() {
                        private final /* synthetic */ e a;
                        
                        @Override
                        public final void a(final bb bb) {
                            com.facebook.d.a(this.a, a4, bb, a2, j);
                        }
                    });
                    request = a4;
                }
                if (request == null) {
                    continue;
                }
                list.add(request);
            }
        }
        if (list.size() > 0) {
            v.a(ak.e, com.facebook.d.a, "Flushing %d events due to %s.", j.a, h.toString());
            final Iterator<Object> iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().f();
            }
            return j;
        }
        return null;
    }
    
    private static l a(final e e) {
        synchronized (com.facebook.d.i) {
            return com.facebook.d.d.get(e);
        }
    }
    
    static /* synthetic */ void a(final e e, final Request request, final bb bb, final l l, final j j) {
        final ae a = bb.a();
        final i a2 = com.facebook.i.a;
        while (true) {
            while (true) {
                Label_0039: {
                    if (a == null) {
                        final String s = "Success";
                        final i b = a2;
                        break Label_0039;
                    }
                    if (a.b() == -1) {
                        final i c = com.facebook.i.c;
                        final String s = "Failed: No Connectivity";
                        final i b = c;
                        break Label_0039;
                    }
                    Label_0184: {
                        break Label_0184;
                    Label_0135_Outer:
                        while (true) {
                            final String s2 = (String)request.e();
                            while (true) {
                            Label_0243:
                                while (true) {
                                    try {
                                        final String string = new JSONArray(s2).toString(2);
                                        final String s;
                                        v.a(ak.e, com.facebook.d.a, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", request.a().toString(), s, string);
                                        if (a != null) {
                                            final boolean b2 = true;
                                            l.a(b2);
                                            final i b;
                                            if (b == com.facebook.i.c) {
                                                k.a(com.facebook.d.h, e, l);
                                            }
                                            if (b != com.facebook.i.a && j.b != com.facebook.i.c) {
                                                j.b = b;
                                            }
                                            return;
                                        }
                                        break Label_0243;
                                        final String format = String.format("Failed:\n  Response: %s\n  Error %s", bb.toString(), a.toString());
                                        final i b3 = com.facebook.i.b;
                                        s = format;
                                        final i b = b3;
                                        break;
                                    }
                                    catch (JSONException ex) {
                                        final String string = "<Can't encode events for debug logging>";
                                        continue Label_0135_Outer;
                                    }
                                    break;
                                }
                                final boolean b2 = false;
                                continue;
                            }
                        }
                    }
                }
                if (bq.a(ak.e)) {
                    continue;
                }
                break;
            }
            continue;
        }
    }
    
    static /* synthetic */ void a(final h p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: getstatic       com/facebook/d.i:Ljava/lang/Object;
        //     3: astore_1       
        //     4: aload_1        
        //     5: monitorenter   
        //     6: getstatic       com/facebook/d.g:Z
        //     9: ifeq            15
        //    12: aload_1        
        //    13: monitorexit    
        //    14: return         
        //    15: iconst_1       
        //    16: putstatic       com/facebook/d.g:Z
        //    19: new             Ljava/util/HashSet;
        //    22: dup            
        //    23: getstatic       com/facebook/d.d:Ljava/util/Map;
        //    26: invokeinterface java/util/Map.keySet:()Ljava/util/Set;
        //    31: invokespecial   java/util/HashSet.<init>:(Ljava/util/Collection;)V
        //    34: astore_3       
        //    35: aload_1        
        //    36: monitorexit    
        //    37: invokestatic    com/facebook/d.i:()I
        //    40: pop            
        //    41: aload_0        
        //    42: aload_3        
        //    43: invokestatic    com/facebook/d.a:(Lcom/facebook/h;Ljava/util/Set;)Lcom/facebook/j;
        //    46: astore          14
        //    48: aload           14
        //    50: astore          7
        //    52: getstatic       com/facebook/d.i:Ljava/lang/Object;
        //    55: astore          8
        //    57: aload           8
        //    59: monitorenter   
        //    60: iconst_0       
        //    61: putstatic       com/facebook/d.g:Z
        //    64: aload           8
        //    66: monitorexit    
        //    67: aload           7
        //    69: ifnull          174
        //    72: new             Landroid/content/Intent;
        //    75: dup            
        //    76: ldc_w           "com.facebook.sdk.APP_EVENTS_FLUSHED"
        //    79: invokespecial   android/content/Intent.<init>:(Ljava/lang/String;)V
        //    82: astore          10
        //    84: aload           10
        //    86: ldc_w           "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED"
        //    89: aload           7
        //    91: getfield        com/facebook/j.a:I
        //    94: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;I)Landroid/content/Intent;
        //    97: pop            
        //    98: aload           10
        //   100: ldc_w           "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT"
        //   103: aload           7
        //   105: getfield        com/facebook/j.b:Lcom/facebook/i;
        //   108: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
        //   111: pop            
        //   112: getstatic       com/facebook/d.h:Landroid/content/Context;
        //   115: invokestatic    android/support/v4/content/e.a:(Landroid/content/Context;)Landroid/support/v4/content/e;
        //   118: aload           10
        //   120: invokevirtual   android/support/v4/content/e.a:(Landroid/content/Intent;)Z
        //   123: pop            
        //   124: return         
        //   125: astore_2       
        //   126: aload_1        
        //   127: monitorexit    
        //   128: aload_2        
        //   129: athrow         
        //   130: astore          5
        //   132: getstatic       com/facebook/d.a:Ljava/lang/String;
        //   135: new             Ljava/lang/StringBuilder;
        //   138: dup            
        //   139: ldc_w           "Caught unexpected exception while flushing: "
        //   142: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   145: aload           5
        //   147: invokevirtual   java/lang/Exception.toString:()Ljava/lang/String;
        //   150: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   153: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   156: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   159: pop            
        //   160: aconst_null    
        //   161: astore          7
        //   163: goto            52
        //   166: astore          9
        //   168: aload           8
        //   170: monitorexit    
        //   171: aload           9
        //   173: athrow         
        //   174: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  6      14     125    130    Any
        //  15     37     125    130    Any
        //  41     48     130    166    Ljava/lang/Exception;
        //  60     67     166    174    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 86, Size: 86
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
    
    private void a(final String s, final Bundle bundle, final boolean b) {
        bq.b().execute(new Runnable() {
            private final /* synthetic */ Context a;
            private final /* synthetic */ e b = com.facebook.d.this.c;
            private final /* synthetic */ f c = new f(com.facebook.d.this.b, s, bundle, b);
            
            @Override
            public final void run() {
                b(this.a, this.b).a(this.c);
                com.facebook.d.g();
            }
        });
    }
    
    private static l b(final Context context, final e e) {
        final l l = com.facebook.d.d.get(e);
        a a = null;
        if (l == null) {
            a = com.facebook.b.a.a(context);
        }
        synchronized (com.facebook.d.i) {
            l i = com.facebook.d.d.get(e);
            if (i == null) {
                i = new l(a, context.getPackageName(), com.facebook.d.j);
                com.facebook.d.d.put(e, i);
            }
            return i;
        }
    }
    
    static /* synthetic */ void g() {
        synchronized (com.facebook.d.i) {
            if (a() != com.facebook.g.b && h() > 100) {
                bq.b().execute(new Runnable() {
                    private final /* synthetic */ h a;
                    
                    @Override
                    public final void run() {
                        com.facebook.d.a(this.a);
                    }
                });
            }
        }
    }
    
    private static int h() {
        synchronized (com.facebook.d.i) {
            final Iterator<l> iterator = com.facebook.d.d.values().iterator();
            int n = 0;
            while (iterator.hasNext()) {
                n += iterator.next().a();
            }
            return n;
        }
    }
    
    private static int i() {
        final k a = k.a(com.facebook.d.h);
        final Iterator iterator = a.a().iterator();
        int n = 0;
        while (iterator.hasNext()) {
            final e e = iterator.next();
            final l b = b(com.facebook.d.h, e);
            final List a2 = a.a(e);
            b.a(a2);
            n += a2.size();
        }
        return n;
    }
    
    public final void a(final String s, final Bundle bundle) {
        this.a(s, bundle, false);
    }
    
    public final String b() {
        return this.c.b();
    }
    
    public final void b(final String s, final Bundle bundle) {
        this.a(s, bundle, true);
    }
}
