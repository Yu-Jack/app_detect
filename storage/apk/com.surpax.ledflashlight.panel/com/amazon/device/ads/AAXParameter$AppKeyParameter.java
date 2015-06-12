// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class AAXParameter$AppKeyParameter extends AAXParameter$StringParameter
{
    AAXParameter$AppKeyParameter() {
        super("appId", "debug.appid");
    }
    
    @Override
    protected String getDerivedValue(final AAXParameter$ParameterData aaxParameter$ParameterData) {
        return InternalAdRegistration.getInstance().getRegistrationInfo().getAppKey();
    }
}
