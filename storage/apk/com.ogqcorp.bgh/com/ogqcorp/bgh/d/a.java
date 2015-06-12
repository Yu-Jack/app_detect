// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.d;

import com.ogqcorp.bgh.activity.AboutActivity;
import android.content.Context;
import android.preference.Preference;
import android.app.Activity;
import android.preference.Preference$OnPreferenceClickListener;

public final class a implements Preference$OnPreferenceClickListener, d
{
    private Activity a;
    
    public String a() {
        return "ABOUT_OGQ";
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
        this.a.startActivity(AboutActivity.a((Context)this.a));
        return true;
    }
}
