// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.widget;

import android.view.Display;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.facebook.a.d;
import android.view.View;
import android.view.View$OnClickListener;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.a.g;
import android.content.DialogInterface;
import android.content.DialogInterface$OnCancelListener;
import com.facebook.ab;
import com.facebook.b.aj;
import com.facebook.b.ad;
import android.os.Bundle;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.app.ProgressDialog;
import android.webkit.WebView;
import android.app.Dialog;

public final class k extends Dialog
{
    private String a;
    private o b;
    private WebView c;
    private ProgressDialog d;
    private ImageView e;
    private FrameLayout f;
    private boolean g;
    private boolean h;
    
    public k(final Context context, final String str, Bundle bundle, final int n, final o b) {
        super(context, n);
        this.g = false;
        this.h = false;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("redirect_uri", "fbconnect://success");
        bundle.putString("display", "touch");
        this.a = aj.a(ad.a(), String.valueOf(ad.d()) + "/dialog/" + str, bundle).toString();
        this.b = b;
    }
    
    private static int a(final int n, final float n2, final int n3, final int n4) {
        double n5 = 0.5;
        final int n6 = (int)(n / n2);
        if (n6 <= n3) {
            n5 = 1.0;
        }
        else if (n6 < n4) {
            n5 += n5 * ((n4 - n6) / (n4 - n3));
        }
        return (int)(n5 * n);
    }
    
    static /* synthetic */ void a(final k k) {
        k.a(new com.facebook.ad());
    }
    
    private void a(final Throwable t) {
        if (this.b != null && !this.g) {
            this.g = true;
            ab ab;
            if (t instanceof ab) {
                ab = (ab)t;
            }
            else {
                ab = new ab(t);
            }
            this.b.a(null, ab);
        }
    }
    
    public final void dismiss() {
        if (this.c != null) {
            this.c.stopLoading();
        }
        if (!this.h) {
            if (this.d.isShowing()) {
                this.d.dismiss();
            }
            super.dismiss();
        }
    }
    
    public final void onAttachedToWindow() {
        this.h = false;
        super.onAttachedToWindow();
    }
    
    protected final void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setOnCancelListener((DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener() {
            public final void onCancel(final DialogInterface dialogInterface) {
                k.a(k.this);
            }
        });
        (this.d = new ProgressDialog(this.getContext())).requestWindowFeature(1);
        this.d.setMessage((CharSequence)this.getContext().getString(com.facebook.a.g.c));
        this.d.setOnCancelListener((DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener() {
            public final void onCancel(final DialogInterface dialogInterface) {
                k.a(k.this);
                k.this.dismiss();
            }
        });
        this.requestWindowFeature(1);
        this.f = new FrameLayout(this.getContext());
        final Display defaultDisplay = ((WindowManager)this.getContext().getSystemService("window")).getDefaultDisplay();
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int n;
        if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
            n = displayMetrics.widthPixels;
        }
        else {
            n = displayMetrics.heightPixels;
        }
        int n2;
        if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
            n2 = displayMetrics.heightPixels;
        }
        else {
            n2 = displayMetrics.widthPixels;
        }
        this.getWindow().setLayout(Math.min(a(n, displayMetrics.density, 480, 800), displayMetrics.widthPixels), Math.min(a(n2, displayMetrics.density, 800, 1280), displayMetrics.heightPixels));
        this.getWindow().setGravity(17);
        this.getWindow().setSoftInputMode(16);
        (this.e = new ImageView(this.getContext())).setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public final void onClick(final View view) {
                k.a(k.this);
                k.this.dismiss();
            }
        });
        this.e.setImageDrawable(this.getContext().getResources().getDrawable(com.facebook.a.d.b));
        this.e.setVisibility(4);
        final int n3 = 1 + this.e.getDrawable().getIntrinsicWidth() / 2;
        final LinearLayout linearLayout = new LinearLayout(this.getContext());
        (this.c = new WebView(this.getContext())).setVerticalScrollBarEnabled(false);
        this.c.setHorizontalScrollBarEnabled(false);
        this.c.setWebViewClient((WebViewClient)new n(this, (byte)0));
        this.c.getSettings().setJavaScriptEnabled(true);
        this.c.loadUrl(this.a);
        this.c.setLayoutParams((ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-1, -1));
        this.c.setVisibility(4);
        this.c.getSettings().setSavePassword(false);
        this.c.getSettings().setSaveFormData(false);
        linearLayout.setPadding(n3, n3, n3, n3);
        linearLayout.addView((View)this.c);
        linearLayout.setBackgroundColor(-872415232);
        this.f.addView((View)linearLayout);
        this.f.addView((View)this.e, new ViewGroup$LayoutParams(-2, -2));
        this.setContentView((View)this.f);
    }
    
    public final void onDetachedFromWindow() {
        this.h = true;
        super.onDetachedFromWindow();
    }
}
