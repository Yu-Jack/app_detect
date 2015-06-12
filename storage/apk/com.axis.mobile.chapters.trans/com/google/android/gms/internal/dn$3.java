// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.webkit.WebView;
import android.os.SystemClock;
import org.json.JSONException;
import android.text.TextUtils;
import android.content.Context;

class dn$3 implements Runnable
{
    final /* synthetic */ dn pG;
    
    dn$3(final dn pg) {
        this.pG = pg;
    }
    
    @Override
    public void run() {
        while (true) {
            synchronized (this.pG.ls) {
                if (this.pG.pC.errorCode != -2) {
                    return;
                }
                this.pG.lN.cb().a(this.pG);
                if (this.pG.pC.errorCode == -3) {
                    eu.C("Loading URL in WebView: " + this.pG.pC.oA);
                    this.pG.lN.loadUrl(this.pG.pC.oA);
                    return;
                }
            }
            eu.C("Loading HTML in WebView.");
            this.pG.lN.loadDataWithBaseURL(eo.v(this.pG.pC.oA), this.pG.pC.qe, "text/html", "UTF-8", (String)null);
        }
    }
}
