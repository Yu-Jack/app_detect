// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.database.sqlite.SQLiteException;
import java.util.List;
import android.os.SystemClock;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.Context;

public class cx
{
    private static final Object ls;
    private static final String pr;
    private static cx pt;
    private final cx$a ps;
    
    static {
        pr = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", "InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time");
        ls = new Object();
    }
    
    private cx(final Context context) {
        this.ps = new cx$a(this, context, "google_inapp_purchase.db");
    }
    
    public static cx k(final Context context) {
        synchronized (cx.ls) {
            if (cx.pt == null) {
                cx.pt = new cx(context);
            }
            return cx.pt;
        }
    }
    
    public cv a(final Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        return new cv(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
    }
    
    public void a(final cv cv) {
        if (cv == null) {
            return;
        }
        final SQLiteDatabase writableDatabase;
        synchronized (cx.ls) {
            writableDatabase = this.getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
        }
        writableDatabase.delete("InAppPurchase", String.format("%s = %d", "purchase_id", cv.pl), (String[])null);
    }
    // monitorexit(o)
    
    public void b(final cv cv) {
        if (cv == null) {
            return;
        }
        final SQLiteDatabase writableDatabase;
        synchronized (cx.ls) {
            writableDatabase = this.getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
        }
        final ContentValues contentValues = new ContentValues();
        contentValues.put("product_id", cv.pn);
        contentValues.put("developer_payload", cv.pm);
        contentValues.put("record_time", SystemClock.elapsedRealtime());
        cv.pl = writableDatabase.insert("InAppPurchase", (String)null, contentValues);
        if (this.getRecordCount() > 20000L) {
            this.bk();
        }
    }
    // monitorexit(o)
    
    public void bk() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: getstatic       com/google/android/gms/internal/cx.ls:Ljava/lang/Object;
        //     3: astore_1       
        //     4: aload_1        
        //     5: monitorenter   
        //     6: aload_0        
        //     7: invokevirtual   com/google/android/gms/internal/cx.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    10: astore_3       
        //    11: aload_3        
        //    12: ifnonnull       18
        //    15: aload_1        
        //    16: monitorexit    
        //    17: return         
        //    18: aload_3        
        //    19: ldc             "InAppPurchase"
        //    21: aconst_null    
        //    22: aconst_null    
        //    23: aconst_null    
        //    24: aconst_null    
        //    25: aconst_null    
        //    26: ldc             "record_time ASC"
        //    28: ldc             "1"
        //    30: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    33: astore          7
        //    35: aload           7
        //    37: astore          5
        //    39: aload           5
        //    41: ifnull          64
        //    44: aload           5
        //    46: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    51: ifeq            64
        //    54: aload_0        
        //    55: aload_0        
        //    56: aload           5
        //    58: invokevirtual   com/google/android/gms/internal/cx.a:(Landroid/database/Cursor;)Lcom/google/android/gms/internal/cv;
        //    61: invokevirtual   com/google/android/gms/internal/cx.a:(Lcom/google/android/gms/internal/cv;)V
        //    64: aload           5
        //    66: ifnull          76
        //    69: aload           5
        //    71: invokeinterface android/database/Cursor.close:()V
        //    76: aload_1        
        //    77: monitorexit    
        //    78: return         
        //    79: astore_2       
        //    80: aload_1        
        //    81: monitorexit    
        //    82: aload_2        
        //    83: athrow         
        //    84: astore          6
        //    86: aconst_null    
        //    87: astore          5
        //    89: new             Ljava/lang/StringBuilder;
        //    92: dup            
        //    93: invokespecial   java/lang/StringBuilder.<init>:()V
        //    96: ldc             "Error remove oldest record"
        //    98: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   101: aload           6
        //   103: invokevirtual   android/database/sqlite/SQLiteException.getMessage:()Ljava/lang/String;
        //   106: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   109: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   112: invokestatic    com/google/android/gms/internal/eu.D:(Ljava/lang/String;)V
        //   115: aload           5
        //   117: ifnull          76
        //   120: aload           5
        //   122: invokeinterface android/database/Cursor.close:()V
        //   127: goto            76
        //   130: aload           5
        //   132: ifnull          142
        //   135: aload           5
        //   137: invokeinterface android/database/Cursor.close:()V
        //   142: aload           4
        //   144: athrow         
        //   145: astore          4
        //   147: goto            130
        //   150: astore          6
        //   152: goto            89
        //   155: astore          4
        //   157: aconst_null    
        //   158: astore          5
        //   160: goto            130
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  6      11     79     84     Any
        //  15     17     79     84     Any
        //  18     35     84     89     Landroid/database/sqlite/SQLiteException;
        //  18     35     155    163    Any
        //  44     64     150    155    Landroid/database/sqlite/SQLiteException;
        //  44     64     145    150    Any
        //  69     76     79     84     Any
        //  76     78     79     84     Any
        //  80     82     79     84     Any
        //  89     115    145    150    Any
        //  120    127    79     84     Any
        //  135    142    79     84     Any
        //  142    145    79     84     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 79, Size: 79
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
    
    public List d(final long p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: getstatic       com/google/android/gms/internal/cx.ls:Ljava/lang/Object;
        //     3: astore_3       
        //     4: aload_3        
        //     5: monitorenter   
        //     6: new             Ljava/util/LinkedList;
        //     9: dup            
        //    10: invokespecial   java/util/LinkedList.<init>:()V
        //    13: astore          4
        //    15: lload_1        
        //    16: lconst_0       
        //    17: lcmp           
        //    18: ifgt            26
        //    21: aload_3        
        //    22: monitorexit    
        //    23: aload           4
        //    25: areturn        
        //    26: aload_0        
        //    27: invokevirtual   com/google/android/gms/internal/cx.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    30: astore          6
        //    32: aload           6
        //    34: ifnonnull       42
        //    37: aload_3        
        //    38: monitorexit    
        //    39: aload           4
        //    41: areturn        
        //    42: aload           6
        //    44: ldc             "InAppPurchase"
        //    46: aconst_null    
        //    47: aconst_null    
        //    48: aconst_null    
        //    49: aconst_null    
        //    50: aconst_null    
        //    51: ldc             "record_time ASC"
        //    53: lload_1        
        //    54: invokestatic    java/lang/String.valueOf:(J)Ljava/lang/String;
        //    57: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    60: astore          10
        //    62: aload           10
        //    64: astore          8
        //    66: aload           8
        //    68: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    73: ifeq            104
        //    76: aload           4
        //    78: aload_0        
        //    79: aload           8
        //    81: invokevirtual   com/google/android/gms/internal/cx.a:(Landroid/database/Cursor;)Lcom/google/android/gms/internal/cv;
        //    84: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //    89: pop            
        //    90: aload           8
        //    92: invokeinterface android/database/Cursor.moveToNext:()Z
        //    97: istore          12
        //    99: iload           12
        //   101: ifne            76
        //   104: aload           8
        //   106: ifnull          116
        //   109: aload           8
        //   111: invokeinterface android/database/Cursor.close:()V
        //   116: aload_3        
        //   117: monitorexit    
        //   118: aload           4
        //   120: areturn        
        //   121: astore          9
        //   123: aconst_null    
        //   124: astore          8
        //   126: new             Ljava/lang/StringBuilder;
        //   129: dup            
        //   130: invokespecial   java/lang/StringBuilder.<init>:()V
        //   133: ldc             "Error extracing purchase info: "
        //   135: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   138: aload           9
        //   140: invokevirtual   android/database/sqlite/SQLiteException.getMessage:()Ljava/lang/String;
        //   143: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   146: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   149: invokestatic    com/google/android/gms/internal/eu.D:(Ljava/lang/String;)V
        //   152: aload           8
        //   154: ifnull          116
        //   157: aload           8
        //   159: invokeinterface android/database/Cursor.close:()V
        //   164: goto            116
        //   167: astore          5
        //   169: aload_3        
        //   170: monitorexit    
        //   171: aload           5
        //   173: athrow         
        //   174: astore          7
        //   176: aconst_null    
        //   177: astore          8
        //   179: aload           8
        //   181: ifnull          191
        //   184: aload           8
        //   186: invokeinterface android/database/Cursor.close:()V
        //   191: aload           7
        //   193: athrow         
        //   194: astore          7
        //   196: goto            179
        //   199: astore          9
        //   201: goto            126
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  6      15     167    174    Any
        //  21     23     167    174    Any
        //  26     32     167    174    Any
        //  37     39     167    174    Any
        //  42     62     121    126    Landroid/database/sqlite/SQLiteException;
        //  42     62     174    179    Any
        //  66     76     199    204    Landroid/database/sqlite/SQLiteException;
        //  66     76     194    199    Any
        //  76     99     199    204    Landroid/database/sqlite/SQLiteException;
        //  76     99     194    199    Any
        //  109    116    167    174    Any
        //  116    118    167    174    Any
        //  126    152    194    199    Any
        //  157    164    167    174    Any
        //  169    171    167    174    Any
        //  184    191    167    174    Any
        //  191    194    167    174    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0076:
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
    
    public int getRecordCount() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_1       
        //     2: getstatic       com/google/android/gms/internal/cx.ls:Ljava/lang/Object;
        //     5: astore_2       
        //     6: aload_2        
        //     7: monitorenter   
        //     8: aload_0        
        //     9: invokevirtual   com/google/android/gms/internal/cx.getWritableDatabase:()Landroid/database/sqlite/SQLiteDatabase;
        //    12: astore          4
        //    14: aload           4
        //    16: ifnonnull       23
        //    19: aload_2        
        //    20: monitorexit    
        //    21: iconst_0       
        //    22: ireturn        
        //    23: aload           4
        //    25: ldc             "select count(*) from InAppPurchase"
        //    27: aconst_null    
        //    28: invokevirtual   android/database/sqlite/SQLiteDatabase.rawQuery:(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
        //    31: astore_1       
        //    32: aload_1        
        //    33: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    38: ifeq            70
        //    41: aload_1        
        //    42: iconst_0       
        //    43: invokeinterface android/database/Cursor.getInt:(I)I
        //    48: istore          7
        //    50: aload_1        
        //    51: ifnull          60
        //    54: aload_1        
        //    55: invokeinterface android/database/Cursor.close:()V
        //    60: aload_2        
        //    61: monitorexit    
        //    62: iload           7
        //    64: ireturn        
        //    65: astore_3       
        //    66: aload_2        
        //    67: monitorexit    
        //    68: aload_3        
        //    69: athrow         
        //    70: aload_1        
        //    71: ifnull          80
        //    74: aload_1        
        //    75: invokeinterface android/database/Cursor.close:()V
        //    80: aload_2        
        //    81: monitorexit    
        //    82: iconst_0       
        //    83: ireturn        
        //    84: astore          6
        //    86: new             Ljava/lang/StringBuilder;
        //    89: dup            
        //    90: invokespecial   java/lang/StringBuilder.<init>:()V
        //    93: ldc             "Error getting record count"
        //    95: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    98: aload           6
        //   100: invokevirtual   android/database/sqlite/SQLiteException.getMessage:()Ljava/lang/String;
        //   103: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   106: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   109: invokestatic    com/google/android/gms/internal/eu.D:(Ljava/lang/String;)V
        //   112: aload_1        
        //   113: ifnull          80
        //   116: aload_1        
        //   117: invokeinterface android/database/Cursor.close:()V
        //   122: goto            80
        //   125: astore          5
        //   127: aload_1        
        //   128: ifnull          137
        //   131: aload_1        
        //   132: invokeinterface android/database/Cursor.close:()V
        //   137: aload           5
        //   139: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  8      14     65     70     Any
        //  19     21     65     70     Any
        //  23     50     84     125    Landroid/database/sqlite/SQLiteException;
        //  23     50     125    140    Any
        //  54     60     65     70     Any
        //  60     62     65     70     Any
        //  66     68     65     70     Any
        //  74     80     65     70     Any
        //  80     82     65     70     Any
        //  86     112    125    140    Any
        //  116    122    65     70     Any
        //  131    137    65     70     Any
        //  137    140    65     70     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0023:
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
    
    public SQLiteDatabase getWritableDatabase() {
        try {
            return this.ps.getWritableDatabase();
        }
        catch (SQLiteException ex) {
            eu.D("Error opening writable conversion tracking database");
            return null;
        }
    }
}
