// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import java.io.FileOutputStream;
import java.io.IOException;
import android.content.Intent;
import android.content.Context;
import android.app.IntentService;

public class CampaignTrackingService extends IntentService
{
    public CampaignTrackingService() {
        super("CampaignIntentService");
    }
    
    public CampaignTrackingService(final String s) {
        super(s);
    }
    
    public void a(final Context context, final Intent intent) {
        final String stringExtra = intent.getStringExtra("referrer");
        try {
            final FileOutputStream openFileOutput = context.openFileOutput("gaInstallData", 0);
            openFileOutput.write(stringExtra.getBytes());
            openFileOutput.close();
            p.c("Stored campaign information.");
        }
        catch (IOException ex) {
            p.a("Error storing install campaign.");
        }
    }
    
    public void onHandleIntent(final Intent intent) {
        this.a((Context)this, intent);
    }
}
