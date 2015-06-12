// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient$Info;
import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import java.io.IOException;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

class GooglePlayServicesAdapter
{
    private static final String LOG_TAG;
    
    static {
        LOG_TAG = GooglePlayServicesAdapter.class.getSimpleName();
    }
    
    protected AdvertisingIdClient createAdvertisingIdClient() {
        return new AdvertisingIdClient();
    }
    
    public GooglePlayServices$AdvertisingInfo getAdvertisingIdentifierInfo() {
        final Context applicationContext = InternalAdRegistration.getInstance().getApplicationContext();
        try {
            final AdvertisingIdClient$Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(applicationContext);
            Log.v(GooglePlayServicesAdapter.LOG_TAG, "The Google Play Services Advertising Identifier was successfully retrieved.");
            return new GooglePlayServices$AdvertisingInfo().setAdvertisingIdentifier(advertisingIdInfo.getId()).setLimitAdTrackingEnabled(advertisingIdInfo.isLimitAdTrackingEnabled());
        }
        catch (IllegalStateException ex) {
            Log.e(GooglePlayServicesAdapter.LOG_TAG, "The Google Play Services Advertising Id API was called from a non-background thread.");
            return new GooglePlayServices$AdvertisingInfo();
        }
        catch (IOException ex2) {
            Log.e(GooglePlayServicesAdapter.LOG_TAG, "Retrieving the Google Play Services Advertising Identifier caused an IOException.");
            return new GooglePlayServices$AdvertisingInfo();
        }
        catch (GooglePlayServicesNotAvailableException ex3) {
            Log.v(GooglePlayServicesAdapter.LOG_TAG, "Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesNotAvailableException.");
            return GooglePlayServices$AdvertisingInfo.createNotAvailable();
        }
        catch (GooglePlayServicesRepairableException ex4) {
            Log.v(GooglePlayServicesAdapter.LOG_TAG, "Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesRepairableException.");
            return new GooglePlayServices$AdvertisingInfo();
        }
    }
}
