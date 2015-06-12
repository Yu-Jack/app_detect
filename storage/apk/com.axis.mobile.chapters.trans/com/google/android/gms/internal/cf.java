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
import android.os.Build$VERSION;
import android.view.View;
import android.content.Intent;
import android.content.Context;
import android.widget.RelativeLayout$LayoutParams;
import android.graphics.Color;
import android.widget.RelativeLayout;
import android.webkit.WebChromeClient$CustomViewCallback;
import android.widget.FrameLayout;
import android.app.Activity;

public class cf extends cn$a
{
    private static final int of;
    private ex lN;
    private final Activity og;
    private ch oh;
    private cj oi;
    private cf$c oj;
    private ck ok;
    private boolean ol;
    private FrameLayout om;
    private WebChromeClient$CustomViewCallback on;
    private boolean oo;
    private boolean op;
    private boolean oq;
    private RelativeLayout or;
    
    static {
        of = Color.argb(0, 0, 0, 0);
    }
    
    public cf(final Activity og) {
        this.oo = false;
        this.op = false;
        this.oq = false;
        this.og = og;
    }
    
    private static RelativeLayout$LayoutParams a(final int n, final int n2, final int n3, final int n4) {
        final RelativeLayout$LayoutParams relativeLayout$LayoutParams = new RelativeLayout$LayoutParams(n3, n4);
        relativeLayout$LayoutParams.setMargins(n, n2, 0, 0);
        relativeLayout$LayoutParams.addRule(10);
        relativeLayout$LayoutParams.addRule(9);
        return relativeLayout$LayoutParams;
    }
    
    public static void a(final Context context, final ch ch) {
        final Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", ch.kQ.sz);
        ch.a(intent, ch);
        intent.addFlags(524288);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }
    
    private void aT() {
        if (this.og.isFinishing() && !this.op) {
            this.op = true;
            if (this.og.isFinishing()) {
                if (this.lN != null) {
                    this.lN.bY();
                    this.or.removeView((View)this.lN);
                    if (this.oj != null) {
                        this.lN.q(false);
                        this.oj.ou.addView((View)this.lN, this.oj.index, this.oj.ot);
                    }
                }
                if (this.oh != null && this.oh.ox != null) {
                    this.oh.ox.Z();
                }
            }
        }
    }
    
    private void k(final boolean b) {
        if (!this.ol) {
            this.og.requestWindowFeature(1);
        }
        final Window window = this.og.getWindow();
        if (!this.oq || this.oh.oH.ld) {
            window.setFlags(1024, 1024);
        }
        this.setRequestedOrientation(this.oh.orientation);
        if (Build$VERSION.SDK_INT >= 11) {
            eu.z("Enabling hardware acceleration on the AdActivity window.");
            eq.a(window);
        }
        this.or = new cf$b((Context)this.og, this.oh.oG);
        if (!this.oq) {
            this.or.setBackgroundColor(-16777216);
        }
        else {
            this.or.setBackgroundColor(cf.of);
        }
        this.og.setContentView((View)this.or);
        this.S();
        final boolean cj = this.oh.oy.cb().cj();
        if (b) {
            this.lN = ex.a((Context)this.og, this.oh.oy.V(), true, cj, null, this.oh.kQ);
            this.lN.cb().a(null, null, this.oh.oz, this.oh.oD, true, this.oh.oF);
            this.lN.cb().a(new cf$1(this));
            if (this.oh.ob != null) {
                this.lN.loadUrl(this.oh.ob);
            }
            else {
                if (this.oh.oC == null) {
                    throw new cf$a("No URL or HTML to display in ad overlay.");
                }
                this.lN.loadDataWithBaseURL(this.oh.oA, this.oh.oC, "text/html", "UTF-8", (String)null);
            }
        }
        else {
            (this.lN = this.oh.oy).setContext((Context)this.og);
        }
        this.lN.a(this);
        final ViewParent parent = this.lN.getParent();
        if (parent != null && parent instanceof ViewGroup) {
            ((ViewGroup)parent).removeView((View)this.lN);
        }
        if (this.oq) {
            this.lN.setBackgroundColor(cf.of);
        }
        this.or.addView((View)this.lN, -1, -1);
        if (!b) {
            this.lN.bZ();
        }
        this.i(cj);
    }
    
    public void S() {
        this.ol = true;
    }
    
    public void a(final View view, final WebChromeClient$CustomViewCallback on) {
        (this.om = new FrameLayout((Context)this.og)).setBackgroundColor(-16777216);
        this.om.addView(view, -1, -1);
        this.og.setContentView((View)this.om);
        this.S();
        this.on = on;
    }
    
    public cj aQ() {
        return this.oi;
    }
    
    public void aR() {
        if (this.oh != null) {
            this.setRequestedOrientation(this.oh.orientation);
        }
        if (this.om != null) {
            this.og.setContentView((View)this.or);
            this.S();
            this.om.removeAllViews();
            this.om = null;
        }
        if (this.on != null) {
            this.on.onCustomViewHidden();
            this.on = null;
        }
    }
    
    public void aS() {
        this.or.removeView((View)this.ok);
        this.i(true);
    }
    
    public void b(final int n, final int n2, final int n3, final int n4) {
        if (this.oi != null) {
            this.oi.setLayoutParams((ViewGroup$LayoutParams)a(n, n2, n3, n4));
        }
    }
    
    public void c(final int n, final int n2, final int n3, final int n4) {
        if (this.oi == null) {
            this.oi = new cj((Context)this.og, this.lN);
            this.or.addView((View)this.oi, 0, (ViewGroup$LayoutParams)a(n, n2, n3, n4));
            this.lN.cb().r(false);
        }
    }
    
    public void close() {
        this.og.finish();
    }
    
    public void i(final boolean b) {
        int n;
        if (b) {
            n = 50;
        }
        else {
            n = 32;
        }
        this.ok = new ck(this.og, n);
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
        this.ok.j(this.oh.oB);
        this.or.addView((View)this.ok, (ViewGroup$LayoutParams)relativeLayout$LayoutParams);
    }
    
    public void j(final boolean b) {
        if (this.ok != null) {
            this.ok.j(b);
        }
    }
    
    public void onCreate(final Bundle bundle) {
        boolean boolean1 = false;
        if (bundle != null) {
            boolean1 = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.oo = boolean1;
        Label_0068: {
            try {
                this.oh = ch.a(this.og.getIntent());
                if (this.oh == null) {
                    throw new cf$a("Could not get info for ad overlay.");
                }
                break Label_0068;
            }
            catch (cf$a cf$a) {
                eu.D(cf$a.getMessage());
                this.og.finish();
            }
            return;
        }
        if (this.oh.oH != null) {
            this.oq = this.oh.oH.lb;
        }
        else {
            this.oq = false;
        }
        if (bundle == null) {
            if (this.oh.ox != null) {
                this.oh.ox.aa();
            }
            if (this.oh.oE != 1 && this.oh.ow != null) {
                this.oh.ow.onAdClicked();
            }
        }
        switch (this.oh.oE) {
            default: {
                throw new cf$a("Could not determine ad overlay type.");
            }
            case 1: {
                this.k(false);
            }
            case 2: {
                this.oj = new cf$c(this.oh.oy);
                this.k(false);
            }
            case 3: {
                this.k(true);
            }
            case 4: {
                if (this.oo) {
                    this.og.finish();
                    return;
                }
                if (!cc.a((Context)this.og, this.oh.ov, this.oh.oD)) {
                    this.og.finish();
                }
            }
        }
    }
    
    public void onDestroy() {
        if (this.oi != null) {
            this.oi.destroy();
        }
        if (this.lN != null) {
            this.or.removeView((View)this.lN);
        }
        this.aT();
    }
    
    public void onPause() {
        if (this.oi != null) {
            this.oi.pause();
        }
        this.aR();
        if (this.lN != null && (!this.og.isFinishing() || this.oj == null)) {
            eo.a(this.lN);
        }
        this.aT();
    }
    
    public void onRestart() {
    }
    
    public void onResume() {
        if (this.oh != null && this.oh.oE == 4) {
            if (this.oo) {
                this.og.finish();
            }
            else {
                this.oo = true;
            }
        }
        if (this.lN != null) {
            eo.b(this.lN);
        }
    }
    
    public void onSaveInstanceState(final Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.oo);
    }
    
    public void onStart() {
    }
    
    public void onStop() {
        this.aT();
    }
    
    public void setRequestedOrientation(final int requestedOrientation) {
        this.og.setRequestedOrientation(requestedOrientation);
    }
}
