// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.receiver;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.appwidget.AppWidgetProvider;

public abstract class AbstractNoteWidget extends AppWidgetProvider
{
    public abstract int a();
    
    public void onDeleted(final Context context, final int[] array) {
        final ka a = ka.a(context);
        for (int length = array.length, i = 0; i < length; ++i) {
            a.a.getWritableDatabase().delete("widget", "_id = ?", new String[] { String.valueOf(array[i]) });
        }
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
        rq.a(context, array, this.a(), 2);
    }
}
