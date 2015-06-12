// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.d;

import java.io.File;
import com.ogqcorp.commons.a.b;
import com.ogqcorp.bgh.system.v;
import android.content.Context;
import android.preference.Preference;
import android.app.Activity;
import android.preference.Preference$OnPreferenceClickListener;

public final class g implements Preference$OnPreferenceClickListener, d, com.ogqcorp.commons.a.d
{
    private Activity a;
    
    public String a() {
        return "SAVE_DIRECTORY";
    }
    
    public void a(final Activity a, final Preference preference) {
        this.a = a;
        preference.setOnPreferenceClickListener((Preference$OnPreferenceClickListener)this);
    }
    
    public void a(final Context context, final Preference preference) {
        preference.setSummary((CharSequence)v.a().e(context));
    }
    
    public void a(final b b, final File file) {
        v.a().a((Context)this.a, file.getAbsolutePath());
    }
    
    public void b() {
        this.a = null;
    }
    
    public boolean onPreferenceClick(final Preference preference) {
        final String e = v.a().e((Context)this.a);
        while (true) {
            try {
                final b b = new b((Context)this.a, new File(e), false);
                b.a();
                b.a(this);
                return true;
            }
            catch (IllegalArgumentException ex) {
                final b b = new b((Context)this.a, null, false);
                continue;
            }
            break;
        }
    }
}
