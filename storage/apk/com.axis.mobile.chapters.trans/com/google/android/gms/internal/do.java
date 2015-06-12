// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.webkit.WebView;
import android.text.TextUtils;
import android.webkit.WebViewClient;
import android.os.Looper;
import android.os.Handler;

public class do implements Runnable
{
    private final int ku;
    private final int kv;
    protected final ex lN;
    private final Handler pK;
    private final long pL;
    private long pM;
    private ey$a pN;
    protected boolean pO;
    protected boolean pP;
    
    public do(final ey$a ey$a, final ex ex, final int n, final int n2) {
        this(ey$a, ex, n, n2, 200L, 50L);
    }
    
    public do(final ey$a pn, final ex ln, final int ku, final int kv, final long pl, final long pm) {
        this.pL = pl;
        this.pM = pm;
        this.pK = new Handler(Looper.getMainLooper());
        this.lN = ln;
        this.pN = pn;
        this.pO = false;
        this.pP = false;
        this.kv = kv;
        this.ku = ku;
    }
    
    public void a(final du du, final fc webViewClient) {
        this.lN.setWebViewClient((WebViewClient)webViewClient);
        final ex ln = this.lN;
        String v;
        if (TextUtils.isEmpty((CharSequence)du.oA)) {
            v = null;
        }
        else {
            v = eo.v(du.oA);
        }
        ln.loadDataWithBaseURL(v, du.qe, "text/html", "UTF-8", (String)null);
    }
    
    public void b(final du du) {
        this.a(du, new fc(this, this.lN, du.qn));
    }
    
    public void bo() {
        this.pK.postDelayed((Runnable)this, this.pL);
    }
    
    public void bp() {
        synchronized (this) {
            this.pO = true;
        }
    }
    
    public boolean bq() {
        synchronized (this) {
            return this.pO;
        }
    }
    
    public boolean br() {
        return this.pP;
    }
    
    @Override
    public void run() {
        if (this.lN == null || this.bq()) {
            this.pN.a(this.lN);
            return;
        }
        new do$a(this, this.lN).execute((Object[])new Void[0]);
    }
}
