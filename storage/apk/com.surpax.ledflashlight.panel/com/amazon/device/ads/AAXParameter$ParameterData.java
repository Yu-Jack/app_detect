// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;

class AAXParameter$ParameterData
{
    private AdRequest adRequest;
    private Map advancedOptions;
    private AdRequest$LOISlot loiSlot;
    
    AAXParameter$ParameterData setAdRequest(final AdRequest adRequest) {
        this.adRequest = adRequest;
        return this;
    }
    
    AAXParameter$ParameterData setAdvancedOptions(final Map advancedOptions) {
        this.advancedOptions = advancedOptions;
        return this;
    }
    
    AAXParameter$ParameterData setLOISlot(final AdRequest$LOISlot loiSlot) {
        this.loiSlot = loiSlot;
        return this;
    }
}
