// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.d;

import com.ogqcorp.bgh.system.ac;
import android.content.Context;
import android.preference.Preference;
import android.app.Activity;

public final class j implements d
{
    @Override
    public String a() {
        return "VERSION";
    }
    
    @Override
    public void a(final Activity activity, final Preference preference) {
    }
    
    @Override
    public void a(final Context context, final Preference preference) {
        preference.setSummary((CharSequence)ac.d(context));
    }
    
    @Override
    public void b() {
    }
}
