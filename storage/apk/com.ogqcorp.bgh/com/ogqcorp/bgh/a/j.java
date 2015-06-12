// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.a;

import com.ogqcorp.commons.o;
import com.ogqcorp.bgh.activity.PreviewActivity;
import android.content.Context;
import com.ogqcorp.bgh.system.c;
import com.ogqcorp.commons.u;
import java.io.File;
import com.ogqcorp.bgh.item.Background;
import android.support.v4.app.FragmentActivity;

class j extends k
{
    final /* synthetic */ i a;
    
    public j(final i a, final FragmentActivity fragmentActivity) {
        this.a = a;
        super(fragmentActivity);
    }
    
    @Override
    protected void a(final Background background, final File file, final u<File> u, final boolean b) {
        this.a.a(background, file, u);
    }
}
