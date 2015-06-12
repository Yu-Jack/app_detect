// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.a;

import com.ogqcorp.commons.o;
import java.util.List;
import android.os.Bundle;
import com.ogqcorp.bgh.system.ac;
import com.ogqcorp.bgh.item.Link;
import com.ogqcorp.bgh.item.Background;
import android.app.Activity;

final class h extends d<Activity>
{
    h(final Activity activity) {
        super(activity);
    }
    
    private void a(final Activity activity, final Background background) {
        final List<Link> linksList = background.getLinksList();
        if (linksList == null || linksList.isEmpty()) {
            return;
        }
        final Link link = linksList.get(0);
        com.ogqcorp.bgh.system.d.b(background.getId(), link.getType(), link.getOrder(), 0);
        ac.a(activity, link.getUri(), null);
    }
    
    void a(final Background background) {
        new o().a(background, "background").a(background.getLinksList(), "background.getLinksList");
        final Activity a = this.a();
        if (a != null) {
            this.a(a, background);
        }
    }
}
