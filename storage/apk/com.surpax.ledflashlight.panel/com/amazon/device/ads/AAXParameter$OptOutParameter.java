// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;

class AAXParameter$OptOutParameter extends AAXParameter$BooleanParameter
{
    AAXParameter$OptOutParameter() {
        super("oo", "debug.optOut");
    }
    
    @Override
    protected Boolean getDerivedValue(final AAXParameter$ParameterData aaxParameter$ParameterData) {
        if (aaxParameter$ParameterData.adRequest.getAdvertisingIdentifierInfo().hasAdvertisingIdentifier()) {
            return aaxParameter$ParameterData.adRequest.getAdvertisingIdentifierInfo().isLimitAdTrackingEnabled();
        }
        return null;
    }
}
