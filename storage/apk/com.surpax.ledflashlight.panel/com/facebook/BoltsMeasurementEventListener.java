// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.content.Intent;
import android.support.v4.content.e;
import android.content.Context;
import android.content.BroadcastReceiver;

public class BoltsMeasurementEventListener extends BroadcastReceiver
{
    private Context a;
    
    protected void finalize() {
        try {
            e.a(this.a).a(this);
        }
        finally {
            super.finalize();
        }
    }
    
    public void onReceive(final Context context, final Intent intent) {
        d.a(context).a("bf_" + intent.getStringExtra("event_name"), intent.getBundleExtra("event_args"));
    }
}
