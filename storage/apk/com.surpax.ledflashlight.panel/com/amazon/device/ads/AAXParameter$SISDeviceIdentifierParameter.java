// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;

class AAXParameter$SISDeviceIdentifierParameter extends AAXParameter$StringParameter
{
    AAXParameter$SISDeviceIdentifierParameter() {
        super("ad-id", "debug.adid");
    }
    
    @Override
    protected String getDerivedValue(final AAXParameter$ParameterData aaxParameter$ParameterData) {
        return aaxParameter$ParameterData.adRequest.getAdvertisingIdentifierInfo().getSISDeviceIdentifier();
    }
}
