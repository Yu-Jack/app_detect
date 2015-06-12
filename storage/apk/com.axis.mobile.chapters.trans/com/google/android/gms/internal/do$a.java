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

public final class do$a extends AsyncTask
{
    private final WebView pQ;
    private Bitmap pR;
    final /* synthetic */ do pS;
    
    public do$a(final do ps, final WebView pq) {
        this.pS = ps;
        this.pQ = pq;
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
                            final int width = this.pR.getWidth();
                            final int height = this.pR.getHeight();
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
                                    if (this.pR.getPixel(n, n3) != 0) {
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
        --this.pS.pM;
        if (b || this.pS.bq() || this.pS.pM <= 0L) {
            this.pS.pP = b;
            this.pS.pN.a(this.pS.lN);
        }
        else if (this.pS.pM > 0L) {
            if (eu.p(2)) {
                eu.z("Ad not detected, scheduling another run.");
            }
            this.pS.pK.postDelayed((Runnable)this.pS, this.pS.pL);
        }
    }
    
    protected void onPreExecute() {
        synchronized (this) {
            this.pR = Bitmap.createBitmap(this.pS.ku, this.pS.kv, Bitmap$Config.ARGB_8888);
            this.pQ.setVisibility(0);
            this.pQ.measure(View$MeasureSpec.makeMeasureSpec(this.pS.ku, 0), View$MeasureSpec.makeMeasureSpec(this.pS.kv, 0));
            this.pQ.layout(0, 0, this.pS.ku, this.pS.kv);
            this.pQ.draw(new Canvas(this.pR));
            this.pQ.invalidate();
        }
    }
}
