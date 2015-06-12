// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import org.json.JSONObject;

class SISGenerateDIDRequest extends SISDeviceRequest
{
    private static final Metrics$MetricType CALL_METRIC_TYPE;
    private static final String LOG_TAG = "SISGenerateDIDRequest";
    private static final String PATH = "/generate_did";
    
    static {
        CALL_METRIC_TYPE = Metrics$MetricType.SIS_LATENCY_REGISTER;
    }
    
    public SISGenerateDIDRequest() {
        this.setCallMetricType(SISGenerateDIDRequest.CALL_METRIC_TYPE);
        this.setLogTag("SISGenerateDIDRequest");
        this.setPath("/generate_did");
    }
    
    @Override
    public void onResponseReceived(final JSONObject jsonObject) {
        final String stringFromJSON = JSONUtils.getStringFromJSON(jsonObject, "adId", "");
        if (stringFromJSON.length() > 0) {
            InternalAdRegistration.getInstance().getRegistrationInfo().putAdId(stringFromJSON, this.getAdvertisingIdentifierInfo());
        }
    }
}
