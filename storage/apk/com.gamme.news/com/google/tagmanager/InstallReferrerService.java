// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.content.Intent;
import com.google.analytics.tracking.android.CampaignTrackingService;
import com.google.android.gms.common.util.VisibleForTesting;
import android.content.Context;
import android.app.IntentService;

public final class InstallReferrerService extends IntentService
{
    @VisibleForTesting
    Context contextOverride;
    @VisibleForTesting
    CampaignTrackingService gaService;
    
    public InstallReferrerService() {
        super("InstallReferrerService");
    }
    
    public InstallReferrerService(final String s) {
        super(s);
    }
    
    private void forwardToGoogleAnalytics(final Context context, final Intent intent) {
        if (this.gaService == null) {
            this.gaService = new CampaignTrackingService();
        }
        this.gaService.processIntent(context, intent);
    }
    
    protected void onHandleIntent(final Intent intent) {
        final String stringExtra = intent.getStringExtra("referrer");
        Context context;
        if (this.contextOverride != null) {
            context = this.contextOverride;
        }
        else {
            context = this.getApplicationContext();
        }
        InstallReferrerUtil.saveInstallReferrer(context, stringExtra);
        this.forwardToGoogleAnalytics(context, intent);
    }
}
