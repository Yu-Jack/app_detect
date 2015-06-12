// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.inappbrowser;

import android.graphics.Bitmap;
import android.annotation.TargetApi;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.graphics.drawable.Drawable;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.WindowManager$LayoutParams;
import android.webkit.CookieManager;
import android.webkit.WebSettings$PluginState;
import android.webkit.WebChromeClient;
import android.widget.LinearLayout$LayoutParams;
import android.widget.Button;
import android.view.View$OnClickListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View$OnKeyListener;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.widget.RelativeLayout;
import android.widget.LinearLayout;
import android.content.Context;
import android.util.TypedValue;
import org.apache.cordova.CordovaWebView;
import android.content.ActivityNotFoundException;
import org.apache.cordova.LOG;
import android.net.Uri;
import android.content.Intent;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaArgs;
import org.json.JSONException;
import android.util.Log;
import android.webkit.WebViewClient;
import java.util.StringTokenizer;
import java.util.HashMap;
import android.view.inputmethod.InputMethodManager;
import android.webkit.ValueCallback;
import android.os.Build$VERSION;
import org.json.JSONArray;
import org.apache.cordova.PluginResult;
import org.json.JSONObject;
import android.webkit.WebView;
import android.widget.EditText;
import org.apache.cordova.CallbackContext;
import android.annotation.SuppressLint;
import org.apache.cordova.CordovaPlugin;

@SuppressLint({ "SetJavaScriptEnabled" })
public class InAppBrowser extends CordovaPlugin
{
    private static final String CLEAR_ALL_CACHE = "clearcache";
    private static final String CLEAR_SESSION_CACHE = "clearsessioncache";
    private static final String CLOCATION = "clocation";
    private static final String CLOSE_BUTTON_CAPTION = "closebuttoncaption";
    private static final String EXIT_EVENT = "exit";
    private static final String HIDDEN = "hidden";
    private static final String LOAD_ERROR_EVENT = "loaderror";
    private static final String LOAD_START_EVENT = "loadstart";
    private static final String LOAD_STOP_EVENT = "loadstop";
    private static final String LOCATION = "location";
    protected static final String LOG_TAG = "InAppBrowser";
    private static final String NULL = "null";
    private static final String SELF = "_self";
    private static final String SYSTEM = "_system";
    private String buttonLabel;
    private CallbackContext callbackContext;
    private boolean clearAllCache;
    private boolean clearSessionCache;
    private InAppBrowserDialog dialog;
    private EditText edittext;
    private WebView inAppWebView;
    private boolean openWindowHidden;
    private boolean showCLocationBar;
    private boolean showLocationBar;
    
    public InAppBrowser() {
        this.showLocationBar = true;
        this.showCLocationBar = false;
        this.openWindowHidden = false;
        this.buttonLabel = "Done";
        this.clearAllCache = false;
        this.clearSessionCache = false;
    }
    
    static /* synthetic */ void access$10(final InAppBrowser inAppBrowser, final WebView inAppWebView) {
        inAppBrowser.inAppWebView = inAppWebView;
    }
    
    static /* synthetic */ void access$4(final InAppBrowser inAppBrowser, final InAppBrowserDialog dialog) {
        inAppBrowser.dialog = dialog;
    }
    
    static /* synthetic */ void access$7(final InAppBrowser inAppBrowser, final EditText edittext) {
        inAppBrowser.edittext = edittext;
    }
    
    private InAppBrowser getInAppBrowser() {
        return this;
    }
    
    private boolean getShowCLocationBar() {
        return this.showCLocationBar;
    }
    
    private boolean getShowLocationBar() {
        return this.showLocationBar;
    }
    
    private void goBack() {
        if (this.inAppWebView.canGoBack()) {
            this.inAppWebView.goBack();
        }
    }
    
    private void goBlank() {
        this.openExternal(this.inAppWebView.getUrl());
    }
    
    private void goForward() {
        if (this.inAppWebView.canGoForward()) {
            this.inAppWebView.goForward();
        }
    }
    
    private void goReload() {
        this.inAppWebView.reload();
    }
    
    private void injectDeferredObject(final String s, final String format) {
        String format2;
        if (format != null) {
            final JSONArray jsonArray = new JSONArray();
            jsonArray.put((Object)s);
            final String string = jsonArray.toString();
            format2 = String.format(format, string.substring(1, -1 + string.length()));
        }
        else {
            format2 = s;
        }
        this.cordova.getActivity().runOnUiThread((Runnable)new Runnable() {
            @SuppressLint({ "NewApi" })
            @Override
            public void run() {
                if (Build$VERSION.SDK_INT < 19) {
                    InAppBrowser.this.inAppWebView.loadUrl("javascript:" + format2);
                    return;
                }
                InAppBrowser.this.inAppWebView.evaluateJavascript(format2, (ValueCallback)null);
            }
        });
    }
    
    private void navigate(final String str) {
        ((InputMethodManager)this.cordova.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.edittext.getWindowToken(), 0);
        if (!str.startsWith("http") && !str.startsWith("file:")) {
            this.inAppWebView.loadUrl("http://" + str);
        }
        else {
            this.inAppWebView.loadUrl(str);
        }
        this.inAppWebView.requestFocus();
    }
    
    private HashMap<String, Boolean> parseFeature(final String str) {
        HashMap<String, Boolean> hashMap;
        if (str.equals("null")) {
            hashMap = null;
        }
        else {
            hashMap = new HashMap<String, Boolean>();
            final StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
            while (stringTokenizer.hasMoreElements()) {
                final StringTokenizer stringTokenizer2 = new StringTokenizer(stringTokenizer.nextToken(), "=");
                if (stringTokenizer2.hasMoreElements()) {
                    final String nextToken = stringTokenizer2.nextToken();
                    if (nextToken.equalsIgnoreCase("closebuttoncaption")) {
                        this.buttonLabel = stringTokenizer2.nextToken();
                    }
                    else {
                        Boolean value;
                        if (stringTokenizer2.nextToken().equals("no")) {
                            value = Boolean.FALSE;
                        }
                        else {
                            value = Boolean.TRUE;
                        }
                        hashMap.put(nextToken, value);
                    }
                }
            }
        }
        return hashMap;
    }
    
    private void sendUpdate(final JSONObject jsonObject, final boolean b) {
        this.sendUpdate(jsonObject, b, PluginResult.Status.OK);
    }
    
    private void sendUpdate(final JSONObject jsonObject, final boolean keepCallback, final PluginResult.Status status) {
        if (this.callbackContext != null) {
            final PluginResult pluginResult = new PluginResult(status, jsonObject);
            pluginResult.setKeepCallback(keepCallback);
            this.callbackContext.sendPluginResult(pluginResult);
            if (!keepCallback) {
                this.callbackContext = null;
            }
        }
    }
    
    public void closeDialog() {
        final WebView inAppWebView = this.inAppWebView;
        if (inAppWebView == null) {
            return;
        }
        this.cordova.getActivity().runOnUiThread((Runnable)new Runnable() {
            @Override
            public void run() {
                inAppWebView.setWebViewClient((WebViewClient)new WebViewClient() {
                    public void onPageFinished(final WebView webView, final String s) {
                        if (InAppBrowser.this.dialog != null) {
                            InAppBrowser.this.dialog.dismiss();
                        }
                    }
                });
                inAppWebView.loadUrl("about:blank");
            }
        });
        try {
            final JSONObject jsonObject = new JSONObject();
            jsonObject.put("type", (Object)"exit");
            this.sendUpdate(jsonObject, false);
        }
        catch (JSONException ex) {
            Log.d("InAppBrowser", "Should never happen");
        }
    }
    
    @Override
    public boolean execute(final String s, final CordovaArgs cordovaArgs, final CallbackContext callbackContext) throws JSONException {
        if (s.equals("open")) {
            this.callbackContext = callbackContext;
            final String string = cordovaArgs.getString(0);
            String optString = cordovaArgs.optString(1);
            if (optString == null || optString.equals("") || optString.equals("null")) {
                optString = "_self";
            }
            final String str = optString;
            final HashMap<String, Boolean> feature = this.parseFeature(cordovaArgs.optString(2));
            Log.d("InAppBrowser", "target = " + str);
            this.cordova.getActivity().runOnUiThread((Runnable)new Runnable() {
                @Override
                public void run() {
                    String s = "";
                    if ("_self".equals(str)) {
                        Log.d("InAppBrowser", "in self");
                        if (string.startsWith("file://") || string.startsWith("javascript:") || Config.isUrlWhiteListed(string)) {
                            InAppBrowser.this.webView.loadUrl(string);
                        }
                        else if (string.startsWith("tel:")) {
                            try {
                                final Intent intent = new Intent("android.intent.action.DIAL");
                                intent.setData(Uri.parse(string));
                                InAppBrowser.this.cordova.getActivity().startActivity(intent);
                            }
                            catch (ActivityNotFoundException ex) {
                                LOG.e("InAppBrowser", "Error dialing " + string + ": " + ex.toString());
                            }
                        }
                        else {
                            s = InAppBrowser.this.showWebPage(string, feature);
                        }
                    }
                    else if ("_system".equals(str)) {
                        Log.d("InAppBrowser", "in system");
                        s = InAppBrowser.this.openExternal(string);
                    }
                    else {
                        Log.d("InAppBrowser", "in blank");
                        s = InAppBrowser.this.showWebPage(string, feature);
                    }
                    final PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, s);
                    pluginResult.setKeepCallback(true);
                    callbackContext.sendPluginResult(pluginResult);
                }
            });
        }
        else if (s.equals("close")) {
            this.closeDialog();
        }
        else if (s.equals("injectScriptCode")) {
            final boolean boolean1 = cordovaArgs.getBoolean(1);
            String format = null;
            if (boolean1) {
                format = String.format("prompt(JSON.stringify([eval(%%s)]), 'gap-iab://%s')", callbackContext.getCallbackId());
            }
            this.injectDeferredObject(cordovaArgs.getString(0), format);
        }
        else if (s.equals("injectScriptFile")) {
            String format2;
            if (cordovaArgs.getBoolean(1)) {
                format2 = String.format("(function(d) { var c = d.createElement('script'); c.src = %%s; c.onload = function() { prompt('', 'gap-iab://%s'); }; d.body.appendChild(c); })(document)", callbackContext.getCallbackId());
            }
            else {
                format2 = "(function(d) { var c = d.createElement('script'); c.src = %s; d.body.appendChild(c); })(document)";
            }
            this.injectDeferredObject(cordovaArgs.getString(0), format2);
        }
        else if (s.equals("injectStyleCode")) {
            String format3;
            if (cordovaArgs.getBoolean(1)) {
                format3 = String.format("(function(d) { var c = d.createElement('style'); c.innerHTML = %%s; d.body.appendChild(c); prompt('', 'gap-iab://%s');})(document)", callbackContext.getCallbackId());
            }
            else {
                format3 = "(function(d) { var c = d.createElement('style'); c.innerHTML = %s; d.body.appendChild(c); })(document)";
            }
            this.injectDeferredObject(cordovaArgs.getString(0), format3);
        }
        else if (s.equals("injectStyleFile")) {
            String format4;
            if (cordovaArgs.getBoolean(1)) {
                format4 = String.format("(function(d) { var c = d.createElement('link'); c.rel='stylesheet'; c.type='text/css'; c.href = %%s; d.head.appendChild(c); prompt('', 'gap-iab://%s');})(document)", callbackContext.getCallbackId());
            }
            else {
                format4 = "(function(d) { var c = d.createElement('link'); c.rel='stylesheet'; c.type='text/css'; c.href = %s; d.head.appendChild(c); })(document)";
            }
            this.injectDeferredObject(cordovaArgs.getString(0), format4);
        }
        else {
            final boolean equals = s.equals("show");
            final boolean b = false;
            if (!equals) {
                return b;
            }
            this.cordova.getActivity().runOnUiThread((Runnable)new Runnable() {
                @Override
                public void run() {
                    InAppBrowser.this.dialog.show();
                }
            });
            final PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
            pluginResult.setKeepCallback(true);
            this.callbackContext.sendPluginResult(pluginResult);
        }
        return true;
    }
    
    @Override
    public void onDestroy() {
        this.closeDialog();
    }
    
    @Override
    public void onReset() {
        this.closeDialog();
    }
    
    public String openExternal(final String str) {
        while (true) {
            try {
                final Intent intent = new Intent("android.intent.action.VIEW");
                try {
                    final Uri parse = Uri.parse(str);
                    if ("file".equals(parse.getScheme())) {
                        intent.setDataAndType(parse, this.webView.getResourceApi().getMimeType(parse));
                    }
                    else {
                        intent.setData(parse);
                    }
                    this.cordova.getActivity().startActivity(intent);
                    return "";
                }
                catch (ActivityNotFoundException ex2) {}
                final ActivityNotFoundException ex;
                Log.d("InAppBrowser", "InAppBrowser: Error loading url " + str + ":" + ex.toString());
                return ex.toString();
            }
            catch (ActivityNotFoundException ex) {
                continue;
            }
            break;
        }
    }
    
    public String showWebPage(final String s, final HashMap<String, Boolean> hashMap) {
        this.showLocationBar = true;
        this.openWindowHidden = false;
        if (hashMap != null) {
            final Boolean b = hashMap.get("location");
            if (b != null) {
                this.showLocationBar = b;
            }
            final Boolean b2 = hashMap.get("clocation");
            if (b2 != null) {
                this.showCLocationBar = b2;
            }
            final Boolean b3 = hashMap.get("hidden");
            if (b3 != null) {
                this.openWindowHidden = b3;
            }
            final Boolean b4 = hashMap.get("clearcache");
            if (b4 != null) {
                this.clearAllCache = b4;
            }
            else {
                final Boolean b5 = hashMap.get("clearsessioncache");
                if (b5 != null) {
                    this.clearSessionCache = b5;
                }
            }
        }
        this.cordova.getActivity().runOnUiThread((Runnable)new Runnable() {
            private final /* synthetic */ CordovaWebView val$thatWebView = InAppBrowser.this.webView;
            
            private int dpToPixels(final int n) {
                return (int)TypedValue.applyDimension(1, (float)n, InAppBrowser.this.cordova.getActivity().getResources().getDisplayMetrics());
            }
            
            @TargetApi(16)
            @Override
            public void run() {
                InAppBrowser.access$4(InAppBrowser.this, new InAppBrowserDialog((Context)InAppBrowser.this.cordova.getActivity(), 16973830));
                InAppBrowser.this.dialog.getWindow().getAttributes().windowAnimations = 16973826;
                InAppBrowser.this.dialog.requestWindowFeature(1);
                InAppBrowser.this.dialog.setCancelable(true);
                InAppBrowser.this.dialog.setInAppBroswer(InAppBrowser.this.getInAppBrowser());
                final LinearLayout contentView = new LinearLayout((Context)InAppBrowser.this.cordova.getActivity());
                contentView.setOrientation(1);
                if (InAppBrowser.this.getShowLocationBar()) {
                    final RelativeLayout relativeLayout = new RelativeLayout((Context)InAppBrowser.this.cordova.getActivity());
                    relativeLayout.setBackgroundColor(-1);
                    relativeLayout.setLayoutParams((ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, this.dpToPixels(44)));
                    relativeLayout.setPadding(this.dpToPixels(2), this.dpToPixels(2), this.dpToPixels(2), this.dpToPixels(2));
                    relativeLayout.setHorizontalGravity(3);
                    relativeLayout.setVerticalGravity(48);
                    final Resources resources = InAppBrowser.this.cordova.getActivity().getResources();
                    InAppBrowser.access$7(InAppBrowser.this, new EditText((Context)InAppBrowser.this.cordova.getActivity()));
                    final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(-1, -1);
                    layoutParams.addRule(1, 1);
                    layoutParams.addRule(0, 5);
                    InAppBrowser.this.edittext.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                    InAppBrowser.this.edittext.setPadding(this.dpToPixels(5), this.dpToPixels(0), this.dpToPixels(0), this.dpToPixels(0));
                    InAppBrowser.this.edittext.setBackgroundColor(-1);
                    InAppBrowser.this.edittext.setId(4);
                    InAppBrowser.this.edittext.setSingleLine(true);
                    InAppBrowser.this.edittext.setTextColor(-7829368);
                    InAppBrowser.this.edittext.setText((CharSequence)"\u2588 \u2588 \u2588");
                    InAppBrowser.this.edittext.setInputType(16);
                    InAppBrowser.this.edittext.setImeOptions(2);
                    InAppBrowser.this.edittext.setInputType(0);
                    InAppBrowser.this.edittext.setOnKeyListener((View$OnKeyListener)new View$OnKeyListener() {
                        public boolean onKey(final View view, final int n, final KeyEvent keyEvent) {
                            if (keyEvent.getAction() == 0 && n == 66) {
                                InAppBrowser.this.navigate(InAppBrowser.this.edittext.getText().toString());
                                return true;
                            }
                            return false;
                        }
                    });
                    InAppBrowser.this.edittext.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
                        public void onClick(final View view) {
                            InAppBrowser.this.closeDialog();
                        }
                    });
                    final Button button = new Button((Context)InAppBrowser.this.cordova.getActivity());
                    button.setLayoutParams((ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-2, -1));
                    button.setContentDescription((CharSequence)"Close Button");
                    button.setId(1);
                    final Drawable drawable = resources.getDrawable(resources.getIdentifier("ic_action_remove", "drawable", InAppBrowser.this.cordova.getActivity().getPackageName()));
                    if (Build$VERSION.SDK_INT < 16) {
                        button.setBackgroundDrawable(drawable);
                    }
                    else {
                        button.setBackground(drawable);
                    }
                    button.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
                        public void onClick(final View view) {
                            InAppBrowser.this.closeDialog();
                        }
                    });
                    relativeLayout.addView((View)button);
                    relativeLayout.addView((View)InAppBrowser.this.edittext);
                    contentView.addView((View)relativeLayout);
                }
                InAppBrowser.access$10(InAppBrowser.this, new WebView((Context)InAppBrowser.this.cordova.getActivity()));
                InAppBrowser.this.inAppWebView.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -1));
                InAppBrowser.this.inAppWebView.setWebChromeClient((WebChromeClient)new InAppChromeClient(this.val$thatWebView) {
                    public void onProgressChanged(final WebView webView, final int n) {
                        if (InAppBrowser.this.getShowLocationBar()) {
                            InAppBrowser.this.edittext.setText((CharSequence)(String.valueOf(InAppBrowser.this.edittext.getText().toString()) + " \u2588 \u2588 \u2588"));
                            if (n == 100) {
                                InAppBrowser.this.edittext.setText((CharSequence)"\u5b85\u5b85\u65b0\u805e");
                            }
                        }
                    }
                });
                InAppBrowser.this.inAppWebView.setWebViewClient((WebViewClient)new InAppBrowserClient(this.val$thatWebView, InAppBrowser.this.edittext));
                final WebSettings settings = InAppBrowser.this.inAppWebView.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setJavaScriptCanOpenWindowsAutomatically(true);
                settings.setBuiltInZoomControls(true);
                settings.setPluginState(WebSettings$PluginState.ON);
                final Bundle extras = InAppBrowser.this.cordova.getActivity().getIntent().getExtras();
                if (extras == null || extras.getBoolean("InAppBrowserStorageEnabled", true)) {
                    settings.setDatabasePath(InAppBrowser.this.cordova.getActivity().getApplicationContext().getDir("inAppBrowserDB", 0).getPath());
                    settings.setDatabaseEnabled(true);
                }
                settings.setDomStorageEnabled(true);
                if (InAppBrowser.this.clearAllCache) {
                    CookieManager.getInstance().removeAllCookie();
                }
                else if (InAppBrowser.this.clearSessionCache) {
                    CookieManager.getInstance().removeSessionCookie();
                }
                InAppBrowser.this.inAppWebView.loadUrl(s);
                InAppBrowser.this.inAppWebView.setId(6);
                InAppBrowser.this.inAppWebView.getSettings().setLoadWithOverviewMode(true);
                InAppBrowser.this.inAppWebView.getSettings().setUseWideViewPort(true);
                InAppBrowser.this.inAppWebView.requestFocus();
                InAppBrowser.this.inAppWebView.requestFocusFromTouch();
                contentView.addView((View)InAppBrowser.this.inAppWebView);
                final WindowManager$LayoutParams attributes = new WindowManager$LayoutParams();
                attributes.copyFrom(InAppBrowser.this.dialog.getWindow().getAttributes());
                attributes.width = -1;
                attributes.height = -1;
                InAppBrowser.this.dialog.setContentView((View)contentView);
                InAppBrowser.this.dialog.show();
                InAppBrowser.this.dialog.getWindow().setAttributes(attributes);
                if (InAppBrowser.this.openWindowHidden) {
                    InAppBrowser.this.dialog.hide();
                }
                else if (InAppBrowser.this.getShowCLocationBar()) {
                    final RelativeLayout relativeLayout2 = new RelativeLayout((Context)InAppBrowser.this.cordova.getActivity());
                    relativeLayout2.setBackgroundColor(Color.rgb(32, 37, 44));
                    relativeLayout2.setLayoutParams((ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, this.dpToPixels(50)));
                    relativeLayout2.setHorizontalGravity(1);
                    relativeLayout2.setVerticalGravity(48);
                    final Button button2 = new Button((Context)InAppBrowser.this.cordova.getActivity());
                    button2.setLayoutParams((ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(this.dpToPixels(40), this.dpToPixels(40)));
                    button2.setContentDescription((CharSequence)"Back Button");
                    button2.setId(2);
                    final Resources resources2 = InAppBrowser.this.cordova.getActivity().getResources();
                    final Drawable drawable2 = resources2.getDrawable(resources2.getIdentifier("ic_action_previous_item", "drawable", InAppBrowser.this.cordova.getActivity().getPackageName()));
                    if (Build$VERSION.SDK_INT < 16) {
                        button2.setBackgroundDrawable(drawable2);
                    }
                    else {
                        button2.setBackground(drawable2);
                    }
                    button2.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
                        public void onClick(final View view) {
                            InAppBrowser.this.goBack();
                        }
                    });
                    final Button button3 = new Button((Context)InAppBrowser.this.cordova.getActivity());
                    final RelativeLayout$LayoutParams layoutParams2 = new RelativeLayout$LayoutParams(this.dpToPixels(40), this.dpToPixels(40));
                    layoutParams2.addRule(17, 2);
                    layoutParams2.setMargins(this.dpToPixels(10), 0, 0, 0);
                    button3.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
                    button3.setContentDescription((CharSequence)"Forward Button");
                    button3.setId(3);
                    final Drawable drawable3 = resources2.getDrawable(resources2.getIdentifier("ic_action_next_item", "drawable", InAppBrowser.this.cordova.getActivity().getPackageName()));
                    if (Build$VERSION.SDK_INT < 16) {
                        button3.setBackgroundDrawable(drawable3);
                    }
                    else {
                        button3.setBackground(drawable3);
                    }
                    button3.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
                        public void onClick(final View view) {
                            InAppBrowser.this.goForward();
                        }
                    });
                    final Button button4 = new Button((Context)InAppBrowser.this.cordova.getActivity());
                    final RelativeLayout$LayoutParams layoutParams3 = new RelativeLayout$LayoutParams(this.dpToPixels(40), this.dpToPixels(40));
                    layoutParams3.addRule(17, 3);
                    layoutParams3.setMargins(this.dpToPixels(10), 0, 0, 0);
                    button4.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
                    button4.setContentDescription((CharSequence)"Reload Button");
                    button4.setId(7);
                    final Drawable drawable4 = resources2.getDrawable(resources2.getIdentifier("ic_action_reload_item", "drawable", InAppBrowser.this.cordova.getActivity().getPackageName()));
                    if (Build$VERSION.SDK_INT < 16) {
                        button4.setBackgroundDrawable(drawable4);
                    }
                    else {
                        button4.setBackground(drawable4);
                    }
                    button4.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
                        public void onClick(final View view) {
                            InAppBrowser.this.goReload();
                        }
                    });
                    final Button button5 = new Button((Context)InAppBrowser.this.cordova.getActivity());
                    final RelativeLayout$LayoutParams layoutParams4 = new RelativeLayout$LayoutParams(this.dpToPixels(40), this.dpToPixels(40));
                    layoutParams4.addRule(1, 7);
                    layoutParams4.setMargins(this.dpToPixels(10), 0, 0, 0);
                    button5.setLayoutParams((ViewGroup$LayoutParams)layoutParams4);
                    button5.setContentDescription((CharSequence)"Blank Button");
                    button5.setId(8);
                    final Drawable drawable5 = resources2.getDrawable(resources2.getIdentifier("ic_action_blank_item", "drawable", InAppBrowser.this.cordova.getActivity().getPackageName()));
                    if (Build$VERSION.SDK_INT < 16) {
                        button5.setBackgroundDrawable(drawable5);
                    }
                    else {
                        button5.setBackground(drawable5);
                    }
                    button5.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
                        public void onClick(final View view) {
                            InAppBrowser.this.goBlank();
                        }
                    });
                    relativeLayout2.addView((View)button2);
                    relativeLayout2.addView((View)button3);
                    relativeLayout2.addView((View)button4);
                    relativeLayout2.addView((View)button5);
                    contentView.addView((View)relativeLayout2);
                    InAppBrowser.this.inAppWebView.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, InAppBrowser.this.cordova.getActivity().getWallpaperDesiredMinimumHeight() - this.dpToPixels(160)));
                }
            }
        });
        return "";
    }
    
    public class InAppBrowserClient extends WebViewClient
    {
        EditText edittext;
        CordovaWebView webView;
        
        public InAppBrowserClient(final CordovaWebView webView, final EditText edittext) {
            this.webView = webView;
            this.edittext = edittext;
        }
        
        public void onPageFinished(final WebView webView, final String s) {
            super.onPageFinished(webView, s);
            try {
                final JSONObject jsonObject = new JSONObject();
                jsonObject.put("type", (Object)"loadstop");
                jsonObject.put("url", (Object)s);
                InAppBrowser.this.sendUpdate(jsonObject, true);
            }
            catch (JSONException ex) {
                Log.d("InAppBrowser", "Should never happen");
            }
        }
        
        public void onPageStarted(final WebView webView, final String s, final Bitmap bitmap) {
            super.onPageStarted(webView, s, bitmap);
            String string = "";
            Label_0081: {
                if (!s.startsWith("http:") && !s.startsWith("https:") && !s.startsWith("file:")) {
                    break Label_0081;
                }
                string = s;
                try {
                    // iftrue(Label_0471:, !s.startsWith("sms:"))
                    // iftrue(Label_0170:, !s.startsWith("tel:"))
                    // iftrue(Label_0318:, query == null || !query.startsWith("body="))
                    // iftrue(Label_0197:, s.startsWith("geo:") || s.startsWith("mailto:"))
                    // iftrue(Label_0277:, !s.startsWith("market:"))
                    JSONObject jsonObject;
                    Intent intent;
                    int index;
                    String str;
                    String query;
                    Intent intent2;
                    Intent intent3;
                    Label_0318_Outer:Block_7_Outer:
                    while (true) {
                        jsonObject = new JSONObject();
                        jsonObject.put("type", (Object)"loadstart");
                        jsonObject.put("url", (Object)string);
                        InAppBrowser.this.sendUpdate(jsonObject, true);
                        return;
                        Block_4: {
                            while (true) {
                                while (true) {
                                    Label_0421: {
                                        try {
                                            intent = new Intent("android.intent.action.VIEW");
                                            index = s.indexOf(63);
                                            if (index != -1) {
                                                break Label_0421;
                                            }
                                            str = s.substring(4);
                                            intent.setData(Uri.parse("sms:" + str));
                                            intent.putExtra("address", str);
                                            intent.setType("vnd.android-dir/mms-sms");
                                            InAppBrowser.this.cordova.getActivity().startActivity(intent);
                                        }
                                        catch (ActivityNotFoundException ex) {
                                            LOG.e("InAppBrowser", "Error sending sms " + s + ":" + ex.toString());
                                        }
                                        continue Label_0318_Outer;
                                        break Block_4;
                                    }
                                    str = s.substring(4, index);
                                    query = Uri.parse(s).getQuery();
                                    Block_10: {
                                        break Block_10;
                                        Label_0471: {
                                            string = "http://" + s;
                                        }
                                        continue Label_0318_Outer;
                                        try {
                                            Label_0197:
                                            intent2 = new Intent("android.intent.action.VIEW");
                                            intent2.setData(Uri.parse(s));
                                            InAppBrowser.this.cordova.getActivity().startActivity(intent2);
                                        }
                                        catch (ActivityNotFoundException ex2) {
                                            LOG.e("InAppBrowser", "Error with " + s + ": " + ex2.toString());
                                        }
                                        continue Label_0318_Outer;
                                    }
                                    intent.putExtra("sms_body", query.substring(5));
                                    continue Block_7_Outer;
                                }
                                Label_0170: {
                                    continue;
                                }
                            }
                        }
                        try {
                            intent3 = new Intent("android.intent.action.DIAL");
                            intent3.setData(Uri.parse(s));
                            InAppBrowser.this.cordova.getActivity().startActivity(intent3);
                        }
                        catch (ActivityNotFoundException ex3) {
                            LOG.e("InAppBrowser", "Error dialing " + s + ": " + ex3.toString());
                        }
                        continue Label_0318_Outer;
                    }
                }
                catch (JSONException ex4) {
                    Log.d("InAppBrowser", "Should never happen");
                }
            }
        }
        
        public void onReceivedError(final WebView webView, final int n, final String s, final String s2) {
            super.onReceivedError(webView, n, s, s2);
            try {
                final JSONObject jsonObject = new JSONObject();
                jsonObject.put("type", (Object)"loaderror");
                jsonObject.put("url", (Object)s2);
                jsonObject.put("code", n);
                jsonObject.put("message", (Object)s);
                InAppBrowser.this.sendUpdate(jsonObject, true, PluginResult.Status.ERROR);
            }
            catch (JSONException ex) {
                Log.d("InAppBrowser", "Should never happen");
            }
        }
        
        public boolean shouldOverrideUrlLoading(final WebView webView, final String s) {
            if (s.contains("market://")) {
                InAppBrowser.this.closeDialog();
                InAppBrowser.this.openExternal(s);
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, s);
        }
    }
}
