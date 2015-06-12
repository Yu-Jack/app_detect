// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.database.sqlite.SQLiteException;
import java.util.List;
import android.os.SystemClock;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

public class cx$a extends SQLiteOpenHelper
{
    final /* synthetic */ cx pu;
    
    public cx$a(final cx pu, final Context context, final String s) {
        this.pu = pu;
        super(context, s, (SQLiteDatabase$CursorFactory)null, 4);
    }
    
    public void onCreate(final SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(cx.pr);
    }
    
    public void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int i, final int j) {
        eu.B("Database updated from version " + i + " to version " + j);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
        this.onCreate(sqLiteDatabase);
    }
}
