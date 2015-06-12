// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import android.view.ViewGroup;
import android.content.Context;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.FlurryAdModule;

public final class ai extends ah
{
    private static final String a;
    private aj b;
    
    static {
        a = ai.class.getSimpleName();
    }
    
    public ai(final FlurryAdModule flurryAdModule, final AdUnit adUnit, final e e) {
        super(flurryAdModule, adUnit, e);
    }
    
    @Override
    public final void a(final Context context, final ViewGroup viewGroup) {
        if (context == null) {
            eo.a(6, ai.a, "failed to render takeover ad for adspace: " + this.e() + " context: " + context + " viewGroup: " + viewGroup);
        }
        else {
            final FlurryAdModule b = this.b();
            final AdUnit c = this.c();
            final e d = this.d();
            if (c == null) {
                eo.a(6, ai.a, "failed to render takeover ad, adUnit is null for adspace: " + this.e() + " context: " + context + " viewGroup: " + viewGroup);
                return;
            }
            this.b = this.b().c().a_(context, b, d, c);
            if (this.b != null) {
                b.a(c);
                b.a(d);
                this.b.a();
            }
        }
    }
}
