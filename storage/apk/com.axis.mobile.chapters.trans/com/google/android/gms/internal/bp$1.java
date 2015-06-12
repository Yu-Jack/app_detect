// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.SystemClock;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import android.text.TextUtils;
import android.os.RemoteException;
import com.google.android.gms.dynamic.e;
import android.content.Context;

class bp$1 implements Runnable
{
    final /* synthetic */ bo nJ;
    final /* synthetic */ bp nK;
    
    bp$1(final bp nk, final bo nj) {
        this.nK = nk;
        this.nJ = nj;
    }
    
    @Override
    public void run() {
        synchronized (this.nK.ls) {
            if (this.nK.nI != -2) {
                return;
            }
            this.nK.nH = this.nK.aP();
            if (this.nK.nH == null) {
                this.nK.g(4);
                return;
            }
        }
        this.nJ.a(this.nK);
        this.nK.a(this.nJ);
    }
    // monitorexit(o)
}
