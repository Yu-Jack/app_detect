// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.widget;

import android.view.Display;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.widget.LinearLayout;
import com.facebook.a.d;
import android.view.View;
import android.view.View$OnClickListener;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.a.g;
import android.content.DialogInterface;
import android.content.DialogInterface$OnCancelListener;
import com.facebook.ab;
import com.facebook.b.ad;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.app.ProgressDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import com.facebook.ah;
import com.facebook.ae;
import com.facebook.a.i;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import com.facebook.aa;
import com.facebook.b.aj;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class n extends WebViewClient
{
    final /* synthetic */ k a;
    
    private n(final k a) {
        this.a = a;
    }
    
    public final void onPageFinished(final WebView webView, final String s) {
        super.onPageFinished(webView, s);
        if (!this.a.h) {
            this.a.d.dismiss();
        }
        this.a.f.setBackgroundColor(0);
        this.a.c.setVisibility(0);
        this.a.e.setVisibility(0);
    }
    
    public final void onPageStarted(final WebView webView, final String str, final Bitmap bitmap) {
        aj.a("FacebookSDK.WebDialog", "Webview loading URL: " + str);
        super.onPageStarted(webView, str, bitmap);
        if (!this.a.h) {
            this.a.d.show();
        }
    }
    
    public final void onReceivedError(final WebView webView, final int n, final String s, final String s2) {
        super.onReceivedError(webView, n, s, s2);
        this.a.a(new aa(s, n, s2));
        this.a.dismiss();
    }
    
    public final void onReceivedSslError(final WebView webView, final SslErrorHandler sslErrorHandler, final SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        this.a.a(new aa(null, -11, null));
        sslErrorHandler.cancel();
        this.a.dismiss();
    }
    
    public final boolean shouldOverrideUrlLoading(final WebView webView, final String str) {
        aj.a("FacebookSDK.WebDialog", "Redirect URL: " + str);
        if (str.startsWith("fbconnect://success")) {
            final Bundle a = i.a(str);
            String s = a.getString("error");
            if (s == null) {
                s = a.getString("error_type");
            }
            String s2 = a.getString("error_msg");
            if (s2 == null) {
                s2 = a.getString("error_description");
            }
            final String string = a.getString("error_code");
        Label_0104:
            while (true) {
                if (aj.a(string)) {
                    final int int1 = -1;
                    break Label_0104;
                }
                while (true) {
                    while (true) {
                        int int1;
                        try {
                            int1 = Integer.parseInt(string);
                            if (aj.a(s) && aj.a(s2) && int1 == -1) {
                                k.a(this.a, a);
                                this.a.dismiss();
                                return true;
                            }
                        }
                        catch (NumberFormatException ex) {
                            int1 = -1;
                            continue Label_0104;
                        }
                        if (s != null && (s.equals("access_denied") || s.equals("OAuthAccessDeniedException"))) {
                            k.a(this.a);
                            continue;
                        }
                        this.a.a(new ah(new ae(int1, s, s2), s2));
                        continue;
                    }
                }
                break;
            }
        }
        else {
            if (str.startsWith("fbconnect://cancel")) {
                k.a(this.a);
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
}
