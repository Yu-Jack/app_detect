// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

public enum AdProperties$AdType
{
    IMAGE_BANNER("IMAGE_BANNER", 0, "Image Banner"), 
    INTERSTITIAL("INTERSTITIAL", 3, "Interstitial", "i"), 
    MRAID_1("MRAID_1", 1, "MRAID 1.0"), 
    MRAID_2("MRAID_2", 2, "MRAID 2.0");
    
    private final String adTypeMetricTag;
    private final String type;
    
    private AdProperties$AdType(final String s, final int n, final String s2) {
        this(s, n, s2, null);
    }
    
    private AdProperties$AdType(final String name, final int ordinal, final String type, final String adTypeMetricTag) {
        this.type = type;
        this.adTypeMetricTag = adTypeMetricTag;
    }
    
    final String getAdTypeMetricTag() {
        return this.adTypeMetricTag;
    }
    
    @Override
    public final String toString() {
        return this.type;
    }
}
