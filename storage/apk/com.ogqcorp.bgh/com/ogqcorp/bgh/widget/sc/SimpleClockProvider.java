// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.widget.sc;

import android.widget.RemoteViews;
import com.ogqcorp.bgh.widget.a.h;
import com.ogqcorp.bgh.widget.a.a;
import android.content.Intent;
import android.view.ViewGroup$LayoutParams;
import com.ogqcorp.bgh.widget.c;
import android.view.LayoutInflater;
import android.app.AlarmManager;
import android.content.ComponentName;
import android.appwidget.AppWidgetManager;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import com.ogqcorp.bgh.widget.a.b;
import com.ogqcorp.bgh.widget.a.f;
import android.graphics.Canvas;
import android.graphics.Bitmap$Config;
import com.ogqcorp.bgh.widget.a.d;
import android.widget.TextView;
import java.util.Date;
import android.graphics.Bitmap;
import android.content.Context;
import java.util.Locale;
import android.app.PendingIntent;
import android.graphics.Typeface;
import android.view.ViewGroup;
import java.text.SimpleDateFormat;
import android.appwidget.AppWidgetProvider;

public class SimpleClockProvider extends AppWidgetProvider
{
    private static final SimpleDateFormat a;
    private static ViewGroup b;
    private static String c;
    private static Typeface d;
    private static int e;
    private static float f;
    private static float g;
    private static PendingIntent h;
    
    static {
        a = new SimpleDateFormat("hh:mm,a,EEEE,dd,MMMM", Locale.US);
        SimpleClockProvider.e = -16777216;
        SimpleClockProvider.f = 0.0f;
        SimpleClockProvider.g = 0.0f;
    }
    
    private Bitmap a(final Context context, final int n, final int n2) {
        if (SimpleClockProvider.b == null) {
            SimpleClockProvider.b = this.b(context, n, n2);
        }
        final String[] split = SimpleClockProvider.a.format(new Date()).split(",");
        int i = 0;
        try {
            while (i < SimpleClockProvider.b.getChildCount()) {
                final TextView textView = (TextView)SimpleClockProvider.b.getChildAt(i);
                textView.setTypeface(SimpleClockProvider.d);
                textView.setTextColor(SimpleClockProvider.e);
                textView.setText((CharSequence)split[i]);
                ++i;
            }
        }
        catch (Exception ex) {
            com.ogqcorp.bgh.widget.a.d.b(ex);
        }
        SimpleClockProvider.b.measure(n, n2);
        SimpleClockProvider.b.layout(0, 0, n, n2);
        final Bitmap bitmap = Bitmap.createBitmap(n, n2, Bitmap$Config.ARGB_4444);
        final Canvas canvas = new Canvas(bitmap);
        if (com.ogqcorp.bgh.widget.a.f.a().e(context)) {
            this.a(canvas, n, n2);
        }
        canvas.translate(SimpleClockProvider.f, SimpleClockProvider.g);
        SimpleClockProvider.b.draw(canvas);
        return bitmap;
    }
    
    private void a(final Context context) {
        final String a = com.ogqcorp.bgh.widget.a.f.a().a(context);
        while (true) {
            if (a.equals(SimpleClockProvider.c)) {
                break Label_0030;
            }
            try {
                SimpleClockProvider.d = com.ogqcorp.bgh.widget.a.b.a(context, a);
                SimpleClockProvider.c = a;
                SimpleClockProvider.e = com.ogqcorp.bgh.widget.a.f.a().b(context);
                SimpleClockProvider.f = com.ogqcorp.bgh.widget.a.f.a().c(context);
                SimpleClockProvider.g = com.ogqcorp.bgh.widget.a.f.a().d(context);
            }
            catch (Exception ex) {
                com.ogqcorp.bgh.widget.a.d.b(ex);
                continue;
            }
            break;
        }
    }
    
    private void a(final Canvas canvas, final int n, final int n2) {
        final Paint paint = new Paint();
        paint.setStyle(Paint$Style.STROKE);
        paint.setColor(-1);
        canvas.drawRect(0.0f, 0.0f, (float)(n - 1), (float)(n2 - 1), paint);
    }
    
    private static int[] a(final Context context, final AppWidgetManager appWidgetManager) {
        return appWidgetManager.getAppWidgetIds(new ComponentName(context, SimpleClockProvider.class.getName()));
    }
    
    private AlarmManager b(final Context context) {
        final AlarmManager alarmManager = (AlarmManager)context.getSystemService("alarm");
        if (SimpleClockProvider.h != null) {
            SimpleClockProvider.h.cancel();
            alarmManager.cancel(SimpleClockProvider.h);
        }
        return alarmManager;
    }
    
    private ViewGroup b(final Context context, final int n, final int n2) {
        final ViewGroup viewGroup = (ViewGroup)LayoutInflater.from(context).inflate(com.ogqcorp.bgh.widget.c.widget_sc_skin_modern, (ViewGroup)null);
        viewGroup.setLayoutParams(new ViewGroup$LayoutParams(n, n2));
        return viewGroup;
    }
    
    private PendingIntent c(final Context context) {
        final String f = com.ogqcorp.bgh.widget.a.f.a().f(context);
        PendingIntent broadcast;
        if ("@NONE".equals(f)) {
            broadcast = PendingIntent.getBroadcast(context, 0, new Intent("com.ogqcorp.bgh.widget.sc.action.UPDATE"), 0);
        }
        else {
            if ("@PREFERENCES".equals(f)) {
                return PendingIntent.getActivity(context, 0, new Intent(context, (Class)SimpleClockPreferences.class), 0);
            }
            final boolean equals = "@ALARM".equals(f);
            broadcast = null;
            if (equals) {
                final Intent a = com.ogqcorp.bgh.widget.a.a.a(context);
                broadcast = null;
                if (a != null) {
                    return PendingIntent.getActivity(context, 0, a, 0);
                }
            }
        }
        return broadcast;
    }
    
    public void onDisabled(final Context context) {
        this.b(context);
    }
    
    public void onReceive(final Context context, final Intent intent) {
        this.a(context);
        final String action = intent.getAction();
        if (action.equals("android.appwidget.action.APPWIDGET_UPDATE")) {
            this.b(context).set(1, 60000L * ((60000L + System.currentTimeMillis()) / 60000L), SimpleClockProvider.h = PendingIntent.getBroadcast(context, 0, intent, 0));
        }
        else if (action.equals("com.ogqcorp.bgh.widget.sc.action.UPDATE")) {
            this.onUpdate(context, AppWidgetManager.getInstance(context), null);
            return;
        }
        super.onReceive(context, intent);
    }
    
    public void onUpdate(final Context context, final AppWidgetManager appWidgetManager, final int[] array) {
        final int a = com.ogqcorp.bgh.widget.a.h.a(context, 240.0f);
        final int a2 = com.ogqcorp.bgh.widget.a.h.a(context, 200.0f);
        for (final int n : a(context, appWidgetManager)) {
            final RemoteViews remoteViews = new RemoteViews(context.getPackageName(), com.ogqcorp.bgh.widget.c.widget_sc_remote);
            final Bitmap a4 = this.a(context, a, a2);
            remoteViews.setImageViewBitmap(com.ogqcorp.bgh.widget.b.simple_clock, a4);
            remoteViews.setOnClickPendingIntent(com.ogqcorp.bgh.widget.b.simple_clock, this.c(context));
            appWidgetManager.updateAppWidget(n, remoteViews);
            a4.recycle();
        }
    }
}
