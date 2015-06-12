// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads;

import android.view.WindowManager;
import com.facebook.ads.a.g;
import android.view.View;
import android.webkit.WebViewClient;
import com.facebook.ads.a.u;
import com.facebook.ads.a.t;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.widget.RelativeLayout;
import android.os.Bundle;
import android.content.Context;
import android.support.v4.content.e;
import android.content.Intent;
import com.facebook.ads.a.y;
import com.facebook.ads.a.x;
import android.webkit.WebView;
import android.app.Activity;

public class InterstitialAdActivity extends Activity
{
    private static final String a;
    private WebView b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private x g;
    private y h;
    private String i;
    
    static {
        a = InterstitialAdActivity.class.getSimpleName();
    }
    
    public InterstitialAdActivity() {
        this.f = false;
    }
    
    private void a(final String s) {
        final Intent intent = new Intent(s);
        intent.putExtra("adInterstitialUniqueId", this.i);
        android.support.v4.content.e.a((Context)this).a(intent);
    }
    
    public void finish() {
        this.h.c();
        this.b.loadUrl("about:blank");
        this.b.clearCache(true);
        this.a("com.facebook.ads.interstitial.dismissed");
        super.finish();
    }
    
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.requestWindowFeature(1);
        this.getWindow().setFlags(1024, 1024);
        final RelativeLayout relativeLayout = new RelativeLayout((Context)this);
        (this.b = new WebView((Context)this)).setId(100001);
        this.b.setLayoutParams((ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, -1));
        u.a(this.b, new k(this, (byte)0), new t());
        relativeLayout.addView((View)this.b);
        this.h = new y(this.b, null, (Context)this);
        this.setContentView((View)relativeLayout, (ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, -1));
        final Intent intent = this.getIntent();
        if (bundle != null && bundle.containsKey("dataModel")) {
            this.g = x.a(bundle.getBundle("dataModel"));
            if (this.g != null) {
                this.b.loadDataWithBaseURL("https://www.facebook.com/", this.g.c(), "text/html", "utf-8", (String)null);
            }
            this.c = bundle.getInt("lastRequestedOrientation", -1);
            this.i = bundle.getString("adInterstitialUniqueId");
            this.f = true;
        }
        else {
            this.d = intent.getIntExtra("displayWidth", 0);
            this.e = intent.getIntExtra("displayHeight", 0);
            this.i = intent.getStringExtra("adInterstitialUniqueId");
            this.g = x.b(intent);
            if (this.g != null) {
                this.h.a(this.g);
                this.b.loadDataWithBaseURL("https://www.facebook.com/", this.g.c(), "text/html", "utf-8", (String)null);
            }
        }
        this.a("com.facebook.ads.interstitial.displayed");
    }
    
    public void onRestart() {
        super.onRestart();
        this.f = true;
    }
    
    public void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.g != null) {
            bundle.putBundle("dataModel", this.g.e());
        }
        bundle.putInt("lastRequestedOrientation", this.c);
        bundle.putString("adInterstitialUniqueId", this.i);
    }
    
    public void onStart() {
        super.onStart();
        if (!this.f) {
            int n;
            if (this.e >= this.d) {
                n = 1;
            }
            else {
                n = 0;
            }
            final int rotation = ((WindowManager)this.getSystemService("window")).getDefaultDisplay().getRotation();
            if (n != 0) {
                switch (rotation) {
                    default: {
                        this.setRequestedOrientation(1);
                        break;
                    }
                    case 1:
                    case 2: {
                        this.setRequestedOrientation(9);
                        break;
                    }
                }
            }
            else {
                switch (rotation) {
                    default: {
                        this.setRequestedOrientation(0);
                        break;
                    }
                    case 2:
                    case 3: {
                        this.setRequestedOrientation(8);
                        break;
                    }
                }
            }
        }
        else if (this.c >= 0) {
            this.setRequestedOrientation(this.c);
            this.c = -1;
        }
        this.f = false;
    }
    
    public void setRequestedOrientation(final int c) {
        super.setRequestedOrientation(this.c = c);
    }
}
