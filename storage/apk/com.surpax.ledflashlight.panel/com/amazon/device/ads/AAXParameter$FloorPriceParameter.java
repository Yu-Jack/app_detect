// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;

class AAXParameter$FloorPriceParameter extends AAXParameter$LongParameter
{
    AAXParameter$FloorPriceParameter() {
        super("ec", "debug.ec");
    }
    
    @Override
    protected Long getDerivedValue(final AAXParameter$ParameterData aaxParameter$ParameterData) {
        if (aaxParameter$ParameterData.loiSlot.getAdTargetingOptions().hasFloorPrice()) {
            return aaxParameter$ParameterData.loiSlot.getAdTargetingOptions().getFloorPrice();
        }
        return null;
    }
}
