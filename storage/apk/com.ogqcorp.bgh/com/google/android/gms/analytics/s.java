// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import java.util.Collections;
import java.util.List;
import com.google.android.gms.internal.ef;
import java.util.Collection;
import android.content.ContentValues;
import java.util.Iterator;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import android.os.Build$VERSION;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import java.util.HashSet;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

class s extends SQLiteOpenHelper
{
    final /* synthetic */ r a;
    private boolean b;
    private long c;
    
    s(final r a, final Context context, final String s) {
        this.a = a;
        super(context, s, (SQLiteDatabase$CursorFactory)null, 1);
        this.c = 0L;
    }
    
    private void a(final SQLiteDatabase sqLiteDatabase) {
        final Cursor rawQuery = sqLiteDatabase.rawQuery("SELECT * FROM hits2 WHERE 0", (String[])null);
        final HashSet<String> set = new HashSet<String>();
        try {
            final String[] columnNames = rawQuery.getColumnNames();
            for (int i = 0; i < columnNames.length; ++i) {
                set.add(columnNames[i]);
            }
            rawQuery.close();
            if (!set.remove("hit_id") || !set.remove("hit_url") || !set.remove("hit_string") || !set.remove("hit_time")) {
                throw new SQLiteException("Database column missing");
            }
        }
        finally {
            rawQuery.close();
        }
        final boolean remove = set.remove("hit_app_id");
        boolean b = false;
        if (!remove) {
            b = true;
        }
        if (!set.isEmpty()) {
            throw new SQLiteException("Database has extra columns");
        }
        if (b) {
            sqLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
        }
    }
    
    private boolean a(final String p0, final SQLiteDatabase p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_3       
        //     2: aload_2        
        //     3: ldc             "SQLITE_MASTER"
        //     5: iconst_1       
        //     6: anewarray       Ljava/lang/String;
        //     9: dup            
        //    10: iconst_0       
        //    11: ldc             "name"
        //    13: aastore        
        //    14: ldc             "name=?"
        //    16: iconst_1       
        //    17: anewarray       Ljava/lang/String;
        //    20: dup            
        //    21: iconst_0       
        //    22: aload_1        
        //    23: aastore        
        //    24: aconst_null    
        //    25: aconst_null    
        //    26: aconst_null    
        //    27: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    30: astore          8
        //    32: aload           8
        //    34: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    39: istore          10
        //    41: aload           8
        //    43: ifnull          53
        //    46: aload           8
        //    48: invokeinterface android/database/Cursor.close:()V
        //    53: iload           10
        //    55: ireturn        
        //    56: astore          5
        //    58: aconst_null    
        //    59: astore          6
        //    61: new             Ljava/lang/StringBuilder;
        //    64: dup            
        //    65: invokespecial   java/lang/StringBuilder.<init>:()V
        //    68: ldc             "Error querying for table "
        //    70: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    73: aload_1        
        //    74: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    77: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    80: invokestatic    com/google/android/gms/analytics/p.d:(Ljava/lang/String;)V
        //    83: aload           6
        //    85: ifnull          95
        //    88: aload           6
        //    90: invokeinterface android/database/Cursor.close:()V
        //    95: iconst_0       
        //    96: ireturn        
        //    97: astore          4
        //    99: aload_3        
        //   100: ifnull          109
        //   103: aload_3        
        //   104: invokeinterface android/database/Cursor.close:()V
        //   109: aload           4
        //   111: athrow         
        //   112: astore          4
        //   114: aload           8
        //   116: astore_3       
        //   117: goto            99
        //   120: astore          7
        //   122: aload           6
        //   124: astore_3       
        //   125: aload           7
        //   127: astore          4
        //   129: goto            99
        //   132: astore          9
        //   134: aload           8
        //   136: astore          6
        //   138: goto            61
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  2      32     56     61     Landroid/database/sqlite/SQLiteException;
        //  2      32     97     99     Any
        //  32     41     132    141    Landroid/database/sqlite/SQLiteException;
        //  32     41     112    120    Any
        //  61     83     120    132    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 70, Size: 70
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
    
    public SQLiteDatabase getWritableDatabase() {
        if (this.b && 3600000L + this.c > this.a.j.a()) {
            throw new SQLiteException("Database creation failed");
        }
        this.b = true;
        this.c = this.a.j.a();
        while (true) {
            try {
                SQLiteDatabase sqLiteDatabase = super.getWritableDatabase();
                if (sqLiteDatabase == null) {
                    sqLiteDatabase = super.getWritableDatabase();
                }
                this.b = false;
                return sqLiteDatabase;
            }
            catch (SQLiteException ex) {
                this.a.e.getDatabasePath(this.a.f).delete();
                final SQLiteDatabase sqLiteDatabase = null;
                continue;
            }
            break;
        }
    }
    
    public void onCreate(final SQLiteDatabase sqLiteDatabase) {
        at.a(sqLiteDatabase.getPath());
    }
    
    public void onOpen(final SQLiteDatabase sqLiteDatabase) {
        while (true) {
            if (Build$VERSION.SDK_INT < 15) {
                final Cursor rawQuery = sqLiteDatabase.rawQuery("PRAGMA journal_mode=memory", (String[])null);
                try {
                    rawQuery.moveToFirst();
                    rawQuery.close();
                    if (!this.a("hits2", sqLiteDatabase)) {
                        sqLiteDatabase.execSQL(r.a);
                        return;
                    }
                }
                finally {
                    rawQuery.close();
                }
                this.a(sqLiteDatabase);
                return;
            }
            continue;
        }
    }
    
    public void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
    }
}
