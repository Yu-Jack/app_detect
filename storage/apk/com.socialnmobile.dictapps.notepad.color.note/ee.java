import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.view.Display;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.view.Window;
import android.content.Context;
import android.widget.FrameLayout;
import android.app.Activity;
import android.widget.LinearLayout;
import android.app.ProgressDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.util.Log;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// 
// Decompiled by Procyon v0.5.29
// 

final class ee extends WebViewClient
{
    final /* synthetic */ ec a;
    
    private ee(final ec a) {
        this.a = a;
    }
    
    public final void onPageFinished(final WebView webView, final String s) {
        super.onPageFinished(webView, s);
        this.a.d.setVisibility(0);
        if (!this.a.f.isFinishing()) {
            this.a.c.dismiss();
        }
    }
    
    public final void onPageStarted(final WebView webView, final String str, final Bitmap bitmap) {
        Log.d("Facebook-WebView", "Webview loading URL: " + str);
        super.onPageStarted(webView, str, bitmap);
        if (!this.a.f.isFinishing()) {
            this.a.c.show();
        }
    }
    
    public final void onReceivedError(final WebView webView, final int n, final String s, final String s2) {
        super.onReceivedError(webView, n, s, s2);
        this.a.b.a(new dx(s, n, s2));
        this.a.dismiss();
    }
    
    public final void onReceivedSslError(final WebView webView, final SslErrorHandler sslErrorHandler, final SslError sslError) {
        sslErrorHandler.proceed();
    }
    
    public final boolean shouldOverrideUrlLoading(final WebView webView, final String str) {
        Log.d("Facebook-WebView", "Redirect URL: " + str);
        if (str.startsWith("fbconnect://success")) {
            final Bundle a = ef.a(str);
            String s = a.getString("error");
            if (s == null) {
                s = a.getString("error_type");
            }
            if (s == null) {
                this.a.b.a(a);
            }
            else if (s.equals("access_denied") || s.equals("OAuthAccessDeniedException")) {
                this.a.b.a();
            }
            else {
                this.a.b.a(new eb(s));
            }
            this.a.dismiss();
            return true;
        }
        if (str.startsWith("fbconnect://cancel")) {
            this.a.b.a();
            this.a.dismiss();
            return true;
        }
        if (str.contains("touch")) {
            return false;
        }
        this.a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        return true;
    }
}
