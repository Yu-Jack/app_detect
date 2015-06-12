// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class GooglePlayServices$AdvertisingInfo
{
    private String advertisingIdentifier;
    private boolean gpsAvailable;
    private boolean limitAdTrackingEnabled;
    
    protected GooglePlayServices$AdvertisingInfo() {
        this.gpsAvailable = true;
    }
    
    static GooglePlayServices$AdvertisingInfo createNotAvailable() {
        return new GooglePlayServices$AdvertisingInfo().setGPSAvailable(false);
    }
    
    private GooglePlayServices$AdvertisingInfo setGPSAvailable(final boolean gpsAvailable) {
        this.gpsAvailable = gpsAvailable;
        return this;
    }
    
    String getAdvertisingIdentifier() {
        return this.advertisingIdentifier;
    }
    
    boolean hasAdvertisingIdentifier() {
        return this.getAdvertisingIdentifier() != null;
    }
    
    boolean isGPSAvailable() {
        return this.gpsAvailable;
    }
    
    boolean isLimitAdTrackingEnabled() {
        return this.limitAdTrackingEnabled;
    }
    
    GooglePlayServices$AdvertisingInfo setAdvertisingIdentifier(final String advertisingIdentifier) {
        this.advertisingIdentifier = advertisingIdentifier;
        return this;
    }
    
    GooglePlayServices$AdvertisingInfo setLimitAdTrackingEnabled(final boolean limitAdTrackingEnabled) {
        this.limitAdTrackingEnabled = limitAdTrackingEnabled;
        return this;
    }
}
