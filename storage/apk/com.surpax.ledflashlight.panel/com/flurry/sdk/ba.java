// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Map;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.FlurryAdModule;
import android.content.Context;

public abstract class ba extends aj
{
    private static final String b;
    
    static {
        b = ba.class.getSimpleName();
    }
    
    public ba(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdUnit adUnit) {
        super(context, flurryAdModule, e, adUnit);
    }
    
    private void a(final String str, final Map map) {
        eo.a(3, ba.b, "onEvent: " + str);
        if (this.e() != null) {
            this.c().a(new q(str, map, this.b(), this.e(), this.d(), 0), this.c().a(), 0);
            return;
        }
        eo.a(3, ba.b, "adUnit == null");
    }
    
    public void a(final Map map) {
        this.a("rendered", map);
    }
    
    public void b(final Map map) {
        this.a("clicked", map);
    }
    
    public void c(final Map map) {
        this.a("adClosed", map);
    }
    
    public void d(final Map map) {
        this.a("renderFailed", map);
    }
}
