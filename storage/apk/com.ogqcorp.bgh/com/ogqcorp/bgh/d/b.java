// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.d;

import android.content.DialogInterface$OnClickListener;
import com.ogqcorp.bgh.system.ac;
import android.app.AlertDialog$Builder;
import com.ogqcorp.bgh.system.o;
import android.content.Context;
import android.preference.Preference;
import android.app.Activity;
import android.preference.Preference$OnPreferenceClickListener;

public final class b implements Preference$OnPreferenceClickListener, d
{
    private Activity a;
    
    public String a() {
        return "CHECK_CACHE";
    }
    
    public void a(final Activity a, final Preference preference) {
        this.a = a;
        preference.setOnPreferenceClickListener((Preference$OnPreferenceClickListener)this);
    }
    
    public void a(final Context context, final Preference preference) {
    }
    
    public void b() {
        this.a = null;
    }
    
    public boolean onPreferenceClick(final Preference preference) {
        ((com.ogqcorp.commons.d<Object, Progress, Result>)new com.ogqcorp.commons.d<Object, Object, Long>() {
            protected Long a(final Object... array) {
                return o.b().n();
            }
            
            protected void a(final Long n) {
                super.onPostExecute(n);
                try {
                    final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)b.this.a);
                    alertDialog$Builder.setTitle(2131427430);
                    alertDialog$Builder.setMessage((CharSequence)(b.this.a.getString(2131427429) + ac.a(n) + " bytes"));
                    alertDialog$Builder.setNeutralButton(17039370, (DialogInterface$OnClickListener)null);
                    alertDialog$Builder.show();
                }
                catch (Exception ex) {}
            }
        }).a((Context)this.a, 2131427462, new Object[0]);
        return true;
    }
}
