import android.app.AlarmManager;
import android.content.ContentValues;
import android.content.ContentUris;
import android.app.NotificationManager;
import android.net.Uri;
import android.widget.RemoteViews;
import android.os.Build;
import android.app.Notification;
import android.database.Cursor;
import android.content.Intent;
import android.app.PendingIntent;
import com.socialnmobile.colornote.ColorNote;
import android.content.Context;
import android.text.format.Time;

// 
// Decompiled by Procyon v0.5.29
// 

public final class gu
{
    private static long a(final int n, final long n2, final long n3, final int n4) {
        final Time time = new Time();
        final Time time2 = new Time();
        if (n4 == 1) {
            time2.timezone = "UTC";
            time.timezone = "UTC";
        }
        time.set(n2);
        int n5 = 1;
        do {
            time2.set(n2);
            switch (n) {
                case 112: {
                    time2.year += n5;
                    break;
                }
                case 96: {
                    time2.month += n5;
                    break;
                }
            }
            jk.a(time2);
            ++n5;
        } while (jk.a(time2, true) < n3 || time.monthDay != time2.monthDay);
        return jk.a(time2, true);
    }
    
    private static long a(final long n, final long n2, final int n3) {
        final Time time = new Time();
        if (n3 == 1) {
            time.timezone = "UTC";
        }
        time.set(n);
        while (jk.a(time, true) < n2 || time.weekDay == 0 || time.weekDay == 6) {
            ++time.monthDay;
            jk.a(time);
        }
        return jk.a(time, true);
    }
    
    public static long a(final Context context, final int n, final long n2, final long n3, final int n4) {
        switch (n) {
            default: {
                return 0L;
            }
            case 16:
            case 48:
            case 64:
            case 144: {
                final Time time = new Time();
                if (n4 == 1) {
                    time.timezone = "UTC";
                }
                time.set(n2);
                while (jk.a(time, true) < n3) {
                    switch (n) {
                        case 16:
                        case 144: {
                            ++time.monthDay;
                            break;
                        }
                        case 48: {
                            time.monthDay += 7;
                            break;
                        }
                        case 64: {
                            time.monthDay += 14;
                            break;
                        }
                    }
                    jk.a(time);
                }
                return jk.a(time, true);
            }
            case 96:
            case 112: {
                return a(n, n2, n3, n4);
            }
            case 32: {
                return a(n2, n3, n4);
            }
            case 80: {
                return b(n2, n3, n4);
            }
            case 128: {
                return a(context, n2, n3, n4);
            }
        }
    }
    
    private static long a(final Context context, final long n, final long n2, final int n3) {
        long a = n;
        while (a < n2) {
            a = new yn(context).a(context, a, n3);
            if (a == 0L) {
                ColorNote.a("Can't calculate next lunar date. it may be > 2050");
                return a;
            }
        }
        return a;
    }
    
    public static PendingIntent a(final Context context, final long n, final long n2) {
        final Intent intent = new Intent("note.socialnmobile.intent.action.TIME_REMINDER");
        intent.putExtra("alarm_id", n);
        intent.putExtra("alarm_time", n2);
        return PendingIntent.getBroadcast(context, 0, intent, 134217728);
    }
    
    public static void a(final Context context) {
        final long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            Cursor query = null;
            Label_0078: {
                try {
                    a(context, currentTimeMillis);
                    c(context, currentTimeMillis);
                    b(context, currentTimeMillis);
                    query = context.getContentResolver().query(kf.a, (String[])null, "reminder_type = 128 AND reminder_date <> 0", (String[])null, (String)null);
                    if (query == null) {
                        throw new mb("Null cursor returned from provider");
                    }
                    break Label_0078;
                }
                catch (mb mb) {
                    ColorNote.a("Invalid State Exception thrown when renewTimeAlarms()");
                    return;
                }
                d(context, query.getLong(query.getColumnIndex("_id")));
            }
            if (!query.moveToNext()) {
                query.close();
                return;
            }
            continue;
        }
    }
    
    public static void a(final Context context, final long l) {
        final Cursor query = context.getContentResolver().query(kf.a, (String[])null, "reminder_type = ? AND reminder_date > ? AND reminder_date < ?", new String[] { String.valueOf(32), String.valueOf(0), String.valueOf(l) }, "reminder_date ASC");
        if (query == null) {
            throw new mb("Null cursor returned from provider");
        }
        while (query.moveToNext()) {
            d(context, query.getLong(query.getColumnIndex("_id")));
        }
        query.close();
    }
    
    public static void a(final Context context, final long n, final long n2, final PendingIntent pendingIntent) {
        try {
            go.a().a(context, n2, pendingIntent);
            jo.a(context, "TIME_ALARM_SCHEDULE", n2);
            jo.a(context, "TIME_ALARM_ID", n);
        }
        catch (SecurityException ex) {
            adl.a.a(context, ex, "GALAXY LOLLIPOP ALARM 2");
            ColorNote.b(context.getString(2131230845));
        }
    }
    
    public static void a(final Context context, final long n, final boolean b) {
        final long n2 = 30000L + gw.b(n);
        if (n2 >= n) {
            final PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent("note.socialnmobile.intent.action.DAY_REMINDER"), 134217728);
            if (jo.b(context, "DAILY_UPDATE_SCHEDULE") == n2) {
                if (!b) {
                    return;
                }
            }
            try {
                go.a().a(context, n2, broadcast);
                jo.a(context, "DAILY_UPDATE_SCHEDULE", n2);
            }
            catch (SecurityException ex) {
                adl.a.a(context, ex, "GALAXY LOLLIPOP ALARM");
            }
        }
    }
    
    private static void a(final Context context, final Notification notification, final CharSequence charSequence, final CharSequence charSequence2, final PendingIntent contentIntent, final boolean b) {
        if ("Nokia".equals(Build.MANUFACTURER) && !b) {
            final RemoteViews contentView = new RemoteViews(context.getPackageName(), 2130903077);
            if (notification.icon != 0) {
                contentView.setImageViewResource(2131624093, notification.icon);
            }
            if (charSequence != null) {
                contentView.setTextViewText(2131624097, charSequence);
            }
            if (charSequence2 != null) {
                contentView.setTextViewText(2131624033, charSequence2);
            }
            notification.contentView = contentView;
            notification.contentIntent = contentIntent;
            return;
        }
        notification.setLatestEventInfo(context, charSequence, charSequence2, contentIntent);
    }
    
    public static void a(final Context context, final Uri uri) {
        ((NotificationManager)context.getSystemService("notification")).cancel(100 + (int)ContentUris.parseId(uri));
    }
    
    public static boolean a(final kh kh) {
        return kh.m != 0 && kh.g() != 0L;
    }
    
    private static long b(final long n, final long n2, final int n3) {
        final Time time = new Time();
        if (n3 == 1) {
            time.timezone = "UTC";
        }
        time.set(n);
        int n4 = 1 + (-1 + time.monthDay) / 7;
        if (n4 == 5) {
            n4 = -1;
        }
        final int weekDay = time.weekDay;
        int n5 = 0;
    Label_0174_Outer:
        while (jk.a(time, true) < n2 || n5 == 0) {
            ++time.month;
            time.monthDay = 1;
            jk.a(time);
            final int weekDay2 = time.weekDay;
            final int actualMaximum = time.getActualMaximum(4);
            int i = 1 + (weekDay - weekDay2);
            if (i <= 0) {
                i += 7;
            }
            while (true) {
                Label_0221: {
                    if (n4 > 0) {
                        final int monthDay = i + 7 * (n4 - 1);
                        if (monthDay > actualMaximum) {
                            break Label_0221;
                        }
                        time.monthDay = monthDay;
                        n5 = 1;
                    }
                    else {
                        while (i <= actualMaximum) {
                            i += 7;
                        }
                        final int monthDay2 = i + n4 * 7;
                        if (monthDay2 <= 0) {
                            break Label_0221;
                        }
                        time.monthDay = monthDay2;
                        n5 = 1;
                    }
                    jk.a(time);
                    continue Label_0174_Outer;
                }
                n5 = 0;
                continue;
            }
        }
        return jk.a(time, true);
    }
    
    public static void b(final Context context, final long n) {
        a(context, n, false);
        final Cursor query = context.getContentResolver().query(kf.a, (String[])null, "reminder_type = ? AND reminder_date > ? AND reminder_date < ?", new String[] { String.valueOf(16), String.valueOf(0), String.valueOf(gw.a(n)) }, (String)null);
        final int columnIndex = query.getColumnIndex("_id");
        final int columnIndex2 = query.getColumnIndex("reminder_date");
        final int columnIndex3 = query.getColumnIndex("reminder_repeat");
        final int columnIndex4 = query.getColumnIndex("reminder_repeat_ends");
        while (query.moveToNext()) {
            kg.a(context, ContentUris.withAppendedId(kf.a, query.getLong(columnIndex)), n, 16, query.getInt(columnIndex3), kh.a(16, query.getLong(columnIndex2)), kh.a(16, query.getLong(columnIndex4)), false, false);
        }
        query.close();
        final Cursor a = kg.a(context, n);
        final int count = a.getCount();
        String string = "";
        String s = "";
        while (a.moveToNext()) {
            final kh kh = new kh(a);
            final long a2 = kh.a;
            final long l = kh.l;
            final Uri withAppendedId = ContentUris.withAppendedId(kf.a, a2);
            final long a3 = gw.a(n);
            if (kh.m == 16 && l != a3) {
                final ContentValues contentValues = new ContentValues();
                contentValues.put("reminder_last", a3);
                context.getContentResolver().update(withAppendedId, contentValues, (String)null, (String[])null);
            }
            final String c = kh.c();
            final String substring = c.substring(0, Math.min(30, c.length()));
            if ("".equals(s)) {
                s = kh.g;
                string = substring;
            }
            else {
                string = String.valueOf(string) + " / " + substring;
                s = String.valueOf(s) + " / " + kh.g;
            }
        }
        a.close();
        final String string2 = "[" + count + "] " + s.substring(0, Math.min(30, s.length()));
        final String substring2 = string.substring(0, Math.min(100, string.length()));
        final NotificationManager notificationManager = (NotificationManager)context.getSystemService("notification");
        if (jp.a(context, "pref_show_all_day_reminder", context.getResources().getBoolean(2131296261))) {
            if (count > 0) {
                final Intent intent = new Intent("note.socialnmobile.intent.action.TODAY");
                intent.setFlags(335544320);
                final Notification notification = new Notification(2130837672, (CharSequence)context.getString(2131230869), System.currentTimeMillis());
                notification.number = count;
                a(context, notification, string2, substring2.replace('\n', ' '), PendingIntent.getActivity(context, 0, intent, 134217728), false);
                notification.flags |= 0x20;
                notificationManager.notify(10, notification);
            }
            else {
                notificationManager.cancel(10);
            }
        }
        else {
            notificationManager.cancel(10);
        }
        rq.b(context);
    }
    
    public static void c(final Context context, final long l) {
        final Cursor query = context.getContentResolver().query(kf.a, (String[])null, "reminder_type = ? AND reminder_date > ?", new String[] { String.valueOf(32), String.valueOf(l) }, "reminder_date ASC");
        if (query == null) {
            throw new mb("Null cursor returned from provider");
        }
        if (query.moveToFirst()) {
            final long long1 = query.getLong(query.getColumnIndex("_id"));
            final long long2 = query.getLong(query.getColumnIndex("reminder_date"));
            final PendingIntent a = a(context, long1, long2);
            final long b = jo.b(context, "TIME_ALARM_SCHEDULE");
            final long b2 = jo.b(context, "TIME_ALARM_ID");
            if (b != long2 || b2 != long1) {
                a(context, long1, long2, a);
            }
        }
        else {
            final PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent("note.socialnmobile.intent.action.TIME_REMINDER"), 134217728);
            go.a();
            ((AlarmManager)context.getSystemService("alarm")).cancel(broadcast);
        }
        query.close();
    }
    
    public static void d(final Context context, final long n) {
        final Uri withAppendedId = ContentUris.withAppendedId(kf.a, n);
        final long currentTimeMillis = System.currentTimeMillis();
        final Cursor e = kg.e(context, withAppendedId);
        if (!e.moveToFirst()) {
            e.close();
            ColorNote.a("Can't notify because note was deleted");
        }
        else {
            final kh kh = new kh(e);
            final String c = kh.c();
            final String substring = c.substring(0, Math.min(30, c.length()));
            e.close();
            if (kh.c == 0) {
                final int m = kh.m;
                kh.g();
                final String g = kh.g;
                final int j = kh.j;
                final int f = kh.f;
                final int k = kh.k;
                final Uri withAppendedId2 = ContentUris.withAppendedId(kf.a, n);
                final Intent intent = new Intent("android.intent.action.VIEW");
                intent.setFlags(335544320);
                intent.putExtra("EXTRA_VIEW_FROM", "NOTIFICATION");
                final Notification notification = new Notification(context.getResources().getIdentifier("stat_textnote_" + j, "drawable", context.getPackageName()), (CharSequence)g, System.currentTimeMillis());
                intent.setData(withAppendedId2);
                final String replace = substring.replace('\n', ' ');
                if (m == 128) {
                    a(context, notification, g, replace, PendingIntent.getActivity(context, 0, intent, 134217728), false);
                    notification.flags |= 0x20;
                }
                else if (m == 32) {
                    a(context, notification, g, replace, PendingIntent.getActivity(context, 0, intent, 1073741824), true);
                    notification.defaults |= 0x3;
                    notification.flags |= 0x1;
                    notification.ledARGB = -256;
                    notification.ledOnMS = 500;
                    notification.ledOffMS = 5000;
                }
                if (kh.m == 32) {
                    kg.a(context, withAppendedId, currentTimeMillis, kh.m, kh.n, kh.g(), kh.i(), false, true);
                }
                ((NotificationManager)context.getSystemService("notification")).notify(100 + (int)n, notification);
            }
        }
    }
}
