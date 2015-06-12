// 
// Decompiled by Procyon v0.5.29
// 

package com.appsflyer;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public final class d
{
    private static d a;
    private Map b;
    private boolean c;
    private boolean d;
    private String e;
    
    static {
        d.a = new d();
    }
    
    private d() {
        this.b = new HashMap();
    }
    
    public static d a() {
        return d.a;
    }
    
    public final String a(final Context context) {
        if (this.e != null) {
            return this.e;
        }
        return context.getSharedPreferences("appsflyer-data", 0).getString("referrer", (String)null);
    }
    
    public final String a(final String s) {
        return this.b.get(s);
    }
    
    public final void a(final String s, final String s2) {
        this.b.put(s, s2);
    }
    
    public final boolean a(final String s, final boolean b) {
        final String a = this.a(s);
        if (a == null) {
            return b;
        }
        return Boolean.valueOf(a);
    }
    
    protected final void b() {
        this.c = true;
    }
    
    protected final void b(final String e) {
        this.e = e;
    }
    
    protected final boolean c() {
        return this.d;
    }
    
    protected final void d() {
        this.d = true;
    }
}
