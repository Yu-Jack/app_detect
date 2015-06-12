// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.content.Context;

public final class AdRegistration
{
    private static final String LOG_TAG = "AdRegistration";
    
    public static final void enableLogging(final boolean b) {
        Log.enableLoggingWithSetterNotification("AdRegistration", b);
    }
    
    public static final void enableTesting(final boolean b) {
        Settings.getInstance().putTransientBoolean("testingEnabled", b);
        Log.logSetterNotification("AdRegistration", "Test mode", b);
    }
    
    public static final String getVersion() {
        return Version.getSDKVersion();
    }
    
    public static final void registerApp(final Context context) {
        if (!PermissionChecker.getInstance().passesInternetPermissionCheck(context, "AdRegistration")) {
            return;
        }
        InternalAdRegistration.getInstance().contextReceived(context);
        InternalAdRegistration.getInstance().register();
    }
    
    public static final void setAppKey(final String s) {
        InternalAdRegistration.getInstance().getRegistrationInfo().putAppKey(s);
    }
}
