// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.webkit.WebView;
import android.os.SystemClock;
import org.json.JSONException;
import android.text.TextUtils;
import android.content.Context;

public class cy extends ed implements de, et
{
    private final bb a;
    private final cw b;
    private final ep c;
    private final Object d;
    private final Context e;
    private final Object f;
    private final dj g;
    private final kw h;
    private ed i;
    private cz j;
    private boolean k;
    private aq l;
    private as m;
    private ax n;
    
    public cy(final Context e, final dj g, final kw h, final ep c, final bb a, final cw b) {
        this.d = new Object();
        this.f = new Object();
        this.k = false;
        this.a = a;
        this.b = b;
        this.c = c;
        this.e = e;
        this.g = g;
        this.h = h;
    }
    
    private ak a(final cx cx) {
        if (this.j.m == null) {
            throw new da("The ad response must specify one of the supported ad sizes.", 0);
        }
        final String[] split = this.j.m.split("x");
        if (split.length != 2) {
            throw new da("Could not parse the ad size from the ad response: " + this.j.m, 0);
        }
        while (true) {
            int int1;
            int int2;
            ak[] h;
            int length;
            int n = 0;
            ak ak = null;
            float density;
            int f;
            int c;
            Label_0157_Outer:Label_0179_Outer:
            while (true) {
            Label_0265:
                while (true) {
                Label_0255:
                    while (true) {
                        try {
                            int1 = Integer.parseInt(split[0]);
                            int2 = Integer.parseInt(split[1]);
                            h = cx.d.h;
                            length = h.length;
                            n = 0;
                            if (n >= length) {
                                break;
                            }
                            ak = h[n];
                            density = this.e.getResources().getDisplayMetrics().density;
                            if (ak.f == -1) {
                                f = (int)(ak.g / density);
                                if (ak.c != -2) {
                                    break Label_0255;
                                }
                                c = (int)(ak.d / density);
                                if (int1 == f && int2 == c) {
                                    return new ak(ak, cx.d.h);
                                }
                                break Label_0265;
                            }
                        }
                        catch (NumberFormatException ex) {
                            throw new da("Could not parse the ad size from the ad response: " + this.j.m, 0);
                        }
                        f = ak.f;
                        continue Label_0179_Outer;
                    }
                    c = ak.c;
                    continue;
                }
                ++n;
                continue Label_0157_Outer;
            }
        }
        throw new da("The ad size from the ad response was not one of the requested sizes: " + this.j.m, 0);
    }
    
    private void a(final cx cx, final long n) {
        synchronized (this.d) {
            this.l = new aq(this.e, cx, this.a, this.m);
            // monitorexit(this.d)
            this.n = this.l.a(n, 60000L);
            switch (this.n.a) {
                default: {
                    throw new da("Unexpected mediation result: " + this.n.a, 0);
                }
                case 1: {
                    break;
                }
                case 0: {
                    return;
                }
            }
        }
        throw new da("No fill from any mediation ad networks.", 3);
    }
    
    private void b(final long n) {
        em.a.post((Runnable)new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (cy.this.f) {
                        if (cy.this.j.e != -2) {
                            return;
                        }
                        cy.this.c.f().a(cy.this);
                        if (cy.this.j.e == -3) {
                            en.d("Loading URL in WebView: " + cy.this.j.b);
                            cy.this.c.loadUrl(cy.this.j.b);
                            return;
                        }
                    }
                    en.d("Loading HTML in WebView.");
                    cy.this.c.loadDataWithBaseURL(eg.a(cy.this.j.b), cy.this.j.c, "text/html", "UTF-8", (String)null);
                }
            }
        });
        this.d(n);
    }
    
    private void c() {
        if (this.j.e != -3) {
            if (TextUtils.isEmpty((CharSequence)this.j.c)) {
                throw new da("No fill from ad server.", 3);
            }
            if (this.j.h) {
                try {
                    this.m = new as(this.j.c);
                }
                catch (JSONException ex) {
                    throw new da("Could not parse mediation config: " + this.j.c, 0);
                }
            }
        }
    }
    
    private void c(final long n) {
        while (this.e(n)) {
            if (this.j != null) {
                synchronized (this.d) {
                    this.i = null;
                    // monitorexit(this.d)
                    if (this.j.e != -2 && this.j.e != -3) {
                        throw new da("There was a problem getting an ad response. ErrorCode: " + this.j.e, this.j.e);
                    }
                }
                return;
            }
        }
        throw new da("Timed out waiting for ad response.", 2);
    }
    
    private void d(final long n) {
        while (this.e(n)) {
            if (this.k) {
                return;
            }
        }
        throw new da("Timed out waiting for WebView to finish loading.", 2);
    }
    
    private boolean e(final long n) {
        final long n2 = 60000L - (SystemClock.elapsedRealtime() - n);
        if (n2 <= 0L) {
            return false;
        }
        try {
            this.f.wait(n2);
            return true;
        }
        catch (InterruptedException ex) {
            throw new da("Ad request cancelled.", -1);
        }
    }
    
    @Override
    public void a() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/google/android/gms/internal/cy.f:Ljava/lang/Object;
        //     4: astore_1       
        //     5: aload_1        
        //     6: monitorenter   
        //     7: ldc             "AdLoaderBackgroundTask started."
        //     9: invokestatic    com/google/android/gms/internal/en.a:(Ljava/lang/String;)V
        //    12: aload_0        
        //    13: getfield        com/google/android/gms/internal/cy.h:Lcom/google/android/gms/internal/kw;
        //    16: invokevirtual   com/google/android/gms/internal/kw.a:()Lcom/google/android/gms/internal/ir;
        //    19: aload_0        
        //    20: getfield        com/google/android/gms/internal/cy.e:Landroid/content/Context;
        //    23: invokeinterface com/google/android/gms/internal/ir.a:(Landroid/content/Context;)Ljava/lang/String;
        //    28: astore_3       
        //    29: new             Lcom/google/android/gms/internal/cx;
        //    32: dup            
        //    33: aload_0        
        //    34: getfield        com/google/android/gms/internal/cy.g:Lcom/google/android/gms/internal/dj;
        //    37: aload_3        
        //    38: invokespecial   com/google/android/gms/internal/cx.<init>:(Lcom/google/android/gms/internal/dj;Ljava/lang/String;)V
        //    41: astore          4
        //    43: aconst_null    
        //    44: astore          5
        //    46: bipush          -2
        //    48: istore          6
        //    50: ldc2_w          -1
        //    53: lstore          7
        //    55: invokestatic    android/os/SystemClock.elapsedRealtime:()J
        //    58: lstore          35
        //    60: aload_0        
        //    61: getfield        com/google/android/gms/internal/cy.e:Landroid/content/Context;
        //    64: aload           4
        //    66: aload_0        
        //    67: invokestatic    com/google/android/gms/internal/dd.a:(Landroid/content/Context;Lcom/google/android/gms/internal/cx;Lcom/google/android/gms/internal/de;)Lcom/google/android/gms/internal/ed;
        //    70: astore          37
        //    72: aload_0        
        //    73: getfield        com/google/android/gms/internal/cy.d:Ljava/lang/Object;
        //    76: astore          38
        //    78: aload           38
        //    80: monitorenter   
        //    81: aload_0        
        //    82: aload           37
        //    84: putfield        com/google/android/gms/internal/cy.i:Lcom/google/android/gms/internal/ed;
        //    87: aload_0        
        //    88: getfield        com/google/android/gms/internal/cy.i:Lcom/google/android/gms/internal/ed;
        //    91: ifnonnull       460
        //    94: new             Lcom/google/android/gms/internal/da;
        //    97: dup            
        //    98: ldc_w           "Could not start the ad request service."
        //   101: iconst_0       
        //   102: invokespecial   com/google/android/gms/internal/da.<init>:(Ljava/lang/String;I)V
        //   105: athrow         
        //   106: astore          39
        //   108: aload           38
        //   110: monitorexit    
        //   111: aload           39
        //   113: athrow         
        //   114: astore          9
        //   116: aload           9
        //   118: invokevirtual   com/google/android/gms/internal/da.a:()I
        //   121: istore          6
        //   123: iload           6
        //   125: iconst_3       
        //   126: if_icmpeq       135
        //   129: iload           6
        //   131: iconst_m1      
        //   132: if_icmpne       558
        //   135: aload           9
        //   137: invokevirtual   com/google/android/gms/internal/da.getMessage:()Ljava/lang/String;
        //   140: invokestatic    com/google/android/gms/internal/en.c:(Ljava/lang/String;)V
        //   143: aload_0        
        //   144: getfield        com/google/android/gms/internal/cy.j:Lcom/google/android/gms/internal/cz;
        //   147: ifnonnull       569
        //   150: aload_0        
        //   151: new             Lcom/google/android/gms/internal/cz;
        //   154: dup            
        //   155: iload           6
        //   157: invokespecial   com/google/android/gms/internal/cz.<init>:(I)V
        //   160: putfield        com/google/android/gms/internal/cy.j:Lcom/google/android/gms/internal/cz;
        //   163: getstatic       com/google/android/gms/internal/em.a:Landroid/os/Handler;
        //   166: new             Lcom/google/android/gms/internal/cy$1;
        //   169: dup            
        //   170: aload_0        
        //   171: invokespecial   com/google/android/gms/internal/cy$1.<init>:(Lcom/google/android/gms/internal/cy;)V
        //   174: invokevirtual   android/os/Handler.post:(Ljava/lang/Runnable;)Z
        //   177: pop            
        //   178: lload           7
        //   180: lstore          11
        //   182: aload           5
        //   184: astore          13
        //   186: aload_0        
        //   187: getfield        com/google/android/gms/internal/cy.j:Lcom/google/android/gms/internal/cz;
        //   190: getfield        com/google/android/gms/internal/cz.r:Ljava/lang/String;
        //   193: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   196: istore          14
        //   198: iload           14
        //   200: ifne            602
        //   203: aload_0        
        //   204: getfield        com/google/android/gms/internal/cy.j:Lcom/google/android/gms/internal/cz;
        //   207: getfield        com/google/android/gms/internal/cz.r:Ljava/lang/String;
        //   210: astore          34
        //   212: new             Lorg/json/JSONObject;
        //   215: dup            
        //   216: aload           34
        //   218: invokespecial   org/json/JSONObject.<init>:(Ljava/lang/String;)V
        //   221: astore          15
        //   223: aload           4
        //   225: getfield        com/google/android/gms/internal/cx.c:Lcom/google/android/gms/internal/ah;
        //   228: astore          16
        //   230: aload_0        
        //   231: getfield        com/google/android/gms/internal/cy.c:Lcom/google/android/gms/internal/ep;
        //   234: astore          17
        //   236: aload_0        
        //   237: getfield        com/google/android/gms/internal/cy.j:Lcom/google/android/gms/internal/cz;
        //   240: getfield        com/google/android/gms/internal/cz.d:Ljava/util/List;
        //   243: astore          18
        //   245: aload_0        
        //   246: getfield        com/google/android/gms/internal/cy.j:Lcom/google/android/gms/internal/cz;
        //   249: getfield        com/google/android/gms/internal/cz.f:Ljava/util/List;
        //   252: astore          19
        //   254: aload_0        
        //   255: getfield        com/google/android/gms/internal/cy.j:Lcom/google/android/gms/internal/cz;
        //   258: getfield        com/google/android/gms/internal/cz.j:Ljava/util/List;
        //   261: astore          20
        //   263: aload_0        
        //   264: getfield        com/google/android/gms/internal/cy.j:Lcom/google/android/gms/internal/cz;
        //   267: getfield        com/google/android/gms/internal/cz.l:I
        //   270: istore          21
        //   272: aload_0        
        //   273: getfield        com/google/android/gms/internal/cy.j:Lcom/google/android/gms/internal/cz;
        //   276: getfield        com/google/android/gms/internal/cz.k:J
        //   279: lstore          22
        //   281: aload           4
        //   283: getfield        com/google/android/gms/internal/cx.i:Ljava/lang/String;
        //   286: astore          24
        //   288: aload_0        
        //   289: getfield        com/google/android/gms/internal/cy.j:Lcom/google/android/gms/internal/cz;
        //   292: getfield        com/google/android/gms/internal/cz.h:Z
        //   295: istore          25
        //   297: aload_0        
        //   298: getfield        com/google/android/gms/internal/cy.n:Lcom/google/android/gms/internal/ax;
        //   301: ifnull          608
        //   304: aload_0        
        //   305: getfield        com/google/android/gms/internal/cy.n:Lcom/google/android/gms/internal/ax;
        //   308: getfield        com/google/android/gms/internal/ax.b:Lcom/google/android/gms/internal/ar;
        //   311: astore          26
        //   313: aload_0        
        //   314: getfield        com/google/android/gms/internal/cy.n:Lcom/google/android/gms/internal/ax;
        //   317: ifnull          614
        //   320: aload_0        
        //   321: getfield        com/google/android/gms/internal/cy.n:Lcom/google/android/gms/internal/ax;
        //   324: getfield        com/google/android/gms/internal/ax.c:Lcom/google/android/gms/internal/be;
        //   327: astore          27
        //   329: aload_0        
        //   330: getfield        com/google/android/gms/internal/cy.n:Lcom/google/android/gms/internal/ax;
        //   333: ifnull          620
        //   336: aload_0        
        //   337: getfield        com/google/android/gms/internal/cy.n:Lcom/google/android/gms/internal/ax;
        //   340: getfield        com/google/android/gms/internal/ax.d:Ljava/lang/String;
        //   343: astore          28
        //   345: aload_0        
        //   346: getfield        com/google/android/gms/internal/cy.m:Lcom/google/android/gms/internal/as;
        //   349: astore          29
        //   351: aload_0        
        //   352: getfield        com/google/android/gms/internal/cy.n:Lcom/google/android/gms/internal/ax;
        //   355: ifnull          626
        //   358: aload_0        
        //   359: getfield        com/google/android/gms/internal/cy.n:Lcom/google/android/gms/internal/ax;
        //   362: getfield        com/google/android/gms/internal/ax.e:Lcom/google/android/gms/internal/au;
        //   365: astore          30
        //   367: new             Lcom/google/android/gms/internal/du;
        //   370: dup            
        //   371: aload           16
        //   373: aload           17
        //   375: aload           18
        //   377: iload           6
        //   379: aload           19
        //   381: aload           20
        //   383: iload           21
        //   385: lload           22
        //   387: aload           24
        //   389: iload           25
        //   391: aload           26
        //   393: aload           27
        //   395: aload           28
        //   397: aload           29
        //   399: aload           30
        //   401: aload_0        
        //   402: getfield        com/google/android/gms/internal/cy.j:Lcom/google/android/gms/internal/cz;
        //   405: getfield        com/google/android/gms/internal/cz.i:J
        //   408: aload           13
        //   410: aload_0        
        //   411: getfield        com/google/android/gms/internal/cy.j:Lcom/google/android/gms/internal/cz;
        //   414: getfield        com/google/android/gms/internal/cz.g:J
        //   417: lload           11
        //   419: aload_0        
        //   420: getfield        com/google/android/gms/internal/cy.j:Lcom/google/android/gms/internal/cz;
        //   423: getfield        com/google/android/gms/internal/cz.n:J
        //   426: aload_0        
        //   427: getfield        com/google/android/gms/internal/cy.j:Lcom/google/android/gms/internal/cz;
        //   430: getfield        com/google/android/gms/internal/cz.o:Ljava/lang/String;
        //   433: aload           15
        //   435: invokespecial   com/google/android/gms/internal/du.<init>:(Lcom/google/android/gms/internal/ah;Lcom/google/android/gms/internal/ep;Ljava/util/List;ILjava/util/List;Ljava/util/List;IJLjava/lang/String;ZLcom/google/android/gms/internal/ar;Lcom/google/android/gms/internal/be;Ljava/lang/String;Lcom/google/android/gms/internal/as;Lcom/google/android/gms/internal/au;JLcom/google/android/gms/internal/ak;JJJLjava/lang/String;Lorg/json/JSONObject;)V
        //   438: astore          31
        //   440: getstatic       com/google/android/gms/internal/em.a:Landroid/os/Handler;
        //   443: new             Lcom/google/android/gms/internal/cy$2;
        //   446: dup            
        //   447: aload_0        
        //   448: aload           31
        //   450: invokespecial   com/google/android/gms/internal/cy$2.<init>:(Lcom/google/android/gms/internal/cy;Lcom/google/android/gms/internal/du;)V
        //   453: invokevirtual   android/os/Handler.post:(Ljava/lang/Runnable;)Z
        //   456: pop            
        //   457: aload_1        
        //   458: monitorexit    
        //   459: return         
        //   460: aload           38
        //   462: monitorexit    
        //   463: aload_0        
        //   464: lload           35
        //   466: invokespecial   com/google/android/gms/internal/cy.c:(J)V
        //   469: invokestatic    android/os/SystemClock.elapsedRealtime:()J
        //   472: lstore          7
        //   474: aload_0        
        //   475: invokespecial   com/google/android/gms/internal/cy.c:()V
        //   478: aload           4
        //   480: getfield        com/google/android/gms/internal/cx.d:Lcom/google/android/gms/internal/ak;
        //   483: getfield        com/google/android/gms/internal/ak.h:[Lcom/google/android/gms/internal/ak;
        //   486: astore          40
        //   488: aconst_null    
        //   489: astore          5
        //   491: aload           40
        //   493: ifnull          504
        //   496: aload_0        
        //   497: aload           4
        //   499: invokespecial   com/google/android/gms/internal/cy.a:(Lcom/google/android/gms/internal/cx;)Lcom/google/android/gms/internal/ak;
        //   502: astore          5
        //   504: aload_0        
        //   505: getfield        com/google/android/gms/internal/cy.j:Lcom/google/android/gms/internal/cz;
        //   508: getfield        com/google/android/gms/internal/cz.h:Z
        //   511: ifeq            525
        //   514: aload_0        
        //   515: aload           4
        //   517: lload           35
        //   519: invokespecial   com/google/android/gms/internal/cy.a:(Lcom/google/android/gms/internal/cx;J)V
        //   522: goto            632
        //   525: aload_0        
        //   526: getfield        com/google/android/gms/internal/cy.j:Lcom/google/android/gms/internal/cz;
        //   529: getfield        com/google/android/gms/internal/cz.p:Z
        //   532: ifeq            549
        //   535: aload_0        
        //   536: lload           35
        //   538: invokevirtual   com/google/android/gms/internal/cy.a:(J)V
        //   541: goto            632
        //   544: astore_2       
        //   545: aload_1        
        //   546: monitorexit    
        //   547: aload_2        
        //   548: athrow         
        //   549: aload_0        
        //   550: lload           35
        //   552: invokespecial   com/google/android/gms/internal/cy.b:(J)V
        //   555: goto            632
        //   558: aload           9
        //   560: invokevirtual   com/google/android/gms/internal/da.getMessage:()Ljava/lang/String;
        //   563: invokestatic    com/google/android/gms/internal/en.e:(Ljava/lang/String;)V
        //   566: goto            143
        //   569: aload_0        
        //   570: new             Lcom/google/android/gms/internal/cz;
        //   573: dup            
        //   574: iload           6
        //   576: aload_0        
        //   577: getfield        com/google/android/gms/internal/cy.j:Lcom/google/android/gms/internal/cz;
        //   580: getfield        com/google/android/gms/internal/cz.k:J
        //   583: invokespecial   com/google/android/gms/internal/cz.<init>:(IJ)V
        //   586: putfield        com/google/android/gms/internal/cy.j:Lcom/google/android/gms/internal/cz;
        //   589: goto            163
        //   592: astore          33
        //   594: ldc_w           "Error parsing the JSON for Active View."
        //   597: aload           33
        //   599: invokestatic    com/google/android/gms/internal/en.b:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   602: aconst_null    
        //   603: astore          15
        //   605: goto            223
        //   608: aconst_null    
        //   609: astore          26
        //   611: goto            313
        //   614: aconst_null    
        //   615: astore          27
        //   617: goto            329
        //   620: aconst_null    
        //   621: astore          28
        //   623: goto            345
        //   626: aconst_null    
        //   627: astore          30
        //   629: goto            367
        //   632: lload           7
        //   634: lstore          11
        //   636: aload           5
        //   638: astore          13
        //   640: goto            186
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  7      43     544    549    Any
        //  55     81     114    592    Lcom/google/android/gms/internal/da;
        //  55     81     544    549    Any
        //  81     106    106    114    Any
        //  108    111    106    114    Any
        //  111    114    114    592    Lcom/google/android/gms/internal/da;
        //  111    114    544    549    Any
        //  116    123    544    549    Any
        //  135    143    544    549    Any
        //  143    163    544    549    Any
        //  163    178    544    549    Any
        //  186    198    544    549    Any
        //  203    223    592    602    Ljava/lang/Exception;
        //  203    223    544    549    Any
        //  223    313    544    549    Any
        //  313    329    544    549    Any
        //  329    345    544    549    Any
        //  345    367    544    549    Any
        //  367    459    544    549    Any
        //  460    463    106    114    Any
        //  463    488    114    592    Lcom/google/android/gms/internal/da;
        //  463    488    544    549    Any
        //  496    504    114    592    Lcom/google/android/gms/internal/da;
        //  496    504    544    549    Any
        //  504    522    114    592    Lcom/google/android/gms/internal/da;
        //  504    522    544    549    Any
        //  525    541    114    592    Lcom/google/android/gms/internal/da;
        //  525    541    544    549    Any
        //  545    547    544    549    Any
        //  549    555    114    592    Lcom/google/android/gms/internal/da;
        //  549    555    544    549    Any
        //  558    566    544    549    Any
        //  569    589    544    549    Any
        //  594    602    544    549    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0223:
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
    
    protected void a(final long n) {
        final ak e = this.c.e();
        int n2;
        int n3;
        if (e.e) {
            n2 = this.e.getResources().getDisplayMetrics().widthPixels;
            n3 = this.e.getResources().getDisplayMetrics().heightPixels;
        }
        else {
            n2 = e.g;
            n3 = e.d;
        }
        final db db = new db(this, this.c, n2, n3);
        em.a.post((Runnable)new Runnable() {
            @Override
            public void run() {
                synchronized (cy.this.f) {
                    if (cy.this.j.e != -2) {
                        return;
                    }
                    cy.this.c.f().a(cy.this);
                    db.a(cy.this.j);
                }
            }
        });
        this.d(n);
        if (db.c()) {
            en.a("Ad-Network indicated no fill with passback URL.");
            throw new da("AdNetwork sent passback url", 3);
        }
        if (!db.d()) {
            throw new da("AdNetwork timed out", 2);
        }
    }
    
    @Override
    public void a(final cz j) {
        synchronized (this.f) {
            en.a("Received ad response.");
            this.j = j;
            this.f.notify();
        }
    }
    
    @Override
    public void a(final ep ep) {
        synchronized (this.f) {
            en.a("WebView finished loading.");
            this.k = true;
            this.f.notify();
        }
    }
    
    @Override
    public void b() {
        synchronized (this.d) {
            if (this.i != null) {
                this.i.f();
            }
            this.c.stopLoading();
            eg.a(this.c);
            if (this.l != null) {
                this.l.a();
            }
        }
    }
}
