// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.widget;

import com.facebook.b.al;
import com.facebook.b.aj;
import android.os.Bundle;
import com.facebook.bc;
import android.content.Context;

class m
{
    private Context a;
    private bc b;
    private String c;
    private String d;
    private int e;
    private o f;
    private Bundle g;
    
    protected m(final Context a, String a2, final String d, final Bundle g) {
        this.e = 16973840;
        if (a2 == null) {
            a2 = aj.a(a);
        }
        al.a(a2, "applicationId");
        this.c = a2;
        this.a = a;
        this.d = d;
        if (g != null) {
            this.g = g;
            return;
        }
        this.g = new Bundle();
    }
    
    public k a() {
        if (this.b != null && this.b.a()) {
            this.g.putString("app_id", this.b.c());
            this.g.putString("access_token", this.b.d());
        }
        else {
            this.g.putString("app_id", this.c);
        }
        return new k(this.a, this.d, this.g, this.e, this.f);
    }
    
    public m a(final o f) {
        this.f = f;
        return this;
    }
    
    protected final String b() {
        return this.c;
    }
    
    protected final Context c() {
        return this.a;
    }
    
    protected final int d() {
        return this.e;
    }
    
    protected final Bundle e() {
        return this.g;
    }
    
    protected final o f() {
        return this.f;
    }
}
