// 
// Decompiled by Procyon v0.5.29
// 

package com.plugin.gcm;

import android.app.NotificationManager;
import android.util.Log;
import android.os.Bundle;
import android.app.Activity;

public class PushHandlerActivity extends Activity
{
    private static String TAG;
    
    static {
        PushHandlerActivity.TAG = "PushHandlerActivity";
    }
    
    private void forceMainActivityReload() {
        this.startActivity(this.getPackageManager().getLaunchIntentForPackage(this.getApplicationContext().getPackageName()));
    }
    
    private void processPushBundle(final boolean b) {
        final Bundle extras = this.getIntent().getExtras();
        if (extras != null) {
            final Bundle bundle = extras.getBundle("pushBundle");
            bundle.putBoolean("foreground", false);
            boolean b2 = false;
            if (!b) {
                b2 = true;
            }
            bundle.putBoolean("coldstart", b2);
            PushPlugin.sendExtras(bundle);
        }
    }
    
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        Log.v(PushHandlerActivity.TAG, "onCreate");
        final boolean active = PushPlugin.isActive();
        this.processPushBundle(active);
        this.finish();
        if (!active) {
            this.forceMainActivityReload();
        }
    }
    
    protected void onResume() {
        super.onResume();
        ((NotificationManager)this.getSystemService("notification")).cancelAll();
    }
}
