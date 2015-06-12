// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.activity.a;

import android.app.Activity;
import com.ogqcorp.bgh.system.c;
import com.actionbarsherlock.app.SherlockPreferenceActivity;

public abstract class c extends SherlockPreferenceActivity
{
    protected void onStart() {
        super.onStart();
        com.ogqcorp.bgh.system.c.a().a((Activity)this);
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        com.ogqcorp.bgh.system.c.a().b((Activity)this);
    }
}
