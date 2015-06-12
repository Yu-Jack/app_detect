// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.webkit.WebView;
import java.net.URISyntaxException;
import java.net.URI;
import android.text.TextUtils;
import android.webkit.WebViewClient;

public class ex extends WebViewClient
{
    private final String a;
    private boolean b;
    private final ep c;
    private final db d;
    
    public ex(final db d, final ep c, final String s) {
        this.a = this.b(s);
        this.b = false;
        this.c = c;
        this.d = d;
    }
    
    private String b(final String s) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            try {
                if (s.endsWith("/")) {
                    return s.substring(0, -1 + s.length());
                }
            }
            catch (IndexOutOfBoundsException ex) {
                en.b(ex.getMessage());
                return s;
            }
        }
        return s;
    }
    
    protected boolean a(final String s) {
        final String b = this.b(s);
        if (!TextUtils.isEmpty((CharSequence)b)) {
            try {
                final URI uri = new URI(b);
                if ("passback".equals(uri.getScheme())) {
                    en.a("Passback received");
                    this.d.b();
                    return true;
                }
                if (!TextUtils.isEmpty((CharSequence)this.a)) {
                    final URI uri2 = new URI(this.a);
                    final String host = uri2.getHost();
                    final String host2 = uri.getHost();
                    final String path = uri2.getPath();
                    final String path2 = uri.getPath();
                    if (gw.a(host, host2) && gw.a(path, path2)) {
                        en.a("Passback received");
                        this.d.b();
                        return true;
                    }
                }
            }
            catch (URISyntaxException ex) {
                en.b(ex.getMessage());
                return false;
            }
        }
        return false;
    }
    
    public void onLoadResource(final WebView webView, final String str) {
        en.a("JavascriptAdWebViewClient::onLoadResource: " + str);
        if (!this.a(str)) {
            this.c.f().onLoadResource(this.c, str);
        }
    }
    
    public void onPageFinished(final WebView webView, final String str) {
        en.a("JavascriptAdWebViewClient::onPageFinished: " + str);
        if (!this.b) {
            this.d.a();
            this.b = true;
        }
    }
    
    public boolean shouldOverrideUrlLoading(final WebView webView, final String str) {
        en.a("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + str);
        if (this.a(str)) {
            en.a("shouldOverrideUrlLoading: received passback url");
            return true;
        }
        return this.c.f().shouldOverrideUrlLoading(this.c, str);
    }
}
