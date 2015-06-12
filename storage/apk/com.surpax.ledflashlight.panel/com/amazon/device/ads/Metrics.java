// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class Metrics
{
    private static final String LOG_TAG;
    private static Metrics instance;
    private MetricsCollector metricsCollector;
    
    static {
        LOG_TAG = Metrics.class.getSimpleName();
        Metrics.instance = new Metrics();
    }
    
    private Metrics() {
        this.metricsCollector = new MetricsCollector();
    }
    
    public static Metrics getInstance() {
        return Metrics.instance;
    }
    
    protected static void reset() {
        Metrics.instance = new Metrics();
    }
    
    private void sendMetrics(final WebRequest webRequest) {
        ThreadUtils.executeRunnable(new Runnable() {
            @Override
            public void run() {
                try {
                    webRequest.makeCall();
                }
                catch (WebRequest$WebRequestException ex) {
                    switch (ex.getStatus()) {
                        default: {}
                        case INVALID_CLIENT_PROTOCOL: {
                            Log.e(Metrics.LOG_TAG, "Unable to submit metrics for ad due to an Invalid Client Protocol, msg: %s", ex.getMessage());
                        }
                        case NETWORK_FAILURE: {
                            Log.e(Metrics.LOG_TAG, "Unable to submit metrics for ad due to Network Failure, msg: %s", ex.getMessage());
                        }
                        case MALFORMED_URL: {
                            Log.e(Metrics.LOG_TAG, "Unable to submit metrics for ad due to a Malformed Pixel URL, msg: %s", ex.getMessage());
                        }
                        case UNSUPPORTED_ENCODING: {
                            Log.e(Metrics.LOG_TAG, "Unable to submit metrics for ad because of unsupported character encoding, msg: %s", ex.getMessage());
                        }
                    }
                }
            }
        });
    }
    
    protected static void setInstance(final Metrics instance) {
        Metrics.instance = instance;
    }
    
    public MetricsCollector getMetricsCollector() {
        return this.metricsCollector;
    }
    
    public void submitAndResetMetrics(final AdData adData) {
        final AdMetrics adMetrics = new AdMetrics(adData);
        if (adMetrics.canSubmit()) {
            final MetricsCollector metricsCollector = this.metricsCollector;
            this.metricsCollector = new MetricsCollector();
            adMetrics.addGlobalMetrics(metricsCollector);
            this.sendMetrics(adMetrics.getAaxWebRequestAndResetAdMetrics());
            return;
        }
        adData.resetMetricsCollector();
    }
}
