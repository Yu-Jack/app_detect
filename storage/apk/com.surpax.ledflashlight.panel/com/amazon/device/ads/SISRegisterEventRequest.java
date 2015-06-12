// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import org.json.JSONObject;
import java.util.HashMap;
import org.json.JSONArray;

class SISRegisterEventRequest implements SISRequest
{
    private static final Metrics$MetricType CALL_METRIC_TYPE;
    private static final String LOG_TAG = "SISRegisterEventRequest";
    private static final String PATH = "/register_event";
    private final AdvertisingIdentifier$Info advertisingIdentifierInfo;
    private final JSONArray appEvents;
    
    static {
        CALL_METRIC_TYPE = Metrics$MetricType.SIS_LATENCY_REGISTER_EVENT;
    }
    
    public SISRegisterEventRequest(final AdvertisingIdentifier$Info advertisingIdentifierInfo, final JSONArray appEvents) {
        this.advertisingIdentifierInfo = advertisingIdentifierInfo;
        this.appEvents = appEvents;
    }
    
    @Override
    public Metrics$MetricType getCallMetricType() {
        return SISRegisterEventRequest.CALL_METRIC_TYPE;
    }
    
    @Override
    public String getLogTag() {
        return "SISRegisterEventRequest";
    }
    
    @Override
    public String getPath() {
        return "/register_event";
    }
    
    @Override
    public HashMap getPostParameters() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("events", this.appEvents.toString());
        return hashMap;
    }
    
    @Override
    public WebRequest$QueryStringParameters getQueryParameters() {
        final WebRequest$QueryStringParameters webRequest$QueryStringParameters = new WebRequest$QueryStringParameters();
        webRequest$QueryStringParameters.putUrlEncoded("adId", this.advertisingIdentifierInfo.getSISDeviceIdentifier());
        webRequest$QueryStringParameters.putUrlEncoded("dt", DeviceInfo.getDeviceType());
        final RegistrationInfo registrationInfo = InternalAdRegistration.getInstance().getRegistrationInfo();
        webRequest$QueryStringParameters.putUrlEncoded("app", registrationInfo.getAppName());
        webRequest$QueryStringParameters.putUrlEncoded("appId", registrationInfo.getAppKey());
        webRequest$QueryStringParameters.putUrlEncoded("aud", Configuration.getInstance().getString(Configuration$ConfigOption.SIS_DOMAIN));
        return webRequest$QueryStringParameters;
    }
    
    @Override
    public void onResponseReceived(final JSONObject jsonObject) {
        final int integerFromJSON = JSONUtils.getIntegerFromJSON(jsonObject, "rcode", 0);
        if (integerFromJSON == 1) {
            Log.d("SISRegisterEventRequest", "Application events registered successfully.");
            AppEventRegistrationHandler.getInstance().onAppEventsRegistered();
            return;
        }
        Log.d("SISRegisterEventRequest", "Application events not registered. rcode:" + integerFromJSON);
    }
}
