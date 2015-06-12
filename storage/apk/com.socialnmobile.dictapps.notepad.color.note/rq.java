import android.content.ComponentName;
import com.socialnmobile.colornote.receiver.TodayWidget2x2;
import com.socialnmobile.colornote.receiver.BuildWidgetReceiver;
import com.socialnmobile.colornote.ColorNote;
import android.os.SystemClock;
import android.database.sqlite.SQLiteException;
import com.socialnmobile.colornote.activity.Today;
import android.text.format.DateUtils;
import android.appwidget.AppWidgetManager;
import java.util.Iterator;
import android.database.Cursor;
import android.net.Uri;
import com.socialnmobile.colornote.activity.NoteWidgetConfigure;
import android.widget.RemoteViews;
import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.content.res.Resources;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.content.Intent;
import android.content.ContentUris;
import android.app.PendingIntent;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class rq
{
    private static PendingIntent a(final Context context, final long n) {
        final Intent intent = new Intent("android.intent.action.VIEW", ContentUris.withAppendedId(kf.a, n));
        intent.setFlags(335544320);
        intent.putExtra("EXTRA_VIEW_FROM", "WIDGET");
        return PendingIntent.getActivity(context, 0, intent, 134217728);
    }
    
    private static Bitmap a(final int n, final int n2) {
        final Bitmap bitmap = Bitmap.createBitmap(10, 10, Bitmap$Config.ARGB_8888);
        bitmap.eraseColor(gw.a(n2, n));
        return bitmap;
    }
    
    private static Bitmap a(final Resources resources, final int n, final int n2, final int n3, final int n4) {
        final int dimensionPixelSize = resources.getDimensionPixelSize(2131361821);
        final Bitmap bitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap$Config.ARGB_4444);
        final Canvas canvas = new Canvas(bitmap);
        final Paint paint = new Paint();
        Bitmap bitmap2;
        if (n == 16 && n2 == 0) {
            bitmap2 = BitmapFactory.decodeResource(resources, 2130837505);
        }
        else {
            bitmap2 = BitmapFactory.decodeResource(resources, 2130837510);
        }
        paint.setColorFilter((ColorFilter)new PorterDuffColorFilter(gw.a(n4, n3), PorterDuff$Mode.MULTIPLY));
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint);
        return bitmap;
    }
    
    private static RemoteViews a(final Context context, final int n, final int i) {
        final Cursor query = ka.a(context).a.getReadableDatabase().query("widget", (String[])null, "_id = ?", new String[] { String.valueOf(n) }, (String)null, (String)null, (String)null);
        long long1;
        if (!query.moveToFirst()) {
            long1 = 0L;
        }
        else {
            long1 = query.getLong(query.getColumnIndex("note_id"));
        }
        query.close();
        while (true) {
            Label_0615: {
                if (long1 == 0L) {
                    break Label_0615;
                }
                final Cursor e = kg.e(context, ContentUris.withAppendedId(kf.a, long1));
                if (e == null) {
                    break Label_0615;
                }
                String g;
                String a;
                int j;
                long a2;
                int f;
                boolean a3;
                int c;
                int k;
                if (e.moveToFirst()) {
                    final kh kh = new kh(e);
                    g = kh.g;
                    a = kh.a(context);
                    j = kh.j;
                    a2 = kh.a;
                    f = kh.f;
                    a3 = kh.a();
                    c = kh.c;
                    k = kh.k;
                }
                else {
                    a2 = long1;
                    j = 8;
                    a = "";
                    g = "";
                    k = 0;
                    c = 0;
                    a3 = false;
                    f = 0;
                }
                e.close();
                final int n2 = c;
                final int n3 = k;
                final boolean b = a3;
                final int n4 = f;
                final long n5 = a2;
                final String s = a;
                final String s2 = g;
                final boolean b2 = b;
                final int n6 = n4;
                if (i == 1) {
                    RemoteViews remoteViews;
                    if (n6 == 16) {
                        remoteViews = new RemoteViews(context.getPackageName(), 2130903098);
                    }
                    else {
                        remoteViews = new RemoteViews(context.getPackageName(), 2130903097);
                    }
                    a(context, remoteViews, n5, s2, s, j, n6, b2, n2);
                    return remoteViews;
                }
                if (i == 2) {
                    RemoteViews remoteViews2;
                    if (n6 == 16) {
                        remoteViews2 = new RemoteViews(context.getPackageName(), 2130903099);
                    }
                    else {
                        remoteViews2 = new RemoteViews(context.getPackageName(), 2130903099);
                    }
                    final Resources resources = context.getResources();
                    a(context, remoteViews2, b2, j);
                    if (b2) {
                        remoteViews2.setTextViewText(16908310, gw.a(s2));
                    }
                    else {
                        remoteViews2.setTextViewText(16908310, (CharSequence)s2);
                    }
                    if (n6 == 16) {
                        remoteViews2.setTextViewText(16908308, yf.a(s));
                    }
                    else {
                        remoteViews2.setTextViewText(16908308, (CharSequence)s);
                    }
                    if (n3 != 0) {
                        remoteViews2.setViewVisibility(2131624068, 0);
                        remoteViews2.setTextViewText(16908308, (CharSequence)"");
                    }
                    else {
                        remoteViews2.setViewVisibility(2131624068, 4);
                    }
                    if (n2 == 32) {
                        remoteViews2.setTextViewText(16908308, (CharSequence)resources.getString(2131230837));
                    }
                    remoteViews2.setOnClickPendingIntent(16908288, a(context, n5));
                    final Intent intent = new Intent(context, (Class)NoteWidgetConfigure.class);
                    intent.setData(Uri.parse(new StringBuilder().append(n).toString()));
                    intent.putExtra("appWidgetId", n);
                    intent.setFlags(335544320);
                    remoteViews2.setOnClickPendingIntent(16908313, PendingIntent.getActivity(context, 0, intent, 134217728));
                    return remoteViews2;
                }
                throw new RuntimeException("Invalid widgetType:" + i);
            }
            final long n5 = long1;
            int j = 8;
            final String s = "";
            final String s2 = "";
            final int n3 = 0;
            final int n6 = 0;
            final boolean b2 = false;
            final int n2 = 0;
            continue;
        }
    }
    
    public static void a(final Context context) {
        final Cursor query = ka.a(context).a.getReadableDatabase().query("widget", (String[])null, (String)null, (String[])null, (String)null, (String)null, (String)null);
        final kn[] array = new kn[query.getCount()];
        int n = 0;
        while (query.moveToNext()) {
            array[n] = new kn();
            array[n].a = query.getInt(query.getColumnIndex("_id"));
            array[n].b = query.getInt(query.getColumnIndex("widget_type"));
            ++n;
        }
        query.close();
        a(context, array);
    }
    
    public static void a(final Context context, final Uri uri) {
        final Cursor query = ka.a(context).a.getReadableDatabase().query("widget", (String[])null, "note_id = ?", new String[] { String.valueOf(ContentUris.parseId(uri)) }, (String)null, (String)null, (String)null);
        final kn[] array = new kn[query.getCount()];
        int n = 0;
        while (query.moveToNext()) {
            array[n] = new kn();
            array[n].a = query.getInt(query.getColumnIndex("_id"));
            array[n].b = query.getInt(query.getColumnIndex("widget_type"));
            ++n;
        }
        query.close();
        if (array.length != 0) {
            a(context, array);
        }
    }
    
    private static void a(final Context context, final RemoteViews remoteViews, final long n, final String s, final String s2, final int n2, final int n3, final boolean b, final int n4) {
        final Resources resources = context.getResources();
        final int i = gr.a(context).i(n2);
        final int j = gr.a(context).j(n2);
        if (b) {
            remoteViews.setTextViewText(16908308, gw.a(s));
        }
        else {
            remoteViews.setTextViewText(16908308, (CharSequence)s);
        }
        if (n4 == 32) {
            remoteViews.setTextViewText(16908308, (CharSequence)resources.getString(2131230837));
        }
        remoteViews.setTextColor(16908308, j);
        while (true) {
            Label_0253: {
                if (n3 != 16) {
                    break Label_0253;
                }
                if (!jp.a(context, "pref_show_item_count_on_widget", context.getResources().getBoolean(2131296260))) {
                    remoteViews.setViewVisibility(16908309, 8);
                    break Label_0253;
                }
                final Iterator<jx> iterator = (Iterator<jx>)yf.b(s2).iterator();
                int k = 0;
                while (iterator.hasNext()) {
                    if (!iterator.next().a()) {
                        ++k;
                    }
                }
                if (k > 0 && n4 == 0) {
                    remoteViews.setTextViewText(16908309, (CharSequence)new StringBuilder().append(k).toString());
                    remoteViews.setViewVisibility(16908309, 0);
                }
                else {
                    remoteViews.setViewVisibility(16908309, 8);
                }
                remoteViews.setImageViewBitmap(16908288, a(resources, n3, k, i, jp.k(context)));
                remoteViews.setOnClickPendingIntent(16908288, a(context, n));
                return;
            }
            int k = 0;
            continue;
        }
    }
    
    private static void a(final Context context, final RemoteViews remoteViews, final Cursor cursor, final int i) {
        final int identifier = context.getResources().getIdentifier("item" + i, "id", context.getPackageName());
        final int identifier2 = context.getResources().getIdentifier("bg_item" + i, "id", context.getPackageName());
        final int identifier3 = context.getResources().getIdentifier("text" + i, "id", context.getPackageName());
        final kh kh = new kh(cursor);
        remoteViews.setViewVisibility(identifier, 0);
        remoteViews.setImageViewBitmap(identifier2, a(gr.a(context).b(kh.j), jp.k(context)));
        remoteViews.setOnClickPendingIntent(identifier3, a(context, kh.a));
        final int g = gr.a(context).g(kh.j);
        if (kh.a()) {
            remoteViews.setTextViewText(identifier3, gw.a(kh.g));
            remoteViews.setTextColor(identifier3, gw.a(102, g));
            return;
        }
        remoteViews.setTextViewText(identifier3, (CharSequence)kh.g);
        remoteViews.setTextColor(identifier3, g);
    }
    
    private static void a(final Context context, final RemoteViews remoteViews, final boolean b, final int n) {
        remoteViews.setImageViewBitmap(2131624135, b(context, n, jp.k(context)));
        remoteViews.setImageViewBitmap(2131624136, c(context, n, jp.k(context)));
        final int f = gr.a(context).f(n);
        final int g = gr.a(context).g(n);
        if (b) {
            remoteViews.setTextColor(16908310, gw.a(102, f));
            remoteViews.setTextColor(16908308, gw.a(102, g));
            return;
        }
        remoteViews.setTextColor(16908310, f);
        remoteViews.setTextColor(16908308, g);
    }
    
    public static void a(final Context context, final int[] array) {
        final AppWidgetManager instance = AppWidgetManager.getInstance(context);
        final long currentTimeMillis = System.currentTimeMillis();
        final RemoteViews remoteViews = new RemoteViews(context.getPackageName(), 2130903100);
        remoteViews.setImageViewBitmap(2131624137, b(context, 9, jp.k(context)));
        remoteViews.setImageViewBitmap(2131624139, c(context, 9, jp.k(context)));
        remoteViews.setTextViewText(16908310, (CharSequence)DateUtils.formatDateTime(context, currentTimeMillis, 524314));
        final Cursor a = kg.a(context, currentTimeMillis);
        if (a != null) {
            if (a.moveToNext()) {
                a(context, remoteViews, a, 1);
            }
            else {
                remoteViews.setViewVisibility(2131624140, 4);
            }
            if (a.moveToNext()) {
                a(context, remoteViews, a, 2);
            }
            else {
                remoteViews.setViewVisibility(2131624143, 4);
            }
            if (a.moveToNext()) {
                a(context, remoteViews, a, 3);
            }
            else {
                remoteViews.setViewVisibility(2131624146, 4);
            }
            if (a.moveToNext()) {
                a(context, remoteViews, a, 4);
            }
            else {
                remoteViews.setViewVisibility(2131624149, 4);
            }
            if (a.moveToNext()) {
                a(context, remoteViews, a, 5);
            }
            else {
                remoteViews.setViewVisibility(2131624152, 4);
            }
            a.close();
        }
        final Intent intent = new Intent(context, (Class)Today.class);
        intent.setFlags(335544320);
        remoteViews.setOnClickPendingIntent(16908313, PendingIntent.getActivity(context, 0, intent, 134217728));
        final Intent intent2 = new Intent("note.socialnmobile.intent.action.VIEW_CALENDAR");
        intent2.setFlags(335544320);
        remoteViews.setOnClickPendingIntent(16908288, PendingIntent.getActivity(context, 0, intent2, 268435456));
        instance.updateAppWidget(array, remoteViews);
    }
    
    public static void a(final Context context, final int[] array, final int n, final int i) {
        final AppWidgetManager instance = AppWidgetManager.getInstance(context);
        int n2 = 1;
        for (int length = array.length, j = 0; j < length; ++j) {
        Label_0115_Outer:
            while (true) {
                final int n3 = array[j];
                while (true) {
                    while (true) {
                        try {
                            final RemoteViews a = a(context, n3, n);
                            if (a != null) {
                                instance.updateAppWidget(n3, a);
                                break;
                            }
                        }
                        catch (SQLiteException ex) {
                            final RemoteViews a = null;
                            n2 = 0;
                            continue Label_0115_Outer;
                        }
                        break;
                    }
                    final Resources resources = context.getResources();
                    RemoteViews remoteViews;
                    if (n == 1) {
                        final int k = gr.a(context).i(8);
                        remoteViews = new RemoteViews(context.getPackageName(), 2130903097);
                        remoteViews.setImageViewBitmap(16908288, a(resources, 0, 0, k, jp.k(context)));
                    }
                    else {
                        remoteViews = null;
                        if (n == 2) {
                            remoteViews = new RemoteViews(context.getPackageName(), 2130903099);
                            a(context, remoteViews, false, 8);
                        }
                    }
                    instance.updateAppWidget(n3, remoteViews);
                    continue;
                }
            }
        }
        if (n2 == 0) {
            go.a();
            int n4;
            if (SystemClock.uptimeMillis() < 300000L) {
                n4 = 1;
            }
            else {
                n4 = 0;
            }
            if (n4 != 0) {
                ColorNote.a("Schedule BuildWidgetReceiver " + i);
                if (i > 0) {
                    BuildWidgetReceiver.a(context, array, n, i);
                }
            }
        }
    }
    
    public static void a(final Context context, final kn[] array) {
        final AppWidgetManager instance = AppWidgetManager.getInstance(context);
        for (final kn kn : array) {
            if (kn.a != 0 && kn.b != 0) {
                final RemoteViews a = a(context, kn.a, kn.b);
                if (a != null) {
                    instance.updateAppWidget(kn.a, a);
                }
            }
        }
    }
    
    private static Bitmap b(final Context context, final int n, final int n2) {
        return a(gr.a(context).c(n), n2);
    }
    
    public static void b(final Context context) {
        try {
            final int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, (Class)TodayWidget2x2.class));
            if (appWidgetIds != null && appWidgetIds.length > 0) {
                a(context, appWidgetIds);
            }
        }
        catch (RuntimeException ex) {}
    }
    
    private static Bitmap c(final Context context, final int n, final int n2) {
        return a(gr.a(context).b(n), n2);
    }
}
