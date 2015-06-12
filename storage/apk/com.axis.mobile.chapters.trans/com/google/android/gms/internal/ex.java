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
import android.view.Display;
import android.util.DisplayMetrics;
import org.json.JSONObject;
import org.json.JSONException;
import java.util.Map;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.os.Build$VERSION;
import android.content.Context;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebView;

public class ex extends WebView implements DownloadListener
{
    private final WindowManager lC;
    private final Object ls;
    private al nF;
    private final ev nG;
    private final k pA;
    private final ey sA;
    private final ex$a sB;
    private cf sC;
    private boolean sD;
    private boolean sE;
    private boolean sF;
    
    private ex(final ex$a sb, final al nf, final boolean sd, final boolean b, final k pa, final ev ng) {
        super((Context)sb);
        this.ls = new Object();
        this.sB = sb;
        this.nF = nf;
        this.sD = sd;
        this.pA = pa;
        this.nG = ng;
        this.lC = (WindowManager)this.getContext().getSystemService("window");
        this.setBackgroundColor(0);
        final WebSettings settings = this.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        eo.a((Context)sb, ng.sw, settings);
        if (Build$VERSION.SDK_INT >= 17) {
            er.a(this.getContext(), settings);
        }
        else if (Build$VERSION.SDK_INT >= 11) {
            eq.a(this.getContext(), settings);
        }
        this.setDownloadListener((DownloadListener)this);
        if (Build$VERSION.SDK_INT >= 11) {
            this.sA = new fa(this, b);
        }
        else {
            this.sA = new ey(this, b);
        }
        this.setWebViewClient((WebViewClient)this.sA);
        if (Build$VERSION.SDK_INT >= 14) {
            this.setWebChromeClient((WebChromeClient)new fb(this));
        }
        else if (Build$VERSION.SDK_INT >= 11) {
            this.setWebChromeClient((WebChromeClient)new ez(this));
        }
        this.cg();
    }
    
    public static ex a(final Context context, final al al, final boolean b, final boolean b2, final k k, final ev ev) {
        return new ex(new ex$a(context), al, b, b2, k, ev);
    }
    
    private void cg() {
        while (true) {
            synchronized (this.ls) {
                if (this.sD || this.nF.mf) {
                    if (Build$VERSION.SDK_INT < 14) {
                        eu.z("Disabling hardware acceleration on an overlay.");
                        this.ch();
                    }
                    else {
                        eu.z("Enabling hardware acceleration on an overlay.");
                        this.ci();
                    }
                    return;
                }
            }
            if (Build$VERSION.SDK_INT < 18) {
                eu.z("Disabling hardware acceleration on an AdView.");
                this.ch();
                return;
            }
            eu.z("Enabling hardware acceleration on an AdView.");
            this.ci();
        }
    }
    
    private void ch() {
        synchronized (this.ls) {
            if (!this.sE && Build$VERSION.SDK_INT >= 11) {
                eq.d((View)this);
            }
            this.sE = true;
        }
    }
    
    private void ci() {
        synchronized (this.ls) {
            if (this.sE && Build$VERSION.SDK_INT >= 11) {
                eq.e((View)this);
            }
            this.sE = false;
        }
    }
    
    protected void E(final String s) {
        synchronized (this.ls) {
            if (!this.isDestroyed()) {
                this.loadUrl(s);
            }
            else {
                eu.D("The webview is destroyed. Ignoring action.");
            }
        }
    }
    
    public al V() {
        synchronized (this.ls) {
            return this.nF;
        }
    }
    
    public void a(final Context baseContext, final al nf) {
        synchronized (this.ls) {
            this.sB.setBaseContext(baseContext);
            this.sC = null;
            this.nF = nf;
            this.sD = false;
            eo.b(this);
            this.loadUrl("about:blank");
            this.sA.reset();
        }
    }
    
    public void a(final al nf) {
        synchronized (this.ls) {
            this.nF = nf;
            this.requestLayout();
        }
    }
    
    public void a(final cf sc) {
        synchronized (this.ls) {
            this.sC = sc;
        }
    }
    
    public void a(final String s, final Map map) {
        try {
            this.b(s, eo.o(map));
        }
        catch (JSONException ex) {
            eu.D("Could not convert parameters to JSON.");
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
        this.E(sb.toString());
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
        eu.C("Dispatching AFMA event: " + (Object)obj);
        this.E(obj.toString());
    }
    
    public void bX() {
        if (!this.cb().cj()) {
            return;
        }
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        final Display defaultDisplay = this.lC.getDefaultDisplay();
        defaultDisplay.getMetrics(displayMetrics);
        final int p = eo.p(this.getContext());
        final float n = 160.0f / displayMetrics.densityDpi;
        final int n2 = (int)(n * displayMetrics.widthPixels);
        final int n3 = (int)(n * (displayMetrics.heightPixels - p));
        try {
            this.b("onScreenInfoChanged", new JSONObject().put("width", n2).put("height", n3).put("density", (double)displayMetrics.density).put("rotation", defaultDisplay.getRotation()));
        }
        catch (JSONException ex) {
            eu.b("Error occured while obtaining screen information.", (Throwable)ex);
        }
    }
    
    public void bY() {
        final HashMap<String, String> hashMap = new HashMap<String, String>(1);
        hashMap.put("version", this.nG.sw);
        this.a("onhide", hashMap);
    }
    
    public void bZ() {
        final HashMap<String, String> hashMap = new HashMap<String, String>(1);
        hashMap.put("version", this.nG.sw);
        this.a("onshow", hashMap);
    }
    
    public cf ca() {
        synchronized (this.ls) {
            return this.sC;
        }
    }
    
    public ey cb() {
        return this.sA;
    }
    
    public k cc() {
        return this.pA;
    }
    
    public ev cd() {
        return this.nG;
    }
    
    public boolean ce() {
        synchronized (this.ls) {
            return this.sD;
        }
    }
    
    public Context cf() {
        return this.sB.cf();
    }
    
    public void destroy() {
        synchronized (this.ls) {
            super.destroy();
            this.sF = true;
        }
    }
    
    public boolean isDestroyed() {
        synchronized (this.ls) {
            return this.sF;
        }
    }
    
    public void onDownloadStart(final String str, final String s, final String s2, final String str2, final long n) {
        try {
            final Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str2);
            this.getContext().startActivity(intent);
        }
        catch (ActivityNotFoundException ex) {
            eu.z("Couldn't find an Activity to view url/mimetype: " + str + " / " + str2);
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        int n3;
        int mode;
        int size = 0;
        int mode2 = 0;
        int size2 = 0;
        int n4;
        float density;
        Block_9_Outer:Label_0080_Outer:
        while (true) {
            n3 = Integer.MAX_VALUE;
            while (true) {
                Label_0288: {
                    Label_0284: {
                        Label_0278: {
                            synchronized (this.ls) {
                                if (this.isInEditMode() || this.sD) {
                                    super.onMeasure(n, n2);
                                    return;
                                }
                                mode = View$MeasureSpec.getMode(n);
                                size = View$MeasureSpec.getSize(n);
                                mode2 = View$MeasureSpec.getMode(n2);
                                size2 = View$MeasureSpec.getSize(n2);
                                if (mode != Integer.MIN_VALUE && mode != 1073741824) {
                                    break Label_0278;
                                }
                                break Label_0284;
                                while (true) {
                                    while (true) {
                                        this.setMeasuredDimension(0, 0);
                                        return;
                                        this.setVisibility(4);
                                        continue Block_9_Outer;
                                    }
                                    density = this.sB.getResources().getDisplayMetrics().density;
                                    eu.D("Not enough space to show ad. Needs " + (int)(this.nF.widthPixels / density) + "x" + (int)(this.nF.heightPixels / density) + " dp, but only has " + (int)(size / density) + "x" + (int)(size2 / density) + " dp.");
                                    continue Label_0080_Outer;
                                }
                            }
                            // iftrue(Label_0243:, this.nF.widthPixels <= n4 && this.nF.heightPixels <= n3)
                            // iftrue(Label_0225:, this.getVisibility() == 8)
                            Label_0243: {
                                if (this.getVisibility() != 8) {
                                    this.setVisibility(0);
                                }
                            }
                            this.setMeasuredDimension(this.nF.widthPixels, this.nF.heightPixels);
                            return;
                        }
                        n4 = n3;
                        break Label_0288;
                    }
                    n4 = size;
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
        if (this.pA != null) {
            this.pA.a(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }
    
    public void q(final boolean sd) {
        synchronized (this.ls) {
            this.sD = sd;
            this.cg();
        }
    }
    
    public void setContext(final Context baseContext) {
        this.sB.setBaseContext(baseContext);
    }
}
