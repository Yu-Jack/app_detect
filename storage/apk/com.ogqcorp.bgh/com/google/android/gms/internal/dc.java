// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebViewClient;
import android.os.Looper;
import android.os.Handler;
import android.graphics.Canvas;
import android.view.View$MeasureSpec;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.os.AsyncTask;

public final class dc extends AsyncTask<Void, Void, Boolean>
{
    final /* synthetic */ db a;
    private final WebView b;
    private Bitmap c;
    
    public dc(final db a, final WebView b) {
        this.a = a;
        this.b = b;
    }
    
    protected Boolean a(final Void... array) {
        while (true) {
        Label_0058_Outer:
            while (true) {
                int n = 0;
            Label_0139:
                while (true) {
                    int n3 = 0;
                    Label_0133: {
                        synchronized (this) {
                            final int width = this.c.getWidth();
                            final int height = this.c.getHeight();
                            Boolean b;
                            if (width == 0 || height == 0) {
                                b = false;
                            }
                            else {
                                n = 0;
                                int n2 = 0;
                                if (n < width) {
                                    n3 = 0;
                                    if (n3 >= height) {
                                        break Label_0139;
                                    }
                                    if (this.c.getPixel(n, n3) != 0) {
                                        ++n2;
                                    }
                                    break Label_0133;
                                }
                                else {
                                    b = (n2 / (width * height / 100.0) > 0.1);
                                }
                            }
                            return b;
                        }
                    }
                    n3 += 10;
                    continue;
                }
                n += 10;
                continue Label_0058_Outer;
            }
        }
    }
    
    protected void a(final Boolean b) {
        --this.a.f;
        if (b || this.a.c() || this.a.f <= 0L) {
            this.a.c = b;
            this.a.g.a(this.a.a);
        }
        else if (this.a.f > 0L) {
            if (en.a(2)) {
                en.a("Ad not detected, scheduling another run.");
            }
            this.a.d.postDelayed((Runnable)this.a, this.a.e);
        }
    }
    
    protected void onPreExecute() {
        synchronized (this) {
            this.c = Bitmap.createBitmap(this.a.i, this.a.h, Bitmap$Config.ARGB_8888);
            this.b.setVisibility(0);
            this.b.measure(View$MeasureSpec.makeMeasureSpec(this.a.i, 0), View$MeasureSpec.makeMeasureSpec(this.a.h, 0));
            this.b.layout(0, 0, this.a.i, this.a.h);
            this.b.draw(new Canvas(this.c));
            this.b.invalidate();
        }
    }
}
