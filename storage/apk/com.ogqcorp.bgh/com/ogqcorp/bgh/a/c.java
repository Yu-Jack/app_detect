// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.a;

import android.os.Bundle;
import com.ogqcorp.bgh.system.ac;
import com.ogqcorp.bgh.system.o;
import android.content.Context;
import com.ogqcorp.bgh.system.c;
import com.ogqcorp.bgh.item.Background;
import android.app.Activity;

final class c extends d<Activity>
{
    c(final Activity activity) {
        super(activity);
    }
    
    private void a(final Activity activity, final Background background) {
        com.ogqcorp.bgh.system.c.a().a((Context)activity, background);
        ac.a(activity, o.b().f(background.getAuthor().getId()), this.b(background));
    }
    
    private Bundle b(final Background background) {
        final String a = o.b().a(background.getHashKey());
        final Bundle bundle = new Bundle();
        bundle.putString("Referer", a);
        return bundle;
    }
    
    void a(final Background background) {
        new com.ogqcorp.commons.o().a(background, "background").a(background.getAuthor(), "background.getAuthor");
        final Activity a = this.a();
        if (a != null) {
            this.a(a, background);
        }
    }
}
