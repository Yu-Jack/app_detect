// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;

class AAXParameter$SHA1UDIDParameter extends AAXParameter$StringParameter
{
    AAXParameter$SHA1UDIDParameter() {
        super("sha1_udid", "debug.sha1udid");
    }
    
    @Override
    protected String getDerivedValue(final AAXParameter$ParameterData aaxParameter$ParameterData) {
        if (!aaxParameter$ParameterData.adRequest.getAdvertisingIdentifierInfo().hasAdvertisingIdentifier()) {
            return InternalAdRegistration.getInstance().getDeviceInfo().getUdidSha1();
        }
        return null;
    }
}
