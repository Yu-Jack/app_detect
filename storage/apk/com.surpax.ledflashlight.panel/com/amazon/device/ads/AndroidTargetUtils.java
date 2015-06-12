// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.webkit.WebView;
import android.widget.ImageButton;
import android.graphics.drawable.Drawable;
import android.database.sqlite.SQLiteException;
import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.graphics.drawable.BitmapDrawable;
import android.content.res.Resources;
import android.os.Build$VERSION;
import android.os.AsyncTask;
import android.content.SharedPreferences$Editor;
import android.view.View;

class AndroidTargetUtils
{
    public static final void disableHardwareAcceleration(final View view) {
        AndroidTargetUtils$HoneycombTargetUtils.disableHardwareAcceleration(view);
    }
    
    public static void editorApply(final SharedPreferences$Editor sharedPreferences$Editor) {
        AndroidTargetUtils$GingerbreadTargetUtils.editorApply(sharedPreferences$Editor);
    }
    
    public static void executeAsyncTask(final AsyncTask asyncTask, final Object... array) {
        if (Build$VERSION.SDK_INT >= 11) {
            AndroidTargetUtils$HoneycombTargetUtils.executeAsyncTaskWithThreadPooling(asyncTask, array);
            return;
        }
        asyncTask.execute(array);
    }
    
    public static BitmapDrawable getNewBitmapDrawable(final Resources resources, final String s) {
        if (isAtLeastAndroidAPI(5)) {
            return AndroidTargetUtils$EclairTargetUtils.getNewBitmapDrawable(resources, s);
        }
        return new BitmapDrawable(s);
    }
    
    public static int getOrientation(final Display display) {
        if (isAtLeastAndroidAPI(8)) {
            return AndroidTargetUtils$FroyoTargetUtils.getRotation(display);
        }
        return display.getOrientation();
    }
    
    public static String getPackageCodePath(final Context context) {
        return AndroidTargetUtils$FroyoTargetUtils.getPackageCodePath(context);
    }
    
    public static void hideActionAndStatusBars(final Activity activity) {
        AndroidTargetUtils$HoneycombTargetUtils.hideActionAndStatusBars(activity);
    }
    
    public static boolean isAtLeastAndroidAPI(final int n) {
        return Build$VERSION.SDK_INT >= n;
    }
    
    public static boolean isInstanceOfSQLiteDatabaseLockedException(final SQLiteException ex) {
        return AndroidTargetUtils$HoneycombTargetUtils.isInstanceOfSQLiteDatabaseLockedException(ex);
    }
    
    public static void setBackgroundDrawable(final View view, final Drawable backgroundDrawable) {
        if (isAtLeastAndroidAPI(16)) {
            AndroidTargetUtils$JellyBeanTargetUtils.setBackgroundForLinerLayout(view, backgroundDrawable);
            return;
        }
        view.setBackgroundDrawable(backgroundDrawable);
    }
    
    public static void setImageButtonAlpha(final ImageButton imageButton, final int alpha) {
        if (isAtLeastAndroidAPI(16)) {
            AndroidTargetUtils$JellyBeanTargetUtils.setImageButtonAlpha(imageButton, alpha);
            return;
        }
        imageButton.setAlpha(alpha);
    }
    
    public static void webViewOnPause(final WebView webView) {
        AndroidTargetUtils$HoneycombTargetUtils.webViewOnPause(webView);
    }
    
    public static void webViewOnResume(final WebView webView) {
        AndroidTargetUtils$HoneycombTargetUtils.webViewOnResume(webView);
    }
}
