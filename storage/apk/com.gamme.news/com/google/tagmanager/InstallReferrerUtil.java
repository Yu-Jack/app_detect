// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.content.SharedPreferences;
import android.net.Uri;
import android.content.Context;
import java.util.HashMap;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;

class InstallReferrerUtil
{
    static final String INTENT_EXTRA_REFERRER = "referrer";
    static final String PREF_KEY_REFERRER = "referrer";
    static final String PREF_NAME_CLICK_REFERRERS = "gtm_click_referrers";
    static final String PREF_NAME_INSTALL_REFERRER = "gtm_install_referrer";
    @VisibleForTesting
    static Map<String, String> clickReferrers;
    private static String installReferrer;
    
    static {
        InstallReferrerUtil.clickReferrers = new HashMap<String, String>();
    }
    
    static void addClickReferrer(final Context context, final String s) {
        final String component = extractComponent(s, "conv");
        if (component != null && component.length() > 0) {
            InstallReferrerUtil.clickReferrers.put(component, s);
            SharedPreferencesUtil.saveAsync(context, "gtm_click_referrers", component, s);
        }
    }
    
    static void cacheInstallReferrer(final String installReferrer) {
        synchronized (InstallReferrerUtil.class) {
            InstallReferrerUtil.installReferrer = installReferrer;
        }
    }
    
    static String extractComponent(final String str, final String s) {
        if (s != null) {
            return Uri.parse("http://hostname/?" + str).getQueryParameter(s);
        }
        if (str.length() > 0) {
            return str;
        }
        return null;
    }
    
    static String getClickReferrer(final Context context, final String s, final String s2) {
        String string = InstallReferrerUtil.clickReferrers.get(s);
        if (string == null) {
            final SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_click_referrers", 0);
            if (sharedPreferences != null) {
                string = sharedPreferences.getString(s, "");
            }
            else {
                string = "";
            }
            InstallReferrerUtil.clickReferrers.put(s, string);
        }
        return extractComponent(string, s2);
    }
    
    static String getInstallReferrer(final Context context, final String s) {
        Label_0043: {
            if (InstallReferrerUtil.installReferrer != null) {
                break Label_0043;
            }
            synchronized (InstallReferrerUtil.class) {
                if (InstallReferrerUtil.installReferrer == null) {
                    final SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                    if (sharedPreferences != null) {
                        InstallReferrerUtil.installReferrer = sharedPreferences.getString("referrer", "");
                    }
                    else {
                        InstallReferrerUtil.installReferrer = "";
                    }
                }
                // monitorexit(InstallReferrerUtil.class)
                return extractComponent(InstallReferrerUtil.installReferrer, s);
            }
        }
    }
    
    static void saveInstallReferrer(final Context context, final String s) {
        SharedPreferencesUtil.saveAsync(context, "gtm_install_referrer", "referrer", s);
        addClickReferrer(context, s);
    }
}
