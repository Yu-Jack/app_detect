// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import com.google.android.gms.common.util.VisibleForTesting;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.Context;

class AppFieldsDefaultProvider implements DefaultProvider
{
    private static AppFieldsDefaultProvider sInstance;
    private static Object sInstanceLock;
    protected String mAppId;
    protected String mAppInstallerId;
    protected String mAppName;
    protected String mAppVersion;
    
    static {
        AppFieldsDefaultProvider.sInstanceLock = new Object();
    }
    
    protected AppFieldsDefaultProvider() {
    }
    
    private AppFieldsDefaultProvider(final Context context) {
        final PackageManager packageManager = context.getPackageManager();
        this.mAppId = context.getPackageName();
        this.mAppInstallerId = packageManager.getInstallerPackageName(this.mAppId);
        String s = this.mAppId;
        while (true) {
            try {
                final PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                String versionName = null;
                if (packageInfo != null) {
                    s = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
                    versionName = packageInfo.versionName;
                }
                this.mAppName = s;
                this.mAppVersion = versionName;
            }
            catch (PackageManager$NameNotFoundException ex) {
                Log.e("Error retrieving package info: appName set to " + s);
                final String versionName = null;
                continue;
            }
            break;
        }
    }
    
    @VisibleForTesting
    static void dropInstance() {
        synchronized (AppFieldsDefaultProvider.sInstanceLock) {
            AppFieldsDefaultProvider.sInstance = null;
        }
    }
    
    public static AppFieldsDefaultProvider getProvider() {
        return AppFieldsDefaultProvider.sInstance;
    }
    
    public static void initializeProvider(final Context context) {
        synchronized (AppFieldsDefaultProvider.sInstanceLock) {
            if (AppFieldsDefaultProvider.sInstance == null) {
                AppFieldsDefaultProvider.sInstance = new AppFieldsDefaultProvider(context);
            }
        }
    }
    
    @Override
    public String getValue(final String s) {
        if (s != null) {
            if (s.equals("&an")) {
                return this.mAppName;
            }
            if (s.equals("&av")) {
                return this.mAppVersion;
            }
            if (s.equals("&aid")) {
                return this.mAppId;
            }
            if (s.equals("&aiid")) {
                return this.mAppInstallerId;
            }
        }
        return null;
    }
    
    @Override
    public boolean providesField(final String s) {
        return "&an".equals(s) || "&av".equals(s) || "&aid".equals(s) || "&aiid".equals(s);
    }
}
