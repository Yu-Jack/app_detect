// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;
import org.json.JSONObject;

class AAXParameter$DeviceInfoParameter extends AAXParameter$JSONObjectParameter
{
    AAXParameter$DeviceInfoParameter() {
        super("dinfo", "debug.dinfo");
    }
    
    @Override
    protected JSONObject getDerivedValue(final AAXParameter$ParameterData aaxParameter$ParameterData) {
        return InternalAdRegistration.getInstance().getDeviceInfo().toJsonObject(aaxParameter$ParameterData.adRequest.getOrientation());
    }
}
