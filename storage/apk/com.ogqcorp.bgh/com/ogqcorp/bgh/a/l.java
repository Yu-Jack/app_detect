// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.a;

import java.util.Locale;
import com.ogqcorp.bgh.system.o;
import com.ogqcorp.commons.m;
import android.content.Intent;
import com.ogqcorp.bgh.system.c;
import com.ogqcorp.bgh.item.Background;
import com.ogqcorp.bgh.a;
import android.content.Context;
import android.app.Activity;

final class l extends d<Activity>
{
    l(final Activity activity) {
        super(activity);
    }
    
    private String a(final Context context) {
        return com.ogqcorp.bgh.a.b(context);
    }
    
    private String a(final Context context, final int n, final Background background) {
        final String replace = context.getString(n).replace("$AUTHOR_NAME$", background.getAuthor().getName());
        String title = background.getTitle();
        if (title == null) {
            title = "";
        }
        return replace.replace("$TITLE$", title).replace("$SHARE_PAGE_URL$", this.b(background));
    }
    
    private void a(final Activity activity, final Background background) {
        c.a().f((Context)activity, background);
        final Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", this.a((Context)activity, 2131427475, background));
        final Intent chooser = Intent.createChooser(intent, (CharSequence)activity.getString(2131427474));
        this.a((Context)activity, background, chooser);
        activity.startActivity(chooser);
    }
    
    private void a(final Context context, final Background background, final Intent intent) {
        new m().a(this.a(context, 2131427476, background)).a("android", "phone", this.a(context), this.c(background)).a(context, intent);
    }
    
    private String b(final Background background) {
        return o.b().a(background.getHashKey());
    }
    
    private String c(final Background background) {
        return String.format(Locale.US, "bgh://background?id=%d", background.getId());
    }
    
    void a(final Background background) {
        new com.ogqcorp.commons.o().a(background, "background");
        final Activity a = this.a();
        if (a != null) {
            this.a(a, background);
        }
    }
}
