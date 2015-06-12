// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.d;

import com.ogqcorp.bgh.system.l;
import android.preference.Preference;
import com.ogqcorp.commons.m;
import android.content.Intent;
import android.content.Context;
import com.ogqcorp.bgh.a;
import android.app.Activity;
import android.preference.Preference$OnPreferenceClickListener;

public final class e implements Preference$OnPreferenceClickListener, d
{
    private Activity a;
    
    private String a(final int n) {
        return this.a.getString(n).replace("$APP_STORE_NAME$", com.ogqcorp.bgh.a.a((Context)this.a)).replace("$APP_STORE_LINK$", com.ogqcorp.bgh.a.b((Context)this.a));
    }
    
    private void a(final Intent intent) {
        new m().a(this.a(2131427471)).a("android", "phone", com.ogqcorp.bgh.a.b((Context)this.a), "bgh://start").a((Context)this.a, intent);
    }
    
    public String a() {
        return "RECOMMEND";
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
        try {
            final Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", this.a(2131427470));
            final Intent chooser = Intent.createChooser(intent, (CharSequence)this.a.getString(2131427474));
            this.a(chooser);
            this.a.startActivity(chooser);
            return true;
        }
        catch (Exception ex) {
            l.b(ex);
            return true;
        }
    }
}
