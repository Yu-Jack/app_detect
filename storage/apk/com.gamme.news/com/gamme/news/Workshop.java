// 
// Decompiled by Procyon v0.5.29
// 

package com.gamme.news;

import org.apache.cordova.Config;
import android.view.KeyEvent;
import android.view.View$OnKeyListener;
import android.view.MotionEvent;
import android.view.View$OnTouchListener;
import android.webkit.WebViewClient;
import android.content.ClipData;
import android.text.ClipboardManager;
import android.os.Build$VERSION;
import android.webkit.WebResourceResponse;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import org.apache.cordova.CordovaWebViewClient;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient$CustomViewCallback;
import android.view.View;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaChromeClient;
import com.gamme.news.crash.CrashHandler;
import android.os.Bundle;
import android.annotation.SuppressLint;
import org.apache.cordova.CordovaActivity;

@SuppressLint({ "SetJavaScriptEnabled" })
public class Workshop<SslErrorHandler, SslError> extends CordovaActivity
{
    static final int MIN_DISTANCE = 300;
    private float downX;
    private float downY;
    private int fbcLoad;
    private int popupiframe;
    private float upX;
    private float upY;
    
    static /* synthetic */ void access$2(final Workshop workshop, final int fbcLoad) {
        workshop.fbcLoad = fbcLoad;
    }
    
    static /* synthetic */ void access$3(final Workshop workshop, final int popupiframe) {
        workshop.popupiframe = popupiframe;
    }
    
    static /* synthetic */ void access$4(final Workshop workshop, final float downX) {
        workshop.downX = downX;
    }
    
    static /* synthetic */ void access$5(final Workshop workshop, final float downY) {
        workshop.downY = downY;
    }
    
    static /* synthetic */ void access$6(final Workshop workshop, final float upX) {
        workshop.upX = upX;
    }
    
    static /* synthetic */ void access$7(final Workshop workshop, final float upY) {
        workshop.upY = upY;
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final CrashHandler instance = CrashHandler.getInstance();
        instance.init(this.getApplicationContext());
        Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)instance);
        super.init();
        this.appView.clearCache(true);
        this.appView.clearHistory();
        this.appView.getSettings().setJavaScriptEnabled(true);
        this.appView.getSettings().setAllowFileAccess(true);
        this.appView.setWebChromeClient(new CordovaChromeClient(this, this.appView) {
            @Override
            public void onHideCustomView() {
                Workshop.this.setRequestedOrientation(1);
                this.appView.hideCustomView();
            }
            
            @Override
            public void onShowCustomView(final View view, final WebChromeClient$CustomViewCallback webChromeClient$CustomViewCallback) {
                Workshop.this.setRequestedOrientation(-1);
                this.appView.showCustomView(view, webChromeClient$CustomViewCallback);
            }
        });
        this.appView.setWebViewClient(new CordovaWebViewClient(this, this.appView) {
            public void doUpdateVisitedHistory(final WebView webView, final String s, final boolean b) {
                super.doUpdateVisitedHistory(webView, s, b);
            }
            
            public void onLoadResource(final WebView webView, final String s) {
                if (s.contains("facebook.com") && !s.contains("/login.php") && !s.contains("/plugins/like/connect") && !s.contains("/plugins/like/disconnect") && !s.contains("graph.facebook.com") && !s.contains("/async/") && !s.contains("/ajax/") && !s.contains("/connect/xd_arbiter") && !s.contains("/plugins/login_success.php") && !s.contains("/plugins/comments.php") && !s.contains("/plugins/like.php") && !s.contains("/plugins/feedback.php") && !s.contains("/vote.php") && Workshop.this.fbcLoad == 1) {
                    Workshop.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
                }
                super.onLoadResource(webView, s);
            }
            
            @Override
            public void onPageFinished(final WebView webView, final String s) {
                super.onPageFinished(webView, s);
            }
            
            public WebResourceResponse shouldInterceptRequest(final WebView webView, final String s) {
                return super.shouldInterceptRequest(webView, s);
            }
            
            @Override
            public boolean shouldOverrideUrlLoading(final WebView webView, final String str) {
                webView.loadUrl("javascript:showlog('shouldOverrideUrlLoading:" + str + "')");
                if (str.contains("facebook.com")) {
                    if (str.contains("/login.php") || str.contains("/dialog/plugin.optin")) {
                        webView.loadUrl("javascript:facebookLogin('" + str + "')");
                    }
                    else {
                        if (!str.contains("graph.facebook.com") && !str.contains("/plugins/like/connect") && !str.contains("/plugins/like/disconnect") && !str.contains("/async/") && !str.contains("/ajax/") && !str.contains("/connect/xd_arbiter") && !str.contains("/plugins/login_success.php") && !str.contains("/plugins/comments.php") && !str.contains("/plugins/like.php") && !str.contains("/plugins/feedback.php") && !str.contains("/vote.php") && !str.contains("common/scribe_endpoint.php") && Workshop.this.fbcLoad == 1) {
                            Workshop.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            return true;
                        }
                        return super.shouldOverrideUrlLoading(webView, str);
                    }
                }
                else if (str.contains("clipboard/")) {
                    final String[] split = str.split("clipboard/");
                    if (split.length > 1) {
                        final String string = "http://m.gamme.com.tw/" + split[1];
                        if (Build$VERSION.SDK_INT < 11) {
                            ((ClipboardManager)Workshop.this.getSystemService("clipboard")).setText((CharSequence)string);
                            return true;
                        }
                        ((android.content.ClipboardManager)Workshop.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText((CharSequence)"Copied Text", (CharSequence)string));
                        return true;
                    }
                }
                else {
                    if (str.contains("market://")) {
                        if (Workshop.this.popupiframe > 0) {
                            webView.loadUrl("javascript:goBack('L');");
                        }
                        Workshop.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        return true;
                    }
                    if (str.contains("gamme.com.tw/tag/")) {
                        if (Workshop.this.popupiframe > 0) {
                            webView.loadUrl("javascript:goBack('L');");
                        }
                        webView.loadUrl("javascript:GetTagList('" + str.split("gamme.com.tw/tag/")[1] + "');");
                        return true;
                    }
                    if (str.contains("news.gamme.com.tw/")) {
                        final String[] split2 = str.split("news.gamme.com.tw/");
                        if (split2.length < 2) {
                            webView.loadUrl("javascript:goBack('L');");
                            return true;
                        }
                        String str2 = split2[1];
                        if (str2.contains("-")) {
                            str2 = str2.split("-")[0];
                        }
                        if (str2.matches("^[0-9]+$")) {
                            webView.loadUrl("javascript:showArticle('" + str2 + "',o);");
                            return true;
                        }
                        return super.shouldOverrideUrlLoading(webView, str);
                    }
                    else if (str.contains("m.gamme.com.tw/")) {
                        final String[] split3 = str.split("m.gamme.com.tw/");
                        if (split3.length < 2) {
                            webView.loadUrl("javascript:goBack('L');");
                            return true;
                        }
                        String str3 = split3[1];
                        if (str3.contains("-")) {
                            str3 = str3.split("-")[0];
                        }
                        if (str3.matches("^[0-9]+$")) {
                            webView.loadUrl("javascript:showArticle('" + str3 + "',o);");
                            return true;
                        }
                        return super.shouldOverrideUrlLoading(webView, str);
                    }
                    else {
                        if (str.contains("finish.close")) {
                            Workshop.this.finish();
                            return true;
                        }
                        if (str.contains("iRate")) {
                            final String string2 = "market://details?id=" + Workshop.this.getPackageName();
                            final Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse(string2));
                            Workshop.this.startActivity(intent);
                            return true;
                        }
                        if (str.contains("fbcLoad")) {
                            if (str.contains("fbcLoad/0")) {
                                Workshop.access$2(Workshop.this, 0);
                            }
                            if (str.contains("fbcLoad/1")) {
                                Workshop.access$2(Workshop.this, 1);
                                return true;
                            }
                        }
                        else if (str.contains("popupiframe")) {
                            if (str.contains("popupiframe/0") && Workshop.this.popupiframe > 0) {
                                final Workshop this$0 = Workshop.this;
                                Workshop.access$3(this$0, -1 + this$0.popupiframe);
                            }
                            if (str.contains("popupiframe/1")) {
                                final Workshop this$ = Workshop.this;
                                Workshop.access$3(this$, 1 + this$.popupiframe);
                                return true;
                            }
                        }
                        else {
                            if (Workshop.this.popupiframe > 0) {
                                webView.loadUrl("javascript:showPopupIframe('" + str + "');");
                                return true;
                            }
                            if (Workshop.this.fbcLoad == 1) {
                                Workshop.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                                return true;
                            }
                            return super.shouldOverrideUrlLoading(webView, str);
                        }
                    }
                }
                return true;
            }
        });
        this.appView.setOnTouchListener((View$OnTouchListener)new View$OnTouchListener() {
            public boolean onTouch(final View view, final MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0: {
                        Workshop.access$4(Workshop.this, motionEvent.getX());
                        Workshop.access$5(Workshop.this, motionEvent.getY());
                    }
                    case 1: {
                        Workshop.access$6(Workshop.this, motionEvent.getX());
                        Workshop.access$7(Workshop.this, motionEvent.getY());
                        final float n = Workshop.this.downX - Workshop.this.upX;
                        final float n2 = Workshop.this.downY - Workshop.this.upY;
                        final WebView webView = (WebView)view;
                        if (Math.abs(n) > Math.abs(n2)) {
                            if (Math.abs(n) <= 300.0f) {
                                break;
                            }
                            if (n < 0.0f && n2 < 100.0f && n2 > -100.0f) {
                                webView.loadUrl("javascript:showLP()");
                            }
                            if (n > 0.0f && n2 < 100.0f && n2 > -100.0f) {
                                webView.loadUrl("javascript:showRP()");
                                break;
                            }
                            break;
                        }
                        else {
                            if (Math.abs(n2) > 300.0f) {
                                break;
                            }
                            break;
                        }
                        break;
                    }
                }
                return false;
            }
        });
        this.appView.setOnKeyListener((View$OnKeyListener)new View$OnKeyListener() {
            public boolean onKey(final View view, final int n, final KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0 || n != 4) {
                    return Workshop.this.onKeyDown(n, keyEvent);
                }
                final WebView webView = (WebView)view;
                if (webView.canGoBack()) {
                    webView.goBack();
                    return true;
                }
                webView.loadUrl("javascript:goBack('L')");
                return false;
            }
        });
        this.appView.postMessage("splashscreen", "hide");
        this.setRequestedOrientation(1);
        super.loadUrl(Config.getStartUrl());
    }
}
