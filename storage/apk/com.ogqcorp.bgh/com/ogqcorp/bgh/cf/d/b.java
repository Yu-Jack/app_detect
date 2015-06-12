// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.d;

import android.content.SharedPreferences$Editor;
import com.ogqcorp.bgh.cf.a;
import org.a.a.b.b;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;
import android.content.Context;
import android.os.Bundle;

public abstract class b
{
    private final Bundle a;
    
    public b() {
        this.a = new Bundle();
    }
    
    private SharedPreferences a(final Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
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
    
    protected final void a(final Context context, final String s, final String[] array) {
        this.b(context, s, org.a.a.b.b.a(array, ','));
    }
    
    protected final void b(final Context context, final String s, final String s2) {
        try {
            final SharedPreferences$Editor edit = this.a(context).edit();
            edit.putString(s, s2);
            edit.commit();
            this.a.putString(s, s2);
        }
        catch (Exception ex) {
            com.ogqcorp.bgh.cf.a.a(ex);
        }
    }
    
    protected final String[] b(final Context context, final String s) {
        return org.a.a.b.b.a(this.a(context, s, (String)null), ',');
    }
}
