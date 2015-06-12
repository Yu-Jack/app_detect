// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.webkit.WebView;
import java.util.Iterator;
import java.util.Map;
import android.net.Uri;
import java.util.HashMap;
import android.webkit.WebViewClient;

public class es extends WebViewClient
{
    protected final ep a;
    private final HashMap<String, aj> b;
    private final Object c;
    private lh d;
    private bx e;
    private et f;
    private ag g;
    private boolean h;
    private al i;
    private boolean j;
    private cc k;
    
    public es(final ep a, final boolean j) {
        this.b = new HashMap<String, aj>();
        this.c = new Object();
        this.h = false;
        this.a = a;
        this.j = j;
    }
    
    private static boolean a(final Uri uri) {
        final String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }
    
    private void b(final Uri obj) {
        final String path = obj.getPath();
        final aj aj = this.b.get(path);
        if (aj != null) {
            final Map<String, String> a = eg.a(obj);
            if (en.a(2)) {
                en.d("Received GMSG: " + path);
                for (final String str : a.keySet()) {
                    en.d("  " + str + ": " + a.get(str));
                }
            }
            aj.a(this.a, a);
            return;
        }
        en.d("No GMSG handler found for GMSG: " + obj);
    }
    
    public final void a(final cb cb) {
        final boolean i = this.a.i();
        lh d;
        if (i && !this.a.e().e) {
            d = null;
        }
        else {
            d = this.d;
        }
        bx e = null;
        if (!i) {
            e = this.e;
        }
        this.a(new ce(cb, d, e, this.k, this.a.h()));
    }
    
    protected void a(final ce ce) {
        bs.a(this.a.getContext(), ce);
    }
    
    public final void a(final et f) {
        this.f = f;
    }
    
    public void a(final lh d, final bx e, final ag g, final cc k, final boolean b, final al i) {
        this.a("/appEvent", new af(g));
        this.a("/canOpenURLs", ai.b);
        this.a("/click", ai.c);
        this.a("/close", ai.d);
        this.a("/customClose", ai.e);
        this.a("/httpTrack", ai.f);
        this.a("/log", ai.g);
        this.a("/open", new am(i));
        this.a("/touch", ai.h);
        this.a("/video", ai.i);
        this.d = d;
        this.e = e;
        this.g = g;
        this.i = i;
        this.k = k;
        this.a(b);
    }
    
    public final void a(final String key, final aj value) {
        this.b.put(key, value);
    }
    
    public final void a(final boolean h) {
        this.h = h;
    }
    
    public final void a(final boolean b, final int n) {
        lh d;
        if (this.a.i() && !this.a.e().e) {
            d = null;
        }
        else {
            d = this.d;
        }
        this.a(new ce(d, this.e, this.k, this.a, b, n, this.a.h()));
    }
    
    public final void a(final boolean b, final int n, final String s) {
        final boolean i = this.a.i();
        lh d;
        if (i && !this.a.e().e) {
            d = null;
        }
        else {
            d = this.d;
        }
        bx e = null;
        if (!i) {
            e = this.e;
        }
        this.a(new ce(d, e, this.g, this.k, this.a, b, n, s, this.a.h(), this.i));
    }
    
    public final void a(final boolean b, final int n, final String s, final String s2) {
        final boolean i = this.a.i();
        lh d;
        if (i && !this.a.e().e) {
            d = null;
        }
        else {
            d = this.d;
        }
        bx e;
        if (i) {
            e = null;
        }
        else {
            e = this.e;
        }
        this.a(new ce(d, e, this.g, this.k, this.a, b, n, s, s2, this.a.h(), this.i));
    }
    
    public boolean a() {
        synchronized (this.c) {
            return this.j;
        }
    }
    
    public final void b() {
        synchronized (this.c) {
            this.b.clear();
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = false;
            this.j = false;
            this.i = null;
            this.k = null;
        }
    }
    
    public final void c() {
        synchronized (this.c) {
            this.h = false;
            this.j = true;
            final bs d = this.a.d();
            if (d != null) {
                if (!em.b()) {
                    em.a.post((Runnable)new Runnable() {
                        @Override
                        public void run() {
                            d.k();
                        }
                    });
                }
                else {
                    d.k();
                }
            }
        }
    }
    
    public final void onLoadResource(final WebView webView, final String str) {
        en.d("Loading resource: " + str);
        final Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            this.b(parse);
        }
    }
    
    public final void onPageFinished(final WebView webView, final String s) {
        if (this.f != null) {
            this.f.a(this.a);
            this.f = null;
        }
    }
    
    public final boolean shouldOverrideUrlLoading(final WebView webView, final String str) {
        en.d("AdWebView shouldOverrideUrlLoading: " + str);
        Uri uri = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uri.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            this.b(uri);
        }
        else {
            if (this.h && webView == this.a && a(uri)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            if (!this.a.willNotDraw()) {
                while (true) {
                    try {
                        final kw g = this.a.g();
                        if (g != null && g.a(uri)) {
                            uri = g.a(uri, this.a.getContext());
                        }
                        final Uri uri2 = uri;
                        this.a(new cb("android.intent.action.VIEW", uri2.toString(), null, null, null, null, null));
                        return true;
                    }
                    catch (kx kx) {
                        en.e("Unable to append parameter to URL: " + str);
                        final Uri uri2 = uri;
                        continue;
                    }
                    break;
                }
            }
            en.e("AdWebView unable to handle URL: " + str);
        }
        return true;
    }
}
