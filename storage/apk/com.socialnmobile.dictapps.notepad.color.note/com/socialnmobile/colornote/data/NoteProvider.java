// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.data;

import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;
import android.database.SQLException;
import java.util.UUID;
import android.database.ContentObserver;
import android.os.Process;
import android.os.Binder;
import android.content.ContentUris;
import android.content.Context;
import android.database.MatrixCursor;
import android.database.Cursor;
import java.util.Iterator;
import java.util.Collection;
import java.util.Arrays;
import android.text.TextUtils;
import java.util.Map;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Handler;
import java.util.ArrayList;
import android.content.UriMatcher;
import java.util.HashMap;
import android.content.ContentProvider;

public class NoteProvider extends ContentProvider
{
    static kl a;
    static ki b;
    private static final String[] c;
    private static final String[] d;
    private static HashMap e;
    private static final UriMatcher f;
    private static NoteProvider i;
    private ArrayList g;
    private Handler h;
    
    static {
        c = new String[] { "_id", "suggest_text_1", "suggest_text_2", "suggest_intent_data", "suggest_shortcut_id", "suggest_spinner_while_refreshing" };
        d = new String[] { "_id", "title", "note", "encrypted" };
        (f = new UriMatcher(-1)).addURI("note.socialnmobile.provider.colornote", "notes", 1);
        NoteProvider.f.addURI("note.socialnmobile.provider.colornote", "notes/#", 2);
        NoteProvider.f.addURI("note.socialnmobile.provider.colornote", "notes/title/*", 6);
        NoteProvider.f.addURI("note.socialnmobile.provider.colornote", "counts", 5);
        NoteProvider.f.addURI("note.socialnmobile.provider.colornote", "search_suggest_query", 3);
        NoteProvider.f.addURI("note.socialnmobile.provider.colornote", "search_suggest_query/*", 3);
        NoteProvider.f.addURI("note.socialnmobile.provider.colornote", "search_suggest_shortcut", 4);
        NoteProvider.f.addURI("note.socialnmobile.provider.colornote", "search_suggest_shortcut/*", 4);
        NoteProvider.f.addURI("note.socialnmobile.provider.colornote", "tempnotes", 10);
        NoteProvider.f.addURI("note.socialnmobile.provider.colornote", "tempnotes/#", 11);
        NoteProvider.f.addURI("note.socialnmobile.provider.colornote", "tempnotes/title/*", 6);
        (NoteProvider.e = new HashMap()).put("_id", "_id");
        NoteProvider.e.put("active_state", "active_state");
        NoteProvider.e.put("account_id", "account_id");
        NoteProvider.e.put("folder_id", "folder_id");
        NoteProvider.e.put("status", "status");
        NoteProvider.e.put("space", "space");
        NoteProvider.e.put("type", "type");
        NoteProvider.e.put("title", "title");
        NoteProvider.e.put("note", "note");
        NoteProvider.e.put("note_ext", "note_ext");
        NoteProvider.e.put("note_type", "note_type");
        NoteProvider.e.put("tags", "tags");
        NoteProvider.e.put("importance", "importance");
        NoteProvider.e.put("created_date", "created_date");
        NoteProvider.e.put("modified_date", "modified_date");
        NoteProvider.e.put("minor_modified_date", "minor_modified_date");
        NoteProvider.e.put("reminder_date", "reminder_date");
        NoteProvider.e.put("reminder_base", "reminder_base");
        NoteProvider.e.put("reminder_last", "reminder_last");
        NoteProvider.e.put("reminder_duration", "reminder_duration");
        NoteProvider.e.put("reminder_type", "reminder_type");
        NoteProvider.e.put("reminder_option", "reminder_option");
        NoteProvider.e.put("reminder_repeat", "reminder_repeat");
        NoteProvider.e.put("reminder_repeat_ends", "reminder_repeat_ends");
        NoteProvider.e.put("latitude", "latitude");
        NoteProvider.e.put("longitude", "longitude");
        NoteProvider.e.put("color_index", "color_index");
        NoteProvider.e.put("encrypted", "encrypted");
        NoteProvider.e.put("revision", "revision");
    }
    
    public NoteProvider() {
        this.g = new ArrayList();
        this.h = new Handler();
    }
    
    public static int a(final Uri uri) {
        return NoteProvider.f.match(uri);
    }
    
    private static int a(final kj kj, final ContentValues contentValues, final String str, final String[] a) {
        final Long value = System.currentTimeMillis();
        contentValues.put("minor_modified_date", value);
        if (contentValues.containsKey("note") && !contentValues.containsKey("modified_date")) {
            contentValues.put("modified_date", value);
        }
        int i;
        if (contentValues.containsKey("modified_date")) {
            i = 3;
        }
        else {
            i = 2;
        }
        final ArrayList<Object> list = new ArrayList<Object>();
        final StringBuilder sb = new StringBuilder(240);
        sb.append("UPDATE ");
        sb.append("notes");
        sb.append(" SET ");
        final ArrayList<String> list2 = new ArrayList<String>();
        for (final Map.Entry<K, Object> entry : contentValues.valueSet()) {
            list2.add(String.valueOf(entry.getKey()) + "=?");
            list.add(entry.getValue());
        }
        list2.add("dirty=dirty|" + i);
        sb.append(TextUtils.join((CharSequence)", ", (Iterable)list2));
        if (!TextUtils.isEmpty((CharSequence)str)) {
            sb.append(" WHERE ");
            sb.append(str);
            if (a != null) {
                list.addAll(Arrays.asList(a));
            }
        }
        return kj.a(sb.toString(), list.toArray());
    }
    
    private static Cursor a(final kj kj, final String s) {
        String lowerCase;
        if (s == null) {
            lowerCase = "";
        }
        else {
            lowerCase = s.toLowerCase();
        }
        if (lowerCase.equals("")) {
            return null;
        }
        final Cursor a = kj.a("notes", NoteProvider.d, "active_state <> 32 AND active_state <> 256 AND (title like ? OR note like ? )", new String[] { "%" + lowerCase + "%", "%" + lowerCase + "%" }, "modified_date DESC");
        final MatrixCursor matrixCursor = new MatrixCursor(NoteProvider.c);
        for (int n = 0; a.moveToNext() && n < 15; ++n) {
            matrixCursor.addRow(a(a));
        }
        a.close();
        return (Cursor)matrixCursor;
    }
    
    public static NoteProvider a(final Context context) {
        if (NoteProvider.i == null) {
            c(context);
            context.getContentResolver().getType(kf.a);
            context.getContentResolver().query(kf.a, (String[])null, (String)null, (String[])null, (String)null);
        }
        return NoteProvider.i;
    }
    
    public static void a(final kj kj) {
        kj.a("CREATE TABLE notes (_id INTEGER PRIMARY KEY AUTOINCREMENT,active_state INTEGER DEFAULT 0,account_id INTEGER DEFAULT 0,folder_id INTEGER DEFAULT 0,status INTEGER DEFAULT 0,space INTEGER DEFAULT 0,type INTEGER NOT NULL,title TEXT NOT NULL COLLATE LOCALIZED,note TEXT NOT NULL ,note_ext TEXT DEFAULT '',note_type INTEGER NOT NULL,tags TEXT DEFAULT '',importance INTEGER DEFAULT 0,created_date INTEGER NOT NULL,modified_date INTEGER NOT NULL,minor_modified_date INTEGER DEFAULT 0,reminder_type INTEGER DEFAULT 0,reminder_option INTEGER DEFAULT 0,reminder_date INTEGER DEFAULT 0,reminder_base INTEGER DEFAULT 0,reminder_last INTEGER DEFAULT 0,reminder_duration INTEGER DEFAULT 0,reminder_repeat INTEGER DEFAULT 0,reminder_repeat_ends INTEGER DEFAULT 0,latitude DOUBLE DEFAULT 0,longitude DOUBLE DEFAULT 0,color_index INTEGER NOT NULL,encrypted INTEGER DEFAULT 0,dirty INTEGER DEFAULT 1,staged INTEGER DEFAULT 0,uuid TEXT,revision INTEGER DEFAULT 0);");
        kj.a("CREATE TABLE SyncAccount(_id INTEGER PRIMARY KEY NOT NULL,client_uuid TEXT,repository_built INTEGER DEFAULT 0 NOT NULL,base_revision INTEGER DEFAULT 0 NOT NULL,auth_token TEXT,email TEXT,colornote_id TEXT,fb_access TEXT,fb_user_name TEXT)");
    }
    
    private static Object[] a(final Cursor cursor) {
        int length = 60;
        final long long1 = cursor.getLong(cursor.getColumnIndex("_id"));
        final String value = String.valueOf(long1);
        final String string = cursor.getString(cursor.getColumnIndex("title"));
        String string2;
        if (cursor.getInt(cursor.getColumnIndex("encrypted")) == 0) {
            string2 = cursor.getString(cursor.getColumnIndex("note"));
        }
        else {
            string2 = "";
        }
        if (string2.length() < length) {
            length = string2.length();
        }
        return new String[] { value, string, string2.substring(0, length), ContentUris.withAppendedId(kf.a, long1).toString(), value, "true" };
    }
    
    private static Cursor b(final kj kj, final String s) {
        try {
            final long longValue = Long.valueOf(s);
            final MatrixCursor matrixCursor = new MatrixCursor(NoteProvider.c);
            final Cursor a = kj.a("notes", NoteProvider.d, "_id = ?", new String[] { String.valueOf(longValue) }, null);
            final boolean moveToNext = a.moveToNext();
            Cursor cursor = null;
            if (moveToNext) {
                matrixCursor.addRow(a(a));
                cursor = (Cursor)matrixCursor;
            }
            a.close();
            return cursor;
        }
        catch (NumberFormatException ex) {
            return null;
        }
    }
    
    public static ki b(final Context context) {
        if (NoteProvider.a == null) {
            c(context);
        }
        return NoteProvider.b;
    }
    
    public static void b(final kj kj) {
        kj.a("CREATE INDEX idx_note1 ON notes(active_state,account_id,folder_id,space)");
        kj.a("CREATE INDEX idx_note2 ON notes(reminder_type,reminder_date)");
        kj.a("CREATE INDEX idx_note3 ON notes(reminder_repeat,reminder_base)");
        kj.a("CREATE INDEX idx_note4 ON notes(title)");
        kj.a("CREATE INDEX idx_note_s1 ON notes(dirty)");
        kj.a("CREATE INDEX idx_note_s2 ON notes(staged)");
    }
    
    public static void c() {
        if (NoteProvider.a != null) {
            NoteProvider.a.close();
            NoteProvider.a = null;
        }
    }
    
    private static void c(final Context context) {
        if (NoteProvider.a == null) {
            NoteProvider.a = new kl(context.getApplicationContext(), "colornote.db");
            NoteProvider.b = new ki(NoteProvider.a);
        }
    }
    
    public static void c(final kj kj) {
        kj.a("DROP TABLE IF EXISTS notes;");
        kj.a("DROP TABLE IF EXISTS SyncAccount;");
        a(kj);
        b(kj);
    }
    
    public final void a() {
        this.h.post((Runnable)new kk(this));
    }
    
    public final void a(final km e) {
        synchronized (this.g) {
            this.g.add(e);
        }
    }
    
    public final void b() {
        c(this.getContext());
        this.a();
    }
    
    public final void b(final km o) {
        synchronized (this.g) {
            this.g.remove(o);
        }
    }
    
    public int delete(final Uri obj, final String str, final String[] array) {
        if (Binder.getCallingUid() != Process.myUid() && this.getContext().checkCallingPermission("android.permission.GLOBAL_SEARCH") == -1) {
            return 0;
        }
        ki.a();
        while (true) {
            kj f = null;
            Label_0126: {
                try {
                    f = NoteProvider.b.f();
                    switch (NoteProvider.f.match(obj)) {
                        default: {
                            throw new IllegalArgumentException("Unknown URI " + obj);
                        }
                        case 1: {
                            break;
                        }
                        case 2: {
                            break Label_0126;
                        }
                    }
                }
                finally {
                    ki.b();
                }
                final int n = f.a("notes", str, array);
                this.getContext().getContentResolver().notifyChange(obj, (ContentObserver)null);
                ki.b();
                return n;
            }
            final StringBuilder append = new StringBuilder("_id=").append(obj.getPathSegments().get(1));
            String string;
            if (!TextUtils.isEmpty((CharSequence)str)) {
                string = " AND (" + str + ')';
            }
            else {
                string = "";
            }
            final int n = f.a("notes", append.append(string).toString(), array);
            continue;
        }
    }
    
    public String getType(final Uri obj) {
        switch (NoteProvider.f.match(obj)) {
            default: {
                throw new IllegalArgumentException("Unknown URI " + obj);
            }
            case 1:
            case 10: {
                return "vnd.android.cursor.dir/vnd.socialnmobile.colornote.note";
            }
            case 2:
            case 11: {
                return "vnd.android.cursor.item/vnd.socialnmobile.colornote.note";
            }
            case 6:
            case 12: {
                return "vnd.android.cursor.item/vnd.socialnmobile.colornote.note.title";
            }
            case 3: {
                return "vnd.android.cursor.dir/vnd.android.search.suggest";
            }
            case 4: {
                return "vnd.android.cursor.item/vnd.android.search.suggest";
            }
        }
    }
    
    public Uri insert(final Uri uri, final ContentValues contentValues) {
        if (Binder.getCallingUid() != Process.myUid() && this.getContext().checkCallingPermission("android.permission.GLOBAL_SEARCH") == -1) {
            return null;
        }
        ki.a();
        kj f;
        try {
            f = NoteProvider.b.f();
            if (NoteProvider.f.match(uri) != 1) {
                throw new IllegalArgumentException("Unknown URI " + uri);
            }
        }
        finally {
            ki.b();
        }
        ContentValues contentValues2;
        if (contentValues != null) {
            contentValues2 = new ContentValues(contentValues);
        }
        else {
            contentValues2 = new ContentValues();
        }
        final Long value = System.currentTimeMillis();
        if (!contentValues2.containsKey("created_date")) {
            contentValues2.put("created_date", value);
        }
        if (!contentValues2.containsKey("modified_date")) {
            contentValues2.put("modified_date", value);
        }
        contentValues2.put("minor_modified_date", value);
        contentValues2.put("dirty", 3);
        contentValues2.put("uuid", UUID.randomUUID().toString());
        contentValues2.put("revision", 0);
        if (!contentValues2.containsKey("title")) {
            contentValues2.put("title", "");
        }
        if (!contentValues2.containsKey("note")) {
            contentValues2.put("note", "");
        }
        final long a = f.a("notes", "note", contentValues2);
        if (a > 0L) {
            final Uri withAppendedId = ContentUris.withAppendedId(kf.a, a);
            this.getContext().getContentResolver().notifyChange(withAppendedId, (ContentObserver)null);
            ki.b();
            return withAppendedId;
        }
        throw new SQLException("Failed to insert row into " + uri);
    }
    
    public boolean onCreate() {
        (NoteProvider.i = this).b();
        Log.i("NoteProvider", "databasePath=" + this.getContext().getDatabasePath("colornote.db"));
        return true;
    }
    
    public Cursor query(final Uri obj, final String[] array, final String str, final String[] array2, final String s) {
        String string = null;
        if (Binder.getCallingUid() != Process.myUid() && this.getContext().checkCallingPermission("android.permission.GLOBAL_SEARCH") == -1) {
            return null;
        }
        ki.a();
        Label_0482: {
            Label_0430: {
                while (true) {
                    SQLiteQueryBuilder sqLiteQueryBuilder = null;
                    Label_0374: {
                        Label_0356: {
                            Label_0320: {
                                Label_0262: {
                                    Label_0210: {
                                        try {
                                            sqLiteQueryBuilder = new SQLiteQueryBuilder();
                                            sqLiteQueryBuilder.setTables("notes");
                                            sqLiteQueryBuilder.setProjectionMap((Map)NoteProvider.e);
                                            switch (NoteProvider.f.match(obj)) {
                                                default: {
                                                    throw new IllegalArgumentException("Unknown URI " + obj);
                                                }
                                                case 1: {
                                                    break;
                                                }
                                                case 2: {
                                                    break Label_0210;
                                                }
                                                case 6: {
                                                    break Label_0262;
                                                }
                                                case 5: {
                                                    break Label_0320;
                                                }
                                                case 10: {
                                                    break Label_0356;
                                                }
                                                case 11: {
                                                    break Label_0374;
                                                }
                                                case 3: {
                                                    break Label_0430;
                                                }
                                                case 4: {
                                                    break Label_0482;
                                                }
                                            }
                                        }
                                        finally {
                                            ki.b();
                                        }
                                        final kj kj = NoteProvider.b.e();
                                        String s2;
                                        if (TextUtils.isEmpty((CharSequence)s)) {
                                            s2 = "modified_date DESC";
                                        }
                                        else {
                                            s2 = s;
                                        }
                                        Cursor cursor;
                                        if (string != null) {
                                            cursor = kj.a(string, null);
                                        }
                                        else {
                                            cursor = sqLiteQueryBuilder.query(kj.a, array, str, array2, (String)null, (String)null, s2);
                                        }
                                        cursor.setNotificationUri(this.getContext().getContentResolver(), obj);
                                        ki.b();
                                        return cursor;
                                    }
                                    final kj e = NoteProvider.b.e();
                                    sqLiteQueryBuilder.appendWhere((CharSequence)("_id=" + obj.getPathSegments().get(1)));
                                    final kj kj = e;
                                    string = null;
                                    continue;
                                }
                                final kj e2 = NoteProvider.b.e();
                                sqLiteQueryBuilder.appendWhere((CharSequence)("title = '" + obj.getPathSegments().get(2) + "'"));
                                final kj kj = e2;
                                string = null;
                                continue;
                            }
                            final kj kj = NoteProvider.b.e();
                            string = "SELECT count(*) as notes_count,color_index from notes where " + str + " group by color_index";
                            continue;
                        }
                        final kj kj = kt.a(this.getContext()).b();
                        string = null;
                        continue;
                    }
                    final kj b = kt.a(this.getContext()).b();
                    sqLiteQueryBuilder.appendWhere((CharSequence)("_id=" + obj.getPathSegments().get(1)));
                    final kj kj = b;
                    string = null;
                    continue;
                }
            }
            final kj e3 = NoteProvider.b.e();
            final int size = obj.getPathSegments().size();
            String lowerCase = null;
            if (size > 1) {
                lowerCase = obj.getLastPathSegment().toLowerCase();
            }
            final Cursor a = a(e3, lowerCase);
            ki.b();
            return a;
        }
        final kj e4 = NoteProvider.b.e();
        final int size2 = obj.getPathSegments().size();
        String lastPathSegment = null;
        if (size2 > 1) {
            lastPathSegment = obj.getLastPathSegment();
        }
        final Cursor b2 = b(e4, lastPathSegment);
        ki.b();
        return b2;
    }
    
    public int update(final Uri obj, final ContentValues contentValues, final String str, final String[] array) {
        if (Binder.getCallingUid() != Process.myUid() && this.getContext().checkCallingPermission("android.permission.GLOBAL_SEARCH") == -1) {
            return 0;
        }
        ki.a();
        while (true) {
            kj f = null;
            Label_0126: {
                try {
                    f = NoteProvider.b.f();
                    switch (NoteProvider.f.match(obj)) {
                        default: {
                            throw new IllegalArgumentException("Unknown URI " + obj);
                        }
                        case 1: {
                            break;
                        }
                        case 2: {
                            break Label_0126;
                        }
                    }
                }
                finally {
                    ki.b();
                }
                final int n = a(f, contentValues, str, array);
                this.getContext().getContentResolver().notifyChange(obj, (ContentObserver)null);
                ki.b();
                return n;
            }
            final StringBuilder append = new StringBuilder("_id=").append(obj.getPathSegments().get(1));
            String string;
            if (!TextUtils.isEmpty((CharSequence)str)) {
                string = " AND (" + str + ')';
            }
            else {
                string = "";
            }
            final int n = a(f, contentValues, append.append(string).toString(), array);
            continue;
        }
    }
}
