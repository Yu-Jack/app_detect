// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class MetricsCollector$MetricHitTotalTime extends MetricsCollector$MetricHit
{
    public final long totalTime;
    
    public MetricsCollector$MetricHitTotalTime(final Metrics$MetricType metrics$MetricType, final long totalTime) {
        super(metrics$MetricType);
        this.totalTime = totalTime;
    }
}
