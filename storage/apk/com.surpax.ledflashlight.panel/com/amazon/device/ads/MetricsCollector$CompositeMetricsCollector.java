// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Iterator;
import java.util.ArrayList;

class MetricsCollector$CompositeMetricsCollector extends MetricsCollector
{
    private final ArrayList collectors;
    
    public MetricsCollector$CompositeMetricsCollector(final ArrayList collectors) {
        this.collectors = collectors;
    }
    
    @Override
    public void incrementMetric(final Metrics$MetricType metrics$MetricType) {
        final Iterator<MetricsCollector> iterator = this.collectors.iterator();
        while (iterator.hasNext()) {
            iterator.next().incrementMetric(metrics$MetricType);
        }
    }
    
    @Override
    public void publishMetricInMilliseconds(final Metrics$MetricType metrics$MetricType, final long n) {
        final Iterator<MetricsCollector> iterator = this.collectors.iterator();
        while (iterator.hasNext()) {
            iterator.next().publishMetricInMilliseconds(metrics$MetricType, n);
        }
    }
    
    @Override
    public void publishMetricInMillisecondsFromNanoseconds(final Metrics$MetricType metrics$MetricType, final long n) {
        final Iterator<MetricsCollector> iterator = this.collectors.iterator();
        while (iterator.hasNext()) {
            iterator.next().publishMetricInMillisecondsFromNanoseconds(metrics$MetricType, n);
        }
    }
    
    @Override
    public void setMetricString(final Metrics$MetricType metrics$MetricType, final String s) {
        final Iterator<MetricsCollector> iterator = this.collectors.iterator();
        while (iterator.hasNext()) {
            iterator.next().setMetricString(metrics$MetricType, s);
        }
    }
    
    @Override
    public void startMetric(final Metrics$MetricType metrics$MetricType) {
        final Iterator<MetricsCollector> iterator = this.collectors.iterator();
        while (iterator.hasNext()) {
            iterator.next().startMetric(metrics$MetricType);
        }
    }
    
    @Override
    public void startMetricInMillisecondsFromNanoseconds(final Metrics$MetricType metrics$MetricType, final long n) {
        final Iterator<MetricsCollector> iterator = this.collectors.iterator();
        while (iterator.hasNext()) {
            iterator.next().startMetricInMillisecondsFromNanoseconds(metrics$MetricType, n);
        }
    }
    
    @Override
    public void stopMetric(final Metrics$MetricType metrics$MetricType) {
        final Iterator<MetricsCollector> iterator = this.collectors.iterator();
        while (iterator.hasNext()) {
            iterator.next().stopMetric(metrics$MetricType);
        }
    }
    
    @Override
    public void stopMetricInMillisecondsFromNanoseconds(final Metrics$MetricType metrics$MetricType, final long n) {
        final Iterator<MetricsCollector> iterator = this.collectors.iterator();
        while (iterator.hasNext()) {
            iterator.next().stopMetricInMillisecondsFromNanoseconds(metrics$MetricType, n);
        }
    }
}
