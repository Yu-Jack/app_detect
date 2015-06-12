// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Vector;

class MetricsCollector
{
    private String adTypeMetricTag;
    protected Vector metricHits;
    
    public MetricsCollector() {
        this.metricHits = new Vector(60);
    }
    
    public String getAdTypeMetricTag() {
        return this.adTypeMetricTag;
    }
    
    public Vector getMetricHits() {
        return this.metricHits;
    }
    
    public void incrementMetric(final Metrics$MetricType metrics$MetricType) {
        this.metricHits.add(new MetricsCollector$MetricHitIncrement(metrics$MetricType, 1));
    }
    
    public boolean isMetricsCollectorEmpty() {
        return this.metricHits.isEmpty();
    }
    
    public void publishMetricInMilliseconds(final Metrics$MetricType metrics$MetricType, final long n) {
        this.metricHits.add(new MetricsCollector$MetricHitTotalTime(metrics$MetricType, n));
    }
    
    public void publishMetricInMillisecondsFromNanoseconds(final Metrics$MetricType metrics$MetricType, final long n) {
        this.publishMetricInMilliseconds(metrics$MetricType, Utils.convertToMillisecondsFromNanoseconds(n));
    }
    
    public void setAdType(final AdProperties$AdType adProperties$AdType) {
        this.adTypeMetricTag = adProperties$AdType.getAdTypeMetricTag();
    }
    
    public void setMetricString(final Metrics$MetricType metrics$MetricType, final String s) {
        this.metricHits.add(new MetricsCollector$MetricHitString(metrics$MetricType, s));
    }
    
    public void startMetric(final Metrics$MetricType metrics$MetricType) {
        this.startMetricInMillisecondsFromNanoseconds(metrics$MetricType, System.nanoTime());
    }
    
    public void startMetricInMillisecondsFromNanoseconds(final Metrics$MetricType metrics$MetricType, final long n) {
        this.metricHits.add(new MetricsCollector$MetricHitStartTime(metrics$MetricType, Utils.convertToMillisecondsFromNanoseconds(n)));
    }
    
    public void stopMetric(final Metrics$MetricType metrics$MetricType) {
        this.stopMetricInMillisecondsFromNanoseconds(metrics$MetricType, System.nanoTime());
    }
    
    public void stopMetricInMillisecondsFromNanoseconds(final Metrics$MetricType metrics$MetricType, final long n) {
        this.metricHits.add(new MetricsCollector$MetricHitStopTime(metrics$MetricType, Utils.convertToMillisecondsFromNanoseconds(n)));
    }
}
