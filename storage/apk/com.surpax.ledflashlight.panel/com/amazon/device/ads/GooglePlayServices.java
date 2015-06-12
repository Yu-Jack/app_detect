// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class GooglePlayServices
{
    private static final String GPS_AVAILABLE_SETTING = "gps-available";
    private static final String LOG_TAG;
    
    static {
        LOG_TAG = GooglePlayServices.class.getSimpleName();
    }
    
    private boolean isGPSAvailable() {
        return Settings.getInstance().getBoolean("gps-available", true);
    }
    
    private boolean isGPSAvailableSet() {
        return Settings.getInstance().containsKey("gps-available");
    }
    
    private void setGooglePlayServicesAvailable(final boolean b) {
        Settings.getInstance().putTransientBoolean("gps-available", b);
    }
    
    protected GooglePlayServicesAdapter createGooglePlayServicesAdapter() {
        return new GooglePlayServicesAdapter();
    }
    
    public GooglePlayServices$AdvertisingInfo getAdvertisingIdentifierInfo() {
        if (!this.isGPSAvailable()) {
            Log.v(GooglePlayServices.LOG_TAG, "The Google Play Services Advertising Identifier feature is not available.");
            return GooglePlayServices$AdvertisingInfo.createNotAvailable();
        }
        if (!this.isGPSAvailableSet() && !ReflectionUtils.isClassAvailable("com.google.android.gms.ads.identifier.AdvertisingIdClient")) {
            Log.v(GooglePlayServices.LOG_TAG, "The Google Play Services Advertising Identifier feature is not available.");
            this.setGooglePlayServicesAvailable(false);
            return GooglePlayServices$AdvertisingInfo.createNotAvailable();
        }
        final GooglePlayServices$AdvertisingInfo advertisingIdentifierInfo = this.createGooglePlayServicesAdapter().getAdvertisingIdentifierInfo();
        this.setGooglePlayServicesAvailable(advertisingIdentifierInfo.isGPSAvailable());
        return advertisingIdentifierInfo;
    }
}
