// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import org.json.JSONObject;
import android.content.Context;

public class f implements d
{
    private final ep a;
    
    public f(final Context context, final dx dx) {
        this.a = ep.a(context, new ak(), false, false, null, dx);
    }
    
    @Override
    public void a(final e e) {
        this.a.f().a(new et() {
            @Override
            public void a(final ep ep) {
                e.a();
            }
        });
    }
    
    @Override
    public void a(final String s) {
        this.a.loadUrl(s);
    }
    
    @Override
    public void a(final String s, final aj aj) {
        this.a.f().a(s, aj);
    }
    
    @Override
    public void a(final String s, final JSONObject jsonObject) {
        this.a.a(s, jsonObject);
    }
    
    @Override
    public void b(final String s) {
        this.a.f().a(s, null);
    }
}
