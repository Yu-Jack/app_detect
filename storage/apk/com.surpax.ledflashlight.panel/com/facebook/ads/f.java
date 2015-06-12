// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads;

import android.content.res.Configuration;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.facebook.ads.a.x;
import com.facebook.ads.a.o;
import com.facebook.ads.a.l;
import com.facebook.ads.a.q;
import android.view.View;
import android.webkit.WebViewClient;
import com.facebook.ads.a.u;
import com.facebook.ads.a.t;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.content.Context;
import android.util.DisplayMetrics;
import com.facebook.ads.a.y;
import com.facebook.ads.a.m;
import android.webkit.WebView;
import android.widget.RelativeLayout;

public class f extends RelativeLayout implements a
{
    private static final String a;
    private int b;
    private final String c;
    private final e d;
    private c e;
    private WebView f;
    private m g;
    private y h;
    private final DisplayMetrics i;
    private final h j;
    private int k;
    
    static {
        a = f.class.getSimpleName();
    }
    
    public f(final Context context, final String c, final e d) {
        super(context);
        this.b = 255;
        this.e = null;
        if (d == null || d == com.facebook.ads.e.b) {
            throw new IllegalArgumentException("adSize");
        }
        this.c = c;
        this.d = d;
        this.i = context.getResources().getDisplayMetrics();
        this.j = new h(this, (byte)0);
        this.d();
        (this.f = new WebView(context)).setLayoutParams((ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, -1));
        this.f.setVisibility(8);
        u.a(this.f, new g(this, (byte)0), new t());
        this.addView((View)this.f);
        this.g = new m(this.getContext(), this.c, this.d, true, q.a, new l() {
            @Override
            public final void a(final o o) {
                com.facebook.ads.f.this.h.c();
                final com.facebook.ads.a.e d = o.d();
                if (d != null && d instanceof x) {
                    com.facebook.ads.f.this.h.a((x)d);
                    com.facebook.ads.f.a(com.facebook.ads.f.this, (x)d);
                    if (com.facebook.ads.f.this.e != null) {
                        com.facebook.ads.f.this.e.onAdLoaded(com.facebook.ads.f.this);
                    }
                    com.facebook.ads.f.this.k = o.c();
                }
                else if (d == null) {
                    if (com.facebook.ads.f.this.e != null) {
                        final c d2 = com.facebook.ads.f.this.e;
                        final f a = com.facebook.ads.f.this;
                        b b;
                        if (o.e() != null) {
                            b = o.e();
                        }
                        else {
                            b = com.facebook.ads.b.c;
                        }
                        d2.onError(a, b);
                    }
                    if (com.facebook.ads.f.this.g != null) {
                        com.facebook.ads.f.this.g.a();
                    }
                }
                else {
                    if (com.facebook.ads.f.this.e != null) {
                        com.facebook.ads.f.this.e.onError(com.facebook.ads.f.this, com.facebook.ads.b.c);
                    }
                    if (com.facebook.ads.f.this.g != null) {
                        com.facebook.ads.f.this.g.a();
                    }
                }
            }
            
            @Override
            public final void a(final b b) {
                com.facebook.ads.f.this.h.c();
                if (com.facebook.ads.f.this.e != null) {
                    com.facebook.ads.f.this.e.onError(com.facebook.ads.f.this, b);
                }
            }
        });
        this.h = new y(this.f, new com.facebook.ads.a.g() {
            @Override
            public final boolean a() {
                return com.facebook.ads.f.a(com.facebook.ads.f.this);
            }
            
            @Override
            public final void b() {
                if (com.facebook.ads.f.this.g != null) {
                    com.facebook.ads.f.this.g.a();
                }
            }
        }, context);
        final IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.getContext().registerReceiver((BroadcastReceiver)this.j, intentFilter);
    }
    
    static /* synthetic */ void a(final f f, final x x) {
        f.f.loadUrl("about:blank");
        f.f.clearCache(true);
        f.f.setVisibility(8);
        f.f.loadDataWithBaseURL("https://www.facebook.com/", x.c(), "text/html", "utf-8", (String)null);
        f.f.setVisibility(0);
    }
    
    static /* synthetic */ boolean a(final f f) {
        if (f.getVisibility() == 0 && f.getParent() != null && f.b >= 229) {
            final int[] array = new int[2];
            f.getLocationOnScreen(array);
            if (array[0] >= 0 && f.i.widthPixels - array[0] >= (int)Math.ceil(f.d.a() * f.i.density)) {
                final int n = (int)Math.ceil(f.d.b() * f.i.density);
                final int n2 = (int)(n * (100.0 - f.k) / 100.0);
                if ((array[1] >= 0 || Math.abs(array[1]) <= n2) && n + array[1] - f.i.heightPixels <= n2) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private void d() {
        int widthPixels;
        if ((int)(this.i.widthPixels / this.i.density) >= this.d.a()) {
            widthPixels = this.i.widthPixels;
        }
        else {
            widthPixels = (int)Math.ceil(this.d.a() * this.i.density);
        }
        final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(widthPixels, (int)Math.ceil(this.d.b() * this.i.density));
        layoutParams.addRule(14);
        this.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
    }
    
    public final void a() {
        if (this.g == null) {
            throw new RuntimeException("No request controller available, has the AdView been destroyed?");
        }
        this.g.b();
    }
    
    public final void a(final c e) {
        this.e = e;
    }
    
    public final void b() {
        if (this.g != null) {
            this.g.c();
            this.g = null;
        }
        this.h.c();
        this.getContext().unregisterReceiver((BroadcastReceiver)this.j);
    }
    
    protected void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.d();
    }
    
    protected boolean onSetAlpha(final int b) {
        this.b = b;
        return super.onSetAlpha(b);
    }
    
    protected void onWindowVisibilityChanged(final int n) {
        super.onWindowVisibilityChanged(n);
        if (this.g != null) {
            this.g.a(n);
        }
        if (n == 0) {
            this.h.b();
            return;
        }
        this.h.c();
    }
}
