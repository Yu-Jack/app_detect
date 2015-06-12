// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Map;

class dz$2 implements bc
{
    final /* synthetic */ dz qF;
    
    dz$2(final dz qf) {
        this.qF = qf;
    }
    
    @Override
    public void b(final ex ex, final Map map) {
        synchronized (this.qF.ls) {
            final eb eb = new eb(map);
            final String url = eb.getUrl();
            if (url == null) {
                eu.D("URL missing in loadAdUrl GMSG.");
                return;
            }
            if (url.contains("%40mediation_adapters%40")) {
                eu.C("Ad request URL modified to " + url.replaceAll("%40mediation_adapters%40", el.a(ex.getContext(), map.get("check_adapters"), this.qF.qB)));
            }
            this.qF.qC = eb;
            this.qF.ls.notify();
        }
    }
}
