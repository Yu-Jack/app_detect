// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.Context;

final class dx$1 implements Runnable
{
    final /* synthetic */ Context qu;
    final /* synthetic */ ds qv;
    final /* synthetic */ dz qw;
    final /* synthetic */ ey$a qx;
    final /* synthetic */ String qy;
    
    dx$1(final Context qu, final ds qv, final dz qw, final ey$a qx, final String qy) {
        this.qu = qu;
        this.qv = qv;
        this.qw = qw;
        this.qx = qx;
        this.qy = qy;
    }
    
    @Override
    public void run() {
        final ex a = ex.a(this.qu, new al(), false, false, null, this.qv.kQ);
        a.setWillNotDraw(true);
        this.qw.b(a);
        final ey cb = a.cb();
        cb.a("/invalidRequest", this.qw.qD);
        cb.a("/loadAdURL", this.qw.qE);
        cb.a("/log", bb.mZ);
        cb.a(this.qx);
        eu.z("Loading the JS library.");
        a.loadUrl(this.qy);
    }
}
