// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.widget.a;

import android.content.Context;

public final class f extends g
{
    private static final f a;
    
    static {
        a = new f();
    }
    
    public static f a() {
        return f.a;
    }
    
    public String a(final Context context) {
        return this.a(context, "FONT_NAME", "Roboto Light");
    }
    
    public void a(final Context context, final float n) {
        this.b(context, "POS_X", n);
    }
    
    public void a(final Context context, final int n) {
        this.b(context, "TEXT_COLOR", n);
    }
    
    public void a(final Context context, final String s) {
        this.b(context, "FONT_NAME", s);
    }
    
    public void a(final Context context, final boolean b) {
        this.b(context, "PREFERENCES_MODE", b);
    }
    
    public int b(final Context context) {
        return this.a(context, "TEXT_COLOR", -16777216);
    }
    
    public void b(final Context context, final float n) {
        this.b(context, "POS_Y", n);
    }
    
    public void b(final Context context, final String s) {
        this.b(context, "CLICK_ACTION", s);
    }
    
    public float c(final Context context) {
        return this.a(context, "POS_X", 23.0f);
    }
    
    public float d(final Context context) {
        return this.a(context, "POS_Y", 23.0f);
    }
    
    public boolean e(final Context context) {
        return this.a(context, "PREFERENCES_MODE", false);
    }
    
    public String f(final Context context) {
        return this.a(context, "CLICK_ACTION", "@PREFERENCES");
    }
}
