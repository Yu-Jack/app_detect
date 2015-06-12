// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.webkit.WebView;
import android.os.Bundle;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.ViewGroup;
import android.view.View;
import android.os.Build$VERSION;
import android.widget.RelativeLayout$LayoutParams;
import android.content.Intent;
import android.content.Context;
import android.widget.RelativeLayout;
import android.webkit.WebChromeClient$CustomViewCallback;
import android.widget.FrameLayout;
import android.app.Activity;

public class bs extends ch
{
    private final Activity a;
    private ce b;
    private by c;
    private ep d;
    private bv e;
    private ca f;
    private boolean g;
    private FrameLayout h;
    private WebChromeClient$CustomViewCallback i;
    private boolean j;
    private boolean k;
    private RelativeLayout l;
    
    public bs(final Activity a) {
        this.j = false;
        this.k = false;
        this.a = a;
    }
    
    public static void a(final Context context, final ce ce) {
        final Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", ce.n.e);
        ce.a(intent, ce);
        intent.addFlags(524288);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }
    
    private static RelativeLayout$LayoutParams c(final int n, final int n2, final int n3, final int n4) {
        final RelativeLayout$LayoutParams relativeLayout$LayoutParams = new RelativeLayout$LayoutParams(n3, n4);
        relativeLayout$LayoutParams.setMargins(n, n2, 0, 0);
        relativeLayout$LayoutParams.addRule(10);
        relativeLayout$LayoutParams.addRule(9);
        return relativeLayout$LayoutParams;
    }
    
    private void c(final boolean b) {
        if (!this.g) {
            this.a.requestWindowFeature(1);
        }
        final Window window = this.a.getWindow();
        window.setFlags(1024, 1024);
        this.a(this.b.k);
        if (Build$VERSION.SDK_INT >= 11) {
            en.a("Enabling hardware acceleration on the AdActivity window.");
            ej.a(window);
        }
        (this.l = new bu((Context)this.a, this.b.p)).setBackgroundColor(-16777216);
        this.a.setContentView((View)this.l);
        this.j();
        final boolean a = this.b.e.f().a();
        if (b) {
            this.d = ep.a((Context)this.a, this.b.e.e(), true, a, null, this.b.n);
            this.d.f().a(null, null, this.b.f, this.b.j, true, this.b.o);
            this.d.f().a(new et() {
                @Override
                public void a(final ep ep) {
                    ep.c();
                }
            });
            if (this.b.m != null) {
                this.d.loadUrl(this.b.m);
            }
            else {
                if (this.b.i == null) {
                    throw new bt("No URL or HTML to display in ad overlay.");
                }
                this.d.loadDataWithBaseURL(this.b.g, this.b.i, "text/html", "UTF-8", (String)null);
            }
        }
        else {
            (this.d = this.b.e).setContext((Context)this.a);
        }
        this.d.a(this);
        final ViewParent parent = this.d.getParent();
        if (parent != null && parent instanceof ViewGroup) {
            ((ViewGroup)parent).removeView((View)this.d);
        }
        this.l.addView((View)this.d, -1, -1);
        if (!b) {
            this.d.c();
        }
        this.a(a);
    }
    
    private void l() {
        if (this.a.isFinishing() && !this.k) {
            this.k = true;
            if (this.a.isFinishing()) {
                if (this.d != null) {
                    this.d.b();
                    this.l.removeView((View)this.d);
                    if (this.e != null) {
                        this.d.a(false);
                        this.e.c.addView((View)this.d, this.e.a, this.e.b);
                    }
                }
                if (this.b != null && this.b.d != null) {
                    this.b.d.o();
                }
            }
        }
    }
    
    public void a() {
        this.a.finish();
    }
    
    public void a(final int requestedOrientation) {
        this.a.setRequestedOrientation(requestedOrientation);
    }
    
    public void a(final int n, final int n2, final int n3, final int n4) {
        if (this.c != null) {
            this.c.setLayoutParams((ViewGroup$LayoutParams)c(n, n2, n3, n4));
        }
    }
    
    public void a(final Bundle bundle) {
        boolean boolean1 = false;
        if (bundle != null) {
            boolean1 = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.j = boolean1;
        Label_0068: {
            try {
                this.b = ce.a(this.a.getIntent());
                if (this.b == null) {
                    throw new bt("Could not get info for ad overlay.");
                }
                break Label_0068;
            }
            catch (bt bt) {
                en.e(bt.getMessage());
                this.a.finish();
            }
            return;
        }
        if (bundle == null) {
            if (this.b.d != null) {
                this.b.d.p();
            }
            if (this.b.l != 1 && this.b.c != null) {
                this.b.c.r();
            }
        }
        switch (this.b.l) {
            default: {
                throw new bt("Could not determine ad overlay type.");
            }
            case 1: {
                this.c(false);
            }
            case 2: {
                this.e = new bv(this.b.e);
                this.c(false);
            }
            case 3: {
                this.c(true);
            }
            case 4: {
                if (this.j) {
                    this.a.finish();
                    return;
                }
                if (!bq.a((Context)this.a, this.b.b, this.b.j)) {
                    this.a.finish();
                }
            }
        }
    }
    
    public void a(final View view, final WebChromeClient$CustomViewCallback i) {
        (this.h = new FrameLayout((Context)this.a)).setBackgroundColor(-16777216);
        this.h.addView(view, -1, -1);
        this.a.setContentView((View)this.h);
        this.j();
        this.i = i;
    }
    
    public void a(final boolean b) {
        int n;
        if (b) {
            n = 50;
        }
        else {
            n = 32;
        }
        this.f = new ca(this.a, n);
        final RelativeLayout$LayoutParams relativeLayout$LayoutParams = new RelativeLayout$LayoutParams(-2, -2);
        relativeLayout$LayoutParams.addRule(10);
        int n2;
        if (b) {
            n2 = 11;
        }
        else {
            n2 = 9;
        }
        relativeLayout$LayoutParams.addRule(n2);
        this.f.a(this.b.h);
        this.l.addView((View)this.f, (ViewGroup$LayoutParams)relativeLayout$LayoutParams);
    }
    
    public by b() {
        return this.c;
    }
    
    public void b(final int n, final int n2, final int n3, final int n4) {
        if (this.c == null) {
            this.c = new by((Context)this.a, this.d);
            this.l.addView((View)this.c, 0, (ViewGroup$LayoutParams)c(n, n2, n3, n4));
            this.d.f().a(false);
        }
    }
    
    public void b(final Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.j);
    }
    
    public void b(final boolean b) {
        if (this.f != null) {
            this.f.a(b);
        }
    }
    
    public void c() {
        if (this.b != null) {
            this.a(this.b.k);
        }
        if (this.h != null) {
            this.a.setContentView((View)this.l);
            this.j();
            this.h.removeAllViews();
            this.h = null;
        }
        if (this.i != null) {
            this.i.onCustomViewHidden();
            this.i = null;
        }
    }
    
    public void d() {
    }
    
    public void e() {
    }
    
    public void f() {
        if (this.b != null && this.b.l == 4) {
            if (this.j) {
                this.a.finish();
            }
            else {
                this.j = true;
            }
        }
        if (this.d != null) {
            eg.b(this.d);
        }
    }
    
    public void g() {
        if (this.c != null) {
            this.c.c();
        }
        this.c();
        if (this.d != null && (!this.a.isFinishing() || this.e == null)) {
            eg.a(this.d);
        }
        this.l();
    }
    
    public void h() {
        this.l();
    }
    
    public void i() {
        if (this.c != null) {
            this.c.a();
        }
        if (this.d != null) {
            this.l.removeView((View)this.d);
        }
        this.l();
    }
    
    public void j() {
        this.g = true;
    }
    
    public void k() {
        this.l.removeView((View)this.f);
        this.a(true);
    }
}
