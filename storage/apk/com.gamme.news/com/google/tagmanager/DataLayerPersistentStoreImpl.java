// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.os.Build$VERSION;
import java.util.HashSet;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import com.google.android.gms.common.util.VisibleForTesting;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import java.util.Iterator;
import java.util.ArrayList;
import android.database.Cursor;
import java.util.Arrays;
import android.text.TextUtils;
import java.util.Collections;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Executor;
import android.content.Context;

class DataLayerPersistentStoreImpl implements PersistentStore
{
    private static final String CREATE_MAPS_TABLE;
    private static final String DATABASE_NAME = "google_tagmanager.db";
    private static final String EXPIRE_FIELD = "expires";
    private static final String ID_FIELD = "ID";
    private static final String KEY_FIELD = "key";
    private static final String MAPS_TABLE = "datalayer";
    private static final int MAX_NUM_STORED_ITEMS = 2000;
    private static final String VALUE_FIELD = "value";
    private Clock mClock;
    private final Context mContext;
    private DatabaseHelper mDbHelper;
    private final Executor mExecutor;
    private int mMaxNumStoredItems;
    
    static {
        CREATE_MAPS_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", "datalayer", "ID", "key", "value", "expires");
    }
    
    public DataLayerPersistentStoreImpl(final Context context) {
        this(context, new Clock() {
            @Override
            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }
        }, "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }
    
    DataLayerPersistentStoreImpl(final Context mContext, final Clock mClock, final String s, final int mMaxNumStoredItems, final Executor mExecutor) {
        this.mContext = mContext;
        this.mClock = mClock;
        this.mMaxNumStoredItems = mMaxNumStoredItems;
        this.mExecutor = mExecutor;
        this.mDbHelper = new DatabaseHelper(this.mContext, s);
    }
    
    private void clearKeysWithPrefixSingleThreaded(final String s) {
        final SQLiteDatabase writableDatabase = this.getWritableDatabase("Error opening database for clearKeysWithPrefix.");
        if (writableDatabase == null) {
            return;
        }
        try {
            Log.v("Cleared " + writableDatabase.delete("datalayer", "key = ? OR key LIKE ?", new String[] { s, s + ".%" }) + " items");
        }
        catch (SQLiteException obj) {
            Log.w("Error deleting entries with key prefix: " + s + " (" + obj + ").");
        }
        finally {
            this.closeDatabaseConnection();
        }
    }
    
    private void closeDatabaseConnection() {
        try {
            this.mDbHelper.close();
        }
        catch (SQLiteException ex) {}
    }
    
    private void deleteEntries(final String[] a) {
        if (a != null && a.length != 0) {
            final SQLiteDatabase writableDatabase = this.getWritableDatabase("Error opening database for deleteEntries.");
            if (writableDatabase != null) {
                final String format = String.format("%s in (%s)", "ID", TextUtils.join((CharSequence)",", (Iterable)Collections.nCopies(a.length, "?")));
                try {
                    writableDatabase.delete("datalayer", format, a);
                }
                catch (SQLiteException ex) {
                    Log.w("Error deleting entries " + Arrays.toString(a));
                }
            }
        }
    }
    
    private void deleteEntriesOlderThan(final long i) {
        final SQLiteDatabase writableDatabase = this.getWritableDatabase("Error opening database for deleteOlderThan.");
        if (writableDatabase == null) {
            return;
        }
        try {
            Log.v("Deleted " + writableDatabase.delete("datalayer", "expires <= ?", new String[] { Long.toString(i) }) + " expired items");
        }
        catch (SQLiteException ex) {
            Log.w("Error deleting old entries.");
        }
    }
    
    private int getNumStoredEntries() {
        final SQLiteDatabase writableDatabase = this.getWritableDatabase("Error opening database for getNumStoredEntries.");
        if (writableDatabase == null) {
            return 0;
        }
        Cursor rawQuery = null;
        try {
            rawQuery = writableDatabase.rawQuery("SELECT COUNT(*) from datalayer", (String[])null);
            final boolean moveToFirst = rawQuery.moveToFirst();
            int n = 0;
            if (moveToFirst) {
                n = (int)rawQuery.getLong(0);
            }
            return n;
        }
        catch (SQLiteException ex) {
            Log.w("Error getting numStoredEntries");
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
    
    private SQLiteDatabase getWritableDatabase(final String s) {
        try {
            return this.mDbHelper.getWritableDatabase();
        }
        catch (SQLiteException ex) {
            Log.w(s);
            return null;
        }
    }
    
    private List<KeyAndSerialized> loadSerialized() {
        final SQLiteDatabase writableDatabase = this.getWritableDatabase("Error opening database for loadSerialized.");
        final ArrayList<KeyAndSerialized> list = new ArrayList<KeyAndSerialized>();
        if (writableDatabase == null) {
            return list;
        }
        final Cursor query = writableDatabase.query("datalayer", new String[] { "key", "value" }, (String)null, (String[])null, (String)null, (String)null, "ID", (String)null);
        try {
            while (query.moveToNext()) {
                list.add(new KeyAndSerialized(query.getString(0), query.getBlob(1)));
            }
        }
        finally {
            query.close();
        }
        query.close();
        return list;
    }
    
    private List<KeyValue> loadSingleThreaded() {
        try {
            this.deleteEntriesOlderThan(this.mClock.currentTimeMillis());
            return this.unserializeValues(this.loadSerialized());
        }
        finally {
            this.closeDatabaseConnection();
        }
    }
    
    private void makeRoomForEntries(final int n) {
        final int n2 = n + (this.getNumStoredEntries() - this.mMaxNumStoredItems);
        if (n2 > 0) {
            final List<String> peekEntryIds = this.peekEntryIds(n2);
            Log.i("DataLayer store full, deleting " + peekEntryIds.size() + " entries to make room.");
            this.deleteEntries(peekEntryIds.toArray(new String[0]));
        }
    }
    
    private List<String> peekEntryIds(final int i) {
        final ArrayList<String> list = new ArrayList<String>();
        if (i <= 0) {
            Log.w("Invalid maxEntries specified. Skipping.");
        }
        else {
            final SQLiteDatabase writableDatabase = this.getWritableDatabase("Error opening database for peekEntryIds.");
            if (writableDatabase != null) {
                Cursor query = null;
                try {
                    query = writableDatabase.query("datalayer", new String[] { "ID" }, (String)null, (String[])null, (String)null, (String)null, String.format("%s ASC", "ID"), Integer.toString(i));
                    if (query.moveToFirst()) {
                        do {
                            list.add(String.valueOf(query.getLong(0)));
                        } while (query.moveToNext());
                    }
                    return list;
                }
                catch (SQLiteException ex) {
                    Log.w("Error in peekEntries fetching entryIds: " + ex.getMessage());
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
    
    private void saveSingleThreaded(final List<KeyAndSerialized> list, final long n) {
        // monitorenter(this)
        try {
            final long currentTimeMillis = this.mClock.currentTimeMillis();
            this.deleteEntriesOlderThan(currentTimeMillis);
            this.makeRoomForEntries(list.size());
            this.writeEntriesToDatabase(list, currentTimeMillis + n);
            return;
        }
        finally {
            this.closeDatabaseConnection();
        }
        try {}
        finally {
        }
        // monitorexit(this)
    }
    
    private byte[] serialize(final Object p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Ljava/io/ByteArrayOutputStream;
        //     3: dup            
        //     4: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //     7: astore_2       
        //     8: aconst_null    
        //     9: astore_3       
        //    10: new             Ljava/io/ObjectOutputStream;
        //    13: dup            
        //    14: aload_2        
        //    15: invokespecial   java/io/ObjectOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    18: astore          4
        //    20: aload           4
        //    22: aload_1        
        //    23: invokevirtual   java/io/ObjectOutputStream.writeObject:(Ljava/lang/Object;)V
        //    26: aload_2        
        //    27: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //    30: astore          9
        //    32: aload           4
        //    34: ifnull          42
        //    37: aload           4
        //    39: invokevirtual   java/io/ObjectOutputStream.close:()V
        //    42: aload_2        
        //    43: invokevirtual   java/io/ByteArrayOutputStream.close:()V
        //    46: aload           9
        //    48: areturn        
        //    49: astore          11
        //    51: aload_3        
        //    52: ifnull          59
        //    55: aload_3        
        //    56: invokevirtual   java/io/ObjectOutputStream.close:()V
        //    59: aload_2        
        //    60: invokevirtual   java/io/ByteArrayOutputStream.close:()V
        //    63: aconst_null    
        //    64: areturn        
        //    65: astore          6
        //    67: aconst_null    
        //    68: areturn        
        //    69: astore          7
        //    71: aload_3        
        //    72: ifnull          79
        //    75: aload_3        
        //    76: invokevirtual   java/io/ObjectOutputStream.close:()V
        //    79: aload_2        
        //    80: invokevirtual   java/io/ByteArrayOutputStream.close:()V
        //    83: aload           7
        //    85: athrow         
        //    86: astore          8
        //    88: goto            83
        //    91: astore          7
        //    93: aload           4
        //    95: astore_3       
        //    96: goto            71
        //    99: astore          5
        //   101: aload           4
        //   103: astore_3       
        //   104: goto            51
        //   107: astore          10
        //   109: goto            46
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  10     20     49     51     Ljava/io/IOException;
        //  10     20     69     71     Any
        //  20     32     99     107    Ljava/io/IOException;
        //  20     32     91     99     Any
        //  37     42     107    112    Ljava/io/IOException;
        //  42     46     107    112    Ljava/io/IOException;
        //  55     59     65     69     Ljava/io/IOException;
        //  59     63     65     69     Ljava/io/IOException;
        //  75     79     86     91     Ljava/io/IOException;
        //  79     83     86     91     Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 58, Size: 58
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
    
    private List<KeyAndSerialized> serializeValues(final List<KeyValue> list) {
        final ArrayList<KeyAndSerialized> list2 = new ArrayList<KeyAndSerialized>();
        for (final KeyValue keyValue : list) {
            list2.add(new KeyAndSerialized(keyValue.mKey, this.serialize(keyValue.mValue)));
        }
        return list2;
    }
    
    private Object unserialize(final byte[] p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Ljava/io/ByteArrayInputStream;
        //     3: dup            
        //     4: aload_1        
        //     5: invokespecial   java/io/ByteArrayInputStream.<init>:([B)V
        //     8: astore_2       
        //     9: aconst_null    
        //    10: astore_3       
        //    11: new             Ljava/io/ObjectInputStream;
        //    14: dup            
        //    15: aload_2        
        //    16: invokespecial   java/io/ObjectInputStream.<init>:(Ljava/io/InputStream;)V
        //    19: astore          4
        //    21: aload           4
        //    23: invokevirtual   java/io/ObjectInputStream.readObject:()Ljava/lang/Object;
        //    26: astore          11
        //    28: aload           4
        //    30: ifnull          38
        //    33: aload           4
        //    35: invokevirtual   java/io/ObjectInputStream.close:()V
        //    38: aload_2        
        //    39: invokevirtual   java/io/ByteArrayInputStream.close:()V
        //    42: aload           11
        //    44: areturn        
        //    45: astore          14
        //    47: aload_3        
        //    48: ifnull          55
        //    51: aload_3        
        //    52: invokevirtual   java/io/ObjectInputStream.close:()V
        //    55: aload_2        
        //    56: invokevirtual   java/io/ByteArrayInputStream.close:()V
        //    59: aconst_null    
        //    60: areturn        
        //    61: astore          6
        //    63: aconst_null    
        //    64: areturn        
        //    65: astore          13
        //    67: aload_3        
        //    68: ifnull          75
        //    71: aload_3        
        //    72: invokevirtual   java/io/ObjectInputStream.close:()V
        //    75: aload_2        
        //    76: invokevirtual   java/io/ByteArrayInputStream.close:()V
        //    79: aconst_null    
        //    80: areturn        
        //    81: astore          8
        //    83: aconst_null    
        //    84: areturn        
        //    85: astore          9
        //    87: aload_3        
        //    88: ifnull          95
        //    91: aload_3        
        //    92: invokevirtual   java/io/ObjectInputStream.close:()V
        //    95: aload_2        
        //    96: invokevirtual   java/io/ByteArrayInputStream.close:()V
        //    99: aload           9
        //   101: athrow         
        //   102: astore          10
        //   104: goto            99
        //   107: astore          9
        //   109: aload           4
        //   111: astore_3       
        //   112: goto            87
        //   115: astore          7
        //   117: aload           4
        //   119: astore_3       
        //   120: goto            67
        //   123: astore          5
        //   125: aload           4
        //   127: astore_3       
        //   128: goto            47
        //   131: astore          12
        //   133: goto            42
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                              
        //  -----  -----  -----  -----  ----------------------------------
        //  11     21     45     47     Ljava/io/IOException;
        //  11     21     65     67     Ljava/lang/ClassNotFoundException;
        //  11     21     85     87     Any
        //  21     28     123    131    Ljava/io/IOException;
        //  21     28     115    123    Ljava/lang/ClassNotFoundException;
        //  21     28     107    115    Any
        //  33     38     131    136    Ljava/io/IOException;
        //  38     42     131    136    Ljava/io/IOException;
        //  51     55     61     65     Ljava/io/IOException;
        //  55     59     61     65     Ljava/io/IOException;
        //  71     75     81     85     Ljava/io/IOException;
        //  75     79     81     85     Ljava/io/IOException;
        //  91     95     102    107    Ljava/io/IOException;
        //  95     99     102    107    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 72, Size: 72
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
    
    private List<KeyValue> unserializeValues(final List<KeyAndSerialized> list) {
        final ArrayList<KeyValue> list2 = new ArrayList<KeyValue>();
        for (final KeyAndSerialized keyAndSerialized : list) {
            list2.add(new DataLayer.KeyValue(keyAndSerialized.mKey, this.unserialize(keyAndSerialized.mSerialized)));
        }
        return list2;
    }
    
    private void writeEntriesToDatabase(final List<KeyAndSerialized> list, final long l) {
        final SQLiteDatabase writableDatabase = this.getWritableDatabase("Error opening database for writeEntryToDatabase.");
        if (writableDatabase != null) {
            for (final KeyAndSerialized keyAndSerialized : list) {
                final ContentValues contentValues = new ContentValues();
                contentValues.put("expires", l);
                contentValues.put("key", keyAndSerialized.mKey);
                contentValues.put("value", keyAndSerialized.mSerialized);
                writableDatabase.insert("datalayer", (String)null, contentValues);
            }
        }
    }
    
    @Override
    public void clearKeysWithPrefix(final String s) {
        this.mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                DataLayerPersistentStoreImpl.this.clearKeysWithPrefixSingleThreaded(s);
            }
        });
    }
    
    @Override
    public void loadSaved(final Callback callback) {
        this.mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                callback.onKeyValuesLoaded(DataLayerPersistentStoreImpl.this.loadSingleThreaded());
            }
        });
    }
    
    @Override
    public void saveKeyValues(final List<KeyValue> list, final long n) {
        this.mExecutor.execute(new Runnable() {
            final /* synthetic */ List val$serializedKeysAndValues = DataLayerPersistentStoreImpl.this.serializeValues(list);
            
            @Override
            public void run() {
                DataLayerPersistentStoreImpl.this.saveSingleThreaded(this.val$serializedKeysAndValues, n);
            }
        });
    }
    
    @VisibleForTesting
    class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(final Context context, final String s) {
            super(context, s, (SQLiteDatabase$CursorFactory)null, 1);
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
            final Cursor rawQuery = sqLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", (String[])null);
            final HashSet<String> set = new HashSet<String>();
            try {
                final String[] columnNames = rawQuery.getColumnNames();
                for (int i = 0; i < columnNames.length; ++i) {
                    set.add(columnNames[i]);
                }
                rawQuery.close();
                if (!set.remove("key") || !set.remove("value") || !set.remove("ID") || !set.remove("expires")) {
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
            while (true) {
                try {
                    SQLiteDatabase sqLiteDatabase = super.getWritableDatabase();
                    if (sqLiteDatabase == null) {
                        sqLiteDatabase = super.getWritableDatabase();
                    }
                    return sqLiteDatabase;
                }
                catch (SQLiteException ex) {
                    DataLayerPersistentStoreImpl.this.mContext.getDatabasePath("google_tagmanager.db").delete();
                    final SQLiteDatabase sqLiteDatabase = null;
                    continue;
                }
                break;
            }
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
                        if (!this.tablePresent("datalayer", sqLiteDatabase)) {
                            sqLiteDatabase.execSQL(DataLayerPersistentStoreImpl.CREATE_MAPS_TABLE);
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
    }
    
    private static class KeyAndSerialized
    {
        final String mKey;
        final byte[] mSerialized;
        
        KeyAndSerialized(final String mKey, final byte[] mSerialized) {
            this.mKey = mKey;
            this.mSerialized = mSerialized;
        }
        
        @Override
        public String toString() {
            return "KeyAndSerialized: key = " + this.mKey + " serialized hash = " + Arrays.hashCode(this.mSerialized);
        }
    }
}
