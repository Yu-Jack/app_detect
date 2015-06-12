// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import com.inmobi.commons.InMobi;
import android.app.Activity;
import android.os.Bundle;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.FlurryAdModule;
import android.content.Context;
import com.inmobi.monetization.IMInterstitial;
import java.lang.reflect.Method;

public class bv extends ba
{
    private static final String b;
    private static final Method c;
    private final String d;
    private IMInterstitial e;
    private bv$a f;
    
    static {
        b = bv.class.getSimpleName();
        c = g();
    }
    
    public bv(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdUnit adUnit, final Bundle bundle) {
        super(context, flurryAdModule, e, adUnit);
        this.d = bundle.getString("com.flurry.inmobi.MY_APP_ID");
        InMobi.initialize((Activity)this.b(), this.d);
    }
    
    private void a(final IMInterstitial obj, final bv$a bv$a) {
        if (obj != null) {
            try {
                if (bv.c != null) {
                    bv.c.invoke(obj, bv$a);
                }
            }
            catch (Exception ex) {
                eo.a(3, bv.b, "InMobi set listener failed.");
            }
        }
    }
    
    private static Method g() {
        for (final Method method : IMInterstitial.class.getMethods()) {
            final String name = method.getName();
            if (name.equals("setIMInterstitialListener") || name.equals("setImInterstitialListener")) {
                return method;
            }
        }
        return null;
    }
    
    @Override
    public void a() {
        this.e = new IMInterstitial((Activity)this.b(), this.d);
        this.f = new bv$a(this, null);
        this.a(this.e, this.f);
        this.e.loadInterstitial();
    }
}
