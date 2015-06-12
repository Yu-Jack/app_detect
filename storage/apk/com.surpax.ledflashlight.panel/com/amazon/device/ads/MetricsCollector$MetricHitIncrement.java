// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class MetricsCollector$MetricHitIncrement extends MetricsCollector$MetricHit
{
    public final int increment;
    
    public MetricsCollector$MetricHitIncrement(final Metrics$MetricType metrics$MetricType, final int increment) {
        super(metrics$MetricType);
        this.increment = increment;
    }
}
