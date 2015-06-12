// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;

class AAXParameter$MD5UDIDParameter extends AAXParameter$StringParameter
{
    AAXParameter$MD5UDIDParameter() {
        super("md5_udid", "debug.md5udid");
    }
    
    @Override
    protected String getDerivedValue(final AAXParameter$ParameterData aaxParameter$ParameterData) {
        if (!aaxParameter$ParameterData.adRequest.getAdvertisingIdentifierInfo().hasAdvertisingIdentifier()) {
            return InternalAdRegistration.getInstance().getDeviceInfo().getUdidMd5();
        }
        return null;
    }
}
