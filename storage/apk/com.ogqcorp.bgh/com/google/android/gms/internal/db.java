// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.webkit.WebView;
import android.text.TextUtils;
import android.webkit.WebViewClient;
import android.os.Looper;
import android.os.Handler;

public class db implements Runnable
{
    protected final ep a;
    protected boolean b;
    protected boolean c;
    private final Handler d;
    private final long e;
    private long f;
    private et g;
    private final int h;
    private final int i;
    
    public db(final et et, final ep ep, final int n, final int n2) {
        this(et, ep, n, n2, 200L, 50L);
    }
    
    public db(final et g, final ep a, final int i, final int h, final long e, final long f) {
        this.e = e;
        this.f = f;
        this.d = new Handler(Looper.getMainLooper());
        this.a = a;
        this.g = g;
        this.b = false;
        this.c = false;
        this.h = h;
        this.i = i;
    }
    
    public void a() {
        this.d.postDelayed((Runnable)this, this.e);
    }
    
    public void a(final cz cz) {
        this.a(cz, new ex(this, this.a, cz.q));
    }
    
    public void a(final cz cz, final ex webViewClient) {
        this.a.setWebViewClient((WebViewClient)webViewClient);
        final ep a = this.a;
        String a2;
        if (TextUtils.isEmpty((CharSequence)cz.b)) {
            a2 = null;
        }
        else {
            a2 = eg.a(cz.b);
        }
        a.loadDataWithBaseURL(a2, cz.c, "text/html", "UTF-8", (String)null);
    }
    
    public void b() {
        synchronized (this) {
            this.b = true;
        }
    }
    
    public boolean c() {
        synchronized (this) {
            return this.b;
        }
    }
    
    public boolean d() {
        return this.c;
    }
    
    @Override
    public void run() {
        if (this.a == null || this.c()) {
            this.g.a(this.a);
            return;
        }
        new dc(this, this.a).execute((Object[])new Void[0]);
    }
}
