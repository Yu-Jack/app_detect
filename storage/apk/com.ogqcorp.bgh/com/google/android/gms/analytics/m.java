// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import java.util.Map;
import java.util.HashMap;
import android.app.Activity;
import java.util.Timer;
import java.util.TimerTask;

class m extends TimerTask
{
    final /* synthetic */ l a;
    
    private m(final l a) {
        this.a = a;
    }
    
    @Override
    public void run() {
        this.a.d = false;
    }
}
