// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import com.facebook.widget.k;
import android.os.Bundle;
import android.content.Context;
import com.facebook.widget.l;

final class n extends l
{
    private String a;
    private boolean b;
    
    public n(final Context context, final String s, final Bundle bundle) {
        super(context, s, "oauth", bundle);
    }
    
    public final n a(final String a) {
        this.a = a;
        return this;
    }
    
    public final n a(final boolean b) {
        this.b = b;
        return this;
    }
    
    @Override
    public final k a() {
        final Bundle e = this.e();
        e.putString("redirect_uri", "fbconnect://success");
        e.putString("client_id", this.b());
        e.putString("e2e", this.a);
        e.putString("response_type", "token");
        e.putString("return_scopes", "true");
        if (this.b && !bq.g()) {
            e.putString("auth_type", "rerequest");
        }
        return new k(this.c(), "oauth", e, this.d(), this.f());
    }
}
