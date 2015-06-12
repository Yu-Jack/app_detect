import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.webkit.WebChromeClient;
import android.os.Bundle;
import android.content.Context;
import android.widget.FrameLayout;
import android.app.Activity;
import android.widget.LinearLayout;
import android.app.ProgressDialog;
import android.app.Dialog;
import com.socialnmobile.colornote.ColorNote;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// 
// Decompiled by Procyon v0.5.29
// 

final class rm extends WebViewClient
{
    final /* synthetic */ rj a;
    
    private rm(final rj a) {
        this.a = a;
    }
    
    public final void onPageFinished(final WebView webView, final String s) {
        super.onPageFinished(webView, s);
        this.a.d.setVisibility(0);
        if (!this.a.g.isFinishing() && !this.a.f && this.a.c.isShowing()) {
            this.a.c.dismiss();
        }
    }
    
    public final void onPageStarted(final WebView webView, final String s, final Bitmap bitmap) {
        super.onPageStarted(webView, s, bitmap);
        if (!this.a.g.isFinishing()) {
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
        new StringBuilder("Redirect URL: ").append(str).toString();
        ColorNote.a();
        this.a.d.loadUrl(str);
        return true;
    }
}
