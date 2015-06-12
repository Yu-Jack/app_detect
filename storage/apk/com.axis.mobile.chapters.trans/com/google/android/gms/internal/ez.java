// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.webkit.WebStorage$QuotaUpdater;
import android.webkit.WebViewClient;
import android.webkit.WebView$WebViewTransport;
import android.os.Message;
import android.webkit.ConsoleMessage;
import android.webkit.WebView;
import android.view.WindowManager$BadTokenException;
import android.webkit.WebChromeClient$CustomViewCallback;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.webkit.JsPromptResult;
import android.content.Context;
import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface$OnClickListener;
import android.webkit.JsResult;
import android.app.AlertDialog$Builder;
import android.webkit.WebChromeClient;

public class ez extends WebChromeClient
{
    private final ex lN;
    
    public ez(final ex ln) {
        this.lN = ln;
    }
    
    private static void a(final AlertDialog$Builder alertDialog$Builder, final String message, final JsResult jsResult) {
        alertDialog$Builder.setMessage((CharSequence)message).setPositiveButton(17039370, (DialogInterface$OnClickListener)new ez$3(jsResult)).setNegativeButton(17039360, (DialogInterface$OnClickListener)new ez$2(jsResult)).setOnCancelListener((DialogInterface$OnCancelListener)new ez$1(jsResult)).create().show();
    }
    
    private static void a(final Context context, final AlertDialog$Builder alertDialog$Builder, final String text, final String text2, final JsPromptResult jsPromptResult) {
        final LinearLayout view = new LinearLayout(context);
        view.setOrientation(1);
        final TextView textView = new TextView(context);
        textView.setText((CharSequence)text);
        final EditText editText = new EditText(context);
        editText.setText((CharSequence)text2);
        view.addView((View)textView);
        view.addView((View)editText);
        alertDialog$Builder.setView((View)view).setPositiveButton(17039370, (DialogInterface$OnClickListener)new ez$6(jsPromptResult, editText)).setNegativeButton(17039360, (DialogInterface$OnClickListener)new ez$5(jsPromptResult)).setOnCancelListener((DialogInterface$OnCancelListener)new ez$4(jsPromptResult)).create().show();
    }
    
    protected final void a(final View view, final int requestedOrientation, final WebChromeClient$CustomViewCallback webChromeClient$CustomViewCallback) {
        final cf ca = this.lN.ca();
        if (ca == null) {
            eu.D("Could not get ad overlay when showing custom view.");
            webChromeClient$CustomViewCallback.onCustomViewHidden();
            return;
        }
        ca.a(view, webChromeClient$CustomViewCallback);
        ca.setRequestedOrientation(requestedOrientation);
    }
    
    protected boolean a(final Context context, final String title, final String s, final String s2, final JsResult jsResult, final JsPromptResult jsPromptResult, final boolean b) {
        try {
            final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder(context);
            alertDialog$Builder.setTitle((CharSequence)title);
            if (b) {
                a(context, alertDialog$Builder, s, s2, jsPromptResult);
            }
            else {
                a(alertDialog$Builder, s, jsResult);
            }
        }
        catch (WindowManager$BadTokenException ex) {
            eu.c("Fail to display Dialog.", (Throwable)ex);
        }
        return true;
    }
    
    public final void onCloseWindow(final WebView webView) {
        if (!(webView instanceof ex)) {
            eu.D("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        final cf ca = ((ex)webView).ca();
        if (ca == null) {
            eu.D("Tried to close an AdWebView not associated with an overlay.");
            return;
        }
        ca.close();
    }
    
    public final boolean onConsoleMessage(final ConsoleMessage consoleMessage) {
        final String string = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        switch (ez$7.sS[consoleMessage.messageLevel().ordinal()]) {
            default: {
                eu.B(string);
                break;
            }
            case 1: {
                eu.A(string);
                break;
            }
            case 2: {
                eu.D(string);
                break;
            }
            case 3:
            case 4: {
                eu.B(string);
                break;
            }
            case 5: {
                eu.z(string);
                break;
            }
        }
        return super.onConsoleMessage(consoleMessage);
    }
    
    public final boolean onCreateWindow(final WebView webView, final boolean b, final boolean b2, final Message message) {
        final WebView$WebViewTransport webView$WebViewTransport = (WebView$WebViewTransport)message.obj;
        final WebView webView2 = new WebView(webView.getContext());
        webView2.setWebViewClient((WebViewClient)this.lN.cb());
        webView$WebViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }
    
    public final void onExceededDatabaseQuota(final String s, final String s2, long n, long min, final long n2, final WebStorage$QuotaUpdater webStorage$QuotaUpdater) {
        final long n3 = 5242880L - n2;
        if (n3 <= 0L) {
            webStorage$QuotaUpdater.updateQuota(n);
            return;
        }
        if (n == 0L) {
            if (min > n3 || min > 1048576L) {
                min = 0L;
            }
        }
        else if (min == 0L) {
            min = Math.min(n + Math.min(131072L, n3), 1048576L);
        }
        else {
            if (min <= Math.min(1048576L - n, n3)) {
                n += min;
            }
            min = n;
        }
        webStorage$QuotaUpdater.updateQuota(min);
    }
    
    public final void onHideCustomView() {
        final cf ca = this.lN.ca();
        if (ca == null) {
            eu.D("Could not get ad overlay when hiding custom view.");
            return;
        }
        ca.aR();
    }
    
    public final boolean onJsAlert(final WebView webView, final String s, final String s2, final JsResult jsResult) {
        if (webView instanceof ex && ((ex)webView).cf() != null) {
            return this.a(((ex)webView).cf(), s, s2, null, jsResult, null, false);
        }
        return this.a(webView.getContext(), s, s2, null, jsResult, null, false);
    }
    
    public final boolean onJsBeforeUnload(final WebView webView, final String s, final String s2, final JsResult jsResult) {
        return this.a(webView.getContext(), s, s2, null, jsResult, null, false);
    }
    
    public final boolean onJsConfirm(final WebView webView, final String s, final String s2, final JsResult jsResult) {
        return this.a(webView.getContext(), s, s2, null, jsResult, null, false);
    }
    
    public final boolean onJsPrompt(final WebView webView, final String s, final String s2, final String s3, final JsPromptResult jsPromptResult) {
        return this.a(webView.getContext(), s, s2, s3, null, jsPromptResult, true);
    }
    
    public final void onReachedMaxAppCacheSize(final long n, final long n2, final WebStorage$QuotaUpdater webStorage$QuotaUpdater) {
        final long n3 = 5242880L - n2;
        final long n4 = 131072L + n;
        if (n3 < n4) {
            webStorage$QuotaUpdater.updateQuota(0L);
            return;
        }
        webStorage$QuotaUpdater.updateQuota(n4);
    }
    
    public final void onShowCustomView(final View view, final WebChromeClient$CustomViewCallback webChromeClient$CustomViewCallback) {
        this.a(view, -1, webChromeClient$CustomViewCallback);
    }
}
