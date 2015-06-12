// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Set;

public enum AdData$AAXCreative
{
    HTML("HTML", 0, 1007), 
    INTERSTITIAL("INTERSTITIAL", 2, 1008), 
    MRAID1("MRAID1", 1, 1016);
    
    private final int id;
    
    private AdData$AAXCreative(final String name, final int ordinal, final int id) {
        this.id = id;
    }
    
    static AdData$AAXCreative getCreative(final int n) {
        switch (n) {
            default: {
                return null;
            }
            case 1007: {
                return AdData$AAXCreative.HTML;
            }
            case 1016: {
                return AdData$AAXCreative.MRAID1;
            }
            case 1008: {
                return AdData$AAXCreative.INTERSTITIAL;
            }
        }
    }
    
    static AdData$AAXCreative getTopCreative(final Set set) {
        AdData$AAXCreative mraid1;
        if (set.contains(AdData$AAXCreative.MRAID1)) {
            mraid1 = AdData$AAXCreative.MRAID1;
        }
        else {
            final boolean contains = set.contains(AdData$AAXCreative.HTML);
            mraid1 = null;
            if (contains) {
                return AdData$AAXCreative.HTML;
            }
        }
        return mraid1;
    }
    
    public final int getId() {
        return this.id;
    }
}
