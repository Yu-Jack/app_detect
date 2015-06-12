// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.widget.a;

import android.content.SharedPreferences$Editor;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;
import android.content.Context;
import android.os.Bundle;

public abstract class g
{
    private final Bundle a;
    
    public g() {
        this.a = new Bundle();
    }
    
    private SharedPreferences a(final Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
    
    protected final float a(final Context context, final String s, final float n) {
        try {
            if (this.a.containsKey(s)) {
                return this.a.getFloat(s);
            }
            final float float1 = this.a(context).getFloat(s, n);
            this.a.putFloat(s, float1);
            return float1;
        }
        catch (Exception ex) {
            return n;
        }
    }
    
    protected final int a(final Context context, final String s, final int n) {
        try {
            if (this.a.containsKey(s)) {
                return this.a.getInt(s);
            }
            final int int1 = this.a(context).getInt(s, n);
            this.a.putInt(s, int1);
            return int1;
        }
        catch (Exception ex) {
            return n;
        }
    }
    
    protected final String a(final Context context, final String s, final String s2) {
        try {
            if (this.a.containsKey(s)) {
                return this.a.getString(s);
            }
            final String string = this.a(context).getString(s, s2);
            this.a.putString(s, string);
            return string;
        }
        catch (Exception ex) {
            return s2;
        }
    }
    
    protected final boolean a(final Context context, final String s, final boolean b) {
        try {
            if (this.a.containsKey(s)) {
                return this.a.getBoolean(s);
            }
            final boolean boolean1 = this.a(context).getBoolean(s, b);
            this.a.putBoolean(s, boolean1);
            return boolean1;
        }
        catch (Exception ex) {
            return b;
        }
    }
    
    protected final void b(final Context context, final String s, final float n) {
        try {
            final SharedPreferences$Editor edit = this.a(context).edit();
            edit.putFloat(s, n);
            edit.commit();
            this.a.putFloat(s, n);
        }
        catch (Exception ex) {
            d.a(ex);
        }
    }
    
    protected final void b(final Context context, final String s, final int n) {
        try {
            final SharedPreferences$Editor edit = this.a(context).edit();
            edit.putInt(s, n);
            edit.commit();
            this.a.putInt(s, n);
        }
        catch (Exception ex) {
            d.a(ex);
        }
    }
    
    protected final void b(final Context context, final String s, final String s2) {
        try {
            final SharedPreferences$Editor edit = this.a(context).edit();
            edit.putString(s, s2);
            edit.commit();
            this.a.putString(s, s2);
        }
        catch (Exception ex) {
            d.a(ex);
        }
    }
    
    protected final void b(final Context context, final String s, final boolean b) {
        try {
            final SharedPreferences$Editor edit = this.a(context).edit();
            edit.putBoolean(s, b);
            edit.commit();
            this.a.putBoolean(s, b);
        }
        catch (Exception ex) {
            d.a(ex);
        }
    }
}
