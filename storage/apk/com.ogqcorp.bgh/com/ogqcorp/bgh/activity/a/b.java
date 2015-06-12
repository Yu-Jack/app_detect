// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.activity.a;

import android.app.Activity;
import com.ogqcorp.bgh.system.c;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public abstract class b extends SherlockFragmentActivity
{
    @Override
    protected void onStart() {
        super.onStart();
        c.a().a(this);
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        c.a().b(this);
    }
}
