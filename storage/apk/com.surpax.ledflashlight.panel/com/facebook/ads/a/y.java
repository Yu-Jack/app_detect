// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a;

import android.content.Context;
import android.webkit.WebView;

public final class y extends f
{
    private final WebView c;
    private volatile boolean d;
    
    public y(final WebView c, final g g, final Context context) {
        super(g, context);
        this.c = c;
    }
    
    public final void a(final x x) {
        super.a(x);
        this.d = false;
    }
    
    @Override
    protected final void e() {
        synchronized (this) {
            final e b = this.b;
            if (!ab.a("facebookAd.sendImpression();")) {
                this.c.loadUrl("javascript:facebookAd.sendImpression();");
            }
            if (this.a != null) {
                this.a.b();
            }
        }
    }
    
    public final void f() {
        synchronized (this) {
            if (this.d && this.b != null) {
                final x x = (x)this.b;
                if (!ab.a(x.d())) {
                    this.c.loadUrl("javascript:" + x.d());
                }
                this.b();
                this.d = true;
            }
        }
    }
}
