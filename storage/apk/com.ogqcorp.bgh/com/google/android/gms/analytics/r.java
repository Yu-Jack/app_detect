// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import android.database.Cursor;
import java.util.Collections;
import java.util.List;
import com.google.android.gms.internal.ef;
import java.util.Collection;
import android.content.ContentValues;
import java.util.Iterator;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Map;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import android.content.Context;

class r implements ah
{
    private static final String a;
    private final s b;
    private volatile as c;
    private final ai d;
    private final Context e;
    private final String f;
    private q g;
    private long h;
    private final int i;
    private am j;
    
    static {
        a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id");
    }
    
    r(final ai ai, final Context context) {
        this(ai, context, "google_analytics_v4.db", 2000);
    }
    
    r(final ai d, final Context context, final String f, final int i) {
        this.e = context.getApplicationContext();
        this.f = f;
        this.d = d;
        this.j = new am() {
            @Override
            public long a() {
                return System.currentTimeMillis();
            }
        };
        this.b = new s(this, this.e, this.f);
        this.c = new x((HttpClient)new DefaultHttpClient(), this.e);
        this.h = 0L;
        this.i = i;
    }
    
    private SQLiteDatabase a(final String s) {
        try {
            return this.b.getWritableDatabase();
        }
        catch (SQLiteException ex) {
            p.d(s);
            return null;
        }
    }
    
    static String a(final Map<String, String> map) {
        final ArrayList<String> list = new ArrayList<String>(map.size());
        for (final Map.Entry<String, String> entry : map.entrySet()) {
            list.add(bj.a(entry.getKey()) + "=" + bj.a(entry.getValue()));
        }
        return TextUtils.join((CharSequence)"&", (Iterable)list);
    }
    
    private void a(final Map<String, String> map, final long l, String s) {
        final SQLiteDatabase a = this.a("Error opening database for putHit");
        if (a == null) {
            return;
        }
        final ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", a(map));
        contentValues.put("hit_time", l);
        while (true) {
            Label_0158: {
                if (!map.containsKey("AppUID")) {
                    break Label_0158;
                }
                try {
                    final long long1 = Long.parseLong(map.get("AppUID"));
                    contentValues.put("hit_app_id", long1);
                    if (s == null) {
                        s = "http://www.google-analytics.com/collect";
                    }
                    if (s.length() == 0) {
                        p.d("Empty path: not sending hit");
                        return;
                    }
                }
                catch (NumberFormatException ex) {
                    final long long1 = 0L;
                    continue;
                }
                contentValues.put("hit_url", s);
                try {
                    a.insert("hits2", (String)null, contentValues);
                    this.d.a(false);
                    return;
                }
                catch (SQLiteException ex2) {
                    p.d("Error storing hit");
                    return;
                }
            }
            final long long1 = 0L;
            continue;
        }
    }
    
    private void a(final Map<String, String> map, final Collection<ef> collection) {
        final String substring = "&_v".substring(1);
        if (collection != null) {
            for (final ef ef : collection) {
                if ("appendVersion".equals(ef.a())) {
                    map.put(substring, ef.b());
                    break;
                }
            }
        }
    }
    
    private void f() {
        final int n = 1 + (this.b() - this.i);
        if (n > 0) {
            final List<String> a = this.a(n);
            p.c("Store full, deleting " + a.size() + " hits to make room.");
            this.a(a.toArray(new String[0]));
        }
    }
    
    int a() {
        int n = 1;
        final long a = this.j.a();
        if (a > 86400000L + this.h) {
            this.h = a;
            final SQLiteDatabase a2 = this.a("Error opening database for deleteStaleHits.");
            if (a2 != null) {
                final long i = this.j.a() - 2592000000L;
                final String[] array = new String[n];
                array[0] = Long.toString(i);
                final int delete = a2.delete("hits2", "HIT_TIME < ?", array);
                final ai d = this.d;
                if (this.b() != 0) {
                    n = 0;
                }
                d.a(n != 0);
                return delete;
            }
        }
        return 0;
    }
    
    List<String> a(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/util/ArrayList.<init>:()V
        //     7: astore_2       
        //     8: iload_1        
        //     9: ifgt            20
        //    12: ldc_w           "Invalid maxHits specified. Skipping"
        //    15: invokestatic    com/google/android/gms/analytics/p.d:(Ljava/lang/String;)V
        //    18: aload_2        
        //    19: areturn        
        //    20: aload_0        
        //    21: ldc_w           "Error opening database for peekHitIds."
        //    24: invokespecial   com/google/android/gms/analytics/r.a:(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
        //    27: astore_3       
        //    28: aload_3        
        //    29: ifnonnull       34
        //    32: aload_2        
        //    33: areturn        
        //    34: aload_3        
        //    35: ldc             "hits2"
        //    37: iconst_1       
        //    38: anewarray       Ljava/lang/String;
        //    41: dup            
        //    42: iconst_0       
        //    43: ldc             "hit_id"
        //    45: aastore        
        //    46: aconst_null    
        //    47: aconst_null    
        //    48: aconst_null    
        //    49: aconst_null    
        //    50: ldc_w           "%s ASC"
        //    53: iconst_1       
        //    54: anewarray       Ljava/lang/Object;
        //    57: dup            
        //    58: iconst_0       
        //    59: ldc             "hit_id"
        //    61: aastore        
        //    62: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //    65: iload_1        
        //    66: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //    69: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    72: astore          7
        //    74: aload           7
        //    76: astore          5
        //    78: aload           5
        //    80: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    85: ifeq            120
        //    88: aload_2        
        //    89: aload           5
        //    91: iconst_0       
        //    92: invokeinterface android/database/Cursor.getLong:(I)J
        //    97: invokestatic    java/lang/String.valueOf:(J)Ljava/lang/String;
        //   100: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   105: pop            
        //   106: aload           5
        //   108: invokeinterface android/database/Cursor.moveToNext:()Z
        //   113: istore          9
        //   115: iload           9
        //   117: ifne            88
        //   120: aload           5
        //   122: ifnull          132
        //   125: aload           5
        //   127: invokeinterface android/database/Cursor.close:()V
        //   132: aload_2        
        //   133: areturn        
        //   134: astore          6
        //   136: aconst_null    
        //   137: astore          5
        //   139: new             Ljava/lang/StringBuilder;
        //   142: dup            
        //   143: invokespecial   java/lang/StringBuilder.<init>:()V
        //   146: ldc_w           "Error in peekHits fetching hitIds: "
        //   149: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   152: aload           6
        //   154: invokevirtual   android/database/sqlite/SQLiteException.getMessage:()Ljava/lang/String;
        //   157: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   160: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   163: invokestatic    com/google/android/gms/analytics/p.d:(Ljava/lang/String;)V
        //   166: aload           5
        //   168: ifnull          132
        //   171: aload           5
        //   173: invokeinterface android/database/Cursor.close:()V
        //   178: goto            132
        //   181: astore          4
        //   183: aconst_null    
        //   184: astore          5
        //   186: aload           5
        //   188: ifnull          198
        //   191: aload           5
        //   193: invokeinterface android/database/Cursor.close:()V
        //   198: aload           4
        //   200: athrow         
        //   201: astore          4
        //   203: goto            186
        //   206: astore          6
        //   208: goto            139
        //    Signature:
        //  (I)Ljava/util/List<Ljava/lang/String;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  34     74     134    139    Landroid/database/sqlite/SQLiteException;
        //  34     74     181    186    Any
        //  78     88     206    211    Landroid/database/sqlite/SQLiteException;
        //  78     88     201    206    Any
        //  88     115    206    211    Landroid/database/sqlite/SQLiteException;
        //  88     115    201    206    Any
        //  139    166    201    206    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0088:
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
    public void a(final long l) {
        int n = 1;
        final SQLiteDatabase a = this.a("Error opening database for clearHits");
        if (a != null) {
            if (l == 0L) {
                a.delete("hits2", (String)null, (String[])null);
            }
            else {
                final String[] array = new String[n];
                array[0] = Long.valueOf(l).toString();
                a.delete("hits2", "hit_app_id = ?", array);
            }
            final ai d = this.d;
            if (this.b() != 0) {
                n = 0;
            }
            d.a(n != 0);
        }
    }
    
    @Deprecated
    void a(final Collection<bi> collection) {
        if (collection == null || collection.isEmpty()) {
            p.d("Empty/Null collection passed to deleteHits.");
            return;
        }
        final String[] array = new String[collection.size()];
        final Iterator<bi> iterator = collection.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            final bi bi = iterator.next();
            final int n2 = n + 1;
            array[n] = String.valueOf(bi.b());
            n = n2;
        }
        this.a(array);
    }
    
    @Override
    public void a(final Map<String, String> map, final long n, final String s, final Collection<ef> collection) {
        this.a();
        this.f();
        this.a(map, collection);
        this.a(map, n, s);
    }
    
    void a(final String[] obj) {
        int n = 1;
        if (obj == null || obj.length == 0) {
            p.d("Empty hitIds passed to deleteHits.");
        }
        else {
            final SQLiteDatabase a = this.a("Error opening database for deleteHits.");
            if (a != null) {
                while (true) {
                    final Object[] args = new Object[n];
                    args[0] = TextUtils.join((CharSequence)",", (Iterable)Collections.nCopies(obj.length, "?"));
                    final String format = String.format("HIT_ID in (%s)", args);
                    while (true) {
                        try {
                            a.delete("hits2", format, obj);
                            final ai d = this.d;
                            if (this.b() == 0) {
                                d.a(n != 0);
                                return;
                            }
                        }
                        catch (SQLiteException ex) {
                            p.d("Error deleting hits " + obj);
                            return;
                        }
                        n = 0;
                        continue;
                    }
                }
            }
        }
    }
    
    int b() {
        Cursor rawQuery = null;
        final SQLiteDatabase a = this.a("Error opening database for getNumStoredHits.");
        int n = 0;
        if (a == null) {
            return n;
        }
        try {
            rawQuery = a.rawQuery("SELECT COUNT(*) from hits2", (String[])null);
            final boolean moveToFirst = rawQuery.moveToFirst();
            n = 0;
            if (moveToFirst) {
                n = (int)rawQuery.getLong(0);
            }
            return n;
        }
        catch (SQLiteException ex) {
            p.d("Error getting numStoredHits");
            n = 0;
            return 0;
        }
        finally {
            if (rawQuery != null) {
                rawQuery.close();
            }
        }
    }
    
    public List<bi> b(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Ljava/util/ArrayList;
        //     3: dup            
        //     4: invokespecial   java/util/ArrayList.<init>:()V
        //     7: astore_2       
        //     8: aload_0        
        //     9: ldc_w           "Error opening database for peekHits"
        //    12: invokespecial   com/google/android/gms/analytics/r.a:(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
        //    15: astore_3       
        //    16: aload_3        
        //    17: ifnonnull       26
        //    20: aload_2        
        //    21: astore          9
        //    23: aload           9
        //    25: areturn        
        //    26: aconst_null    
        //    27: astore          4
        //    29: aload_3        
        //    30: ldc             "hits2"
        //    32: iconst_2       
        //    33: anewarray       Ljava/lang/String;
        //    36: dup            
        //    37: iconst_0       
        //    38: ldc             "hit_id"
        //    40: aastore        
        //    41: dup            
        //    42: iconst_1       
        //    43: ldc             "hit_time"
        //    45: aastore        
        //    46: aconst_null    
        //    47: aconst_null    
        //    48: aconst_null    
        //    49: aconst_null    
        //    50: ldc_w           "%s ASC"
        //    53: iconst_1       
        //    54: anewarray       Ljava/lang/Object;
        //    57: dup            
        //    58: iconst_0       
        //    59: ldc             "hit_id"
        //    61: aastore        
        //    62: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //    65: iload_1        
        //    66: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //    69: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    72: astore          10
        //    74: aload           10
        //    76: astore          11
        //    78: new             Ljava/util/ArrayList;
        //    81: dup            
        //    82: invokespecial   java/util/ArrayList.<init>:()V
        //    85: astore          12
        //    87: aload           11
        //    89: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    94: ifeq            143
        //    97: aload           12
        //    99: new             Lcom/google/android/gms/analytics/bi;
        //   102: dup            
        //   103: aconst_null    
        //   104: aload           11
        //   106: iconst_0       
        //   107: invokeinterface android/database/Cursor.getLong:(I)J
        //   112: aload           11
        //   114: iconst_1       
        //   115: invokeinterface android/database/Cursor.getLong:(I)J
        //   120: invokespecial   com/google/android/gms/analytics/bi.<init>:(Ljava/lang/String;JJ)V
        //   123: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   128: pop            
        //   129: aload           11
        //   131: invokeinterface android/database/Cursor.moveToNext:()Z
        //   136: istore          15
        //   138: iload           15
        //   140: ifne            97
        //   143: aload           11
        //   145: ifnull          155
        //   148: aload           11
        //   150: invokeinterface android/database/Cursor.close:()V
        //   155: aload_3        
        //   156: ldc             "hits2"
        //   158: iconst_3       
        //   159: anewarray       Ljava/lang/String;
        //   162: dup            
        //   163: iconst_0       
        //   164: ldc             "hit_id"
        //   166: aastore        
        //   167: dup            
        //   168: iconst_1       
        //   169: ldc             "hit_string"
        //   171: aastore        
        //   172: dup            
        //   173: iconst_2       
        //   174: ldc             "hit_url"
        //   176: aastore        
        //   177: aconst_null    
        //   178: aconst_null    
        //   179: aconst_null    
        //   180: aconst_null    
        //   181: ldc_w           "%s ASC"
        //   184: iconst_1       
        //   185: anewarray       Ljava/lang/Object;
        //   188: dup            
        //   189: iconst_0       
        //   190: ldc             "hit_id"
        //   192: aastore        
        //   193: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   196: iload_1        
        //   197: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //   200: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   203: astore          24
        //   205: aload           24
        //   207: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   212: ifeq            298
        //   215: iconst_0       
        //   216: istore          25
        //   218: aload           24
        //   220: checkcast       Landroid/database/sqlite/SQLiteCursor;
        //   223: invokevirtual   android/database/sqlite/SQLiteCursor.getWindow:()Landroid/database/CursorWindow;
        //   226: invokevirtual   android/database/CursorWindow.getNumRows:()I
        //   229: ifle            384
        //   232: aload           12
        //   234: iload           25
        //   236: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   241: checkcast       Lcom/google/android/gms/analytics/bi;
        //   244: aload           24
        //   246: iconst_1       
        //   247: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   252: invokevirtual   com/google/android/gms/analytics/bi.a:(Ljava/lang/String;)V
        //   255: aload           12
        //   257: iload           25
        //   259: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   264: checkcast       Lcom/google/android/gms/analytics/bi;
        //   267: aload           24
        //   269: iconst_2       
        //   270: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   275: invokevirtual   com/google/android/gms/analytics/bi.b:(Ljava/lang/String;)V
        //   278: iload           25
        //   280: iconst_1       
        //   281: iadd           
        //   282: istore          27
        //   284: aload           24
        //   286: invokeinterface android/database/Cursor.moveToNext:()Z
        //   291: istore          28
        //   293: iload           28
        //   295: ifne            635
        //   298: aload           24
        //   300: ifnull          310
        //   303: aload           24
        //   305: invokeinterface android/database/Cursor.close:()V
        //   310: aload           12
        //   312: areturn        
        //   313: astore          6
        //   315: aload           6
        //   317: astore          7
        //   319: aconst_null    
        //   320: astore          8
        //   322: aload_2        
        //   323: astore          9
        //   325: new             Ljava/lang/StringBuilder;
        //   328: dup            
        //   329: invokespecial   java/lang/StringBuilder.<init>:()V
        //   332: ldc_w           "Error in peekHits fetching hitIds: "
        //   335: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   338: aload           7
        //   340: invokevirtual   android/database/sqlite/SQLiteException.getMessage:()Ljava/lang/String;
        //   343: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   346: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   349: invokestatic    com/google/android/gms/analytics/p.d:(Ljava/lang/String;)V
        //   352: aload           8
        //   354: ifnull          23
        //   357: aload           8
        //   359: invokeinterface android/database/Cursor.close:()V
        //   364: aload           9
        //   366: areturn        
        //   367: astore          5
        //   369: aload           4
        //   371: ifnull          381
        //   374: aload           4
        //   376: invokeinterface android/database/Cursor.close:()V
        //   381: aload           5
        //   383: athrow         
        //   384: iconst_1       
        //   385: anewarray       Ljava/lang/Object;
        //   388: astore          26
        //   390: aload           26
        //   392: iconst_0       
        //   393: aload           12
        //   395: iload           25
        //   397: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   402: checkcast       Lcom/google/android/gms/analytics/bi;
        //   405: invokevirtual   com/google/android/gms/analytics/bi.b:()J
        //   408: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   411: aastore        
        //   412: ldc_w           "HitString for hitId %d too large.  Hit will be deleted."
        //   415: aload           26
        //   417: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   420: invokestatic    com/google/android/gms/analytics/p.d:(Ljava/lang/String;)V
        //   423: goto            278
        //   426: astore          16
        //   428: aload           24
        //   430: astore          11
        //   432: new             Ljava/lang/StringBuilder;
        //   435: dup            
        //   436: invokespecial   java/lang/StringBuilder.<init>:()V
        //   439: ldc_w           "Error in peekHits fetching hitString: "
        //   442: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   445: aload           16
        //   447: invokevirtual   android/database/sqlite/SQLiteException.getMessage:()Ljava/lang/String;
        //   450: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   453: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   456: invokestatic    com/google/android/gms/analytics/p.d:(Ljava/lang/String;)V
        //   459: new             Ljava/util/ArrayList;
        //   462: dup            
        //   463: invokespecial   java/util/ArrayList.<init>:()V
        //   466: astore          18
        //   468: iconst_0       
        //   469: istore          19
        //   471: aload           12
        //   473: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //   478: astore          20
        //   480: aload           20
        //   482: invokeinterface java/util/Iterator.hasNext:()Z
        //   487: ifeq            522
        //   490: aload           20
        //   492: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   497: checkcast       Lcom/google/android/gms/analytics/bi;
        //   500: astore          21
        //   502: aload           21
        //   504: invokevirtual   com/google/android/gms/analytics/bi.a:()Ljava/lang/String;
        //   507: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   510: istore          22
        //   512: iload           22
        //   514: ifeq            540
        //   517: iload           19
        //   519: ifeq            537
        //   522: aload           11
        //   524: ifnull          534
        //   527: aload           11
        //   529: invokeinterface android/database/Cursor.close:()V
        //   534: aload           18
        //   536: areturn        
        //   537: iconst_1       
        //   538: istore          19
        //   540: aload           18
        //   542: aload           21
        //   544: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   549: pop            
        //   550: goto            480
        //   553: astore          17
        //   555: aload           11
        //   557: ifnull          567
        //   560: aload           11
        //   562: invokeinterface android/database/Cursor.close:()V
        //   567: aload           17
        //   569: athrow         
        //   570: astore          17
        //   572: aload           24
        //   574: astore          11
        //   576: goto            555
        //   579: astore          16
        //   581: goto            432
        //   584: astore          5
        //   586: aload           11
        //   588: astore          4
        //   590: goto            369
        //   593: astore          5
        //   595: aload           8
        //   597: astore          4
        //   599: goto            369
        //   602: astore          29
        //   604: aload           29
        //   606: astore          7
        //   608: aload           11
        //   610: astore          8
        //   612: aload_2        
        //   613: astore          9
        //   615: goto            325
        //   618: astore          13
        //   620: aload           13
        //   622: astore          7
        //   624: aload           11
        //   626: astore          8
        //   628: aload           12
        //   630: astore          9
        //   632: goto            325
        //   635: iload           27
        //   637: istore          25
        //   639: goto            218
        //    Signature:
        //  (I)Ljava/util/List<Lcom/google/android/gms/analytics/bi;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  29     74     313    325    Landroid/database/sqlite/SQLiteException;
        //  29     74     367    369    Any
        //  78     87     602    618    Landroid/database/sqlite/SQLiteException;
        //  78     87     584    593    Any
        //  87     97     618    635    Landroid/database/sqlite/SQLiteException;
        //  87     97     584    593    Any
        //  97     138    618    635    Landroid/database/sqlite/SQLiteException;
        //  97     138    584    593    Any
        //  155    205    579    584    Landroid/database/sqlite/SQLiteException;
        //  155    205    553    555    Any
        //  205    215    426    432    Landroid/database/sqlite/SQLiteException;
        //  205    215    570    579    Any
        //  218    278    426    432    Landroid/database/sqlite/SQLiteException;
        //  218    278    570    579    Any
        //  284    293    426    432    Landroid/database/sqlite/SQLiteException;
        //  284    293    570    579    Any
        //  325    352    593    602    Any
        //  384    423    426    432    Landroid/database/sqlite/SQLiteException;
        //  384    423    570    579    Any
        //  432    468    553    555    Any
        //  471    480    553    555    Any
        //  480    512    553    555    Any
        //  540    550    553    555    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:635)
        //     at java.util.ArrayList.get(ArrayList.java:411)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:3037)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2446)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:109)
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
    
    @Override
    public void c() {
        boolean b = true;
        p.c("Dispatch running...");
        if (!this.c.a()) {
            return;
        }
        final List<bi> b2 = this.b(40);
        if (b2.isEmpty()) {
            p.c("...nothing to dispatch");
            this.d.a(b);
            return;
        }
        if (this.g == null) {
            this.g = new q("_t=dispatch&_v=ma4.0.1", b);
        }
        if (this.b() > b2.size()) {
            b = false;
        }
        final int a = this.c.a(b2, this.g, b);
        p.c("sent " + a + " of " + b2.size() + " hits");
        this.a(b2.subList(0, Math.min(a, b2.size())));
        if (a == b2.size() && this.b() > 0) {
            com.google.android.gms.analytics.c.a(this.e).e();
            return;
        }
        this.g = null;
    }
    
    @Override
    public as d() {
        return this.c;
    }
}
