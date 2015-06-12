// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

class AdRequest$LOISlot
{
    static final AAXParameter[] PARAMETERS;
    private final AdData adData;
    private final AdRequest$JSONObjectBuilder jsonObjectBuilder;
    private final AdTargetingOptions opt;
    
    static {
        PARAMETERS = new AAXParameter[] { AAXParameter.SIZE, AAXParameter.PAGE_TYPE, AAXParameter.SLOT, AAXParameter.SLOT_POSITION, AAXParameter.MAX_SIZE, AAXParameter.SLOT_ID, AAXParameter.FLOOR_PRICE };
    }
    
    AdRequest$LOISlot(final AdData adData, final AdTargetingOptions opt, final AdRequest adRequest) {
        this.adData = adData;
        this.opt = opt;
        final HashMap copyOfAdvancedOptions = this.opt.getCopyOfAdvancedOptions();
        this.jsonObjectBuilder = new AdRequest$JSONObjectBuilder().setAAXParameters(AdRequest$LOISlot.PARAMETERS).setAdvancedOptions(copyOfAdvancedOptions).setParameterData(new AAXParameter$ParameterData().setAdvancedOptions(copyOfAdvancedOptions).setLOISlot(this).setAdRequest(adRequest));
    }
    
    AdData getAdData() {
        return this.adData;
    }
    
    AdTargetingOptions getAdTargetingOptions() {
        return this.opt;
    }
    
    JSONObject getJSON() {
        this.jsonObjectBuilder.build();
        return this.jsonObjectBuilder.getJSON();
    }
}
