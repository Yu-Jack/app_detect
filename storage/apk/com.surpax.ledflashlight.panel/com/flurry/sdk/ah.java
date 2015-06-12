// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import android.view.ViewGroup;
import android.content.Context;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.FlurryAdModule;

public abstract class ah
{
    private final FlurryAdModule a;
    private final AdUnit b;
    private final e c;
    private final String d;
    
    public ah(final FlurryAdModule a, final AdUnit b, final e c) {
        this.a = a;
        this.b = b;
        this.c = c;
        String string;
        if (b != null) {
            string = b.b().toString();
        }
        else {
            string = null;
        }
        this.d = string;
    }
    
    public abstract void a(final Context p0, final ViewGroup p1);
    
    public FlurryAdModule b() {
        return this.a;
    }
    
    public AdUnit c() {
        return this.b;
    }
    
    public e d() {
        return this.c;
    }
    
    public String e() {
        return this.d;
    }
}
