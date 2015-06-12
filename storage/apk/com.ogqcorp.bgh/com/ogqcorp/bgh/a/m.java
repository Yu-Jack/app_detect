// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.a;

import com.ogqcorp.commons.o;
import com.ogqcorp.bgh.activity.TagActivity;
import android.content.Context;
import com.ogqcorp.bgh.system.c;
import android.app.Activity;

final class m extends d<Activity>
{
    m(final Activity activity) {
        super(activity);
    }
    
    private void a(final Activity activity, final String s) {
        c.a().a((Context)activity, s);
        activity.startActivityForResult(TagActivity.a((Context)activity, s), 0);
    }
    
    void a(final String s) {
        new o().a(s, "tag");
        final Activity a = this.a();
        if (a != null) {
            this.a(a, s);
        }
    }
}
