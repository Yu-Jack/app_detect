// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class MetricsCollector$MetricHitStopTime extends MetricsCollector$MetricHit
{
    public final long stopTime;
    
    public MetricsCollector$MetricHitStopTime(final Metrics$MetricType metrics$MetricType, final long stopTime) {
        super(metrics$MetricType);
        this.stopTime = stopTime;
    }
}
