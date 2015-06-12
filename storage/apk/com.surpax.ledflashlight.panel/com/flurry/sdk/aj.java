// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.FlurryAdModule;
import java.lang.ref.WeakReference;

public abstract class aj
{
    static final String a;
    private final WeakReference b;
    private final FlurryAdModule c;
    private final e d;
    private final AdUnit e;
    
    static {
        a = aj.class.getSimpleName();
    }
    
    public aj(final Context referent, final FlurryAdModule c, final e d, final AdUnit e) {
        this.b = new WeakReference((T)referent);
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public abstract void a();
    
    public Context b() {
        return (Context)this.b.get();
    }
    
    public FlurryAdModule c() {
        return this.c;
    }
    
    public e d() {
        return this.d;
    }
    
    public AdUnit e() {
        return this.e;
    }
}
