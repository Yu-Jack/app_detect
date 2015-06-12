// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.a;

import com.ogqcorp.commons.o;
import android.os.Bundle;
import com.ogqcorp.bgh.system.ac;
import android.content.Context;
import com.ogqcorp.bgh.system.c;
import com.ogqcorp.bgh.item.License;
import android.app.Activity;

final class g extends d<Activity>
{
    g(final Activity activity) {
        super(activity);
    }
    
    private void a(final Activity activity, final License license) {
        c.a().a((Context)activity, license);
        ac.a(activity, license.getLink(), null);
    }
    
    void a(final License license) {
        new o().a(license, "license");
        final Activity a = this.a();
        if (a != null) {
            this.a(a, license);
        }
    }
}
