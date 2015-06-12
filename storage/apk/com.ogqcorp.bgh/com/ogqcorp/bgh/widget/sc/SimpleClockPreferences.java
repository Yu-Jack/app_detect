// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.widget.sc;

import com.ogqcorp.bgh.widget.sc.a.e;
import com.ogqcorp.bgh.widget.sc.a.d;
import com.ogqcorp.bgh.widget.c;
import android.os.Bundle;
import android.content.Context;
import com.ogqcorp.bgh.widget.a.f;
import android.view.View;
import com.ogqcorp.bgh.widget.b;
import android.app.Activity;

public final class SimpleClockPreferences extends Activity
{
    private void a() {
        final View viewById = this.findViewById(b.background);
        if (this.getIntent().getDataString() != null) {
            viewById.setBackgroundColor(-16777216);
        }
    }
    
    private void a(final boolean b) {
        f.a().a((Context)this, b);
        a.a((Context)this);
    }
    
    protected void onCreate(final Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        this.setContentView(c.widget_sc_preference);
        this.a();
        for (com.ogqcorp.bgh.widget.sc.a.c[] array = { new com.ogqcorp.bgh.widget.sc.a.b(this), new d(this), new e(this), new com.ogqcorp.bgh.widget.sc.a.a(this) }; i < array.length; ++i) {
            array[i].a();
        }
    }
    
    protected void onPause() {
        this.a(false);
        super.onPause();
    }
    
    protected void onResume() {
        this.a(true);
        super.onResume();
    }
}
