// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.d;

import android.content.Context;

public final class a extends b
{
    private static final a a;
    
    static {
        a = new a();
    }
    
    public static a a() {
        return com.ogqcorp.bgh.cf.d.a.a;
    }
    
    public void a(final Context context, final String s) {
        this.b(context, "KEY_LAST_ID", s);
    }
    
    public void a(final Context context, final String[] array) {
        this.a(context, "KEY_IDS", array);
    }
    
    public String[] a(final Context context) {
        return this.b(context, "KEY_IDS");
    }
    
    public void b(final Context context, final String[] array) {
        this.a(context, "KEY_LIKED_IDS", array);
    }
    
    public String[] b(final Context context) {
        return this.b(context, "KEY_LIKED_IDS");
    }
    
    public String c(final Context context) {
        return this.a(context, "KEY_LAST_ID", "0");
    }
}
