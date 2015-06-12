// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.webkit.WebView;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.app.ActionBar;
import android.app.Activity;
import android.os.AsyncTask;
import android.graphics.Paint;
import android.view.View;
import android.annotation.TargetApi;

@TargetApi(11)
class AndroidTargetUtils$HoneycombTargetUtils
{
    public static final void disableHardwareAcceleration(final View view) {
        view.setLayerType(1, (Paint)null);
    }
    
    protected static final void executeAsyncTaskWithThreadPooling(final AsyncTask asyncTask, final Object... array) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, array);
    }
    
    protected static void hideActionAndStatusBars(final Activity activity) {
        final ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(4);
    }
    
    public static boolean isInstanceOfSQLiteDatabaseLockedException(final SQLiteException ex) {
        return ex instanceof SQLiteDatabaseLockedException;
    }
    
    protected static void webViewOnPause(final WebView webView) {
        webView.onPause();
    }
    
    protected static void webViewOnResume(final WebView webView) {
        webView.onResume();
    }
}
