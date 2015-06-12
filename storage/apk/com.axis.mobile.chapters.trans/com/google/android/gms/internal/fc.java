// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.webkit.WebView;
import java.net.URISyntaxException;
import java.net.URI;
import android.text.TextUtils;
import android.webkit.WebViewClient;

public class fc extends WebViewClient
{
    private final ex lN;
    private final String sT;
    private boolean sU;
    private final do sV;
    
    public fc(final do sv, final ex ln, final String s) {
        this.sT = this.G(s);
        this.sU = false;
        this.lN = ln;
        this.sV = sv;
    }
    
    private String G(final String s) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            try {
                if (s.endsWith("/")) {
                    return s.substring(0, -1 + s.length());
                }
            }
            catch (IndexOutOfBoundsException ex) {
                eu.A(ex.getMessage());
                return s;
            }
        }
        return s;
    }
    
    protected boolean F(final String s) {
        final String g = this.G(s);
        if (!TextUtils.isEmpty((CharSequence)g)) {
            try {
                final URI uri = new URI(g);
                if ("passback".equals(uri.getScheme())) {
                    eu.z("Passback received");
                    this.sV.bp();
                    return true;
                }
                if (!TextUtils.isEmpty((CharSequence)this.sT)) {
                    final URI uri2 = new URI(this.sT);
                    final String host = uri2.getHost();
                    final String host2 = uri.getHost();
                    final String path = uri2.getPath();
                    final String path2 = uri.getPath();
                    if (hk.equal(host, host2) && hk.equal(path, path2)) {
                        eu.z("Passback received");
                        this.sV.bp();
                        return true;
                    }
                }
            }
            catch (URISyntaxException ex) {
                eu.A(ex.getMessage());
                return false;
            }
        }
        return false;
    }
    
    public void onLoadResource(final WebView webView, final String str) {
        eu.z("JavascriptAdWebViewClient::onLoadResource: " + str);
        if (!this.F(str)) {
            this.lN.cb().onLoadResource(this.lN, str);
        }
    }
    
    public void onPageFinished(final WebView webView, final String str) {
        eu.z("JavascriptAdWebViewClient::onPageFinished: " + str);
        if (!this.sU) {
            this.sV.bo();
            this.sU = true;
        }
    }
    
    public boolean shouldOverrideUrlLoading(final WebView webView, final String str) {
        eu.z("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + str);
        if (this.F(str)) {
            eu.z("shouldOverrideUrlLoading: received passback url");
            return true;
        }
        return this.lN.cb().shouldOverrideUrlLoading(this.lN, str);
    }
}
