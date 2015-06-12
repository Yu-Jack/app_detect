// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.util.Log;
import android.text.TextUtils;

public class gn
{
    private static boolean Cl;
    private boolean Cm;
    private boolean Cn;
    private String Co;
    private final String mTag;
    
    static {
        gn.Cl = false;
    }
    
    public gn(final String s) {
        this(s, es());
    }
    
    public gn(final String mTag, final boolean cm) {
        this.mTag = mTag;
        this.Cm = cm;
        this.Cn = false;
    }
    
    private String e(final String format, final Object... args) {
        String str = String.format(format, args);
        if (!TextUtils.isEmpty((CharSequence)this.Co)) {
            str = this.Co + str;
        }
        return str;
    }
    
    public static boolean es() {
        return gn.Cl;
    }
    
    public void a(final String s, final Object... array) {
        if (this.er()) {
            Log.v(this.mTag, this.e(s, array));
        }
    }
    
    public void a(final Throwable t, final String s, final Object... array) {
        if (this.eq() || gn.Cl) {
            Log.d(this.mTag, this.e(s, array), t);
        }
    }
    
    public void ap(final String s) {
        String format;
        if (TextUtils.isEmpty((CharSequence)s)) {
            format = null;
        }
        else {
            format = String.format("[%s] ", s);
        }
        this.Co = format;
    }
    
    public void b(final String s, final Object... array) {
        if (this.eq() || gn.Cl) {
            Log.d(this.mTag, this.e(s, array));
        }
    }
    
    public void c(final String s, final Object... array) {
        Log.i(this.mTag, this.e(s, array));
    }
    
    public void d(final String s, final Object... array) {
        Log.w(this.mTag, this.e(s, array));
    }
    
    public boolean eq() {
        return this.Cm;
    }
    
    public boolean er() {
        return this.Cn;
    }
}
