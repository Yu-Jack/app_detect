// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import android.content.DialogInterface$OnCancelListener;
import android.os.Handler;
import java.util.HashMap;
import android.view.MenuItem;
import org.json.JSONException;
import org.json.JSONObject;
import android.view.KeyEvent;
import android.view.Menu;
import android.os.Bundle;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.content.Intent;
import android.annotation.SuppressLint;
import java.util.List;
import android.util.Log;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.content.Context;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.widget.LinearLayout;
import java.util.ArrayList;
import android.app.Activity;

public class CordovaActivity extends Activity implements CordovaInterface
{
    private static int ACTIVITY_EXITING;
    private static int ACTIVITY_RUNNING;
    private static int ACTIVITY_STARTING;
    public static String TAG;
    protected CordovaPlugin activityResultCallback;
    protected boolean activityResultKeepRunning;
    private int activityState;
    protected CordovaWebView appView;
    protected Whitelist externalWhitelist;
    private String initCallbackClass;
    protected Whitelist internalWhitelist;
    protected boolean keepRunning;
    protected String launchUrl;
    protected int loadUrlTimeoutValue;
    protected ArrayList<PluginEntry> pluginEntries;
    protected CordovaPreferences preferences;
    @Deprecated
    protected LinearLayout root;
    protected ProgressDialog spinnerDialog;
    protected Dialog splashDialog;
    protected int splashscreen;
    protected int splashscreenTime;
    private final ExecutorService threadPool;
    @Deprecated
    protected CordovaWebViewClient webViewClient;
    
    static {
        CordovaActivity.TAG = "CordovaActivity";
        CordovaActivity.ACTIVITY_STARTING = 0;
        CordovaActivity.ACTIVITY_RUNNING = 1;
        CordovaActivity.ACTIVITY_EXITING = 2;
    }
    
    public CordovaActivity() {
        this.spinnerDialog = null;
        this.threadPool = Executors.newCachedThreadPool();
        this.activityState = 0;
        this.activityResultCallback = null;
        this.splashscreen = 0;
        this.splashscreenTime = 3000;
        this.loadUrlTimeoutValue = 20000;
        this.keepRunning = true;
    }
    
    @Deprecated
    public void addService(final String s, final String s2) {
        if (this.appView != null && this.appView.pluginManager != null) {
            this.appView.pluginManager.addService(s, s2);
        }
    }
    
    @Deprecated
    public boolean backHistory() {
        return this.appView != null && this.appView.backHistory();
    }
    
    @Deprecated
    public void cancelLoadUrl() {
    }
    
    public void clearAuthenticationTokens() {
        if (this.appView != null && this.appView.viewClient != null) {
            this.appView.viewClient.clearAuthenticationTokens();
        }
    }
    
    @Deprecated
    public void clearCache() {
        if (this.appView == null) {
            this.init();
        }
        this.appView.clearCache(true);
    }
    
    @Deprecated
    public void clearHistory() {
        this.appView.clearHistory();
    }
    
    protected void createViews() {
        final Display defaultDisplay = this.getWindowManager().getDefaultDisplay();
        (this.root = new LinearLayoutSoftKeyboardDetect((Context)this, defaultDisplay.getWidth(), defaultDisplay.getHeight())).setOrientation(1);
        this.root.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -1, 0.0f));
        this.appView.setId(100);
        this.appView.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -1, 1.0f));
        this.appView.setVisibility(4);
        this.root.addView((View)this.appView);
        this.setContentView((View)this.root);
        this.root.setBackgroundColor(this.preferences.getInteger("BackgroundColor", -16777216));
    }
    
    public void displayError(final String s, final String s2, final String s3, final boolean b) {
        this.runOnUiThread((Runnable)new Runnable() {
            @Override
            public void run() {
                try {
                    final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)CordovaActivity.this);
                    alertDialog$Builder.setMessage((CharSequence)s2);
                    alertDialog$Builder.setTitle((CharSequence)s);
                    alertDialog$Builder.setCancelable(false);
                    alertDialog$Builder.setPositiveButton((CharSequence)s3, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                        private final /* synthetic */ CordovaActivity val$me = CordovaActivity.this;
                        
                        public void onClick(final DialogInterface dialogInterface, final int n) {
                            dialogInterface.dismiss();
                            if (b) {
                                this.val$me.endActivity();
                            }
                        }
                    });
                    alertDialog$Builder.create();
                    alertDialog$Builder.show();
                }
                catch (Exception ex) {
                    CordovaActivity.this.finish();
                }
            }
        });
    }
    
    public void endActivity() {
        this.activityState = CordovaActivity.ACTIVITY_EXITING;
        super.finish();
    }
    
    public Activity getActivity() {
        return this;
    }
    
    public AuthenticationToken getAuthenticationToken(final String s, final String s2) {
        if (this.appView != null && this.appView.viewClient != null) {
            return this.appView.viewClient.getAuthenticationToken(s, s2);
        }
        return null;
    }
    
    @Deprecated
    public boolean getBooleanProperty(final String s, final boolean b) {
        return this.preferences.getBoolean(s, b);
    }
    
    @Deprecated
    public Context getContext() {
        LOG.d(CordovaActivity.TAG, "This will be deprecated December 2012");
        return (Context)this;
    }
    
    @Deprecated
    public double getDoubleProperty(final String s, final double n) {
        return this.preferences.getDouble(s, n);
    }
    
    @Deprecated
    public int getIntegerProperty(final String s, final int n) {
        return this.preferences.getInteger(s, n);
    }
    
    @Deprecated
    public String getStringProperty(final String s, final String s2) {
        return this.preferences.getString(s, s2);
    }
    
    public ExecutorService getThreadPool() {
        return this.threadPool;
    }
    
    public void init() {
        this.init(this.appView, null, null);
    }
    
    @Deprecated
    @SuppressLint({ "NewApi" })
    public void init(CordovaWebView webView, final CordovaWebViewClient cordovaWebViewClient, final CordovaChromeClient cordovaChromeClient) {
        LOG.d(CordovaActivity.TAG, "CordovaActivity.init()");
        if (!this.preferences.getBoolean("ShowTitle", false)) {
            this.getWindow().requestFeature(1);
        }
        if (this.preferences.getBoolean("SetFullscreen", false)) {
            Log.d(CordovaActivity.TAG, "The SetFullscreen configuration is deprecated in favor of Fullscreen, and will be removed in a future version.");
            this.getWindow().setFlags(1024, 1024);
        }
        else if (this.preferences.getBoolean("Fullscreen", false)) {
            this.getWindow().setFlags(1024, 1024);
        }
        else {
            this.getWindow().setFlags(2048, 2048);
        }
        if (webView == null) {
            webView = this.makeWebView();
        }
        this.appView = webView;
        if (this.appView.pluginManager == null) {
            final CordovaWebView appView = this.appView;
            CordovaWebViewClient webViewClient;
            if (cordovaWebViewClient != null) {
                webViewClient = cordovaWebViewClient;
            }
            else {
                webViewClient = this.makeWebViewClient(this.appView);
            }
            CordovaChromeClient chromeClient;
            if (cordovaChromeClient != null) {
                chromeClient = cordovaChromeClient;
            }
            else {
                chromeClient = this.makeChromeClient(this.appView);
            }
            appView.init(this, webViewClient, chromeClient, this.pluginEntries, this.internalWhitelist, this.externalWhitelist, this.preferences);
        }
        if (this.preferences.getBoolean("DisallowOverscroll", false)) {
            this.appView.setOverScrollMode(2);
        }
        this.createViews();
        this.setVolumeControlStream(3);
    }
    
    @Deprecated
    public boolean isUrlWhiteListed(final String s) {
        return this.internalWhitelist.isUrlWhiteListed(s);
    }
    
    protected void loadConfig() {
        final ConfigXmlParser parser = new ConfigXmlParser();
        parser.parse(this);
        (this.preferences = parser.getPreferences()).setPreferencesBundle(this.getIntent().getExtras());
        this.preferences.copyIntoIntentExtras(this);
        this.internalWhitelist = parser.getInternalWhitelist();
        this.externalWhitelist = parser.getExternalWhitelist();
        this.launchUrl = parser.getLaunchUrl();
        this.pluginEntries = parser.getPluginEntries();
        Config.parser = parser;
    }
    
    void loadSpinner() {
        String s;
        if (this.appView == null || !this.appView.canGoBack()) {
            s = this.preferences.getString("LoadingDialog", null);
        }
        else {
            s = this.preferences.getString("LoadingPageDialog", null);
        }
        if (s != null) {
            String substring = "";
            String substring2 = "Loading Application...";
            if (s.length() > 0) {
                final int index = s.indexOf(44);
                if (index > 0) {
                    substring = s.substring(0, index);
                    substring2 = s.substring(index + 1);
                }
                else {
                    substring = "";
                    substring2 = s;
                }
            }
            this.spinnerStart(substring, substring2);
        }
    }
    
    public void loadUrl(final String s) {
        if (this.appView == null) {
            this.init();
        }
        this.splashscreenTime = this.preferences.getInteger("SplashScreenDelay", this.splashscreenTime);
        final String string = this.preferences.getString("SplashScreen", null);
        if (this.splashscreenTime > 0 && string != null) {
            this.splashscreen = this.getResources().getIdentifier(string, "drawable", this.getClass().getPackage().getName());
            if (this.splashscreen != 0) {
                this.showSplashScreen(this.splashscreenTime);
            }
        }
        this.keepRunning = this.preferences.getBoolean("KeepRunning", true);
        if (this.appView.getParent() != null) {
            this.loadSpinner();
        }
        if (this.splashscreen != 0) {
            this.appView.loadUrl(s, this.splashscreenTime);
            return;
        }
        this.appView.loadUrl(s);
    }
    
    public void loadUrl(final String s, final int splashscreenTime) {
        this.splashscreenTime = splashscreenTime;
        this.loadUrl(s);
    }
    
    protected CordovaChromeClient makeChromeClient(final CordovaWebView cordovaWebView) {
        return cordovaWebView.makeWebChromeClient(this);
    }
    
    protected CordovaWebView makeWebView() {
        return new CordovaWebView((Context)this);
    }
    
    protected CordovaWebViewClient makeWebViewClient(final CordovaWebView cordovaWebView) {
        return cordovaWebView.makeWebViewClient(this);
    }
    
    protected void onActivityResult(final int i, final int n, final Intent intent) {
        LOG.d(CordovaActivity.TAG, "Incoming Result");
        super.onActivityResult(i, n, intent);
        Log.d(CordovaActivity.TAG, "Request code = " + i);
        Label_0128: {
            if (this.appView == null || i != 5173) {
                break Label_0128;
            }
            final ValueCallback<Uri> valueCallback = this.appView.getWebChromeClient().getValueCallback();
            Log.d(CordovaActivity.TAG, "did we get here?");
            if (valueCallback != null) {
                Object data;
                if (intent == null || n != -1) {
                    data = null;
                }
                else {
                    data = intent.getData();
                }
                Log.d(CordovaActivity.TAG, "result = " + data);
                valueCallback.onReceiveValue(data);
                break Label_0128;
            }
            return;
        }
        CordovaPlugin cordovaPlugin = this.activityResultCallback;
        if (cordovaPlugin == null && this.initCallbackClass != null) {
            this.activityResultCallback = this.appView.pluginManager.getPlugin(this.initCallbackClass);
            cordovaPlugin = this.activityResultCallback;
        }
        if (cordovaPlugin != null) {
            LOG.d(CordovaActivity.TAG, "We have a callback to send this result to");
            cordovaPlugin.onActivityResult(i, n, intent);
        }
    }
    
    public void onCreate(final Bundle bundle) {
        LOG.i(CordovaActivity.TAG, "Apache Cordova native platform version 3.6.3 is starting");
        LOG.d(CordovaActivity.TAG, "CordovaActivity.onCreate()");
        super.onCreate(bundle);
        if (bundle != null) {
            this.initCallbackClass = bundle.getString("callbackClass");
        }
        this.loadConfig();
    }
    
    public boolean onCreateOptionsMenu(final Menu menu) {
        this.postMessage("onCreateOptionsMenu", menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    public void onDestroy() {
        LOG.d(CordovaActivity.TAG, "CordovaActivity.onDestroy()");
        super.onDestroy();
        this.removeSplashScreen();
        if (this.appView != null) {
            this.appView.handleDestroy();
            return;
        }
        this.activityState = CordovaActivity.ACTIVITY_EXITING;
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        if (this.appView != null && this.appView.getFocusedChild() != null && (n == 4 || n == 82)) {
            return this.appView.onKeyDown(n, keyEvent);
        }
        return super.onKeyDown(n, keyEvent);
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        if (this.appView != null && (this.appView.isCustomViewShowing() || this.appView.getFocusedChild() != null) && (n == 4 || n == 82)) {
            return this.appView.onKeyUp(n, keyEvent);
        }
        return super.onKeyUp(n, keyEvent);
    }
    
    public Object onMessage(final String s, final Object obj) {
        if (!"onScrollChanged".equals(s)) {
            LOG.d(CordovaActivity.TAG, "onMessage(" + s + "," + obj + ")");
        }
        if ("splashscreen".equals(s)) {
            if ("hide".equals(obj.toString())) {
                this.removeSplashScreen();
            }
            else if (this.splashDialog == null || !this.splashDialog.isShowing()) {
                final String string = this.preferences.getString("SplashScreen", null);
                if (string != null) {
                    this.splashscreen = this.getResources().getIdentifier(string, "drawable", this.getClass().getPackage().getName());
                }
                this.showSplashScreen(this.splashscreenTime);
                return null;
            }
        }
        else if ("spinner".equals(s)) {
            if ("stop".equals(obj.toString())) {
                this.spinnerStop();
                this.appView.setVisibility(0);
                return null;
            }
        }
        else {
            if ("onReceivedError".equals(s)) {
                final JSONObject jsonObject = (JSONObject)obj;
                try {
                    this.onReceivedError(jsonObject.getInt("errorCode"), jsonObject.getString("description"), jsonObject.getString("url"));
                    return null;
                }
                catch (JSONException ex) {
                    ex.printStackTrace();
                    return null;
                }
            }
            if ("exit".equals(s)) {
                this.endActivity();
                return null;
            }
        }
        return null;
    }
    
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        if (this.appView != null) {
            this.appView.onNewIntent(intent);
        }
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        this.postMessage("onOptionsItemSelected", menuItem);
        return true;
    }
    
    protected void onPause() {
        super.onPause();
        LOG.d(CordovaActivity.TAG, "Paused the application!");
        if (this.activityState != CordovaActivity.ACTIVITY_EXITING && this.appView != null) {
            this.appView.handlePause(this.keepRunning);
            this.removeSplashScreen();
        }
    }
    
    public boolean onPrepareOptionsMenu(final Menu menu) {
        this.postMessage("onPrepareOptionsMenu", menu);
        return true;
    }
    
    public void onReceivedError(final int n, final String s, final String s2) {
        final String string = this.preferences.getString("errorUrl", null);
        if (string != null && (string.startsWith("file://") || this.internalWhitelist.isUrlWhiteListed(string)) && !s2.equals(string)) {
            this.runOnUiThread((Runnable)new Runnable() {
                @Override
                public void run() {
                    CordovaActivity.this.spinnerStop();
                    CordovaActivity.this.appView.showWebPage(string, false, true, null);
                }
            });
            return;
        }
        this.runOnUiThread((Runnable)new Runnable() {
            private final /* synthetic */ boolean val$exit = n != -2;
            
            @Override
            public void run() {
                if (this.val$exit) {
                    CordovaActivity.this.appView.setVisibility(8);
                    CordovaActivity.this.displayError("Application Error", String.valueOf(s) + " (" + s2 + ")", "OK", this.val$exit);
                }
            }
        });
    }
    
    protected void onResume() {
        super.onResume();
        LOG.d(CordovaActivity.TAG, "Resuming the App");
        if (this.activityState == CordovaActivity.ACTIVITY_STARTING) {
            this.activityState = CordovaActivity.ACTIVITY_RUNNING;
        }
        else if (this.appView != null) {
            this.getWindow().getDecorView().requestFocus();
            this.appView.handleResume(this.keepRunning, this.activityResultKeepRunning);
            if ((!this.keepRunning || this.activityResultKeepRunning) && this.activityResultKeepRunning) {
                this.keepRunning = this.activityResultKeepRunning;
                this.activityResultKeepRunning = false;
            }
        }
    }
    
    protected void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.activityResultCallback != null) {
            bundle.putString("callbackClass", this.activityResultCallback.getClass().getName());
        }
    }
    
    public void postMessage(final String s, final Object o) {
        if (this.appView != null) {
            this.appView.postMessage(s, o);
        }
    }
    
    public AuthenticationToken removeAuthenticationToken(final String s, final String s2) {
        if (this.appView != null && this.appView.viewClient != null) {
            return this.appView.viewClient.removeAuthenticationToken(s, s2);
        }
        return null;
    }
    
    public void removeSplashScreen() {
        if (this.splashDialog != null && this.splashDialog.isShowing()) {
            this.splashDialog.dismiss();
            this.splashDialog = null;
        }
    }
    
    @Deprecated
    public void sendJavascript(final String s) {
        if (this.appView != null) {
            this.appView.bridge.getMessageQueue().addJavaScript(s);
        }
    }
    
    public void setActivityResultCallback(final CordovaPlugin activityResultCallback) {
        this.activityResultCallback = activityResultCallback;
    }
    
    public void setAuthenticationToken(final AuthenticationToken authenticationToken, final String s, final String s2) {
        if (this.appView != null && this.appView.viewClient != null) {
            this.appView.viewClient.setAuthenticationToken(authenticationToken, s, s2);
        }
    }
    
    @Deprecated
    public void setBooleanProperty(final String s, final boolean b) {
        Log.d(CordovaActivity.TAG, "Setting boolean properties in CordovaActivity will be deprecated in 3.0 on July 2013, please use config.xml");
        this.getIntent().putExtra(s.toLowerCase(), b);
    }
    
    @Deprecated
    public void setDoubleProperty(final String s, final double n) {
        Log.d(CordovaActivity.TAG, "Setting double properties in CordovaActivity will be deprecated in 3.0 on July 2013, please use config.xml");
        this.getIntent().putExtra(s.toLowerCase(), n);
    }
    
    @Deprecated
    public void setIntegerProperty(final String s, final int n) {
        Log.d(CordovaActivity.TAG, "Setting integer properties in CordovaActivity will be deprecated in 3.0 on July 2013, please use config.xml");
        this.getIntent().putExtra(s.toLowerCase(), n);
    }
    
    @Deprecated
    public void setStringProperty(final String s, final String s2) {
        Log.d(CordovaActivity.TAG, "Setting string properties in CordovaActivity will be deprecated in 3.0 on July 2013, please use config.xml");
        this.getIntent().putExtra(s.toLowerCase(), s2);
    }
    
    protected void showSplashScreen(final int n) {
        this.runOnUiThread((Runnable)new Runnable() {
            @Override
            public void run() {
                final Display defaultDisplay = CordovaActivity.this.getWindowManager().getDefaultDisplay();
                final LinearLayout contentView = new LinearLayout((Context)CordovaActivity.this.getActivity());
                contentView.setMinimumHeight(defaultDisplay.getHeight());
                contentView.setMinimumWidth(defaultDisplay.getWidth());
                contentView.setOrientation(1);
                contentView.setBackgroundColor(CordovaActivity.this.preferences.getInteger("backgroundColor", -16777216));
                contentView.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -1, 0.0f));
                contentView.setBackgroundResource(CordovaActivity.this.splashscreen);
                CordovaActivity.this.splashDialog = new Dialog((Context)CordovaActivity.this, 16973840);
                if ((0x400 & CordovaActivity.this.getWindow().getAttributes().flags) == 0x400) {
                    CordovaActivity.this.splashDialog.getWindow().setFlags(1024, 1024);
                }
                CordovaActivity.this.splashDialog.setContentView((View)contentView);
                CordovaActivity.this.splashDialog.setCancelable(false);
                CordovaActivity.this.splashDialog.show();
                new Handler().postDelayed((Runnable)new Runnable() {
                    @Override
                    public void run() {
                        CordovaActivity.this.removeSplashScreen();
                    }
                }, (long)n);
            }
        });
    }
    
    @Deprecated
    public void showWebPage(final String s, final boolean b, final boolean b2, final HashMap<String, Object> hashMap) {
        if (this.appView != null) {
            this.appView.showWebPage(s, b, b2, hashMap);
        }
    }
    
    public void spinnerStart(final String s, final String s2) {
        if (this.spinnerDialog != null) {
            this.spinnerDialog.dismiss();
            this.spinnerDialog = null;
        }
        this.spinnerDialog = ProgressDialog.show((Context)this, (CharSequence)s, (CharSequence)s2, true, true, (DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener() {
            public void onCancel(final DialogInterface dialogInterface) {
                CordovaActivity.this.spinnerDialog = null;
            }
        });
    }
    
    public void spinnerStop() {
        if (this.spinnerDialog != null && this.spinnerDialog.isShowing()) {
            this.spinnerDialog.dismiss();
            this.spinnerDialog = null;
        }
    }
    
    public void startActivityForResult(final CordovaPlugin activityResultCallback, final Intent intent, final int n) {
        this.activityResultCallback = activityResultCallback;
        this.activityResultKeepRunning = this.keepRunning;
        if (activityResultCallback != null) {
            this.keepRunning = false;
        }
        super.startActivityForResult(intent, n);
    }
}
