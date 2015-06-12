// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

class SISRegistration
{
    private static final String LOG_TAG;
    protected static final long SIS_CHECKIN_INTERVAL = 86400000L;
    private static final String SIS_LAST_CHECKIN_PREF_NAME = "amzn-ad-sis-last-checkin";
    private static final ExecutorService executorService;
    
    static {
        LOG_TAG = SISRegistration.class.getSimpleName();
        executorService = Executors.newSingleThreadExecutor();
    }
    
    private void putLastSISCheckin(final long n) {
        Settings.getInstance().putLong("amzn-ad-sis-last-checkin", n);
    }
    
    protected boolean canRegister(final long n) {
        final RegistrationInfo registrationInfo = InternalAdRegistration.getInstance().getRegistrationInfo();
        if (!this.exceededCheckinInterval(n) && !registrationInfo.shouldGetNewSISDeviceIdentifer() && !registrationInfo.shouldGetNewSISRegistration()) {
            final boolean debugPropertyAsBoolean = DebugProperties.getDebugPropertyAsBoolean("debug.shouldRegisterSIS", false);
            final boolean b = false;
            if (!debugPropertyAsBoolean) {
                return b;
            }
        }
        return true;
    }
    
    protected AdvertisingIdentifier$Info createAdvertisingIdentifierInfo() {
        return new AdvertisingIdentifier().getAdvertisingIdentifierInfo();
    }
    
    protected boolean exceededCheckinInterval(final long n) {
        return n - this.getLastSISCheckin() > 86400000L;
    }
    
    protected long getLastSISCheckin() {
        return Settings.getInstance().getLong("amzn-ad-sis-last-checkin", 0L);
    }
    
    protected void register(final AdvertisingIdentifier$Info advertisingIdentifierInfo) {
        new SISRequestor(new SISRegistration$RegisterEventsSISRequestorCallback(this), new SISRequest[] { new SISGenerateDIDRequest().setAdvertisingIdentifierInfo(advertisingIdentifierInfo) }).startCallSIS();
    }
    
    public void registerApp() {
        SISRegistration.executorService.submit(new Runnable() {
            @Override
            public void run() {
                SISRegistration.this.waitForConfigurationThenBeginRegistration();
            }
        });
    }
    
    void registerAppWorker() {
        final long currentTimeMillis = System.currentTimeMillis();
        final AdvertisingIdentifier$Info advertisingIdentifierInfo = this.createAdvertisingIdentifierInfo();
        if (advertisingIdentifierInfo.canDo() && this.canRegister(currentTimeMillis)) {
            this.putLastSISCheckin(currentTimeMillis);
            if (!this.shouldUpdateDeviceInfo()) {
                this.register(advertisingIdentifierInfo);
                return;
            }
            this.updateDeviceInfo(advertisingIdentifierInfo);
        }
    }
    
    protected void registerEvents() {
        if (ThreadUtils.isOnMainThread()) {
            Log.e(SISRegistration.LOG_TAG, "Registering events must be done on a background thread.");
        }
        else {
            final AdvertisingIdentifier$Info advertisingIdentifierInfo = new AdvertisingIdentifier().getAdvertisingIdentifierInfo();
            if (advertisingIdentifierInfo.hasSISDeviceIdentifier()) {
                final JSONArray appEventsJSONArray = AppEventRegistrationHandler.getInstance().getAppEventsJSONArray();
                if (appEventsJSONArray != null) {
                    new SISRequestor(new SISRequest[] { new SISRegisterEventRequest(advertisingIdentifierInfo, appEventsJSONArray) }).startCallSIS();
                }
            }
        }
    }
    
    protected boolean shouldUpdateDeviceInfo() {
        return InternalAdRegistration.getInstance().getRegistrationInfo().isRegisteredWithSIS();
    }
    
    protected void updateDeviceInfo(final AdvertisingIdentifier$Info advertisingIdentifierInfo) {
        new SISRequestor(new SISRegistration$RegisterEventsSISRequestorCallback(this), new SISRequest[] { new SISUpdateDeviceInfoRequest().setAdvertisingIdentifierInfo(advertisingIdentifierInfo) }).startCallSIS();
    }
    
    void waitForConfigurationThenBeginRegistration() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Configuration.getInstance().queueConfigurationListener(new Configuration$ConfigurationListener() {
            @Override
            public void onConfigurationFailure() {
                Log.w(SISRegistration.LOG_TAG, "Configuration fetching failed so device registration will not proceed.");
                countDownLatch.countDown();
            }
            
            @Override
            public void onConfigurationReady() {
                atomicBoolean.set(true);
                countDownLatch.countDown();
            }
        });
        while (true) {
            try {
                countDownLatch.await();
                if (atomicBoolean.get()) {
                    this.registerAppWorker();
                }
            }
            catch (InterruptedException ex) {
                continue;
            }
            break;
        }
    }
}
