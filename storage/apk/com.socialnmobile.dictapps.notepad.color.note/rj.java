import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.os.Bundle;
import android.content.Context;
import android.widget.FrameLayout;
import android.app.Activity;
import android.widget.LinearLayout;
import android.webkit.WebView;
import android.app.ProgressDialog;
import android.app.Dialog;

// 
// Decompiled by Procyon v0.5.29
// 

public final class rj extends Dialog
{
    private String a;
    private ea b;
    private ProgressDialog c;
    private WebView d;
    private LinearLayout e;
    private boolean f;
    private Activity g;
    private FrameLayout h;
    private int i;
    private int j;
    
    public rj(final Activity g, final String a, final ea b) {
        super((Context)g, 16973840);
        this.a = a;
        this.b = b;
        this.f = false;
        this.g = g;
    }
    
    protected final void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        (this.c = new ProgressDialog(this.getContext())).requestWindowFeature(1);
        this.c.setMessage((CharSequence)this.getContext().getString(2131231006));
        this.requestWindowFeature(1);
        this.h = new FrameLayout(this.getContext());
        this.getWindow().setGravity(17);
        ec.a(this.getContext(), this.getWindow());
        final float density = this.getContext().getResources().getDisplayMetrics().density;
        this.i = (int)(16.0f * density);
        this.j = (int)(density * 8.0f);
        (this.e = new LinearLayout(this.getContext())).setOrientation(1);
        (this.d = new rk(this, this.getContext())).setVerticalScrollBarEnabled(false);
        this.d.setHorizontalScrollBarEnabled(false);
        this.d.setWebViewClient((WebViewClient)new rm(this, (byte)0));
        this.d.setWebChromeClient((WebChromeClient)new rl(this, (byte)0));
        this.d.getSettings().setJavaScriptEnabled(true);
        while (true) {
            try {
                this.d.loadUrl(this.a);
                this.d.getSettings().setSavePassword(false);
                this.d.getSettings().setSaveFormData(false);
                this.d.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -1));
                this.d.setVisibility(4);
                this.e.setPadding(this.j, this.i, this.j, this.i);
                this.e.addView((View)this.d);
                this.e.setBackgroundColor(-2013265920);
                this.h.addView((View)this.e);
                this.getWindow().setSoftInputMode(16);
                this.setContentView((View)this.h);
            }
            catch (SecurityException ex) {
                continue;
            }
            break;
        }
    }
}
