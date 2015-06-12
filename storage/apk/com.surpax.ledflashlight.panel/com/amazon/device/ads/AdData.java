// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Set;

class AdData
{
    public static final int CAN_EXPAND1_CT = 1003;
    public static final int CAN_EXPAND2_CT = 1004;
    public static final int CAN_PLAY_AUDIO1_CT = 1001;
    public static final int CAN_PLAY_AUDIO2_CT = 1002;
    public static final int CAN_PLAY_VIDEO_CT = 1014;
    public static final int HTML_CT = 1007;
    public static final int INTERSTITIAL_CT = 1008;
    public static final int MRAID1_CT = 1016;
    public static final int MRAID2_CT = 1017;
    private String connectionType;
    private String creative;
    private Set creativeTypes;
    private long expirationTimeMs;
    private boolean fetched;
    private int height;
    private String impPixelUrl;
    private String instrPixelUrl;
    private boolean isRendering;
    private String maxSize;
    private MetricsCollector metricsCollector;
    private AdProperties properties;
    private final AdSize requestedAdSize;
    private int screenHeight;
    private int screenWidth;
    private int slotId;
    private int width;
    
    public AdData(final AdSize requestedAdSize) {
        this.height = 0;
        this.width = 0;
        this.screenHeight = 0;
        this.screenWidth = 0;
        this.expirationTimeMs = -1L;
        this.requestedAdSize = requestedAdSize;
        this.metricsCollector = new MetricsCollector();
    }
    
    public String getConnectionType() {
        return this.connectionType;
    }
    
    protected String getCreative() {
        return this.creative;
    }
    
    protected Set getCreativeTypes() {
        return this.creativeTypes;
    }
    
    protected int getHeight() {
        return this.height;
    }
    
    protected String getImpressionPixelUrl() {
        return this.impPixelUrl;
    }
    
    protected String getInstrumentationPixelUrl() {
        return this.instrPixelUrl;
    }
    
    public boolean getIsFetched() {
        return this.fetched;
    }
    
    protected boolean getIsRendering() {
        return this.isRendering;
    }
    
    public String getMaxSize() {
        return this.maxSize;
    }
    
    public MetricsCollector getMetricsCollector() {
        return this.metricsCollector;
    }
    
    protected AdProperties getProperties() {
        return this.properties;
    }
    
    protected AdSize getRequestedAdSize() {
        return this.requestedAdSize;
    }
    
    protected int getScreenHeight() {
        return this.screenHeight;
    }
    
    protected int getScreenWidth() {
        return this.screenWidth;
    }
    
    public int getSlotId() {
        return this.slotId;
    }
    
    protected int getWidth() {
        return this.width;
    }
    
    public boolean isExpired() {
        return this.expirationTimeMs >= 0L && System.currentTimeMillis() > this.expirationTimeMs;
    }
    
    public void resetMetricsCollector() {
        this.metricsCollector = new MetricsCollector();
    }
    
    public void setConnectionType(final String connectionType) {
        this.connectionType = connectionType;
    }
    
    protected void setCreative(final String creative) {
        this.creative = creative;
    }
    
    protected void setCreativeTypes(final Set creativeTypes) {
        this.creativeTypes = creativeTypes;
    }
    
    protected void setExpirationTimeMillis(final long expirationTimeMs) {
        this.expirationTimeMs = expirationTimeMs;
    }
    
    public void setFetched(final boolean fetched) {
        this.fetched = fetched;
    }
    
    protected void setHeight(final int height) {
        this.height = height;
    }
    
    protected void setImpressionPixelUrl(final String impPixelUrl) {
        this.impPixelUrl = impPixelUrl;
    }
    
    protected void setInstrumentationPixelUrl(final String instrPixelUrl) {
        this.instrPixelUrl = instrPixelUrl;
    }
    
    protected void setIsRendering(final boolean isRendering) {
        this.isRendering = isRendering;
    }
    
    public void setMaxSize(final String maxSize) {
        this.maxSize = maxSize;
    }
    
    protected void setProperties(final AdProperties properties) {
        this.properties = properties;
    }
    
    protected void setScreenHeight(final int screenHeight) {
        this.screenHeight = screenHeight;
    }
    
    protected void setScreenWidth(final int screenWidth) {
        this.screenWidth = screenWidth;
    }
    
    public void setSlotId(final int slotId) {
        this.slotId = slotId;
    }
    
    protected void setWidth(final int width) {
        this.width = width;
    }
}
