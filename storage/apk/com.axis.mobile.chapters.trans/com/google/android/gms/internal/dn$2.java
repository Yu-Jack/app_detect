// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.webkit.WebView;
import android.os.SystemClock;
import org.json.JSONException;
import android.text.TextUtils;
import android.content.Context;

class dn$2 implements Runnable
{
    final /* synthetic */ dn pG;
    final /* synthetic */ ef pH;
    
    dn$2(final dn pg, final ef ph) {
        this.pG = pg;
        this.pH = ph;
    }
    
    @Override
    public void run() {
        synchronized (this.pG.ls) {
            this.pG.px.a(this.pH);
        }
    }
}
