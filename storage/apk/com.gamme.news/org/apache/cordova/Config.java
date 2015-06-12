// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import android.app.Activity;
import java.util.List;
import android.util.Log;

@Deprecated
public class Config
{
    private static final String TAG = "Config";
    static ConfigXmlParser parser;
    
    public static void addWhiteListEntry(final String s, final boolean b) {
        if (Config.parser == null) {
            Log.e("Config", "Config was not initialised. Did you forget to Config.init(this)?");
            return;
        }
        Config.parser.getInternalWhitelist().addWhiteListEntry(s, b);
    }
    
    public static String getErrorUrl() {
        return Config.parser.getPreferences().getString("errorurl", null);
    }
    
    public static Whitelist getExternalWhitelist() {
        return Config.parser.getExternalWhitelist();
    }
    
    public static List<PluginEntry> getPluginEntries() {
        return Config.parser.getPluginEntries();
    }
    
    public static CordovaPreferences getPreferences() {
        return Config.parser.getPreferences();
    }
    
    public static String getStartUrl() {
        if (Config.parser == null) {
            return "file:///android_asset/www/index.html";
        }
        return Config.parser.getLaunchUrl();
    }
    
    public static Whitelist getWhitelist() {
        return Config.parser.getInternalWhitelist();
    }
    
    public static void init() {
        if (Config.parser == null) {
            Config.parser = new ConfigXmlParser();
        }
    }
    
    public static void init(final Activity activity) {
        (Config.parser = new ConfigXmlParser()).parse(activity);
        Config.parser.getPreferences().setPreferencesBundle(activity.getIntent().getExtras());
        Config.parser.getPreferences().copyIntoIntentExtras(activity);
    }
    
    public static boolean isInitialized() {
        return Config.parser != null;
    }
    
    public static boolean isUrlExternallyWhiteListed(final String s) {
        if (Config.parser == null) {
            Log.e("Config", "Config was not initialised. Did you forget to Config.init(this)?");
            return false;
        }
        return Config.parser.getExternalWhitelist().isUrlWhiteListed(s);
    }
    
    public static boolean isUrlWhiteListed(final String s) {
        if (Config.parser == null) {
            Log.e("Config", "Config was not initialised. Did you forget to Config.init(this)?");
            return false;
        }
        return Config.parser.getInternalWhitelist().isUrlWhiteListed(s);
    }
}
