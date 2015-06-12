import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.webkit.WebViewClient;
import android.os.Bundle;
import android.view.Display;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.view.Window;
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

public final class ec extends Dialog
{
    private String a;
    private ea b;
    private ProgressDialog c;
    private WebView d;
    private LinearLayout e;
    private Activity f;
    private FrameLayout g;
    private int h;
    
    public ec(final Activity f, final String a, final ea b) {
        super((Context)f, 16973840);
        this.a = a;
        this.b = b;
        this.f = f;
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
    
    public static void a(final Context context, final Window window) {
        final Display defaultDisplay = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
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
        window.setLayout(Math.min(a(n, displayMetrics.density, 480, 800), displayMetrics.widthPixels), Math.min(a(n2, displayMetrics.density, 800, 1280), displayMetrics.heightPixels));
    }
    
    protected final void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        (this.c = new ProgressDialog(this.getContext())).requestWindowFeature(1);
        final int identifier = this.getContext().getResources().getIdentifier("loading", "string", this.getContext().getPackageName());
        if (identifier != 0) {
            this.c.setMessage(this.getContext().getText(identifier));
        }
        else {
            this.c.setMessage((CharSequence)"Loading...");
        }
        this.requestWindowFeature(1);
        this.g = new FrameLayout(this.getContext());
        this.getWindow().setGravity(17);
        a(this.getContext(), this.getWindow());
        this.h = (int)(16.0f * this.getContext().getResources().getDisplayMetrics().density);
        (this.e = new LinearLayout(this.getContext())).setOrientation(1);
        (this.d = new ed(this, this.getContext())).setVerticalScrollBarEnabled(false);
        this.d.setHorizontalScrollBarEnabled(false);
        this.d.setWebViewClient((WebViewClient)new ee(this, (byte)0));
        this.d.getSettings().setJavaScriptEnabled(true);
        this.d.loadUrl(this.a);
        this.d.getSettings().setSavePassword(false);
        this.d.getSettings().setSaveFormData(false);
        this.d.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -1));
        this.d.setVisibility(4);
        this.e.setPadding(this.h, this.h, this.h, this.h);
        this.e.addView((View)this.d);
        this.e.setBackgroundColor(-2013265920);
        this.g.addView((View)this.e);
        this.getWindow().setSoftInputMode(16);
        this.setContentView((View)this.g);
    }
}
