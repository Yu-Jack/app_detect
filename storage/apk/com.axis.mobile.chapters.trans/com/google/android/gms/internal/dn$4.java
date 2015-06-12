// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.webkit.WebView;
import android.os.SystemClock;
import org.json.JSONException;
import android.text.TextUtils;
import android.content.Context;

class dn$4 implements Runnable
{
    final /* synthetic */ dn pG;
    final /* synthetic */ do pI;
    
    dn$4(final dn pg, final do pi) {
        this.pG = pg;
        this.pI = pi;
    }
    
    @Override
    public void run() {
        synchronized (this.pG.ls) {
            if (this.pG.pC.errorCode != -2) {
                return;
            }
            this.pG.lN.cb().a(this.pG);
            this.pI.b(this.pG.pC);
        }
    }
}
