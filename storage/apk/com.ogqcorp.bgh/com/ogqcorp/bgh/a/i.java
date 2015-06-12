// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.a;

import com.ogqcorp.commons.o;
import com.ogqcorp.bgh.activity.PreviewActivity;
import java.io.File;
import com.ogqcorp.commons.u;
import android.content.Context;
import com.ogqcorp.bgh.system.c;
import com.ogqcorp.bgh.item.Background;
import android.support.v4.app.FragmentActivity;

final class i extends d<FragmentActivity>
{
    i(final FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    
    private void a(final FragmentActivity fragmentActivity, final Background background) {
        c.a().d((Context)fragmentActivity, background);
        new j(this, fragmentActivity).a(background, false, null, null);
    }
    
    private void a(final Background background, final File file, final u<File> u) {
        final FragmentActivity fragmentActivity = this.a();
        if (fragmentActivity == null) {
            return;
        }
        fragmentActivity.startActivity(PreviewActivity.a((Context)fragmentActivity, file));
    }
    
    void a(final Background background) {
        new o().a(background, "background");
        final FragmentActivity fragmentActivity = this.a();
        if (fragmentActivity != null) {
            this.a(fragmentActivity, background);
        }
    }
}
