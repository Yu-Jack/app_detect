import java.util.Iterator;
import com.socialnmobile.colornote.ColorNote;
import java.util.UUID;
import android.content.ContentValues;

// 
// Decompiled by Procyon v0.5.29
// 

public final class tl
{
    final rt a;
    final ki b;
    final ko c;
    
    public tl(final rt a, final ki b) {
        this.a = a;
        this.b = b;
        this.c = new ko(b);
    }
    
    private long a(final kj p0, final uy p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_2        
        //     1: invokevirtual   uy.v:()Landroid/content/ContentValues;
        //     4: astore_3       
        //     5: aload_2        
        //     6: getfield        uy.a:Lvu;
        //     9: getfield        vu.a:Lacf;
        //    12: invokeinterface acf.c:()Ljava/lang/Object;
        //    17: checkcast       Ljava/util/UUID;
        //    20: astore          4
        //    22: aload           4
        //    24: ifnonnull       36
        //    27: ldc             "sid is null"
        //    29: invokestatic    com/socialnmobile/colornote/ColorNote.a:(Ljava/lang/String;)V
        //    32: ldc2_w          -1
        //    35: lreturn        
        //    36: aload_2        
        //    37: getfield        uy.a:Lvu;
        //    40: getfield        vu.b:Lacf;
        //    43: invokeinterface acf.c:()Ljava/lang/Object;
        //    48: checkcast       Ljava/lang/Long;
        //    51: ifnonnull       63
        //    54: ldc             "revision is null"
        //    56: invokestatic    com/socialnmobile/colornote/ColorNote.a:(Ljava/lang/String;)V
        //    59: ldc2_w          -1
        //    62: lreturn        
        //    63: aload_3        
        //    64: ldc             "dirty"
        //    66: iconst_0       
        //    67: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    70: invokevirtual   android/content/ContentValues.put:(Ljava/lang/String;Ljava/lang/Integer;)V
        //    73: aload_1        
        //    74: getfield        kj.a:Landroid/database/sqlite/SQLiteDatabase;
        //    77: invokevirtual   android/database/sqlite/SQLiteDatabase.beginTransaction:()V
        //    80: aload_0        
        //    81: getfield        tl.c:Lko;
        //    84: aload           4
        //    86: invokevirtual   ko.a:(Ljava/util/UUID;)Landroid/content/ContentValues;
        //    89: astore          9
        //    91: aload           9
        //    93: ifnonnull       139
        //    96: aload_2        
        //    97: iconst_1       
        //    98: invokevirtual   uy.a:(Z)V
        //   101: aload_0        
        //   102: getfield        tl.c:Lko;
        //   105: aload_3        
        //   106: invokevirtual   ko.a:(Landroid/content/ContentValues;)J
        //   109: lstore          10
        //   111: lload           10
        //   113: lconst_0       
        //   114: lcmp           
        //   115: ifle            487
        //   118: aload_1        
        //   119: getfield        kj.a:Landroid/database/sqlite/SQLiteDatabase;
        //   122: invokevirtual   android/database/sqlite/SQLiteDatabase.setTransactionSuccessful:()V
        //   125: lload           10
        //   127: lstore          12
        //   129: aload_1        
        //   130: getfield        kj.a:Landroid/database/sqlite/SQLiteDatabase;
        //   133: invokevirtual   android/database/sqlite/SQLiteDatabase.endTransaction:()V
        //   136: lload           12
        //   138: lreturn        
        //   139: aload_2        
        //   140: iconst_0       
        //   141: invokevirtual   uy.a:(Z)V
        //   144: new             Lacm;
        //   147: dup            
        //   148: new             Lact;
        //   151: dup            
        //   152: ldc             "_id"
        //   154: invokespecial   act.<init>:(Ljava/lang/String;)V
        //   157: invokespecial   acm.<init>:(Lacn;)V
        //   160: astore          14
        //   162: new             Lwh;
        //   165: dup            
        //   166: invokespecial   wh.<init>:()V
        //   169: astore          15
        //   171: aload           14
        //   173: aload           9
        //   175: invokevirtual   acm.d:(Landroid/content/ContentValues;)Ljava/lang/Object;
        //   178: pop            
        //   179: aload           15
        //   181: aload           9
        //   183: invokevirtual   wh.d:(Landroid/content/ContentValues;)Ljava/lang/Object;
        //   186: pop            
        //   187: aload           14
        //   189: invokevirtual   acm.c:()Ljava/lang/Object;
        //   192: checkcast       Ljava/lang/Long;
        //   195: invokevirtual   java/lang/Long.longValue:()J
        //   198: lstore          10
        //   200: aload           15
        //   202: getfield        wh.b:Lacf;
        //   205: invokeinterface acf.c:()Ljava/lang/Object;
        //   210: checkcast       Ljava/lang/Integer;
        //   213: invokevirtual   java/lang/Integer.intValue:()I
        //   216: ifeq            261
        //   219: iconst_1       
        //   220: istore          18
        //   222: iload           18
        //   224: ifeq            267
        //   227: new             Ltm;
        //   230: dup            
        //   231: invokespecial   tm.<init>:()V
        //   234: athrow         
        //   235: astore          8
        //   237: aload           8
        //   239: invokevirtual   android/database/SQLException.printStackTrace:()V
        //   242: aload           8
        //   244: invokevirtual   android/database/SQLException.toString:()Ljava/lang/String;
        //   247: invokestatic    com/socialnmobile/colornote/ColorNote.a:(Ljava/lang/String;)V
        //   250: aload_1        
        //   251: getfield        kj.a:Landroid/database/sqlite/SQLiteDatabase;
        //   254: invokevirtual   android/database/sqlite/SQLiteDatabase.endTransaction:()V
        //   257: ldc2_w          -1
        //   260: lreturn        
        //   261: iconst_0       
        //   262: istore          18
        //   264: goto            222
        //   267: iconst_1       
        //   268: aload           15
        //   270: getfield        wh.a:Lacf;
        //   273: invokeinterface acf.c:()Ljava/lang/Object;
        //   278: checkcast       Ljava/lang/Integer;
        //   281: invokevirtual   java/lang/Integer.intValue:()I
        //   284: iand           
        //   285: ifeq            494
        //   288: iconst_1       
        //   289: istore          19
        //   291: iload           19
        //   293: ifne            481
        //   296: aload           15
        //   298: getfield        wh.a:Lacf;
        //   301: invokeinterface acf.c:()Ljava/lang/Object;
        //   306: checkcast       Ljava/lang/Integer;
        //   309: invokevirtual   java/lang/Integer.intValue:()I
        //   312: ifeq            500
        //   315: iconst_1       
        //   316: istore          20
        //   318: goto            476
        //   321: lload           10
        //   323: lconst_0       
        //   324: lcmp           
        //   325: iflt            487
        //   328: aload_1        
        //   329: getfield        kj.a:Landroid/database/sqlite/SQLiteDatabase;
        //   332: invokevirtual   android/database/sqlite/SQLiteDatabase.setTransactionSuccessful:()V
        //   335: goto            487
        //   338: aload_0        
        //   339: getfield        tl.c:Lko;
        //   342: astore          21
        //   344: iconst_1       
        //   345: anewarray       Ljava/lang/Object;
        //   348: astore          22
        //   350: aload           22
        //   352: iconst_0       
        //   353: lload           10
        //   355: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   358: aastore        
        //   359: aload           21
        //   361: aload_3        
        //   362: new             Laco;
        //   365: dup            
        //   366: ldc             "_id=?"
        //   368: aload           22
        //   370: invokespecial   aco.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   373: invokevirtual   ko.a:(Landroid/content/ContentValues;Laco;)I
        //   376: iconst_1       
        //   377: if_icmpeq       321
        //   380: new             Ltn;
        //   383: dup            
        //   384: invokespecial   tn.<init>:()V
        //   387: athrow         
        //   388: astore          7
        //   390: new             Ljava/lang/StringBuilder;
        //   393: dup            
        //   394: ldc             "Note of uuid "
        //   396: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   399: aload           4
        //   401: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   404: ldc             " is in commit; checkout failed"
        //   406: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   409: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   412: invokestatic    com/socialnmobile/colornote/ColorNote.a:(Ljava/lang/String;)V
        //   415: aload_1        
        //   416: getfield        kj.a:Landroid/database/sqlite/SQLiteDatabase;
        //   419: invokevirtual   android/database/sqlite/SQLiteDatabase.endTransaction:()V
        //   422: ldc2_w          -1
        //   425: lreturn        
        //   426: astore          6
        //   428: new             Ljava/lang/StringBuilder;
        //   431: dup            
        //   432: ldc             "Note of uuid "
        //   434: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   437: aload           4
        //   439: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   442: ldc             ": is not updated; checkout failed"
        //   444: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   447: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   450: invokestatic    com/socialnmobile/colornote/ColorNote.a:(Ljava/lang/String;)V
        //   453: aload_1        
        //   454: getfield        kj.a:Landroid/database/sqlite/SQLiteDatabase;
        //   457: invokevirtual   android/database/sqlite/SQLiteDatabase.endTransaction:()V
        //   460: ldc2_w          -1
        //   463: lreturn        
        //   464: astore          5
        //   466: aload_1        
        //   467: getfield        kj.a:Landroid/database/sqlite/SQLiteDatabase;
        //   470: invokevirtual   android/database/sqlite/SQLiteDatabase.endTransaction:()V
        //   473: aload           5
        //   475: athrow         
        //   476: iload           20
        //   478: ifeq            338
        //   481: lconst_0       
        //   482: lstore          10
        //   484: goto            321
        //   487: lload           10
        //   489: lstore          12
        //   491: goto            129
        //   494: iconst_0       
        //   495: istore          19
        //   497: goto            291
        //   500: iconst_0       
        //   501: istore          20
        //   503: goto            476
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  80     91     235    261    Landroid/database/SQLException;
        //  80     91     388    426    Ltm;
        //  80     91     426    464    Ltn;
        //  80     91     464    476    Any
        //  96     111    235    261    Landroid/database/SQLException;
        //  96     111    388    426    Ltm;
        //  96     111    426    464    Ltn;
        //  96     111    464    476    Any
        //  118    125    235    261    Landroid/database/SQLException;
        //  118    125    388    426    Ltm;
        //  118    125    426    464    Ltn;
        //  118    125    464    476    Any
        //  139    219    235    261    Landroid/database/SQLException;
        //  139    219    388    426    Ltm;
        //  139    219    426    464    Ltn;
        //  139    219    464    476    Any
        //  227    235    235    261    Landroid/database/SQLException;
        //  227    235    388    426    Ltm;
        //  227    235    426    464    Ltn;
        //  227    235    464    476    Any
        //  237    250    464    476    Any
        //  267    288    235    261    Landroid/database/SQLException;
        //  267    288    388    426    Ltm;
        //  267    288    426    464    Ltn;
        //  267    288    464    476    Any
        //  296    315    235    261    Landroid/database/SQLException;
        //  296    315    388    426    Ltm;
        //  296    315    426    464    Ltn;
        //  296    315    464    476    Any
        //  328    335    235    261    Landroid/database/SQLException;
        //  328    335    388    426    Ltm;
        //  328    335    426    464    Ltn;
        //  328    335    464    476    Any
        //  338    388    235    261    Landroid/database/SQLException;
        //  338    388    388    426    Ltm;
        //  338    388    426    464    Ltn;
        //  338    388    464    476    Any
        //  390    415    464    476    Any
        //  428    453    464    476    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0261:
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
    
    public final int a(final long n, final xi xi) {
        final vc s = this.a.s();
        final ve a = ve.a;
        final uz uz = new uz(s);
        final kj f = this.b.f();
        final Iterator<xi> iterator = (Iterator<xi>)xi.iterator();
        int n2 = 0;
        int n3 = 0;
        while (iterator.hasNext()) {
            long longValue;
            int i;
            int j;
            while (true) {
                final xi next = iterator.next();
                f.a.beginTransaction();
                while (true) {
                    uy uy;
                    Iterator<xj> iterator2;
                    try {
                        final xi xi2 = next;
                        longValue = ((Number)xi2.get(0)).longValue();
                        final xi xi3 = (xi)xi2.get(1);
                        uy = new uy();
                        iterator2 = xi3.iterator();
                        i = 0;
                        j = n3;
                        if (!iterator2.hasNext()) {
                            if (i != xi3.size()) {
                                throw new RuntimeException("not all checkout notes imported");
                            }
                            break;
                        }
                    }
                    catch (ux ux) {
                        try {
                            throw new vx(ux);
                        }
                        finally {
                            f.a.endTransaction();
                        }
                    }
                    final xj xj = iterator2.next();
                    uy.d(new ContentValues());
                    try {
                        uz.a(xj);
                        ve.a(uy, xj);
                        this.a(f, uy);
                        ++i;
                        continue;
                    }
                    catch (tv tv) {
                        tv.printStackTrace();
                        final vw a2 = vw.a;
                        vw.b(uy.a, xj);
                        final UUID uuid = (UUID)uy.a.a.c();
                        f.a.beginTransaction();
                        Label_0453: {
                            try {
                                if (this.c.a(uuid) == null) {
                                    uy.b.e.a(32);
                                    uy.a(true);
                                    if (this.c.a(uy.v()) <= 0L) {
                                        throw new RuntimeException("can't insert note");
                                    }
                                    break Label_0453;
                                }
                            }
                            finally {
                                f.a.endTransaction();
                            }
                            final Long n4 = (Long)uy.a.b.c();
                            final ContentValues contentValues = new ContentValues();
                            final vu vu = new vu();
                            vu.d(contentValues);
                            vu.b.a(n4);
                            if (1 != this.c.a(contentValues, uuid)) {
                                throw new RuntimeException("can't update note revision");
                            }
                        }
                        if (1 != this.c.a(ko.b(uuid))) {
                            throw new RuntimeException("can't mark note dirty");
                        }
                        f.a.setTransactionSuccessful();
                        f.a.endTransaction();
                        final int n5 = i + 1;
                        ++j;
                        i = n5;
                        continue;
                    }
                    continue;
                }
            }
            final int n6 = n2 + i;
            this.a.a(longValue);
            f.a.setTransactionSuccessful();
            new StringBuilder("checkout: rev=").append(longValue).append(" count=").append(i).toString();
            ColorNote.a();
            if (j > 0) {
                final xj xj2 = new xj();
                xj2.a("nFailedDecryption", j);
                adl.a.a(xj2);
            }
            f.a.endTransaction();
            n2 = n6;
            n3 = j;
        }
        this.a.a(n);
        return n2;
    }
}
