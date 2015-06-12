// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.content.Intent;
import java.util.HashMap;
import java.util.Map;
import android.view.Display;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.os.Build$VERSION;
import android.content.Context;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebView;

public class ep extends WebView implements DownloadListener
{
    private final es a;
    private final eq b;
    private final Object c;
    private final kw d;
    private final dx e;
    private bs f;
    private ak g;
    private boolean h;
    private boolean i;
    private final WindowManager j;
    
    private ep(final eq b, final ak g, final boolean h, final boolean b2, final kw d, final dx e) {
        super((Context)b);
        this.c = new Object();
        this.b = b;
        this.g = g;
        this.h = h;
        this.d = d;
        this.e = e;
        this.j = (WindowManager)this.getContext().getSystemService("window");
        this.setBackgroundColor(0);
        final WebSettings settings = this.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        eg.a((Context)b, e.b, settings);
        if (Build$VERSION.SDK_INT >= 17) {
            ek.a(this.getContext(), settings);
        }
        else if (Build$VERSION.SDK_INT >= 11) {
            ej.a(this.getContext(), settings);
        }
        this.setDownloadListener((DownloadListener)this);
        if (Build$VERSION.SDK_INT >= 11) {
            this.a = new ev(this, b2);
        }
        else {
            this.a = new es(this, b2);
        }
        this.setWebViewClient((WebViewClient)this.a);
        if (Build$VERSION.SDK_INT >= 14) {
            this.setWebChromeClient((WebChromeClient)new ew(this));
        }
        else if (Build$VERSION.SDK_INT >= 11) {
            this.setWebChromeClient((WebChromeClient)new eu(this));
        }
        this.j();
    }
    
    public static ep a(final Context context, final ak ak, final boolean b, final boolean b2, final kw kw, final dx dx) {
        return new ep(new eq(context), ak, b, b2, kw, dx);
    }
    
    private void j() {
        while (true) {
            synchronized (this.c) {
                if (this.h || this.g.e) {
                    if (Build$VERSION.SDK_INT < 14) {
                        en.a("Disabling hardware acceleration on an overlay.");
                        this.k();
                    }
                    else {
                        en.a("Enabling hardware acceleration on an overlay.");
                        this.l();
                    }
                    return;
                }
            }
            if (Build$VERSION.SDK_INT < 18) {
                en.a("Disabling hardware acceleration on an AdView.");
                this.k();
                return;
            }
            en.a("Enabling hardware acceleration on an AdView.");
            this.l();
        }
    }
    
    private void k() {
        synchronized (this.c) {
            if (!this.i && Build$VERSION.SDK_INT >= 11) {
                ej.a((View)this);
            }
            this.i = true;
        }
    }
    
    private void l() {
        synchronized (this.c) {
            if (this.i && Build$VERSION.SDK_INT >= 11) {
                ej.b((View)this);
            }
            this.i = false;
        }
    }
    
    public void a() {
        if (!this.f().a()) {
            return;
        }
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        final Display defaultDisplay = this.j.getDefaultDisplay();
        defaultDisplay.getMetrics(displayMetrics);
        try {
            this.b("onScreenInfoChanged", new JSONObject().put("width", displayMetrics.widthPixels).put("height", displayMetrics.heightPixels).put("density", (double)displayMetrics.density).put("rotation", defaultDisplay.getRotation()));
        }
        catch (JSONException ex) {
            en.b("Error occured while obtaining screen information.", (Throwable)ex);
        }
    }
    
    public void a(final Context baseContext, final ak g) {
        synchronized (this.c) {
            this.b.setBaseContext(baseContext);
            this.f = null;
            this.g = g;
            this.h = false;
            eg.b(this);
            this.loadUrl("about:blank");
            this.a.b();
        }
    }
    
    public void a(final ak g) {
        synchronized (this.c) {
            this.g = g;
            this.requestLayout();
        }
    }
    
    public void a(final bs f) {
        synchronized (this.c) {
            this.f = f;
        }
    }
    
    public void a(final String s, final Map<String, ?> map) {
        try {
            this.b(s, eg.a(map));
        }
        catch (JSONException ex) {
            en.e("Could not convert parameters to JSON.");
        }
    }
    
    public void a(final String str, JSONObject jsonObject) {
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        final String string = jsonObject.toString();
        final StringBuilder sb = new StringBuilder();
        sb.append("javascript:" + str + "(");
        sb.append(string);
        sb.append(");");
        this.loadUrl(sb.toString());
    }
    
    public void a(final boolean h) {
        synchronized (this.c) {
            this.h = h;
            this.j();
        }
    }
    
    public void b() {
        final HashMap<String, String> hashMap = new HashMap<String, String>(1);
        hashMap.put("version", this.e.b);
        this.a("onhide", hashMap);
    }
    
    public void b(final String str, JSONObject jsonObject) {
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        final String string = jsonObject.toString();
        final StringBuilder obj = new StringBuilder();
        obj.append("javascript:AFMA_ReceiveMessage('");
        obj.append(str);
        obj.append("'");
        obj.append(",");
        obj.append(string);
        obj.append(");");
        en.d("Dispatching AFMA event: " + (Object)obj);
        this.loadUrl(obj.toString());
    }
    
    public void c() {
        final HashMap<String, String> hashMap = new HashMap<String, String>(1);
        hashMap.put("version", this.e.b);
        this.a("onshow", hashMap);
    }
    
    public bs d() {
        synchronized (this.c) {
            return this.f;
        }
    }
    
    public ak e() {
        synchronized (this.c) {
            return this.g;
        }
    }
    
    public es f() {
        return this.a;
    }
    
    public kw g() {
        return this.d;
    }
    
    public dx h() {
        return this.e;
    }
    
    public boolean i() {
        synchronized (this.c) {
            return this.h;
        }
    }
    
    public void onDownloadStart(final String str, final String s, final String s2, final String str2, final long n) {
        try {
            final Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str2);
            this.getContext().startActivity(intent);
        }
        catch (ActivityNotFoundException ex) {
            en.a("Couldn't find an Activity to view url/mimetype: " + str + " / " + str2);
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        while (true) {
            int n3 = Integer.MAX_VALUE;
            while (true) {
                final int mode2;
                final int size2;
                Label_0253: {
                    final int size;
                    Label_0249: {
                        Label_0243: {
                            synchronized (this.c) {
                                if (this.isInEditMode() || this.h) {
                                    super.onMeasure(n, n2);
                                    return;
                                }
                                final int mode = View$MeasureSpec.getMode(n);
                                size = View$MeasureSpec.getSize(n);
                                mode2 = View$MeasureSpec.getMode(n2);
                                size2 = View$MeasureSpec.getSize(n2);
                                if (mode != Integer.MIN_VALUE && mode != 1073741824) {
                                    break Label_0243;
                                }
                                break Label_0249;
                                // iftrue(Label_0208:, this.g.g <= n4 && this.g.d <= n3)
                                // iftrue(Label_0190:, this.getVisibility() == 8)
                            Label_0190:
                                while (true) {
                                    Label_0103: {
                                        break Label_0103;
                                        this.setVisibility(4);
                                        break Label_0190;
                                    }
                                    en.e("Not enough space to show ad. Needs " + this.g.g + "x" + this.g.d + " pixels, but only has " + size + "x" + size2 + " pixels.");
                                    continue;
                                }
                                this.setMeasuredDimension(0, 0);
                                return;
                            }
                            Label_0208: {
                                if (this.getVisibility() != 8) {
                                    this.setVisibility(0);
                                }
                            }
                            this.setMeasuredDimension(this.g.g, this.g.d);
                            return;
                        }
                        final int n4 = n3;
                        break Label_0253;
                    }
                    final int n4 = size;
                }
                if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                    n3 = size2;
                    continue;
                }
                continue;
            }
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (this.d != null) {
            this.d.a(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }
    
    public void setContext(final Context baseContext) {
        this.b.setBaseContext(baseContext);
    }
}
