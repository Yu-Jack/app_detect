// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.webkit.WebView;
import android.os.SystemClock;
import org.json.JSONException;
import android.text.TextUtils;
import android.content.Context;

public class dn extends em implements dp$a, ey$a
{
    private final bt kB;
    private final ex lN;
    private final Object ls;
    private final Context mContext;
    private bm nf;
    private final k pA;
    private em pB;
    private du pC;
    private boolean pD;
    private bk pE;
    private bq pF;
    private final dm$a px;
    private final Object py;
    private final ds$a pz;
    
    public dn(final Context mContext, final ds$a pz, final k pa, final ex ln, final bt kb, final dm$a px) {
        this.py = new Object();
        this.ls = new Object();
        this.pD = false;
        this.kB = kb;
        this.px = px;
        this.lN = ln;
        this.mContext = mContext;
        this.pz = pz;
        this.pA = pa;
    }
    
    private al a(final ds ds) {
        if (this.pC.qj == null) {
            throw new dn$a("The ad response must specify one of the supported ad sizes.", 0);
        }
        final String[] split = this.pC.qj.split("x");
        if (split.length != 2) {
            throw new dn$a("Could not parse the ad size from the ad response: " + this.pC.qj, 0);
        }
        while (true) {
            int int1;
            int int2;
            al[] mg;
            int length;
            int n = 0;
            al al = null;
            float density;
            int width;
            int height;
            Label_0157_Outer:Label_0179_Outer:
            while (true) {
            Label_0265:
                while (true) {
                Label_0255:
                    while (true) {
                        try {
                            int1 = Integer.parseInt(split[0]);
                            int2 = Integer.parseInt(split[1]);
                            mg = ds.kT.mg;
                            length = mg.length;
                            n = 0;
                            if (n >= length) {
                                break;
                            }
                            al = mg[n];
                            density = this.mContext.getResources().getDisplayMetrics().density;
                            if (al.width == -1) {
                                width = (int)(al.widthPixels / density);
                                if (al.height != -2) {
                                    break Label_0255;
                                }
                                height = (int)(al.heightPixels / density);
                                if (int1 == width && int2 == height) {
                                    return new al(al, ds.kT.mg);
                                }
                                break Label_0265;
                            }
                        }
                        catch (NumberFormatException ex) {
                            throw new dn$a("Could not parse the ad size from the ad response: " + this.pC.qj, 0);
                        }
                        width = al.width;
                        continue Label_0179_Outer;
                    }
                    height = al.height;
                    continue;
                }
                ++n;
                continue Label_0157_Outer;
            }
        }
        throw new dn$a("The ad size from the ad response was not one of the requested sizes: " + this.pC.qj, 0);
    }
    
    private void a(final ds ds, final long n) {
        synchronized (this.py) {
            this.pE = new bk(this.mContext, ds, this.kB, this.nf);
            // monitorexit(this.py)
            this.pF = this.pE.a(n, 60000L);
            switch (this.pF.nL) {
                default: {
                    throw new dn$a("Unexpected mediation result: " + this.pF.nL, 0);
                }
                case 1: {
                    break;
                }
                case 0: {
                    return;
                }
            }
        }
        throw new dn$a("No fill from any mediation ad networks.", 3);
    }
    
    private void bn() {
        if (this.pC.errorCode != -3) {
            if (TextUtils.isEmpty((CharSequence)this.pC.qe)) {
                throw new dn$a("No fill from ad server.", 3);
            }
            if (this.pC.qg) {
                try {
                    this.nf = new bm(this.pC.qe);
                }
                catch (JSONException ex) {
                    throw new dn$a("Could not parse mediation config: " + this.pC.qe, 0);
                }
            }
        }
    }
    
    private boolean c(final long n) {
        final long n2 = 60000L - (SystemClock.elapsedRealtime() - n);
        if (n2 <= 0L) {
            return false;
        }
        try {
            this.ls.wait(n2);
            return true;
        }
        catch (InterruptedException ex) {
            throw new dn$a("Ad request cancelled.", -1);
        }
    }
    
    private void e(final long n) {
        et.sv.post((Runnable)new dn$3(this));
        this.h(n);
    }
    
    private void g(final long n) {
        while (this.c(n)) {
            if (this.pC != null) {
                synchronized (this.py) {
                    this.pB = null;
                    // monitorexit(this.py)
                    if (this.pC.errorCode != -2 && this.pC.errorCode != -3) {
                        throw new dn$a("There was a problem getting an ad response. ErrorCode: " + this.pC.errorCode, this.pC.errorCode);
                    }
                }
                return;
            }
        }
        throw new dn$a("Timed out waiting for ad response.", 2);
    }
    
    private void h(final long n) {
        while (this.c(n)) {
            if (this.pD) {
                return;
            }
        }
        throw new dn$a("Timed out waiting for WebView to finish loading.", 2);
    }
    
    @Override
    public void a(final du pc) {
        synchronized (this.ls) {
            eu.z("Received ad response.");
            this.pC = pc;
            this.ls.notify();
        }
    }
    
    @Override
    public void a(final ex ex) {
        synchronized (this.ls) {
            eu.z("WebView finished loading.");
            this.pD = true;
            this.ls.notify();
        }
    }
    
    @Override
    public void bh() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/google/android/gms/internal/dn.ls:Ljava/lang/Object;
        //     4: astore_1       
        //     5: aload_1        
        //     6: monitorenter   
        //     7: ldc_w           "AdLoaderBackgroundTask started."
        //    10: invokestatic    com/google/android/gms/internal/eu.z:(Ljava/lang/String;)V
        //    13: aload_0        
        //    14: getfield        com/google/android/gms/internal/dn.pA:Lcom/google/android/gms/internal/k;
        //    17: invokevirtual   com/google/android/gms/internal/k.z:()Lcom/google/android/gms/internal/g;
        //    20: astore_3       
        //    21: aload_3        
        //    22: aload_0        
        //    23: getfield        com/google/android/gms/internal/dn.mContext:Landroid/content/Context;
        //    26: invokeinterface com/google/android/gms/internal/g.b:(Landroid/content/Context;)Ljava/lang/String;
        //    31: astore          4
        //    33: aload_3        
        //    34: aload_0        
        //    35: getfield        com/google/android/gms/internal/dn.mContext:Landroid/content/Context;
        //    38: invokeinterface com/google/android/gms/internal/g.a:(Landroid/content/Context;)Ljava/lang/String;
        //    43: astore          5
        //    45: new             Lcom/google/android/gms/internal/ds;
        //    48: dup            
        //    49: aload_0        
        //    50: getfield        com/google/android/gms/internal/dn.pz:Lcom/google/android/gms/internal/ds$a;
        //    53: aload           4
        //    55: aload           5
        //    57: invokespecial   com/google/android/gms/internal/ds.<init>:(Lcom/google/android/gms/internal/ds$a;Ljava/lang/String;Ljava/lang/String;)V
        //    60: astore          6
        //    62: aconst_null    
        //    63: astore          7
        //    65: bipush          -2
        //    67: istore          8
        //    69: ldc2_w          -1
        //    72: lstore          9
        //    74: invokestatic    android/os/SystemClock.elapsedRealtime:()J
        //    77: lstore          37
        //    79: aload_0        
        //    80: getfield        com/google/android/gms/internal/dn.mContext:Landroid/content/Context;
        //    83: aload           6
        //    85: aload_0        
        //    86: invokestatic    com/google/android/gms/internal/dp.a:(Landroid/content/Context;Lcom/google/android/gms/internal/ds;Lcom/google/android/gms/internal/dp$a;)Lcom/google/android/gms/internal/em;
        //    89: astore          39
        //    91: aload_0        
        //    92: getfield        com/google/android/gms/internal/dn.py:Ljava/lang/Object;
        //    95: astore          40
        //    97: aload           40
        //    99: monitorenter   
        //   100: aload_0        
        //   101: aload           39
        //   103: putfield        com/google/android/gms/internal/dn.pB:Lcom/google/android/gms/internal/em;
        //   106: aload_0        
        //   107: getfield        com/google/android/gms/internal/dn.pB:Lcom/google/android/gms/internal/em;
        //   110: ifnonnull       479
        //   113: new             Lcom/google/android/gms/internal/dn$a;
        //   116: dup            
        //   117: ldc_w           "Could not start the ad request service."
        //   120: iconst_0       
        //   121: invokespecial   com/google/android/gms/internal/dn$a.<init>:(Ljava/lang/String;I)V
        //   124: athrow         
        //   125: astore          41
        //   127: aload           40
        //   129: monitorexit    
        //   130: aload           41
        //   132: athrow         
        //   133: astore          11
        //   135: aload           11
        //   137: invokevirtual   com/google/android/gms/internal/dn$a.getErrorCode:()I
        //   140: istore          8
        //   142: iload           8
        //   144: iconst_3       
        //   145: if_icmpeq       154
        //   148: iload           8
        //   150: iconst_m1      
        //   151: if_icmpne       577
        //   154: aload           11
        //   156: invokevirtual   com/google/android/gms/internal/dn$a.getMessage:()Ljava/lang/String;
        //   159: invokestatic    com/google/android/gms/internal/eu.B:(Ljava/lang/String;)V
        //   162: aload_0        
        //   163: getfield        com/google/android/gms/internal/dn.pC:Lcom/google/android/gms/internal/du;
        //   166: ifnonnull       588
        //   169: aload_0        
        //   170: new             Lcom/google/android/gms/internal/du;
        //   173: dup            
        //   174: iload           8
        //   176: invokespecial   com/google/android/gms/internal/du.<init>:(I)V
        //   179: putfield        com/google/android/gms/internal/dn.pC:Lcom/google/android/gms/internal/du;
        //   182: getstatic       com/google/android/gms/internal/et.sv:Landroid/os/Handler;
        //   185: new             Lcom/google/android/gms/internal/dn$1;
        //   188: dup            
        //   189: aload_0        
        //   190: invokespecial   com/google/android/gms/internal/dn$1.<init>:(Lcom/google/android/gms/internal/dn;)V
        //   193: invokevirtual   android/os/Handler.post:(Ljava/lang/Runnable;)Z
        //   196: pop            
        //   197: lload           9
        //   199: lstore          13
        //   201: aload           7
        //   203: astore          15
        //   205: aload_0        
        //   206: getfield        com/google/android/gms/internal/dn.pC:Lcom/google/android/gms/internal/du;
        //   209: getfield        com/google/android/gms/internal/du.qo:Ljava/lang/String;
        //   212: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   215: istore          16
        //   217: iload           16
        //   219: ifne            621
        //   222: aload_0        
        //   223: getfield        com/google/android/gms/internal/dn.pC:Lcom/google/android/gms/internal/du;
        //   226: getfield        com/google/android/gms/internal/du.qo:Ljava/lang/String;
        //   229: astore          36
        //   231: new             Lorg/json/JSONObject;
        //   234: dup            
        //   235: aload           36
        //   237: invokespecial   org/json/JSONObject.<init>:(Ljava/lang/String;)V
        //   240: astore          17
        //   242: aload           6
        //   244: getfield        com/google/android/gms/internal/ds.pX:Lcom/google/android/gms/internal/ai;
        //   247: astore          18
        //   249: aload_0        
        //   250: getfield        com/google/android/gms/internal/dn.lN:Lcom/google/android/gms/internal/ex;
        //   253: astore          19
        //   255: aload_0        
        //   256: getfield        com/google/android/gms/internal/dn.pC:Lcom/google/android/gms/internal/du;
        //   259: getfield        com/google/android/gms/internal/du.nt:Ljava/util/List;
        //   262: astore          20
        //   264: aload_0        
        //   265: getfield        com/google/android/gms/internal/dn.pC:Lcom/google/android/gms/internal/du;
        //   268: getfield        com/google/android/gms/internal/du.nu:Ljava/util/List;
        //   271: astore          21
        //   273: aload_0        
        //   274: getfield        com/google/android/gms/internal/dn.pC:Lcom/google/android/gms/internal/du;
        //   277: getfield        com/google/android/gms/internal/du.qi:Ljava/util/List;
        //   280: astore          22
        //   282: aload_0        
        //   283: getfield        com/google/android/gms/internal/dn.pC:Lcom/google/android/gms/internal/du;
        //   286: getfield        com/google/android/gms/internal/du.orientation:I
        //   289: istore          23
        //   291: aload_0        
        //   292: getfield        com/google/android/gms/internal/dn.pC:Lcom/google/android/gms/internal/du;
        //   295: getfield        com/google/android/gms/internal/du.nx:J
        //   298: lstore          24
        //   300: aload           6
        //   302: getfield        com/google/android/gms/internal/ds.qa:Ljava/lang/String;
        //   305: astore          26
        //   307: aload_0        
        //   308: getfield        com/google/android/gms/internal/dn.pC:Lcom/google/android/gms/internal/du;
        //   311: getfield        com/google/android/gms/internal/du.qg:Z
        //   314: istore          27
        //   316: aload_0        
        //   317: getfield        com/google/android/gms/internal/dn.pF:Lcom/google/android/gms/internal/bq;
        //   320: ifnull          627
        //   323: aload_0        
        //   324: getfield        com/google/android/gms/internal/dn.pF:Lcom/google/android/gms/internal/bq;
        //   327: getfield        com/google/android/gms/internal/bq.nM:Lcom/google/android/gms/internal/bl;
        //   330: astore          28
        //   332: aload_0        
        //   333: getfield        com/google/android/gms/internal/dn.pF:Lcom/google/android/gms/internal/bq;
        //   336: ifnull          633
        //   339: aload_0        
        //   340: getfield        com/google/android/gms/internal/dn.pF:Lcom/google/android/gms/internal/bq;
        //   343: getfield        com/google/android/gms/internal/bq.nN:Lcom/google/android/gms/internal/bu;
        //   346: astore          29
        //   348: aload_0        
        //   349: getfield        com/google/android/gms/internal/dn.pF:Lcom/google/android/gms/internal/bq;
        //   352: ifnull          639
        //   355: aload_0        
        //   356: getfield        com/google/android/gms/internal/dn.pF:Lcom/google/android/gms/internal/bq;
        //   359: getfield        com/google/android/gms/internal/bq.nO:Ljava/lang/String;
        //   362: astore          30
        //   364: aload_0        
        //   365: getfield        com/google/android/gms/internal/dn.nf:Lcom/google/android/gms/internal/bm;
        //   368: astore          31
        //   370: aload_0        
        //   371: getfield        com/google/android/gms/internal/dn.pF:Lcom/google/android/gms/internal/bq;
        //   374: ifnull          645
        //   377: aload_0        
        //   378: getfield        com/google/android/gms/internal/dn.pF:Lcom/google/android/gms/internal/bq;
        //   381: getfield        com/google/android/gms/internal/bq.nP:Lcom/google/android/gms/internal/bo;
        //   384: astore          32
        //   386: new             Lcom/google/android/gms/internal/ef;
        //   389: dup            
        //   390: aload           18
        //   392: aload           19
        //   394: aload           20
        //   396: iload           8
        //   398: aload           21
        //   400: aload           22
        //   402: iload           23
        //   404: lload           24
        //   406: aload           26
        //   408: iload           27
        //   410: aload           28
        //   412: aload           29
        //   414: aload           30
        //   416: aload           31
        //   418: aload           32
        //   420: aload_0        
        //   421: getfield        com/google/android/gms/internal/dn.pC:Lcom/google/android/gms/internal/du;
        //   424: getfield        com/google/android/gms/internal/du.qh:J
        //   427: aload           15
        //   429: aload_0        
        //   430: getfield        com/google/android/gms/internal/dn.pC:Lcom/google/android/gms/internal/du;
        //   433: getfield        com/google/android/gms/internal/du.qf:J
        //   436: lload           13
        //   438: aload_0        
        //   439: getfield        com/google/android/gms/internal/dn.pC:Lcom/google/android/gms/internal/du;
        //   442: getfield        com/google/android/gms/internal/du.qk:J
        //   445: aload_0        
        //   446: getfield        com/google/android/gms/internal/dn.pC:Lcom/google/android/gms/internal/du;
        //   449: getfield        com/google/android/gms/internal/du.ql:Ljava/lang/String;
        //   452: aload           17
        //   454: invokespecial   com/google/android/gms/internal/ef.<init>:(Lcom/google/android/gms/internal/ai;Lcom/google/android/gms/internal/ex;Ljava/util/List;ILjava/util/List;Ljava/util/List;IJLjava/lang/String;ZLcom/google/android/gms/internal/bl;Lcom/google/android/gms/internal/bu;Ljava/lang/String;Lcom/google/android/gms/internal/bm;Lcom/google/android/gms/internal/bo;JLcom/google/android/gms/internal/al;JJJLjava/lang/String;Lorg/json/JSONObject;)V
        //   457: astore          33
        //   459: getstatic       com/google/android/gms/internal/et.sv:Landroid/os/Handler;
        //   462: new             Lcom/google/android/gms/internal/dn$2;
        //   465: dup            
        //   466: aload_0        
        //   467: aload           33
        //   469: invokespecial   com/google/android/gms/internal/dn$2.<init>:(Lcom/google/android/gms/internal/dn;Lcom/google/android/gms/internal/ef;)V
        //   472: invokevirtual   android/os/Handler.post:(Ljava/lang/Runnable;)Z
        //   475: pop            
        //   476: aload_1        
        //   477: monitorexit    
        //   478: return         
        //   479: aload           40
        //   481: monitorexit    
        //   482: aload_0        
        //   483: lload           37
        //   485: invokespecial   com/google/android/gms/internal/dn.g:(J)V
        //   488: invokestatic    android/os/SystemClock.elapsedRealtime:()J
        //   491: lstore          9
        //   493: aload_0        
        //   494: invokespecial   com/google/android/gms/internal/dn.bn:()V
        //   497: aload           6
        //   499: getfield        com/google/android/gms/internal/ds.kT:Lcom/google/android/gms/internal/al;
        //   502: getfield        com/google/android/gms/internal/al.mg:[Lcom/google/android/gms/internal/al;
        //   505: astore          42
        //   507: aconst_null    
        //   508: astore          7
        //   510: aload           42
        //   512: ifnull          523
        //   515: aload_0        
        //   516: aload           6
        //   518: invokespecial   com/google/android/gms/internal/dn.a:(Lcom/google/android/gms/internal/ds;)Lcom/google/android/gms/internal/al;
        //   521: astore          7
        //   523: aload_0        
        //   524: getfield        com/google/android/gms/internal/dn.pC:Lcom/google/android/gms/internal/du;
        //   527: getfield        com/google/android/gms/internal/du.qg:Z
        //   530: ifeq            544
        //   533: aload_0        
        //   534: aload           6
        //   536: lload           37
        //   538: invokespecial   com/google/android/gms/internal/dn.a:(Lcom/google/android/gms/internal/ds;J)V
        //   541: goto            651
        //   544: aload_0        
        //   545: getfield        com/google/android/gms/internal/dn.pC:Lcom/google/android/gms/internal/du;
        //   548: getfield        com/google/android/gms/internal/du.qm:Z
        //   551: ifeq            568
        //   554: aload_0        
        //   555: lload           37
        //   557: invokevirtual   com/google/android/gms/internal/dn.f:(J)V
        //   560: goto            651
        //   563: astore_2       
        //   564: aload_1        
        //   565: monitorexit    
        //   566: aload_2        
        //   567: athrow         
        //   568: aload_0        
        //   569: lload           37
        //   571: invokespecial   com/google/android/gms/internal/dn.e:(J)V
        //   574: goto            651
        //   577: aload           11
        //   579: invokevirtual   com/google/android/gms/internal/dn$a.getMessage:()Ljava/lang/String;
        //   582: invokestatic    com/google/android/gms/internal/eu.D:(Ljava/lang/String;)V
        //   585: goto            162
        //   588: aload_0        
        //   589: new             Lcom/google/android/gms/internal/du;
        //   592: dup            
        //   593: iload           8
        //   595: aload_0        
        //   596: getfield        com/google/android/gms/internal/dn.pC:Lcom/google/android/gms/internal/du;
        //   599: getfield        com/google/android/gms/internal/du.nx:J
        //   602: invokespecial   com/google/android/gms/internal/du.<init>:(IJ)V
        //   605: putfield        com/google/android/gms/internal/dn.pC:Lcom/google/android/gms/internal/du;
        //   608: goto            182
        //   611: astore          35
        //   613: ldc_w           "Error parsing the JSON for Active View."
        //   616: aload           35
        //   618: invokestatic    com/google/android/gms/internal/eu.b:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   621: aconst_null    
        //   622: astore          17
        //   624: goto            242
        //   627: aconst_null    
        //   628: astore          28
        //   630: goto            332
        //   633: aconst_null    
        //   634: astore          29
        //   636: goto            348
        //   639: aconst_null    
        //   640: astore          30
        //   642: goto            364
        //   645: aconst_null    
        //   646: astore          32
        //   648: goto            386
        //   651: lload           9
        //   653: lstore          13
        //   655: aload           7
        //   657: astore          15
        //   659: goto            205
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                  
        //  -----  -----  -----  -----  --------------------------------------
        //  7      62     563    568    Any
        //  74     100    133    611    Lcom/google/android/gms/internal/dn$a;
        //  74     100    563    568    Any
        //  100    125    125    133    Any
        //  127    130    125    133    Any
        //  130    133    133    611    Lcom/google/android/gms/internal/dn$a;
        //  130    133    563    568    Any
        //  135    142    563    568    Any
        //  154    162    563    568    Any
        //  162    182    563    568    Any
        //  182    197    563    568    Any
        //  205    217    563    568    Any
        //  222    242    611    621    Ljava/lang/Exception;
        //  222    242    563    568    Any
        //  242    332    563    568    Any
        //  332    348    563    568    Any
        //  348    364    563    568    Any
        //  364    386    563    568    Any
        //  386    478    563    568    Any
        //  479    482    125    133    Any
        //  482    507    133    611    Lcom/google/android/gms/internal/dn$a;
        //  482    507    563    568    Any
        //  515    523    133    611    Lcom/google/android/gms/internal/dn$a;
        //  515    523    563    568    Any
        //  523    541    133    611    Lcom/google/android/gms/internal/dn$a;
        //  523    541    563    568    Any
        //  544    560    133    611    Lcom/google/android/gms/internal/dn$a;
        //  544    560    563    568    Any
        //  564    566    563    568    Any
        //  568    574    133    611    Lcom/google/android/gms/internal/dn$a;
        //  568    574    563    568    Any
        //  577    585    563    568    Any
        //  588    608    563    568    Any
        //  613    621    563    568    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0242:
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
    
    protected void f(final long n) {
        final al v = this.lN.V();
        int n2;
        int n3;
        if (v.mf) {
            n2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            n3 = this.mContext.getResources().getDisplayMetrics().heightPixels;
        }
        else {
            n2 = v.widthPixels;
            n3 = v.heightPixels;
        }
        final do do1 = new do(this, this.lN, n2, n3);
        et.sv.post((Runnable)new dn$4(this, do1));
        this.h(n);
        if (do1.bq()) {
            eu.z("Ad-Network indicated no fill with passback URL.");
            throw new dn$a("AdNetwork sent passback url", 3);
        }
        if (!do1.br()) {
            throw new dn$a("AdNetwork timed out", 2);
        }
    }
    
    @Override
    public void onStop() {
        synchronized (this.py) {
            if (this.pB != null) {
                this.pB.cancel();
            }
            this.lN.stopLoading();
            eo.a(this.lN);
            if (this.pE != null) {
                this.pE.cancel();
            }
        }
    }
}
