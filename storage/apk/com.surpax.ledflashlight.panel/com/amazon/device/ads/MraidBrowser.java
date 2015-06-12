// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.os.Build$VERSION;
import android.webkit.WebChromeClient;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.webkit.WebViewClient;
import android.annotation.SuppressLint;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.os.AsyncTask;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.view.WindowManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View$OnClickListener;
import android.webkit.CookieSyncManager;
import android.widget.ImageView$ScaleType;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.graphics.BitmapFactory;
import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.app.Activity;

class MraidBrowser implements IAdActivityAdapter
{
    private static final int BUTTON_SIZE_DP = 50;
    private static final int HORIZONTAL_RULE_SIZE_DP = 3;
    protected static final String LOG_TAG;
    protected static final String SHOW_OPEN_EXTERNAL_BROWSER_BTN = "extra_open_btn";
    protected static final String URL_EXTRA = "extra_url";
    private Activity activity;
    private ImageButton mBrowserBackButton;
    private ImageButton mBrowserForwardButton;
    private ImageButton mCloseButton;
    private ImageButton mOpenExternalBrowserButton;
    private ImageButton mRefreshButton;
    private WebView mWebView;
    private boolean showOpenExternalBrowserButton;
    
    static {
        LOG_TAG = MraidBrowser.class.getSimpleName();
    }
    
    private ImageButton createButton(final String s, final int n, final int n2, final int n3, final int n4) {
        final ImageButton imageButton = new ImageButton((Context)this.activity);
        imageButton.setImageBitmap(BitmapFactory.decodeFile(s));
        final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(n3, n4);
        layoutParams.addRule(n, n2);
        layoutParams.addRule(12);
        imageButton.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        imageButton.setBackgroundColor(0);
        imageButton.setScaleType(ImageView$ScaleType.FIT_CENTER);
        return imageButton;
    }
    
    private void enableCookies() {
        CookieSyncManager.createInstance((Context)this.activity);
        CookieSyncManager.getInstance().startSync();
    }
    
    private void initializeButtons(final Intent intent) {
        this.mBrowserBackButton.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                if (MraidBrowser.this.mWebView.canGoBack()) {
                    MraidBrowser.this.mWebView.goBack();
                }
            }
        });
        this.mBrowserForwardButton.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                if (MraidBrowser.this.mWebView.canGoForward()) {
                    MraidBrowser.this.mWebView.goForward();
                }
            }
        });
        this.mRefreshButton.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                MraidBrowser.this.mWebView.reload();
            }
        });
        this.mCloseButton.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                MraidBrowser.this.activity.finish();
            }
        });
        if (this.showOpenExternalBrowserButton) {
            this.mOpenExternalBrowserButton.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
                final String originalUrl = intent.getStringExtra("extra_url");
                
                public void onClick(final View view) {
                    String s = MraidBrowser.this.mWebView.getUrl();
                    if (s == null) {
                        Log.w(MraidBrowser.LOG_TAG, "The current URL is null. Reverting to the original URL for external browser.");
                        s = this.originalUrl;
                    }
                    AdUtils.launchActivityForIntentLink(s, MraidBrowser.this.mWebView.getContext());
                }
            });
        }
    }
    
    @SuppressLint({ "InlinedApi" })
    private void initializeEntireView(final Intent intent) {
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager)this.activity.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        final float density = displayMetrics.density;
        final int n = (int)(0.5f + 50.0f * density);
        final int n2 = (int)(0.5f + density * 3.0f);
        int n3;
        if (this.showOpenExternalBrowserButton) {
            n3 = 5;
        }
        else {
            n3 = 4;
        }
        int n4 = displayMetrics.widthPixels / n3;
        if (n4 > n * 2) {
            n4 = n * 2;
        }
        final RelativeLayout relativeLayout = new RelativeLayout((Context)this.activity);
        relativeLayout.setId(10280);
        final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(-1, n + n2);
        layoutParams.addRule(12);
        relativeLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        relativeLayout.setBackgroundColor(-986896);
        ThreadUtils.executeAsyncTask(new MraidBrowser$LoadButtonsTask(this, intent, (ViewGroup)relativeLayout, n4, n), (Object[])new Void[0]);
        final View view = new View((Context)this.activity);
        view.setBackgroundColor(-3355444);
        final RelativeLayout$LayoutParams layoutParams2 = new RelativeLayout$LayoutParams(-1, n2);
        layoutParams2.addRule(10);
        view.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        relativeLayout.addView(view);
        this.mWebView = WebViewFactory.getInstance().createWebView((Context)this.activity);
        final RelativeLayout$LayoutParams layoutParams3 = new RelativeLayout$LayoutParams(-1, -1);
        layoutParams3.addRule(2, relativeLayout.getId());
        this.mWebView.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
        final RelativeLayout relativeLayout2 = new RelativeLayout((Context)this.activity);
        relativeLayout2.setLayoutParams((ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, -2));
        relativeLayout2.addView((View)this.mWebView);
        relativeLayout2.addView((View)relativeLayout);
        final LinearLayout contentView = new LinearLayout((Context)this.activity);
        contentView.setOrientation(1);
        contentView.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -1));
        contentView.addView((View)relativeLayout2);
        this.activity.setContentView((View)contentView);
    }
    
    private void initializeWebView(final Intent intent) {
        WebViewFactory.setJavaScriptEnabledForWebView(true, this.mWebView, MraidBrowser.LOG_TAG);
        this.mWebView.loadUrl(intent.getStringExtra("extra_url"));
        this.mWebView.setWebViewClient((WebViewClient)new WebViewClient() {
            public void onReceivedError(final WebView webView, final int n, final String s, final String s2) {
                Log.w(MraidBrowser.LOG_TAG, "MRAID error: %s", s);
            }
            
            public boolean shouldOverrideUrlLoading(final WebView webView, final String s) {
                if (s != null) {
                    if (!s.startsWith("market:") && !s.startsWith("tel:") && !s.startsWith("voicemail:") && !s.startsWith("sms:") && !s.startsWith("mailto:") && !s.startsWith("geo:")) {
                        if (!s.startsWith("google.streetview:")) {
                            return false;
                        }
                    }
                    try {
                        MraidBrowser.this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
                        return true;
                    }
                    catch (ActivityNotFoundException ex) {
                        Log.w(MraidBrowser.LOG_TAG, "Could not handle intent with URI: %s", s);
                        return true;
                    }
                }
                return false;
            }
        });
        this.mWebView.setWebChromeClient((WebChromeClient)new WebChromeClient() {
            public void onProgressChanged(final WebView webView, final int n) {
                final Activity activity = (Activity)webView.getContext();
                activity.setTitle((CharSequence)"Loading...");
                activity.setProgress(n * 100);
                if (n == 100) {
                    activity.setTitle((CharSequence)webView.getUrl());
                }
                MraidBrowser.this.updateNavigationButtons(webView);
            }
        });
    }
    
    private void updateNavigationButtons(final WebView webView) {
        if (this.mBrowserBackButton != null && this.mBrowserForwardButton != null) {
            if (webView.canGoBack()) {
                AndroidTargetUtils.setImageButtonAlpha(this.mBrowserBackButton, 255);
            }
            else {
                AndroidTargetUtils.setImageButtonAlpha(this.mBrowserBackButton, 102);
            }
            if (!webView.canGoForward()) {
                AndroidTargetUtils.setImageButtonAlpha(this.mBrowserForwardButton, 102);
                return;
            }
            AndroidTargetUtils.setImageButtonAlpha(this.mBrowserForwardButton, 255);
        }
    }
    
    protected boolean canPauseWebViewTimers() {
        return this.getWebView() != null && this.getShouldPauseWebViewTimers();
    }
    
    protected boolean canResumeWebViewTimers() {
        return this.getWebView() != null && this.getShouldPauseWebViewTimers();
    }
    
    protected boolean getShouldPauseWebViewTimers() {
        return Settings.getInstance().getBoolean("shouldPauseWebViewTimersInWebViewRelatedActivities", false);
    }
    
    protected WebView getWebView() {
        return this.mWebView;
    }
    
    protected boolean isAtLeastAndroidAPI(final int n) {
        return Build$VERSION.SDK_INT >= n;
    }
    
    @Override
    public void onCreate() {
        this.activity.getWindow().requestFeature(2);
        this.activity.getWindow().setFeatureInt(2, -1);
        final Intent intent = this.activity.getIntent();
        this.showOpenExternalBrowserButton = intent.getBooleanExtra("extra_open_btn", false);
        this.initializeEntireView(intent);
        this.initializeWebView(intent);
        this.enableCookies();
    }
    
    @Override
    public void onPause() {
        Log.d(MraidBrowser.LOG_TAG, "onPause");
        final WebView webView = this.getWebView();
        if (this.isAtLeastAndroidAPI(11)) {
            this.webViewOnPause(webView);
        }
        else {
            Log.w(MraidBrowser.LOG_TAG, "Unable to call WebView.onPause");
        }
        if (this.canPauseWebViewTimers()) {
            webView.pauseTimers();
        }
        CookieSyncManager.getInstance().stopSync();
    }
    
    @Override
    public void onResume() {
        Log.d(MraidBrowser.LOG_TAG, "onResume");
        final WebView webView = this.getWebView();
        if (this.isAtLeastAndroidAPI(11)) {
            this.webViewOnResume(webView);
        }
        else {
            Log.w(MraidBrowser.LOG_TAG, "Unable to call WebView.onResume");
        }
        if (this.canResumeWebViewTimers()) {
            webView.resumeTimers();
        }
        CookieSyncManager.getInstance().startSync();
    }
    
    @Override
    public void onStop() {
    }
    
    @Override
    public void preOnCreate() {
    }
    
    @Override
    public void setActivity(final Activity activity) {
        this.activity = activity;
    }
    
    protected void webViewOnPause(final WebView webView) {
        AndroidTargetUtils.webViewOnPause(webView);
    }
    
    protected void webViewOnResume(final WebView webView) {
        AndroidTargetUtils.webViewOnResume(webView);
    }
}
