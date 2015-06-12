// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;

class AAXParameter$AdvertisingIdentifierParameter extends AAXParameter$StringParameter
{
    AAXParameter$AdvertisingIdentifierParameter() {
        super("idfa", "debug.idfa");
    }
    
    @Override
    protected String getDerivedValue(final AAXParameter$ParameterData aaxParameter$ParameterData) {
        if (aaxParameter$ParameterData.adRequest.getAdvertisingIdentifierInfo().hasAdvertisingIdentifier()) {
            return aaxParameter$ParameterData.adRequest.getAdvertisingIdentifierInfo().getAdvertisingIdentifier();
        }
        return null;
    }
}
