// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class RegistrationInfo
{
    private static final String ADID_ORIGIN_PREF_NAME = "amzn-ad-id-origin";
    private static final String ADID_PREF_NAME = "amzn-ad-id";
    private static final String NEW_SIS_DID_REQUESTED_SETTING = "newSISDIDRequested";
    private static final String NON_ADVERTISING_IDENTIFIER_ORIGIN = "non-advertising-identifier";
    private static final String THIRD_PARTY_APP_NAME = "app";
    private String appKey;
    private String appName;
    
    public RegistrationInfo() {
        this.appName = "app";
    }
    
    public static boolean isAdIdCurrent(final AdvertisingIdentifier$Info advertisingIdentifier$Info) {
        boolean adIdOriginatedFromNonAdvertisingIdentifier = isAdIdOriginatedFromNonAdvertisingIdentifier();
        if (advertisingIdentifier$Info.hasAdvertisingIdentifier()) {
            if (!adIdOriginatedFromNonAdvertisingIdentifier) {
                return advertisingIdentifier$Info.getAdvertisingIdentifier().equals(Settings.getInstance().getString("amzn-ad-id-origin", null));
            }
            adIdOriginatedFromNonAdvertisingIdentifier = false;
        }
        return adIdOriginatedFromNonAdvertisingIdentifier;
    }
    
    public static boolean isAdIdOriginatedFromNonAdvertisingIdentifier() {
        final String string = Settings.getInstance().getString("amzn-ad-id-origin", null);
        return string == null || "non-advertising-identifier".equals(string);
    }
    
    protected static void setOrigin(final AdvertisingIdentifier$Info advertisingIdentifier$Info) {
        if (advertisingIdentifier$Info.hasAdvertisingIdentifier()) {
            Settings.getInstance().putStringWithNoFlush("amzn-ad-id-origin", advertisingIdentifier$Info.getAdvertisingIdentifier());
            return;
        }
        Settings.getInstance().putStringWithNoFlush("amzn-ad-id-origin", "non-advertising-identifier");
    }
    
    public String getAdId() {
        return DebugProperties.getDebugPropertyAsString("debug.adid", Settings.getInstance().getString("amzn-ad-id", null));
    }
    
    public String getAppKey() {
        return DebugProperties.getDebugPropertyAsString("debug.appid", this.appKey);
    }
    
    public String getAppName() {
        return this.appName;
    }
    
    public boolean hasAdId() {
        return this.getAdId() != null;
    }
    
    public boolean isRegisteredWithSIS() {
        return !Utils.isNullOrEmpty(this.getAdId());
    }
    
    public void putAdId(final String s, final AdvertisingIdentifier$Info origin) {
        final Settings instance = Settings.getInstance();
        instance.putStringWithNoFlush("amzn-ad-id", s);
        setOrigin(origin);
        instance.putBooleanWithNoFlush("newSISDIDRequested", false);
        instance.flush();
    }
    
    public void putAppKey(final String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("Application Key must not be null or empty.");
        }
        this.appKey = Utils.getURLEncodedString(s);
    }
    
    public void putAppName(final String s) {
        this.appName = Utils.getURLEncodedString(s);
    }
    
    public void requestNewSISDeviceIdentifier() {
        Settings.getInstance().putBoolean("newSISDIDRequested", true);
    }
    
    public boolean shouldGetNewSISDeviceIdentifer() {
        return Settings.getInstance().getBoolean("newSISDIDRequested", false);
    }
    
    public boolean shouldGetNewSISRegistration() {
        return !this.isRegisteredWithSIS();
    }
}
