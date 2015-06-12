// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class AAXParameter$SDKVersionParameter extends AAXParameter$StringParameter
{
    AAXParameter$SDKVersionParameter() {
        super("adsdk", "debug.ver");
    }
    
    @Override
    protected String getDerivedValue(final AAXParameter$ParameterData aaxParameter$ParameterData) {
        return Version.getSDKVersion();
    }
}
