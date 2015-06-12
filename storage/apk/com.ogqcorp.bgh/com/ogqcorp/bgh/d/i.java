// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.d;

import com.ogqcorp.bgh.receiver.NotificationReceiver;
import android.content.Context;
import android.preference.Preference;
import android.app.Activity;
import android.preference.Preference$OnPreferenceChangeListener;

public final class i implements Preference$OnPreferenceChangeListener, d
{
    private Activity a;
    
    public String a() {
        return "USE_NOTIFICATION";
    }
    
    public void a(final Activity a, final Preference preference) {
        this.a = a;
        preference.setOnPreferenceChangeListener((Preference$OnPreferenceChangeListener)this);
    }
    
    public void a(final Context context, final Preference preference) {
    }
    
    public void b() {
        this.a = null;
    }
    
    public boolean onPreferenceChange(final Preference preference, final Object o) {
        if (o.equals(true)) {
            NotificationReceiver.a((Context)this.a);
            return true;
        }
        NotificationReceiver.b((Context)this.a);
        return true;
    }
}
