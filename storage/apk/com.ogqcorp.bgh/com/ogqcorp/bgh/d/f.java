// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.d;

import com.ogqcorp.bgh.system.v;
import android.text.Html;
import com.ogqcorp.bgh.system.o;
import android.content.Context;
import android.preference.Preference;
import android.app.Activity;
import android.preference.Preference$OnPreferenceClickListener;

public final class f implements Preference$OnPreferenceClickListener, d
{
    private Activity a;
    
    public String a() {
        return "RESET_SAVE_DIRECTORY";
    }
    
    public void a(final Activity a, final Preference preference) {
        this.a = a;
        preference.setOnPreferenceClickListener((Preference$OnPreferenceClickListener)this);
    }
    
    public void a(final Context context, final Preference preference) {
        preference.setSummary((CharSequence)Html.fromHtml(context.getString(2131427511, new Object[] { o.b().c().getAbsolutePath() })));
    }
    
    public void b() {
        this.a = null;
    }
    
    public boolean onPreferenceClick(final Preference preference) {
        v.a().a((Context)this.a, o.b().c().getAbsolutePath());
        return true;
    }
}
