// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import java.io.FileOutputStream;
import java.io.IOException;
import android.content.Context;
import android.content.Intent;
import android.app.IntentService;

public class CampaignTrackingService extends IntentService
{
    public CampaignTrackingService() {
        super("CampaignIntentService");
    }
    
    public CampaignTrackingService(final String s) {
        super(s);
    }
    
    public void onHandleIntent(final Intent intent) {
        this.processIntent((Context)this, intent);
    }
    
    public void processIntent(final Context context, final Intent intent) {
        final String stringExtra = intent.getStringExtra("referrer");
        try {
            final FileOutputStream openFileOutput = context.openFileOutput("gaInstallData", 0);
            openFileOutput.write(stringExtra.getBytes());
            openFileOutput.close();
        }
        catch (IOException ex) {
            Log.e("Error storing install campaign.");
        }
    }
}
