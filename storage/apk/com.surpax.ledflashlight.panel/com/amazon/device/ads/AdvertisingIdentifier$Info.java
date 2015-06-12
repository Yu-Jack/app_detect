// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class AdvertisingIdentifier$Info
{
    private String advertisingIdentifier;
    private boolean canDo;
    private boolean limitAdTrackingEnabled;
    private String sisDeviceIdentifier;
    
    AdvertisingIdentifier$Info() {
        this.canDo = true;
    }
    
    private AdvertisingIdentifier$Info setAdvertisingIdentifier(final String advertisingIdentifier) {
        this.advertisingIdentifier = advertisingIdentifier;
        return this;
    }
    
    private AdvertisingIdentifier$Info setCanDo(final boolean canDo) {
        this.canDo = canDo;
        return this;
    }
    
    private AdvertisingIdentifier$Info setLimitAdTrackingEnabled(final boolean limitAdTrackingEnabled) {
        this.limitAdTrackingEnabled = limitAdTrackingEnabled;
        return this;
    }
    
    private AdvertisingIdentifier$Info setSISDeviceIdentifier(final String sisDeviceIdentifier) {
        this.sisDeviceIdentifier = sisDeviceIdentifier;
        return this;
    }
    
    boolean canDo() {
        return this.canDo;
    }
    
    String getAdvertisingIdentifier() {
        return DebugProperties.getDebugPropertyAsString("debug.idfa", this.advertisingIdentifier);
    }
    
    String getSISDeviceIdentifier() {
        return DebugProperties.getDebugPropertyAsString("debug.adid", this.sisDeviceIdentifier);
    }
    
    boolean hasAdvertisingIdentifier() {
        return !Utils.isNullOrEmpty(this.getAdvertisingIdentifier());
    }
    
    boolean hasSISDeviceIdentifier() {
        return this.getSISDeviceIdentifier() != null;
    }
    
    boolean isLimitAdTrackingEnabled() {
        return DebugProperties.getDebugPropertyAsBoolean("debug.optOut", this.limitAdTrackingEnabled);
    }
}
