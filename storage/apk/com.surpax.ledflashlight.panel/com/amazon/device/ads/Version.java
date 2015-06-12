// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class Version
{
    private static String buildVersion;
    private static String devBuild;
    private static String prefixVersion;
    private static String sdkVersion;
    
    static {
        Version.buildVersion = "5.4.78";
        Version.prefixVersion = "amznAdSDK-android-";
        Version.sdkVersion = null;
        Version.devBuild = "(DEV)";
    }
    
    public static String getRawSDKVersion() {
        String str = Version.buildVersion;
        if (str == null || str.equals("")) {
            str = Version.devBuild;
        }
        else if (str.endsWith("x")) {
            return str + Version.devBuild;
        }
        return str;
    }
    
    public static String getSDKVersion() {
        if (Version.sdkVersion == null) {
            Version.sdkVersion = Version.prefixVersion + getRawSDKVersion();
        }
        return Version.sdkVersion;
    }
    
    protected static void setSDKVersion(final String sdkVersion) {
        Version.sdkVersion = sdkVersion;
    }
}
