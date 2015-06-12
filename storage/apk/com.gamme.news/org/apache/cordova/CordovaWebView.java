// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import android.webkit.WebHistoryItem;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import java.util.HashMap;
import android.view.ViewGroup$LayoutParams;
import android.webkit.WebBackForwardList;
import android.view.inputmethod.InputMethodManager;
import android.view.KeyEvent;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import java.util.List;
import android.view.ViewGroup;
import android.os.Bundle;
import java.util.Locale;
import android.annotation.SuppressLint;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebSettings$LayoutAlgorithm;
import android.os.Build$VERSION;
import android.annotation.TargetApi;
import android.util.Log;
import android.util.AttributeSet;
import android.content.Context;
import android.content.BroadcastReceiver;
import android.webkit.WebChromeClient$CustomViewCallback;
import android.view.View;
import java.util.HashSet;
import android.widget.FrameLayout$LayoutParams;
import android.webkit.WebView;

public class CordovaWebView extends WebView
{
    public static final String CORDOVA_VERSION = "3.6.3";
    static final FrameLayout$LayoutParams COVER_SCREEN_GRAVITY_CENTER;
    public static final String TAG = "CordovaWebView";
    private HashSet<Integer> boundKeyCodes;
    CordovaBridge bridge;
    private CordovaChromeClient chromeClient;
    private CordovaInterface cordova;
    private Whitelist externalWhitelist;
    private Whitelist internalWhitelist;
    private long lastMenuEventTime;
    int loadUrlTimeout;
    String loadedUrl;
    private View mCustomView;
    private WebChromeClient$CustomViewCallback mCustomViewCallback;
    private boolean paused;
    public PluginManager pluginManager;
    private CordovaPreferences preferences;
    private BroadcastReceiver receiver;
    private CordovaResourceApi resourceApi;
    CordovaWebViewClient viewClient;
    
    static {
        COVER_SCREEN_GRAVITY_CENTER = new FrameLayout$LayoutParams(-1, -1, 17);
    }
    
    public CordovaWebView(final Context context) {
        this(context, null);
    }
    
    public CordovaWebView(final Context context, final AttributeSet set) {
        super(context, set);
        this.boundKeyCodes = new HashSet<Integer>();
        this.loadUrlTimeout = 0;
        this.lastMenuEventTime = 0L;
    }
    
    public CordovaWebView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.boundKeyCodes = new HashSet<Integer>();
        this.loadUrlTimeout = 0;
        this.lastMenuEventTime = 0L;
    }
    
    public CordovaWebView(final Context context, final AttributeSet set, final int n, final boolean b) {
        super(context, set, n, b);
        this.boundKeyCodes = new HashSet<Integer>();
        this.loadUrlTimeout = 0;
        this.lastMenuEventTime = 0L;
    }
    
    @TargetApi(19)
    private void enableRemoteDebugging() {
        try {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        catch (IllegalArgumentException ex) {
            Log.d("CordovaWebView", "You have one job! To turn on Remote Web Debugging! YOU HAVE FAILED! ");
            ex.printStackTrace();
        }
    }
    
    private void exposeJsInterface() {
        if (Build$VERSION.SDK_INT < 17) {
            Log.i("CordovaWebView", "Disabled addJavascriptInterface() bridge since Android version is old.");
            return;
        }
        this.addJavascriptInterface((Object)new ExposedJsApi(this.bridge), "_cordovaNative");
    }
    
    private void initIfNecessary() {
        if (this.pluginManager == null) {
            Log.w("CordovaWebView", "CordovaWebView.init() was not called. This will soon be required.");
            final CordovaInterface cordovaInterface = (CordovaInterface)this.getContext();
            if (!Config.isInitialized()) {
                Config.init(cordovaInterface.getActivity());
            }
            this.init(cordovaInterface, this.makeWebViewClient(cordovaInterface), this.makeWebChromeClient(cordovaInterface), Config.getPluginEntries(), Config.getWhitelist(), Config.getExternalWhitelist(), Config.getPreferences());
        }
    }
    
    @SuppressLint({ "SetJavaScriptEnabled" })
    private void initWebViewSettings() {
        this.setInitialScale(0);
        this.setVerticalScrollBarEnabled(false);
        if (this.shouldRequestFocusOnInit()) {
            this.requestFocusFromTouch();
        }
        final WebSettings settings = this.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLayoutAlgorithm(WebSettings$LayoutAlgorithm.NORMAL);
        while (true) {
            try {
                final Method method = WebSettings.class.getMethod("setNavDump", Boolean.TYPE);
                Log.d("CordovaWebView", "CordovaWebView is running on device made by: " + Build.MANUFACTURER);
                if (Build$VERSION.SDK_INT < 11 && Build.MANUFACTURER.contains("HTC")) {
                    method.invoke(settings, true);
                }
                settings.setSaveFormData(false);
                settings.setSavePassword(false);
                if (Build$VERSION.SDK_INT > 15) {
                    Level16Apis.enableUniversalAccess(settings);
                }
                final String path = this.getContext().getApplicationContext().getDir("database", 0).getPath();
                settings.setDatabaseEnabled(true);
                settings.setDatabasePath(path);
                if ((0x2 & this.getContext().getApplicationContext().getApplicationInfo().flags) != 0x0 && Build$VERSION.SDK_INT >= 19) {
                    this.enableRemoteDebugging();
                }
                settings.setGeolocationDatabasePath(path);
                settings.setDomStorageEnabled(true);
                settings.setGeolocationEnabled(true);
                settings.setAppCacheMaxSize(5242880L);
                settings.setAppCachePath(path);
                settings.setAppCacheEnabled(true);
                settings.getUserAgentString();
                final IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
                if (this.receiver == null) {
                    this.receiver = new BroadcastReceiver() {
                        public void onReceive(final Context context, final Intent intent) {
                            CordovaWebView.this.getSettings().getUserAgentString();
                        }
                    };
                    this.getContext().registerReceiver(this.receiver, intentFilter);
                }
            }
            catch (NoSuchMethodException ex) {
                Log.d("CordovaWebView", "We are on a modern version of Android, we will deprecate HTC 2.3 devices in 2.8");
                continue;
            }
            catch (IllegalArgumentException ex2) {
                Log.d("CordovaWebView", "Doing the NavDump failed with bad arguments");
                continue;
            }
            catch (IllegalAccessException ex3) {
                Log.d("CordovaWebView", "This should never happen: IllegalAccessException means this isn't Android anymore");
                continue;
            }
            catch (InvocationTargetException ex4) {
                Log.d("CordovaWebView", "This should never happen: InvocationTargetException means this isn't Android anymore.");
                continue;
            }
            break;
        }
    }
    
    public boolean backHistory() {
        if (super.canGoBack()) {
            super.goBack();
            return true;
        }
        return false;
    }
    
    @Deprecated
    public void bindButton(final int n, final boolean b, final boolean b2) {
        this.setButtonPlumbedToJs(n, b2);
    }
    
    @Deprecated
    public void bindButton(final String s, final boolean b) {
        if (s.compareTo("volumeup") == 0) {
            this.setButtonPlumbedToJs(24, b);
        }
        else if (s.compareTo("volumedown") == 0) {
            this.setButtonPlumbedToJs(25, b);
        }
    }
    
    @Deprecated
    public void bindButton(final boolean b) {
        this.setButtonPlumbedToJs(4, b);
    }
    
    public Whitelist getExternalWhitelist() {
        return this.externalWhitelist;
    }
    
    public CordovaPreferences getPreferences() {
        return this.preferences;
    }
    
    public String getProperty(final String s, final String s2) {
        final Bundle extras = this.cordova.getActivity().getIntent().getExtras();
        if (extras != null) {
            final Object value = extras.get(s.toLowerCase(Locale.getDefault()));
            if (value != null) {
                return value.toString();
            }
        }
        return s2;
    }
    
    public CordovaResourceApi getResourceApi() {
        return this.resourceApi;
    }
    
    public CordovaChromeClient getWebChromeClient() {
        return this.chromeClient;
    }
    
    public Whitelist getWhitelist() {
        return this.internalWhitelist;
    }
    
    @Deprecated
    public boolean hadKeyEvent() {
        return false;
    }
    
    public void handleDestroy() {
        this.loadUrl("javascript:try{cordova.require('cordova/channel').onDestroy.fire();}catch(e){console.log('exception firing destroy event from native');};");
        this.loadUrl("about:blank");
        if (this.pluginManager != null) {
            this.pluginManager.onDestroy();
        }
        if (this.receiver == null) {
            return;
        }
        try {
            this.getContext().unregisterReceiver(this.receiver);
        }
        catch (Exception ex) {
            Log.e("CordovaWebView", "Error unregistering configuration receiver: " + ex.getMessage(), (Throwable)ex);
        }
    }
    
    public void handlePause(final boolean b) {
        LOG.d("CordovaWebView", "Handle the pause");
        this.loadUrl("javascript:try{cordova.fireDocumentEvent('pause');}catch(e){console.log('exception firing pause event from native');};");
        if (this.pluginManager != null) {
            this.pluginManager.onPause(b);
        }
        if (!b) {
            this.pauseTimers();
        }
        this.paused = true;
    }
    
    public void handleResume(final boolean b, final boolean b2) {
        this.loadUrl("javascript:try{cordova.fireDocumentEvent('resume');}catch(e){console.log('exception firing resume event from native');};");
        if (this.pluginManager != null) {
            this.pluginManager.onResume(b);
        }
        this.resumeTimers();
        this.paused = false;
    }
    
    public void hideCustomView() {
        Log.d("CordovaWebView", "Hiding Custom View");
        if (this.mCustomView == null) {
            return;
        }
        this.mCustomView.setVisibility(8);
        ((ViewGroup)this.getParent()).removeView(this.mCustomView);
        this.mCustomView = null;
        this.mCustomViewCallback.onCustomViewHidden();
        this.setVisibility(0);
    }
    
    public void init(final CordovaInterface cordova, final CordovaWebViewClient cordovaWebViewClient, final CordovaChromeClient cordovaChromeClient, final List<PluginEntry> list, final Whitelist internalWhitelist, final Whitelist externalWhitelist, final CordovaPreferences preferences) {
        if (this.cordova != null) {
            throw new IllegalStateException();
        }
        this.cordova = cordova;
        this.viewClient = cordovaWebViewClient;
        this.chromeClient = cordovaChromeClient;
        this.internalWhitelist = internalWhitelist;
        this.externalWhitelist = externalWhitelist;
        this.preferences = preferences;
        super.setWebChromeClient((WebChromeClient)cordovaChromeClient);
        super.setWebViewClient((WebViewClient)cordovaWebViewClient);
        this.pluginManager = new PluginManager(this, this.cordova, list);
        this.bridge = new CordovaBridge(this.pluginManager, new NativeToJsMessageQueue(this, cordova));
        this.resourceApi = new CordovaResourceApi(this.getContext(), this.pluginManager);
        this.pluginManager.addService("App", "org.apache.cordova.App");
        this.initWebViewSettings();
        this.exposeJsInterface();
    }
    
    @Deprecated
    public boolean isBackButtonBound() {
        return this.isButtonPlumbedToJs(4);
    }
    
    public boolean isButtonPlumbedToJs(final int i) {
        return this.boundKeyCodes.contains(i);
    }
    
    public boolean isCustomViewShowing() {
        return this.mCustomView != null;
    }
    
    public boolean isPaused() {
        return this.paused;
    }
    
    public void loadUrl(final String s) {
        if (s.equals("about:blank") || s.startsWith("javascript:")) {
            this.loadUrlNow(s);
            return;
        }
        this.loadUrlIntoView(s);
    }
    
    @Deprecated
    public void loadUrl(final String s, final int n) {
        if (s == null) {
            this.loadUrlIntoView(Config.getStartUrl());
            return;
        }
        this.loadUrlIntoView(s);
    }
    
    public void loadUrlIntoView(final String s) {
        this.loadUrlIntoView(s, true);
    }
    
    public void loadUrlIntoView(final String s, final int i) {
        if (!s.startsWith("javascript:") && !this.canGoBack()) {
            LOG.d("CordovaWebView", "loadUrlIntoView(%s, %d)", s, i);
            this.postMessage("splashscreen", "show");
        }
        this.loadUrlIntoView(s);
    }
    
    public void loadUrlIntoView(final String s, final boolean b) {
        LOG.d("CordovaWebView", ">>> loadUrl(" + s + ")");
        this.initIfNecessary();
        if (b) {
            this.loadedUrl = s;
            this.pluginManager.init();
        }
        this.cordova.getActivity().runOnUiThread((Runnable)new Runnable() {
            private final /* synthetic */ Runnable val$timeoutCheck = new Runnable(this, Integer.parseInt(CordovaWebView.this.getProperty("LoadUrlTimeoutValue", "20000")), this, CordovaWebView.this.loadUrlTimeout, new Runnable(this, this, s) {
                private final /* synthetic */ String val$url;
                
                @Override
                public void run() {
                    CordovaWebView.this.stopLoading();
                    LOG.e("CordovaWebView", "CordovaWebView: TIMEOUT ERROR!");
                    if (CordovaWebView.this.viewClient != null) {
                        CordovaWebView.this.viewClient.onReceivedError(CordovaWebView.this, -6, "The connection to the server was unsuccessful.", this.val$url);
                    }
                }
            }) {
                private final /* synthetic */ int val$currentLoadUrlTimeout;
                private final /* synthetic */ Runnable val$loadError;
                private final /* synthetic */ int val$loadUrlTimeoutValue;
                
                @Override
                public void run() {
                    while (true) {
                        try {
                            synchronized (this) {
                                Object.this.wait(this.val$loadUrlTimeoutValue);
                                // monitorexit(this)
                                if (CordovaWebView.this.loadUrlTimeout == this.val$currentLoadUrlTimeout) {
                                    CordovaWebView.this.cordova.getActivity().runOnUiThread(this.val$loadError);
                                }
                            }
                        }
                        catch (InterruptedException ex) {
                            ex.printStackTrace();
                            continue;
                        }
                        break;
                    }
                }
            };
            
            @Override
            public void run() {
                CordovaWebView.this.cordova.getThreadPool().execute(this.val$timeoutCheck);
                CordovaWebView.this.loadUrlNow(s);
            }
        });
    }
    
    void loadUrlNow(final String s) {
        if (LOG.isLoggable(3) && !s.startsWith("javascript:")) {
            LOG.d("CordovaWebView", ">>> loadUrlNow()");
        }
        if (s.startsWith("file://") || s.startsWith("javascript:") || this.internalWhitelist.isUrlWhiteListed(s)) {
            super.loadUrl(s);
        }
    }
    
    public CordovaChromeClient makeWebChromeClient(final CordovaInterface cordovaInterface) {
        return new CordovaChromeClient(cordovaInterface, this);
    }
    
    public CordovaWebViewClient makeWebViewClient(final CordovaInterface cordovaInterface) {
        if (Build$VERSION.SDK_INT < 14) {
            return new CordovaWebViewClient(cordovaInterface, this);
        }
        return new IceCreamCordovaWebViewClient(cordovaInterface, this);
    }
    
    public boolean onKeyDown(final int i, final KeyEvent keyEvent) {
        if (this.boundKeyCodes.contains(i)) {
            if (i == 25) {
                this.loadUrl("javascript:cordova.fireDocumentEvent('volumedownbutton');");
            }
            else {
                if (i == 24) {
                    this.loadUrl("javascript:cordova.fireDocumentEvent('volumeupbutton');");
                    return true;
                }
                return super.onKeyDown(i, keyEvent);
            }
        }
        else if (i == 4) {
            if (this.startOfHistory() && !this.isButtonPlumbedToJs(4)) {
                return false;
            }
        }
        else {
            if (i != 82) {
                return super.onKeyDown(i, keyEvent);
            }
            final View focusedChild = this.getFocusedChild();
            if (focusedChild != null) {
                ((InputMethodManager)this.cordova.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(focusedChild.getWindowToken(), 0);
                this.cordova.getActivity().openOptionsMenu();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        if (n == 4) {
            if (this.mCustomView != null) {
                this.hideCustomView();
            }
            else {
                if (this.isButtonPlumbedToJs(4)) {
                    this.loadUrl("javascript:cordova.fireDocumentEvent('backbutton');");
                    return true;
                }
                if (!this.backHistory()) {
                    return super.onKeyUp(n, keyEvent);
                }
            }
            return true;
        }
        if (n == 82) {
            if (this.lastMenuEventTime < keyEvent.getEventTime()) {
                this.loadUrl("javascript:cordova.fireDocumentEvent('menubutton');");
            }
            this.lastMenuEventTime = keyEvent.getEventTime();
            return super.onKeyUp(n, keyEvent);
        }
        if (n == 84) {
            this.loadUrl("javascript:cordova.fireDocumentEvent('searchbutton');");
            return true;
        }
        return super.onKeyUp(n, keyEvent);
    }
    
    public void onNewIntent(final Intent intent) {
        if (this.pluginManager != null) {
            this.pluginManager.onNewIntent(intent);
        }
    }
    
    public void onScrollChanged(final int n, final int n2, final int n3, final int n4) {
        super.onScrollChanged(n, n2, n3, n4);
        this.postMessage("onScrollChanged", new ScrollEvent(n, n2, n3, n4, (View)this));
    }
    
    public void postMessage(final String s, final Object o) {
        if (this.pluginManager != null) {
            this.pluginManager.postMessage(s, o);
        }
    }
    
    public void printBackForwardList() {
        final WebBackForwardList copyBackForwardList = this.copyBackForwardList();
        for (int size = copyBackForwardList.getSize(), i = 0; i < size; ++i) {
            LOG.d("CordovaWebView", "The URL at index: " + Integer.toString(i) + " is " + copyBackForwardList.getItemAtIndex(i).getUrl());
        }
    }
    
    public WebBackForwardList restoreState(final Bundle bundle) {
        final WebBackForwardList restoreState = super.restoreState(bundle);
        Log.d("CordovaWebView", "WebView restoration crew now restoring!");
        this.pluginManager.init();
        return restoreState;
    }
    
    @Deprecated
    public void sendJavascript(final String s) {
        this.bridge.getMessageQueue().addJavaScript(s);
    }
    
    public void sendPluginResult(final PluginResult pluginResult, final String s) {
        this.bridge.getMessageQueue().addPluginResult(pluginResult, s);
    }
    
    public void setButtonPlumbedToJs(final int i, final boolean b) {
        switch (i) {
            default: {
                throw new IllegalArgumentException("Unsupported keycode: " + i);
            }
            case 4:
            case 24:
            case 25: {
                if (b) {
                    this.boundKeyCodes.add(i);
                    return;
                }
                this.boundKeyCodes.remove(i);
            }
        }
    }
    
    public void setWebChromeClient(final WebChromeClient webChromeClient) {
        this.chromeClient = (CordovaChromeClient)webChromeClient;
        super.setWebChromeClient(webChromeClient);
    }
    
    public void setWebViewClient(final WebViewClient webViewClient) {
        this.viewClient = (CordovaWebViewClient)webViewClient;
        super.setWebViewClient(webViewClient);
    }
    
    protected boolean shouldRequestFocusOnInit() {
        return true;
    }
    
    public void showCustomView(final View mCustomView, final WebChromeClient$CustomViewCallback mCustomViewCallback) {
        Log.d("CordovaWebView", "showing Custom View");
        if (this.mCustomView != null) {
            mCustomViewCallback.onCustomViewHidden();
            return;
        }
        this.mCustomView = mCustomView;
        this.mCustomViewCallback = mCustomViewCallback;
        final ViewGroup viewGroup = (ViewGroup)this.getParent();
        viewGroup.addView(mCustomView, (ViewGroup$LayoutParams)CordovaWebView.COVER_SCREEN_GRAVITY_CENTER);
        this.setVisibility(8);
        viewGroup.setVisibility(0);
        viewGroup.bringToFront();
    }
    
    public void showWebPage(final String s, final boolean b, final boolean b2, final HashMap<String, Object> hashMap) {
        LOG.d("CordovaWebView", "showWebPage(%s, %b, %b, HashMap", s, b, b2);
        if (b2) {
            this.clearHistory();
        }
        if (!b) {
            if (s.startsWith("file://") || this.internalWhitelist.isUrlWhiteListed(s)) {
                this.loadUrl(s);
                return;
            }
            LOG.w("CordovaWebView", "showWebPage: Cannot load URL into webview since it is not in white list.  Loading into browser instead. (URL=" + s + ")");
        }
        while (true) {
            while (true) {
                Intent intent;
                Uri parse;
                try {
                    intent = new Intent("android.intent.action.VIEW");
                    parse = Uri.parse(s);
                    if ("file".equals(parse.getScheme())) {
                        intent.setDataAndType(parse, this.resourceApi.getMimeType(parse));
                        this.cordova.getActivity().startActivity(intent);
                        return;
                    }
                }
                catch (ActivityNotFoundException ex) {
                    LOG.e("CordovaWebView", "Error loading url " + s, (Throwable)ex);
                    return;
                }
                intent.setData(parse);
                continue;
            }
        }
    }
    
    public boolean startOfHistory() {
        final WebHistoryItem itemAtIndex = this.copyBackForwardList().getItemAtIndex(0);
        boolean equals = false;
        if (itemAtIndex != null) {
            final String url = itemAtIndex.getUrl();
            final String url2 = this.getUrl();
            LOG.d("CordovaWebView", "The current URL is: " + url2);
            LOG.d("CordovaWebView", "The URL at item 0 is: " + url);
            equals = url2.equals(url);
        }
        return equals;
    }
    
    public void stopLoading() {
        this.viewClient.isCurrentlyLoading = false;
        super.stopLoading();
    }
    
    @Deprecated
    public void storeResult(final int n, final int n2, final Intent intent) {
    }
    
    class ActivityResult
    {
        Intent incoming;
        int request;
        int result;
        
        public ActivityResult(final int request, final int result, final Intent incoming) {
            this.request = request;
            this.result = result;
            this.incoming = incoming;
        }
    }
    
    @TargetApi(16)
    private static class Level16Apis
    {
        static void enableUniversalAccess(final WebSettings webSettings) {
            webSettings.setAllowUniversalAccessFromFileURLs(true);
        }
    }
}
