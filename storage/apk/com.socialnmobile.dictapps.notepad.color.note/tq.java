import java.util.HashSet;
import java.util.UUID;
import android.text.TextUtils;
import java.util.Set;
import android.database.Cursor;

// 
// Decompiled by Procyon v0.5.29
// 

public final class tq
{
    final ki a;
    final ko b;
    final Cursor c;
    final vc d;
    final uz e;
    final vb f;
    final ve g;
    final xj h;
    public int i;
    public int j;
    public int k;
    
    public tq(final ki a, final xj h, final Set set, final vc d) {
        this.f = vb.d;
        this.g = ve.a;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.a = a;
        this.b = new ko(a);
        this.h = h;
        final Number g = h.g("MAX_CHECKINS_PER_REQUEST");
        if (g != null) {
            this.b.a(g.intValue(), set);
            this.c = this.b.c();
            this.d = d;
            this.e = new uz(d);
            return;
        }
        throw new IllegalArgumentException("sessionParams: no MAX_CHECKINS_PER_REQUEST");
    }
    
    private static xj a(final Cursor cursor) {
        final xj xj = new xj();
        try {
            xj.a("class", cursor.getClass().getName());
            xj.a("isClosed", cursor.isClosed());
            xj.a("rowcount", cursor.getCount());
            xj.a("rowposition", cursor.getPosition());
            xj.a("columnscount", cursor.getColumnCount());
            xj.a("columns", TextUtils.join((CharSequence)" ", (Object[])cursor.getColumnNames()));
            return xj;
        }
        catch (Exception ex) {
            return xj;
        }
    }
    
    private xj a(final va va, final vc vc) {
        if (va == null) {
            throw new IllegalArgumentException("commit is null");
        }
        if (vc == null) {
            throw new IllegalArgumentException("nek is null");
        }
        while (true) {
            final xj xj = new xj();
            final xj xj2 = new xj();
            this.f.a(va, xj);
            while (true) {
                Label_0302: {
                    while (true) {
                        try {
                            final uz e = this.e;
                            final String h = xj.h("title");
                            if (h != null) {
                                xj.a("title", e.a(h));
                            }
                            final String h2 = xj.h("content");
                            if (h2 != null) {
                                xj.a("content", e.a(h2));
                            }
                            final String h3 = xj.h("uuid");
                            if (h3 == null) {
                                xj2.a("cursorinfo", a(this.c));
                                final xj xj3 = new xj();
                                final int columnIndexOrThrow = this.c.getColumnIndexOrThrow("uuid");
                                final String string = this.c.getString(columnIndexOrThrow);
                                final UUID uuid = (UUID)va.a.a.c();
                                if (uuid == null) {
                                    break Label_0302;
                                }
                                final String string2 = uuid.toString();
                                xj3.a("InCursorColumnIndex", columnIndexOrThrow);
                                xj3.a("inCursor", string);
                                xj3.a("inField", string2);
                                xj3.a("inMap", h3);
                                xj2.a("uuid", xj3);
                            }
                            if (xj2.size() > 0) {
                                xj.a("z_debuginfo", xj2);
                            }
                            return xj;
                        }
                        catch (tv tv) {
                            xj2.a("exception", adr.a.c(tv));
                            continue;
                        }
                        break;
                    }
                }
                final String string2 = null;
                continue;
            }
        }
    }
    
    final xi a(final Cursor cursor, final vc vc) {
        if (cursor == null) {
            throw new IllegalArgumentException("c is null");
        }
        final xi xi = new xi();
        final va va = new va();
        va.b(cursor);
        for (int i = 0; i < cursor.getCount(); ++i) {
            cursor.moveToPosition(i);
            xi.add(this.a(va, vc));
        }
        return xi;
    }
    
    public final void a() {
        this.c.close();
        this.b.d();
    }
    
    public final void a(final xx p0, final HashSet p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_1        
        //     1: getfield        xx.c:Lxj;
        //     4: astore_3       
        //     5: aload_0        
        //     6: getfield        tq.a:Lki;
        //     9: invokevirtual   ki.f:()Lkj;
        //    12: astore          4
        //    14: aload           4
        //    16: getfield        kj.a:Landroid/database/sqlite/SQLiteDatabase;
        //    19: invokevirtual   android/database/sqlite/SQLiteDatabase.beginTransaction:()V
        //    22: aload_3        
        //    23: invokevirtual   xj.keySet:()Ljava/util/Set;
        //    26: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    31: astore          7
        //    33: aload           7
        //    35: invokeinterface java/util/Iterator.hasNext:()Z
        //    40: ifne            60
        //    43: aload           4
        //    45: getfield        kj.a:Landroid/database/sqlite/SQLiteDatabase;
        //    48: invokevirtual   android/database/sqlite/SQLiteDatabase.setTransactionSuccessful:()V
        //    51: aload           4
        //    53: getfield        kj.a:Landroid/database/sqlite/SQLiteDatabase;
        //    56: invokevirtual   android/database/sqlite/SQLiteDatabase.endTransaction:()V
        //    59: return         
        //    60: aload           7
        //    62: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    67: checkcast       Ljava/lang/String;
        //    70: astore          8
        //    72: aload           8
        //    74: invokestatic    java/lang/Long.parseLong:(Ljava/lang/String;)J
        //    77: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //    80: astore          9
        //    82: aload_3        
        //    83: aload           8
        //    85: invokevirtual   xj.e:(Ljava/lang/String;)Lxi;
        //    88: astore          10
        //    90: aload           10
        //    92: iconst_0       
        //    93: invokevirtual   xi.get:(I)Ljava/lang/Object;
        //    96: checkcast       Ljava/lang/Number;
        //    99: invokevirtual   java/lang/Number.intValue:()I
        //   102: istore          11
        //   104: aload           10
        //   106: iconst_1       
        //   107: invokevirtual   xi.get:(I)Ljava/lang/Object;
        //   110: astore          12
        //   112: iload           11
        //   114: lookupswitch {
        //              200: 186
        //              400: 713
        //              409: 275
        //          default: 148
        //        }
        //   148: aload_2        
        //   149: aload           9
        //   151: invokevirtual   java/util/HashSet.add:(Ljava/lang/Object;)Z
        //   154: pop            
        //   155: goto            33
        //   158: astore          6
        //   160: new             Lvx;
        //   163: dup            
        //   164: ldc_w           "Bad commit result"
        //   167: aload           6
        //   169: invokespecial   vx.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   172: athrow         
        //   173: astore          5
        //   175: aload           4
        //   177: getfield        kj.a:Landroid/database/sqlite/SQLiteDatabase;
        //   180: invokevirtual   android/database/sqlite/SQLiteDatabase.endTransaction:()V
        //   183: aload           5
        //   185: athrow         
        //   186: aload           12
        //   188: checkcast       Ljava/lang/Number;
        //   191: invokevirtual   java/lang/Number.longValue:()J
        //   194: lstore          34
        //   196: aload           9
        //   198: invokevirtual   java/lang/Long.longValue:()J
        //   201: lstore          36
        //   203: new             Lva;
        //   206: dup            
        //   207: invokespecial   va.<init>:()V
        //   210: astore          38
        //   212: new             Landroid/content/ContentValues;
        //   215: dup            
        //   216: invokespecial   android/content/ContentValues.<init>:()V
        //   219: astore          39
        //   221: aload           38
        //   223: aload           39
        //   225: invokevirtual   va.d:(Landroid/content/ContentValues;)Ljava/lang/Object;
        //   228: pop            
        //   229: aload           38
        //   231: getfield        va.a:Lvu;
        //   234: getfield        vu.b:Lacf;
        //   237: lload           34
        //   239: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   242: invokeinterface acf.a:(Ljava/lang/Object;)V
        //   247: aload_0        
        //   248: getfield        tq.b:Lko;
        //   251: aload           39
        //   253: lload           36
        //   255: invokestatic    ko.a:(J)Laco;
        //   258: invokevirtual   ko.b:(Landroid/content/ContentValues;Laco;)I
        //   261: pop            
        //   262: aload_0        
        //   263: iconst_1       
        //   264: aload_0        
        //   265: getfield        tq.i:I
        //   268: iadd           
        //   269: putfield        tq.i:I
        //   272: goto            33
        //   275: aload           12
        //   277: invokestatic    xf.c:(Ljava/lang/Object;)Lxj;
        //   280: astore          14
        //   282: aload           9
        //   284: invokevirtual   java/lang/Long.longValue:()J
        //   287: pop2           
        //   288: new             Luy;
        //   291: dup            
        //   292: invokespecial   uy.<init>:()V
        //   295: astore          19
        //   297: aload           19
        //   299: new             Landroid/content/ContentValues;
        //   302: dup            
        //   303: invokespecial   android/content/ContentValues.<init>:()V
        //   306: invokevirtual   uy.d:(Landroid/content/ContentValues;)Ljava/lang/Object;
        //   309: pop            
        //   310: aload_0        
        //   311: getfield        tq.e:Luz;
        //   314: aload           14
        //   316: invokevirtual   uz.a:(Lxj;)V
        //   319: aload_0        
        //   320: getfield        tq.g:Lve;
        //   323: pop            
        //   324: aload           19
        //   326: aload           14
        //   328: invokestatic    ve.a:(Luy;Lxj;)V
        //   331: invokestatic    com/socialnmobile/colornote/ColorNote.e:()Lcom/socialnmobile/colornote/ColorNote;
        //   334: invokestatic    android/preference/PreferenceManager.getDefaultSharedPreferences:(Landroid/content/Context;)Landroid/content/SharedPreferences;
        //   337: ldc_w           "pref_sync_on_launch"
        //   340: invokeinterface android/content/SharedPreferences.contains:(Ljava/lang/String;)Z
        //   345: ifne            381
        //   348: invokestatic    com/socialnmobile/colornote/ColorNote.e:()Lcom/socialnmobile/colornote/ColorNote;
        //   351: invokestatic    android/preference/PreferenceManager.getDefaultSharedPreferences:(Landroid/content/Context;)Landroid/content/SharedPreferences;
        //   354: invokeinterface android/content/SharedPreferences.edit:()Landroid/content/SharedPreferences$Editor;
        //   359: astore          31
        //   361: aload           31
        //   363: ldc_w           "pref_sync_on_launch"
        //   366: iconst_1       
        //   367: invokeinterface android/content/SharedPreferences$Editor.putBoolean:(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;
        //   372: pop            
        //   373: aload           31
        //   375: invokeinterface android/content/SharedPreferences$Editor.commit:()Z
        //   380: pop            
        //   381: aload           19
        //   383: getfield        uy.a:Lvu;
        //   386: getfield        vu.a:Lacf;
        //   389: invokeinterface acf.c:()Ljava/lang/Object;
        //   394: checkcast       Ljava/util/UUID;
        //   397: astore          22
        //   399: aload           19
        //   401: getfield        uy.b:Lvi;
        //   404: getfield        vi.f:Lacf;
        //   407: invokeinterface acf.c:()Ljava/lang/Object;
        //   412: checkcast       Ljava/lang/Integer;
        //   415: invokevirtual   java/lang/Integer.intValue:()I
        //   418: istore          23
        //   420: iload           23
        //   422: lookupswitch {
        //                0: 593
        //               16: 605
        //              256: 504
        //          default: 456
        //        }
        //   456: new             Ljava/lang/RuntimeException;
        //   459: dup            
        //   460: new             Ljava/lang/StringBuilder;
        //   463: dup            
        //   464: ldc_w           "Unknown note type : "
        //   467: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   470: iload           23
        //   472: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   475: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   478: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;)V
        //   481: athrow         
        //   482: astore          15
        //   484: aload_0        
        //   485: iconst_1       
        //   486: aload_0        
        //   487: getfield        tq.j:I
        //   490: iadd           
        //   491: putfield        tq.j:I
        //   494: aload_2        
        //   495: aload           9
        //   497: invokevirtual   java/util/HashSet.add:(Ljava/lang/Object;)Z
        //   500: pop            
        //   501: goto            33
        //   504: new             Lyh;
        //   507: dup            
        //   508: invokespecial   yh.<init>:()V
        //   511: astore          24
        //   513: new             Luy;
        //   516: dup            
        //   517: invokespecial   uy.<init>:()V
        //   520: astore          25
        //   522: aload           22
        //   524: invokestatic    ko.b:(Ljava/util/UUID;)Laco;
        //   527: astore          26
        //   529: aload           25
        //   531: aload_0        
        //   532: getfield        tq.b:Lko;
        //   535: aconst_null    
        //   536: aload           26
        //   538: invokevirtual   ko.b:([Ljava/lang/String;Laco;)Landroid/content/ContentValues;
        //   541: invokevirtual   uy.d:(Landroid/content/ContentValues;)Ljava/lang/Object;
        //   544: pop            
        //   545: aload           24
        //   547: aload           25
        //   549: aload           19
        //   551: invokevirtual   yg.a:(Luy;Luy;)I
        //   554: tableswitch {
        //                2: 701
        //                3: 617
        //                4: 677
        //          default: 580
        //        }
        //   580: aload_0        
        //   581: iconst_1       
        //   582: aload_0        
        //   583: getfield        tq.k:I
        //   586: iadd           
        //   587: putfield        tq.k:I
        //   590: goto            33
        //   593: new             Lyi;
        //   596: dup            
        //   597: invokespecial   yi.<init>:()V
        //   600: astore          24
        //   602: goto            513
        //   605: new             Lyf;
        //   608: dup            
        //   609: invokespecial   yf.<init>:()V
        //   612: astore          24
        //   614: goto            513
        //   617: aload           25
        //   619: new             Landroid/content/ContentValues;
        //   622: dup            
        //   623: invokespecial   android/content/ContentValues.<init>:()V
        //   626: invokevirtual   uy.d:(Landroid/content/ContentValues;)Ljava/lang/Object;
        //   629: pop            
        //   630: aload           25
        //   632: getfield        uy.a:Lvu;
        //   635: getfield        vu.b:Lacf;
        //   638: aload           19
        //   640: getfield        uy.a:Lvu;
        //   643: getfield        vu.b:Lacf;
        //   646: invokeinterface acf.c:()Ljava/lang/Object;
        //   651: checkcast       Ljava/lang/Long;
        //   654: invokeinterface acf.a:(Ljava/lang/Object;)V
        //   659: aload_0        
        //   660: getfield        tq.b:Lko;
        //   663: aload           25
        //   665: invokevirtual   uy.v:()Landroid/content/ContentValues;
        //   668: aload           22
        //   670: invokevirtual   ko.a:(Landroid/content/ContentValues;Ljava/util/UUID;)I
        //   673: pop            
        //   674: goto            580
        //   677: aload           19
        //   679: iconst_0       
        //   680: invokevirtual   uy.a:(Z)V
        //   683: aload_0        
        //   684: getfield        tq.b:Lko;
        //   687: aload           19
        //   689: invokevirtual   uy.v:()Landroid/content/ContentValues;
        //   692: aload           26
        //   694: invokevirtual   ko.b:(Landroid/content/ContentValues;Laco;)I
        //   697: pop            
        //   698: goto            580
        //   701: aload_0        
        //   702: getfield        tq.b:Lko;
        //   705: aload           22
        //   707: invokevirtual   ko.c:(Ljava/util/UUID;)V
        //   710: goto            580
        //   713: aload_0        
        //   714: iconst_1       
        //   715: aload_0        
        //   716: getfield        tq.j:I
        //   719: iadd           
        //   720: putfield        tq.j:I
        //   723: goto            148
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  22     33     158    173    Lux;
        //  22     33     173    186    Any
        //  33     51     158    173    Lux;
        //  33     51     173    186    Any
        //  60     112    158    173    Lux;
        //  60     112    173    186    Any
        //  148    155    158    173    Lux;
        //  148    155    173    186    Any
        //  160    173    173    186    Any
        //  186    272    158    173    Lux;
        //  186    272    173    186    Any
        //  275    282    158    173    Lux;
        //  275    282    173    186    Any
        //  282    381    482    504    Ltv;
        //  282    381    158    173    Lux;
        //  282    381    173    186    Any
        //  381    420    482    504    Ltv;
        //  381    420    158    173    Lux;
        //  381    420    173    186    Any
        //  456    482    482    504    Ltv;
        //  456    482    158    173    Lux;
        //  456    482    173    186    Any
        //  484    501    158    173    Lux;
        //  484    501    173    186    Any
        //  504    513    482    504    Ltv;
        //  504    513    158    173    Lux;
        //  504    513    173    186    Any
        //  513    580    482    504    Ltv;
        //  513    580    158    173    Lux;
        //  513    580    173    186    Any
        //  580    590    482    504    Ltv;
        //  580    590    158    173    Lux;
        //  580    590    173    186    Any
        //  593    602    482    504    Ltv;
        //  593    602    158    173    Lux;
        //  593    602    173    186    Any
        //  605    614    482    504    Ltv;
        //  605    614    158    173    Lux;
        //  605    614    173    186    Any
        //  617    674    482    504    Ltv;
        //  617    674    158    173    Lux;
        //  617    674    173    186    Any
        //  677    698    482    504    Ltv;
        //  677    698    158    173    Lux;
        //  677    698    173    186    Any
        //  701    710    482    504    Ltv;
        //  701    710    158    173    Lux;
        //  701    710    173    186    Any
        //  713    723    158    173    Lux;
        //  713    723    173    186    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0381:
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
