// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.os.Build$VERSION;
import java.util.HashSet;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.Collections;
import android.content.ContentValues;
import java.util.List;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;

class PersistentHitStore implements HitStore
{
    private static final String CREATE_HITS_TABLE;
    private static final String DATABASE_FILENAME = "gtm_urls.db";
    @VisibleForTesting
    static final String HITS_TABLE = "gtm_hits";
    static final long HIT_DISPATCH_RETRY_WINDOW = 14400000L;
    @VisibleForTesting
    static final String HIT_FIRST_DISPATCH_TIME = "hit_first_send_time";
    @VisibleForTesting
    static final String HIT_ID = "hit_id";
    private static final String HIT_ID_WHERE_CLAUSE = "hit_id=?";
    @VisibleForTesting
    static final String HIT_TIME = "hit_time";
    @VisibleForTesting
    static final String HIT_URL = "hit_url";
    private Clock mClock;
    private final Context mContext;
    private final String mDatabaseName;
    private final UrlDatabaseHelper mDbHelper;
    private volatile Dispatcher mDispatcher;
    private long mLastDeleteStaleHitsTime;
    private final HitStoreStateListener mListener;
    
    static {
        CREATE_HITS_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time");
    }
    
    PersistentHitStore(final HitStoreStateListener hitStoreStateListener, final Context context) {
        this(hitStoreStateListener, context, "gtm_urls.db");
    }
    
    PersistentHitStore(final HitStoreStateListener mListener, final Context context, final String mDatabaseName) {
        this.mContext = context.getApplicationContext();
        this.mDatabaseName = mDatabaseName;
        this.mListener = mListener;
        this.mClock = new Clock() {
            @Override
            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }
        };
        this.mDbHelper = new UrlDatabaseHelper(this.mContext, this.mDatabaseName);
        this.mDispatcher = new SimpleNetworkDispatcher((HttpClient)new DefaultHttpClient(), this.mContext, (SimpleNetworkDispatcher.DispatchListener)new StoreDispatchListener());
        this.mLastDeleteStaleHitsTime = 0L;
    }
    
    private void deleteHit(final long l) {
        this.deleteHits(new String[] { String.valueOf(l) });
    }
    
    private SQLiteDatabase getWritableDatabase(final String s) {
        try {
            return this.mDbHelper.getWritableDatabase();
        }
        catch (SQLiteException ex) {
            Log.w(s);
            return null;
        }
    }
    
    private void removeOldHitIfFull() {
        final int n = 1 + (-2000 + this.getNumStoredHits());
        if (n > 0) {
            final List<String> peekHitIds = this.peekHitIds(n);
            Log.v("Store full, deleting " + peekHitIds.size() + " hits to make room.");
            this.deleteHits(peekHitIds.toArray(new String[0]));
        }
    }
    
    private void setHitFirstDispatchTime(final long n, final long l) {
        final SQLiteDatabase writableDatabase = this.getWritableDatabase("Error opening database for getNumStoredHits.");
        if (writableDatabase == null) {
            return;
        }
        final ContentValues contentValues = new ContentValues();
        contentValues.put("hit_first_send_time", l);
        try {
            writableDatabase.update("gtm_hits", contentValues, "hit_id=?", new String[] { String.valueOf(n) });
        }
        catch (SQLiteException ex) {
            Log.w("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + n);
            this.deleteHit(n);
        }
    }
    
    private void writeHitToDatabase(final long l, final String s) {
        final SQLiteDatabase writableDatabase = this.getWritableDatabase("Error opening database for putHit");
        if (writableDatabase == null) {
            return;
        }
        final ContentValues contentValues = new ContentValues();
        contentValues.put("hit_time", l);
        contentValues.put("hit_url", s);
        contentValues.put("hit_first_send_time", 0);
        try {
            writableDatabase.insert("gtm_hits", (String)null, contentValues);
            this.mListener.reportStoreIsEmpty(false);
        }
        catch (SQLiteException ex) {
            Log.w("Error storing hit");
        }
    }
    
    @Override
    public void close() {
        try {
            this.mDbHelper.getWritableDatabase().close();
            this.mDispatcher.close();
        }
        catch (SQLiteException ex) {
            Log.w("Error opening database for close");
        }
    }
    
    void deleteHits(final String[] array) {
        int n = 1;
        if (array != null && array.length != 0) {
            final SQLiteDatabase writableDatabase = this.getWritableDatabase("Error opening database for deleteHits.");
            if (writableDatabase != null) {
                while (true) {
                    final Object[] args = new Object[n];
                    args[0] = TextUtils.join((CharSequence)",", (Iterable)Collections.nCopies(array.length, "?"));
                    final String format = String.format("HIT_ID in (%s)", args);
                    while (true) {
                        try {
                            writableDatabase.delete("gtm_hits", format, array);
                            final HitStoreStateListener mListener = this.mListener;
                            if (this.getNumStoredHits() == 0) {
                                mListener.reportStoreIsEmpty(n != 0);
                                return;
                            }
                        }
                        catch (SQLiteException ex) {
                            Log.w("Error deleting hits");
                            return;
                        }
                        n = 0;
                        continue;
                    }
                }
            }
        }
    }
    
    int deleteStaleHits() {
        int n = 1;
        final long currentTimeMillis = this.mClock.currentTimeMillis();
        if (currentTimeMillis > 86400000L + this.mLastDeleteStaleHitsTime) {
            this.mLastDeleteStaleHitsTime = currentTimeMillis;
            final SQLiteDatabase writableDatabase = this.getWritableDatabase("Error opening database for deleteStaleHits.");
            if (writableDatabase != null) {
                final long i = this.mClock.currentTimeMillis() - 2592000000L;
                final String[] array = new String[n];
                array[0] = Long.toString(i);
                final int delete = writableDatabase.delete("gtm_hits", "HIT_TIME < ?", array);
                final HitStoreStateListener mListener = this.mListener;
                if (this.getNumStoredHits() != 0) {
                    n = 0;
                }
                mListener.reportStoreIsEmpty(n != 0);
                return delete;
            }
        }
        return 0;
    }
    
    @Override
    public void dispatch() {
        Log.v("GTM Dispatch running...");
        if (this.mDispatcher.okToDispatch()) {
            final List<Hit> peekHits = this.peekHits(40);
            if (peekHits.isEmpty()) {
                Log.v("...nothing to dispatch");
                this.mListener.reportStoreIsEmpty(true);
                return;
            }
            this.mDispatcher.dispatchHits(peekHits);
            if (this.getNumStoredUntriedHits() > 0) {
                ServiceManagerImpl.getInstance().dispatch();
            }
        }
    }
    
    @VisibleForTesting
    public UrlDatabaseHelper getDbHelper() {
        return this.mDbHelper;
    }
    
    @Override
    public Dispatcher getDispatcher() {
        return this.mDispatcher;
    }
    
    @VisibleForTesting
    UrlDatabaseHelper getHelper() {
        return this.mDbHelper;
    }
    
    int getNumStoredHits() {
        final SQLiteDatabase writableDatabase = this.getWritableDatabase("Error opening database for getNumStoredHits.");
        if (writableDatabase == null) {
            return 0;
        }
        Cursor rawQuery = null;
        try {
            rawQuery = writableDatabase.rawQuery("SELECT COUNT(*) from gtm_hits", (String[])null);
            final boolean moveToFirst = rawQuery.moveToFirst();
            int n = 0;
            if (moveToFirst) {
                n = (int)rawQuery.getLong(0);
            }
            return n;
        }
        catch (SQLiteException ex) {
            Log.w("Error getting numStoredHits");
            int n = 0;
            if (rawQuery != null) {
                rawQuery.close();
                n = 0;
                return n;
            }
            return n;
        }
        finally {
            if (rawQuery != null) {
                rawQuery.close();
            }
        }
    }
    
    int getNumStoredUntriedHits() {
        final SQLiteDatabase writableDatabase = this.getWritableDatabase("Error opening database for getNumStoredHits.");
        if (writableDatabase == null) {
            return 0;
        }
        Cursor query = null;
        try {
            query = writableDatabase.query("gtm_hits", new String[] { "hit_id", "hit_first_send_time" }, "hit_first_send_time=0", (String[])null, (String)null, (String)null, (String)null);
            return query.getCount();
        }
        catch (SQLiteException ex) {
            Log.w("Error getting num untried hits");
            int count = 0;
            if (query != null) {
                query.close();
                count = 0;
                return count;
            }
            return count;
        }
        finally {
            if (query != null) {
                query.close();
            }
        }
    }
    
    List<String> peekHitIds(final int i) {
        final ArrayList<String> list = new ArrayList<String>();
        if (i <= 0) {
            Log.w("Invalid maxHits specified. Skipping");
        }
        else {
            final SQLiteDatabase writableDatabase = this.getWritableDatabase("Error opening database for peekHitIds.");
            if (writableDatabase != null) {
                Cursor query = null;
                try {
                    query = writableDatabase.query("gtm_hits", new String[] { "hit_id" }, (String)null, (String[])null, (String)null, (String)null, String.format("%s ASC", "hit_id"), Integer.toString(i));
                    if (query.moveToFirst()) {
                        do {
                            list.add(String.valueOf(query.getLong(0)));
                        } while (query.moveToNext());
                    }
                    return list;
                }
                catch (SQLiteException ex) {
                    Log.w("Error in peekHits fetching hitIds: " + ex.getMessage());
                    return list;
                }
                finally {
                    if (query != null) {
                        query.close();
                    }
                }
            }
        }
        return list;
    }
    
    public List<Hit> peekHits(final int p0) {
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
        //    12: invokespecial   com/google/tagmanager/PersistentHitStore.getWritableDatabase:(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
        //    15: astore_3       
        //    16: aload_3        
        //    17: ifnonnull       22
        //    20: aload_2        
        //    21: areturn        
        //    22: aconst_null    
        //    23: astore          4
        //    25: aload_3        
        //    26: ldc             "gtm_hits"
        //    28: iconst_3       
        //    29: anewarray       Ljava/lang/String;
        //    32: dup            
        //    33: iconst_0       
        //    34: ldc             "hit_id"
        //    36: aastore        
        //    37: dup            
        //    38: iconst_1       
        //    39: ldc             "hit_time"
        //    41: aastore        
        //    42: dup            
        //    43: iconst_2       
        //    44: ldc             "hit_first_send_time"
        //    46: aastore        
        //    47: aconst_null    
        //    48: aconst_null    
        //    49: aconst_null    
        //    50: aconst_null    
        //    51: ldc_w           "%s ASC"
        //    54: iconst_1       
        //    55: anewarray       Ljava/lang/Object;
        //    58: dup            
        //    59: iconst_0       
        //    60: ldc             "hit_id"
        //    62: aastore        
        //    63: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //    66: iload_1        
        //    67: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //    70: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    73: astore          4
        //    75: new             Ljava/util/ArrayList;
        //    78: dup            
        //    79: invokespecial   java/util/ArrayList.<init>:()V
        //    82: astore          7
        //    84: aload           4
        //    86: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    91: ifeq            147
        //    94: aload           7
        //    96: new             Lcom/google/tagmanager/Hit;
        //    99: dup            
        //   100: aload           4
        //   102: iconst_0       
        //   103: invokeinterface android/database/Cursor.getLong:(I)J
        //   108: aload           4
        //   110: iconst_1       
        //   111: invokeinterface android/database/Cursor.getLong:(I)J
        //   116: aload           4
        //   118: iconst_2       
        //   119: invokeinterface android/database/Cursor.getLong:(I)J
        //   124: invokespecial   com/google/tagmanager/Hit.<init>:(JJJ)V
        //   127: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   132: pop            
        //   133: aload           4
        //   135: invokeinterface android/database/Cursor.moveToNext:()Z
        //   140: istore          9
        //   142: iload           9
        //   144: ifne            94
        //   147: aload           4
        //   149: ifnull          159
        //   152: aload           4
        //   154: invokeinterface android/database/Cursor.close:()V
        //   159: aload_3        
        //   160: ldc             "gtm_hits"
        //   162: iconst_2       
        //   163: anewarray       Ljava/lang/String;
        //   166: dup            
        //   167: iconst_0       
        //   168: ldc             "hit_id"
        //   170: aastore        
        //   171: dup            
        //   172: iconst_1       
        //   173: ldc             "hit_url"
        //   175: aastore        
        //   176: aconst_null    
        //   177: aconst_null    
        //   178: aconst_null    
        //   179: aconst_null    
        //   180: ldc_w           "%s ASC"
        //   183: iconst_1       
        //   184: anewarray       Ljava/lang/Object;
        //   187: dup            
        //   188: iconst_0       
        //   189: ldc             "hit_id"
        //   191: aastore        
        //   192: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   195: iload_1        
        //   196: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //   199: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   202: astore          4
        //   204: aload           4
        //   206: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   211: istore          18
        //   213: iconst_0       
        //   214: istore          19
        //   216: iload           18
        //   218: ifeq            275
        //   221: aload           4
        //   223: checkcast       Landroid/database/sqlite/SQLiteCursor;
        //   226: invokevirtual   android/database/sqlite/SQLiteCursor.getWindow:()Landroid/database/CursorWindow;
        //   229: invokevirtual   android/database/CursorWindow.getNumRows:()I
        //   232: ifle            350
        //   235: aload           7
        //   237: iload           19
        //   239: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   244: checkcast       Lcom/google/tagmanager/Hit;
        //   247: aload           4
        //   249: iconst_1       
        //   250: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   255: invokevirtual   com/google/tagmanager/Hit.setHitUrl:(Ljava/lang/String;)V
        //   258: iinc            19, 1
        //   261: aload           4
        //   263: invokeinterface android/database/Cursor.moveToNext:()Z
        //   268: istore          21
        //   270: iload           21
        //   272: ifne            221
        //   275: aload           4
        //   277: ifnull          287
        //   280: aload           4
        //   282: invokeinterface android/database/Cursor.close:()V
        //   287: aload           7
        //   289: areturn        
        //   290: astore          6
        //   292: new             Ljava/lang/StringBuilder;
        //   295: dup            
        //   296: invokespecial   java/lang/StringBuilder.<init>:()V
        //   299: ldc_w           "Error in peekHits fetching hitIds: "
        //   302: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   305: aload           6
        //   307: invokevirtual   android/database/sqlite/SQLiteException.getMessage:()Ljava/lang/String;
        //   310: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   313: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   316: invokestatic    com/google/tagmanager/Log.w:(Ljava/lang/String;)V
        //   319: aload           4
        //   321: ifnull          331
        //   324: aload           4
        //   326: invokeinterface android/database/Cursor.close:()V
        //   331: aload_2        
        //   332: areturn        
        //   333: astore          5
        //   335: aload           4
        //   337: ifnull          347
        //   340: aload           4
        //   342: invokeinterface android/database/Cursor.close:()V
        //   347: aload           5
        //   349: athrow         
        //   350: iconst_1       
        //   351: anewarray       Ljava/lang/Object;
        //   354: astore          20
        //   356: aload           20
        //   358: iconst_0       
        //   359: aload           7
        //   361: iload           19
        //   363: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   368: checkcast       Lcom/google/tagmanager/Hit;
        //   371: invokevirtual   com/google/tagmanager/Hit.getHitId:()J
        //   374: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   377: aastore        
        //   378: ldc_w           "HitString for hitId %d too large.  Hit will be deleted."
        //   381: aload           20
        //   383: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   386: invokestatic    com/google/tagmanager/Log.w:(Ljava/lang/String;)V
        //   389: goto            258
        //   392: astore          11
        //   394: new             Ljava/lang/StringBuilder;
        //   397: dup            
        //   398: invokespecial   java/lang/StringBuilder.<init>:()V
        //   401: ldc_w           "Error in peekHits fetching hit url: "
        //   404: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   407: aload           11
        //   409: invokevirtual   android/database/sqlite/SQLiteException.getMessage:()Ljava/lang/String;
        //   412: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   415: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   418: invokestatic    com/google/tagmanager/Log.w:(Ljava/lang/String;)V
        //   421: new             Ljava/util/ArrayList;
        //   424: dup            
        //   425: invokespecial   java/util/ArrayList.<init>:()V
        //   428: astore          12
        //   430: iconst_0       
        //   431: istore          13
        //   433: aload           7
        //   435: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //   440: astore          14
        //   442: aload           14
        //   444: invokeinterface java/util/Iterator.hasNext:()Z
        //   449: ifeq            484
        //   452: aload           14
        //   454: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   459: checkcast       Lcom/google/tagmanager/Hit;
        //   462: astore          15
        //   464: aload           15
        //   466: invokevirtual   com/google/tagmanager/Hit.getHitUrl:()Ljava/lang/String;
        //   469: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   472: istore          16
        //   474: iload           16
        //   476: ifeq            502
        //   479: iload           13
        //   481: ifeq            499
        //   484: aload           4
        //   486: ifnull          496
        //   489: aload           4
        //   491: invokeinterface android/database/Cursor.close:()V
        //   496: aload           12
        //   498: areturn        
        //   499: iconst_1       
        //   500: istore          13
        //   502: aload           12
        //   504: aload           15
        //   506: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   511: pop            
        //   512: goto            442
        //   515: astore          10
        //   517: aload           4
        //   519: ifnull          529
        //   522: aload           4
        //   524: invokeinterface android/database/Cursor.close:()V
        //   529: aload           10
        //   531: athrow         
        //   532: astore          5
        //   534: goto            335
        //   537: astore          6
        //   539: aload           7
        //   541: astore_2       
        //   542: goto            292
        //    Signature:
        //  (I)Ljava/util/List<Lcom/google/tagmanager/Hit;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  25     84     290    292    Landroid/database/sqlite/SQLiteException;
        //  25     84     333    335    Any
        //  84     94     537    545    Landroid/database/sqlite/SQLiteException;
        //  84     94     532    537    Any
        //  94     142    537    545    Landroid/database/sqlite/SQLiteException;
        //  94     142    532    537    Any
        //  159    213    392    515    Landroid/database/sqlite/SQLiteException;
        //  159    213    515    532    Any
        //  221    258    392    515    Landroid/database/sqlite/SQLiteException;
        //  221    258    515    532    Any
        //  261    270    392    515    Landroid/database/sqlite/SQLiteException;
        //  261    270    515    532    Any
        //  292    319    333    335    Any
        //  350    389    392    515    Landroid/database/sqlite/SQLiteException;
        //  350    389    515    532    Any
        //  394    430    515    532    Any
        //  433    442    515    532    Any
        //  442    474    515    532    Any
        //  502    512    515    532    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0094:
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
    public void putHit(final long n, final String s) {
        this.deleteStaleHits();
        this.removeOldHitIfFull();
        this.writeHitToDatabase(n, s);
    }
    
    @VisibleForTesting
    public void setClock(final Clock mClock) {
        this.mClock = mClock;
    }
    
    @VisibleForTesting
    void setDispatcher(final Dispatcher mDispatcher) {
        this.mDispatcher = mDispatcher;
    }
    
    @VisibleForTesting
    void setLastDeleteStaleHitsTime(final long mLastDeleteStaleHitsTime) {
        this.mLastDeleteStaleHitsTime = mLastDeleteStaleHitsTime;
    }
    
    @VisibleForTesting
    class StoreDispatchListener implements DispatchListener
    {
        @Override
        public void onHitDispatched(final Hit hit) {
            PersistentHitStore.this.deleteHit(hit.getHitId());
        }
        
        @Override
        public void onHitPermanentDispatchFailure(final Hit hit) {
            PersistentHitStore.this.deleteHit(hit.getHitId());
            Log.v("Permanent failure dispatching hitId: " + hit.getHitId());
        }
        
        @Override
        public void onHitTransientDispatchFailure(final Hit hit) {
            final long hitFirstDispatchTime = hit.getHitFirstDispatchTime();
            if (hitFirstDispatchTime == 0L) {
                PersistentHitStore.this.setHitFirstDispatchTime(hit.getHitId(), PersistentHitStore.this.mClock.currentTimeMillis());
            }
            else if (14400000L + hitFirstDispatchTime < PersistentHitStore.this.mClock.currentTimeMillis()) {
                PersistentHitStore.this.deleteHit(hit.getHitId());
                Log.v("Giving up on failed hitId: " + hit.getHitId());
            }
        }
    }
    
    @VisibleForTesting
    class UrlDatabaseHelper extends SQLiteOpenHelper
    {
        private boolean mBadDatabase;
        private long mLastDatabaseCheckTime;
        
        UrlDatabaseHelper(final Context context, final String s) {
            super(context, s, (SQLiteDatabase$CursorFactory)null, 1);
            this.mLastDatabaseCheckTime = 0L;
        }
        
        private boolean tablePresent(final String str, final SQLiteDatabase sqLiteDatabase) {
            Cursor query = null;
            try {
                query = sqLiteDatabase.query("SQLITE_MASTER", new String[] { "name" }, "name=?", new String[] { str }, (String)null, (String)null, (String)null);
                return query.moveToFirst();
            }
            catch (SQLiteException ex) {
                Log.w("Error querying for table " + str);
                return false;
            }
            finally {
                if (query != null) {
                    query.close();
                }
            }
        }
        
        private void validateColumnsPresent(final SQLiteDatabase sqLiteDatabase) {
            final Cursor rawQuery = sqLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", (String[])null);
            final HashSet<String> set = new HashSet<String>();
            try {
                final String[] columnNames = rawQuery.getColumnNames();
                for (int i = 0; i < columnNames.length; ++i) {
                    set.add(columnNames[i]);
                }
                rawQuery.close();
                if (!set.remove("hit_id") || !set.remove("hit_url") || !set.remove("hit_time") || !set.remove("hit_first_send_time")) {
                    throw new SQLiteException("Database column missing");
                }
            }
            finally {
                rawQuery.close();
            }
            if (!set.isEmpty()) {
                throw new SQLiteException("Database has extra columns");
            }
        }
        
        public SQLiteDatabase getWritableDatabase() {
            if (this.mBadDatabase && 3600000L + this.mLastDatabaseCheckTime > PersistentHitStore.this.mClock.currentTimeMillis()) {
                throw new SQLiteException("Database creation failed");
            }
            this.mBadDatabase = true;
            this.mLastDatabaseCheckTime = PersistentHitStore.this.mClock.currentTimeMillis();
            while (true) {
                try {
                    SQLiteDatabase sqLiteDatabase = super.getWritableDatabase();
                    if (sqLiteDatabase == null) {
                        sqLiteDatabase = super.getWritableDatabase();
                    }
                    this.mBadDatabase = false;
                    return sqLiteDatabase;
                }
                catch (SQLiteException ex) {
                    PersistentHitStore.this.mContext.getDatabasePath(PersistentHitStore.this.mDatabaseName).delete();
                    final SQLiteDatabase sqLiteDatabase = null;
                    continue;
                }
                break;
            }
        }
        
        boolean isBadDatabase() {
            return this.mBadDatabase;
        }
        
        public void onCreate(final SQLiteDatabase sqLiteDatabase) {
            FutureApis.setOwnerOnlyReadWrite(sqLiteDatabase.getPath());
        }
        
        public void onOpen(final SQLiteDatabase sqLiteDatabase) {
            while (true) {
                if (Build$VERSION.SDK_INT < 15) {
                    final Cursor rawQuery = sqLiteDatabase.rawQuery("PRAGMA journal_mode=memory", (String[])null);
                    try {
                        rawQuery.moveToFirst();
                        rawQuery.close();
                        if (!this.tablePresent("gtm_hits", sqLiteDatabase)) {
                            sqLiteDatabase.execSQL(PersistentHitStore.CREATE_HITS_TABLE);
                            return;
                        }
                    }
                    finally {
                        rawQuery.close();
                    }
                    this.validateColumnsPresent(sqLiteDatabase);
                    return;
                }
                continue;
            }
        }
        
        public void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
        }
        
        void setBadDatabase(final boolean mBadDatabase) {
            this.mBadDatabase = mBadDatabase;
        }
    }
}
