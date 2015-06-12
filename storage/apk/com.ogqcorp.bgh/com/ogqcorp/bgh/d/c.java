// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.d;

import android.widget.Toast;
import com.ogqcorp.bgh.system.l;
import com.ogqcorp.bgh.system.o;
import android.content.Context;
import android.preference.Preference;
import java.io.File;
import android.app.Activity;
import android.preference.Preference$OnPreferenceClickListener;

public final class c implements Preference$OnPreferenceClickListener, d
{
    private Activity a;
    
    private void c() {
        final File parent = new File(this.a.getCacheDir().getParent(), "files");
        if (parent.exists()) {
            for (final String child : parent.list()) {
                if (!child.equals("INSTALLATION")) {
                    new File(parent, child).delete();
                }
            }
        }
    }
    
    public String a() {
        return "CLEAR_CACHE";
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
        ((com.ogqcorp.commons.d<Object, Progress, Result>)new com.ogqcorp.commons.d<Object, Object, Object>() {
            protected Object doInBackground(final Object... array) {
                try {
                    c.this.c();
                    o.b().o();
                    return null;
                }
                catch (Exception ex) {
                    l.b(ex);
                    return null;
                }
            }
            
            @Override
            protected void onPostExecute(final Object o) {
                super.onPostExecute(o);
                if (c.this.a == null || c.this.a.isFinishing()) {
                    return;
                }
                Toast.makeText((Context)c.this.a, 2131427477, 0).show();
            }
        }).a((Context)this.a, 2131427462, new Object[0]);
        return true;
    }
}
