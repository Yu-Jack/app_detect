// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.receiver;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.appwidget.AppWidgetProvider;

public class TodayWidget2x2 extends AppWidgetProvider
{
    public void onDeleted(final Context context, final int[] array) {
        super.onDeleted(context, array);
    }
    
    public void onDisabled(final Context context) {
        super.onDisabled(context);
    }
    
    public void onEnabled(final Context context) {
        super.onEnabled(context);
    }
    
    public void onUpdate(final Context context, final AppWidgetManager appWidgetManager, final int[] array) {
        super.onUpdate(context, appWidgetManager, array);
        rq.a(context, array);
    }
}
