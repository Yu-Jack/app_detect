// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import org.json.JSONObject;

class SISUpdateDeviceInfoRequest extends SISDeviceRequest
{
    private static final Metrics$MetricType CALL_METRIC_TYPE;
    private static final String LOG_TAG = "SISUpdateDeviceInfoRequest";
    private static final String PATH = "/update_dev_info";
    
    static {
        CALL_METRIC_TYPE = Metrics$MetricType.SIS_LATENCY_UPDATE_DEVICE_INFO;
    }
    
    public SISUpdateDeviceInfoRequest() {
        this.setCallMetricType(SISUpdateDeviceInfoRequest.CALL_METRIC_TYPE);
        this.setLogTag("SISUpdateDeviceInfoRequest");
        this.setPath("/update_dev_info");
    }
    
    @Override
    public WebRequest$QueryStringParameters getQueryParameters() {
        final String debugPropertyAsString = DebugProperties.getDebugPropertyAsString("debug.adid", this.getAdvertisingIdentifierInfo().getSISDeviceIdentifier());
        final WebRequest$QueryStringParameters queryParameters = super.getQueryParameters();
        if (!Utils.isNullOrEmpty(debugPropertyAsString)) {
            queryParameters.putUrlEncoded("adId", debugPropertyAsString);
        }
        return queryParameters;
    }
    
    @Override
    public void onResponseReceived(final JSONObject jsonObject) {
        final String stringFromJSON = JSONUtils.getStringFromJSON(jsonObject, "adId", "");
        if (JSONUtils.getBooleanFromJSON(jsonObject, "idChanged", false)) {
            Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics$MetricType.SIS_COUNTER_IDENTIFIED_DEVICE_CHANGED);
        }
        if (stringFromJSON.length() > 0) {
            InternalAdRegistration.getInstance().getRegistrationInfo().putAdId(stringFromJSON, this.getAdvertisingIdentifierInfo());
        }
    }
}
