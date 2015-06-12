// 
// Decompiled by Procyon v0.5.29
// 

package bolts;

import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;

public final class AppLinks
{
    static final String KEY_NAME_APPLINK_DATA = "al_applink_data";
    static final String KEY_NAME_EXTRAS = "extras";
    static final String KEY_NAME_TARGET = "target_url";
    
    public static Bundle getAppLinkData(final Intent intent) {
        return intent.getBundleExtra("al_applink_data");
    }
    
    public static Bundle getAppLinkExtras(final Intent intent) {
        final Bundle appLinkData = getAppLinkData(intent);
        if (appLinkData == null) {
            return null;
        }
        return appLinkData.getBundle("extras");
    }
    
    public static Uri getTargetUrl(final Intent intent) {
        final Bundle appLinkData = getAppLinkData(intent);
        if (appLinkData != null) {
            final String string = appLinkData.getString("target_url");
            if (string != null) {
                return Uri.parse(string);
            }
        }
        return intent.getData();
    }
}
