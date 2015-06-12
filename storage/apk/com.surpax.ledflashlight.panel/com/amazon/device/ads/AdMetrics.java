// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import org.json.JSONObject;

class AdMetrics
{
    public static final String LOG_TAG = "AdMetrics";
    private AdData adData;
    private MetricsCollector globalMetrics;
    
    public AdMetrics(final AdData adData) {
        this.adData = adData;
    }
    
    protected static void addMetricsToJSON(final JSONObject jsonObject, final MetricsCollector metricsCollector) {
        if (metricsCollector != null) {
            final HashMap<Metrics$MetricType, Long> hashMap = new HashMap<Metrics$MetricType, Long>();
            final HashMap<Object, Integer> hashMap2 = new HashMap<Object, Integer>();
            final String adTypeMetricTag = metricsCollector.getAdTypeMetricTag();
            String string;
            if (adTypeMetricTag != null) {
                string = adTypeMetricTag + "_";
            }
            else {
                string = adTypeMetricTag;
            }
            for (final MetricsCollector$MetricHit metricsCollector$MetricHit : metricsCollector.getMetricHits().toArray(new MetricsCollector$MetricHit[metricsCollector.getMetricHits().size()])) {
                final String aaxName = metricsCollector$MetricHit.metric.getAaxName();
                String string2;
                if (string != null && metricsCollector$MetricHit.metric.isAdTypeSpecific()) {
                    string2 = string + aaxName;
                }
                else {
                    string2 = aaxName;
                }
                if (metricsCollector$MetricHit instanceof MetricsCollector$MetricHitStartTime) {
                    hashMap.put(metricsCollector$MetricHit.metric, ((MetricsCollector$MetricHitStartTime)metricsCollector$MetricHit).startTime);
                }
                else if (metricsCollector$MetricHit instanceof MetricsCollector$MetricHitStopTime) {
                    final MetricsCollector$MetricHitStopTime metricsCollector$MetricHitStopTime = (MetricsCollector$MetricHitStopTime)metricsCollector$MetricHit;
                    final Long n = hashMap.get(metricsCollector$MetricHit.metric);
                    if (n != null) {
                        JSONUtils.put(jsonObject, string2, metricsCollector$MetricHitStopTime.stopTime - n);
                    }
                }
                else if (metricsCollector$MetricHit instanceof MetricsCollector$MetricHitTotalTime) {
                    JSONUtils.put(jsonObject, string2, ((MetricsCollector$MetricHitTotalTime)metricsCollector$MetricHit).totalTime);
                }
                else if (metricsCollector$MetricHit instanceof MetricsCollector$MetricHitIncrement) {
                    final MetricsCollector$MetricHitIncrement metricsCollector$MetricHitIncrement = (MetricsCollector$MetricHitIncrement)metricsCollector$MetricHit;
                    final Integer n2 = hashMap2.get(metricsCollector$MetricHit.metric);
                    int increment;
                    if (n2 == null) {
                        increment = metricsCollector$MetricHitIncrement.increment;
                    }
                    else {
                        increment = n2 + metricsCollector$MetricHitIncrement.increment;
                    }
                    hashMap2.put(metricsCollector$MetricHit.metric, increment);
                }
                else if (metricsCollector$MetricHit instanceof MetricsCollector$MetricHitString) {
                    JSONUtils.put(jsonObject, string2, ((MetricsCollector$MetricHitString)metricsCollector$MetricHit).text);
                }
            }
            for (final Map.Entry<Metrics$MetricType, Integer> entry : hashMap2.entrySet()) {
                String str = entry.getKey().getAaxName();
                if (string != null && entry.getKey().isAdTypeSpecific()) {
                    str = string + str;
                }
                JSONUtils.put(jsonObject, str, entry.getValue());
            }
        }
    }
    
    private String getAaxUrlAndResetAdMetrics() {
        final String string = this.adData.getInstrumentationPixelUrl() + Utils.getURLEncodedString(this.getAaxJson());
        this.adData.resetMetricsCollector();
        return string;
    }
    
    public void addGlobalMetrics(final MetricsCollector globalMetrics) {
        this.globalMetrics = globalMetrics;
    }
    
    public boolean canSubmit() {
        if (this.adData != null) {
            final String instrumentationPixelUrl = this.adData.getInstrumentationPixelUrl();
            if (instrumentationPixelUrl != null && !instrumentationPixelUrl.equals("")) {
                final String appKey = InternalAdRegistration.getInstance().getRegistrationInfo().getAppKey();
                if (appKey == null || appKey.equals("123")) {
                    Log.d("AdMetrics", "Not submitting metrics because the AppKey is either not set or set to a test key.");
                    return false;
                }
                return true;
            }
        }
        return false;
    }
    
    protected String getAaxJson() {
        final JSONObject jsonObject = new JSONObject();
        JSONUtils.put(jsonObject, "c", "msdk");
        JSONUtils.put(jsonObject, "v", Version.getRawSDKVersion());
        addMetricsToJSON(jsonObject, this.adData.getMetricsCollector());
        addMetricsToJSON(jsonObject, this.globalMetrics);
        final String string = jsonObject.toString();
        return string.substring(1, -1 + string.length());
    }
    
    public WebRequest getAaxWebRequestAndResetAdMetrics() {
        final WebRequest newWebRequest = WebRequest.createNewWebRequest();
        newWebRequest.setUrlString(this.getAaxUrlAndResetAdMetrics());
        return newWebRequest;
    }
}
