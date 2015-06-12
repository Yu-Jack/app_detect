// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class AdvertisingIdentifier
{
    private static final String GPS_ADVERTISING_IDENTIFIER_SETTING = "gpsAdId";
    private static final String LOG_TAG;
    private static final String TRANSITION_MIGRATE = "migrate";
    private static final String TRANSITION_RESET = "reset";
    private static final String TRANSITION_REVERT = "revert";
    private static final String TRANSITION_SETTING = "adIdTransistion";
    private GooglePlayServices$AdvertisingInfo gpsAdvertisingInfo;
    private boolean shouldSetCurrentAdvertisingIdentifier;
    
    static {
        LOG_TAG = AdvertisingIdentifier.class.getSimpleName();
    }
    
    AdvertisingIdentifier() {
        this.shouldSetCurrentAdvertisingIdentifier = true;
    }
    
    private void determineTransition() {
        String transition;
        if (this.isTransitionMigrated()) {
            transition = "migrate";
        }
        else if (this.isTransitionReset()) {
            transition = "reset";
        }
        else {
            final boolean transitionReverted = this.isTransitionReverted();
            transition = null;
            if (transitionReverted) {
                transition = "revert";
            }
        }
        if (transition != null) {
            setTransition(transition);
            return;
        }
        Log.d(AdvertisingIdentifier.LOG_TAG, "No transition detected.");
    }
    
    static String getAndClearTransition() {
        final Settings instance = Settings.getInstance();
        final String string = instance.getString("adIdTransistion", null);
        instance.remove("adIdTransistion");
        return string;
    }
    
    private static String getCurrentGPSAID() {
        return Settings.getInstance().getString("gpsAdId", "");
    }
    
    private boolean hasCurrentGPSAID() {
        return !Utils.isNullOrEmpty(getCurrentGPSAID());
    }
    
    private boolean isTransitionMigrated() {
        return InternalAdRegistration.getInstance().getRegistrationInfo().hasAdId() && RegistrationInfo.isAdIdOriginatedFromNonAdvertisingIdentifier() && !this.hasCurrentGPSAID() && this.getGPSAdvertisingInfo().hasAdvertisingIdentifier();
    }
    
    private boolean isTransitionReset() {
        return this.hasCurrentGPSAID() && this.getGPSAdvertisingInfo().hasAdvertisingIdentifier() && !getCurrentGPSAID().equals(this.getGPSAdvertisingInfo().getAdvertisingIdentifier());
    }
    
    private boolean isTransitionReverted() {
        return this.hasCurrentGPSAID() && !this.getGPSAdvertisingInfo().hasAdvertisingIdentifier();
    }
    
    private static void setCurrentGPSAID(final String s) {
        Settings.getInstance().putString("gpsAdId", s);
    }
    
    private static void setTransition(final String s) {
        Log.d(AdvertisingIdentifier.LOG_TAG, "Transition: %s", s);
        Settings.getInstance().putString("adIdTransistion", s);
    }
    
    protected void fetchGooglePlayServicesAdvertisingIdentifierInfo() {
        this.gpsAdvertisingInfo = new GooglePlayServices().getAdvertisingIdentifierInfo();
    }
    
    AdvertisingIdentifier$Info getAdvertisingIdentifierInfo() {
        if (ThreadUtils.isOnMainThread()) {
            Log.e(AdvertisingIdentifier.LOG_TAG, "You must obtain the advertising indentifier information on a background thread.");
            return new AdvertisingIdentifier$Info().setCanDo(false);
        }
        this.fetchGooglePlayServicesAdvertisingIdentifierInfo();
        if (this.shouldSetCurrentAdvertisingIdentifier) {
            this.determineTransition();
        }
        final AdvertisingIdentifier$Info advertisingIdentifier$Info = new AdvertisingIdentifier$Info();
        if (this.getGPSAdvertisingInfo().hasAdvertisingIdentifier()) {
            advertisingIdentifier$Info.setAdvertisingIdentifier(this.getGPSAdvertisingInfo().getAdvertisingIdentifier());
            advertisingIdentifier$Info.setLimitAdTrackingEnabled(this.getGPSAdvertisingInfo().isLimitAdTrackingEnabled());
            if (this.shouldSetCurrentAdvertisingIdentifier) {
                setCurrentGPSAID(this.getGPSAdvertisingInfo().getAdvertisingIdentifier());
            }
        }
        final RegistrationInfo registrationInfo = InternalAdRegistration.getInstance().getRegistrationInfo();
        if (RegistrationInfo.isAdIdCurrent(advertisingIdentifier$Info)) {
            advertisingIdentifier$Info.setSISDeviceIdentifier(registrationInfo.getAdId());
            return advertisingIdentifier$Info;
        }
        registrationInfo.requestNewSISDeviceIdentifier();
        return advertisingIdentifier$Info;
    }
    
    protected GooglePlayServices$AdvertisingInfo getGPSAdvertisingInfo() {
        return this.gpsAdvertisingInfo;
    }
    
    AdvertisingIdentifier setShouldSetCurrentAdvertisingIdentifier(final boolean shouldSetCurrentAdvertisingIdentifier) {
        this.shouldSetCurrentAdvertisingIdentifier = shouldSetCurrentAdvertisingIdentifier;
        return this;
    }
}
