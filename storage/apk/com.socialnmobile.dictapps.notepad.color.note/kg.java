import com.socialnmobile.colornote.data.NoteColumns;
import android.database.sqlite.SQLiteDatabase;
import android.database.ContentObserver;
import com.socialnmobile.colornote.data.NoteProvider;
import android.text.format.Time;
import java.util.Iterator;
import java.util.ArrayList;
import com.socialnmobile.colornote.ColorNote;
import android.content.ContentUris;
import java.util.HashMap;
import android.net.Uri;
import android.content.ContentValues;
import android.database.Cursor;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class kg
{
    public static int a(final int n, final int n2, final int n3) {
        return (n & ~n3) | (n2 & n3);
    }
    
    public static int a(final Context context) {
        final Cursor query = context.getContentResolver().query(kf.a, (String[])null, "active_state = 0", (String[])null, (String)null);
        if (query == null) {
            return -1;
        }
        final int count = query.getCount();
        query.close();
        return count;
    }
    
    public static ContentValues a() {
        final ContentValues contentValues = new ContentValues();
        contentValues.put("active_state", 32);
        contentValues.put("title", "");
        contentValues.put("note", "");
        contentValues.put("note_ext", "");
        contentValues.put("encrypted", 0);
        contentValues.put("reminder_date", 0);
        contentValues.put("reminder_base", 0);
        contentValues.put("reminder_last", 0);
        contentValues.put("reminder_repeat", 0);
        contentValues.put("reminder_type", 0);
        contentValues.put("reminder_duration", 0);
        contentValues.put("reminder_option", 0);
        return contentValues;
    }
    
    public static Cursor a(final Context context, final long n) {
        return context.getContentResolver().query(kf.a, (String[])null, "reminder_type = 16 AND reminder_date = " + gw.a(n) + " AND active_state = 0", (String[])null, "color_index ASC, reminder_repeat DESC, modified_date DESC");
    }
    
    public static Cursor a(final Context context, final String s) {
        return context.getContentResolver().query(kf.a, (String[])null, "active_state = ? AND account_id = 0 AND folder_id = ? AND type = ? AND title = ?", new String[] { String.valueOf(256), String.valueOf(256), String.valueOf(256), s }, "created_date asc");
    }
    
    public static Cursor a(final Context context, final boolean b, final int n, final int n2, final int i, final int j, final int k, final int l) {
        String s = "active_state = 0 AND account_id = 0";
        if (k != -1) {
            s = String.valueOf(s) + " AND " + ("folder_id = " + k);
        }
        if (l != -1) {
            s = String.valueOf(s) + " AND " + ("space = " + l);
        }
        if (n2 == 1) {
            s = String.valueOf(s) + " AND " + ("color_index = " + i);
        }
        if (j != -1) {
            s = String.valueOf(s) + " AND " + ("type = " + j);
        }
        String s2 = null;
        Label_0259: {
            switch (n) {
                case 1: {
                    s2 = "modified_date DESC";
                    break Label_0259;
                }
                case 5: {
                    s2 = "created_date DESC";
                    break Label_0259;
                }
                case 2: {
                    s2 = "title ASC";
                    break Label_0259;
                }
                case 3: {
                    final int intValue = Integer.valueOf(jp.a(context, "pref_sort_order_in_color", context.getString(2131230724)));
                    if (intValue == 2) {
                        s2 = "color_index ASC, title ASC";
                        break Label_0259;
                    }
                    if (intValue == 1) {
                        s2 = "color_index ASC, modified_date DESC";
                        break Label_0259;
                    }
                    break;
                }
                case 4: {
                    s = String.valueOf(s) + " AND reminder_date > 0";
                    s2 = null;
                    break Label_0259;
                }
                case 7: {
                    s2 = "reminder_last DESC";
                    s = String.valueOf(s) + " AND reminder_last > 0";
                    break Label_0259;
                }
            }
            s2 = null;
        }
        if (b) {
            return context.getContentResolver().query(kf.d, (String[])null, s, (String[])null, s2);
        }
        return context.getContentResolver().query(kf.a, (String[])null, s, (String[])null, s2);
    }
    
    public static Uri a(final Context context, final int i, final int j, final int k, final int l, final String s, final String s2) {
        new HashMap();
        final ContentValues contentValues = new ContentValues();
        contentValues.put("active_state", i);
        contentValues.put("status", 0);
        contentValues.put("type", j);
        contentValues.put("folder_id", k);
        contentValues.put("note_type", 0);
        contentValues.put("color_index", l);
        if (s != null) {
            contentValues.put("title", s);
        }
        if (s2 != null) {
            contentValues.put("note", s2);
        }
        return context.getContentResolver().insert(kf.a, contentValues);
    }
    
    public static Uri a(final Context context, final ContentValues contentValues) {
        return context.getContentResolver().insert(kf.a, contentValues);
    }
    
    public static void a(final Context context, final Uri uri) {
        final ContentValues contentValues = new ContentValues();
        contentValues.put("active_state", 0);
        context.getContentResolver().update(uri, contentValues, (String)null, (String[])null);
        rq.a(context, uri);
    }
    
    public static void a(final Context context, final Uri uri, final int n) {
        if (n == 128) {
            a(context, uri, 0L, 0, 0, 0L, false);
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final ContentValues contentValues = new ContentValues();
        contentValues.put("reminder_date", 0);
        context.getContentResolver().update(uri, contentValues, (String)null, (String[])null);
        gu.a(context, uri);
        gu.c(context, currentTimeMillis);
        gu.b(context, currentTimeMillis);
    }
    
    public static void a(final Context context, final Uri uri, final int n, final int n2, final int n3) {
        final int a = a(n, n2, n3);
        final ContentValues contentValues = new ContentValues();
        contentValues.put("status", a);
        context.getContentResolver().update(uri, contentValues, (String)null, (String[])null);
        rq.a(context, uri);
    }
    
    public static void a(final Context context, final Uri uri, final int i, final String s, final String s2, final int j, final int k, final int n) {
        final ContentValues contentValues = new ContentValues();
        contentValues.put("status", i);
        contentValues.put("note", s);
        contentValues.put("title", s2);
        contentValues.put("color_index", j);
        contentValues.put("encrypted", k);
        context.getContentResolver().update(uri, contentValues, (String)null, (String[])null);
        rq.a(context, uri);
        if (n == 128) {
            gu.d(context, ContentUris.parseId(uri));
        }
        else if (n == 16) {
            gu.b(context, System.currentTimeMillis());
        }
    }
    
    public static void a(final Context context, final Uri uri, final long n, final int n2, final int n3, final long l, final long n4, final boolean b, final boolean b2) {
        final ContentValues contentValues = new ContentValues();
        if (n2 == 16) {
            final long a = gw.a(l);
            long i;
            if (b) {
                i = gu.a(context, n3, a, a + 1L, 1);
            }
            else if (n3 == 0) {
                i = 0L;
            }
            else {
                i = gu.a(context, n3, a, gw.a(n), 1);
            }
            if (n4 != 0L && i > n4) {
                i = 0L;
            }
            contentValues.put("reminder_last", a);
            contentValues.put("reminder_date", i);
            context.getContentResolver().update(uri, contentValues, (String)null, (String[])null);
            if (b2) {
                gu.b(context, n);
            }
        }
        else if (n2 == 32) {
            long j;
            if (b) {
                j = gu.a(context, n3, l, l + 1L, 2);
            }
            else if (n3 == 0) {
                j = 0L;
            }
            else {
                j = gu.a(context, n3, l, n, 2);
            }
            if (n4 != 0L && j > n4) {
                j = 0L;
            }
            contentValues.put("reminder_last", l);
            contentValues.put("reminder_date", j);
            context.getContentResolver().update(uri, contentValues, (String)null, (String[])null);
            gu.c(context, n);
        }
    }
    
    public static void a(final Context context, final Uri uri, final String s) {
        ColorNote.a(context, "NOTE", "DELETE", "FROM", s);
        final ContentValues contentValues = new ContentValues();
        contentValues.put("active_state", 16);
        contentValues.put("reminder_date", 0);
        context.getContentResolver().update(uri, contentValues, (String)null, (String[])null);
        final long currentTimeMillis = System.currentTimeMillis();
        gu.a(context, uri);
        rq.a(context, uri);
        gu.b(context, currentTimeMillis);
        gu.c(context, currentTimeMillis);
    }
    
    public static void a(final Context context, final Uri uri, final boolean b) {
        final long currentTimeMillis = System.currentTimeMillis();
        final Cursor query = context.getContentResolver().query(uri, (String[])null, (String)null, (String[])null, (String)null);
        if (query.moveToNext()) {
            final kh kh = new kh();
            kh.a(query);
            final ArrayList b2 = yf.b(kh.a(context));
            final Iterator<jx> iterator = b2.iterator();
            while (iterator.hasNext()) {
                iterator.next().a(b);
            }
            final String a = yf.a(b2);
            final ContentValues contentValues = new ContentValues();
            if (kh.e()) {
                final jz a2 = jz.a(context);
                final int a3 = a2.a;
                contentValues.put("note", a2.c(a));
                contentValues.put("encrypted", a3);
            }
            else {
                contentValues.put("note", a);
            }
            int i;
            if (b) {
                i = a(kh.d, 16, 16);
            }
            else {
                i = a(kh.d, 0, 16);
            }
            contentValues.put("status", i);
            context.getContentResolver().update(uri, contentValues, (String)null, (String[])null);
            gu.b(context, currentTimeMillis);
            rq.a(context, uri);
        }
        query.close();
    }
    
    public static boolean a(final Context context, final Uri uri, final long l, final int i, final int n, final long j, final boolean b) {
        final ContentValues contentValues = new ContentValues();
        final long currentTimeMillis = System.currentTimeMillis();
        gu.a(context, uri);
        if (i == 16 && n == 144) {
            final long a = gw.a(currentTimeMillis);
            contentValues.put("reminder_type", 16);
            contentValues.put("reminder_repeat", 144);
            contentValues.put("reminder_base", a);
            contentValues.put("reminder_date", a);
            contentValues.put("reminder_last", a);
            contentValues.put("reminder_repeat_ends", 0);
            context.getContentResolver().update(uri, contentValues, (String)null, (String[])null);
        }
        else if (i == 16) {
            final long a2 = gw.a(l);
            long a3;
            if (j != 0L) {
                a3 = gw.a(j);
            }
            else {
                a3 = 0L;
            }
            contentValues.put("reminder_type", i);
            contentValues.put("reminder_repeat", n);
            contentValues.put("reminder_base", a2);
            contentValues.put("reminder_date", a2);
            contentValues.put("reminder_last", a2);
            contentValues.put("reminder_repeat_ends", a3);
            final Time time = new Time();
            time.setToNow();
            time.set(time.monthDay, time.month, time.year);
            if (l < jk.a(time, true) && !b) {
                return false;
            }
            context.getContentResolver().update(uri, contentValues, (String)null, (String[])null);
        }
        else if (i == 32) {
            contentValues.put("reminder_type", i);
            contentValues.put("reminder_repeat", n);
            contentValues.put("reminder_base", l);
            contentValues.put("reminder_date", l);
            contentValues.put("reminder_last", l);
            contentValues.put("reminder_repeat_ends", j);
            if (l < currentTimeMillis && !b) {
                return false;
            }
            context.getContentResolver().update(uri, contentValues, (String)null, (String[])null);
        }
        else if (i == 128) {
            contentValues.put("reminder_type", i);
            contentValues.put("reminder_repeat", 0);
            contentValues.put("reminder_base", 0);
            contentValues.put("reminder_date", -1);
            contentValues.put("reminder_last", 0);
            contentValues.put("reminder_repeat_ends", 0);
            context.getContentResolver().update(uri, contentValues, (String)null, (String[])null);
            gu.d(context, ContentUris.parseId(uri));
        }
        else if (i == 0) {
            contentValues.put("reminder_type", 0);
            contentValues.put("reminder_repeat", 0);
            contentValues.put("reminder_date", 0);
            contentValues.put("reminder_base", 0);
            contentValues.put("reminder_last", 0);
            contentValues.put("reminder_repeat_ends", 0);
            contentValues.put("reminder_duration", 0);
            contentValues.put("reminder_option", 0);
            context.getContentResolver().update(uri, contentValues, (String)null, (String[])null);
        }
        gu.c(context, currentTimeMillis);
        gu.b(context, currentTimeMillis);
        return true;
    }
    
    public static void b(final Context context) {
        ki.a();
        try {
            NoteProvider.c(NoteProvider.b(context).f());
            ki.b();
            final ka a = ka.a(context);
            final SQLiteDatabase writableDatabase = a.a.getWritableDatabase();
            writableDatabase.execSQL("DROP TABLE IF EXISTS widget;");
            a.a.onCreate(writableDatabase);
            context.getContentResolver().notifyChange(kf.a, (ContentObserver)null);
        }
        finally {
            ki.b();
        }
    }
    
    public static void b(final Context context, final Uri uri) {
        ColorNote.a(context, "NOTE", "ARCHIVE");
        final ContentValues contentValues = new ContentValues();
        contentValues.put("space", 16);
        contentValues.put("reminder_date", 0);
        context.getContentResolver().update(uri, contentValues, (String)null, (String[])null);
        final long currentTimeMillis = System.currentTimeMillis();
        gu.a(context, uri);
        gu.c(context, currentTimeMillis);
        gu.b(context, currentTimeMillis);
    }
    
    public static void c(final Context context, final Uri uri) {
        final ContentValues contentValues = new ContentValues();
        contentValues.put("space", 0);
        context.getContentResolver().update(uri, contentValues, (String)null, (String[])null);
    }
    
    public static void d(final Context context, final Uri uri) {
        context.getContentResolver().update(uri, a(), (String)null, (String[])null);
        rq.a(context, uri);
        final long currentTimeMillis = System.currentTimeMillis();
        gu.a(context, uri);
        gu.b(context, currentTimeMillis);
        gu.c(context, currentTimeMillis);
    }
    
    public static Cursor e(final Context context, final Uri uri) {
        return context.getContentResolver().query(uri, (String[])null, (String)null, (String[])null, (String)null);
    }
    
    public static boolean f(final Context context, final Uri uri) {
        int i = 0;
        final Cursor e = e(context, uri);
        try {
            if (!e.moveToNext()) {
                return false;
            }
            final ContentValues contentValues = new ContentValues();
            for (acb[] a = NoteColumns.a; i < a.length; ++i) {
                final acb acb = a[i];
                acb.a(contentValues, acb.a(e).c());
            }
            contentValues.remove("_id");
            contentValues.remove("created_date");
            contentValues.remove("modified_date");
            a(context, contentValues);
            return true;
        }
        finally {
            if (e != null) {
                e.close();
            }
        }
    }
}
