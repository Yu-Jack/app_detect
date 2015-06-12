// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.List;
import java.util.Collections;
import com.flurry.android.AdCreative;
import android.os.Bundle;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.FlurryAdModule;
import android.content.Context;

public abstract class bg implements ak, k
{
    protected abstract aj a(final Context p0, final FlurryAdModule p1, final e p2, final AdUnit p3, final Bundle p4);
    
    protected bf a() {
        return this.c();
    }
    
    protected abstract i a(final Context p0, final FlurryAdModule p1, final e p2, final AdCreative p3, final Bundle p4);
    
    @Override
    public i a(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdUnit adUnit) {
        if (context != null && flurryAdModule != null && e != null && adUnit != null && this.b(context, this.e())) {
            final Bundle c = this.c(context, flurryAdModule, e, adUnit);
            if (c != null) {
                final AdCreative a = cc.a(adUnit);
                if (a != null) {
                    return this.a(context, flurryAdModule, e, a, c);
                }
            }
        }
        return null;
    }
    
    protected boolean a(final Context context, final bj bj) {
        if (context != null && bj != null) {
            final bf a = this.a();
            if (a != null) {
                return a.a(context, bj);
            }
        }
        return false;
    }
    
    @Override
    public aj a_(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdUnit adUnit) {
        if (context != null && flurryAdModule != null && e != null && adUnit != null && this.a(context, this.d())) {
            final Bundle b = this.b(context, flurryAdModule, e, adUnit);
            if (b != null) {
                return this.a(context, flurryAdModule, e, adUnit, b);
            }
        }
        return null;
    }
    
    protected Bundle b(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdUnit adUnit) {
        return this.d(context, flurryAdModule, e, adUnit);
    }
    
    protected bf b() {
        return this.c();
    }
    
    protected boolean b(final Context context, final bj bj) {
        if (context != null && bj != null) {
            final bf b = this.b();
            if (b != null) {
                return b.a(context, bj);
            }
        }
        return false;
    }
    
    protected Bundle c(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdUnit adUnit) {
        return this.d(context, flurryAdModule, e, adUnit);
    }
    
    protected bf c() {
        return new be();
    }
    
    protected Bundle d(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdUnit adUnit) {
        return dx.d(context);
    }
    
    protected bj d() {
        return new bj(this.f(), this.g(), this.h(), this.i(), this.j());
    }
    
    protected bj e() {
        return new bj(this.f(), this.k(), this.l(), this.m(), Collections.emptyList());
    }
    
    protected abstract String f();
    
    protected abstract List g();
    
    protected List h() {
        return this.n();
    }
    
    protected List i() {
        return this.o();
    }
    
    protected abstract List j();
    
    protected abstract List k();
    
    protected List l() {
        return this.n();
    }
    
    protected List m() {
        return this.o();
    }
    
    protected abstract List n();
    
    protected abstract List o();
}
