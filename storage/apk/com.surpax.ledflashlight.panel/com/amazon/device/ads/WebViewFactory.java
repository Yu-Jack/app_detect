// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.annotation.SuppressLint;
import android.webkit.WebView;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.webkit.WebViewDatabase;
import android.content.Context;
import android.os.Build$VERSION;
import android.database.sqlite.SQLiteException;

class WebViewFactory
{
    private static WebViewFactory instance;
    private static boolean isWebViewCheckedAndOk;
    private boolean cookieSyncManagerCreated;
    
    static {
        WebViewFactory.instance = new WebViewFactory();
        WebViewFactory.isWebViewCheckedAndOk = false;
    }
    
    protected WebViewFactory() {
        this.cookieSyncManagerCreated = false;
    }
    
    protected static boolean doesExceptionContainLockedDatabaseMessage(final Exception ex) {
        return ex != null && ex.getMessage() != null && ex.getMessage().contains("database is locked");
    }
    
    public static final WebViewFactory getInstance() {
        return WebViewFactory.instance;
    }
    
    protected static boolean isDatabaseLocked(final SQLiteException ex) {
        if (Build$VERSION.SDK_INT >= 11) {
            return AndroidTargetUtils.isInstanceOfSQLiteDatabaseLockedException(ex);
        }
        return doesExceptionContainLockedDatabaseMessage((Exception)ex);
    }
    
    public static boolean isWebViewOk(final Context context) {
        if (Build$VERSION.SDK_INT > 8 || WebViewFactory.isWebViewCheckedAndOk) {
            return true;
        }
        if (WebViewDatabase.getInstance(context) == null) {
            return false;
        }
        try {
            final SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase("webviewCache.db", 0, (SQLiteDatabase$CursorFactory)null);
            if (openOrCreateDatabase != null) {
                openOrCreateDatabase.close();
            }
            WebViewFactory.isWebViewCheckedAndOk = true;
            return true;
        }
        catch (SQLiteException ex) {
            return isDatabaseLocked(ex);
        }
    }
    
    protected static void setInstance(final WebViewFactory instance) {
        WebViewFactory.instance = instance;
    }
    
    @SuppressLint({ "SetJavaScriptEnabled" })
    public static final boolean setJavaScriptEnabledForWebView(final boolean javaScriptEnabled, final WebView webView, final String s) {
        try {
            webView.getSettings().setJavaScriptEnabled(javaScriptEnabled);
            return true;
        }
        catch (NullPointerException ex) {
            Log.w(s, "Could not set JavaScriptEnabled because a NullPointerException was encountered.");
            return false;
        }
    }
    
    private void updateAdIdCookie() {
        if (this.cookieSyncManagerCreated) {
            String adId = InternalAdRegistration.getInstance().getRegistrationInfo().getAdId();
            if (adId == null) {
                adId = "";
            }
            this.setCookie("http://amazon-adsystem.com", "ad-id=" + adId + "; Domain=.amazon-adsystem.com");
        }
    }
    
    public WebView createWebView(final Context context) {
        synchronized (this) {
            final WebView webView = new WebView(context);
            if (!this.cookieSyncManagerCreated) {
                CookieSyncManager.createInstance(context);
                this.cookieSyncManagerCreated = true;
            }
            this.updateAdIdCookie();
            return webView;
        }
    }
    
    protected void setCookie(final String s, final String s2) {
        CookieManager.getInstance().setCookie(s, s2);
    }
}
