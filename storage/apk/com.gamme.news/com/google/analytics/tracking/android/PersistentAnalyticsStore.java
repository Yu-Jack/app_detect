// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import android.os.Build$VERSION;
import java.util.HashSet;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import java.util.Collections;
import android.content.ContentValues;
import java.util.List;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import com.google.android.gms.analytics.internal.Command;
import java.util.Collection;
import java.util.Map;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;

class PersistentAnalyticsStore implements AnalyticsStore
{
    private static final String CREATE_HITS_TABLE;
    private static final String DATABASE_FILENAME = "google_analytics_v2.db";
    @VisibleForTesting
    static final String HITS_TABLE = "hits2";
    @VisibleForTesting
    static final String HIT_APP_ID = "hit_app_id";
    @VisibleForTesting
    static final String HIT_ID = "hit_id";
    @VisibleForTesting
    static final String HIT_STRING = "hit_string";
    @VisibleForTesting
    static final String HIT_TIME = "hit_time";
    @VisibleForTesting
    static final String HIT_URL = "hit_url";
    private Clock mClock;
    private final Context mContext;
    private final String mDatabaseName;
    private final AnalyticsDatabaseHelper mDbHelper;
    private volatile Dispatcher mDispatcher;
    private long mLastDeleteStaleHitsTime;
    private final AnalyticsStoreStateListener mListener;
    
    static {
        CREATE_HITS_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id");
    }
    
    PersistentAnalyticsStore(final AnalyticsStoreStateListener analyticsStoreStateListener, final Context context) {
        this(analyticsStoreStateListener, context, "google_analytics_v2.db");
    }
    
    PersistentAnalyticsStore(final AnalyticsStoreStateListener mListener, final Context context, final String mDatabaseName) {
        this.mContext = context.getApplicationContext();
        this.mDatabaseName = mDatabaseName;
        this.mListener = mListener;
        this.mClock = new Clock() {
            @Override
            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }
        };
        this.mDbHelper = new AnalyticsDatabaseHelper(this.mContext, this.mDatabaseName);
        this.mDispatcher = new SimpleNetworkDispatcher((HttpClient)new DefaultHttpClient(), this.mContext);
        this.mLastDeleteStaleHitsTime = 0L;
    }
    
    private void fillVersionParameter(final Map<String, String> map, final Collection<Command> collection) {
        final String substring = "&_v".substring(1);
        if (collection != null) {
            for (final Command command : collection) {
                if ("appendVersion".equals(command.getId())) {
                    map.put(substring, command.getValue());
                    break;
                }
            }
        }
    }
    
    static String generateHitString(final Map<String, String> map) {
        final ArrayList<String> list = new ArrayList<String>(map.size());
        for (final Map.Entry<String, String> entry : map.entrySet()) {
            list.add(HitBuilder.encode(entry.getKey()) + "=" + HitBuilder.encode(entry.getValue()));
        }
        return TextUtils.join((CharSequence)"&", (Iterable)list);
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
    
    private void writeHitToDatabase(final Map<String, String> map, final long l, String s) {
        final SQLiteDatabase writableDatabase = this.getWritableDatabase("Error opening database for putHit");
        if (writableDatabase == null) {
            return;
        }
        final ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", generateHitString(map));
        contentValues.put("hit_time", l);
        long long1 = 0L;
        while (true) {
            if (!map.containsKey("AppUID")) {
                break Label_0082;
            }
            try {
                long1 = Long.parseLong(map.get("AppUID"));
                contentValues.put("hit_app_id", long1);
                if (s == null) {
                    s = "http://www.google-analytics.com/collect";
                }
                if (s.length() == 0) {
                    Log.w("Empty path: not sending hit");
                    return;
                }
                contentValues.put("hit_url", s);
                try {
                    writableDatabase.insert("hits2", (String)null, contentValues);
                    this.mListener.reportStoreIsEmpty(false);
                }
                catch (SQLiteException ex) {
                    Log.w("Error storing hit");
                }
            }
            catch (NumberFormatException ex2) {
                continue;
            }
            break;
        }
    }
    
    @Override
    public void clearHits(final long l) {
        int n = 1;
        final SQLiteDatabase writableDatabase = this.getWritableDatabase("Error opening database for clearHits");
        if (writableDatabase != null) {
            if (l == 0L) {
                writableDatabase.delete("hits2", (String)null, (String[])null);
            }
            else {
                final String[] array = new String[n];
                array[0] = Long.valueOf(l).toString();
                writableDatabase.delete("hits2", "hit_app_id = ?", array);
            }
            final AnalyticsStoreStateListener mListener = this.mListener;
            if (this.getNumStoredHits() != 0) {
                n = 0;
            }
            mListener.reportStoreIsEmpty(n != 0);
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
    
    @Deprecated
    void deleteHits(final Collection<Hit> collection) {
        if (collection == null || collection.isEmpty()) {
            Log.w("Empty/Null collection passed to deleteHits.");
            return;
        }
        final String[] array = new String[collection.size()];
        int n = 0;
        for (final Hit hit : collection) {
            final int n2 = n + 1;
            array[n] = String.valueOf(hit.getHitId());
            n = n2;
        }
        this.deleteHits(array);
    }
    
    void deleteHits(final String[] obj) {
        int n = 1;
        if (obj == null || obj.length == 0) {
            Log.w("Empty hitIds passed to deleteHits.");
        }
        else {
            final SQLiteDatabase writableDatabase = this.getWritableDatabase("Error opening database for deleteHits.");
            if (writableDatabase != null) {
                while (true) {
                    final Object[] args = new Object[n];
                    args[0] = TextUtils.join((CharSequence)",", (Iterable)Collections.nCopies(obj.length, "?"));
                    final String format = String.format("HIT_ID in (%s)", args);
                    while (true) {
                        try {
                            writableDatabase.delete("hits2", format, obj);
                            final AnalyticsStoreStateListener mListener = this.mListener;
                            if (this.getNumStoredHits() == 0) {
                                mListener.reportStoreIsEmpty(n != 0);
                                return;
                            }
                        }
                        catch (SQLiteException ex) {
                            Log.w("Error deleting hits " + obj);
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
                final int delete = writableDatabase.delete("hits2", "HIT_TIME < ?", array);
                final AnalyticsStoreStateListener mListener = this.mListener;
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
        Log.v("Dispatch running...");
        if (this.mDispatcher.okToDispatch()) {
            final List<Hit> peekHits = this.peekHits(40);
            if (peekHits.isEmpty()) {
                Log.v("...nothing to dispatch");
                this.mListener.reportStoreIsEmpty(true);
                return;
            }
            final int dispatchHits = this.mDispatcher.dispatchHits(peekHits);
            Log.v("sent " + dispatchHits + " of " + peekHits.size() + " hits");
            this.deleteHits(peekHits.subList(0, Math.min(dispatchHits, peekHits.size())));
            if (dispatchHits == peekHits.size() && this.getNumStoredHits() > 0) {
                GAServiceManager.getInstance().dispatchLocalHits();
            }
        }
    }
    
    @VisibleForTesting
    public AnalyticsDatabaseHelper getDbHelper() {
        return this.mDbHelper;
    }
    
    @Override
    public Dispatcher getDispatcher() {
        return this.mDispatcher;
    }
    
    @VisibleForTesting
    AnalyticsDatabaseHelper getHelper() {
        return this.mDbHelper;
    }
    
    int getNumStoredHits() {
        final SQLiteDatabase writableDatabase = this.getWritableDatabase("Error opening database for getNumStoredHits.");
        if (writableDatabase == null) {
            return 0;
        }
        Cursor rawQuery = null;
        try {
            rawQuery = writableDatabase.rawQuery("SELECT COUNT(*) from hits2", (String[])null);
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
                    query = writableDatabase.query("hits2", new String[] { "hit_id" }, (String)null, (String[])null, (String)null, (String)null, String.format("%s ASC", "hit_id"), Integer.toString(i));
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
        //    12: invokespecial   com/google/analytics/tracking/android/PersistentAnalyticsStore.getWritableDatabase:(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
        //    15: astore_3       
        //    16: aload_3        
        //    17: ifnonnull       22
        //    20: aload_2        
        //    21: areturn        
        //    22: aconst_null    
        //    23: astore          4
        //    25: aload_3        
        //    26: ldc             "hits2"
        //    28: iconst_2       
        //    29: anewarray       Ljava/lang/String;
        //    32: dup            
        //    33: iconst_0       
        //    34: ldc             "hit_id"
        //    36: aastore        
        //    37: dup            
        //    38: iconst_1       
        //    39: ldc             "hit_time"
        //    41: aastore        
        //    42: aconst_null    
        //    43: aconst_null    
        //    44: aconst_null    
        //    45: aconst_null    
        //    46: ldc_w           "%s ASC"
        //    49: iconst_1       
        //    50: anewarray       Ljava/lang/Object;
        //    53: dup            
        //    54: iconst_0       
        //    55: ldc             "hit_id"
        //    57: aastore        
        //    58: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //    61: iload_1        
        //    62: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //    65: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //    68: astore          4
        //    70: new             Ljava/util/ArrayList;
        //    73: dup            
        //    74: invokespecial   java/util/ArrayList.<init>:()V
        //    77: astore          7
        //    79: aload           4
        //    81: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    86: ifeq            135
        //    89: aload           7
        //    91: new             Lcom/google/analytics/tracking/android/Hit;
        //    94: dup            
        //    95: aconst_null    
        //    96: aload           4
        //    98: iconst_0       
        //    99: invokeinterface android/database/Cursor.getLong:(I)J
        //   104: aload           4
        //   106: iconst_1       
        //   107: invokeinterface android/database/Cursor.getLong:(I)J
        //   112: invokespecial   com/google/analytics/tracking/android/Hit.<init>:(Ljava/lang/String;JJ)V
        //   115: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   120: pop            
        //   121: aload           4
        //   123: invokeinterface android/database/Cursor.moveToNext:()Z
        //   128: istore          9
        //   130: iload           9
        //   132: ifne            89
        //   135: aload           4
        //   137: ifnull          147
        //   140: aload           4
        //   142: invokeinterface android/database/Cursor.close:()V
        //   147: aload_3        
        //   148: ldc             "hits2"
        //   150: iconst_3       
        //   151: anewarray       Ljava/lang/String;
        //   154: dup            
        //   155: iconst_0       
        //   156: ldc             "hit_id"
        //   158: aastore        
        //   159: dup            
        //   160: iconst_1       
        //   161: ldc             "hit_string"
        //   163: aastore        
        //   164: dup            
        //   165: iconst_2       
        //   166: ldc             "hit_url"
        //   168: aastore        
        //   169: aconst_null    
        //   170: aconst_null    
        //   171: aconst_null    
        //   172: aconst_null    
        //   173: ldc_w           "%s ASC"
        //   176: iconst_1       
        //   177: anewarray       Ljava/lang/Object;
        //   180: dup            
        //   181: iconst_0       
        //   182: ldc             "hit_id"
        //   184: aastore        
        //   185: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   188: iload_1        
        //   189: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //   192: invokevirtual   android/database/sqlite/SQLiteDatabase.query:(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   195: astore          4
        //   197: aload           4
        //   199: invokeinterface android/database/Cursor.moveToFirst:()Z
        //   204: istore          18
        //   206: iconst_0       
        //   207: istore          19
        //   209: iload           18
        //   211: ifeq            291
        //   214: aload           4
        //   216: checkcast       Landroid/database/sqlite/SQLiteCursor;
        //   219: invokevirtual   android/database/sqlite/SQLiteCursor.getWindow:()Landroid/database/CursorWindow;
        //   222: invokevirtual   android/database/CursorWindow.getNumRows:()I
        //   225: ifle            366
        //   228: aload           7
        //   230: iload           19
        //   232: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   237: checkcast       Lcom/google/analytics/tracking/android/Hit;
        //   240: aload           4
        //   242: iconst_1       
        //   243: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   248: invokevirtual   com/google/analytics/tracking/android/Hit.setHitString:(Ljava/lang/String;)V
        //   251: aload           7
        //   253: iload           19
        //   255: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   260: checkcast       Lcom/google/analytics/tracking/android/Hit;
        //   263: aload           4
        //   265: iconst_2       
        //   266: invokeinterface android/database/Cursor.getString:(I)Ljava/lang/String;
        //   271: invokevirtual   com/google/analytics/tracking/android/Hit.setHitUrl:(Ljava/lang/String;)V
        //   274: iinc            19, 1
        //   277: aload           4
        //   279: invokeinterface android/database/Cursor.moveToNext:()Z
        //   284: istore          21
        //   286: iload           21
        //   288: ifne            214
        //   291: aload           4
        //   293: ifnull          303
        //   296: aload           4
        //   298: invokeinterface android/database/Cursor.close:()V
        //   303: aload           7
        //   305: areturn        
        //   306: astore          6
        //   308: new             Ljava/lang/StringBuilder;
        //   311: dup            
        //   312: invokespecial   java/lang/StringBuilder.<init>:()V
        //   315: ldc_w           "Error in peekHits fetching hitIds: "
        //   318: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   321: aload           6
        //   323: invokevirtual   android/database/sqlite/SQLiteException.getMessage:()Ljava/lang/String;
        //   326: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   329: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   332: invokestatic    com/google/analytics/tracking/android/Log.w:(Ljava/lang/String;)V
        //   335: aload           4
        //   337: ifnull          347
        //   340: aload           4
        //   342: invokeinterface android/database/Cursor.close:()V
        //   347: aload_2        
        //   348: areturn        
        //   349: astore          5
        //   351: aload           4
        //   353: ifnull          363
        //   356: aload           4
        //   358: invokeinterface android/database/Cursor.close:()V
        //   363: aload           5
        //   365: athrow         
        //   366: iconst_1       
        //   367: anewarray       Ljava/lang/Object;
        //   370: astore          20
        //   372: aload           20
        //   374: iconst_0       
        //   375: aload           7
        //   377: iload           19
        //   379: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   384: checkcast       Lcom/google/analytics/tracking/android/Hit;
        //   387: invokevirtual   com/google/analytics/tracking/android/Hit.getHitId:()J
        //   390: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   393: aastore        
        //   394: ldc_w           "HitString for hitId %d too large.  Hit will be deleted."
        //   397: aload           20
        //   399: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   402: invokestatic    com/google/analytics/tracking/android/Log.w:(Ljava/lang/String;)V
        //   405: goto            274
        //   408: astore          11
        //   410: new             Ljava/lang/StringBuilder;
        //   413: dup            
        //   414: invokespecial   java/lang/StringBuilder.<init>:()V
        //   417: ldc_w           "Error in peekHits fetching hitString: "
        //   420: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   423: aload           11
        //   425: invokevirtual   android/database/sqlite/SQLiteException.getMessage:()Ljava/lang/String;
        //   428: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   431: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   434: invokestatic    com/google/analytics/tracking/android/Log.w:(Ljava/lang/String;)V
        //   437: new             Ljava/util/ArrayList;
        //   440: dup            
        //   441: invokespecial   java/util/ArrayList.<init>:()V
        //   444: astore          12
        //   446: iconst_0       
        //   447: istore          13
        //   449: aload           7
        //   451: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //   456: astore          14
        //   458: aload           14
        //   460: invokeinterface java/util/Iterator.hasNext:()Z
        //   465: ifeq            500
        //   468: aload           14
        //   470: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   475: checkcast       Lcom/google/analytics/tracking/android/Hit;
        //   478: astore          15
        //   480: aload           15
        //   482: invokevirtual   com/google/analytics/tracking/android/Hit.getHitParams:()Ljava/lang/String;
        //   485: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   488: istore          16
        //   490: iload           16
        //   492: ifeq            518
        //   495: iload           13
        //   497: ifeq            515
        //   500: aload           4
        //   502: ifnull          512
        //   505: aload           4
        //   507: invokeinterface android/database/Cursor.close:()V
        //   512: aload           12
        //   514: areturn        
        //   515: iconst_1       
        //   516: istore          13
        //   518: aload           12
        //   520: aload           15
        //   522: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   527: pop            
        //   528: goto            458
        //   531: astore          10
        //   533: aload           4
        //   535: ifnull          545
        //   538: aload           4
        //   540: invokeinterface android/database/Cursor.close:()V
        //   545: aload           10
        //   547: athrow         
        //   548: astore          5
        //   550: goto            351
        //   553: astore          6
        //   555: aload           7
        //   557: astore_2       
        //   558: goto            308
        //    Signature:
        //  (I)Ljava/util/List<Lcom/google/analytics/tracking/android/Hit;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  25     79     306    308    Landroid/database/sqlite/SQLiteException;
        //  25     79     349    351    Any
        //  79     89     553    561    Landroid/database/sqlite/SQLiteException;
        //  79     89     548    553    Any
        //  89     130    553    561    Landroid/database/sqlite/SQLiteException;
        //  89     130    548    553    Any
        //  147    206    408    531    Landroid/database/sqlite/SQLiteException;
        //  147    206    531    548    Any
        //  214    274    408    531    Landroid/database/sqlite/SQLiteException;
        //  214    274    531    548    Any
        //  277    286    408    531    Landroid/database/sqlite/SQLiteException;
        //  277    286    531    548    Any
        //  308    335    349    351    Any
        //  366    405    408    531    Landroid/database/sqlite/SQLiteException;
        //  366    405    531    548    Any
        //  410    446    531    548    Any
        //  449    458    531    548    Any
        //  458    490    531    548    Any
        //  518    528    531    548    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0089:
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
    public void putHit(final Map<String, String> map, final long n, final String s, final Collection<Command> collection) {
        this.deleteStaleHits();
        this.removeOldHitIfFull();
        this.fillVersionParameter(map, collection);
        this.writeHitToDatabase(map, n, s);
    }
    
    @VisibleForTesting
    public void setClock(final Clock mClock) {
        this.mClock = mClock;
    }
    
    @Override
    public void setDispatch(final boolean b) {
        Dispatcher mDispatcher;
        if (b) {
            mDispatcher = new SimpleNetworkDispatcher((HttpClient)new DefaultHttpClient(), this.mContext);
        }
        else {
            mDispatcher = new NoopDispatcher();
        }
        this.mDispatcher = mDispatcher;
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
    class AnalyticsDatabaseHelper extends SQLiteOpenHelper
    {
        private boolean mBadDatabase;
        private long mLastDatabaseCheckTime;
        
        AnalyticsDatabaseHelper(final Context context, final String s) {
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
            final boolean b = !set.remove("hit_app_id");
            if (!set.isEmpty()) {
                throw new SQLiteException("Database has extra columns");
            }
            if (b) {
                sqLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
            }
        }
        
        public SQLiteDatabase getWritableDatabase() {
            if (this.mBadDatabase && 3600000L + this.mLastDatabaseCheckTime > PersistentAnalyticsStore.this.mClock.currentTimeMillis()) {
                throw new SQLiteException("Database creation failed");
            }
            this.mBadDatabase = true;
            this.mLastDatabaseCheckTime = PersistentAnalyticsStore.this.mClock.currentTimeMillis();
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
                    PersistentAnalyticsStore.this.mContext.getDatabasePath(PersistentAnalyticsStore.this.mDatabaseName).delete();
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
                        if (!this.tablePresent("hits2", sqLiteDatabase)) {
                            sqLiteDatabase.execSQL(PersistentAnalyticsStore.CREATE_HITS_TABLE);
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
