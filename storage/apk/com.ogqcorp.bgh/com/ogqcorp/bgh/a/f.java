// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.a;

import com.ogqcorp.commons.o;
import com.ogqcorp.bgh.system.ac;
import com.ogqcorp.bgh.system.g;
import android.content.Context;
import com.ogqcorp.bgh.system.c;
import com.ogqcorp.bgh.item.Background;
import android.app.Activity;

final class f extends d<Activity>
{
    f(final Activity activity) {
        super(activity);
    }
    
    private void a(final Activity activity, final Background background, final Runnable runnable) {
        c.a().c((Context)activity, background);
        ((com.ogqcorp.commons.d<Object, Progress, Result>)new com.ogqcorp.commons.d<Object, Object, Object>() {
            protected Object doInBackground(final Object... array) {
                final long currentTimeMillis = System.currentTimeMillis();
                g.a().b(background);
                final long max = Math.max(0L, currentTimeMillis + (500L - System.currentTimeMillis()));
                if (max != 0L) {
                    ac.a(max);
                }
                return null;
            }
            
            @Override
            protected void onPostExecute(final Object o) {
                super.onPostExecute(o);
                if (runnable != null) {
                    runnable.run();
                }
            }
        }).a((Context)activity, 2131427454, new Object[0]);
    }
    
    void a(final Background background, final Runnable runnable) {
        new o().a(background, "background");
        final Activity a = this.a();
        if (a != null) {
            this.a(a, background, runnable);
        }
    }
}
