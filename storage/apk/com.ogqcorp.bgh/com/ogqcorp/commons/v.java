// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons;

import android.content.SharedPreferences$Editor;
import java.io.Serializable;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;
import android.content.Context;
import android.os.Bundle;

public abstract class v
{
    private final Bundle a;
    
    public v() {
        this.a = new Bundle();
    }
    
    private SharedPreferences a(final Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
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
    
    protected final long a(final Context context, final String s, final long n) {
        try {
            if (this.a.containsKey(s)) {
                return this.a.getLong(s);
            }
            final long long1 = this.a(context).getLong(s, n);
            this.a.putLong(s, long1);
            return long1;
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
    
    public void a(final SharedPreferences sharedPreferences, final String s) {
        try {
            this.a.putSerializable(s, (Serializable)sharedPreferences.getAll().get(s));
        }
        catch (Exception ex) {
            n.a(ex);
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
    
    protected final void b(final Context context, final String s, final int n) {
        try {
            final SharedPreferences$Editor edit = this.a(context).edit();
            edit.putInt(s, n);
            edit.commit();
            this.a.putInt(s, n);
        }
        catch (Exception ex) {
            n.a(ex);
        }
    }
    
    protected final void b(final Context context, final String s, final long n) {
        try {
            final SharedPreferences$Editor edit = this.a(context).edit();
            edit.putLong(s, n);
            edit.commit();
            this.a.putLong(s, n);
        }
        catch (Exception ex) {
            n.a(ex);
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
            n.a(ex);
        }
    }
}
