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

public class ey extends WebViewClient
{
    protected final ex lN;
    private final Object ls;
    private ba mS;
    private bf nc;
    private bd nd;
    private ey$a pN;
    private final HashMap sH;
    private t sI;
    private ci sJ;
    private boolean sK;
    private boolean sL;
    private cl sM;
    
    public ey(final ex ln, final boolean sl) {
        this.sH = new HashMap();
        this.ls = new Object();
        this.sK = false;
        this.lN = ln;
        this.sL = sl;
    }
    
    private static boolean d(final Uri uri) {
        final String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }
    
    private void e(final Uri obj) {
        final String path = obj.getPath();
        final bc bc = this.sH.get(path);
        if (bc != null) {
            final Map c = eo.c(obj);
            if (eu.p(2)) {
                eu.C("Received GMSG: " + path);
                for (final String str : c.keySet()) {
                    eu.C("  " + str + ": " + (String)c.get(str));
                }
            }
            bc.b(this.lN, c);
            return;
        }
        eu.C("No GMSG handler found for GMSG: " + obj);
    }
    
    public final void a(final ce ce) {
        final boolean ce2 = this.lN.ce();
        t si;
        if (ce2 && !this.lN.V().mf) {
            si = null;
        }
        else {
            si = this.sI;
        }
        ci sj = null;
        if (!ce2) {
            sj = this.sJ;
        }
        this.a(new ch(ce, si, sj, this.sM, this.lN.cd()));
    }
    
    protected void a(final ch ch) {
        cf.a(this.lN.getContext(), ch);
    }
    
    public final void a(final ey$a pn) {
        this.pN = pn;
    }
    
    public void a(final t si, final ci sj, final ba ms, final cl sm, final boolean b, final bd nd) {
        this.a("/appEvent", new az(ms));
        this.a("/canOpenURLs", bb.mU);
        this.a("/click", bb.mV);
        this.a("/close", bb.mW);
        this.a("/customClose", bb.mX);
        this.a("/httpTrack", bb.mY);
        this.a("/log", bb.mZ);
        this.a("/open", new bg(nd));
        this.a("/touch", bb.na);
        this.a("/video", bb.nb);
        this.sI = si;
        this.sJ = sj;
        this.mS = ms;
        this.nd = nd;
        this.sM = sm;
        this.r(b);
    }
    
    public void a(final t t, final ci ci, final ba ba, final cl cl, final boolean b, final bd bd, final bf nc) {
        this.a(t, ci, ba, cl, b, bd);
        this.a("/setInterstitialProperties", new be(nc));
        this.nc = nc;
    }
    
    public final void a(final String key, final bc value) {
        this.sH.put(key, value);
    }
    
    public final void a(final boolean b, final int n) {
        t si;
        if (this.lN.ce() && !this.lN.V().mf) {
            si = null;
        }
        else {
            si = this.sI;
        }
        this.a(new ch(si, this.sJ, this.sM, this.lN, b, n, this.lN.cd()));
    }
    
    public final void a(final boolean b, final int n, final String s) {
        final boolean ce = this.lN.ce();
        t si;
        if (ce && !this.lN.V().mf) {
            si = null;
        }
        else {
            si = this.sI;
        }
        ci sj = null;
        if (!ce) {
            sj = this.sJ;
        }
        this.a(new ch(si, sj, this.mS, this.sM, this.lN, b, n, s, this.lN.cd(), this.nd));
    }
    
    public final void a(final boolean b, final int n, final String s, final String s2) {
        final boolean ce = this.lN.ce();
        t si;
        if (ce && !this.lN.V().mf) {
            si = null;
        }
        else {
            si = this.sI;
        }
        ci sj;
        if (ce) {
            sj = null;
        }
        else {
            sj = this.sJ;
        }
        this.a(new ch(si, sj, this.mS, this.sM, this.lN, b, n, s, s2, this.lN.cd(), this.nd));
    }
    
    public final void aS() {
        synchronized (this.ls) {
            this.sK = false;
            this.sL = true;
            final cf ca = this.lN.ca();
            if (ca != null) {
                if (!et.bW()) {
                    et.sv.post((Runnable)new ey$1(this, ca));
                }
                else {
                    ca.aS();
                }
            }
        }
    }
    
    public boolean cj() {
        synchronized (this.ls) {
            return this.sL;
        }
    }
    
    public final void onLoadResource(final WebView webView, final String str) {
        eu.C("Loading resource: " + str);
        final Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            this.e(parse);
        }
    }
    
    public final void onPageFinished(final WebView webView, final String s) {
        if (this.pN != null) {
            this.pN.a(this.lN);
            this.pN = null;
        }
    }
    
    public final void r(final boolean sk) {
        this.sK = sk;
    }
    
    public final void reset() {
        synchronized (this.ls) {
            this.sH.clear();
            this.sI = null;
            this.sJ = null;
            this.pN = null;
            this.mS = null;
            this.sK = false;
            this.sL = false;
            this.nd = null;
            this.sM = null;
        }
    }
    
    public final boolean shouldOverrideUrlLoading(final WebView webView, final String str) {
        eu.C("AdWebView shouldOverrideUrlLoading: " + str);
        Uri uri = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uri.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            this.e(uri);
        }
        else {
            if (this.sK && webView == this.lN && d(uri)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            if (!this.lN.willNotDraw()) {
                while (true) {
                    try {
                        final k cc = this.lN.cc();
                        if (cc != null && cc.b(uri)) {
                            uri = cc.a(uri, this.lN.getContext());
                        }
                        final Uri uri2 = uri;
                        this.a(new ce("android.intent.action.VIEW", uri2.toString(), null, null, null, null, null));
                        return true;
                    }
                    catch (l l) {
                        eu.D("Unable to append parameter to URL: " + str);
                        final Uri uri2 = uri;
                        continue;
                    }
                    break;
                }
            }
            eu.D("AdWebView unable to handle URL: " + str);
        }
        return true;
    }
}
