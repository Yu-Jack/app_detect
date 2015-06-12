// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class MetricsCollector$MetricHitStartTime extends MetricsCollector$MetricHit
{
    public final long startTime;
    
    public MetricsCollector$MetricHitStartTime(final Metrics$MetricType metrics$MetricType, final long startTime) {
        super(metrics$MetricType);
        this.startTime = startTime;
    }
}
