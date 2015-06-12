// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class AAXParameter$UserAgentParameter extends AAXParameter$StringParameter
{
    AAXParameter$UserAgentParameter() {
        super("ua", "debug.ua");
    }
    
    @Override
    protected String getDerivedValue(final AAXParameter$ParameterData aaxParameter$ParameterData) {
        return DeviceInfo.getUserAgentString();
    }
}
