// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.a;

import com.ogqcorp.commons.o;
import com.ogqcorp.bgh.activity.AuthorActivity;
import android.content.Context;
import com.ogqcorp.bgh.system.c;
import com.ogqcorp.bgh.item.Author;
import android.app.Activity;

final class b extends d<Activity>
{
    b(final Activity activity) {
        super(activity);
    }
    
    private void a(final Activity activity, final Author author) {
        c.a().a((Context)activity, author);
        activity.startActivityForResult(AuthorActivity.a((Context)activity, author), 0);
    }
    
    void a(final Author author) {
        new o().a(author, "author");
        final Activity a = this.a();
        if (a != null) {
            this.a(a, author);
        }
    }
}
