import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ry implements acf
{
    final rv a;
    final sc b;
    Context c;
    
    public ry(final rv a) {
        this.b = new sc();
        this.c = null;
        this.a = a;
    }
    
    private void a(final Exception ex) {
        try {
            throw new vs(ex, this.a);
        }
        catch (Exception ex2) {
            adl.a.a(ex2);
        }
    }
    
    private rx d() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        ry.b:Lsc;
        //     4: aload_0        
        //     5: getfield        ry.a:Lrv;
        //     8: invokevirtual   sc.a:(Lrv;)Lrx;
        //    11: astore          46
        //    13: aload           46
        //    15: areturn        
        //    16: astore          45
        //    18: aload_0        
        //    19: aload           45
        //    21: invokespecial   ry.a:(Ljava/lang/Exception;)V
        //    24: new             Lsa;
        //    27: dup            
        //    28: aload_0        
        //    29: getfield        ry.a:Lrv;
        //    32: invokespecial   sa.<init>:(Lrv;)V
        //    35: astore_2       
        //    36: aload_2        
        //    37: getfield        sa.d:Lsl;
        //    40: astore          8
        //    42: aload           8
        //    44: getstatic       sl.a:Lsm;
        //    47: if_acmpne       504
        //    50: aload_2        
        //    51: getfield        sa.a:Lrv;
        //    54: getfield        rv.r:Lacf;
        //    57: invokeinterface acf.c:()Ljava/lang/Object;
        //    62: checkcast       Ljava/lang/String;
        //    65: astore          43
        //    67: new             Lui;
        //    70: dup            
        //    71: aload           43
        //    73: invokespecial   ui.<init>:(Ljava/lang/String;)V
        //    76: astore          44
        //    78: new             Ltj;
        //    81: dup            
        //    82: getstatic       sl.a:Lsm;
        //    85: aload           43
        //    87: aload           44
        //    89: invokespecial   tj.<init>:(Lsl;Ljava/lang/String;Ltt;)V
        //    92: astore          12
        //    94: aload_2        
        //    95: getfield        sa.a:Lrv;
        //    98: getfield        rv.m:Lacf;
        //   101: invokeinterface acf.c:()Ljava/lang/Object;
        //   106: checkcast       Ljava/lang/Long;
        //   109: invokevirtual   java/lang/Long.longValue:()J
        //   112: lstore          13
        //   114: aload_2        
        //   115: getfield        sa.b:Lxj;
        //   118: ldc             "NEK"
        //   120: getstatic       vd.a:Lvd;
        //   123: invokevirtual   xj.a:(Ljava/lang/String;Ladi;)Ljava/lang/Object;
        //   126: checkcast       Lvc;
        //   129: astore          15
        //   131: new             Ltw;
        //   134: dup            
        //   135: lconst_0       
        //   136: invokespecial   tw.<init>:(J)V
        //   139: astore          16
        //   141: new             Ltw;
        //   144: dup            
        //   145: lconst_0       
        //   146: invokespecial   tw.<init>:(J)V
        //   149: astore          17
        //   151: aload_2        
        //   152: getfield        sa.a:Lrv;
        //   155: getfield        rv.o:Lacf;
        //   158: invokeinterface acf.c:()Ljava/lang/Object;
        //   163: checkcast       Ltw;
        //   166: astore          18
        //   168: new             Lsq;
        //   171: dup            
        //   172: invokespecial   sq.<init>:()V
        //   175: astore          19
        //   177: aload           12
        //   179: getfield        tj.b:Ljava/lang/String;
        //   182: ifnull          408
        //   185: aload           19
        //   187: aload           12
        //   189: getfield        tj.a:Lsl;
        //   192: invokevirtual   sq.a:(Lsl;)Ljava/util/HashMap;
        //   195: astore          23
        //   197: aload           12
        //   199: getfield        tj.a:Lsl;
        //   202: astore          24
        //   204: aload_2        
        //   205: invokevirtual   sa.a:()Lxj;
        //   208: astore          25
        //   210: aload           24
        //   212: getstatic       sl.b:Lsn;
        //   215: if_acmpne       665
        //   218: aload           25
        //   220: ifnull          665
        //   223: aload           25
        //   225: ldc             "id"
        //   227: invokevirtual   xj.h:(Ljava/lang/String;)Ljava/lang/String;
        //   230: astore          26
        //   232: aload           25
        //   234: ldc             "updated_time"
        //   236: invokevirtual   xj.h:(Ljava/lang/String;)Ljava/lang/String;
        //   239: astore          27
        //   241: aload           25
        //   243: ldc             "name"
        //   245: invokevirtual   xj.h:(Ljava/lang/String;)Ljava/lang/String;
        //   248: astore          28
        //   250: aload           25
        //   252: ldc             "first_name"
        //   254: invokevirtual   xj.h:(Ljava/lang/String;)Ljava/lang/String;
        //   257: astore          29
        //   259: aload           25
        //   261: ldc             "last_name"
        //   263: invokevirtual   xj.h:(Ljava/lang/String;)Ljava/lang/String;
        //   266: astore          30
        //   268: aload           25
        //   270: ldc             "gender"
        //   272: invokevirtual   xj.h:(Ljava/lang/String;)Ljava/lang/String;
        //   275: astore          31
        //   277: aload           25
        //   279: ldc             "locale"
        //   281: invokevirtual   xj.h:(Ljava/lang/String;)Ljava/lang/String;
        //   284: astore          32
        //   286: aload           25
        //   288: ldc             "age_range"
        //   290: invokevirtual   xj.j:(Ljava/lang/String;)Lxj;
        //   293: astore          33
        //   295: aload           33
        //   297: ifnull          650
        //   300: aload           33
        //   302: ldc             "ageRangeMin"
        //   304: invokevirtual   xj.g:(Ljava/lang/String;)Ljava/lang/Number;
        //   307: astore          34
        //   309: aload           33
        //   311: ldc             "ageRangeMax"
        //   313: invokevirtual   xj.g:(Ljava/lang/String;)Ljava/lang/Number;
        //   316: astore          35
        //   318: aload           26
        //   320: ifnull          659
        //   323: new             Ljava/lang/StringBuilder;
        //   326: dup            
        //   327: ldc             "https://graph.facebook.com/"
        //   329: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   332: aload           26
        //   334: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   337: ldc             "/picture"
        //   339: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   342: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   345: astore          36
        //   347: new             Lvp;
        //   350: dup            
        //   351: aload           27
        //   353: aload           28
        //   355: aload           29
        //   357: aload           30
        //   359: aload           31
        //   361: aload           32
        //   363: aload           34
        //   365: aload           35
        //   367: aload           36
        //   369: invokespecial   vp.<init>:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/String;)V
        //   372: astore          37
        //   374: new             Lsr;
        //   377: dup            
        //   378: aload           12
        //   380: getfield        tj.a:Lsl;
        //   383: aload           12
        //   385: getfield        tj.b:Ljava/lang/String;
        //   388: aload           37
        //   390: invokespecial   sr.<init>:(Lsl;Ljava/lang/String;Lvp;)V
        //   393: astore          38
        //   395: aload           23
        //   397: aload           12
        //   399: getfield        tj.b:Ljava/lang/String;
        //   402: aload           38
        //   404: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   407: pop            
        //   408: aload_2        
        //   409: getfield        sa.b:Lxj;
        //   412: ldc             "hidden"
        //   414: invokevirtual   xj.g:(Ljava/lang/String;)Ljava/lang/Number;
        //   417: astore          20
        //   419: aload           20
        //   421: ifnull          671
        //   424: aload           20
        //   426: invokevirtual   java/lang/Number.intValue:()I
        //   429: ifeq            671
        //   432: iconst_1       
        //   433: istore          21
        //   435: new             Lrx;
        //   438: dup            
        //   439: new             Lsh;
        //   442: dup            
        //   443: lload           13
        //   445: aload           15
        //   447: aload           16
        //   449: aload           17
        //   451: aload           18
        //   453: iconst_0       
        //   454: aload           19
        //   456: iload           21
        //   458: invokespecial   sh.<init>:(JLvc;Ltw;Ltw;Ltw;ILsq;Z)V
        //   461: new             Luc;
        //   464: dup            
        //   465: aload           12
        //   467: invokespecial   uc.<init>:(Ltj;)V
        //   470: invokespecial   rx.<init>:(Lsh;Luc;)V
        //   473: astore          22
        //   475: aload           22
        //   477: areturn        
        //   478: astore          7
        //   480: aload_0        
        //   481: getfield        ry.c:Landroid/content/Context;
        //   484: ifnull          715
        //   487: aload_0        
        //   488: getfield        ry.c:Landroid/content/Context;
        //   491: ifnonnull       677
        //   494: new             Ljava/lang/IllegalStateException;
        //   497: dup            
        //   498: ldc             "context is null"
        //   500: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   503: athrow         
        //   504: aload           8
        //   506: getstatic       sl.c:Lso;
        //   509: if_acmpne       560
        //   512: aload_2        
        //   513: invokevirtual   sa.a:()Lxj;
        //   516: astore          40
        //   518: aload           40
        //   520: ifnull          740
        //   523: aload           40
        //   525: ldc             "email"
        //   527: invokevirtual   xj.h:(Ljava/lang/String;)Ljava/lang/String;
        //   530: astore          41
        //   532: aload_2        
        //   533: getstatic       uv.c:Luv;
        //   536: invokevirtual   sa.a:(Luv;)Luu;
        //   539: astore          42
        //   541: new             Ltj;
        //   544: dup            
        //   545: getstatic       sl.c:Lso;
        //   548: aload           41
        //   550: aload           42
        //   552: invokespecial   tj.<init>:(Lsl;Ljava/lang/String;Ltt;)V
        //   555: astore          12
        //   557: goto            94
        //   560: aload           8
        //   562: getstatic       sl.b:Lsn;
        //   565: if_acmpne       616
        //   568: aload_2        
        //   569: invokevirtual   sa.a:()Lxj;
        //   572: astore          9
        //   574: aload           9
        //   576: ifnull          734
        //   579: aload           9
        //   581: ldc             "id"
        //   583: invokevirtual   xj.h:(Ljava/lang/String;)Ljava/lang/String;
        //   586: astore          10
        //   588: aload_2        
        //   589: getstatic       us.c:Lus;
        //   592: invokevirtual   sa.a:(Lus;)Lur;
        //   595: astore          11
        //   597: new             Ltj;
        //   600: dup            
        //   601: getstatic       sl.b:Lsn;
        //   604: aload           10
        //   606: aload           11
        //   608: invokespecial   tj.<init>:(Lsl;Ljava/lang/String;Ltt;)V
        //   611: astore          12
        //   613: goto            94
        //   616: new             Ljava/lang/IllegalStateException;
        //   619: dup            
        //   620: new             Ljava/lang/StringBuilder;
        //   623: dup            
        //   624: ldc             "unsupported authority: "
        //   626: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   629: aload           8
        //   631: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   634: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   637: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   640: athrow         
        //   641: astore_3       
        //   642: aload_0        
        //   643: aload_3        
        //   644: invokespecial   ry.a:(Ljava/lang/Exception;)V
        //   647: goto            480
        //   650: aconst_null    
        //   651: astore          34
        //   653: aconst_null    
        //   654: astore          35
        //   656: goto            318
        //   659: aconst_null    
        //   660: astore          36
        //   662: goto            347
        //   665: aconst_null    
        //   666: astore          37
        //   668: goto            374
        //   671: iconst_0       
        //   672: istore          21
        //   674: goto            435
        //   677: new             Lrz;
        //   680: dup            
        //   681: aload_0        
        //   682: getfield        ry.c:Landroid/content/Context;
        //   685: invokespecial   rz.<init>:(Landroid/content/Context;)V
        //   688: astore          4
        //   690: aload           4
        //   692: aload_0        
        //   693: getfield        ry.a:Lrv;
        //   696: invokevirtual   rz.d:(Ljava/lang/Object;)Ljava/lang/Object;
        //   699: checkcast       Lrx;
        //   702: astore          6
        //   704: aload           6
        //   706: areturn        
        //   707: astore          5
        //   709: aload_0        
        //   710: aload           5
        //   712: invokespecial   ry.a:(Ljava/lang/Exception;)V
        //   715: new             Lvs;
        //   718: dup            
        //   719: ldc_w           "invalid account data"
        //   722: aload_0        
        //   723: getfield        ry.a:Lrv;
        //   726: invokespecial   vs.<init>:(Ljava/lang/String;Lrv;)V
        //   729: athrow         
        //   730: astore_1       
        //   731: goto            24
        //   734: aconst_null    
        //   735: astore          10
        //   737: goto            588
        //   740: aconst_null    
        //   741: astore          41
        //   743: goto            532
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  0      13     730    734    Lsd;
        //  0      13     16     24     Lux;
        //  24     94     478    480    Lsb;
        //  24     94     641    650    Lux;
        //  94     218    478    480    Lsb;
        //  94     218    641    650    Lux;
        //  223    295    478    480    Lsb;
        //  223    295    641    650    Lux;
        //  300    318    478    480    Lsb;
        //  300    318    641    650    Lux;
        //  323    347    478    480    Lsb;
        //  323    347    641    650    Lux;
        //  347    374    478    480    Lsb;
        //  347    374    641    650    Lux;
        //  374    408    478    480    Lsb;
        //  374    408    641    650    Lux;
        //  408    419    478    480    Lsb;
        //  408    419    641    650    Lux;
        //  424    432    478    480    Lsb;
        //  424    432    641    650    Lux;
        //  435    475    478    480    Lsb;
        //  435    475    641    650    Lux;
        //  504    518    478    480    Lsb;
        //  504    518    641    650    Lux;
        //  523    532    478    480    Lsb;
        //  523    532    641    650    Lux;
        //  532    557    478    480    Lsb;
        //  532    557    641    650    Lux;
        //  560    574    478    480    Lsb;
        //  560    574    641    650    Lux;
        //  579    588    478    480    Lsb;
        //  579    588    641    650    Lux;
        //  588    613    478    480    Lsb;
        //  588    613    641    650    Lux;
        //  616    641    478    480    Lsb;
        //  616    641    641    650    Lux;
        //  690    704    707    715    Lux;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 333, Size: 333
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
    
    public final rx a() {
        try {
            return this.d();
        }
        catch (Exception ex) {
            this.a(ex);
            return new rx();
        }
    }
    
    public final void a(final Context c) {
        if (c == null) {
            throw new IllegalArgumentException("context is null");
        }
        this.c = c;
    }
    
    public final void a(final rx rx) {
        final sc b = this.b;
        sc.a(rx, this.a);
    }
    
    @Override
    public final void b() {
        throw new UnsupportedOperationException();
    }
}
